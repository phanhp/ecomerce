<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Category</title>
<jsp:include page="/template/include/management/css-page.jsp" />
<jsp:include page="/template/include/management/js-page.jsp" />
</head>
<body
	class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
	
	<div class="page-wrapper">
		<jsp:include page="/template/include/management/header-page.jsp"></jsp:include>

		<div class="page-container">
			<jsp:include page="/template/include/management/menu-page.jsp"></jsp:include>
			<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Room Category</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="">Room Category</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">View Room Category</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="card card-box">
								<div class="card-head">
									<header>Room Category</header>
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

									<div class="row p-b-20">
										<div class="col-sm-6 col-md-6">
											<div>
												<form action="searchCategory" method="get">
													<input type="text" name="search" placeholder="Enter a name category"> <input
														type="submit" value="search">
												</form>
											</div>
										</div>
									</div>
									
									<div class="table-scrollable">
										<table
											class="table table-hover table-checkable order-column full-width"
											id="example4">
											<thead>
												<tr>
													
													<th class="center">Image</th>
													<th class="center">Name</th>
													<th class="center">Size</th>
													<th class="center">Bed Info</th>
													<th class="center">Capacity</th>
													<th class="center">Price</th>
													<th class="center">Create Date</th>
													<th class="center">Status</th>
													<th class="center">Description</th>
													<th class="center">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${roomCategoryList }" var="item">
													<tr>
														
														<td class="user-circle-img"><c:forEach
																items="${item.imageEntities }" var="image" end="0">
																<img width="100"
																	src="<c:url value="/resources-management/assets/img/${image.name}"/>" />
															</c:forEach></td>
														<td class="center">${item.name }</td>
														<td class="center">${item.size }</td>
														<td class="center">${item.bedInfo }</td>
														<td class="center">${item.capacity }</td>
														<td class="center">$${item.price }</td>
														<td class="center">${item.createDate }</td>
														<td class="center">${item.status }</td>
														<td class="center">${item.description }</td>
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
		<jsp:include page="/template/include/management/footer-page.jsp"></jsp:include>
	</div>

</body>
</html>