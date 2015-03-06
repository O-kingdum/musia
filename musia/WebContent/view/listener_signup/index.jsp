<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.ArrayList;"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="リスナー登録 | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/vendor/reset.css"
    name="resetCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/listener_signup.css"
    name="mainCss" />
    
  <jsp:param value="${pageContext.request.contextPath}/js/vendor/jquery-1.11.2.min.js" name="jqueryJs" />
    
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
    
      <article class="article">
        <h2 class="article-title">リスナー登録</h2>
        <div class="article-content">
          <form
            action="${pageContext.request.contextPath}/listener_signup"
            method="post">
            <fieldset>
              <legend>リスナー情報登録</legend>
              <table>
                <caption>リスナー情報登録</caption>
                <tr>
                  <th class="form-header">
                    <label for="name">名前</label>
                  </th>
                  <td class="form-data">
                    <input id="name" type="text" name="user_name"
                    autofocus required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="email">メールアドレス</label>
                  </th>
                  <td class="form-data">
                    <input id="email" type="email" name="email"
                    autofocus required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="password">パスワード</label>
                  </th>
                  <td class="form-data">
                    <input id="password" type="password" name="password"
                    autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">性別</th>
                  <td class="form-data">
                    <input id="female" type="radio" name="sex" value="0"
                    checked="checked">
                    <label for="female">女性</label>
                    <input id="male" type="radio" name="sex" value="1">
                    <label for="male">男性</label>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">生年月日</th>
                  <td class="form-data">
                    <select id="year" name="year" class="year date">
                    <option value="0">---</option>
                    </select>
                    <label for="year">年</label>
                    <select id="month" name="month" class="month date">
                    <option value="0">---</option>
                    </select>
                    <label for="month">月</label>
                    <select id="day" name="day" class="day">
                    <option value="0">---</option>
                    </select>
                    <label for="day">日</label>
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
