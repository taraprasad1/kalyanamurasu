<liferay-ui:icon-menu>
	<portlet:renderURL var="viewURL">
		<portlet:param name="profileId" value="<%= String.valueOf(aProfile.getProfileId()) %>" />
		<portlet:param name="jspPage" value="/html/matrimony/profile/view_profile.jsp" />
		<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="view" message="View Profile" url="<%= viewURL %>"/>
	
	<portlet:renderURL var="editURL">
		<portlet:param name="jspPage" value="/html/matrimony/profile/edit_profile.jsp" />
		<portlet:param name="profileId" value="<%= String.valueOf(aProfile.getProfileId()) %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit Profile" url="<%= editURL %>" />
	
	<portlet:actionURL var="deleteURL">
		<portlet:param name="<%= javax.portlet.ActionRequest.ACTION_NAME %>" value="deleteAccount" />
		<portlet:param name="profileId" value="<%= String.valueOf(aProfile.getProfileId()) %>" />				
	</portlet:actionURL>
	<liferay-ui:icon image="delete" message="Delete Profile" url="<%= deleteURL %>" />
	
	<portlet:renderURL var="editPhotoURL">
		<portlet:param name="jspPage" value="/html/matrimony/profile/upload_photo.jsp" />
		<portlet:param name="profileId" value="<%= String.valueOf(aProfile.getProfileId()) %>" />				
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit Photo" url="<%= editPhotoURL %>" />
</liferay-ui:icon-menu>