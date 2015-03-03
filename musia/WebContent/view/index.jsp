<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="MUSIA-音楽ダウンロードサイトMUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/option_artist.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">トップ</h2>
        <div class="article-content">
          <%
            if (products != null && products.size() > 0) {
          %>
            <%
              for (ProductsBean product : products) {
            %>
              <div>
                <a href="<%=user.get()%>"><img src="<%=user.get()%>"
              alt="<%=user.get()%>" /></a>
              </div>
            <%
              }
            %>
          <%
            } else {
          %>
          <p>商品が登録されていません</p>
          <%
            }
          %>
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
