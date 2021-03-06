<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
      <title>Insert title here</title>
      <style type="text/css">
         .error {
         color: red;
         }
      </style>
    
   </head>
   <body>
    <sec:authentication property="principal.username" var="uname" />
      <div class="content-wrapper">
         <!-- Content Header (Page header) -->
         <section class="content-header">
            <c:url	value="/a/clntregister" var="registerURL" />
            <div class="form-group has-feedback">
               <div class="row">
                  <div class="col-md-6">
                     <div class="box box-primary">
                        <div class="box-header with-border">
                           <h3 class="box-title">Register a Client</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                           <form:form method="POST" modelAttribute="clientdata"
                              action="${registerURL}">
                              <div class="form-group has-feedback">
                                 <form:input class="form-control" placeholder="Name" type="text" path="Clientname"/>
                                 <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                 <span>
                                    <form:errors path="clientname" cssClass="error"/>
                                 </span>
                              </div>
                              <div class="form-group has-feedback">
                                 <form:input class="form-control" placeholder="PAN Number" type="text" path="pannumber"/>
                                 <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                 <span>
                                    <form:errors path="pannumber" cssClass="error" />
                                 </span>
                              </div>
                              <div class="form-group has-feedback">
                                 <form:input class="form-control" placeholder="Adhar Number" type="text" path="adharnumber"/>
                                 <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                 <span>
                                    <form:errors path="adharnumber" cssClass="error" />
                                 </span>
                              </div>
                               <div class="form-group has-feedback">
                                 <form:input class="form-control" placeholder="Department" type="text" path="department"/>
                                 <span class="fa-building-o form-control-feedback"></span>
                                 <span>
                                    <form:errors path="department" cssClass="error" />
                                 </span>
                              </div>
                                <div class="form-group has-feedback">
                                 <form:input class="form-control" placeholder="DOB" type="text" path="dateofbirth" id="datepicker"/>
                                 <span class="fa fa-birthday-cake form-control-feedback"></span>
                                 <span>
                                    <form:errors path="dateofbirth" cssClass="error" />
                                 </span>
                              </div>
                              <div class="form-group has-feedback">
                                 <form:input class="form-control" placeholder="Mobile Number" type="number" path="mobilenumber"/>
                                 <span class="fa-mobile form-control-feedback"></span>
                                 <span>
                                    <form:errors path="mobilenumber" cssClass="error" />
                                 </span>
                              </div>
                                <div class="form-group has-feedback">
                                 <form:input class="form-control" placeholder="Phone Number" type="number" path="phonenumber"/>
                                 <span class="fa-phone form-control-feedback"></span>
                                 <span>
                                    <form:errors path="phonenumber" cssClass="error" />
                                 </span>
                              </div>
                              <div class="row">
                                 <div class="col-xs-8">
                                    <div class="checkbox icheck">
                                       <label class="">
                                       </label>
                                    </div>
                                 </div>
                                 <!-- /.col -->
                                 <div class="col-xs-4">
                                    <button type="submit"
                                       class="btn btn-primary btn-block btn-flat">Register</button>
                                 </div>
                                 <!-- /.col -->
                                    <form:hidden path="createdBy" value="${uname }"/>
                              </div>
                           </form:form>
                        </div>
                     </div>
                     <!-- /.box -->
                  </div>
                  <div class="col-md-6"></div>
               </div>
            </div>
         </section>
         <!-- /.content -->
      </div>
   </body>
 
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 

        <script type="text/javascript">
   $(function() {
	    $( "#datepicker" ).datepicker({
	    	  dateFormat : 'dd/mm/yy',
	            changeMonth : true,
	            changeYear : true,
	            yearRange: '-100y:c+nn',
	            maxDate: '-1d',
	            autoclose: true,
	            orientation: "bottom"
	    	
	    });
	  });
  
   
   </script>
	    
</html>
