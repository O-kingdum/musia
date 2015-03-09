<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  ProductsBean products = (ProductsBean) request.getAttribute("products");
  @SuppressWarnings("unchecked")
  ArrayList<String> msg = (ArrayList<String>) request.getAttribute("msg");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="商品詳細 | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/song.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <header class="article-title">
          <h2>商品詳細</h2>
        </header>
        <div class="article-content">
          <form action="${pageContext.request.contextPath}/cartadd"
            method="post">
            <%
              if (products != null) {
            %>
            <header class="song-title">
              <h3><%=products.getProduct_name()%></h3>
              <p>
                <input type="submit" value="いいね！" />
              </p>
            </header>
            <div class="song-content">
              <div class="song-img">
                <figure>
                  <img
                    src="<%=request.getContextPath()%><%=products.getImg_path()%>"
                    alt="<%=products.getProduct_name()%>" />
                  <figcaption><%=products.getProduct_name()%></figcaption>
                </figure>
              </div>
              <div>
                <div class="song-artist">
                  <p>
                    <a href=""><%=products.getArtist_name()%></a>
                  </p>
                </div>
                <div class="song-audio">
                  <audio
                    src="http://localhost:8080<%=products.getDirectory_path()%>"
                    controls></audio>
                </div>
                <div class="song-remarks">
                  <p><%=products.getRemarks()%></p>
                </div>
                <div class="song-add">
                  <ul>
                    <li>
                      <input type="hidden" name="id"
                      value="<%=products.getProduct_id()%>" />
                      <input type="submit" name="list" value="気になるに追加" />
                    </li>
                    <li>
                      <input type="submit" name="cart" value="カートに追加" />
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            <%
              } else {
            %>
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
            <%
              }
            %>
          </form>
        </div>
        <p class="back">
          <a href="<%=request.getHeader("Referer")%>"><img
            src="${pageContext.request.contextPath}/img/pageback.png"
            alt="戻る" /></a>
        </p>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
