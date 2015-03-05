<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;" %>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="商品詳細画面 | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/admin/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/admin/admin_main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
	<article>
		<h2>商品詳細画面</h2>
	<%
    @SuppressWarnings("unchecked")
    ArrayList<ProductsBean> products = (ArrayList<ProductsBean>)request.getAttribute("products");
	
    if( products != null && products.size() > 0 ) {
    	ProductsBean product = products.get(0);
    %>
		<table class="adminTable">
			<caption>
			商品詳細
			</caption>
			<tbody>
				<tr>
					<th>商品ＩＤ</th><td><%= product.getProduct_id() %></td>
				</tr>
				<tr>
					<th>商品名</th><td><%= product.getProduct_name() %></td>
				</tr>
				<tr>
					<th>アーティスト名</th><td><%= product.getArtist_name() %></td>
				</tr>
				<tr>
					<th>価格</th><td><%= product.getPrice() %></td>
				</tr>
				<tr>
					<th>商品詳細</th><td><%= product.getProduct_details() %></td>
				</tr>
				<tr>
					<th>ジャンルＩＤ</th><td><%= product.getGenre_id() %></td>
				</tr>
				<tr>
					<th>曲尺</th><td><%= product.getMeasure() %> sec</td>
				</tr>
				<tr>
					<th>ファイル形式</th><td><%= product.getFile_type() %></td>
				</tr>
				<tr>
					<th>ファイルサイズ</th><td><%= ((double)product.getFile_size()) / 1000 %>MB</td>
				</tr>
				<tr>
					<th>ファイル保存先ディレクトリ</th><td><%= product.getDirectory_path() %></td>
				</tr>
				<tr>
					<th>画像保存先ディレクトリ</th><td><%= product.getImg_path() %></td>
				</tr>
				<tr>
					<th>登録日</th><td><%= product.getPosted_date() %></td>
				</tr>
				<tr>
					<th>備考</th><td><%= product.getRemarks() %></td>
				</tr>
			</tbody>
		</table>
	<%
    } else {
	%>
		<h2>商品が見つかりません。</h2>
	<%
    }
	%>
	<a href="<%= request.getHeader("Referer") %>">戻る</a>
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
