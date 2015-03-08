<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header clearfix">
  <div class="header-title grid_3 clearfix">
    <h1>
      <a href="${pageContext.request.contextPath}/">MUSIA</a>
    </h1>
  </div>
  <div class="header-content clearfix">
    <div class="header-search grid_9">
      <input type="search" name="search" size="30" maxlength="255"><input
        type="submit" value="検索">
    </div>
    <nav class="header-nav">
      <ul class="header-nav-ul clearfix">
        <li class="header-nav-li grid_3"><a
          href="${pageContext.request.contextPath}/release">リリース</a></li>
        <li class="header-nav-li grid_3"><a
          href="${pageContext.request.contextPath}/contest">コンテスト</a></li>
        <li class="header-nav-li grid_3"><a
          href="${pageContext.request.contextPath}/help">ヘルプ</a></li>
      </ul>
    </nav>
  </div>
</header>
