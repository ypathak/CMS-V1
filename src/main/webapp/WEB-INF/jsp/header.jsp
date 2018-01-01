<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="main-header">
   <c:url var="logout" value="/logout"></c:url>
   <sec:authentication property="principal.username" var="uname" />
   <!-- Logo -->
   <a href="javascript:void(0);" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>CMS</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>CMS</b></span>
   </a>
   <!-- Header Navbar: style can be found in header.less -->
   <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
      <span class="sr-only">Toggle navigation</span>
      </a>
      <div class="navbar-custom-menu">
         <ul class="nav navbar-nav">
            <li>
               <a href="java:script(0);">Welcome To CMS, ${uname}</a>
            </li>
            <li>
               <a href="${logout}"><i class="fa fa-sign-out" aria-hidden="true"></i></a>
            </li>
         </ul>
      </div>
   </nav>
</header>