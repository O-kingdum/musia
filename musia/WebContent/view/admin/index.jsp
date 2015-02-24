<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="管理者ログイン | MUSIA" name="siteTitle" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2>MUSIA - 管理者ログイン</h2>
        <form action="#" method="post">
          <fieldset>
            <legend>ログイン情報</legend>
            <div>
            	<label for="">メールアドレス</label>
            	<input type="text" required autofocus>
            </div>
            <div>
            	<label for="">パスワード</label>
            	<input type="password" required>
            </div>
            <div>
            	<button type="submit">ログイン</button>
            </div>
          </fieldset>
        </form>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
