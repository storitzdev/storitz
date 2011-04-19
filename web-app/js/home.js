
function calcDistance(lat1, lat2, lng1, lng2) {
    var d = Math.acos(Math.sin(lat1 / 57.2958) * Math.sin(lat2 / 57.2958) +
            Math.cos(lat1 / 57.2958) * Math.cos(lat2 / 57.2958) *
                    Math.cos(lng2 / 57.2958 - lng1 / 57.2958)) * R;
    return Math.round(100 * d) / 100;
}

function siteLink(s) {
    var city_pat = RegExp(' ?[-/]? ?' + s.city + ' ?[-/]? ?', 'i');
    var queryStr = '';
    var paramAdded = false;
    if (searchSize > 1 || getDate() != '' || getAddress() != '' || searchType != "STORAGE") {
        if (searchSize >1) {
            paramAdded = true;
            queryStr += ('?size=' + searchSize);
        }
        if (getDate() != '') {
            queryStr += ((paramAdded ? '&' : '?') + 'date=' + getDate());
            paramAdded = true;
        }
        if (searchType != 'STORAGE') {
            queryStr += ((paramAdded ? '&' : '?') + 'searchType=' + searchType);
            paramAdded = true;
        }
    }
    return baseURL + '/self-storage-' + s.title.replace(city_pat, '').replace(/ - /g,'-').replace(/ /g,'-') + '/' + s.id + queryStr;
}

function metroLink(city, state, zip) {
    // /$city-$state-zip-code-$zip-self-storage
    return baseURL + '/' + city.replace(/ /g, '-') + '-' + state + '-zip-code-' + zip + '-self-storage';
}


function getDate() {
    if ($('#date').val() && !/^Select/.test($('#date').val())) {
        return $('#date').val();
    }
    return '';
}

function getAddress() {
    if ($('#address').val() && !/^Enter /.test($('#address').val())) {
        return $('#address').val();
    }
    return '';
}

function redrawMap() {

    bounds = map.getBounds();

    if (!firstDraw) {
        firstDraw = true;
        return;
    }

    if (!inDrag) {
        _gaq.push(['_trackEvent', 'home', 'map', 'bounds change']);
        getMarkers();
    }
}

function dragStart() {
    inDrag = true;
}

function dragEnd() {
    inDrag = false;
    _gaq.push(['_trackEvent', 'home', 'map', 'drag']);
    getMarkers();
}

function setupIdle() {
    $.fn.idle = function(time) {
        return this.each(function() {
            var i = $(this);
            i.queue(function() {
                setTimeout(function() {
                    i.dequeue();
                }, time);
            });
        });
    };
}

function createMarker(s) {
    var location = new google.maps.LatLng(s.lat, s.lng);

    features[s.id] = s;
    s.marker = new google.maps.Marker({
        map: map,
        title: s.title,
        position: location,
        icon: savedFeature && savedFeature == s.id ? markersBlue[s.index] : markersGreen[s.index]
    });
    google.maps.event.addListener(s.marker, 'click', function() {
        markerClick(s);
    });
    google.maps.event.addListener(s.marker, 'mouseover', function() {
        var foundRow = $(resultTable.fnGetNodes(s.index - 1));
        if (foundRow) {
            foundRow.addClass('highlightRow');
        }
        if (!savedFeature || savedFeature != s.id) {
            s.marker.setIcon(markersBlue[s.index]);
        }
        if (!savedTableId || savedTableId != s.id) {
            $('#map_icon' + s.id).html($('<img>', { src:srcMarkersBlue[s.index], width: 28, height: 35}));
        }
    });
    google.maps.event.addListener(s.marker, 'mouseout', function() {
        var foundRow = $(resultTable.fnGetNodes(s.index - 1));
        if (foundRow) {
            foundRow.removeClass('highlightRow');
        }
        if (!savedFeature || savedFeature != s.id) {
            s.marker.setIcon(markersGreen[s.index]);
        }
        if (!savedTableId || savedTableId != s.id) {
            $('#map_icon' + s.id).html($('<img>', { src:srcMarkersGreen[s.index], width: 28, height: 35}));
        }
    });
}

