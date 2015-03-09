<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<V_ProductsBean> products = (ArrayList<V_ProductsBean>) request.getAttribute("products");
  @SuppressWarnings("unchecked")
  ArrayList<String> msgs = (ArrayList<String>) request.getAttribute("msg");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="リリース | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/release.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">リリース</h2>
        <div class="article-content">
          <form action="${pageContext.request.contextPath}/release"
            method="post">
            <%
              if (products != null && products.size() > 0) {
            %>
            <fieldset>
              <legend>リリース情報</legend>
              <table>
                <caption>リリース</caption>
                <thead>
                  <tr>
                    <th class="table-header">曲名</th>
                    <th class="table-header">ジャンル</th>
                    <th class="table-header">ファイル種別</th>
                    <th class="table-header">曲尺</th>
                    <th class="table-header">価格</th>
                    <th class="table-header">リリース日</th>
                    <th class="table-header">削除</th>
                  </tr>
                </thead>
                <tbody>
                  <%
                    for (V_ProductsBean product : products) {
                  %>
                  <tr>
                    <td class="table-data">
                      <%
                        product.getProduct_name();
                      %>
                    </td>
                    <td class="table-data">
                      <%
                        product.getGenre_name();
                      %>
                    </td>
                    <td class="table-data">
                      <%
                        product.getFile_size();
                      %>
                    </td>
                    <td class="table-data">
                      <%
                        product.getPrice();
                      %>
                    </td>
                    <td class="table-data">
                      <%
                        product.getPosted_date();
                      %>
                    </td>
                    <td class="table-data">
                      <input type="submit" name="#" value="削除" />
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
              <p class="data-else">楽曲が登録されていません</p>
              <%
                }
              %>
              <p class="form-submit">
                <input type="submit" name="all" value="リリース">
              </p>
            </fieldset>
          </form>
        </div>
        <p class="back">
          <a href="<%=request.getHeader("Referer")%>"><img
            src="${pageContext.request.contextPath}/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
