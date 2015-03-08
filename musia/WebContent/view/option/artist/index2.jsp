<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<UsersBean> users = (ArrayList<UsersBean>) request.getAttribute("users");
  @SuppressWarnings("unchecked")
  ArrayList<String> msg = (ArrayList<String>) request.getAttribute("msg");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="アーティスト情報 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/option_artist.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">アーティスト情報</h2>
        <div class="article-content">
          <form action="/artist" method="post">
            <fieldset>
              <legend>アーティスト登録情報</legend>
              <table>
                <caption>アーティスト登録</caption>
                <tr>
                  <th class="form-header">現在の金融機関</th>
                  <td class="form-data">金融機関</td>
                </tr>
                <tr>
                  <th class="form-header">新しい金融機関</th>
                  <td class="form-data">
                    <input id="re_mitsubishi" type="radio"
                    name="re_mitsubishi" value="mitsubishi"
                    checked="checked">
                    <label for="re_mitsubishi">三菱東京UFJ銀行</label>
                    <input id="re_mitsui" type="radio" name="re_mitsui"
                    value="mitsui">
                    <label for="re_mitsui">三井住友銀行</label>
                    <input id="re_mizuho" type="radio" name="re_mizuho"
                    value="mizuho">
                    <label for="re_mizuho">みずほ銀行</label>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="account_number">現在の口座番号</label>
                  </th>
                  <td class="form-data">口座番号</td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="account_number">新しい口座番号</label>
                  </th>
                  <td class="form-data">
                    <input id="re_account_number" type="text"
                    name="account_number" autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="branch_number">現在の支店番号</label>
                  </th>
                  <td class="form-data">支店番号</td>
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
                    <label for="account_name">現在の口座名義</label>
                  </th>
                  <td class="form-data">口座名義</td>
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
              <input type="submit" name="#" value="変更">
            </p>
          </form>
        </div>
        <p class="back">
          <a href="history.back()"><img
            src="${pageContext.request.contextPath}/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
