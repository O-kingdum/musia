<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<String> msg = (ArrayList<String>) request.getAttribute("msg");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="リスナー登録 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/listener_signup.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
    
      <article class="article">
        <h2 class="article-title">リスナー登録</h2>
        <div class="article-content">
          <form
            action="${pageContext.request.contextPath}/listener_signup"
            method="post" novalidate name="myForm">
            <fieldset>
              <legend>リスナー情報登録</legend>
              <table>
                <caption>リスナー情報登録</caption>
                <tr>
                  <th class="form-header">
                    <label for="name">名前</label>
                  </th>
                  <td class="form-data">
                    <input id="name" type="text" name="user_name"
                    autofocus ng-model="name" required ng-maxlength="20">
                    <!-- angularJSの名前メッセージ -->
                    <p class="ang-errorMsg"
                      ng-show="myForm.user_name.$error.required">
	                      <img
                        src="${pageContext.request.contextPath}/img/no.png"
                        alt="err_img" title="エラー画像">名前を入力して下さい
	                  </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.user_name.$error.maxlength">
	                      <img
                        src="${pageContext.request.contextPath}/img/no.png"
                        alt="err_img" title="エラー画像">名前は20文字以内で入力して下さい
	                  </p>
                    <p class="ang-okMsg"
                      ng-show="myForm.user_name.$valid">
	                      <img
                        src="${pageContext.request.contextPath}/img/ok.png"
                        alt="ok_img" title="オーケー画像">
	                      OK
	                  </p>
                    <!-- /angularJSの名前メッセージ -->
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="email">メールアドレス</label>
                  </th>
                  <td class="form-data">
                    <input id="email" type="email" name="email"
                    autofocus ng-model="email" required
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
                    <label for="password">パスワード</label>
                  </th>
                  <td class="form-data">
                    <input id="password" type="password" name="password"
                    autofocus="" ng-model="password" required
                    ng-minlength="6" ng-maxlength="8">
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
                <tr>
                  <th class="form-header">性別</th>
                  <td class="form-data">
                    <input id="female" type="radio" name="sex" value="0"
                    checked="checked">
                    <label for="female">女性</label>
                    <input id="male" type="radio" name="sex" value="1">
                    <label for="male">男性</label>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">生年月日</th>
                  <td class="form-data">
                    <select id="year" name="year" class="year date">
                    <option value="0">---</option>
                    </select>
                    <label for="year">年</label>
                    <select id="month" name="month" class="month date">
                    <option value="0">---</option>
                    </select>
                    <label for="month">月</label>
                    <select id="day" name="day" class="day">
                    <option value="0">---</option>
                    </select>
                    <label for="day">日</label>
                  </td>
                </tr>
              </table>
            </fieldset>
            <p class="form-submit">
              <input type="submit" name="#" value="次へ">
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
