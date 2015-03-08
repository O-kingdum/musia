<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.ArrayList;"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="アーティスト登録 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/artist_signup.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">アーティスト登録</h2>
        <div class="article-content">
          <form action="${pageContext.request.contextPath}/artist_signup"
            method="post"  novalidate name="myForm">
            <fieldset>
              <legend>アーティスト登録情報</legend>
              <table>
                <caption>アーティスト情報登録</caption>
                <tr>
                  <th class="form-header">
                    <label for="image">アイコン画像</label>
                  </th>
                  <td class="form-data">
                    <input id="image" type="file" name="image"
                    autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="comment">コメント内容</label>
                  </th>
                  <td class="form-data">
                    <textarea id="comment" type="text" name="comment"
                      autofocus="" required></textarea>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">金融機関</th>
                  <td class="form-data">
                    <input id="maru_bank" type="radio" name="bank_name"
                    value="maru_bank" checked="checked">
                    <label for="maru_bank">マル銀行</label>
                    <input id="batsu_bank" type="radio" name="bank_name"
                    value="batsu_bank">
                    <label for="batsu_bank">バツ銀行</label>
                    <input id="sankaku_bank" type="radio" name="bank_name"
                    value="sankaku_bank">
                    <label for="sankaku_bank">サンカク銀行</label>
                    <input id="shikaku_bank" type="radio" name="bank_name"
                    value="shikaku_bank">
                    <label for="shikaku_bank">シカク銀行</label>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="account_number">口座番号</label>
                  </th>
                  <td class="form-data">
                    <input id="account_number" type="text"
                    name="bank_number" autofocus="" ng-model="bank_number" required ng-maxlength="10">
                    <!-- angularJSの口座番号メッセージ -->
                    <p class="ang-errorMsg"
                      ng-show="myForm.bank_number.$error.required">
                      <img src="${pageContext.request.contextPath}/img/no.png" alt="err_img" title="エラー画像">
                      口座番号を入力して下さい
                    </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.bank_number.$error.maxlength">
                      <img src="${pageContext.request.contextPath}/img/no.png" alt="err_img" title="エラー画像">
                      10文字以内で入力して下さい
                    </p>
                    <p class="ang-okMsg"
                      ng-show="myForm.bank_number.$valid">
                      <img src="${pageContext.request.contextPath}/img/ok.png" alt="ok_img" title="オーケー画像">
                      OK
                    </p>
                    <!-- /angularJSの口座番号エラーメッセージ -->
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="branch_number">支店番号</label>
                  </th>
                  <td class="form-data">
                    <input id="branch_number" type="text"
                    name="branch_code" autofocus="" ng-model="branch_code" required ng-minlength="3" ng-maxlength="3">
                    <!-- angularJSの支店番号メッセージ -->
                    <p class="ang-errorMsg"
                      ng-show="myForm.branch_code.$error.required">
                      <img src="${pageContext.request.contextPath}/img/no.png" alt="err_img" title="エラー画像">
                      支店番号を入力して下さい
                    </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.branch_code.$error.minlength">
                      <img src="${pageContext.request.contextPath}/img/no.png" alt="err_img" title="エラー画像">
                      3文字で入力して下さい
                    </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.branch_code.$error.maxlength">
                      <img src="${pageContext.request.contextPath}/img/no.png" alt="err_img" title="エラー画像">
                      3文字で入力して下さい
                    </p>
                    <p class="ang-okMsg"
                      ng-show="myForm.branch_code.$valid">
                      <img src="${pageContext.request.contextPath}/img/ok.png" alt="ok_img" title="オーケー画像">
                      OK
                   	</p>
                    <!-- /angularJSの支店番号メッセージ -->
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="account_name">口座名義</label>
                  </th>
                  <td class="form-data">
                    <input id="account_name" type="text"
                    name="bank_persons" autofocus="" ng-model="bank_persons" required ng-maxlength="20">
                    <!-- angularJSの口座名義メッセージ -->
                    <p class="ang-errorMsg"
                      ng-show="myForm.bank_persons.$error.required">
                      <img src="${pageContext.request.contextPath}/img/no.png" alt="err_img" title="エラー画像">
                      口座名義を入力して下さい
                    </p>
                    <p class="ang-errorMsg"
                      ng-show="myForm.bank_persons.$error.maxlength">
                      <img src="${pageContext.request.contextPath}/img/no.png" alt="err_img" title="エラー画像">
                      20文字以内で入力して下さい
                    </p>
                    <p class="ang-okMsg"
                      ng-show="myForm.bank_persons.$valid">
                      <img src="${pageContext.request.contextPath}/img/ok.png" alt="ok_img" title="オーケー画像">
                      OK
                    </p>
                    <!-- /angularJSの口座名義メッセージ -->
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
