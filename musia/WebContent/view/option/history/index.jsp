<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="購入履歴 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/option_history.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">購入履歴</h2>
        <div class="article-content">
          <form action="/list" method="post">
            <%
              if (products != null && products.size() > 0) {
            %>
            <fieldset>
              <legend>購入履歴情報</legend>
              <table>
                <caption>購入履歴</caption>
                <thead>
                  <tr>
                    <th class="table-header">商品名</th>
                    <th class="table-header">アーティスト名</th>
                    <th class="table-header">価格</th>
                    <th class="table-header">ジャンル</th>
                    <th class="table-header"><label for="download">ダウンロード</label></th>
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
                    <td class="table-data"><input id="download"
                      type="checkbox" name="download"></td>
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
                <input type="submit" name="all" value="ダウンロード">
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
