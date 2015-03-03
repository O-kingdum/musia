<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.ArrayList;"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="ログイン | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/user_login.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">MUSIA - ログイン</h2>
        <div class="article-content">
          <form action="${pageContext.request.contextPath}/login_user" method="post">
            <fieldset>
              <legend>ログイン情報</legend>
              <table>
                <caption>ログイン</caption>
                <tr>
                  <th class="form-header">
                    <label for="login-email">メールアドレス</label>
                  </th>
                  <td class="form-data">
                    <input id="login-email" type="email" name="email"
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="login-password">パスワード</label>
                  </th>
                  <td class="form-data">
                    <input id="login-password" type="password"
                    name="password" autofocus="">
                  </td>
                </tr>
              </table>
            </fieldset>
            <p class="form-checkbox">
              <input id="memory" type="checkbox" name="memory">
              <label for="memory">メールアドレスを記憶する</label>
            </p>
            <p class="form-submit">
              <input type="submit" name="#" value="ログイン">
            </p>
          </form>
        </div>
        <%
        @SuppressWarnings("unchecked")
        ArrayList<String> msg = (ArrayList<String>)request.getAttribute("msg");
        if(msg != null && msg.size() > 0) {
        %>
        <ul>
        <%	for(String str : msg) {	 %>
        	<li><%= str %></li>
        <%	}	%>
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
