<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header clearfix">
  <h1 class="header-title">
    <a href="${pageContext.request.contextPath}/"><img
      src="${pageContext.request.contextPath}/img/logo.png" alt="MUSIA" /></a>
  </h1>
  <div class="header-content clearfix">
    <div class="header-search">
      <input class="input-search" type="search" name="search" size="30"
        maxlength="255"> <input class="input-submit"
        type="submit" value="検索">
    </div>
    <nav class="header-nav">
      <ul class="header-nav-ul clearfix">
        <li class="header-nav-li"><a
          href="${pageContext.request.contextPath}/release"><img
            src="${pageContext.request.contextPath}/img/release.png"
            alt="リリース" /></a></li>
        <li class="header-nav-li"><a
          href="${pageContext.request.contextPath}/contest"><img
            src="${pageContext.request.contextPath}/img/contest.png"
            alt="コンテスト" /></a></li>
        <li class="header-nav-li"><a
          href="${pageContext.request.contextPath}/help"><img
            src="${pageContext.request.contextPath}/img/help.png"
            alt="ヘルプ" /></a></li>
      </ul>
    </nav>
  </div>
</header>
