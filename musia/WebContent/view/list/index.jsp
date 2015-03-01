<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="気になる | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">気になる</h2>
        <div class="article-content">
          <form action="/list" method="post">
            <%
              if (products != null && products.size() > 0) {
            %>
            <fieldset>
              <legend>気になる情報</legend>
              <table>
                <caption>気になる</caption>
                <thead>
                  <tr>
                    <th class="table-header">商品名</th>
                    <th class="table-header">アーティスト名</th>
                    <th class="table-header">価格</th>
                    <th class="table-header">ジャンル</th>
                    <th class="table-header"><label for="cart_add">カートに追加</label></th>
                  </tr>
                </thead>
                <tbody>
                <%
                  for (ProductsBean product : products) {
                %>
                  <tr>
                    <td class="table-data"></td>
                    <td class="table-data"><a href=""></a></td>
                    <td class="table-data"></td>
                    <td class="table-data"></td>
                    <td class="table-data"><input id="cart_add"
                      type="checkbox" name="cart_add"></td>
                  </tr>
                <%
                  }
                %>
                </tbody>
              </table>
              <%
                } else {
              %>
              <p>商品が登録されていません</p>
              <%
                }
              %>
              <p class="form-submit">
                <input type="submit" name="all" value="カートに追加">
              </p>
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
