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
    value="${pageContext.request.contextPath}/css/cart_download.css"
    name="mainCss" />
    
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/datatable.css" name="datableCss" />
  <jsp:param value="${pageContext.request.contextPath}/js/vendor/jquery-1.11.2.min.js" name="jqueryJs" />
  <jsp:param value="${pageContext.request.contextPath}/js/vendor/datatable.min.js" name="datableJs" />
    
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
              <div class="paging"></div><!-- tableに対するjQuery plug-inのページ送り用 -->
              
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
      
      <!-- tableに対するjQuery plug-inの指定 -->
        <script>
		$('#data-table').datatable({
		  pageSize: 5, // 1ページに表示する最大数
		  //sort: [true, true, true, true],
		  //filters: [false, false, 'select']
		});
		</script>
		<!-- /tableに対するjQuery plug-inの指定 -->
    </jsp:attribute>
  </jsp:param>
</jsp:include>
