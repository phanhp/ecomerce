<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<jsp:include page="/template/include/admin/css-page.jsp" />
<jsp:include page="/template/include/admin/js-page.jsp" />
</head>
<body
	class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
	<div class="page-wrapper">
		<jsp:include page="/template/include/admin/header-page.jsp"></jsp:include>

		<div class="page-container">
			<jsp:include page="/template/include/admin/menu-page.jsp"></jsp:include>
			<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">All Account</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="">Manage Account</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">View Account</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="card card-box">
								<div class="card-head">
									<header>Manage Account</header>
									<div class="tools">
										<a class="fa fa-repeat btn-color box-refresh"
											href="javascript:;"></a> <a
											class="t-collapse btn-color fa fa-chevron-down"
											href="javascript:;"></a> <a
											class="t-close btn-color fa fa-times" href="javascript:;"></a>
									</div>
								</div>
								<div class="card-body ">
									<div class="row p-b-20">
										<div class="col-md-6 col-sm-6 col-6">
											<div class="btn-group">
												<a href="addCategory" id="addRow" class="btn btn-info">
													Add New <i class="fa fa-plus"></i>
												</a>
											</div>
										</div>
										<form action="searchCategory" method="get">
											<input type="text" name="search"> <input
												type="submit" value="search">
										</form>
										<div class="col-md-6 col-sm-6 col-6">
											<div class="btn-group pull-right">
												<a class="btn deepPink-bgcolor  btn-outline dropdown-toggle"
													data-toggle="dropdown">Tools <i
													class="fa fa-angle-down"></i>
												</a>
												<ul class="dropdown-menu pull-right">
													<li><a href="javascript:;"> <i class="fa fa-print"></i>
															Print
													</a></li>
													<li><a href="javascript:;"> <i
															class="fa fa-file-pdf-o"></i> Save as PDF
													</a></li>
													<li><a href="javascript:;"> <i
															class="fa fa-file-excel-o"></i> Export to Excel
													</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="table-scrollable">
										<table
											class="table table-hover table-checkable order-column full-width"
											id="example4">
											<thead>
												<tr>
													<th class="center">Id</th>
													<th class="center">Email</th>
													<th class="center">Name</th>
													<th class="center">Gender</th>
													<th class="center">BirthDay</th>
													<th class="center">Address</th>
													<th class="center">Phone Number</th>
													<th class="center">Status</th>
													<th class="center">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${userList }" var="item">
													<tr>
														<td class="center">${item.id }</td>
														<td class="center">${item.email }</td>
														<td class="center">${item.fullName }</td>
														<td class="center">${item.gender }</td>
														<td class="center">${item.birthDate }</td>
														<td class="center">${item.address }</td>
														<td class="center">${item.phoneNumber }</td>
														<td class="center">${item.status }</td>

														<td class="center"><a
															href="updateCategory?id=${item.id }"
															class="btn btn-tbl-edit btn-xs"> <i
																class="fa fa-pencil"></i>
														</a> <a href="deleteCategory?id=${item.id }"
															class="btn btn-tbl-delete btn-xs"> <i
																class="fa fa-trash-o "></i>
														</a></td>
													</tr>

												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end page content -->
		</div>
		<jsp:include page="/template/include/admin/footer-page.jsp"></jsp:include>
	</div>

</body>
</html>