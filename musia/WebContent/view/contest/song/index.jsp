<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="楽曲投稿 | コンテスト | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/contest_song.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">楽曲投稿</h2>
        <div class="article-content">
          <article>
            <form
              action="${pageContext.request.contextPath}/contest/song"
              method="post" enctype="multipart/form-data">
              <div>
                <input id="image" type="file" name="image" autofocus
                  required>
                <input type="submit" value="送信" class="form-submit">
              </div>
            </form>
          </article>
        </div>
        <p class="back">
          <a href="<%=request.getHeader("Referer")%>"><img
            src="${pageContext.request.contextPath}/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
