<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="商品管理画面 | MUSIA" name="siteTitle" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
	<article>
		<h2>商品管理画面</h2>
	<%
    @SuppressWarnings("unchecked")
    ArrayList<ProductsBean> products = (ArrayList<ProductsBean>)request.getAttribute("products");
	if( products != null && products.size() > 0 ) {
	%>
		<table>
			<thead>
				<tr>
					<th>商品ＩＤ</th>
					<th>商品名</th>
					<th>アーティスト名</th>
					<th>価格</th>
					<th>ジャンル</th>
				</tr>
			</thead>
			<tbody>
			<%
			for( ProductsBean product : products ) {
			%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
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
	<button><a href="<%= request.getContextPath() %>/song/post">商品登録</a></button>
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
