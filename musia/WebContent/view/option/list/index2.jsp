<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<V_ProductsBean> products = (ArrayList<V_ProductsBean>) request.getAttribute("products");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="気になる | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/list.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">気になる</h2>
        <div class="article-content">
          <form action="${pageContext.request.contextPath}/option/list" method="post">
            <fieldset>
              <legend>気になる情報</legend>
              <table>
                <caption>気になる</caption>
                <thead>
                  <tr>
                    <th class="table-header">タイトル</th>
                    <th class="table-header">アーティスト</th>
                    <th class="table-header">ジャンル</th>
                    <th class="table-header">価格</th>
                    <th class="table-header"><label for="cart_add">カートに追加</label></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td class="table-data">ああああ</td>
                    <td class="table-data"><a href="">いいいい</a></td>
                    <td class="table-data">うううう</td>
                    <td class="table-data">ええええ</td>
                    <td class="table-data"><input id="cart_add"
                      type="checkbox" name="cart_add"></td>
                  </tr>
                </tbody>
              </table>
              <p class="form-submit">
                <input type="submit" name="all" value="カートに追加">
              </p>
            </fieldset>
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
