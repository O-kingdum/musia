<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header cf">
  <h1 class="header-title">
    <a href="<%=request.getContextPath()%>/">MUSIA</a>
  </h1>
  <form class="header-search cf" action="#">
    <p class="header-search-input">
      <input name="#" type="search" size="30"><input name="#"
        type="submit" value="検索">
    </p>
  </form>
  <div class="header-menu cf">
    <ul class="header-menu-login">
      <li><a href="<%=request.getContextPath()%>/view/signup/index.jsp">新規登録</a></li>
      <li><a href="<%=request.getContextPath()%>/view/login/index.jsp">ログイン</a></li>
    </ul>
  </div>
</header>
