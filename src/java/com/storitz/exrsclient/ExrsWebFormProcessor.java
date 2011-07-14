package com.storitz.exrsclient;

import com.storitz.StoritzUtil;
import storitz.ExrsStorageFeedService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlCheckBoxInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.storitz.RentalTransaction;
import com.storitz.Contact;
import storitz.constants.CreditCardType;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExrsWebFormProcessor {

    final WebClient webClient;
    private static final String baseUrl = ExrsStorageFeedService.getBaseUrl();
    private static final String reserveOrHoldAction = "/Storage/ReserveOrHold.aspx";
    private static final String reserveConfirmAction = "/Storage/Reserve/Confirm.aspx";
    private StringBuffer buf = new StringBuffer(5120);

    // 0 = dump errors only
    // 1 = dump page source
    // 2 = dump page+form source
    // 3 = dump everything
    private int debug_level = 1;

    public ExrsWebFormProcessor() {
        webClient = new WebClient(BrowserVersion.FIREFOX_3_6);
        webClient.setRedirectEnabled(true);
        webClient.setJavaScriptEnabled(false); // JS is buggy, and not required for this purpose
        logMessage(3,"*** BroswerVersion: Firefox 3.6 ***");
        logMessage(3,"*** Redirect Enabled: true");
        logMessage(3,"*** Javascript Enabled: false");
    }

    public boolean processMoveIn(RentalTransaction trans) {
        try {
            String url = trans.getSite().getUrl();
            Contact contact = trans.getContactPrimary();
            logMessage(0, "*** Attempting Automatic Move-In ***");
            logMessage(0, "*** Name: " + contact.getFirstName() + " " + contact.getLastName() + " ***");
            logMessage(0, "*** URL  =" + url + "  ***");


            //////////////////////////////////////
            // PAGE 1 - Find Unit ////////////////
            //////////////////////////////////////
            HtmlPage page1 = getHtmlPage(url);
            if (page1 == null) {
                logMessage(0, "*** page1 is null ***");
                return false;
            }
            logMessage(1,"*** page1 ***");
            logMessage(1,page1.asXml().toString());


            //////////////////////////////////////
            // PAGE 2 - Give Credentials /////////
            //////////////////////////////////////
            HtmlPage page2 = processPageOne(trans, page1);
            if (page2 == null) {
                logMessage(0,"*** page2 is null ***");
                return false;
            }
            logMessage(1,"*** page2 ***");
            logMessage(1,page2.asXml().toString());


            //////////////////////////////////////
            // PAGE 3 - Chose Notifications //////
            //////////////////////////////////////
            HtmlPage page3 = processPageTwo(trans, page2);
            if (page3 == null) {
                logMessage(0, "*** page3 is null ***");
                return false;
            }
            logMessage(1,"*** page3 ***");
            logMessage(1,page3.asXml().toString());


            //////////////////////////////////////
            // PAGE 4 - Receive Confirmation /////
            //////////////////////////////////////
            HtmlPage page4 = processPageThree(trans, page3);
            if (page4 == null) {
                logMessage(0,"*** page4 is null ***");
                return false;
            }
            logMessage(1,"*** page4 ***");
            logMessage(1,page4.asXml().toString());


            //////////////////////////////////////
            // Wrap Up - Receive Confirmation # //
            //////////////////////////////////////
            String confirmationNumber = verifyConfirmationNumber(trans, page4);
            if (confirmationNumber != null) {
                logMessage(0,"Confirmation Number: " + confirmationNumber);
                trans.setIdNumber(confirmationNumber);
                return true;
            }

        } catch (Throwable t) {
            logStackTrace(t);
        }

        return false;
    }

    public String getLogBuf() {
        return buf.toString();
    }

    private void logMessage (int level, String message) {
        if (debug_level >= level) {
            buf.append(message);
            buf.append("\n");
        }
    }

    private String verifyConfirmationNumber(RentalTransaction trans, HtmlPage page4) {
        String htmlText = page4.asXml().toString();

        /* Match the confirmation message
         * HTML input comes in looking something like this:

          <div class="sub_title" style="border:0; padding:0px 12px 0px;"> 
            Confirmation Number: 
            <span style="color:#fff;font-size:12px;"> 
              5878551
            </span> 
          </div> 

         */
        Pattern p0 = Pattern.compile("^.*(Confirmation|Reservation) Number.*$",Pattern.DOTALL);
        Matcher m0 = p0.matcher(htmlText);


        /* Match the confirmation number
         * HTML input comes in looking something like this:
            s.events="event7,event12,event23,purchase"
            s.prop5="7x10"
            s.prop6="NDN-Non-Climate Down Normal"
            s.prop7="CBB - First Month Free"
            s.prop15="0"
            s.prop17="Personal"
            s.eVar1="California"
            s.state="California"
            s.products="1122;7x10|NDN-Non-Climate Down Normal|CBB - First Month Free|91.00|107.00|1122;1;91.00;event23=91.00"
            s.purchaseID="5800776"
            s.eVar7="07X10"
            s.eVar8="1122"
            s.eVar9="91"
            s.eVar12="91"
            s.eVar14="107"
            s.eVar15="91"
            s.eVar17=""
            s.eVar18="91"
         */
        Pattern p1 = Pattern.compile("^.*s.purchaseID=\"([0-9]+)\".*$",Pattern.DOTALL);
        Matcher m1 = p1.matcher(htmlText);


        if (m0.matches() && m1.matches() && m1.groupCount() > 0) {
            return m1.group(1);
        }


        return null;
    }

    private HtmlPage processPageThree(RentalTransaction trans, HtmlPage page3) {
        HtmlForm htmlForm = getHtmlForm(page3,reserveConfirmAction);
        HtmlElement ctl00_mContent_ConfirmButton = page3.getElementById("ctl00_mContent_ConfirmButton");
        try {
            return ctl00_mContent_ConfirmButton.click();
        } catch (IOException e) {
          logStackTrace(e);
        }
        return null;
    }

    private HtmlPage processPageTwo(RentalTransaction trans, HtmlPage page2) {
        HtmlForm htmlForm = getHtmlForm(page2,reserveOrHoldAction);

        if (htmlForm == null) {
            return null;
        }

        Contact primaryContact = trans.getContactPrimary();

        //
        //Form Elements:
        //
        // The three below can use the default form values
        //Setup Reservation                 ctl00_mContent_setupReservation   (Checked)
        //Setup Hold                        ctl00_mContent_setupHold
        HtmlCheckBoxInput ctl00_mContent_setupReservation = (HtmlCheckBoxInput) page2.getElementById("ctl00_mContent_setupReservation");
        HtmlCheckBoxInput ctl00_mContent_setupHold        = (HtmlCheckBoxInput) page2.getElementById("ctl00_mContent_setupHold");

        ctl00_mContent_setupReservation.setChecked(true);  // these two are mutually exclusive
        ctl00_mContent_setupHold.setChecked(false);        // these two are mutually exclusive


        //First Name:                       ctl00_mContent_FirstName
        //Last Name:                        ctl00_mContent_LastName
        //Address:                          ctl00_mContent_Address
        //City:                             ctl00_mContent_City
        //State:                            ctl00_mContent_State   [2 char state codes]
        //Primary use (Personal/Business):  ctl00_mContent_PrimaryUse
        //Zip Code:                         ctl00_mContent_PostalCode   [5 digit only]
        //Phone:                            ctl00_mContent_Telephone    [15 digit max]
        //Email:                            ctl00_mContent_Email
        //Email (Confirm):                  ctl00_mContent_ConfirmEmail
        HtmlTextInput ctl00_mContent_FirstName          = (HtmlTextInput) page2.getElementById("ctl00_mContent_FirstName");
        HtmlTextInput ctl00_mContent_LastName           = (HtmlTextInput) page2.getElementById("ctl00_mContent_LastName");
        HtmlTextInput ctl00_mContent_Address            = (HtmlTextInput) page2.getElementById("ctl00_mContent_Address");
        HtmlTextInput ctl00_mContent_City               = (HtmlTextInput) page2.getElementById("ctl00_mContent_City");
        HtmlSelect ctl00_mContent_State              = (HtmlSelect) page2.getElementById("ctl00_mContent_State");
        HtmlSelect ctl00_mContent_PrimaryUse            = (HtmlSelect) page2.getElementById("ctl00_mContent_PrimaryUse");
        HtmlTextInput ctl00_mContent_PostalCode         = (HtmlTextInput) page2.getElementById("ctl00_mContent_PostalCode");
        HtmlTextInput ctl00_mContent_Telephone          = (HtmlTextInput) page2.getElementById("ctl00_mContent_Telephone");
        HtmlTextInput ctl00_mContent_Email              = (HtmlTextInput) page2.getElementById("ctl00_mContent_Email");
        HtmlTextInput ctl00_mContent_ConfirmEmail       = (HtmlTextInput) page2.getElementById("ctl00_mContent_ConfirmEmail");

        ctl00_mContent_FirstName.setText(primaryContact.getFirstName()) ;
        ctl00_mContent_LastName.setText(primaryContact.getLastName());
        ctl00_mContent_Address.setText(primaryContact.getAddress1()) ;
        ctl00_mContent_City.setText(primaryContact.getCity());
        ctl00_mContent_State.setSelectedAttribute(primaryContact.getState().getValue().toUpperCase(), true);

        if (trans.getRentalUse().getValue().equalsIgnoreCase("personal")) {
            ctl00_mContent_PrimaryUse.setSelectedAttribute("Personal",true);
        } else {
            ctl00_mContent_PrimaryUse.setSelectedAttribute("Business",true);
        }

        ctl00_mContent_PostalCode.setText(primaryContact.getZipcode());
        ctl00_mContent_Telephone.setText(primaryContact.getPhone());
        ctl00_mContent_Email.setText(primaryContact.getEmail());
        ctl00_mContent_ConfirmEmail.setText(primaryContact.getEmail());



        //Credit Card Number:               ctl00_mContent_CardNumber   [16 digit max]
        //CCV/Verification Code:            ctl00_mContent_VerifyCard
        //Coupon Code:                      ctl00_mContent_CouponCode
        //Update Price:                     ctl00_mContent_UpdatePrice  // this is a submit button!
        //Insurance:                        ctl00_mContent_ProtectionCheckBox
        //Move-in date:                     ctl00_mContent_StartDate  [M/D/YYYY]
        //Credit Card Type:                 ctl00_mContent_CardType [VISA,MasterCard,AmEx,Discover]
        //Credit Card Expiration (Month):   ctl00_mContent_ExpiresMonth [01-12]
        //Credit Card Expiration (Year):    ctl00_mContent_ExpiresYear [11-21]
        HtmlTextInput ctl00_mContent_CardNumber         = (HtmlTextInput) page2.getElementById("ctl00_mContent_CardNumber");
        HtmlTextInput ctl00_mContent_VerifyCard         = (HtmlTextInput) page2.getElementById("ctl00_mContent_VerifyCard");
        HtmlTextInput ctl00_mContent_CouponCode         = (HtmlTextInput) page2.getElementById("ctl00_mContent_CouponCode");
        //HtmlTextInput ctl00_mContent_UpdatePrice        = (HtmlTextInput) page2.getElementById("ctl00_mContent_UpdatePrice");
        HtmlCheckBoxInput ctl00_mContent_ProtectionCheckBox = (HtmlCheckBoxInput) page2.getElementById("ctl00_mContent_ProtectionCheckBox");
        HtmlSelect ctl00_mContent_StartDate          = (HtmlSelect) page2.getElementById("ctl00_mContent_StartDate");
        HtmlSelect ctl00_mContent_CardType           = (HtmlSelect) page2.getElementById("ctl00_mContent_CardType");
        HtmlSelect ctl00_mContent_ExpiresMonth       = (HtmlSelect) page2.getElementById("ctl00_mContent_ExpiresMonth");
        HtmlSelect ctl00_mContent_ExpiresYear        = (HtmlSelect) page2.getElementById("ctl00_mContent_ExpiresYear");

        ctl00_mContent_CardNumber.setText(trans.getCcNum());
        ctl00_mContent_VerifyCard.setText(trans.getCvv2());
        ctl00_mContent_CouponCode.setText("");  // no coupon code
        //ctl00_mContent_UpdatePrice.setText(""); // no update price
        ctl00_mContent_ProtectionCheckBox.setChecked(true);
        ctl00_mContent_StartDate.setSelectedAttribute(formatMoveInDate(trans.getMoveInDate()), true);
        ctl00_mContent_CardType.setSelectedAttribute(resolveCCTyp(trans.getCardType().toString()), true);
        ctl00_mContent_ExpiresMonth.setSelectedAttribute(resolveExpMonth(trans.getCcExpDate()), true);
        ctl00_mContent_ExpiresYear.setSelectedAttribute(resolveExpYear(trans.getCcExpDate()), true);


        logMessage(3, "ctl00_mContent_setupReservation: " + ctl00_mContent_setupReservation.getTextContent());
        logMessage(3, "ctl00_mContent_setupHold: " + ctl00_mContent_setupHold.getTextContent());
        logMessage(3, "ctl00_mContent_FirstName: " + ctl00_mContent_FirstName.getTextContent());
        logMessage(3, "ctl00_mContent_LastName: " + ctl00_mContent_LastName.getTextContent());
        logMessage(3, "ctl00_mContent_Address: " + ctl00_mContent_Address.getTextContent());
        logMessage(3, "ctl00_mContent_City: " + ctl00_mContent_City.getTextContent());
        logMessage(3, "ctl00_mContent_PrimaryUse: " + ctl00_mContent_PrimaryUse.getTextContent());
        logMessage(3, "ctl00_mContent_VerifyCard: " + ctl00_mContent_VerifyCard.getTextContent());
        logMessage(3, "ctl00_mContent_PostalCode: " + ctl00_mContent_PostalCode.getTextContent());
        logMessage(3, "ctl00_mContent_Telephone: " + ctl00_mContent_Telephone.getTextContent());
        logMessage(3, "ctl00_mContent_Email: " + ctl00_mContent_Email.getTextContent());
        logMessage(3, "ctl00_mContent_ConfirmEmail: " + ctl00_mContent_ConfirmEmail.getTextContent());
        logMessage(3, "ctl00_mContent_CardNumber: " + ctl00_mContent_CardNumber.getTextContent());
        logMessage(3, "ctl00_mContent_CouponCode: " + ctl00_mContent_CouponCode.getTextContent());
        //logMessage(3,"ctl00_mContent_UpdatePrice: " + ctl00_mContent_UpdatePrice.getTextContent());
        logMessage(3, "ctl00_mContent_ProtectionCheckBox: " + ctl00_mContent_ProtectionCheckBox.getTextContent());
        logMessage(3, "ctl00_mContent_State: " + ctl00_mContent_State.getTextContent());
        logMessage(3, "ctl00_mContent_StartDate: " + ctl00_mContent_StartDate.getTextContent());
        logMessage(3, "ctl00_mContent_CardType: " + ctl00_mContent_CardType.getTextContent());
        logMessage(3, "ctl00_mContent_ExpiresMonth: " + ctl00_mContent_ExpiresMonth.getTextContent());
        logMessage(3, "ctl00_mContent_ExpiresYear: " + ctl00_mContent_ExpiresYear.getTextContent());


        //Submit Button:                    ctl00_mContent_SubmitData
        HtmlElement ctl00_mContent_SubmitData        = page2.getElementById("ctl00_mContent_SubmitData");

        // Enable this for production only
        try {
            return ctl00_mContent_SubmitData.click();
        } catch (IOException e) {
            logStackTrace(e);
        }

        return null;
    }

    private String resolveExpMonth(Date expDate) {
        SimpleDateFormat sdf_MM = new SimpleDateFormat ("MM");  // CC Month [01-12]
        return sdf_MM.format(expDate);
    }

    private String resolveExpYear(Date expDate) {
        SimpleDateFormat sdf_yyyy = new SimpleDateFormat ("yyyy");  // CC Year [2011-2021]
        return sdf_yyyy.format(expDate);
    }

    // Move-in dates have no leading zeros (i.e. 04/01/2011 becomes 4/1/2011)
    private String formatMoveInDate(Date moveInDate) {
        Date actualMoveInDate = getActualMoveInDate(moveInDate);

        SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");

        String d1 = sdf1.format(actualMoveInDate);
        String d2 = sdf2.format(actualMoveInDate);
        String d3 = sdf3.format(actualMoveInDate);

        if (d1.charAt(0)=='0') {
            d1 = d1.substring(1);
        }

        if (d2.charAt(0)=='0') {
            d2 = d2.substring(1);
        }

        return d1+"/"+d2+"/"+d3;
    }

    // JM: 2011-06-03
    // Odd factoid. The Extraspace reservation form does not list Sunday as
    // a valid move-in date! If a user requests a Sunday move-in, then subtract
    // one day and move them in on the preceding Saturday.
    //
    // Failure to do this will result in a same-day move in, since the code
    // that sets the selection option will fail, and the default move-in
    // value is same day.
    private Date getActualMoveInDate(Date moveInDate) {
        Date actualMoveInDate = moveInDate;

        Calendar cal = Calendar.getInstance();
        cal.setTime(actualMoveInDate);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            cal.add(Calendar.DATE,-1);
            actualMoveInDate = cal.getTime();
        }

        return actualMoveInDate;
    }

    private String resolveCCTyp(String ccType) {
        if (ccType.equalsIgnoreCase(CreditCardType.VISA.toString())) {
            return "VISA";
        }
        if (ccType.equalsIgnoreCase(CreditCardType.MASTERCARD.toString())) {
            return "MasterCard";
        }
        if (ccType.equalsIgnoreCase(CreditCardType.AMERICAN_EXPRESS.toString())) {
            return "AmEx";
        }
        if (ccType.equalsIgnoreCase(CreditCardType.DISCOVER.toString())) {
            return "Discover";
        }

        logMessage(0,"*** Cannot resolve credit card type: " + ccType + " ***");
        logMessage(0,"*** Returning null. ***");
        return null;
    }

    private ArrayList<String> getUnitType(RentalTransaction trans) {
        String type = trans.getUnitType().getDisplay().toString().toLowerCase();
        ArrayList<String> ret = new ArrayList<String>();

        if (type.equalsIgnoreCase("interior")) {
            ret.add("inside");
            return ret;
        }
        if (type.equalsIgnoreCase("upper")) {
            ret.add("upper");
            ret.add("elevator");
            return ret;
        }
        if (type.equalsIgnoreCase("drive up")) {
            ret.add("drive");
            return ret;
        }

        return null; // match anything
    }

    private HtmlPage processPageOne(RentalTransaction trans, HtmlPage page1) {
        String size  = trans.getDisplaySize();
        String cost  = trans.getMonthlyRate().toString();
        String promo = trans.getPromoName();
        ArrayList<String> type  = getUnitType(trans);

        logMessage(0,"*** SIZE =" + size + "  ***");
        logMessage(0,"*** COST =" + cost + "  ***");
        for (String s : type) {
            logMessage(0,"*** TYPE =" + s + " ***");
        }
        logMessage(0,"*** PROMO=" + promo + "  ***");

        String actionUrl = page1.getUrl().toString();
        HtmlForm htmlForm = getHtmlForm(page1, actionUrl);

        if (htmlForm == null) {
            return null;
        }

        HtmlElement button = getPageOneSelectButton(htmlForm, size, cost, type, promo);
        if (button == null) {
            return null;
        }

        try {
            return button.click();
       } catch (IOException e) {
            logMessage(0,e.toString());
            logStackTrace(e);
       }

       return null;
    }

    private void logStackTrace(Throwable t) {
        logMessage(0,StoritzUtil.stackTraceToString(t));
    }

    private HtmlForm getHtmlForm (HtmlPage htmlPage, String actionUrl) {
        List<HtmlForm> allForms = htmlPage.getForms();

        if (allForms == null || allForms.size() < 1) {
            logMessage(0,"*** allForms is null on page " + htmlPage.getUrl().toString() + " ***");
            return null;
        }

         for (HtmlForm form : allForms) {
            String action = form.getActionAttribute();
            String formAction = form.getActionAttribute();
            if (actionUrl.contains(formAction) || formAction.contains(actionUrl)) {
                logMessage(2,"*** FORM ***");
                logMessage(2,form.asXml().toString());

                logMessage(3,"*** FORM ACTION=" + formAction + " ***");
                logMessage(3,"*** ACTION URL=" + actionUrl + " ***");

                return form;
            }
        }

        logMessage(0,"*** Cannot find form on page " + htmlPage.getUrl().toString() + " ***");
        logMessage(0,"*** Returning null ***");
        return null;
    }

    private HtmlPage getHtmlPage(String url) {
        try {
            return webClient.getPage(baseUrl + url);
        } catch (IOException e) {
            logStackTrace(e);
        }
        return null;
    }

    // testing only
    private HtmlPage getHtmlPageNoBase(String url) {
        try {
            return webClient.getPage(url);
        } catch (IOException e) {
            logStackTrace(e);
        }
        return null;
    }


    private HtmlElement getPageOneSelectButton (HtmlForm htmlForm, String size, String cost, ArrayList<String> type, String offer) {
        DomNodeList<HtmlElement> domNodeList = htmlForm.getElementsByTagName("tr");

        for (HtmlElement element : domNodeList) {
            // Each element here is a table row. Scan for text that signifies
            // this row as the correct row for this unit, and when we find that
            // row, isolate the button
            String elementText = element.asText().replaceAll(" ","").toLowerCase();
            size = size.replaceAll(" ","").toLowerCase();
            logMessage(3,"*** AFTER ELEMENTTEXT: " + elementText);
            logMessage(3,"*** AFTER SIZE: " + size);

            if (elementText.contains(size)) {
                logMessage(3,"POSSIBLE-MATCH ELEMENT: " + element.asText());

                // We know this unit is the correct size. Let's examine the remaining attributes to
                // see if it is a perfect match.
                Iterable<DomNode> domNodeChildren = element.getChildren();
                Iterator<DomNode> domNodeIterator = domNodeChildren.iterator();

                DomNode lastNode = null; // placeholder for the button when we fid it
                DomNode buttonNode = null;
                boolean matchedRate = false;
                boolean matchedType = type == null ? true : false;
                boolean matchedOffer = false;

                while (domNodeIterator.hasNext()) {
                    DomNode node = domNodeIterator.next();
                    String nodeString = node.asText().toLowerCase();

                    logMessage(3,"NODE >" + nodeString + "<");

                    // try to match the cost
                    if (nodeString.contains("internet rate: $" + cost) || nodeString.contains("web rate: $" + cost)) {
                        matchedRate = true;
                        continue;
                    }

                    // try to match the type
                    if ((type != null) && typeMatches(nodeString,type)) {
                        matchedType = true;
                        continue;
                    }

                    // try to match the offer
                    if ((offer != null) && nodeString.contains(offer.toLowerCase())) {
                        matchedOffer = true;
                        continue;
                    }
                    // If there is no promotion, the move-in cost is repeated in the promotion text
                    if (offer == null && nodeString.contains(cost)) {
                        matchedOffer = true;
                        continue;
                    }

                    lastNode = node;
                }

                 // Found it!
                if (matchedRate && matchedType && matchedOffer) {
                    buttonNode = lastNode;
                }

                if (buttonNode != null) {
                    logMessage(3," BUTTON NODE: " + buttonNode.asXml().toString().toLowerCase());
                    String buttonId = buttonNode.getChildNodes().get(1).getChildNodes().get(1).getAttributes().getNamedItem("id").getNodeValue();
                    logMessage(3," BUTTON ID: " + buttonId);
                    HtmlElement button = htmlForm.getElementById(buttonId);
                    return button;
              }

            }
        }

        logMessage(0,"*** Can not find page 1 select button. Returning null. ***");
        return null;
    }

    private boolean typeMatches(String nodeString, ArrayList<String> type) {
        for (String t : type) {
            if (nodeString.contains(t)) {
                return true;
            }
        }
        return false;
    }


    /// TESTS ///
    public boolean testLogin1() {
        HtmlPage page1 = getHtmlPageNoBase("http://localhost/form.html");
        System.out.println("*** PAGE1 ***");
        if (page1 != null) {
            System.out.println(page1.asXml().toString());
        }
        else {
            System.out.println("PAGE1 is NULL!");
            return false;
        }

        HtmlForm htmlForm1 = getHtmlForm(page1,"/action.php");
        HtmlTextInput username = (HtmlTextInput)page1.getElementById("username");
        HtmlTextInput password = (HtmlTextInput)page1.getElementById("password");
        HtmlSelect state = (HtmlSelect)page1.getElementById("state");

        username.setText("testuname");
        password.setText("testpass");
        state.setSelectedAttribute("AR",true);

        HtmlElement button = htmlForm1.getInputByValue("Click me");
        try {
            HtmlPage page2 = button.click();
            System.out.println("*** PAGE2 ***");
            System.out.println(page2.asXml().toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }

    public boolean testLogin2() {
        HtmlPage page1 = getHtmlPageNoBase("http://localhost/form.html");
        System.out.println("*** PAGE1 ***");
        if (page1 != null) {
            System.out.println(page1.asXml().toString());
        }
        else {
            System.out.println("PAGE1 is NULL!");
            return false;
        }

        HtmlForm htmlForm1 = getHtmlForm(page1,"/action.php");
        HtmlElement username = page1.getElementById("username");
        HtmlElement password = page1.getElementById("password");
        HtmlElement state = page1.getElementById("state");

        username.setTextContent("testuname");
        password.setTextContent("testpass");
        state.setTextContent("AK");

        HtmlElement button = htmlForm1.getInputByValue("Click me");
        try {
            HtmlPage page2 = button.click();
            System.out.println("*** PAGE2 ***");
            System.out.println(page2.asXml().toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }


}
