<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList,jp.co.musia.okingdum.Utils.*;"%>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="商品登録画面 | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/admin/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/admin/admin_main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
    <%
    @SuppressWarnings("unchecked")
    ArrayList<GenreBean> genres = (ArrayList<GenreBean>)request.getAttribute("genres");
    @SuppressWarnings("unchecked")
    ArrayList<String> msgs = (ArrayList<String>)request.getAttribute("msg");
    %>
	<article>
	<!-- <h2>商品登録</h2> -->
		<form action="${pageContext.request.contextPath}/admin/song/post" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>商品登録フォーム</legend>
				<%	if(msgs != null && msgs.size() > 0) {	%>
					<ul>
					<%	for(String msg : msgs) {	%>
						<li><%= msg %></li>
					<%	} %>
					</ul>
				<%	} %>
				<div class="form-group-add">
					<label for="">商品名</label>
					<input type="text" name="product_name" required autofocus>
				</div>
				<div class="form-group-add">
					<label for="">アーティスト名</label>
					<input type="text" name="artist_name" required>
				</div>
				<div class="form-group-add">
					<label for="">価格</label>
					<input type="text" name="price" required>
				</div>
				<div class="form-group-add">
					<label for="">商品詳細</label>
					<textarea name="" id="" name="product_details" cols="30" rows="10" required>
					</textarea>
				</div>
				<div class="form-group-add">
					<label for="genre">ジャンル</label>
					<select name="genre_id" id="genre" required>
						<%
						if(genres != null && genres.size() > 0) {
							for(GenreBean genre : genres) {
						%>						
							<option value="<%= genre.getGenre_id() %>">
							<%= Sanitizer.convertSanitize(genre.getGenre_name()) %>
							</option>
						<%
							}
						} else {
						%>
							<option value="">ジャンルがありません。</option>
						<%
						}
						%>
					</select>
				</div>
				<div class="form-group-add">
					<label for="">曲尺</label>
					<input type="text" name="measure" required>
				</div>
				<div class="form-group-add">
					<label for="">ファイル種別</label>
					<input type="text" required>
				</div>
				<div class="form-group-add">
					<label for="">備考</label>
					<textarea name="remarks" id="" cols="30" rows="10" required>
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
		<img src="\WEB-INF\music_file\H/001.jpg" alt="" />
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
