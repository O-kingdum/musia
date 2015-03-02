<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="商品登録画面 | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/admin/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/admin/admin_main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
	<article>
	<!-- <h2>商品登録</h2> -->
		<form action="${pageContext.request.contextPath}/admin/song/post" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>商品登録フォーム</legend>
				<div class="form-group-add">
					<label for="">商品名</label>
					<input type="text" required autofocus>
				</div>
				<div class="form-group-add">
					<label for="">アーティスト名</label>
					<input type="text" required>
				</div>
				<div class="form-group-add">
					<label for="">価格</label>
					<input type="text" required>
				</div>
				<div class="form-group-add">
					<label for="">商品詳細</label>
					<textarea name="" id="" cols="30" rows="10" required>
					</textarea>
				</div>
				<div class="form-group-add">
					<label for="">ジャンル</label>
					<input type="text" required>
				</div>
				<div class="form-group-add">
					<label for="">曲尺</label>
					<input type="text" required>
				</div>
				<div class="form-group-add">
					<label for="">ファイル種別</label>
					<input type="text" required>
				</div>
				<div class="form-group-add">
					<label for="">備考</label>
					<textarea name="" id="" cols="30" rows="10" required>
					</textarea>
				</div>
				<div class="form-group-add">
					<label for="">商品ファイル</label>
					<input type="file" name="file" />
				</div>
				<div class="form-group-add form-btn">
					<button type="submit" class="login-btn">登録</button>
				</div>
			</fieldset>
		</form>
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
