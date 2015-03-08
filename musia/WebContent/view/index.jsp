<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList, jp.co.musia.okingdum.dao.*;"%>
<%
  ProductsDao pd = new ProductsDao();
  ArrayList<ProductsBean> products = pd.allSelectProducts();
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="MUSIA-音楽ダウンロードサイトMUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/top.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">トップ</h2>
        <div class="article-content clearfix">
          <ul class="clearfix">
            <li class="grid_2"><a href="">邦楽</a></li>
            <li class="grid_2"><a href="">洋楽</a></li>
            <li class="grid_2"><a href="">一般</a></li>
            <li class="grid_2"><a href="">効果音</a></li>
            <li class="grid_2"><a href="">新着</a></li>
            <li class="grid_2"><a href="">ランキング</a></li>
          </ul>
          <%
            if (products != null && products.size() > 0) {
              for (ProductsBean product : products) {
          %>
          <div class="grid_2">
            <a
              href="${pageContext.request.contextPath}/song?id=<%=product.getProduct_id()%>">
              <img
              src="${pageContext.request.contextPath}/music_img/<%=product.getProduct_id()%>.jpg"
              alt="" />
            </a>
          </div>
            <%
              }
            %>
          <%
            }
          %>
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
