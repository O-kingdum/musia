<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<V_ProductsBean> products = (ArrayList<V_ProductsBean>) request.getAttribute("products");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="カート | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/cart.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">カート</h2>
        <div class="article-content">
          <form action="/cart" method="post">
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
                    <th class="table-header"><label for="buy">購入</label></th>
                  </tr>
                </thead>
                <tbody>
                <%
                  for (V_ProductsBean product : products) {
                %>
                  <tr>
                    <td class="table-data"><% product.getProduct_name(); %></td>
                    <td class="table-data"><% product.getArtist_name(); %><a href=""></a></td>
                    <td class="table-data"><% product.getGenre_name(); %></td>
                    <td class="table-data"><% product.getPrice(); %></td>
                    <td class="table-data"><input id="buy"
                      type="checkbox" name="buy"></td>
                  </tr>
                <%
                  }
                %>
                </tbody>
              </table>
              <p class="form-submit">
                <input type="submit" name="all" value="購入">
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
            src="<%=request.getContextPath()%>/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
