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
            <li class="grid_2 filter" data-filter=".category-1"><a href="">邦楽</a></li>
            <li class="grid_2"><a href="">洋楽</a></li>
            <li class="grid_2"><a href="">一般</a></li>
            <li class="grid_2"><a href="">効果音</a></li>
            <li class="grid_2"><a href="">新着</a></li>
            <li class="grid_2"><a href="">ランキング</a></li>
          </ul>
          <%
            if (products != null && products.size() > 0) {
              //for (ProductsBean product : products) {
            	  //System.out.println(product.getGenre_id());
              for (int i = 0; i < products.size(); i++) {
          %>
          <div class="grid_2 prod mix">
          <%
          	if( (products.get(i).getGenre_id().equals("GE00001")) ||
          	(products.get(i).getGenre_id().equals("GE00002")) ||
          	(products.get(i).getGenre_id().equals("GE00009")) ||
          	(products.get(i).getGenre_id().equals("GE00019")) ||
          	(products.get(i).getGenre_id().equals("GE00018")) ||
          	(products.get(i).getGenre_id().equals("GE00005")) ) {
          		
          %>
          	<script>
	          	//var a = <%= i %>;
          		$(function() {
          			var str = <%= i %>;
	          		//var a = 0;
          			console.log(str);
          			var i =  Number(str);
          			console.log(i);
          			$(".prod").eq(i).addClass("mix");
	          		$(".prod").eq(i).addClass("category-1");
          		});
          	</script>
          <%
          	}
          %>
            <a
              href="${pageContext.request.contextPath}/song?id=<%=products.get(i).getProduct_id()%>">
              <img
              src="${pageContext.request.contextPath}/music_img/<%=products.get(i).getProduct_id()%>.jpg"
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
