<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="リスナー登録 | MUSIA" name="siteTitle" />
  <jsp:param value="../../css/vendor/reset.css" name="resetCss" />
  <jsp:param value="../../css/main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">MUSIA - リスナー登録</h2>
        <form class="article-form" action="#" method="#">
          <fieldset>
            <legend>リスナー登録情報</legend>
            <table>
              <caption>リスナー登録</caption>
              <tr>
                <th class="article-form-header">
                  <label for="name">ユーザ名</label>
                </th>
                <td class="article-form-data">
                  <input id="name" type="text" name="lname" autofocus=""
                  required>
                </td>
              </tr>
              <tr>
                <th class="article-form-header">
                  <label for="email">メールアドレス</label>
                </th>
                <td class="article-form-data">
                  <input id="email" type="email" name="mail"
                  autofocus="" required>
                </td>
              </tr>
              <tr>
                <th class="article-form-header">
                  <label for="password">パスワード</label>
                </th>
                <td class="article-form-data">
                  <input id="password" type="password" name="passwd"
                  autofocus="" required>
                </td>
              </tr>
              <tr>
                <th class="article-form-header">性別</th>
                <td class="article-form-data">
                  <input id="female" type="radio" name="sex"
                  value="female" checked="checked">
                  <label for="female">女性</label>
                  <input id="male" type="radio" name="sex" value="male">
                  <label for="male">男性</label>
                </td>
              </tr>
              <tr>
                <th class="article-form-header">生年月日</th>
                <td class="article-form-data">
                  <select id="year">
                  <option>0000</option>
                  </select>
                  <label for="year">年</label>
                  <select id="month">
                  <option>01</option>
                  <option>02</option>
                  <option>03</option>
                  <option>04</option>
                  <option>05</option>
                  <option>06</option>
                  <option>07</option>
                  <option>08</option>
                  <option>09</option>
                  <option>10</option>
                  <option>11</option>
                  <option>12</option>
                  </select>
                  <label for="month">月</label>
                  <select id="day">
                  <option>01</option>
                  <option>02</option>
                  <option>03</option>
                  <option>04</option>
                  <option>05</option>
                  <option>06</option>
                  <option>07</option>
                  <option>08</option>
                  <option>09</option>
                  <option>10</option>
                  <option>11</option>
                  <option>12</option>
                  <option>13</option>
                  <option>14</option>
                  <option>15</option>
                  <option>16</option>
                  <option>17</option>
                  <option>18</option>
                  <option>19</option>
                  <option>20</option>
                  <option>21</option>
                  <option>22</option>
                  <option>23</option>
                  <option>24</option>
                  <option>25</option>
                  <option>26</option>
                  <option>27</option>
                  <option>28</option>
                  <option>29</option>
                  <option>30</option>
                  <option>31</option>
                  </select>
                  <label for="day">日</label>
                </td>
              </tr>
            </table>
          </fieldset>
          <p class="article-form-submit">
            <input type="submit" name="#" value="次へ">
          </p>
        </form>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
