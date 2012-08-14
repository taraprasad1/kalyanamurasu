<%@include file="/html/matrimony/profile/init.jsp" %>
<%
	String listType = "table";
%>
<c:if test='<%= listType.equalsIgnoreCase("table") %>'>
	<%@ include file="/html/matrimony/profile/list/table.jsp" %>
</c:if>