<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*, java.util.ArrayList;"%>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="コンテスト管理画面 | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/admin/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/admin/admin_main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
	<article>
		<h2>コンテスト管理画面</h2>
	<%
    @SuppressWarnings("unchecked")
    ArrayList<ContestBean> contests = (ArrayList<ContestBean>)request.getAttribute("contests");
	if( contests != null && contests.size() > 0 ) {
	%>
		<table>
			<thead>
				<tr>
					<th>コンテストＩＤ</th>
					<th>コンテスト名</th>
					<th>アーティスト名</th>
					<th>価格</th>
					<th>ジャンル</th>
				</tr>
			</thead>
			<tbody>
			<%
			for( ContestBean contest : contests ) {
			%>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			<%
			}
			%>
			</tbody>
		</table>
	<%
	} else {
	%>
		<h2>コンテストが登録されていません</h2>
	<%
	}
	%>
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
