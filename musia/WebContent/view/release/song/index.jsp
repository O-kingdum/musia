<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList ,jp.co.musia.okingdum.Utils.*;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<GenreBean> genres = (ArrayList<GenreBean>) request.getAttribute("genres");
  @SuppressWarnings("unchecked")
  ArrayList<String> msg = (ArrayList<String>) request.getAttribute("msg");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="楽曲投稿 | リリース | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/release_song.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">楽曲投稿</h2>
        <div class="article-content">
          <form action="${pageContext.request.contextPath}/release/song"
            method="post" enctype="multipart/form-data">
            <fieldset>
              <legend>楽曲情報登録</legend>
              <table>
                <caption>楽曲情報登録</caption>
                <tr>
                  <th class="form-header">
                    <label for="song_title">曲名</label>
                  </th>
                  <td class="form-data">
                    <input id="song_title" type="text"
                    name="product_name" autofocus required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="song_genre">ジャンル</label>
                  </th>
                  <td class="form-data">
                    <select id="song_genre" name="genre_id" required>
                      <%
                        if (genres != null && genres.size() > 0) {
                          for (GenreBean genre : genres) {
                      %>
                            <option value="<%=genre.getGenre_id()%>">
                            <%=Sanitizer.convertSanitize(genre.getGenre_name())%>
                            </option>
                          <%
                            }
                          %>
                        <%
                          } else {
                        %>
                            <option value="GE00001">ジャンルがありません。</option>
                        <%
                          }
                        %>
                    </select>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="song_scale">曲尺</label>
                  </th>
                  <td class="form-data">
                    <input id="song_scale" type="text" name="measure"
                    autofocus required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="file_type">ファイル種別</label>
                  </th>
                  <td class="form-data">
                    <input id="file_type" type="text" name="" autofocus
                    required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="song_comment">コメント</label>
                  </th>
                  <td class="form-data">
                    <textarea id="song_comment" name="remarks" cols="30"
                      rows="10" autofocus required>
                    </textarea>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="song_price">価格</label>
                  </th>
                  <td class="form-data">
                    <input id="song_price" type="text" name="price"
                    autofocus required>
                  </td>
                </tr>
                <tr>
                  <th class="form-header">
                    <label for="song_select">ファイル選択</label>
                  </th>
                  <td class="form-data">
                    <input id="song_select" type="file" name="file" />
                  </td>
                </tr>
              </table>
            </fieldset>
            <p class="form-submit">
              <input type="submit" name="#" value="リリース" />
            </p>
          </form>
        </div>
        <%
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
            src="${pageContext.request.contextPath}/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
