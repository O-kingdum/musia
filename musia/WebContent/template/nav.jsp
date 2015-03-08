<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<nav class="nav clearfix">
  <ul class="clearfix">
    <li>ログインしていません</li>
    <li><a
      href="${pageContext.request.contextPath}/listener_signup">新規登録</a></li>
    <li><a href="${pageContext.request.contextPath}/user_login">ログイン</a></li>
    <li><input type="search" name="search" size="30"
      maxlength="255"> <input type="submit" value="検索"></li>
    <!--
    <li>ようこそ○○さん</li>
    <li><a href="${pageContext.request.contextPath}/option/list">気になる</a></li>
    <li><a href="${pageContext.request.contextPath}/option/cart">カート</a></li>
    <li><a href="${pageContext.request.contextPath}/option">オプション</a></li>
    <li><a href="${pageContext.request.contextPath}/user_login">ログアウト</a></li>
    -->
  </ul>
</nav>
