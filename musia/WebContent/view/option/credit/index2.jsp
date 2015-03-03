<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<CreditCardBean> credit_card = (ArrayList<CreditCardBean>) request.getAttribute("credit_card");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="クレジット追加 | MUSIA" name="siteTitle" />
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
        <h2 class="article-title">クレジットカード追加</h2>
        <div class="article-content">
          <form action="/list" method="post">
            <fieldset>
              <legend>クレジットカード情報</legend>
              <table>
                <caption>登録済みクレジットカード</caption>
                <thead>
                  <tr>
                    <th class="table-header">カードID</th>
                    <th class="table-header">カード番号</th>
                    <th class="table-header">カード有効期限</th>
                    <th class="table-header">カード会社名</th>
                    <th class="table-header">セキュリティコード</th>
                    <th class="table-header">カード名義人</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td class="table-data"></td>
                    <td class="table-data"></td>
                    <td class="table-data"></td>
                    <td class="table-data"></td>
                    <td class="table-data"></td>
                    <td class="table-data"></td>
                  </tr>
                </tbody>
              </table>
              <p>クレジットカードが登録されていません</p>
            </fieldset>
          </form>
          <form action="#" method="post">
            <fieldset>
              <legend>クレジットカード情報</legend>
              <table>
                <caption>クレジットカード追加</caption>
                <tr>
                  <th class="form-header">
                    <label for="credit-id">カードID</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-id" type="text" name="#"
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-no">カード番号</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-no" type="text" name=""
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-date">カード有効期限</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-date" type="" name="" autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-cname">カード会社名</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-cname" type="text" name=""
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-security">セキュリティコード</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-security" type="text" name=""
                    autofocus="">
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="credit-Nominee">カード名義人</label>
                  </th>
                  <td class="form-data">
                    <input id="credit-Nominee" type="text" name=""
                    autofocus="">
                  </td>
                </tr>
              </table>
            </fieldset>
            <p class="form-submit">
              <input type="submit" name="#" value="カードを追加">
            </p>
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
