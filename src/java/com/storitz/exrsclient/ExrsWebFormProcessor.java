package com.storitz.exrsclient;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import storitz.ExrsService;
import storitz.EmailService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlCheckBoxInput;
import com.gargoylesoftware.htmlunit.html.HtmlRadioButtonInput;
import com.storitz.RentalTransaction;
import com.storitz.Contact;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class ExrsWebFormProcessor {

    final WebClient webClient;
    private static final String baseUrl = ExrsService.getBaseUrl();
    private static final String reserveOrHoldAction = "/Storage/ReserveOrHold.aspx";
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
            return verifyConfirmationNumber(trans, page4);
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

    private boolean verifyConfirmationNumber(RentalTransaction trans, HtmlPage page4) {
        return false;
    }

    private HtmlPage processPageThree(RentalTransaction trans, HtmlPage page3) {
        return null;
    }

    private HtmlPage processPageTwo(RentalTransaction trans, HtmlPage page2) {
        HtmlForm htmlForm = getHtmlForm(page2,reserveOrHoldAction);

        Contact primaryContact = trans.getContactPrimary();

        //
        //Form Elements:
        //
        // The three below can use the default form values
        //Setup Reservation                 ctl00_MainContent_setupReservation   (Checked)
        //Setup Hold                        ctl00_MainContent_setupHold
        //Returning User                    ctl00_MainContent_ReturningUser
        HtmlRadioButtonInput ctl00_MainContent_setupReservation = (HtmlRadioButtonInput) page2.getElementById("ctl00_MainContent_setupReservation");
        HtmlRadioButtonInput ctl00_MainContent_setupHold        = (HtmlRadioButtonInput) page2.getElementById("ctl00_MainContent_setupHold");
        HtmlCheckBoxInput ctl00_MainContent_ReturningUser       = (HtmlCheckBoxInput) page2.getElementById("ctl00_MainContent_ReturningUser");

        ctl00_MainContent_setupReservation.setChecked(true);  // these two are mutually exclusive
        ctl00_MainContent_setupHold.setChecked(false);        // these two are mutually exclusive
        ctl00_MainContent_ReturningUser.setChecked(false);


        //First Name:                       ctl00_MainContent_FirstName
        //Last Name:                        ctl00_MainContent_LastName
        //Address:                          ctl00_MainContent_Address
        //City:                             ctl00_MainContent_City
        //Primary use (Personal):           ctl00_MainContent_UsingStorageFor_0  (Checked)
        //Primary use (Business):           ctl00_MainContent_UsingStorageFor_1
        //Zip Code:                         ctl00_MainContent_PostalCode   [5 digit only]
        //Phone:                            ctl00_MainContent_Telephone    [15 digit max]
        //Email:                            ctl00_MainContent_Email
        //Email (Confirm):                  ctl00_MainContent_ConfirmEmail
        HtmlElement ctl00_MainContent_FirstName          = page2.getElementById("ctl00_MainContent_FirstName");
        HtmlElement ctl00_MainContent_LastName           = page2.getElementById("ctl00_MainContent_LastName");
        HtmlElement ctl00_MainContent_Address            = page2.getElementById("ctl00_MainContent_Address");
        HtmlElement ctl00_MainContent_City               = page2.getElementById("ctl00_MainContent_City");
        HtmlRadioButtonInput ctl00_MainContent_UsingStorageFor_0  = (HtmlRadioButtonInput) page2.getElementById("ctl00_MainContent_UsingStorageFor_0");
        HtmlRadioButtonInput ctl00_MainContent_UsingStorageFor_1  = (HtmlRadioButtonInput) page2.getElementById("ctl00_MainContent_UsingStorageFor_1");
        HtmlElement ctl00_MainContent_PostalCode         = page2.getElementById("ctl00_MainContent_PostalCode");
        HtmlElement ctl00_MainContent_Telephone          = page2.getElementById("ctl00_MainContent_Telephone");
        HtmlElement ctl00_MainContent_Email              = page2.getElementById("ctl00_MainContent_Email");
        HtmlElement ctl00_MainContent_ConfirmEmail       = page2.getElementById("ctl00_MainContent_ConfirmEmail");

        ctl00_MainContent_FirstName.setTextContent(primaryContact.getFirstName()) ;
        ctl00_MainContent_LastName.setTextContent(primaryContact.getLastName());
        ctl00_MainContent_Address.setTextContent(primaryContact.getAddress1()) ;
        ctl00_MainContent_City.setTextContent(primaryContact.getCity());

        // these two are mutually exclusive
        if (trans.getRentalUse().getValue().equalsIgnoreCase("personal")) {
            ctl00_MainContent_UsingStorageFor_0.setChecked(true);
            ctl00_MainContent_UsingStorageFor_1.setChecked(false);
        } else {
            ctl00_MainContent_UsingStorageFor_0.setChecked(false);
            ctl00_MainContent_UsingStorageFor_1.setChecked(true);
        }

        ctl00_MainContent_PostalCode.setTextContent(primaryContact.getZipcode());
        ctl00_MainContent_Telephone.setTextContent(primaryContact.getPhone());
        ctl00_MainContent_Email.setTextContent(primaryContact.getEmail());
        ctl00_MainContent_ConfirmEmail.setTextContent(primaryContact.getEmail());



        //Credit Card Number:               ctl00_MainContent_CardNumber   [16 digit max]
        //Coupon Code:                      ctl00_MainContent_CouponCode
        //Update Price:                     ctl00_MainContent_UpdatePrice  // this is a submit button!
        //Insurance:                        ctl00_MainContent_ProtectionCheckBox
        //State:                            ctl00_MainContent_State   [2 char state codes]
        //Move-in date:                     ctl00_MainContent_StartDate  [M/D/YYYY]
        //Credit Card Type:                 ctl00_MainContent_CardType [VISA,MasterCard,AmEx,Discover]
        //Credit Card Expiration (Month):   ctl00_MainContent_ExpiresMonth [01-12]
        //Credit Card Expiration (Year):    ctl00_MainContent_ExpiresYear [11-21]
        //Credit Card Verification Code:    none listed!
        HtmlElement ctl00_MainContent_CardNumber         = page2.getElementById("ctl00_MainContent_CardNumber");
        HtmlElement ctl00_MainContent_CouponCode         = page2.getElementById("ctl00_MainContent_CouponCode");
        //HtmlElement ctl00_MainContent_UpdatePrice        = page2.getElementById("ctl00_MainContent_UpdatePrice");
        HtmlCheckBoxInput ctl00_MainContent_ProtectionCheckBox = (HtmlCheckBoxInput) page2.getElementById("ctl00_MainContent_ProtectionCheckBox");
        HtmlElement ctl00_MainContent_State              = page2.getElementById("ctl00_MainContent_State");
        HtmlElement ctl00_MainContent_StartDate          = page2.getElementById("ctl00_MainContent_StartDate");
        HtmlElement ctl00_MainContent_CardType           = page2.getElementById("ctl00_MainContent_CardType");
        HtmlElement ctl00_MainContent_ExpiresMonth       = page2.getElementById("ctl00_MainContent_ExpiresMonth");
        HtmlElement ctl00_MainContent_ExpiresYear        = page2.getElementById("ctl00_MainContent_ExpiresYear");

        ctl00_MainContent_CardNumber.setTextContent(trans.getCcNum());
        ctl00_MainContent_CouponCode.setTextContent("");  // no coupon code
        //ctl00_MainContent_UpdatePrice.setTextContent(""); // no update price
        ctl00_MainContent_ProtectionCheckBox.setChecked(true);
        ctl00_MainContent_State.setTextContent(primaryContact.getState().getValue());
        ctl00_MainContent_StartDate.setTextContent(formatMoveInDate(trans.getMoveInDate()));
        ctl00_MainContent_CardType.setTextContent(resolveCCTyp(trans.getCardType().toString()));
        ctl00_MainContent_ExpiresMonth.setTextContent(resolveExpMonth(trans.getCcExpDate()));
        ctl00_MainContent_ExpiresYear.setTextContent(resolveExpYear(trans.getCcExpDate()));


        logMessage(3, "ctl00_MainContent_setupReservation: " + ctl00_MainContent_setupReservation.getTextContent());
        logMessage(3, "ctl00_MainContent_setupHold: " + ctl00_MainContent_setupHold.getTextContent());
        logMessage(3, "ctl00_MainContent_ReturningUser: " + ctl00_MainContent_ReturningUser.getTextContent());
        logMessage(3, "ctl00_MainContent_FirstName: " + ctl00_MainContent_FirstName.getTextContent());
        logMessage(3, "ctl00_MainContent_LastName: " + ctl00_MainContent_LastName.getTextContent());
        logMessage(3, "ctl00_MainContent_Address: " + ctl00_MainContent_Address.getTextContent());
        logMessage(3, "ctl00_MainContent_City: " + ctl00_MainContent_City.getTextContent());
        logMessage(3, "ctl00_MainContent_UsingStorageFor_0: " + ctl00_MainContent_UsingStorageFor_0.getTextContent());
        logMessage(3, "ctl00_MainContent_UsingStorageFor_1: " + ctl00_MainContent_UsingStorageFor_1.getTextContent());
        logMessage(3, "ctl00_MainContent_PostalCode: " + ctl00_MainContent_PostalCode.getTextContent());
        logMessage(3, "ctl00_MainContent_Telephone: " + ctl00_MainContent_Telephone.getTextContent());
        logMessage(3, "ctl00_MainContent_Email: " + ctl00_MainContent_Email.getTextContent());
        logMessage(3, "ctl00_MainContent_ConfirmEmail: " + ctl00_MainContent_ConfirmEmail.getTextContent());
        logMessage(3, "ctl00_MainContent_CardNumber: " + ctl00_MainContent_CardNumber.getTextContent());
        logMessage(3, "ctl00_MainContent_CouponCode: " + ctl00_MainContent_CouponCode.getTextContent());
        //logMessage(3,"ctl00_MainContent_UpdatePrice: " + ctl00_MainContent_UpdatePrice.getTextContent());
        logMessage(3, "ctl00_MainContent_ProtectionCheckBox: " + ctl00_MainContent_ProtectionCheckBox.getTextContent());
        logMessage(3, "ctl00_MainContent_State: " + ctl00_MainContent_State.getTextContent());
        logMessage(3, "ctl00_MainContent_StartDate: " + ctl00_MainContent_StartDate.getTextContent());
        logMessage(3, "ctl00_MainContent_CardType: " + ctl00_MainContent_CardType.getTextContent());
        logMessage(3, "ctl00_MainContent_ExpiresMonth: " + ctl00_MainContent_ExpiresMonth.getTextContent());
        logMessage(3, "ctl00_MainContent_ExpiresYear: " + ctl00_MainContent_ExpiresYear.getTextContent());


        //Submit Button:                    ctl00_MainContent_SubmitData
        HtmlElement ctl00_MainContent_SubmitData        = page2.getElementById("ctl00_MainContent_SubmitData");

        // Enable this for production only
        try {
            return ctl00_MainContent_SubmitData.click();
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
        SimpleDateFormat sdf_yy = new SimpleDateFormat ("yy");  // CC Year [11-21]
        return sdf_yy.format(expDate);
    }

    // Move-in dates have no leading zeros (i.e. 04/01/2011 becomes 4/1/2011)
    private String formatMoveInDate(Date moveInDate) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");

        String d1 = sdf1.format(moveInDate);
        String d2 = sdf2.format(moveInDate);
        String d3 = sdf3.format(moveInDate);

        if (d1.charAt(0)=='0') {
            d1 = d1.substring(1);
        }

        if (d2.charAt(0)=='0') {
            d2 = d2.substring(1);
        }

        return d1+"/"+d2+"/"+d3;
    }

    private String resolveCCTyp(String ccType) {
        if (ccType.equalsIgnoreCase("visa")) {
            return "VISA";
        }
        if (ccType.equalsIgnoreCase("master card")) {
            return "MasterCard";
        }
        if (ccType.equalsIgnoreCase("american express")) {
            return "AmEx";
        }
        if (ccType.equalsIgnoreCase("discover")) {
            return "Discover";
        }

        logMessage(0,"*** Cannot resolve credit card type: " + ccType + " ***");
        logMessage(0,"*** Returning null. ***");
        return null;
    }


    private HtmlPage processPageOne(RentalTransaction trans, HtmlPage page1) {
        String size  = trans.getDisplaySize();
        String cost  = trans.getMonthlyRate().toString();
        String promo = trans.getPromoName();

        logMessage(0,"*** SIZE =" + size + "  ***");
        logMessage(0,"*** COST =" + cost + "  ***");
        logMessage(0,"*** PROMO=" + promo + "  ***");

        String actionUrl = page1.getUrl().toString();
        HtmlForm htmlForm = getHtmlForm(page1, actionUrl);

        if (htmlForm == null) {
            return null;
        }

        HtmlElement button = getPageOneSelectButton(htmlForm, size, cost, promo);
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
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        t.printStackTrace(printWriter);
        logMessage(0,result.toString());
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

    private HtmlElement getPageOneSelectButton (HtmlForm htmlForm, String size, String cost, String offer) {
        DomNodeList<HtmlElement> domNodeList = htmlForm.getElementsByTagName("div");
        for (HtmlElement element : domNodeList) {
            String elementText = element.asText().replaceAll(" ","");
            size = size.replaceAll(" ","");
            logMessage(3,"*** AFTER ELEMENTTEXT: " + elementText);
            logMessage(3,"*** AFTER SIZE: " + size);

            if (elementText.equalsIgnoreCase(size)) {
                logMessage(3,"ELEMENT: " + element.asText());
                logMessage(3,"     P1: " + element.getParentNode().asXml().toString());
                logMessage(3,"     P2: " + element.getParentNode().getParentNode().getChildNodes().toString());

                // We know this unit is the correct size. Let's examine the remaining attributes to
                // see if it is a perfect match.
                DomNodeList<DomNode> domNodeList2 = element.getParentNode().getParentNode().getChildNodes();
                int sz = domNodeList2.size();

                DomNode buttonNode = null;
                boolean matchedRate = false;
                boolean matchedOffer = false;

                for (int i = 0; i < sz; i++) {
                    DomNode node = domNodeList2.get(i);
                    String nodeString = node.asText();

                    logMessage(3,"NODESTRING[" + i + "]: >" + nodeString + "<");

                    // try to match the cost
                    if (nodeString.contains("Internet Rate: $" + cost)) {
                        matchedRate = true;
                        continue;
                    }

                    // try to match the offer
                    if ((offer != null) && nodeString.contains(offer)) {
                        matchedOffer = true;
                        continue;
                    }
                    // If there is no promotion, the move-in cost is repeated in the promotion text
                    if (offer == null && nodeString.contains(cost)) {
                        matchedOffer = true;
                        continue;
                    }
                }

                // Found it!
                if (matchedRate && matchedOffer) {
                    buttonNode = domNodeList2.get(sz - 1);
                }

                if (buttonNode != null) {
                    String buttonId = buttonNode.getChildNodes().get(1).getAttributes().getNamedItem("id").getNodeValue();
                    logMessage(3," BUTTON: " + buttonId);
                    HtmlElement button = htmlForm.getElementById(buttonId);
                    return button;
              }

            }
        }

        logMessage(0,"*** Can not find page 1 select button. Returning null. ***");
        return null;
    }
}
