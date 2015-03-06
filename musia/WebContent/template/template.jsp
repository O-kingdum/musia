<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.siteTitle}</title>
<link rel="stylesheet" type="text/css" href="${param.resetCss}">
<link rel="stylesheet" type="text/css" href="${param.templateCss}">
<link rel="stylesheet" type="text/css" href="${param.mainCss}">

<link rel="stylesheet" type="text/css" href="${param.datableCss}">
<script src="${param.jqueryJs}" type="text/javascript" charset="utf-8"></script>
<script src="${param.datableJs}" type="text/javascript" charset="utf-8"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<script>
 $(function(){
 
   var now_year = new Date().getFullYear();
    
   for (var i = now_year - 100; i <= now_year ;i++) {
    $(".year").append("<option value='"+i+"'>"+i+"</option>");
   }
 
   for (var i = 1; i <= 12 ;i++) {
    $(".month").append("<option value='"+i+"'>"+i+"</option>");
   }
   
  //月日に応じて日数を決める
  $(".date").change(function () {
    
   var year  = $("[name=year]   option:selected").val();
   var month = $("[name=month]  option:selected").val();
   var day   = new Date(year, month, 0).getDate();
 
   $(".day").empty();
   $(".day").append("<option value='0'>---</option>");
 
   for (var i = 1; i <= day ;i++) {
    $(".day").append("<option value='"+i+"'>"+i+"</option>");
   }
    
  });
 
 });
</script>

</head>
<body>
  <div class="wrapper">
    <jsp:include page="header.jsp" />
    <main class="main">${param.pageContents}</main>
    <jsp:include page="footer.jsp" />
  </div>
</body>
</html>
