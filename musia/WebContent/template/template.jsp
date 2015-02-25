<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.siteTitle}</title>
<link rel="stylesheet" type="text/css" href="${param.resetCss}">
</head>
<body>
  <div class="wrapper">
    <jsp:include page="../template/header.jsp" />
    <main class="main">${param.pageContents}</main>
    <jsp:include page="../template/footer.jsp" />
  </div>
</body>
</html>
