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
</html>