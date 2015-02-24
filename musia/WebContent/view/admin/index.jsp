<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="管理者ログイン | MUSIA" name="siteTitle" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">MUSIA - 管理者ログイン</h2>
          <form action="#" method="post">
            <fieldset>
              <legend>ログイン情報</legend>
            </fieldset>
          </form>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
