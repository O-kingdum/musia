<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="お支払い選択 | カート | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/cart_song.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">お支払い選択</h2>
        <div class="article-content">
          <ul>
            <li><a href="/credit">クレジットカード</a></li>
            <li><a href="/point">及川ポイント</a></li>
          </ul>
          <p class="page-back">
            <input type="button" value="戻る" onClick="history.back()">
          </p>
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>