<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>管理者ログイン | MUSIA</title>
</head>
<body>
	<div class="login-form-article">
		<form action="<%= request.getContextPath() %>/login_admin" method="post">
			<fieldset>
			<legend>MUSIA　管理者ログインフォーム</legend>
				<div class="form-group">
					<label for="">メールアドレス：</label>
					<input type="text" required autofocus>
				</div>
				<div class="form-group">
					<label for="">パスワード:</label>
					<input type="password" required>
				</div>
				<div class="form-group">
					<button type="submit">ログイン</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>管理者ログイン | MUSIA</title>
</head>
<body>
	<div class="login-form-article">
		<form action="<%= request.getContextPath() %>/login_admin" method="post">
			<fieldset>
			<legend>MUSIA　管理者ログインフォーム</legend>
				<div class="form-group">
					<label for="">メールアドレス：</label>
					<input type="text" required autofocus>
				</div>
				<div class="form-group">
					<label for="">パスワード:</label>
					<input type="password" required>
				</div>
				<div class="form-group">
					<button type="submit">ログイン</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
>>>>>>> Develop
</html>
=======
    pageEncoding="UTF-8" import="java.util.ArrayList;"%>
<jsp:include page="/template/admin/template_top.jsp">
  <jsp:param value="管理者ログイン | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/template/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/admin/admin_main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
    <%
    @SuppressWarnings("unchecked")
    ArrayList<String> msgarr = (ArrayList<String>)request.getAttribute("msg");
    %>
		<div class="login-form-article">
			<form action="<%= request.getContextPath() %>/login_admin" method="post">
				<fieldset>
					<legend>MUSIA　管理者ログインフォーム</legend>
					<div class="form-group">
						<label for="">メールアドレス：</label>
						<input type="text" name="id" required autofocus>
					</div>
					<div class="form-group">
						<label for="">パスワード:</label>
						<input type="password" name="password" required>
					</div>
					<div class="login-error-msg">
					<%
					if( msgarr != null && msgarr.size() > 0 ) {
					%>
						<ul>
						<%
						for(String msg : msgarr) {
						%>
							<li><%= msg %></li>
						<%
						}
						%>
						</ul>
					<%
					}
					%>
					</div>
					<div class="form-group form-btn">
						<button type="submit" class="login-btn">ログイン</button>
					</div>
				</fieldset>
			</form>
		</div>
	
		<!-- <div class="login-error-msg">test</div> -->
	
    </jsp:attribute>
  </jsp:param>
</jsp:include>
>>>>>>> Develop
