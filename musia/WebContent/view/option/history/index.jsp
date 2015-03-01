<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="購入履歴 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">購入履歴</h2>
        <div class="article-content">
          
        </div>
        <p class="back">
          <input type="button" value="戻る" onClick="history.back()">
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
