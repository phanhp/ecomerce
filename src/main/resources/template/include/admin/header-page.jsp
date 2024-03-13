<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner ">
		<!-- logo start -->
		<div class="page-logo">
			<a href="index.html"> <%-- <img alt="" width="20"
				src="<c:url value="/resources-management/assets/img/logo-big.png"/>"> --%>
				<span class="logo-default">Management</span>
			</a>
		</div>
		<!-- logo end -->
		<ul class="nav navbar-nav navbar-left in">
			<li><a href="#" class="menu-toggler sidebar-toggler"><i
					class="icon-menu"></i></a></li>
		</ul>
		<!-- start mobile menu -->
		<a href="javascript:;" class="menu-toggler responsive-toggler"
			data-toggle="collapse" data-target=".navbar-collapse"> <span></span>
		</a>
		<!-- end mobile menu -->
		<!-- start header menu -->
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<!-- start notification dropdown -->
				
				
				<!-- start manage user dropdown -->
				<li class="dropdown dropdown-user"><a href="javascript:;"
					class="dropdown-toggle" data-toggle="dropdown"
					data-hover="dropdown" data-close-others="true"> <img alt=""
						class="img-circle " src="<c:url value="/resources-management/assets/img/person_5.jpg"/> "/> <span
						class="username username-hide-on-mobile"> Admin </span> <i
						class="fa fa-angle-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-menu-default animated jello">
						<li><a href="user_profile.html"> <i class="icon-user"></i>
								Profile
						</a></li>
						<li><a href="#"> <i class="icon-settings"></i> Settings
						</a></li>
						<li><a href="#"> <i class="icon-directions"></i> Help
						</a></li>
						<li class="divider"></li>
						<li><a href="lock_screen.html"> <i class="icon-lock"></i>
								Lock
						</a></li>
						<li><a href="<c:url value="/logout" />"> <i class="icon-logout"></i> Log
								Out
						</a></li>
					</ul></li>
				<!-- end manage user dropdown -->
				<li class="dropdown dropdown-quick-sidebar-toggler"><a
					id="headerSettingButton"
					class="mdl-button mdl-js-button mdl-button--icon pull-right"
					data-upgraded=",MaterialButton"> <i class="material-icons">settings</i>
				</a></li>
			</ul>
		</div>
	</div>
</div>