function panTo(markerId) {
    window.setTimeout(function() {
        map.panTo(features[markerId].marker.getPosition());
    }, 250);
    markerOver(features[markerId]);
}

function getMarkers() {

    if (!bounds || typeof(bounds) == 'undefined') {
        return;
    }

    $('#mapSpinner').fadeIn();

    $.ajax({
        url: urlMapResults,
        method:'get',
        dataType:'json',
        data: {
            searchSize: searchSize,
            addressChange: addressChange,
            searchType: searchType,
            date: getDate(),
            lat: map.getCenter().lat(),
            lng: map.getCenter().lng(),
            swLat: bounds.getSouthWest().lat(),
            swLng: bounds.getSouthWest().lng(),
            neLat: bounds.getNorthEast().lat(),
            neLng: bounds.getNorthEast().lng()
        },
        success:function(ret) {

            if (ret.zoom > 0) {
                map.setZoom(ret.zoom);
            }
            var rows = 0;
            var statusText
            if (ret.siteCount >= 20) {
                statusText = 'Your search found more than 20 results.  Here are the top 20';
            } else if (ret.siteCount > 1) {
                statusText = 'Your search found ' + ret.siteCount + ' results';
            } else if (ret.siteCount == 1) {
                statusText = 'Your search found ' + ret.siteCount + ' result';
            } else {
                statusText = 'Your search found no results';
            }
            $('#mapStatus').html(statusText).effect("highlight", {}, 1000);

            resultTable.fnClearTable();

            $.each(features, function(i, f) {
                if (f && f.marker) {
                    f.marker.setMap(null);
                }
            });

            $.each(ret.features, function(i, s) {
                createMarker(s);
                createTableRow(s);
            });
            $('table#stresults thead').children().remove();

            setupMap();
            setupTooltips();
        },
        error:function(ret) {
            alert("Something went wrong " + ret);
        }
    });
    addressChange = false;
    $('#mapSpinner').idle(500).fadeOut('slow')
}

function showAddress(address, size, date, searchType) {

    var validAddr = address.length > 4 && !/^Enter /.test(address);

    if (validAddr) {
        oldSearchAddr = searchAddr
        searchAddr = address;
        if (searchAddr != oldSearchAddr) {
            document.title = "Self storage units, mini storage in " + address + " - Storitz";
            addressChange = true;
            updateMetroBox(searchAddr);
        }
    }
    searchSize = size;
    searchDate = date;

    if (validAddr) {
        $.ajax({
            url: urlGeocode,
            method:'get',
            dataType:'json',
            data: { address: address},
            success:function(geoResult) {
                if (geoResult.status == google.maps.GeocoderStatus.OK) {
                    searchLat = geoResult.results[0].geometry.location.lat;
                    searchLng = geoResult.results[0].geometry.location.lng;
                    var center = new google.maps.LatLng(searchLat, searchLng)
                    map.setCenter(center);
                    if (mapMarker) {
                        mapMarker.setMap(null);
                    }
                    mapMarker = new google.maps.Marker({
                        map: map,
                        position: center
                    });
                } else {
                    $('#mapStatus').html('Could not find address - please check search.').effect("highlight", {}, 1000);
                }
            }
        });

    }
    // only redraw markers if date or size changed
    if (oldSearchAddr == searchAddr) {
        getMarkers();
    }
}

function setupCalendar() {
    $('#date').datepicker(
    { dateFormat: 'mm/dd/y',
        minDate: 0,
        maxDate: "+2M",
        onSelect: function(dateText, inst) {
            _gaq.push(['_trackEvent', 'home', 'search', 'step 3 date']);
            showAddress(getAddress(), $('#size').val(), dateText, searchType);
        }
    }).addTouch();
}

function setupHelp() {
    $('#sizeHelp').dialog({
        autoOpen: false,
        resizable: false,
        width: 440
    }).addTouch();
    $('.sizeGuide').click(function(event) {
        _gaq.push(['_trackEvent', 'home', 'size guide']);
        $('#sizeHelp').dialog('open');
    });
}

