<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.siteTitle}</title>
<link rel="stylesheet" type="text/css" href="${param.resetCss}">
<link rel="stylesheet" type="text/css" href="${param.templateCss}">
<link rel="stylesheet" type="text/css" href="${param.mainCss}">
</head>
<body>
  <div class="wrapper">
    <main class="main">${param.pageContents}</main>
  </div>
</body>
</html>
