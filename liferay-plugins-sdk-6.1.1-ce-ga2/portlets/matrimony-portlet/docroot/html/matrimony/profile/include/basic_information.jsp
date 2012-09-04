<%@include file="/html/matrimony/profile/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>

<%
	long profileId = ParamUtil.getLong(request, "profileId");
	Profile profile = new ProfileImpl();
	
	if(Validator.isNotNull(profileId)) {
		profile = ProfileLocalServiceUtil.getProfileObj(profileId);
	}
	
	Calendar birthDate= CalendarFactoryUtil.getCalendar();
	if(profile.getBirthDateWithTime()!= null){
		birthDate.setTime(profile.getBirthDateWithTime());
	}
%>
<aui:model-context bean="<%= profile %>" model="<%= Profile.class %>" />
<aui:select name="createdForMy" label="profile-created-for" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${createdForMy}" var="createdForMyValue">
		<aui:option value="${createdForMyValue}" label="${createdForMyValue}" selected="${selectedCreatedForMyValue == createdForMyValue}"/>
	</c:forEach>
</aui:select><br/>

<aui:input type="text" name="name" label="profile-name" inlineField="true" inputCssClass="textBoxStyle required"/><br/>

<aui:field-wrapper name="gender" inlineField="true">
	<aui:input name="gender" type="radio" value="male" label="male" inlineField="true" inputCssClass="radioButtonStyle required" />
	<aui:input name="gender" type="radio" value="female" label="female"  inlineField="true" inputCssClass="radioButtonStyle"/>
</aui:field-wrapper>

<aui:input name="birthDateWithTime" value="<%= birthDate %>" /><br/>