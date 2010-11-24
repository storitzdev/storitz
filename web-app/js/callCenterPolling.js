function ajaxFormUpdate() {
  ajaxFormUpdateTimer = setTimeout("doAjaxFormUpdate()", 5000)
}

function doAjaxFormUpdate() {
  var ajaxFormNewValues = $('#rentalTransaction');

  if (ajaxFormNewValues != undefined) {
    ajaxFormNewValues = ajaxFormNewValues.serialize(true);
    var jsonValues = JSON.stringify(ajaxFormNewValues);
    var valuesUnchanged = ajaxFormOldValues == jsonValues;
    ajaxFormOldValues = jsonValues;

    if (ajaxFormDirty) {
      if (valuesUnchanged) {
        $.ajax({
          url: urlAjaxUpdate,
          type:'post',
          data: ajaxFormNewValues,
          complete:function() {
            ajaxFormDirty = false;
            ajaxFormUpdate();
          }
        });
        return;
      }
    } else {
      if (!valuesUnchanged) {
        ajaxFormDirty = true;
      }
    }
  }
  ajaxFormUpdate();
}

function ajaxServerPoll() {
  ajaxServerPollTimer = setTimeout("doAjaxServerPoll()", 5000)
}

function doAjaxServerPoll() {
  $.ajax({
    url: urlAjaxPoll,
    type:'get',
    dataType:'html',
    success:function(ret) {
      $('#helpDeskStatus').html(ret);
    },
    complete:function() {
      ajaxServerPoll();
    }
  });
}
