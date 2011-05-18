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
        if (!/^Enter /.test($('#address').val())) {
                $('#btn-search').click();
        }
        return false;
    });
 }


$(document).ready(function() {
  setupForm();
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

