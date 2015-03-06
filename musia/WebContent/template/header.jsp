<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header cf">
  <h1 class="header-title">
    <a href=""><img src="" alt="MUSIA" /></a>
  </h1>
  <div class="header-content">
    <p class="login-stetas">
      ログインしていません（ようこそ<a href="">ユーザ名</a>さん）
    </p>
    <ul>
      <li class="head-listener_signup"><a href="${pageContext.request.contextPath}/listener_signup"><img src="" alt="新規登録" /></a><!-- →<a
        href="/option"><img src="" alt="オプション" /></a> --></li>
      <li class="head-login"><a href="${pageContext.request.contextPath}/login_user"><img src="" alt="ログイン" /></a><!-- →<a
        href=""><img src="${pageContext.request.contextPath}/logout" alt="ログアウト" /></a> --></li>
    </ul>
  </div>
  <div class="header-content">
    <form action="#" method="post">
      <p class="head-search">
        <input name="#" type="search" size="30"> <input name="#"
          type="submit" value="検索">
      </p>
    </form>
    <ul>
      <li class="head-list"><a href="${pageContext.request.contextPath}/option/list"><img src="" alt="気になる" /></a></li>
      <li class="head-cart"><a href="${pageContext.request.contextPath}/cart"><img src="" alt="カート" /></a></li>
    </ul>
  </div>
  <div class="header-content">
    <nav>
      <ul>
        <li class="head-release"><a href="${pageContext.request.contextPath}/release"><img src="" alt="リリース" /></a></li>
        <li class="head-contest"><a href="${pageContext.request.contextPath}/contest"><img src="" alt="コンテスト" /></a></li>
        <li class="head-help"><a href="${pageContext.request.contextPath}/help"><img src="" alt="ヘルプ" /></a></li>
      </ul>
    </nav>
  </div>
</header>
