<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
 <!--
<audio preload="auto" controls>

	<source src="http://localhost:8080<%= request.getContextPath() %>/audio/Alive.m4a" type="audio/aac">

<p>音声を再生することができませんでした。</p>
</audio>
 -->
<audio src="http://localhost:8080<%= request.getContextPath() %>/audio/Alive.m4a" controls></audio>

</body>
</html>