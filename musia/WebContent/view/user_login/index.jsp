<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<String> msg = (ArrayList<String>) request.getAttribute("msg");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="ログイン | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/user_login.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">MUSIA - ログイン</h2>
        <div class="article-content">
          <form action="${pageContext.request.contextPath}/user_login"
            method="post" novalidate name="myForm">
            <fieldset>
              <legend>ログイン情報</legend>
              <table>
                <caption>ログイン</caption>
                <tr>
                  <th class="form-header">
                    <label for="login-email">メールアドレス</label>
                  </th>
                  <td class="form-data">
                    <input type="email" id="login-email" name="email"
                    autofocus="" ng-model="email" required
                    ng-maxlength="50">
                    <!-- angularJSのemailメッセージ -->
                    <p class="ang-errorMsg"
                      ng-show="myForm.email.$error.required">
	                      <img
                        src="${pageContext.request.contextPath}/img/no.png"
                        alt="err_img" title="エラー画像">メールアドレスを入力して下さい
	                  </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.email.$error.maxlength">
	                      <img
                        src="${pageContext.request.contextPath}/img/no.png"
                        alt="err_img" title="エラー画像">50文字以内で入力して下さい
	                  </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.email.$error.email">
	                      <img
                        src="${pageContext.request.contextPath}/img/no.png"
                        alt="err_img" title="エラー画像">メールアドレスを入力して下さい
	                  </p>
                    <p class="ang-okMsg" ng-show="myForm.email.$valid">
	                      <img
                        src="${pageContext.request.contextPath}/img/ok.png"
                        alt="ok_img" title="オーケー画像">
	                      OK
	                  </p>
                    <!-- /angularJSのemailメッセージ -->
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="login-password">パスワード</label>
                  </th>
                  <td class="form-data">
                    <input id="login-password" type="password"
                    name="password" autofocus="" ng-model="password"
                    required ng-minlength="6" ng-maxlength="8">
                    <!-- angularJSのpasswordメッセージ -->
                    <p class="ang-errorMsg"
                      ng-show="myForm.password.$error.required">
	                      <img
                        src="${pageContext.request.contextPath}/img/no.png"
                        alt="err_img" title="エラー画像">
	                      パスワードを入力して下さい
	                  </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.password.$error.minlength">
	                      <img
                        src="${pageContext.request.contextPath}/img/no.png"
                        alt="err_img" title="エラー画像">
	                      パスワードは6~8文字で入力して下さい
	                  </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.password.$error.maxlength">
	                      <img
                        src="${pageContext.request.contextPath}/img/no.png"
                        alt="err_img" title="エラー画像">
	                      パスワードは6~8文字で入力して下さい
	                  </p>
                    <p class="ang-okMsg"
                      ng-show="myForm.password.$valid">
	                      <img
                        src="${pageContext.request.contextPath}/img/ok.png"
                        alt="ok_img" title="オーケー画像">
	                      OK
	                  </p>
                    <!-- /angularJSのpasswordメッセージ -->
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
          <a href="<%=request.getHeader("Referer")%>"><img
            src="${pageContext.request.contextPath}/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
