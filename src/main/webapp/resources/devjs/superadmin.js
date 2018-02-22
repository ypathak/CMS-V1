var superadmin = {
    init: function() {
    	superadmin.getadmindata(1);
       $("#adminRegDiv").hide();
       
    },homeCountryDrpChange: function(e){
    	var homecountryid = $('#homecountryid option:selected').val();
    	event.preventDefault();
    	$.ajax({
            url: context + '/s/a/r/p',
            type: 'GET',
            data: {
            	homecountryid: homecountryid
            },
            success: function(res) {
            	debugger;
                $('.dev_homestates').replaceWith($(res).find('.dev_homestates'));
                $('.dev_homecities').replaceWith($(res).find('.dev_homecities'));
                $(".select2").select2();
            }
        });
    },homeStateDrpChange: function(e){
    	var homecountryid = $('#homecountryid option:selected').val();
    	var homestateid = $('#homestateid option:selected').val();
    	event.preventDefault();
    	$.ajax({
            url: context + '/s/a/r/p',
            type: 'GET',
            data: {
            	homecountryid: homecountryid,
            	homestateid: homestateid
            },
            success: function(res) {
                $('.dev_homecities').replaceWith($(res).find('.dev_homecities'));
                setTimeout(function(){ 
                	$(".select2").select2(), 3000
                });
                
            }
        });
    },offCountryDrpChange: function(e){
    	var officecountryid = $('#officecountryid option:selected').val();
    	event.preventDefault();
    	$.ajax({
            url: context + '/s/a/r/p',
            type: 'GET',
            data: {
            	officecountryid: officecountryid
            },
            success: function(res) {
            	debugger;
                $('.dev_officestateid').replaceWith($(res).find('.dev_officestateid'));
                $('.dev_officecityid').replaceWith($(res).find('.dev_officecityid'));
                $(".select2").select2();
            }
        });
    },offStateDrpChange: function(e){
    	var officecountryid = $('#officecountryid option:selected').val();
    	var officestateid = $('#officestateid option:selected').val();
    	event.preventDefault();
    	$.ajax({
            url: context + '/s/a/r/p',
            type: 'GET',
            data: {
            	officecountryid: officecountryid,
            	officestateid: officestateid
            },
            success: function(res) {
                $('.dev_officecityid').replaceWith($(res).find('.dev_officecityid'));
                setTimeout(function(){ 
                	$(".select2").select2(), 3000
                });
            }
        });
    },save:function(){
    	 $('form[name=dev_adminRegistrationForm]').submit(function(event) {
             event.preventDefault();
             $.ajax({
                 url: context + '/s/a/r',
                 type: 'POST',
                 cache: false,
                 data: $('form[name=dev_adminRegistrationForm]').serialize(),
                 success: function(res) {
                     //$('form[name=dev_adminRegistrationForm]')[0].reset();
                	 
                 	$('form[name=dev_adminRegistrationForm]')[0].replaceWith($(res).find('form[name=dev_adminRegistrationForm]')[0]);
                 	$('#aniversarydate, #birthdate').datepicker({
                 		  autoclose: true
                 	});
                 },error: function(err){
                 	$('form[name=dev_adminRegistrationForm]')[0].replaceWith($(err).find('form[name=dev_adminRegistrationForm]')[0]);
                 }
             });
         });
    },addnewadmin : function(){
    	event.preventDefault();
    	$("#adminlist").hide();
    	$("#adminRegDiv").show();
    	debugger;
    	var homecountryid = $('#homecountryid option:selected').val();
    	$.ajax({
            url: context + '/s/a/r/p',
            type: 'GET',
            data: {
            	homecountryid: homecountryid
            },
            success: function(res) {
            	debugger;
            	$("#adminRegDiv").replaceWith($(res).find('#adminRegDiv'));
             	$('#aniversarydate, #birthdate').datepicker({
             		  autoclose: true
             	});
                $(".select2").select2();
            }
        });
    
    },backadminlist : function(){
    	$("#adminRegDiv").hide();
    	$("#adminlist").show();
    },	getadmindata : function (i) {
		 debugger;
			$.ajax({
				type: "GET",
				url:context + '/s/a/l',
				data :{ 
					'pageCount': i
					},
				success: function(res) {
					var header = document.getElementById("example2_paginate");
					var btns = header.getElementsByClassName("paginate_button");
					for (var i = 0; i < btns.length; i++) {
					  btns[i].addEventListener("click", function() {
					    var current = document.getElementsByClassName("active");
					    current[0].className = current[0].className.replace(" active", "");
					    this.className += " active";
					  });
					}
					$("#example2").replaceWith($(res).find('#example2'));
				},error : function(){
					console.log("Excedption");
				}
			});
		
	 },
}