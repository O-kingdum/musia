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
    	UsersBean user = users.get(0);
    %>
		<table class="adminTable">
			<caption>
			ユーザ詳細
			</caption>
			<tbody>
				<tr>
					<th>ユーザＩＤ</th><td><%= user.getUser_id() %></td>
				</tr>
				<tr>
					<th>メールアドレス</th><td><%= user.getEmail() %></td>
				</tr>
				<tr>
					<th>ユーザ名</th><td><%= user.getUser_name() %></td>
				</tr>
				<tr>
					<th>生年月日</th><td><%= user.getBirthday() %></td>
				</tr>
				<tr>
					<th>ユーザ詳細</th><td><%= user.getSelf_introduction() %></td>
				</tr>
				<tr>
					<th>登録日</th><td><%= user.getEntry_date() %></td>
				</tr>
				<tr>
					<th colspan="2">振込先銀行</th>
				</tr>
				<tr>
					<th>銀行名</th><td><%= user.getBank_name() %></td>
				</tr>
				<tr>
					<th>口座番号</th><td><%= user.getBank_number() %></td>
				</tr>
				<tr>
					<th>支店番号</th><td><%= user.getBranch_code() %></td>
				</tr>
				<tr>
					<th>口座名義人</th><td><%= user.getBank_persons() %></td>
				</tr>
			</tbody>
		</table>
	<%
    } else {
	%>
		<h2>ユーザが見つかりません。</h2>
	<%
    }
	%>
	</article>
    </jsp:attribute>
  </jsp:param>
</jsp:include>
