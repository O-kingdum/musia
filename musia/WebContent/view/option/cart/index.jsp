<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
  int total = (Integer)request.getAttribute("total");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="カート | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/cart.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">カート</h2>
        <div class="article-content">
            <%
              if (products != null && products.size() > 0) {
            %>
              <table class="test-table">
                <caption>カート</caption>
                <thead>
                  <tr>
                    <th class="table-header">タイトル</th>
                    <th class="table-header">アーティスト</th>
                    <th class="table-header">価格</th>
                    <th class="table-header"><label for="delete">削除</label></th>
                  </tr>
                </thead>
                <tbody>
                <%
                  int idx = 0;
                              for (ProductsBean product : products) {
                %>
                  <tr>
                    <td class="table-data"><a
                  href="<%=request.getContextPath()%>/song?id=<%=product.getProduct_id()%>">
                        <%=product.getProduct_name()%>
                    </a></td>
                    <td class="table-data">
                        <%=product.getArtist_name()%>
                    </td>
                    <td class="table-data">
                      <%=product.getPrice()%>
                    </td>
                    <td class="table-data">

                    	<form action="${pageContext.request.contextPath}/option/cartdel" method="post">
	                    	<input type="hidden" name="idx" value="<%= idx %>" />
	                    	<input id="delete"
	                      type="submit" name="delete" value="削除" />
                      	</form>
                    </td>
                  </tr>
                <%
                  idx++;
                              }
                %>
                </tbody>
              </table>
              <div class="paging"></div>
              <!-- tableに対するjQuery plug-inのページ送り用 -->

              <div class="cart-total">
              	<p>合計金額：<%=total%></p>
              </div>
	          <form action="${pageContext.request.contextPath}/option/cart/select" method="post">
	            <p class="form-submit">
	                <input type="submit" name="all" value="及川ポイントで購入する" />
	            </p>
	          	<p class="form-submit">
                	<input type="submit" name="all" value="クレジットカードで購入する" />
             	</p>
              </form>
              <%
                } else {
              %>
              <p>商品が登録されていません</p>
              <%
                }
              %>
        </div>
        <p class="back">
          <a href="<%=request.getHeader("Referer")%>"><img
            src="${pageContext.request.contextPath}/img/pageback.png"
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
