<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<UsersBean> users = (ArrayList<UsersBean>) request.getAttribute("users");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="アーティスト情報 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/option_artist.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">アーティスト情報</h2>
        <div class="article-content">
          <form action="/artist" method="post">
            <%
              if (users != null && users.size() > 0) {
                UsersBean user = users.get(0);
            %>
            <fieldset>
              <legend>アーティスト登録情報</legend>
              <table>
                <caption>アーティスト登録</caption>
                <tr>
                  <th class="form-header">現在の金融機関</th>
                  <td class="form-data"><%=user.getBank_name()%></td>
                </tr>
                <tr>
                  <th class="form-header">新しい金融機関</th>
                  <td class="form-data">
                    <input id="re_maru_bank" type="radio" name="re_bank"
                    value="maru_bank" checked="checked">
                    <label for="re_maru_bank">マル銀行</label>
                    <input id="re_batsu_bank" type="radio"
                    name="re_bank" value="batsu_bank">
                    <label for="re_batsu_bank">バツ銀行</label>
                    <input id="re_sankaku_bank" type="radio"
                    name="re_bank" value="sankaku_bank">
                    <label for="re_sankaku_bank">サンカク銀行</label>
                    <input id="re_shikaku_bank" type="radio"
                    name="re_bank" value="shikaku_bank">
                    <label for="re_shikaku_bank">シカク銀行</label>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="re_account_number">現在の口座番号</label>
                  </th>
                  <td class="form-data"><%=user.getBank_number()%></td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="re_account_number">新しい口座番号</label>
                  </th>
                  <td class="form-data">
                    <input id="re_account_number" type="text"
                    name="account_number" autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="re_branch_number">現在の支店番号</label>
                  </th>
                  <td class="form-data"><%=user.getBranch_code()%></td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="re_branch_number">新しい支店番号</label>
                  </th>
                  <td class="form-data">
                    <input id="re_branch_number" type="text"
                    name="branch_number" autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="re_account_name">現在の口座名義</label>
                  </th>
                  <td class="form-data"><%=user.getBank_persons()%></td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="re_account_name">新しい口座名義</label>
                  </th>
                  <td class="form-data">
                    <input id="re_account_name" type="text"
                    name="re_account_name" autofocus="" required>
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
