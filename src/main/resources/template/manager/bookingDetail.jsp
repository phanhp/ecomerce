<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
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
								<div class="page-title">Booking Details</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="">Booking</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">Booking Details</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<div class="card-head">
									<header>Booking Details</header>
									<button id="panel-button"
										class="mdl-button mdl-js-button mdl-button--icon pull-right"
										data-upgraded=",MaterialButton">
										<i class="material-icons">more_vert</i>
									</button>
									<ul
										class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
										data-mdl-for="panel-button">
										<li class="mdl-menu__item"><i class="material-icons">assistant_photo</i>Action</li>
										<li class="mdl-menu__item"><i class="material-icons">print</i>Another
											action</li>
										<li class="mdl-menu__item"><i class="material-icons">favorite</i>Something
											else here</li>
									</ul>
								</div>
								<spring:form action="saveBookingDetail" method="post" modelAttribute="booking"
									enctype="multipart/form-data">
									<div class="card-body row">
										<spring:hidden path="id" />

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="fullName"
													readonly="true" />

												<label class="mdl-textfield__label">Name</label>
											</div>
										</div>
										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input"
													path="phoneNumber" readonly="true" />

												<label class="mdl-textfield__label">Phone Number</label>
											</div>
										</div>

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="email"
													readonly="true" />

												<label class="mdl-textfield__label">Email</label>
											</div>
										</div>

										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input"
													path="bookingDate" readonly="true"/>

												<label class="mdl-textfield__label">Booking Date</label>
											</div>
										</div>
										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="checkIn"
													readonly="true" />

												<label class="mdl-textfield__label">Check In </label>
											</div>
										</div>
										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="checkOut"
													readonly="true" />

												<label class="mdl-textfield__label">Check Out</label>
											</div>
										</div>
										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<div class="form-group">
													<spring:select path="status" cssClass="form-control">
														<spring:option value="">Select</spring:option>
														<spring:options items="${status}" />
													</spring:select>

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
														<th class="center">Room Number</th>
														<th class="center">Price</th>
														<th class="center">Room Type</th>
														<th class="center">Service</th>
														<th class="center">Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${bookingDetailList }" var="item">
														<tr>
															<td class="center"><c:forEach
																	items="${item.room.roomCategory.imageEntities }"
																	var="image" end="0">
																	<img width="100"
																		src="<c:url value="/resources-management/assets/img/${image.name}"/>" />
																</c:forEach></td>
															<td class="center">${item.room.roomNumber }</td>
															<td class="center">$${item.room.roomCategory.price }</td>
															<td class="center">${item.room.roomCategory.name }</td>

																<td class="center">
																<ul>
																
																<c:forEach items="${item.serviceBookings }" var="sv"><li>${sv.service.name } </li> </c:forEach>
																	</ul></td>
															<td class="center"><a
																href="addServiceBooking?id=${item.id }">
																	<button type="button" class="btn btn-primary">Add
																		Service</button>
															</a> <a href="addGuest?id=${item.id }">
																	<button type="button" class="btn btn-success">Add
																		Guest</button>
															</a></td>

														</tr>

													</c:forEach>
												</tbody>
											</table>
										</div>

										<div class="col-lg-12 p-t-20 text-center">
											<input type="submit" value="Save"
												class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink" />
											<a href="viewBooking">
												<button type="button"
													class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-default">Return Booking View</button>
											</a>
										</div>
									</div>
								</spring:form>
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