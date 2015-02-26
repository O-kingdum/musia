<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="MUSIA-音楽ダウンロードサイトMUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/template/template.css" name="templateCss"/>
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      
    </jsp:attribute>
  </jsp:param>
</jsp:include>
