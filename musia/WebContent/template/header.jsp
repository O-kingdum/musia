<<<<<<< HEAD
<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header cf">
  <h1 class="header-title">
    <a href="<%=request.getContextPath()%>/view/index.jsp"><img
      src="" alt="MUSIA" /></a>
  </h1>
  <div class="header-content">
    <p>
      ログインしていません（ようこそ<a
        href="<%=request.getContextPath()%>/view/option/index.jsp">ユーザ名</a>さん）
    </p>
    <ul>
      <li><a
        href="<%=request.getContextPath()%>/view/signup_listener/index.jsp"><img
          src="" alt="新規登録" /></a>→<a
        href="<%=request.getContextPath()%>/view/option/index.jsp"><img
          src="" alt="オプション" /></a></li>
      <li><a
        href="<%=request.getContextPath()%>/view/login/index.jsp"><img
          src="" alt="ログイン" /></a>→<a
        href="<%=request.getContextPath()%>/view/login/index.jsp"><img
          src="" alt="ログアウト" /></a></li>
    </ul>
  </div>
  <div class="header-content">
    <form action="#" method="post">
      <p>
        <input name="#" type="search" size="30"> <input name="#"
          type="submit" value="検索">
      </p>
    </form>
    <ul>
      <li><a
        href="<%=request.getContextPath()%>/view/list/index.jsp"><img
          src="" alt="気になる" /></a></li>
      <li><a
        href="<%=request.getContextPath()%>/view/cart/index.jsp"><img
          src="" alt="カート" /></a></li>
    </ul>
  </div>
  <div class="header-content">
    <nav>
      <ul>
        <li><a href="<%=request.getContextPath()%>"><img src=""
            alt="リリース" /></a></li>
        <li><a href="<%=request.getContextPath()%>"><img src=""
            alt="コンテスト" /></a></li>
        <li><a href="<%=request.getContextPath()%>"><img src=""
            alt="ヘルプ" /></a></li>
      </ul>
    </nav>
  </div>
</header>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header cf">
  <h1 class="header-title">
    <a href="<%=request.getContextPath()%>/view/index.jsp"><img
      src="" alt="MUSIA" /></a>
  </h1>
  <div class="header-content">
    <p>
      ログインしていません（ようこそ<a
        href="<%=request.getContextPath()%>/view/option/index.jsp">ユーザ名</a>さん）
    </p>
    <ul>
      <li><a
        href="<%=request.getContextPath()%>/view/signup_listener/index.jsp"><img
          src="" alt="新規登録" /></a>→<a
        href="<%=request.getContextPath()%>/view/option/index.jsp"><img
          src="" alt="オプション" /></a></li>
      <li><a
        href="<%=request.getContextPath()%>/view/login/index.jsp"><img
          src="" alt="ログイン" /></a>→<a
        href="<%=request.getContextPath()%>/view/login/index.jsp"><img
          src="" alt="ログアウト" /></a></li>
    </ul>
  </div>
  <div class="header-content">
    <form action="#" method="post">
      <p>
        <input name="#" type="search" size="30"> <input name="#"
          type="submit" value="検索">
      </p>
    </form>
    <ul>
      <li><a
        href="<%=request.getContextPath()%>/view/list/index.jsp"><img
          src="" alt="気になる" /></a></li>
      <li><a
        href="<%=request.getContextPath()%>/view/cart/index.jsp"><img
          src="" alt="カート" /></a></li>
    </ul>
  </div>
  <div class="header-content">
    <nav>
      <ul>
        <li><a href="<%=request.getContextPath()%>"><img src=""
            alt="リリース" /></a></li>
        <li><a href="<%=request.getContextPath()%>"><img src=""
            alt="コンテスト" /></a></li>
        <li><a href="<%=request.getContextPath()%>"><img src=""
            alt="ヘルプ" /></a></li>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header clearfix">
  <div class="header-title grid_3 clearfix">
    <h1>
      <a href="${pageContext.request.contextPath}/"><img src=""
        alt="MUSIA" /></a>
    </h1>
  </div>
  <div class="header-content grid_9">
    <div class="header-search">
      <input name="#" type="search" size="30"> <input name="#"
        type="submit" value="検索">
    </div>
    <nav class="header-nav">
      <ul class="cf">
        <li><a href="${pageContext.request.contextPath}/release">リリース</a></li>
        <li><a href="${pageContext.request.contextPath}/contest">コンテスト</a></li>
        <li><a href="${pageContext.request.contextPath}/help">ヘルプ</a></li>
>>>>>>> Develop
      </ul>
    </nav>
  </div>
</header>
<<<<<<< HEAD
>>>>>>> Develop
=======
>>>>>>> Develop
