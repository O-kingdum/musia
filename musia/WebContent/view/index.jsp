<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<%
  @SuppressWarnings("unchecked")
  ArrayList<AlbumBean> albums = (ArrayList<AlbumBean>) request.getAttribute("albums");
%>
<jsp:include page="/template/template.jsp">
  <jsp:param value="MUSIA-音楽ダウンロードサイトMUSIA" name="siteTitle" />
  <jsp:param
    value="${pageContext.request.contextPath}/css/template/template.css"
    name="templateCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/top.css"
    name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
      <article class="article">
        <h2 class="article-title">トップ</h2>
        <div class="article-content">
          <div class="clearfix">
            <%
              if (albums != null && albums.size() > 0) {
                for (AlbumBean album : albums) {
            %>
            <div class="grid_2">
              <a href="<%=album.getAlbum_id()%>">
                <img
                src="${pageContext.request.contextPath}/music_img/001.jpg"
                alt="<%=album.getAlbum_name()%>" />
              </a>
            </div>
            <div class="grid_2">
              <a href="<%=album.getAlbum_id()%>">
                <img
                src="${pageContext.request.contextPath}/music_img/002.jpg"
                alt="<%=album.getAlbum_name()%>" />
              </a>
            </div>
            <div class="grid_2">
              <a href="<%=album.getAlbum_id()%>">
                <img
                src="${pageContext.request.contextPath}/music_img/003.jpg"
                alt="<%=album.getAlbum_name()%>" />
              </a>
            </div>
            <div class="grid_2">
              <a href="<%=album.getAlbum_id()%>">
                <img
                src="${pageContext.request.contextPath}/music_img/004.jpg"
                alt="<%=album.getAlbum_name()%>" />
              </a>
            </div>
            <div class="grid_2">
              <a href="<%=album.getAlbum_id()%>">
                <img
                src="${pageContext.request.contextPath}/music_img/005.jpg"
                alt="<%=album.getAlbum_name()%>" />
              </a>
            </div>
            <div class="grid_2">
              <a href="<%=album.getAlbum_id()%>">
                <img
                src="${pageContext.request.contextPath}/music_img/006.jpg"
                alt="<%=album.getAlbum_name()%>" />
              </a>
            </div>
            <%
              }
            %>
            <%
              }
            %>
          </div>
        </div>
      </article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
