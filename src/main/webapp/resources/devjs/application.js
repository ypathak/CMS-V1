 $(document).ready(function() {

 }).ajaxStart(function() {
     //alert('yes');
 }).ajaxStop(function() {
     //alert('e');
 });

 $(window).scroll(function(e) {
     var $el = $('.fixedElement');
     var isPositionFixed = ($el.css('position') == 'fixed');
     if ($(this).scrollTop() > 10 && !isPositionFixed) {
         $('.fixedElement').css({
             'position': 'fixed',
             'top': '0px'
         });
     }
     if ($(this).scrollTop() < 200 && isPositionFixed) {
         $('.fixedElement').css({
             'position': 'static',
             'top': '0px'
         });
     }
 });
 var mainApp = {
     showNotification: function(str, msg) {
         $('div.devnotification').removeClass('alert-success');
         $('div.devnotification').removeClass('alert-info');
         $('div.devnotification').removeClass('alert-warning');
         $('div.devnotification').removeClass('alert-danger');
         $('div.devnotification').text("");
         if (str === "Info") {
             $('div.devnotification').text(msg);
             $('div.devnotification').addClass('alert-info');
             $('div.devnotification').removeClass('invisible');
         } else if (str === "success") {
             $('div.devnotification').text(msg);
             $('div.devnotification').addClass('alert-success');
             $('div.devnotification').removeClass('invisible');
         } else if (str === "warning") {
             $('div.devnotification').text(msg);
             $('div.devnotification').addClass('alert-warning');
             $('div.devnotification').removeClass('invisible');
         } else if (str === "danger") {
             $('div.devnotification').text(msg);
             $('div.devnotification').addClass('alert-danger');
             $('div.devnotification').removeClass('invisible');
         }
         $("div.devnotification").fadeIn("slow").delay(1000).fadeOut("slow");
     }
 }