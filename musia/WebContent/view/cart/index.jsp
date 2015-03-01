<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="カート | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/cart.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">カート</h2>
        <div class="article-content">
          <form action="/cart" method="post">
            <%
              @SuppressWarnings("unchecked")
              ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
              if (products != null && products.size() > 0) {
            %>
            <table>
              <thead>
                <tr>
                  <th>商品ＩＤ</th>
                  <th>商品名</th>
                  <th>アーティスト名</th>
                  <th>価格</th>
                  <th>ジャンル</th>
                  <th>購入</th>
                </tr>
              </thead>
              <tbody>
              <%
                for (ProductsBean product : products) {
              %>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td><input id="buy" type="checkbox" name="buy"></td>
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
            <p class="form-submit">
              <input type="submit" name="all" value="購入">
            </p>
          </form>
        </div>
        <p class="back">
          <a href="<%= request.getContextPath() %>">戻る</a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
