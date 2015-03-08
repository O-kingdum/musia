<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Utils.*;" %>
<nav class="nav clearfix">
  <ul class="clearfix">
    <%
      if (!Auth.checkAuth(request)) {
    %>
    <li class="grid_4">ログインしていません</li>
    <li class="grid_2"><a
      href="${pageContext.request.contextPath}/listener_signup">新規登録</a></li>
    <li class="grid_2"><a
      href="${pageContext.request.contextPath}/user_login">ログイン</a></li>
    <%
      } else {
    %>
    <li>ようこそ○○さん</li>
    <li><a href="${pageContext.request.contextPath}/option/list">気になる</a></li>
    <li><a href="${pageContext.request.contextPath}/option/cart">カート</a></li>
    <li><a href="${pageContext.request.contextPath}/option">オプション</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">ログアウト</a></li>
    <%
      }
    %>
  </ul>
</nav>
