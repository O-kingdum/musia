<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="アーティスト登録 | MUSIA" name="siteTitle" />
  <jsp:param value="#" name="resetCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">アーティスト登録</h2>
        <div class="article-content">
          <form action="#" method="post">
            <fieldset>
              <legend>アーティスト登録情報</legend>
              <table>
                <caption>アーティスト登録</caption>
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
                      autofocus="" required>コメント内容を、入力してください。</textarea>
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
                    <label for="course_number">講座番号</label>
                  </th>
                  <td class="form-data">
                    <input id="course_number" type="text"
                    name="course_number" autofocus="" required>
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
                    <label for="course_name">講座名義</label>
                  </th>
                  <td class="form-data">
                    <input id="course_name" type="text"
                    name="course_name" autofocus="" required>
                  </td>
                </tr>
              </table>
            </fieldset>
            <p class="form-submit">
              <input type="submit" name="#" value="次へ">
            </p>
          </form>
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
