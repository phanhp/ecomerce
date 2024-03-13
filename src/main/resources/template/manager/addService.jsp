<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
<jsp:include page="/template/include/management/css-page.jsp" />
<jsp:include page="/template/include/management/js-page.jsp" />
</head>
<body
	class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
	<div class="page-wrapper">
		<jsp:include page="/WEB-INF/pages/include/management/header-page.jsp"></jsp:include>

		<div class="page-container">
			<jsp:include page="/template/include/management/menu-page.jsp"></jsp:include>
			<!-- start page content -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="page-bar">
						<div class="page-title-breadcrumb">
							<div class=" pull-left">
								<div class="page-title">Add Service</div>
							</div>
							<ol class="breadcrumb page-breadcrumb pull-right">
								<li><i class="fa fa-home"></i>&nbsp;<a class="parent-item"
									href="index.html">Home</a>&nbsp;<i class="fa fa-angle-right"></i>
								</li>
								<li><a class="parent-item" href="">Room Category</a>&nbsp;<i
									class="fa fa-angle-right"></i></li>
								<li class="active">Add Service</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="card-box">
								<div class="card-head">
									<header>Add Service</header>
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
								<spring:form action="doAddService" method="post"
									modelAttribute="service" enctype="multipart/form-data">
									<div class="card-body row">
										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="name" />
												<spring:errors path="name" cssStyle="color: red" />
												<label class="mdl-textfield__label">Service Name</label>
											</div>
										</div>
										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="openTime" />
												<spring:errors path="openTime" cssStyle="color: red" />
												<label class="mdl-textfield__label">Open Time</label>
											</div>
										</div>
										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input class="mdl-textfield__input" path="location" />
												<spring:errors path="location" cssStyle="color: red" />
												<label class="mdl-textfield__label">Location</label>
											</div>
										</div>
										<div class="col-lg-6 p-t-20">
											<div
												class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label txt-full-width">
												<spring:input cssClass="mdl-textfield__input" path="price"
													id="txtRoomNo" pattern="-?[0-9]*(\.[0-9]+)?" />
												<label class="mdl-textfield__label">Price</label>
												<spring:errors path="price" cssStyle="color: red" />
												<span class="mdl-textfield__error">Number required!</span>
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
													<spring:errors path="status" cssStyle="color: red" />
												</div>
											</div>
										</div>
										<div class="col-lg-6 p-t-20"></div>
										<label class="control-label col-md-3">Upload Room
											Photos</label>
										<div class="col-lg-12 p-t-20">
											<spring:input path="images" type="file" multiple="multiple"
												cssClass="dropzone" />
										</div>
										<div class="col-lg-12 p-t-20">
											<div class="mdl-textfield mdl-js-textfield txt-full-width">
												<spring:textarea path="description"
													cssClass="mdl-textfield__input" rows="3" id="education" />
												<spring:errors path="description" cssStyle="color: red" />
												<label class="mdl-textfield__label" for="text7">Description</label>
											</div>
										</div>
										<div class="col-lg-12 p-t-20 text-center">
											<input type="submit" value="Add"
												class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 m-r-20 btn-pink" />
											<a href="viewService">
												<button type="button"
													class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect m-b-10 btn-default">Cancel</button>
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
	</div>
</body>
</html>