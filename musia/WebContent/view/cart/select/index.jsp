<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="お支払い選択 | カート | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/cart_select.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">お支払い選択</h2>
        <div class="article-content">
          <form action="" method="post">
            <fieldset>
              <legend>カート情報</legend>
              <table>
                <caption>カート</caption>
                <thead>
                  <tr>
                    
                  </tr>
                </thead>
            <input type="radio" name="" value="" checked="checked">
            <input type="radio" name="" value="">
            <input type="radio" name="" value="">
          </form>
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