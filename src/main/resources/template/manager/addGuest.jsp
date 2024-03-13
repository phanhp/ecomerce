<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guests</title>
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
								<div class="page-title">Add Guest</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="">Booking</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">Guests</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<div class="card-head">
									<header>Guests</header>
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
								<spring:form action="doAddServiceBooking" method="post"
									modelAttribute="bookingDetail">
									<div class="form-body">
										<spring:hidden path="id" />
										<spring:hidden path="booking.id" />
										<div class="col-lg-2 col-md-2 col-sm-2 col-2">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="booking.id"
													readonly="true" />

												<label class="mdl-textfield__label">Booking Number</label>
											</div>
										</div>
										<div class="col-lg-2 col-md-2 col-sm-2 col-2">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input"
													path="room.roomNumber" readonly="true" />

												<label class="mdl-textfield__label">Room Number</label>
											</div>
										</div>
									</div>
								</spring:form>

								<div class="card-body">
									<div class="col-lg-2">
										<button id="btn" class="btn btn-info">Add New</button>
									</div>

									<div>
										<spring:form
											action="doAddGuest?bookingDetailId=${bookingDetail.id}"
											method="post" modelAttribute="guest" id="formService">
											<div class="card-body row">
												<spring:input path="id" hidden="true" />
												<div class="col-lg-6 p-t-20">
													<div
														class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
														<spring:input class="mdl-textfield__input" path="fullName" />
														<label class="mdl-textfield__label">Name</label>
													</div>
												</div>

												<div class="col-lg-6 p-t-20">
													<div
														class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
														<spring:input class="mdl-textfield__input" path="idCard" />
														<label class="mdl-textfield__label">idCard</label>
													</div>
												</div>

												<div class="col-lg-6 p-t-20">
													<div
														class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
														<spring:input class="mdl-textfield__input"
															path="phoneNumber" />

														<label class="mdl-textfield__label">Phone Number</label>
													</div>
												</div>

												<div class="col-lg-6 p-t-20">
													<div
														class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
														<spring:input class="mdl-textfield__input" path="address" />

														<label class="mdl-textfield__label">Address</label>
													</div>
												</div>

												<div class="col-lg-12 p-t-20 text-center">
													<input type="submit" value="Save"
														class="mdl-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink " />
												</div>
											</div>
										</spring:form>
									</div>
								</div>
								<div class="table-scrollable">
									<table
										class="table table-hover table-checkable order-column full-width"
										id="example4">
										<thead>
											<tr>
												<th class="center">Name</th>
												<th class="center">Address</th>
												<th class="center">idCard</th>
												<th class="center">Phone Number</th>
												<th class="center">Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${guestList }" var="item">
												<tr>
													<td class="center">${item.fullName }</td>
													<td class="center">${item.address }</td>
													<td class="center">${item.idCard }</td>
													<td class="center">${item.phoneNumber }</td>
													<td class="center"><a
														href="updateGuest?id=${item.id }&bookingDetailId=${bookingDetail.id}">
															<button type="button" class="btn btn-primary">Update</button>
													</a> <a
														href="deleteGuest?id=${item.id }&bookingDetailId=${bookingDetail.id}">
															<button type="button" class="btn btn-warning">Remove</button>

													</a></td>
												</tr>

											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-md-6 col-sm-6 col-6">
									<!-- <div class="btn-group">
												<a href="addServiceforBooking" id="addRow" class="btn btn-info">
													Add New <i class="fa fa-plus"></i>
												</a>
											</div> -->
								</div>
								<div class="col-lg-12 p-t-20 text-center">
									<a href="bookingDetail?id=${bookingDetail.id }">
										<button type="button"
											class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-default">Cancel</button>
									</a>
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


</body>
<script type="text/javascript">

const btn = document.getElementById('btn');

const form = document.getElementById('formService');

form.style.display = 'none'

btn.addEventListener('click', () => {
   
  if (form.style.display === 'none') {
    // this SHOWS the form
    form.style.display = 'block';
  } else {
    // this HIDES the form
    form.style.display = 'none';
  }
});
</script>

</html>