function setupForm() {
    $('#address').focus();
    $('#address').keypress(function(event) {
        if (event.keyCode == 13) {
            event.preventDefault();
            _gaq.push(['_trackEvent', 'home', 'search', 'step 1 address']);
            showAddress(getAddress(), $('#size').val(), getDate(), searchType);
            return false;
        }
    });
    $('#address').click(function(event) {
        if (/^Enter /.test($('#address').val())) {
            $('#address').val('');
        }
    });
    $('#address').focusout(function(event) {
        _gaq.push(['_trackEvent', 'home', 'search', 'step 1 address']);
        showAddress(getAddress(), $('#size').val(), getDate(), searchType);
        return false;
    });
    $('select#size').change(function(event) {
        var searchUnitSize = $('#size').val();
        _gaq.push(['_trackEvent', 'home', 'search', 'step 2 unitsize ' + searchUnitSize]);
        showAddress(getAddress(), searchUnitSize, getDate(), searchType);
    });
    $('select#sbUnitsize').change(function(event) {
        var searchUnitSize = $('select#sbUnitsize').val();
        _gaq.push(['_trackEvent', 'home', 'search', 'results unitsize ' + searchUnitSize]);
        showAddress(getAddress(), searchUnitSize, getDate(), searchType);
    });
    $('select#sbSortSelect').change(function(event) {
        var sortType = $(this).val();
        _gaq.push(['_trackEvent', 'home', 'sort', 'results table ' + sortType]);
        switch (sortType) {
            case '0':
                resultTable.fnSort([
                    [3, 'asc']
                ]);
                break;
            case '1':
                resultTable.fnSort([
                    [3, 'desc']
                ]);
                break;
            case '2':
                resultTable.fnSort([
                    [2, 'asc']
                ]);
                break;
            case '3':
                resultTable.fnSort([
                    [2, 'desc']
                ]);
                break;
            case '4':
                resultTable.fnSort([
                    [1, 'asc']
                ]);
                break;
            case '5':
                resultTable.fnSort([
                    [1, 'desc']
                ]);
                break;
            case '6':
                resultTable.fnSort([
                    [5, 'asc']
                ]);
                break;
            case '7':
                resultTable.fnSort([
                    [5, 'desc']
                ]);
                break;
        }
    });
    $('input[name="searchType"]').change(function(event) {
        // update the dropdown here
        $('#size').children().each(function(index) { $(this).remove(); });
        searchType = $('input[name="searchType"]:checked').val();
        _gaq.push(['_trackEvent', 'home', 'search', 'searchType ' + searchType]);
        $.ajax({
            url: urlChangeSearchType,
            method:'get',
            dataType:'json',
            data: { searchType: searchType },
            success:function(data) {
                $.each(data, function (index, sizeEntry) {
                   var opt = $("<option>", {
                     value: sizeEntry.id
                   }).text(sizeEntry.description);
                   $('#size').append(opt);
                });
            }
        });
        addressChange = true;
        showAddress(getAddress(), $('#size').val(), getDate(), searchType);
    });
}

function setupQtipThemeroller() {
    $.fn.qtip.styles.themeroller = {
        background: null,
        color: null,
        tip: {
            corner: true,
            background: null
        },
        border: {
            width: 5,
            radius: 3
        },
        title: {
            'background': null,
            'fontWeight': null
        },
        classes: {
            tooltip: 'ui-widget',
            tip: 'ui-widget',
            title: 'ui-widget-header',
            content: 'ui-widget-content'
        }
    };

}

