<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.matrimony.service.ProfileLocalServiceUtil"%>
<%@include file="/html/matrimony/profile/init.jsp" %>
<portlet:renderURL var="newProfileURL">
	<portlet:param name="jspPage" value="/html/matrimony/profile/edit_profile.jsp"/>
</portlet:renderURL>

<a href="<%= newProfileURL%>">Create account</a><br/><br/>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= com.matrimony.service.ProfileLocalServiceUtil.getProfiles(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ProfileLocalServiceUtil.getProfilesCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.matrimony.model.Profile"
		modelVar="aProfile"
	>
	
		<liferay-ui:search-container-column-text property="profileCode" />

		<liferay-ui:search-container-column-text property="name" />

		<liferay-ui:search-container-column-text property="religion" />

		<liferay-ui:search-container-column-text property="gender" />

		<liferay-ui:search-container-column-text property="emailAddress" />

		<liferay-ui:search-container-column-text name="Modified Date">
			<fmt:formatDate value="<%= aProfile.getModifiedDate() %>" pattern="dd/MMM/yyyy" />
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text property="motherTongue" />

		<liferay-ui:search-container-column-text property="country" />

		<liferay-ui:search-container-column-text property="state" />
		
		<liferay-ui:search-container-column-text>
			<%@ include file="/html/matrimony/profile/profile_actions.jsp" %>
		</liferay-ui:search-container-column-text>

		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
		
	