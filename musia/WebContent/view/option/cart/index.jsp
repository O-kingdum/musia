<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
  int total = (int)request.getAttribute("total");
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
          <form action="${pageContext.request.contextPath}/option/cart"
            method="post">
            <%
              if (products != null && products.size() > 0) {
            %>
            <fieldset>
              <legend>カート情報</legend>
              <table>
                <caption>カート</caption>
                <thead>
                  <tr>
                    <th class="table-header">タイトル</th>
                    <th class="table-header">アーティスト</th>
                    <th class="table-header">ジャンル</th>
                    <th class="table-header">価格</th>
                    <th class="table-header"><label for="delete">削除</label></th>
                  </tr>
                </thead>
                <tbody>
                <%
                  for (ProductsBean product : products) {
                %>
                  <tr>
                    <td class="table-data"><a href="">
                        <%
                          product.getProduct_name();
                        %>
                    </a></td>
                    <td class="table-data"><a href="">
                        <%
                          product.getArtist_name();
                        %>
                    </a></td>
                    <td class="table-data">
                      <%
                        product.getPrice();
                      %>
                    </td>
                    <td class="table-data"><input id="delete"
                      type="submit" name="delete" /></td>
                  </tr>
                <%
                  }
                %>
                </tbody>
              </table>
              <div class="paging"></div>
              <!-- tableに対するjQuery plug-inのページ送り用 -->
              <p>合計金額：<%=total%></p>
              <p class="form-submit">
                <input type="submit" name="all" value="及川ポイントで購入する" />
              </p>
              <p class="form-submit">
                <input type="submit" name="all" value="クレジットカードで購入する" />
              </p>
              <%
                } else {
              %>
              <p>商品が登録されていません</p>
              <%
                }
              %>
            </fieldset>
          </form>
        </div>
        <p class="back">
          <a href="history.back()"><img
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
