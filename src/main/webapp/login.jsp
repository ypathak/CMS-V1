<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Log in</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/theme/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/theme/dist/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/theme/dist/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/theme/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/theme/plugins/iCheck/square/blue.css">



<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<b>Admin</b>
		</div>

		<div class="login-box-body">
			<c:url var="auth" value="/auth"></c:url>
			<form action="${auth}" method="post">

				<c:if test="${param.error != null}">
				
					<div class="form-group has-error has-feedback">
					<label for="username">Username</label>
					</td> <input type="text" id="username" name="username"
						class="form-control">
					</td>
						<span class="help-block"><p>UserName Field is Required</p></span>
					</div>
					<div class="form-group has-error has-feedback">
							<label for="password">Password </label>
					</td> <input type="password" id="password" name="password"
						class="form-control">
					</td>
						<span class="help-block"><p>Password Field is Required</p></span>
					</div>

				</c:if>
				<c:if test="${param.logout != null}">
				 You have been logout
    
               </c:if>

	<c:if test="${param.error == null}">
				<div class="form-group has-feedback">
                          
			
					<label for="username">Username</label>
					</td> <input type="text" id="username" name="username"
						class="form-control">
					</td>


				</div>
				<div class="form-group has-feedback">

					<label for="password">Password </label>
					</td> <input type="password" id="password" name="password"
						class="form-control">
					</td>


				</div>
				</c:if>
				<div class="row">
					<div class="col-xs-4">
                   



						<!-- <td><input type="submit" value="login"></td> -->
						<input type="submit" class="btn btn-primary btn-block btn-flat"
							value="submit">
						</button>

						<!-- <td><a href="register">Click here for register</a></td> -->

					</div>
				</div>

			</form>
		</div>
	</div>
</body>
<script
	src="${pageContext.request.contextPath}/resources/theme/dist/js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script
	src="${pageContext.request.contextPath}/resources/theme/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script
	src="${pageContext.request.contextPath}/resources/theme/plugins/iCheck/icheck.min.js"></script>
<script>
</html>