<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<V_ProductsBean> products = (ArrayList<V_ProductsBean>) request.getAttribute("products");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="カート | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/cart.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">カート</h2>
        <div class="article-content">
          <form action="/cart" method="post">
            <fieldset>
              <legend>カート情報</legend>
              <table>
                <caption>カート</caption>
                <thead>
                  <tr>
                    <th class="table-header">タイトル</th>
                    <th class="table-header">アーティスト</th>
                    <th class="table-header">ジャンル</th>
                    <th class="table-header">価格</th>
                    <th class="table-header"><label for="delete">削除</label></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td class="table-data"><a href="">ああああ</a></td>
                    <td class="table-data"><a href="">いいいい</a></td>
                    <td class="table-data">うううう</td>
                    <td class="table-data">ええええ</td>
                    <td class="table-data"><input id="delete"
                      type="submit" name="delete" value="削除" /></td>
                  </tr>
                </tbody>
              </table>
              <div class="paging"></div>
              <!-- tableに対するjQuery plug-inのページ送り用 -->
              <p class="form-submit">
                <input type="submit" name="all" value="クレジットカードで購入する" />
              </p>
              <p class="form-submit">
                <input type="submit" name="all" value="及川ポイントで購入する" />
              </p>
            </fieldset>
          </form>
        </div>
        <p class="back">
          <a href="history.back()"><img
            src="${pageContext.request.contextPath}/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
      
      <!-- tableに対するjQuery plug-inの指定 -->
        <script>
									$('#data-table').datatable({
										pageSize : 5, // 1ページに表示する最大数
									//sort: [true, true, true, true],
									//filters: [false, false, 'select']
									});
								</script>
    <!-- /tableに対するjQuery plug-inの指定 -->
    
    </jsp:attribute>
  </jsp:param>
</jsp:include>
