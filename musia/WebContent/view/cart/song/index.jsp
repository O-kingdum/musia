<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="楽曲詳細 | カート | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/cart_song.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">楽曲詳細</h2>
        <div class="article-content">
          
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>