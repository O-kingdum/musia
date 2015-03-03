<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<Oikawa_PointBean> oikawa_point = (ArrayList<Oikawa_PointBean>) request.getAttribute("oikawa_users");
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
          <form action="/option/point" method="post">
            <fieldset>
              <legend>及川ポイント</legend>
              <table>
                <caption>及川ポイント購入</caption>
                <tr>
                  <th class="table-header">現在の及川ポイント</th>
                  <td class="table-data"></td>
                </tr>
                <tr>
                  <th class="table-header"><label for="prepaid-no">プリペイド番号</label></th>
                  <td class="table-data"><input id="prepaid-no"
                    type="text" name="" autofocus=""></td>
                </tr>
              </table>
              <p class="form-submit">
                <input type="submit" name="all" value="及川ポイント購入">
              </p>
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
