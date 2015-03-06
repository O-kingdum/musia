<<<<<<< Updated upstream
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
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/artist.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">アーティスト詳細</h2>
        <div class="article-content">
          <div class="side clearfix">
	          
	          <div class="side_left">
		          <div class="side_left_image">
			          <img src="<%=request.getContextPath()%>/img/userImage.jpg" alt="" title="" width="210" height="210">
		          </div>
		          <div class="side_left_username">
			          <p class="side_left_title">ユーザー名</p>
		          </div>
		          <div class="side_left_profile">
		          	<p class="side_left_title">プロフィール</p>
			          <p class="side_left_expo">
				          プロフィールの見本です。プロフィールの見本です。プロフィールの見本です。
									プロフィールの見本です。プロフィールの見本です。プロフィールの見本です。
			          </p>
		          </div>
	          </div>
	          
	          <div class="side_right">
		          
		          <table class="test-table">
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
                  <tr>
                  	<td class="table-data">1</td>
                    <td class="table-data"><a href="">test1</a></td>
                    <td class="table-data">250円</td>
                    <td class="table-data">wav</td>
                  </tr>
                  <tr>
                  	<td class="table-data">2</td>
                    <td class="table-data"><a href="">test2</a></td>
                    <td class="table-data">250円</td>
                    <td class="table-data">wav</td>
                  </tr>
                  <tr>
                  	<td class="table-data">3</td>
                    <td class="table-data"><a href="">test3</a></td>
                    <td class="table-data">250円</td>
                    <td class="table-data">wav</td>
                  </tr>
                </tbody>
              </table>
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
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
=======
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
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/artist.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">アーティスト詳細</h2>
        <div class="article-content">
          <div class="side clearfix">
	          
	          <div class="side_left">
		          <div class="side_left_image">
			          <img src="<%=request.getContextPath()%>/img/userImage.jpg" alt="" title="" width="210" height="210">
		          </div>
		          <div class="side_left_username">
			          <p class="side_left_title">ユーザー名</p>
		          </div>
		          <div class="side_left_profile">
		          	<p class="side_left_title">プロフィール</p>
			          <p class="side_left_expo">
				          プロフィールの見本です。プロフィールの見本です。プロフィールの見本です。
									プロフィールの見本です。プロフィールの見本です。プロフィールの見本です。
			          </p>
		          </div>
	          </div>
	          
	          <div class="side_right">
		          
		          <table class="test-table">
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
                  <tr>
                  	<td class="table-data">1</td>
                    <td class="table-data"><a href="">test1</a></td>
                    <td class="table-data">250円</td>
                    <td class="table-data">wav</td>
                  </tr>
                  <tr>
                  	<td class="table-data">2</td>
                    <td class="table-data"><a href="">test2</a></td>
                    <td class="table-data">250円</td>
                    <td class="table-data">wav</td>
                  </tr>
                  <tr>
                  	<td class="table-data">3</td>
                    <td class="table-data"><a href="">test3</a></td>
                    <td class="table-data">250円</td>
                    <td class="table-data">wav</td>
                  </tr>
                </tbody>
              </table>
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
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
>>>>>>> Stashed changes
