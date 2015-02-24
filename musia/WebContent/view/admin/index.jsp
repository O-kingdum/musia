<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<title>管理者ログイン | MUSIA</title>
</head>
<body>
	<div>
		<form action="<%= request.getContextPath() %>/login_admin" method="post">
			<fieldset>
				<div>
					<label for=""></label>
					<input type="text" required autofocus>
				</div>
				<div>
					<label for=""></label>
					<input type="password" required>
				</div>
				<div>
					<button type="submit"></button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>