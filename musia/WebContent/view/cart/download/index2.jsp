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
        <h2 class="article-title">ダウンロード</h2>
        <div class="article-content">
          <form action="/cart" method="post">
            <fieldset>
              <legend>ダウンロード情報</legend>
              <table>
                <caption>ダウンロード</caption>
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
                  <tr>
                    <td class="table-data">ロック・イズ・デッド</td>
                    <td class="table-data"><a href="">マリリン・マンソン</a></td>
                    <td class="table-data">ロック</td>
                    <td class="table-data">500</td>
                    <td class="table-data"><input id="buy"
                      type="checkbox" name="buy"></td>
                  </tr>
                </tbody>
              </table>
              <p class="form-submit">
                <input type="submit" name="all" value="購入">
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
