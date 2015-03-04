<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.ArrayList;"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="アーティスト登録 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/artist_signup.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">アーティスト登録</h2>
        <div class="article-content">
          <form action="${pageContext.request.contextPath}/artist"
            method="post">
            <fieldset>
              <legend>アーティスト登録情報</legend>
              <table>
                <caption>アーティスト情報登録</caption>
                <tr>
                  <th class="form-header">
                    <label for="image">アイコン画像</label>
                  </th>
                  <td class="form-data">
                    <input id="image" type="file" name="image"
                    autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="comment">コメント内容</label>
                  </th>
                  <td class="form-data">
                    <textarea id="comment" type="text" name="comment"
                      autofocus="" required></textarea>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">金融機関</th>
                  <td class="form-data">
                    <input id="maru_bank" type="radio" name="bank"
                    value="maru_bank" checked="checked">
                    <label for="maru_bank">マル銀行</label>
                    <input id="batsu_bank" type="radio" name="bank"
                    value="batsu_bank">
                    <label for="batsu_bank">バツ銀行</label>
                    <input id="sankaku_bank" type="radio" name="bank"
                    value="sankaku_bank">
                    <label for="sankaku_bank">サンカク銀行</label>
                    <input id="shikaku_bank" type="radio" name="bank"
                    value="shikaku_bank">
                    <label for="shikaku_bank">シカク銀行</label>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="account_number">口座番号</label>
                  </th>
                  <td class="form-data">
                    <input id="account_number" type="text"
                    name="account_number" autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="branch_number">支店番号</label>
                  </th>
                  <td class="form-data">
                    <input id="branch_number" type="text"
                    name="branch_number" autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="account_name">口座名義</label>
                  </th>
                  <td class="form-data">
                    <input id="account_name" type="text"
                    name="account_name" autofocus="" required>
                  </td>
                </tr>
              </table>
            </fieldset>
            <p class="form-submit">
              <input type="submit" name="#" value="次へ">
            </p>
          </form>
        </div>
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
        <p class="back">
          <a href="history.back()"><img
            src="<%=request.getContextPath()%>/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
