<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="ダウンロード | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/cart_download.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">ダウンロード</h2>
        <div class="article-content">
            <%
              if (products != null && products.size() > 0) {
            %>
            <table>
              <thead>
                <tr>
                  <th>タイトル</th>
                  <th>アーティスト</th>
                  <th>価格</th>
                  <th>ダウンロード</th>
                </tr>
              </thead>
              <tbody>
              <%
                for (ProductsBean product : products) {
              %>
                <tr>
                  <td><%= product.getProduct_name() %></td>
                  <td><%= product.getArtist_name() %></td>
                  <td><%= product.getPrice() %></td>
                  <td>
          			<form action="${pageContext.request.contextPath}/option/cart/download" method="post">
                  	  <input type="hidden" name="id" value="<%= product.getProduct_id() %>" />
                  	  <p class="form-submit">
		          		<input type="submit" name="all" value="ダウンロード">
		          	  </p>
		          	</form>
                  </td>
                </tr>
              <%
                }
              %>
              </tbody>
            </table>
            <div class="paging"></div>
            <!-- tableに対するjQuery plug-inのページ送り用 -->
            <%
              } else {
            %>
            <h2>商品が登録されていません</h2>
            <%
              }
            %>
        </div>
        <p class="back">
          <a href="<%= request.getHeader("referer") %>"><img
            src="<%=request.getContextPath()%>/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
      
      <!-- tableに対するjQuery plug-inの指定 -->
        <script>
									$('#data-table').datatable({
										pageSize : 5, // 1ページに表示する最大数
									//sort: [true, true, true, true],
									//filters: [false, false, 'select']
									});
								</script>
		<!-- /tableに対するjQuery plug-inの指定 -->
		
    </jsp:attribute>
  </jsp:param>
</jsp:include>
