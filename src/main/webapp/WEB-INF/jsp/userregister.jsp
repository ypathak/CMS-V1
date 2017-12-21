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
		 <c:url	value="/a/rurl" var="registerURL" />


		<div class="form-group has-feedback">
		
			<div class="row">
				<div class="col-md-6">
				
					
<div class="box box-primary">
	<div class="box-header with-border">
	  <h3 class="box-title">Register an User</h3>
	</div>
	<!-- /.box-header -->
	<div class="box-body">
	
<form:form method="POST" modelAttribute="Empdata"
							action="${registerURL}">
							<div class="form-group has-feedback">
							    
								<form:input class="form-control" placeholder="First name" type="text" path="firstname"/>
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
								 <span><form:errors path="firstname" cssClass="error"/></span>
							</div>
							<div class="form-group has-feedback">
								<form:input class="form-control" placeholder="Last name" type="text" path="lastname"/>
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
								<span><form:errors path="lastname" cssClass="error" /></span>
							</div>
							<div class="form-group has-feedback">
								<form:input class="form-control" placeholder="Email" type="email" path="email"/>
								<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
								 <span><form:errors path="email" cssClass="error" /></span>
							</div>
							<div class="form-group has-feedback">
								<form:input class="form-control" placeholder="User name" type="text" path="username"/>
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
								</span> <form:errors path="username" cssClass="error" /></span>
							</div>
							<div class="form-group has-feedback">
								<form:input class="form-control" placeholder="Password"
									type="password" path="password"/> 
									<span class="glyphicon glyphicon-lock form-control-feedback"></span>
									</span> <form:errors path="password" cssClass="error" /></span>
							</div>
					       <div class="form-group has-feedback">
								<form:input class="form-control" placeholder="createdBy" type="hidden" path="createdBy" value="${uname }"/>
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
								
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
</html>