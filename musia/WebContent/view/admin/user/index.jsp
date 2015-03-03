<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="jp.co.musia.okingdum.Bean.*,java.util.ArrayList;" %>
<jsp:include page="/template/admin/template.jsp">
  <jsp:param value="ユーザ管理画面 | MUSIA" name="siteTitle" />
  <jsp:param value="${pageContext.request.contextPath}/css/vendor/reset.css" name="resetCss" />
  <jsp:param value="${pageContext.request.contextPath}/css/admin/template.css" name="templateCss"/>
  <jsp:param value="${pageContext.request.contextPath}/css/admin/admin_main.css" name="mainCss" />
  <jsp:param name="pageContents">
    <jsp:attribute name="value">
	<article>
		<h2>ユーザ管理画面</h2>
	<%
    @SuppressWarnings("unchecked")
    ArrayList<UsersBean> users = (ArrayList<UsersBean>)request.getAttribute("users");
    if( users != null && users.size() > 0 ) {
    %>
		<table class="adminTable">
			<caption>
			</caption>
			<thead>
				<tr>
					<th>ユーザＩＤ</th>
					<th>メールアドレス</th>
					<th>ユーザ名</th>
					<th>登録日</th>
					<th>ユーザ詳細</th>
				</tr>
			</thead>
			<tbody>
			<%
			for(UsersBean user : users) {
			%>
				<tr>
					<td><%= user.getUser_id() %></td>
					<td><%= user.getEmail() %></td>
					<td><%= user.getUser_name() %></td>
					<td><%= user.getEntry_date() %></td>
					<td>
						<button class="radiusBtn">
							<a href="<%= request.getContextPath() %>/user/detail?id=<%= user.getUser_id() %>">ユーザ詳細</a>
						</button>
					</td>
				</tr>
			<%
			}
			%>
			</tbody>
		</table>
	<%
    } else {
	%>
		<h2>ユーザが登録されていません</h2>
	<%
    }
	%>
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
