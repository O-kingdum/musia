<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<ProductsBean> products = (ArrayList<ProductsBean>) request.getAttribute("products");
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
          <form action="" method="post">
            <%
              if (products != null && products.size() > 0) {
                ProductsBean product = products.get(0);
            %>
            <header class="song-title">
              <h3><%=product.getProduct_name()%></h3>
              <p>
                <input type="submit" value="いいね！" />
              </p>
            </header>
            <div class="song-content">
              <div class="song-img">
                <figure>
                  <img src="<%=product.getImg_path()%>"
                    alt="<%=product.getProduct_name()%>" />
                  <figcaption><%=product.getProduct_name()%></figcaption>
                </figure>
              </div>
              <div>
                <div class="song-artist">
                  <p>
                    <a href=""><%=product.getArtist_name()%></a>
                  </p>
                </div>
                <div class="song-audio">
                  <audio
                    src="http://localhost:8080<%=request.getContextPath()%>/audio/Alive.m4a"
                    controls></audio>
                </div>
                <div class="song-remarks">
                  <p><%=product.getRemarks()%></p>
                </div>
                <div class="song-add">
                  <ul>
                    <li><input type="submit" value="気になるに追加" /></li>
                    <li><input type="submit" value="カートに追加" /></li>
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
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
