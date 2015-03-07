<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header cf">
  <div class="header-title">
    <h1>
      <a href="${pageContext.request.contextPath}/"><img src=""
        alt="MUSIA" /></a>
    </h1>
  </div>
  <div class="header-content">
    <div class="header-search">
      <input name="#" type="search" size="30"> <input name="#"
        type="submit" value="検索">
    </div>
    <nav class="header-nav">
      <ul class="cf">
        <li><a href="${pageContext.request.contextPath}/release">リリース</a></li>
        <li><a href="${pageContext.request.contextPath}/contest">コンテスト</a></li>
        <li><a href="${pageContext.request.contextPath}/help">ヘルプ</a></li>
      </ul>
    </nav>
  </div>
</header>
