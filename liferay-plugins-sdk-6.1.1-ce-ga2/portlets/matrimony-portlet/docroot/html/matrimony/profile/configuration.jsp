<%@ include file="/html/matrimony/profile/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" ></liferay-portlet:actionURL>
<aui:form name="configurationForm" method="post" action="<%= configurationURL %>"> 
	List View
	<select name="listView" >
		<option value="Table" <% if(listView.equalsIgnoreCase("Table")) { %> selected="selected" <% } %>>Table</option>
		<option value="Abstract" <% if(listView.equalsIgnoreCase("Abstract")) { %> selected="selected" <% } %>>Abstract</option>
	</select>
	<aui:button type="submit" value="Save" />
</aui:form>
