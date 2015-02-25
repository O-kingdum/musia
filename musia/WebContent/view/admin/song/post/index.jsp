<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="商品登録画面 | MUSIA" name="siteTitle" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
	<article>
	<h2>商品登録</h2>
		<form action="">
			<fieldset>
				<legend>商品登録フォーム</legend>
				<div class="form-group">
					<label for="">商品名：</label>
					<input type="text" required autofocus>
				</div>
				<div class="form-group">
					<label for="">アーティスト名：</label>
					<input type="text" required>
				</div>
				<div class="form-group">
					<label for="">価格：</label>
					<input type="text" required>
				</div>
				<div class="form-group">
					<label for="">商品詳細：</label>
					<textarea name="" id="" cols="30" rows="10" required>
					</textarea>
				</div>
				<div class="form-group">
					<label for="">ジャンル：</label>
					<input type="text" required>
				</div>
				<div class="form-group">
					<label for="">曲尺：</label>
					<input type="text" required>
				</div>
				<div class="form-group">
					<label for="">ファイル種別：</label>
					<input type="text" required>
				</div>
				<div class="form-group">
					<label for="">備考：</label>
					<textarea name="" id="" cols="30" rows="10" required>
					</textarea>
				</div>
			</fieldset>
		</form>
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
