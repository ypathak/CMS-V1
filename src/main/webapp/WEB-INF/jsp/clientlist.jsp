<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>




<script src="${pageContext.request.contextPath}/resources/js/client.js"></script>
<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<style type="text/css">
#divdisplay {
	width: 170%;
	height: 100%;
	opacity: .95;
	top: 0;
	left: 0;
	display: none;
	position: absolute;
	background-color: #313131;
	overflow: auto;
	margin-top: 50px
}

#popupform {
	position: absolute;
	margin-left: 250px;
	font-family: 'Raleway', sans-serif
}

#clientdata {
	max-width: 600px;
	min-width: 500px;
	padding: 10px 50px;
	border: 2px solid gray;
	border-radius: 10px;
	font-family: raleway;
	background-color: #fff
}

.close { 
color: red; 
opacity: 1; 
 display:block;
    float:right;
    width:30px;
    height:29px;
    background:url(https://web.archive.org/web/20110126035650/http://digitalsbykobke.com/images/close.png) no-repeat center center;
}
.error {
	color: red;
}
</style>
</head>
<body>
	<div class="content-wrapper" style="min-height: 916.3px;">
		<!-- Content Header (Page header) -->
		
		<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">Client</h3>
						<a href="javascript:void(0)"
							class="btn btn-sm btn-info btn-flat pull-right"
							style="float: right;" onclick="client.addnewclient()">Add New
							Client</a>
					</div>
					
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example2_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-6"></div>
								<div class="col-sm-6"></div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<table id="example2"
										class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
										<thead>
											<tr role="row">
												<th class="sorting_desc" tabindex="0"
													aria-controls="example2" rowspan="1" colspan="1"
													aria-label="Rendering engine: activate to sort column ascending"
													aria-sort="descending">Client Name</th>
												<th class="sorting" tabindex="0" aria-controls="example2"
													rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending">Department</th>
												<th class="sorting" tabindex="0" aria-controls="example2"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending">Mobile
													Number</th>
												<th class="sorting" tabindex="0" aria-controls="example2"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending">Delete</th>
												<th class="sorting" tabindex="0" aria-controls="example2"
													rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending">Print</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${clientlist}" var="userForm">
												<tr role="row">
													<td><c:out value="${userForm.clientname}" /></td>
													<td><c:out value="${userForm.department}" /></td>
													<td><c:out value="${userForm.mobilenumber}" /></td>
													<td>Delete</td>
													<td>Edit</td>
												</tr>
											</c:forEach>
											<!-- <tr role="row" class="even">
                                          <td class="sorting_1">Webkit</td>
                                          <td>Safari 1.3</td>
                                          <td>OSX.3</td>
                                          <td>312.8</td>
                                          <td>A</td>
                                          </tr>
                                          <tr role="row" class="odd">
                                          <td class="sorting_1">Webkit</td>
                                          <td>Safari 2.0</td>
                                          <td>OSX.4+</td>
                                          <td>419.3</td>
                                          <td>A</td>
                                          </tr>
                                          <tr role="row" class="even">
                                          <td class="sorting_1">Webkit</td>
                                          <td>Safari 3.0</td>
                                          <td>OSX.4+</td>
                                          <td>522.1</td>
                                          <td>A</td>
                                          </tr>
                                          <tr role="row" class="odd">
                                          <td class="sorting_1">Webkit</td>
                                          <td>OmniWeb 5.5</td>
                                          <td>OSX.4+</td>
                                          <td>420</td>
                                          <td>A</td>
                                          </tr>
                                          <tr role="row" class="even">
                                          <td class="sorting_1">Webkit</td>
                                          <td>iPod Touch / iPhone</td>
                                          <td>iPod</td>
                                          <td>420.1</td>
                                          <td>A</td>
                                          </tr>
                                          <tr role="row" class="odd">
                                          <td class="sorting_1">Webkit</td>
                                          <td>S60</td>
                                          <td>S60</td>
                                          <td>413</td>
                                          <td>A</td>
                                          </tr>
                                          <tr role="row" class="even">
                                          <td class="sorting_1">Trident</td>
                                          <td>Internet Explorer 4.0</td>
                                          <td>Win 95+</td>
                                          <td>4</td>
                                          <td>X</td>
                                          </tr>
                                          <tr role="row" class="odd">
                                          <td class="sorting_1">Trident</td>
                                          <td>Internet Explorer 5.0</td>
                                          <td>Win 95+</td>
                                          <td>5</td>
                                          <td>C</td>
                                          </tr>
                                          <tr role="row" class="even">
                                          <td class="sorting_1">Trident</td>
                                          <td>Internet Explorer 5.5</td>
                                          <td>Win 95+</td>
                                          <td>5.5</td>
                                          <td>A</td>
                                          </tr> -->
										</tbody>
										<tfoot>
											<tr>
												<th rowspan="1" colspan="1">Client Name</th>
												<th rowspan="1" colspan="1">Department</th>
												<th rowspan="1" colspan="1">Mobile Number</th>
												<th rowspan="1" colspan="1">Delete</th>
												<th rowspan="1" colspan="1">Print</th>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-5">
									<div class="dataTables_info" id="example2_info" role="status"
										aria-live="polite">Showing 1 to 10 of 57 entries</div>
								</div>
								<div class="col-sm-7">
									<div class="dataTables_paginate paging_simple_numbers"
										id="example2_paginate">
										<ul class="pagination">
											<li class="paginate_button previous disabled"
												id="example2_previous"><a href="#"
												aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a></li>
											<li class="paginate_button active"><a href="#"
												aria-controls="example2" data-dt-idx="1" tabindex="0">1</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="2" tabindex="0">2</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="3" tabindex="0">3</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="4" tabindex="0">4</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="5" tabindex="0">5</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="6" tabindex="0">6</a></li>
											<li class="paginate_button next" id="example2_next"><a
												href="#" aria-controls="example2" data-dt-idx="7"
												tabindex="0">Next</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
			</div>
		</div>
		</section>
		
		<sec:authentication property="principal.username" var="uname" />
		<div class="content-wrapper" id="divdisplay">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<div class="form-group has-feedback">
				<div class="row">
					<div class="col-md-6">


						<!-- /.box-header -->
						<div class="box-body" id="popupform">
						
						<button type="button" onclick="client.closepopup()" 
						         class="close" data-dismiss="modal" aria-hidden="true">×</button>
						
							<form:form modelAttribute="clientdata"
								onsubmit="client.fromsubmit()" name="form1" action="${contextPath}">
								<div class="form-group has-feedback">
									<form:input class="form-control" placeholder="Client Name"
										type="text" path="clientname" autocomplete="off" />
									<span class="glyphicon glyphicon-user form-control-feedback"></span>
									<span id="client" style="color: red;"> </span>
								</div>
								<div class="form-group has-feedback">
									<form:input class="form-control" placeholder="PAN Number"
										type="text" path="pannumber" autocomplete="off"/>
									<span class="glyphicon glyphicon-user form-control-feedback"></span>
									<span id="pan" style="color: red;" /></span>
								</div>
								<div class="form-group has-feedback">
									<form:input class="form-control" placeholder="Adhar Number"
										type="text" path="adharnumber" autocomplete="off"/>
									<span class="glyphicon glyphicon-user form-control-feedback"></span>
									<span id="adhar" style="color: red;"></span>
								</div>
								<div class="form-group has-feedback">
									<form:input class="form-control" placeholder="Department"
										type="text" path="department" autocomplete="off"/>
									<span class="fa-building-o form-control-feedback"></span> <span
										style="color: red;" id="depart"></span>
								</div>
								<div class="form-group has-feedback">
									<form:input class="form-control" placeholder="DOB" type="text"
										path="dateofbirth" name="datepicker" autocomplete="off"/>
									<span class="fa fa-birthday-cake form-control-feedback"></span>
									<span> <span style="color: red;" id="dob"></span>
									</span>
								</div>
								<div class="form-group has-feedback">
									<form:input class="form-control" placeholder="Mobile Number"
										type="text" path="mobilenumber"
										oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" autocomplete="off"/>
									<span id="mobile" style="color: red;"> </span>
								</div>
								<div class="form-group has-feedback">
									<form:input class="form-control" placeholder="Phone Number"
										type="text" path="phonenumber"
										oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" autocomplete="off"/>
									<span id="phone" style="color: red;"> </span>
								</div>
								<div class="row">
									<div class="col-xs-8">
										<div class="checkbox icheck">
											<label class=""> </label>
										</div>
									</div>
									<!-- /.col -->
									<div class="col-xs-4">
										<button type="submit"
											class="btn btn-primary btn-block btn-flat">Register</button>
									</div>
									<!-- /.col -->
									<form:hidden path="createdBy" value="${uname }" />

								</div>
							</form:form>
						</div>

						<!-- /.box -->
					</div>
					<div class="col-md-6"></div>
				</div>
			</div>
			</section>
			
			<!-- /.content -->
		</div>
	</div>
</body>
<script>
      $(function() {
          $( "#dateofbirth" ).datepicker({
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
