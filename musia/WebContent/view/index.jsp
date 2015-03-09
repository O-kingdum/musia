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
          <div class="controls">
						<div>
						<label class="grid_2">カテゴリ</label>
						<button class="filter active grid_2" data-filter="all">すべて</button>
						<button class="filter grid_2" data-filter=".category-1">邦楽</button>
						<button class="filter grid_2" data-filter=".category-2">洋楽</button>
						<button class="filter grid_2" data-filter=".category-3">一般</button>
						<button class="filter grid_2" data-filter=".category-4">投稿曲</button>
						<!-- <button class="filter" data-filter=".category-5">効果音</button> -->
						</div>
						<div>
						<label class="grid_8">ソート</label>
						<button class="sort active grid_2" data-sort="default">リリース順</button>
						<!-- <button class="sort" data-sort="mytitle:asc">タイトル順</button> -->
						<button class="sort " data-sort="mydate:asc">ランキング</button>
						</div>
						</div>
          <%
            if (products != null && products.size() > 0) {
          %>  
              <div id="Container" class="container">
              <%
                for (int i = 0; i < products.size(); i++) {
              %>
          <div class="grid_2 prod mix">
          <script>
											$(function() {

												var str =
										<%=products.get(i).getMeasure()%>
											;
												console.log(str);
												var num = Number(str);
												var i =
										<%=i%>
											;
												console.log(i);
												//$(".prod").eq(i).attr('data-mytitle', title);
												$(".prod").eq(i).attr(
														'data-mydate', num);
												//$(".prod").eq(i).addClass("category-1");
											});
										</script>
          <%
            if( (products.get(i).getGenre_id().equals("GE00001")) ||
                	(products.get(i).getGenre_id().equals("GE00002")) ||
                	(products.get(i).getGenre_id().equals("GE00009")) ||
                	(products.get(i).getGenre_id().equals("GE00019")) ||
                	(products.get(i).getGenre_id().equals("GE00018")) ||
                	(products.get(i).getGenre_id().equals("GE00005")) ) {
          %>
          	<script>
												$(function() {
													var str =
											<%=i%>
												;
													//console.log(str);
													var i = Number(str);
													//console.log(i);
													$(".prod").eq(i).addClass(
															"mix");
													$(".prod").eq(i).addClass(
															"category-1");
												});
											</script>
          <%
            }else if( (products.get(i).getGenre_id().equals("GE00021")) ||
                        	(products.get(i).getGenre_id().equals("GE00022")) ||
          					(products.get(i).getGenre_id().equals("GE00020")) ){
          %>
              	<script>
																//var a =
															<%=i%>
																;
																$(function() {
																	var str =
															<%=i%>
																;
																	//var a = 0;
																	console
																			.log(str);
																	var i = Number(str);
																	console
																			.log(i);
																	$(".prod")
																			.eq(
																					i)
																			.addClass(
																					"mix");
																	$(".prod")
																			.eq(
																					i)
																			.addClass(
																					"category-2");
																});
															</script>
              <%
                }else {
              %>
              	<script>
																//var a =
															<%=i%>
																;
																$(function() {
																	var str =
															<%=i%>
																;
																	//var a = 0;
																	console
																			.log(str);
																	var i = Number(str);
																	console
																			.log(i);
																	$(".prod")
																			.eq(
																					i)
																			.addClass(
																					"mix");
																	$(".prod")
																			.eq(
																					i)
																			.addClass(
																					"category-3");
																});
															</script>
              <%
                }
              %>
            <a
                href="${pageContext.request.contextPath}/song?id=<%=products.get(i).getProduct_id()%>">
              <img class="top"
                src="<%= request.getContextPath() %><%=products.get(i).getImg_path()%>"
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
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
