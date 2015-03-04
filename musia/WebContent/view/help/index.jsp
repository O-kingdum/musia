<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="ヘルプ | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">ヘルプ</h2>
        <div class="article-content">
	        
          <ul>
	          <li><a href="">1.このサイトの使い方</a></li>
	          <li><a href="">2.ユーザー登録の方法</a></li>
	          <li><a href="">3.クレジットカードの登録方法</a></li>
	          <li><a href="">4.曲のアップロード方法</a></li>
	          <li><a href="">5.コンテストに参加する方法</a></li>
	          <li><a href="">6.困った時は</a></li>
          </ul>
          
        </div>
        <p class="back">
          <a href="history.back()"><img
            src="<%=request.getContextPath()%>/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