function setupTooltips() {
    $(".tooltip_keypad").qtip({ content: "Keypad Entry",  position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } },   show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
    $(".tooltip_camera").qtip({ content: "Video Camera Security", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
    $(".tooltip_gate").qtip({ content: "Security Gate", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
    $(".tooltip_alarm").qtip({ content: "Unit level alarms", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
    $(".tooltip_truck").qtip({ content: "Move-In Truck Available", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
    $(".tooltip_manager").qtip({ content: "Manager Onsite", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
    $(".tooltip_elevator").qtip({ content: "Elevator to upper floors", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
}

function createTableRow(s) {

  var logoCol
  if (s.logo.toString().length > 0) {
    logoCol = $('<div>').append($('<div>', { 'class': 'left' } ).css('width','120px').append($('<img>', { 'class':'stLogo', src: s.logo, width:100, height:40, border:0, alt: s.title + ' Logo'})));
  } else {
    logoCol = $('<div>').append($('<div>', { 'class': 'left' } ).css('width', '120px').html('&nbsp;'));
  }

  var features = $('<div>');
  if (s.isKeypad) {
    features.append($('<img>', { 'class': 'stFeatureIcon tooltip_keypad', src: srcIconKeypad, alt:"Keypad", width:20, height:20 }));
  }
  if (s.isCamera) {
    features.append($('<img>', { 'class': 'stFeatureIcon tooltip_camera', src: srcIconCamera, alt:"Video Camera", width:20, height:20 }));
  }
  if (s.isGate) {
    features.append($('<img>', { 'class': 'stFeatureIcon tooltip_gate', src: srcIconGate, alt:"Gate", width:20, height:20 }));
  }
  if (s.isUnitAlarmed) {
    features.append($('<img>', { 'class': 'stFeatureIcon tooltip_alarm', src: srcIconAlarm, alt:"Unit Alarms", width:20, height:20 }));
  }
  if (s.isManagerOnsite) {
    features.append($('<img>', { 'class': 'stFeatureIcon tooltip_manager', src: srcIconManager, alt:"Manager Onsite", width:20, height:20 }));
  }
  if (s.isGate) {
    features.append($('<img>', { 'class': 'stFeatureIcon tooltip_elevator', src: srcIconElevator, alt:"Elevator", width:20, height:20 }));
  }

  switch(s.freeTruck) {
    case "FREE":
      features.append($('<img>', { 'class': 'stFeatureIcon tooltip_truck', src: srcIconTruck, alt:"Free Truck", width:20, height:20 }));
      break;
    case "RENTAL":
      features.append($('<img>', { 'class': 'stFeatureIcon tooltip_truck', src: srcIconTruck, alt:"Rental Truck", width:20, height:20 }));
      break;
  }

  var offersCol = $('<div>').append($('<div>').css('width', '150px'));

  if (s.promoId) {
    offersCol
      .append($('<div>', {'class':'left'}).css('width','22px')
        .append($('<img>', { src: srcSpecialOffer, alt:'Special Offer checkmark', width:16, height:16})))
      .append($('<div>', {'class':'left'}).css('width','125px')
        .append($('<div>', { 'class': 'stSpecialOffers'}).text(s.promoName ? s.promoName : ''))
        .append($('<div>', { 'class': 'stSpecialOffersSeeMore'}).text('See more offers'))
        .append($('<div>').text((s.sizeDescription ? s.sizeDescription: '') + (s.unitType ? ' ' + s.unitType : '') + (searchType == 'PARKING' ? ' space' : ' unit') )));
  } else {
    offersCol
      .append($('<div>', {'class':'left'}).css({'width':'22px', 'height':'100%'}).html('&nbsp;'))
      .append($('<div>', {'class':'left'}).css('width','120px')
        .append($('<div>').text((s.sizeDescription ? s.sizeDescription: '') + (s.unitType ? ' ' + s.unitType : '') + (searchType == 'PARKING' ? ' space' : ' unit') )));
  }

  var distanceCol = $('<div>').append($('<div>').css('width', '55px').append($('<div>', { 'class': 'left' }).css('margin-left', '10px'))
              .append($('<div>', { id: 'map_icon'+s.id, 'class':'map_icon'})
                .append($('<img>', { src: savedTableId && savedTableId == s.id ? srcMarkersBlue[s.index] : srcMarkersGreen[s.index], width: 28, height: 35 })))
              .append($('<div>', { 'class':'stDistance' }).text(calcDistance(searchLat, s.lat, searchLng, s.lng)))
              .append($('<div>', { 'class':'stMiles' }).text('miles')));

  var facilityCol = $('<div>').append($('<div>').css('width', '190px').append($('<div>', { 'class':'stTitle' }).text(s.title)))
              .append($('<div>', { 'class': 'left' }).css('margin-left', '5px')
                .append($('<div>', { 'class':'stAddress' }).text(s.address)))
            .append($('<div>').css('clear','both'))
            .append(features);

    var linkUrl = siteLink(s);

  var priceCol;
  if (displayStyle === "monthly") {
    priceCol = $('<div>').append($('<div>').css('width', '120px'));
      if (s.monthly > s.pushRate) {
        priceCol.append($('<div>', { 'class':'stPrice textCenter' })
          .append($('<div>').css('text-decoration', 'line-through').html('$' + (s.monthly ? s.monthly.toFixed(2) : '')))
          .append($('<div>', { 'class':'red' }).html('$' + (s.pushRate ? s.pushRate.toFixed(2) : '')).append($('<span>', {'class':'stPricePerMonth'}).html(' / MO'))));
      } else {
         priceCol.append($('<div>', { 'class':'stPrice textCenter' }).html('$' + (s.monthly ? s.monthly.toFixed(2) : '')).append($('<span>', { 'class':'stPricePerMonth' }).html(' / MO')));
      }
      priceCol.append($('<div>', { 'class':'stRentMe' })
        .append($('<a>', { href: linkUrl + (s.promoId ? (linkUrl.indexOf('?') != -1 ? '&' : '?') + 'promoId=' + s.promoId : '') })
        .append($('<img>', { src: s.transactionType == 'RESERVATION' ? srcReserveButton : srcRentMeButton, width:87, height: 31, border: 0 } ))))
  } else {

    priceCol = $('<div>').append($('<div>').css('width', '120px'))
            .append($('<div>', { 'class':'stPrice textCenter' }).text('$' + (s.moveInCost ? s.moveInCost.toFixed(2) : '')))
            .append($('<div>', { 'class':'stPriceSub textCenter'}).text('Paid thru ' + (s.paidThruDate ? s.paidThruDate : '')))
            .append($('<div>', { 'class':'stPriceSub textCenter'}).html('Taxes &amp; fees included'))
            .append($('<div>', { 'class':'stRentMe' })
              .append($('<a>', { href: linkUrl + (s.promoId ? (linkUrl.indexOf('?') != -1 ? '&' : '?') + 'promoId=' + s.promoId : '') })
                .append($('<img>', { src: s.transactionType == 'RESERVATION' ? srcReserveButton : srcRentMeButton, width:87, height: 31, border: 0 } ))))

            if (s.monthly > s.pushRate) {
                priceCol.append($('<div>', { 'class':'stPriceSub textCenter monthly'}).append($('<span>').css('text-decoration','line-through').html('$' + (s.monthly ? s.monthly.toFixed(2) : ''))).append('&nbsp;').append($('<span>', {'class':'red'}).text('$' + (s.pushRate ? s.pushRate.toFixed(2) : ''))).append(' / MO'));
            } else {
                priceCol.append($('<div>', { 'class':'stPriceSub textCenter monthly'}).text('$' + (s.monthly ? s.monthly.toFixed(2) : '') + ' / MO'));                
            }
  }

  resultTable.fnAddData([
    priceCol.html(),
    (s.moveInCost ? s.moveInCost.toFixed(2) : 10000),
    (s.pushRate ? s.pushRate.toFixed(2) : 10000),
    distanceCol.html(),
    logoCol.html(),
    facilityCol.html(),
    offersCol.html()
  ]);
}

function setupTable() {
    /* Create an array with the values of all the input boxes in a column */
    $.fn.dataTableExt.afnSortData['distance'] = function  (oSettings, iColumn, vColumn) {
        var aData = [];
        $('td:eq(' + vColumn + ') div.stDistance', oSettings.oApi._fnGetTrNodes(oSettings)).each(function () {
            aData.push($(this).text());
        });
        return aData;
    }
    $.fn.dataTableExt.afnSortData['facility'] = function  (oSettings, iColumn, vColumn) {
        var aData = [];
        $('td:eq(' + vColumn + ') div.stTitle', oSettings.oApi._fnGetTrNodes(oSettings)).each(function () {
            aData.push($(this).text());
        });
        return aData;
    }
    $.fn.dataTableExt.afnSortData['moveincost'] = function  (oSettings, iColumn, vColumn) {
        var aData = [];
        $('td:eq(' + vColumn + ') div.stPrice', oSettings.oApi._fnGetTrNodes(oSettings)).each(function () {
            aData.push($(this).text().substring(1));
        });
        return aData;
    }
}

function markerClick(feature) {
    var c = $('<div>', {'id':'mapInfoWin'}).css({'width':'200', 'overflow':'hidden'}).append(
            $('<div>', { 'class': 'infoWindowTitle' }).text(feature.title));
    if (feature.coverImg.length > 0) {
        c.append($('<img>', { src: srcHome + feature.coverImg,  alt:feature.title, 'class': 'left'}).css('margin-right', '5px'));
    }
    var linkUrl = siteLink(feature);
    c.append($('<div>', { 'class':'infoWindowText' })
            .append($('<div>').text(feature.address))
            .append($('<div>').text(feature.city + ', ' + feature.state + ' ' + feature.zipcode))
            .append($('<div>', {'class':'left'}).css('margin-top', '5px').append($('<a>', { 'class':'mapIcon', href: linkUrl + (feature.promoId ? (linkUrl.indexOf('?') != -1 ? '&' : '?') + 'promoId=' + feature.promoId : '') })
            .append($('<img>', { src: srcDetailButton, width:'55', height:'20', border:'0'  })))));
    var holder = $('<div>').append(c);
    feature.marker.setIcon(markersBlue[feature.index]);
    $('#map_icon' + feature.id).html($('<img>', { src:srcMarkersBlue[feature.index], width: 28, height: 35}));
    savedTableId = feature.id;
    if (infoWindow) {
        infoWindow.close();
    }
    if (savedFeature) {
        features[savedFeature].marker.setIcon(markersGreen[features[savedFeature].index]);
    }
    savedFeature = feature.id;
    infoWindow = new google.maps.InfoWindow({content: holder.html(), maxWidth: 200});
    google.maps.event.addListener(infoWindow, 'closeclick', function() {
        features[savedFeature].marker.setIcon(markersGreen[features[savedFeature].index]);
        if (savedTableId) {
            $('#map_icon' + savedTableId).html($('<img>', { src:srcMarkersGreen[features[savedTableId].index], width: 28, height: 35}));
        }
        savedTableId = null;
        savedFeature = null;
    });
    infoWindow.open(map, feature.marker);
    _gaq.push(['_trackEvent', 'home', 'map', 'marker click']);
    $('div#mapInfoWin').parent().css('overflow', 'hidden');
    $('a.mapIcon').click(function(event) {
        buildState();
        _gaq.push(['_trackEvent', 'home', 'map', 'marker detail']);
    });
}

function setupMap() {
    $('.map_icon').click(function(event) {
        var mapId = $(this).attr('id').substring(8);
        $('#map_icon' + mapId).html($('<img>', { src:srcMarkersBlue[features[mapId].index], width: 28, height: 35}));
        if (savedTableId) {
            $('#map_icon' + savedTableId).html($('<img>', { src:srcMarkersGreen[features[savedTableId].index], width: 28, height: 35}));
        }
        _gaq.push(['_trackEvent', 'home', 'results', 'icon click', mapId]);
        markerClick(features[mapId]);
        savedTableId = mapId;
    });
    $("table#stresults tbody tr td.stClickable").click(function(event) {
        var mapDiv = $(this).parent().find('.map_icon');
        var mapId = mapDiv.attr('id').substring(8);
        var linkUrl = siteLink(features[mapId]);
        _gaq.push(['_trackEvent', 'home', 'results', 'table click', mapId]);
        buildState();
        window.location = linkUrl + (features[mapId].promoId ? (linkUrl.indexOf('?') != -1 ? '&' : '?') + 'promoId=' + features[mapId].promoId : '');
    });
    $("div.stRentMe a").click(function(event){
      buildState();
      return true;  
    });
    $('#stresults tbody tr').mouseenter(function(event) {
        var mapDiv = $(this).find('.map_icon');
        var mapId = mapDiv.attr('id').substring(8);
        features[mapId].marker.setIcon(markersBlue[features[mapId].index]);
        $('#map_icon' + mapId).html($('<img>', { src:srcMarkersBlue[features[mapId].index], width: 28, height: 35}));
    });
    $('#stresults tbody tr').mouseleave(function(event) {
        var mapDiv = $(this).find('.map_icon');
        var mapId = mapDiv.attr('id').substring(8);
        if (!savedTableId || savedTableId != mapId) {
            features[mapId].marker.setIcon(markersGreen[features[mapId].index]);
            $('#map_icon' + mapId).html($('<img>', { src:srcMarkersGreen[features[mapId].index], width: 28, height: 35}));
        }
    });
}

function setupResults() {
    $('select#sbSortSelect').selectmenu({style:'dropdown', width: 210, menuWidth:250});
    $('select#sbUnitsize').selectmenu({style:'dropdown', width:125});
}

function updateMetroBox(address) {
    $.ajax({
            url: urlUpdateMetro,
            method:'get',
            dataType:'json',
            data: { address:address},
            success:function(ret) {
                if (ret.metro) {
                    var m = $('<div>', {'class':'wideTextbox' }).append($('<span>', {'class':'bold'}).append('<h3>', {'class':'metro'}).text(ret.metro.city + ', ' + ret.metro.state.display + ':')).append(ret.metro.note);
                    if (ret.neighborhood) {
                        m.append($('<div>').css('height','10px')).append($('<span>', {'class':'bold'}).append('<h3>', {'class':'metro'}).text(ret.neighborhood.city + ', ' + ret.neighborhood.state.display + ':')).append(ret.neighborhood.note);
                    }
                    m.append($('<div>').css({'font-weight':'bold', 'margin':'10px 0'}).append('<h3>', {'class':'metro'}).text('Neighborhoods and Towns'));
                    $.each(ret.neighborhoodList, function(i, n) {
                        m.append($('<div>', {'class':'left'}).css({'width':'200px', 'margin-right':'8px'}).append($('<a>', {href: metroLink(n.city, n.state.display, n.zipcode)}).text(n.city + ' self-storage')));
                    });
                    m.append($('<div>').css('clear','both'));
                    $("div#metroBox").html(m);
                } else {
                    $("div#metroBox").html('&nbsp;');
                }
            }
    });
}

function buildState() {
    var params = new Object();
    if (getAddress() != '') {
        params.address = getAddress();
    }
    if (getDate() != '') {
        params.date = getDate();
    }
    params.searchSize = $('#size').val();
    params.searchType = $('input[name="searchType"]:checked').val();
    params.zoom = map.getZoom();
    params.lat = map.getCenter().lat();
    params.lng = map.getCenter().lng();
    params.redraw = true;
    $.bbq.pushState(params, 0);
}

$(document).ready(function() {

  setupCalendar();
  setupHelp();
  setupForm();
  setupQtipThemeroller();
  setupIdle();
  createMap();
  setupTooltips();
  setupTable();
  setupResults();
});

$(window).bind('hashchange', function(e) {
    var url = e.fragment;
    var params = $.deparam.fragment(url);
    if (params.zoom && params.lat && params.lng) {
        searchLat = params.lat;
        searchLng = params.lng;
        zoom = parseInt(params.zoom);
        redraw = params.redraw;
    }
    if (params.searchSize) {
        searchSize = parseInt(params.searchSize);
        $("select#size").val(searchSize);
    }
    if (params.searchType) {
        searchType = params.searchType;
        $('input[name="searchType]').val(searchType);
    }
    if (params.date) {
        searchDate = params.date;
        $('input#date').val(searchDate);
    }
    if (params.address) {
        searchAddr = params.address;
        $('input#address').val(params.address);
    }
    // TODO - set sort order for table
});

// setup for google analytics
var _gaq = _gaq || [];
_gaq.push(  ['_setAccount', 'UA-16012579-1'],
            ['_setDomain', '.storitz.com'],
            ['_setAllowHash',false],
            ['_setAllowLinker', true],
            ['_trackPageview'],
            ['_trackPageview', '/goal/home']);

<!-- Google Website Optimizer Tracking Script -->
 _gaq.push(['gwo._setAccount', 'UA-16012579-4']);
 _gaq.push(['gwo._trackPageview', '/0667671337/test']);

var ga = document.createElement('script');
ga.type = 'text/javascript';
ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0];
s.parentNode.insertBefore(ga, s);
