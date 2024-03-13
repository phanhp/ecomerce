

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="<c:url value="resources/image/favicon.png" />" type="image/png">
        <title>Royal Hotel</title>
        <jsp:include page="/template/include/user/css-page.jsp" />
    </head>
    <body>
       <jsp:include page="/template/include/user/header-page.jsp" />
       <jsp:include page="/template/include/user/banner-page.jsp" />
       <jsp:include page="/template/include/user/accomodation.jsp" />
       <jsp:include page="/template/include/user/facilities.jsp" />
       <jsp:include page="/template/include/user/abouthistory.jsp" />
       <jsp:include page="/template/include/user/testimonial.jsp" />
       <jsp:include page="/template/include/user/latestblog.jsp" />
       <jsp:include page="/template/include/user/footer-page.jsp" />
       <jsp:include page="/template/include/user/js-page.jsp" />
       </body>
</html>
