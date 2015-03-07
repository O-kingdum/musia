<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="コンテスト | MUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/contest.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">コンテスト</h2>
        <div class="article-content">
          <form action="/cart" method="post">
            <fieldset>
              <legend>コンテスト</legend>
              
              <p>齋藤達朗に相応しい曲を</p>
              <h2>SEクリエイターコンテスト開催決定！</h2>
              
              <p>
	              世界的サウンドクリエイターの齋藤達朗から、自分に相応しい曲を作ってくれ！という依頼がきぞ！<br>
	              みんなの熱い挑戦を待ってるぜ！
              </p>
              
              <table>
                <caption>コンテスト</caption>
                <tbody>
                  <tr>
                    <td class="table-data">コンテスト表題</td>
                    <td class="table-data">SEクリエイターコンテスト</td>
                  </tr>
                  <tr>
                    <td class="table-data">主催企業名</td>
                    <td class="table-data">齋藤達朗株式会社</td>
                  </tr>
                  <tr>
                    <td class="table-data">募集期間</td>
                    <td class="table-data">2015-01-01 ~ 2015-02-01</td>
                  </tr>
                  <tr>
                    <td class="table-data">募集総数</td>
                    <td class="table-data">12</td>
                  </tr>
                  <tr>
                    <td class="table-data">募集要項</td>
                    <td class="table-data">
                      応募データは2分以内、データは4MBまで。<br>
                      齋藤達朗に相応しいカッコイイものであればOK！<br>
                      採用者報酬：10000円
                    </td>
                  </tr>
                </tbody>
              </table>
            </fieldset>
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
