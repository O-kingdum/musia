<%@page import="jp.co.musia.okingdum.Bean.ProductsBean"%>
<%@page import="jp.co.musia.okingdum.Bean.UsersBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<UsersBean> users = (ArrayList<UsersBean>) request.getAttribute("users");
  ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
%>

<jsp:include page="/template/template.jsp">
  <jsp:param value="アーティスト詳細 | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/artist.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">アーティスト詳細</h2>
        <div class="article-content">
          <div class="side">
	          <div class="side_left">
		          <div class="side_left_image">
			          <img src="" alt="" title="">
		          </div>
		          <div class="side_left_username">
			          ユーザー名
		          </div>
		          <div class="side_left_profile">
			          プロフィール
		          </div>
	          </div>
	          <div class="side_right">
		          サイドバー右
		          <table>
                <caption>投稿曲</caption>
                <thead>
                  <tr>
                  	<th class="table-header">番号</th>
                    <th class="table-header">タイトル</th>
                    <th class="table-header">価格</th>
                    <th class="table-header">ファイル形式</th>
                  </tr>
                </thead>
                <tbody>
                <%
                  for(int i = 0; i< products.size(); i++) {
                %>
                  <tr>
                  	<td class="table-data"><%=i+1%></td>
                    <td class="table-data"><a href=""><%=products.get(i).getProduct_name()%></a></td>
                    <td class="table-data"><%=products.get(i).getPrice()%></td>
                    <td class="table-data"><%=products.get(i).getFile_type()%></td>
                  </tr>
                <%
                  }
                %>
                </tbody>
              </table>
              <div class="paging"></div>
              <!-- tableに対するjQuery plug-inのページ送り用 -->
	          </div>
          </div>
        </div>
        <%
          @SuppressWarnings("unchecked")
                      ArrayList<String> msg = (ArrayList<String>) request.getAttribute("msg");
                      if (msg != null && msg.size() > 0) {
        %>
        <ul>
        <%
          for (String str : msg) {
        %>
          <li><%=str%></li>
        <%
          }
        %>
        </ul>
        <%
          }
        %>
        <p class="back">
          <a href="history.back()"><img
            src="<%=request.getContextPath()%>/img/pageback.png"
            alt="戻る" class="backimg" /></a>
        </p>
        
        <!-- tableに対するjQuery plug-inの指定 -->
        <script>
									$('#data-table').datatable({
										pageSize : 5, // 1ページに表示する最大数
									//sort: [true, true, true, true],
									//filters: [false, false, 'select']
									});
								</script>
		<!-- /tableに対するjQuery plug-inの指定 -->
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
