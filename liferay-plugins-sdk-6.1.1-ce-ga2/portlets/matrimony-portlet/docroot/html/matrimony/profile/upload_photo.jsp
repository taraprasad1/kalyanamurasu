<%@include file="/html/matrimony/profile/init.jsp" %>
<%
	long profileId = ParamUtil.getLong(request, "profileId");
	PortletURL uploadPhotoURL = renderResponse.createActionURL();
	uploadPhotoURL.setParameter(ActionRequest.ACTION_NAME, "updatePhoto");
	uploadPhotoURL.setParameter("profileId", profileId + "");
	
%>
<liferay-ui:error exception="<%= InvalidImageTypeException.class %>" message="the-image-is-not-vaid-type" />
<liferay-ui:error exception="<%= ImageSizeExceedsLimitException.class %>" message="the-size-exceeds-limit" />
<liferay-ui:error exception="<%= InvalidImageException.class %>" message="image-invalid" />
<form name="uploadPhoto" action="<%= uploadPhotoURL.toString() %>" method="post" enctype="multipart/form-data">
	<aui:input name="profilePhoto" type="file" helpMessage="photo-upload-message"/>
	<aui:button value="upload" type="submit" />
	<aui:button value="cancel" type="button" />
</form>