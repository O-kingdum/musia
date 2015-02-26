<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="オプション | MUSIA" name="siteTitle" />
  <jsp:param value="" name="resetCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">オプション</h2>
        <div class="article-content">
          <ul>
            <li><a href="<%=request.getContextPath()%>/view/option/listener.jsp">リスナー情報</a></li>
            <li><a href="<%=request.getContextPath()%>/view/option/artist.jsp">アーティスト情報</a></li>
            <li><a href="<%=request.getContextPath()%>/view/option/credit.jsp">クレジットカード情報</a></li>
            <li><a href="<%=request.getContextPath()%>/view/option/point.jsp">及川ポイント購入</a></li>
          </ul>
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
