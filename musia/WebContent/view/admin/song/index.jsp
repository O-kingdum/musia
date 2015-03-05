<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList,jp.co.musia.okingdum.Utils.*;"%>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="商品管理画面 | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/admin/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/admin/admin_main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
	<article>
		<h2>商品管理画面</h2>
	<a href="<%= request.getContextPath() %>/admin/song/post">商品登録</a>
	<%
    @SuppressWarnings("unchecked")
    ArrayList<ProductsBean> products = (ArrayList<ProductsBean>)request.getAttribute("products");
		if( products != null && products.size() > 0 ) {
	%>
		<table class="adminTable">
			<caption>商品一覧</caption>
			<thead>
				<tr>
					<th>商品ＩＤ</th>
					<th>商品名</th>
					<th>アーティスト名</th>
					<th>価格</th>
					<th>商品詳細</th>
				</tr>
			</thead>
			<tbody>
			<%
			for( ProductsBean product : products ) {
			%>
				<tr>
					<td><%= product.getProduct_id() %></td>
					<td><%= Sanitizer.convertSanitize(product.getProduct_name()) %></td>
					<td><%= Sanitizer.convertSanitize(product.getArtist_name()) %></td>
					<td><%= product.getPrice() %></td>
					<td>
						<button class="radiusBtn">
							<a href="<%= request.getContextPath() %>/admin/song/review?id=<%= product.getProduct_id() %>">商品詳細</a>
						</button>
					</td>
				</tr>
			<%
			}
			%>
			</tbody>
		</table>
	<%
	} else {
	%>
		<h2>商品が登録されていません</h2>
	<%
	}
	%>
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
