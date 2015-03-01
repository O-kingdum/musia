<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">リスナー登録</h2>
        <div class="article-content">
          <form action="#" method="post">
            <fieldset>
              <legend>リスナー情報登録</legend>
              <table>
                <caption>リスナー情報登録</caption>
                <tr>
                  <th class="form-header">
                    <label for="name">名前</label>
                  </th>
                  <td class="form-data">
                    <input id="name" type="text" name="name"
                    autofocus="" required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="email">メールアドレス</label>
                  </th>
                  <td class="form-data">
                    <input id="email" type="email" name="mail"
                    autofocus="" required>
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
                    <input id="female" type="radio" name="sex"
                    value="female" checked="checked">
                    <label for="female">女性</label>
                    <input id="male" type="radio" name="sex"
                    value="male">
                    <label for="male">男性</label>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">生年月日</th>
                  <td class="form-data">
                    <select id="year">
                    <option>0001</option>
                    </select>
                    <label for="year">年</label>
                    <select id="month">
                    <option>01</option>
                    </select>
                    <label for="month">月</label>
                    <select id="day">
                    <option>01</option>
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
        <p class="back">
          <a href="history.back()"><img
            src="<%=request.getContextPath()%>/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
