<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header">
	<div>
		<h1>MUSIA管理画面</h1>
	</div>
	<nav>
		<ul>
			<li><a href="<%= request.getContextPath() %>/admin/user">ユーザ管理</a></li>
			<li><a href="<%= request.getContextPath() %>/admin/song">商品管理</a></li>
			<li><a href="<%= request.getContextPath() %>/admin/contest">コンテスト管理</a></li>
			<li><a href="<%= request.getContextPath() %>/admin/logout">ログアウト</a></li>
		</ul>
	</nav>
</header>
