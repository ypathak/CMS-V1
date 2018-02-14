<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content Wrapper. Contains page content -->
   <section class="content-header"></section>
   <section class="content" id="adminRegDiv">
      <div class="box box-default">
         <div class="box-header with-border">
            <span class="fa fa-user-o"></span>
            <h3 class="box-title">Admin Register</h3>
            <!-- <div class="box-tools pull-right">
               <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
               <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
               </div> -->
         </div>
         <!-- /.box-header -->
         <div class="box-body">
            <%-- <form:form modelAttribute="admindata" action="${contextPath}/s/a/r" name="dev_adminRegistrationForm"> --%>
            <form:form modelAttribute="admindata" name="dev_adminRegistrationForm">
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label class="requiredField">First Name</label>
                        <form:input class="form-control" placeholder="First Name" type="text" path="firstname"/>
                        <span class="fa fa-user form-control-feedback"></span>
                        <span>
                           <form:errors path="firstname" cssClass="error"/>
                        </span>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label class="requiredField">Last Name</label>
                        <form:input class="form-control" placeholder="Last Name" type="text" path="lastname"/>
                        <span class="fa fa-user form-control-feedback"></span>
                        <span>
                           <form:errors path="lastname" cssClass="error" />
                        </span>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label class="requiredField">User Name</label>
                        <form:input class="form-control" placeholder="User name" type="text" path="username"/>
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        <span>
                           <form:errors path="username" cssClass="error"/>
                        </span>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label class="requiredField">Email</label>
                        <form:input class="form-control" placeholder="Email" type="email" path="email"/>
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                        <span>
                           <form:errors path="email" cssClass="error" />
                        </span>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label class="requiredField">Password</label>
                        <form:input class="form-control" placeholder="Password" type="password" path="password"/>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        <span>
                           <form:errors path="password" cssClass="error" />
                        </span>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group has-feedback">	
                        <label>Repeat-Password</label>
                        <input class="form-control" placeholder="Repeat-Password" type="password" />
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label class="requiredField">Birth Date</label>
                        <div class="input-group date">
                           <form:input type="text" class="form-control pull-right" path="birthdate" placeholder="Birth Date" />
                           <div class="input-group-addon">
                              <i class="fa fa-calendar"></i>
                           </div>
                        </div>
                        <span>
                           <%-- <form:errors path="birthdate" cssClass="error" /> --%>
                        </span>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label class="requiredField">Aniversary Date</label>
                        <div class="input-group date">
                           <form:input type="text" class="form-control pull-right" path="aniversarydate" placeholder="Aniversary Date" />
                           <div class="input-group-addon">
                              <i class="fa fa-calendar"></i>
                           </div>
                        </div>
                        <span>
                           <%-- <form:errors path="aniversarydate" cssClass="error" /> --%>
                        </span>
                     </div>
                  </div>
               </div> 
               <div class="row">
                  <div class="col-md-12">
                     <div class="form-group has-feedback">
                        <label class="requiredField">Home Address</label>
                        <form:textarea class="form-control" rows="3" placeholder="Home Address" path="homeadd"></form:textarea>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <div class="form-group">
                           <label>Country*</label>
                           <form:select class="form-control select2" style="width: 100%;" path="homecountryid" onchange="superadmin.homeCountryDrpChange();">
                              <form:options items="${homecountries}" itemLabel="name" itemValue="id"/>
                           </form:select>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group has-feedback dev_homestates">
                        <label>State*</label>
                        <form:select class="form-control select2" style="width: 100%;" path="homestateid" onchange="superadmin.homeStateDrpChange();">
                           <form:options items="${homestates}" itemLabel="name" itemValue="id"/>
                        </form:select>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group has-feedback dev_homecities">
                        <div class="form-group">
                           <label>City*</label>
                           <form:select class="form-control select2" style="width: 100%;" path="homecityid">
                              <form:options items="${homecities}" itemLabel="name" itemValue="id"/>
                           </form:select>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label>Zip Code*</label>
                        <form:input type="text" class="form-control pull-right" path="homezipcode" placeholder="Zip Code" />
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-12">
                     <div class="form-group has-feedback">
                        <label>Office Address</label>
                        <form:textarea class="form-control" rows="3" placeholder="Office Address" path="offadd" ></form:textarea>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <div class="form-group">
                           <label>Country*</label>
                           <form:select class="form-control select2" style="width: 100%;" path="officecountryid" onchange="superadmin.offCountryDrpChange();">
                              <form:options items="${offcountries}" itemLabel="name" itemValue="id"/>
                           </form:select>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group has-feedback dev_officestateid">
                        <label>State*</label>
                        <form:select class="form-control select2" style="width: 100%;" path="officestateid" onchange="superadmin.offStateDrpChange();">
                           <form:options items="${offstates}" itemLabel="name" itemValue="id"/>
                        </form:select>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-6">
                     <div class="form-group has-feedback dev_officecityid">
                        <div class="form-group">
                           <label>City*</label>
                           <form:select class="form-control select2" style="width: 100%;" path="officecityid">
                              <form:options items="${offcities}" itemLabel="name" itemValue="id"/>
                           </form:select>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group has-feedback">
                        <label>Zip Code*</label>
                        <form:input type="text" class="form-control pull-right" path="officezipcode" placeholder="Zip Code" />
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-md-4">
                    <div class="form-group has-feedback">
                        <label>Pan Card Number (PAN)*</label>
                        <form:input type="text" class="form-control" path="pancardnum" placeholder="Pan Card Number (PAN)"  />
                     </div>
                  </div>
                   <div class="col-md-4">
                     <div class="form-group has-feedback">
                        <label>Aadhar Card Number*</label>
                        <form:input type="text" class="form-control" placeholder="Aadhar Card Number" path="aadharnum" />
                     </div>
                  </div>
                  <div class="col-md-4">
                     <div class="form-group has-feedback">
                        <label>GSTIN</label>
                        <form:input type="text" class="form-control" placeholder="GSTIN" path="gstin" />
                     </div>
                  </div>
               </div>
               <div class="box-footer">
                  <!-- <button type="submit" class="btn btn-primary">Submit</button> -->
                  <button type="submit" class="btn btn-primary"
                        onclick="superadmin.save();">Submit</button>
               </div>
            </form:form>
         </div>
      </div>
      <!-- /.box -->
   </section>
<script src="${contextPath}/resources/devjs/superadmin.js"></script>
<script type="text/javascript">
   $(function () {
   	$('#aniversarydate, #birthdate').datepicker({
   		  autoclose: true
   	});
    //Initialize Select2 Elements
    $(".select2").select2();
   });
   
   superadmin.init();
</script>