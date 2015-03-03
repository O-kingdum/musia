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
              <legend>お支払い選択情報</legend>
              <table>
                <caption>お支払い選択</caption>
                <thead>
                  <tr>
                    <th>選択</th>
                    <th>お支払い方法</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><input type="radio" name="select" value=""></td>
                    <td><img
                      src="<%=request.getContextPath()%>/img/mc.png"
                      alt="" /></td>
                  </tr>
                  <tr>
                    <td><input type="radio" name="select" value=""></td>
                    <td><img
                      src="<%=request.getContextPath()%>/img/visa.png"
                      alt="" /></td>
                  </tr>
                  <tr>
                    <td><input type="radio" name="select" value=""></td>
                    <td><img
                      src="<%=request.getContextPath()%>/img/jcb.png"
                      alt="" /></td>
                  </tr>
                </tbody>
              </table>
            </fieldset>
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