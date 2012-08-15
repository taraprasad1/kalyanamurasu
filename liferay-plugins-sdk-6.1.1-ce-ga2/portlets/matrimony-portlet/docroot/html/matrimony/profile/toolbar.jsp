<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@include file="/html/matrimony/init.jsp" %>

<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view");
%>

<div class="lfr-portlet-toolbar">
	<portlet:renderURL var="viewURL" />
 
	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : StringPool.BLANK %>">
		<a href="<%= viewURL %>"><liferay-ui:message key="view-all" /></a>
	</span>
	
	<liferay-ui:icon-menu align="left" cssClass='<%= "lfr-toolbar-button add-button " + (toolbarItem.equals("add") ? "current" : StringPool.BLANK) %>' direction="down" extended="<%= false %>" icon='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>' message="add" showWhenSingleIcon="<%= true %>">
	<portlet:renderURL var="newProfileURL">
		<portlet:param name="jspPage" value="/html/matrimony/profile/edit_profile.jsp"/>
	</portlet:renderURL>

		<liferay-ui:icon
			image="user_icon"
			message="profile"
			url="<%= newProfileURL %>"
		/>
		
		</liferay-ui:icon-menu>
</div>