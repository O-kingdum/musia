<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="ログイン | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/template/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/login.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">MUSIA - ログイン</h2>
        <div class="article-content">
          <form action="/login_user" method="post">
            <fieldset>
              <legend>ログイン情報</legend>
              <table>
                <caption>ログイン</caption>
                <tr>
                  <th class="form-header">
                    <label for="login-email">メールアドレス</label>
                  </th>
                  <td class="form-data">
                    <input id="login-email" type="email" name="mail"
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="login-password">パスワード</label>
                  </th>
                  <td class="form-data">
                    <input id="login-password" type="password"
                    name="passwd" autofocus="">
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
            <p class="form-back">
              <input type="button" value="戻る" onClick="history.back()">
            </p>
          </form>
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
