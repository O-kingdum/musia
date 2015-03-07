<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.siteTitle}</title>
<!-- vendor css -->
<link rel="stylesheet" type="text/css"
  href="${pageContext.request.contextPath}/css/vendor/reset.css">
<link rel="stylesheet" type="text/css"
  href="${pageContext.request.contextPath}/css/vendor/text.css">
<link rel="stylesheet" type="text/css"
  href="${pageContext.request.contextPath}/css/vendor/960.css">
<link rel="stylesheet" type="text/css"
  href="${pageContext.request.contextPath}/css/vendor/datatable.css">
<!-- css -->
<link rel="stylesheet" type="text/css" href="${param.templateCss}">
<link rel="stylesheet" type="text/css" href="${param.mainCss}">
<!-- vendor js -->
<script type="text/javascript"
  src="${pageContext.request.contextPath}/js/vendor/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
  src="${pageContext.request.contextPath}/js/vendor/jquery.mixitup.js"></script>
<script type="text/javascript"
  src="${pageContext.request.contextPath}/js/vendor/datatable.min.js"></script>
<script type="text/javascript"
  src="${pageContext.request.contextPath}/js/vendor/angular.min.js"></script>
<!-- js -->
<script type="text/javascript"
  src="${pageContext.request.contextPath}/js/birthday.js"
  charset="utf-8"></script>
</head>
<body>
  <div class="container_12">
    <jsp:include page="header.jsp" />
    <jsp:include page="nav.jsp" />
    <main class="main">${param.pageContents}</main>
    <jsp:include page="footer.jsp" />
  </div>
</body>
</html>
