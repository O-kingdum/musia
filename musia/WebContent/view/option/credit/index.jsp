<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<CreditCardBean> cards = (ArrayList<CreditCardBean>) request.getAttribute("cards");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="クレジットカード情報 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/option_credit.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">クレジットカード情報</h2>
        <div class="article-content">
          <form action="/option/artist" method="post">
            <%
              if (cards != null && cards.size() > 0) {
                CreditCardBean card = cards.get(0);
            %>
            <fieldset>
              <legend>クレジットカード情報変更</legend>
              <table>
                <caption>クレジットカード情報変更</caption>
                <tr>
                  <th class="form-header">現在のカード番号</th>
                  <td class="form-data"><%=card.getCard_number()%></td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-no">新しいカード番号</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-no" type="text" name=""
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">現在のカード有効期限</th>
                  <td class="form-data"><%=card.getLimit_date()%></td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-date">新しいカード有効期限</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-date" type="" name="" autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">現在のカード会社</th>
                  <td class="form-data"><%=card.getCard_company()%></td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-cname">新しいカード会社</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-cname" type="text" name=""
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">現在のセキュリティーコード</th>
                  <td class="form-data"><%=card.getSec_cord()%></td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-security">新しいセキュリティコード</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-security" type="text" name=""
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">現在のカード名義人</th>
                  <td class="form-data"><%=card.getCard_persons()%></td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-Nominee">新しいカード名義人</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-Nominee" type="text" name=""
                    autofocus="">
                  </td>
                </tr>
              </table>
            </fieldset>
            <p class="form-submit">
              <input type="submit" name="#" value="変更">
            </p>
          </form>
        </div>
        <%
          } else {
        %>
          <%
            @SuppressWarnings("unchecked")
              ArrayList<String> msg = (ArrayList<String>) request.getAttribute("msg");
              if (msg != null && msg.size() > 0) {
          %>
            <ul>
              <%
                for (String str : msg) {
              %>
              <li><%=str%></li>
              <%
                }
              %>
            </ul>
          <%
            }
          %>
        <%
          }
        %>
        <p class="back">
          <a href="history.back()"><img
            src="<%=request.getContextPath()%>/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
