<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- start sidebar menu -->
 			<div class="sidebar-container">
 				<div class="sidemenu-container navbar-collapse collapse fixed-menu">
	                <div id="remove-scroll">
	                    <ul class="sidemenu page-header-fixed p-t-20" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
	                        <li class="sidebar-toggler-wrapper hide">
	                            <div class="sidebar-toggler">
	                                <span></span>
	                            </div>
	                        </li>
	                        <li class="sidebar-user-panel">
	                            <div class="user-panel">
	                                <div class="row">
                                            <div class="sidebar-userpic">
                                                <img src="<c:url value="/resources-management/assets/img/person_3.jpg"/>" class="img-responsive" alt=""> </div>
                                        </div>
                                        <div class="profile-usertitle">
                                            <div class="sidebar-userpic-name"></div>
                                            <div class="profile-usertitle-job"> Manager </div>
                                        </div>
                                        <div class="sidebar-userpic-btn">
									        <a class="tooltips" href="user_profile.html" data-placement="top" data-original-title="Profile">
									        	<i class="material-icons">person_outline</i>
									        </a>
									        <a class="tooltips" href="email_inbox.html" data-placement="top" data-original-title="Mail">
									        	<i class="material-icons">mail_outline</i>
									        </a>
									        <a class="tooltips" href="chat.html" data-placement="top" data-original-title="Chat">
									        	<i class="material-icons">chat</i>
									        </a>
									        <a class="tooltips" href="<c:url value="/logout" />" data-placement="top" data-original-title="Logout">
									        	<i class="material-icons">input</i>
									        </a>
									    </div>
	                            </div>
	                        </li>
	                        <li class="menu-heading">
			                	<span>-- Main</span>
			                </li>
	                        <!-- <li class="nav-item start active">
	                            <a href="#" class="nav-link nav-toggle">
	                                <i class="material-icons">dashboard</i>
	                                <span class="title">Dashboard</span>
                                	<span class="selected"></span>
                                	<span class="arrow open"></span>
	                            </a>
	                            <ul class="sub-menu">
	                                <li class="nav-item active">
	                                    <a href="index.html" class="nav-link ">
	                                        <span class="title">Dashboard 1</span>
	                                        <span class="selected"></span>
	                                    </a>
	                                </li>
	                                <li class="nav-item ">
	                                    <a href="dashboard2.html" class="nav-link ">
	                                        <span class="title">Dashboard 2</span>
	                                    </a>
	                                </li>
	                            </ul>
	                        </li> -->
	                        <li class="nav-item start active">
	                            <a href="#" class="nav-link nav-toggle">
	                                <i class="material-icons">business_center</i>
	                                <span class="title">Booking</span>
	                                <span class="selected"></span>
	                                <span class="arrow open"></span>
	                            </a>
	                            <ul class="sub-menu">
	                                <li class="nav-item active">
	                                    <a href="viewBooking" class="nav-link ">
	                                        <span class="title">View Booking</span>
	                                        <span class="selected"></span>
	                                    </a>
	                                </li>
	                                
	                            </ul>
	                        </li>
	                        <li class="nav-item">
	                            <a href="#" class="nav-link nav-toggle">
	                                <i class="material-icons">vpn_key</i>
	                                <span class="title">Room Category</span>
	                                <span class="arrow"></span>
	                            </a>
	                            <ul class="sub-menu">
	                                <li class="nav-item">
	                                    <a href="addCategory" class="nav-link ">
	                                        <span class="title">Add Room Category</span>
	                                    </a>
	                                </li>
	                                <li class="nav-item">
	                                    <a href="viewCategory" class="nav-link ">
	                                        <span class="title">View Room Category</span>
	                                    </a>
	                                </li>	                               
	                            </ul>
	                        </li>
	                      <li class="nav-item">
	                            <a href="#" class="nav-link nav-toggle">
	                                <i class="material-icons">vpn_key</i>
	                                <span class="title">Rooms</span>
	                                <span class="arrow"></span>
	                            </a>
	                            <ul class="sub-menu">
	                                <li class="nav-item">
	                                    <a href="addRoom" class="nav-link ">
	                                        <span class="title">Add Room Details</span>
	                                    </a>
	                                </li>
	                                <li class="nav-item">
	                                    <a href="viewRoom" class="nav-link ">
	                                        <span class="title">View All Rooms</span>
	                                    </a>
	                                </li>                                
	                            </ul>
	                        </li>
	                        <li class="nav-item">
	                            <a href="#" class="nav-link nav-toggle">
	                                <i class="material-icons">vpn_key</i>
	                                <span class="title">Services</span>
	                                <span class="arrow"></span>
	                            </a>
	                            <ul class="sub-menu">
	                                <li class="nav-item">
	                                    <a href="addService" class="nav-link ">
	                                        <span class="title">Add Service</span>
	                                    </a>
	                                </li>
	                                <li class="nav-item">
	                                    <a href="viewService" class="nav-link ">
	                                        <span class="title">View Services</span>
	                                    </a>
	                                </li>                                
	                            </ul>
	                        </li>
	                        <li class="nav-item">
	                            <a href="#" class="nav-link nav-toggle">
	                                <i class="material-icons">vpn_key</i>
	                                <span class="title">Promotion</span>
	                                <span class="arrow"></span>
	                            </a>
	                            <ul class="sub-menu">
	                                <li class="nav-item">
	                                    <a href="addPromotion" class="nav-link ">
	                                        <span class="title">Add Promotion</span>
	                                    </a>
	                                </li>
	                                <li class="nav-item">
	                                    <a href="viewPromotion" class="nav-link ">
	                                        <span class="title">View Promotion</span>
	                                    </a>
	                                </li>	                               
	                            </ul>
	                        </li>	                        
	                    </ul>
	                </div>
                </div>
            </div>
            <!-- end sidebar menu --> 