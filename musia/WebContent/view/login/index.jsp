<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="ログイン | MUSIA" name="siteTitle" />
  <jsp:param value="../../css/vendor/reset.css" name="resetCss" />
  <jsp:param value="../../css/main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">MUSIA - ログイン</h2>
        <form class="article-form" action="#" method="#">
          <fieldset>
            <legend>ログイン情報</legend>
            <table>
              <caption>ログイン</caption>
              <tr>
                <th class="article-form-header">
                  <label for="login-email">メールアドレス</label>
                </th>
                <td class="article-form-data">
                  <input id="login-email" type="email" name="mail"
                  autofocus="">
                </td>
              </tr>
              <tr>
                <th class="article-form-header">
                  <label for="login-password">パスワード</label>
                </th>
                <td class="article-form-data">
                  <input id="login-password" type="password"
                  name="passwd" autofocus="">
                </td>
              </tr>
            </table>
          </fieldset>
          <p class="article-form-checkbox">
            <input id="memory" type="checkbox" name="#">
            <label for="memory">メールアドレスを記憶する</label>
          </p>
          <p class="article-form-submit">
            <input type="submit" name="#" value="ログイン">
          </p>
        </form>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
