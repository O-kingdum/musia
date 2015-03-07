<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="オプション | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/option.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">オプション</h2>
        <div class="article-content">
          <ul>
            <li><a href="/option/history">購入履歴</a></li>
            <li><a href="/option/point">及川ポイント購入</a></li>
            <li><a href="/option/listener">リスナー情報</a></li>
            <li><a href="/option/artist">アーティスト情報</a></li>
            <li><a href="/option/credit">クレジットカード情報</a></li>
          </ul>
        </div>
        <p class="back">
          <a href="history.back()"><img
            src="${pageContext.request.contextPath}/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
