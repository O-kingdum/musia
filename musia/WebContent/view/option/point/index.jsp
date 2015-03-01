<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<Oikawa_PointBean> oikawa_point = (ArrayList<Oikawa_PointBean) request.getAttribute("oikawa_users");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="及川ポイント購入 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/option_point.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">及川ポイント購入</h2>
        <div class="article-content">
          
        </div>
        <p class="back">
          <input type="button" value="戻る" onClick="history.back()">
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
