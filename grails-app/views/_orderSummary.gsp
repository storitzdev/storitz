<div id="left_checkout_info" style="display: none;">
  <div style="height: 15px;"></div>
  <div class="order_summary_top header_text_hi">Order Summary</div>
  <table id="checkout_price_table" style="width: 300px; border-left: #154A99 1px solid; border-right: #154A99 1px solid;">
    <tr style="height: 15px;">
      <td class="section_header" colspan="4">&nbsp;
      </td>
    </tr>
    <tr>
      <td class="section_header" colspan="4">
        Unit size: <span id="checkout_unit_size"></span>
      </td>
    </tr>
    <tr>
      <td class="section_header" colspan="4">
        Move in date: <span id="checkout_movein_date"></span>
      </td>
    </tr>
    <tr>
      <td class="section_header" colspan="4">
        Paid through date: <span id="checkout_paid_through_date"></span>
      </td>
    </tr>
    <tr style="height: 15px;">
      <td class="section_header" colspan="4">&nbsp;
      </td>
    </tr>

    <tr style="background: #F1F8E9;">
      <th class="width: 120px;">Options</th>
      <th class="width: 60px;">Months</th>
      <th class="width: 60px;">Rent</th>
      <th class="width: 60px;">Total Rent</th>
    </tr>
    <tr style="height: 10px;">
      <td class="section_header" colspan="4">&nbsp;
      </td>
    </tr>
    <tbody id="checkout_price_body">
    </tbody>
  </table>
  <table id="checkout_price_totals" style="width: 300px;">
    <tbody id="checkout_price_totals_body">
    </tbody>
  </table>
  <div class="order_summary_bottom">
    <div class="left header_text_hi">Total Move-In Cost:</div>
    <div class="right header_text_hi_right" id="checkout_price_total"></div>
    <div style="clear: both;"></div>
  </div>
  <div style="height: 10px;"></div>
  <div id="returnLinks" class="returnLink">
    <a href="#" onclick="details_return(); return false">&laquo; Back to Details</a>&nbsp;|
    <g:link controller="home" action="index" params="[size: params.searchSize, date: params.date, address: params.address]">
      &laquo; Back to Seach Results
    </g:link>
  </div>
  <div class="returnLink">
    <g:link controller="home" action="index">
      New Search &raquo;
    </g:link>
  </div>
</div>
