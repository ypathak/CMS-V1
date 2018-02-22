var superadmin = {
    init: function() {
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
                 	$('form[name=dev_adminRegistrationForm]')[0].replaceWith($(res).find('form[name=dev_adminRegistrationForm]')[0]);
                 	$('#aniversarydate, #birthdate').datepicker({
                 		  autoclose: true
                 	});
                	var header = document.getElementById("admindata");
                	var error = header.getElementsByClassName("error");
                	if(error.length>1){
                		mainApp.showNotification("Info","Plese Enter valid Information");
                	}else{
                		mainApp.showNotification("success","Insert Admin Successfully");
                	}
                 },error: function(err){
                 	$('form[name=dev_adminRegistrationForm]')[0].replaceWith($(err).find('form[name=dev_adminRegistrationForm]')[0]);
                 }
             });
         });
    },addnewadminbtn : function(){
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
    
    },
    backadminlistbtn : function(){
    	$("#adminRegDiv").hide();
    	$("#adminlist").show();
    	superadmin.getadmindata(1);
    },
    getadmindata : function (i) {
    	event.preventDefault();
    	$("#adminRegDiv").hide();
    	$("#adminlist").show();
    	var totalperpage=$("#showdatalength").val();
			$.ajax({
				type: "GET",
				url:context + '/s/a/l',
				data :{ 
					'pageindex': i,
					'totalrecperpage':totalperpage
					},
				success: function(res) {
					$("#example2_paginate").replaceWith($(res).find('#example2_paginate'));
					var header = document.getElementById("example2_paginate");
                	var error = header.getElementsByClassName("active");
                	error[0].className = error[0].className.replace(" active", "");
                	var header1 = document.getElementById("page"+i);
                	header1.className += " active";
                	$("#example2_info").replaceWith($(res).find('#example2_info'));
					$("#example2").replaceWith($(res).find('#example2'));
				},error : function(){
					console.log("Excedption");
				}
			});
		
	 },
}