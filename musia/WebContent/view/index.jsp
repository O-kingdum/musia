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
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/top.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">トップ</h2>
        <div class="article-content">
          <%
            if (products != null && products.size() > 0) {
              for (ProductsBean product : products) {
          %>
          <div class="grid_2">
            <a href="<%=product.getProduct_id()%>">
              <img src="<%=product.getImg_path()%>"
              alt="<%=product.getProduct_name()%>" />
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
