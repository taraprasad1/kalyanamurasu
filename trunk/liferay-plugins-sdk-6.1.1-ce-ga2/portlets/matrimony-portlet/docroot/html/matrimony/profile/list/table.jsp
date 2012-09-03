<%
	List<Profile> profileList = ProfileLocalServiceUtil.getProfileListByIndexer(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
%>
<liferay-util:include page="/html/matrimony/profile/toolbar.jsp" servletContext="<%= getServletContext() %>">
	<liferay-util:param name="toolbarItem" value="view-all" />
</liferay-util:include>
<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= profileList %>"
		total="<%= profileList.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.matrimony.model.Profile"
		modelVar="aProfile"
	>
	
		<liferay-ui:search-container-column-text property="profileCode" name="profile-code"/>

		<liferay-ui:search-container-column-text property="name" name="profile-name"/>

		<liferay-ui:search-container-column-text property="religion" name="profile-religion"/>

		<liferay-ui:search-container-column-text name="profile-gender">
			<%= aProfile.getGender() ? "Male" : "Female" %>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text property="emailAddress" name="profile-email-address"/>

		<liferay-ui:search-container-column-text name="profile-modified-date">
			<fmt:formatDate value="<%= aProfile.getModifiedDate() %>" pattern="dd/MMM/yyyy" />
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text property="motherTongue" name="profile-mother-tongue"/>

		<liferay-ui:search-container-column-text property="country" name="profile-country"/>

		<liferay-ui:search-container-column-text property="state" name="profile-state"/>
		
		<liferay-ui:search-container-column-text name="profile-action">
			<%@ include file="/html/matrimony/profile/profile_actions.jsp" %>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>	