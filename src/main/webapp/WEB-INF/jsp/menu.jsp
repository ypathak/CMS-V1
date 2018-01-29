<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<aside class="main-sidebar">
   <!-- sidebar: style can be found in sidebar.less -->
   <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
            <sec:authorize access="hasRole('SUPER_ADMIN')">
            	 <li>
            	 		<a href="${pageContext.request.contextPath}/s/d"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a>
            	 </li>
            	 <li>
            	 		<a href="${pageContext.request.contextPath}/s/a/r/p"><i class="fa fa-user-o"></i> <span>Register Admin</span></a>
            	 </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
            	<li>
            	 		<a href="documentation/index.html"><i class="fa fa-book"></i> <span>Dashboard</span></a>
            	 </li>
            	 <li class="active">
            	 		<a href="${pageContext.request.contextPath}/a/regi"><i class="fa fa-circle-o"></i> <span>Register User</span></a>
            	 </li>
            	 <li>
            	 		<a href="${pageContext.request.contextPath}/a/clnt"><i class="fa fa-circle-o"></i> <span>Add Client</span></a>
            	 </li>
            </sec:authorize>
      </ul>
   </section>
   <!-- /.sidebar -->
</aside>