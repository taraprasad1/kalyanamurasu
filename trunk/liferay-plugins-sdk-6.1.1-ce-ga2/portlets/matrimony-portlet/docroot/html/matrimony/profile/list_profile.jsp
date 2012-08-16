<%@include file="/html/matrimony/profile/init.jsp" %>
<%
	String listType = "table";
%>
<c:if test='<%= SessionMessages.contains(request, "image-updated-successfully") %>' >
	<div class="portlet-msg-success"> <liferay-ui:message key="image-updated-successfully" /> </div>
</c:if>
<c:if test='<%= SessionMessages.contains(request, "image-added-successfully") %>' >
	<div class="portlet-msg-success"> <liferay-ui:message key="image-added-successfully" /> </div>
</c:if>
<c:if test='<%= SessionMessages.contains(request, "image-deleted-successfully") %>' >
	<div class="portlet-msg-success"> <liferay-ui:message key="image-deleted-successfully" /> </div>
</c:if>
<c:if test='<%= listType.equalsIgnoreCase("table") %>'>
	<%@ include file="/html/matrimony/profile/list/table.jsp" %>
</c:if>