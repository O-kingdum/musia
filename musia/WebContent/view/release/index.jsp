<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="リリース | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/template/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/release.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">リリース</h2>
        <div class="article-content">
          
        </div>
        <p class="back">
          <a href="<%= request.getContextPath() %>">戻る</a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
