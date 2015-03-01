<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<UsersBean> users = (ArrayList<UsersBean>) request.getAttribute("users");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="リスナー情報 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/option_listener.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">リスナー情報</h2>
        <div class="article-content">
          <%
            if (users != null && users.size() > 0) {
              for (UsersBean user : users) {
          %>
          <form action="/" method="post">
            <fieldset>
              <legend>リスナー情報変更</legend>
              <table>
                <caption>リスナー情報変更</caption>
                <tr>
                  <th class="form-header">現在の名前</th>
                  <td class="form-data"><%=user.getUser_name()%></td>
                </tr>
                <tr>
                  <th class="form-header"><label for="re_name">新しい名前</label></th>
                  <td class="form-data"><input id="re_name"
                    type="text" name="re_name" autofocus="" required></td>
                </tr>
                <tr>
                  <th class="form-header">現在のメールアドレス</th>
                  <td class="form-data"><%=user.getEmail()%></td>
                </tr>
                <tr>
                  <th class="form-header">新しいメールアドレス</th>
                  <td class="form-data"><input id="re_email"
                    type="email" name="re_email" autofocus="" required></td>
                </tr>
                <tr>
                  <th class="form-header">現在のパスワード</th>
                  <td class="form-data"><%=user.getPassword()%></td>
                </tr>
                <tr>
                  <th class="form-header">新しいパスワード</th>
                  <td class="form-data"><input id="re_password"
                    type="password" name="re_password" autofocus=""
                    required></td>
                </tr>
                <tr>
                  <th class="form-header">現在の性別</th>
                  <td class="form-data"><%=user.getSex()%></td>
                </tr>
                <tr>
                  <th class="form-header">新しい性別</th>
                  <td class="form-data">
                    <input id="re_female" type="radio" name="re_sex"
                    value="female" checked="checked">
                    <label for="female">女性</label>
                    <input id="re_male" type="radio" name="re_sex"
                    value="male">
                    <label for="male">男性</label>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">生年月日</th>
                  <td class="form-data"><%=user.getBirthday()%></td>
                </tr>
                <tr>
                  <th class="form-header">生年月日</th>
                  <td class="form-data">
                    <select id="re_year">
                    <option>0001</option>
                    </select>
                    <label for="re_year">年</label>
                    <select id="re_month">
                    <option>01</option>
                    </select>
                    <label for="re_month">月</label>
                    <select id="re_day">
                    <option>01</option>
                    </select>
                    <label for="re_day">日</label>
                  </td>
                </tr>
              </table>
            </fieldset>
            <p class="form-submit">
              <input type="submit" name="#" value="変更">
            </p>
          </form>
          <%
            }
            }
          %>
        </div>
        <p class="back">
          <a href="<%= request.getContextPath() %>">戻る</a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
