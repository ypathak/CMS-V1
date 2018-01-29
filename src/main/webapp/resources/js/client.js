/**
 * 
 */

var client={
		addnewclient : function(){
			document.getElementById('divdisplay').style.display = "block";
		},	

		fromsubmit : function(){
			
			//Prevent default submission of form
			event.stopPropagation();
		      
			debugger;
			var urlsend = $("#clientdata").attr("action")+"/a/clntregister";
			
			$.ajax({
				/*type:"POST",
				url:urlsend,
				data:$("#clientdata").serialize(),*/
				url : urlsend,
                type : "POST",
                /*data: $("#clientdata").serialize(),*/
				success: function(data){
					debugger;
					alert(data+"success");
					$("#divdisplay").hide();


				},error : function(error){
					alert(error.responseText+"exception");
					/*document.getElementById('divdisplay').style.display = "block";*/
				} 
			});

		},

		Validate: function(){
			
			debugger;
			
			//Prevent default submission of form
			event.stopPropagation();
			
			/*var cname = document.getElementById("clientname").value;
			var Pannumber = document.getElementById("pannumber").value;
			var adharnumber = document.getElementById("adharnumber").value;
			var department = document.getElementById("department").value;
			var datepicker = document.getElementById("dateofbirth").value;
			var mobilenumber = document.getElementById("mobilenumber").value;
			var phonenumber = document.getElementById("phonenumber").value;

			if(phonenumber.length != 10 || cname=="" || Pannumber=="" || adharnumber=="" || department=="" || datepicker==""
				|| isNaN(mobilenumber) || isNaN(phonenumber) || mobilenumber.length != 10 || phonenumber.length != 10){


				if(cname=="" || cname==null){
					document.getElementById("client").innerHTML="Enter Client Name";  

				}
				if(Pannumber=="" || Pannumber==null){
					document.getElementById("pan").innerHTML="Enter Pan Number";  
				}
				if(adharnumber=="" || adharnumber==null){
					document.getElementById("adhar").innerHTML="Enter Adhar Number";  
				}
				if(department=="" || department==null){
					document.getElementById("depart").innerHTML="Enter Department";  
				}

				if(datepicker=="" || datepicker == null){
					debugger;
					re = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
					alert($("#dateofbirth").val());
					if(regs =  $("#dateofbirth").val().match(re)) {
						if(regs[1] < 1 || regs[1] > 31) {
							document.getElementById("dob").innerHTML= "Invalid value for day: " + regs[1]; 
						} else if(regs[2] < 1 || regs[2] > 12) {
							document.getElementById("dob").innerHTML= "Invalid value for month: " + regs[2]; 

						} else if(regs[3] < minYear || regs[3] > maxYear) {
							document.getElementById("dob").innerHTML= "Invalid value for year: " + regs[3] + " - must be between " + minYear + " and " + maxYear;
						}
					} else {
						document.getElementById("dob").innerHTML= "Invalid date format: ";
					}

				} 

				if(isNaN(mobilenumber) || isNaN(phonenumber)){
					document.getElementById("mobilenumber").innerHTML="Enter Valid Mobile Number";  

				}
				if(mobilenumber.length != 10){
					debugger;
					document.getElementById("mobile").innerHTML="Enter Valid Mobile Number";  

				}
				if(phonenumber.length != 10){
					document.getElementById("phone").innerHTML="Enter Valid Phone Number";  

				}
				return false;
			}*/
			client.fromsubmit();
		},

		closepopup: function(){
			debugger;
			$("#divdisplay").hide();

		},

		showtable: function(obj){

		},

};
