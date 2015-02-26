<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<header class="header">
	<div class="head_title">
		<h1>MUSIA管理画面</h1>
	</div>
	<nav class="head_navs clearfix">
		<ul>
			<li class="head_nav"><a href="<%= request.getContextPath() %>/admin/user">ユーザ管理</a></li>
			<li class="head_nav"><a href="<%= request.getContextPath() %>/admin/song">商品管理</a></li>
			<li class="head_nav"><a href="<%= request.getContextPath() %>/admin/contest">コンテスト管理</a></li>
			<li class="head_nav"><a href="<%= request.getContextPath() %>/admin/logout">ログアウト</a></li>
		</ul>
	</nav>
</header>
