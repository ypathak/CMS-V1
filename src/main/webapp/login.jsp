<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
   <body class="hold-transition login-page">
      <div class="login-box">
         <div class="login-logo">
            <a href="../../index2.html"><b>Admin</b>LTE</a>
         </div>
         <!-- /.login-logo -->
         <div class="login-box-body">
            <p class="login-box-msg">Sign in to start your session</p>
            <form name='f' action="auth" method="post" onsubmit="return applogin.validate();">
               <c:if test="${param.error != null}">
                  <div id="error">
                     <!-- <spring:message code="message.badCredentials">   
                        </spring:message> -->
                     Invalid username or password
                  </div>
               </c:if>
               <div class="form-group has-feedback devDivUsername" >
                  <input type="text" class="form-control" placeholder="Email / User Name" id="username" name="username">
                  <span class="glyphicon glyphicon-user form-control-feedback"></span>
               </div>
               <div class="form-group has-feedback devDivPassword">
                  <input type="password" class="form-control" placeholder="Password" id="password" name="password">
                  <span class="glyphicon glyphicon-lock form-control-feedback"></span>
               </div>
               <div class="row">
                  <div class="col-xs-8">
                     <!-- <div class="checkbox icheck">
                        <label>
                          <input type="checkbox"> Remember Me
                        </label>
                        </div> -->
                  </div>
                  <!-- /.col -->
                  <div class="col-xs-4">
                     <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                  </div>
                  <!-- /.col -->
               </div>
            </form>
            <!--  <div class="social-auth-links text-center">
               <p>- OR -</p>
               <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using
                 Facebook</a>
               <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using
                 Google+</a>
               </div> -->
            <!-- /.social-auth-links -->
            <!-- <a href="#">I forgot my password</a><br>
               <a href="register.html" class="text-center">Register a new membership</a> -->
         </div>
         <!-- /.login-box-body -->
      </div>
      <!-- /.login-box -->
      <!-- jQuery 2.2.3 -->
      <script
         src="${pageContext.request.contextPath}/resources/theme/dist/js/jquery.min.js"></script>
      <!-- Bootstrap 3.3.7 -->
      <script
         src="${pageContext.request.contextPath}/resources/theme/dist/js/bootstrap.min.js"></script>
      <!-- iCheck -->
      <script
         src="${pageContext.request.contextPath}/resources/theme/plugins/iCheck/icheck.min.js"></script>
      <script>
         $(function () {
           $('input').iCheck({
             checkboxClass: 'icheckbox_square-blue',
             radioClass: 'iradio_square-blue',
             increaseArea: '20%' // optional
           });
         });
      </script>
      <script type="text/javascript">
         var applogin = {
         		validate: function(){
         			$(".devDivUsername").removeClass('has-error')
         			$(".devDivPassword").removeClass('has-error')
         			if (document.f.username.value == "" && document.f.password.value == "") {
         				document.f.username.focus();
         				$(".devDivUsername").addClass('has-error')
         				$(".devDivPassword").addClass('has-error')
         				return false;
         			}
         			if (document.f.username.value == "") {
         				document.f.username.focus();
         				$(".devDivUsername").addClass('has-error')
         				return false;
         			}
         			if (document.f.password.value == "") {
         				document.f.password.focus();
         				$(".devDivPassword").addClass('has-error')
         				return false;
         			}
         		}
         }
      </script>
   </body>
</html>