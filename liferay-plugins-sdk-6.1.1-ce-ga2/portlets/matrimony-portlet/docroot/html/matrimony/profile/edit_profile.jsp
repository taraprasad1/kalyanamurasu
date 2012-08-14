<%@page import="com.matrimony.service.ProfileLocalServiceUtil"%>
<%@page import="com.matrimony.model.Profile"%>
<%@page import="com.matrimony.model.impl.ProfileImpl"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.service.RegionServiceUtil"%>
<%@page import="com.liferay.portal.model.Region"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.matrimony.model.impl.KeyValueImpl"%>
<%@page import="com.matrimony.util.ProfileUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@include file="/html/matrimony/profile/init.jsp" %>
<%
	long profileId = ParamUtil.getLong(request, "profileId");
	System.out.println("profileId---->" + profileId);
	Profile profile = new ProfileImpl();
	PortletURL updateAccountURL = renderResponse.createActionURL();
	updateAccountURL.setParameter(ActionRequest.ACTION_NAME, "updateAccount");
	
	if(Validator.isNotNull(profileId)) {
		profile = ProfileLocalServiceUtil.getProfile(profileId);
	}	
%>
<div style="float: right;"><a href='<portlet:renderURL />'>&laquo; Back</a></div>
<div id="profilePortlet">
	<aui:form name="fm" method="post" action="<%= updateAccountURL.toString() %>">
		<aui:model-context bean="<%= profile %>" model="<%= Profile.class %>" />
		<aui:input type="hidden" name="profileId" label="name" inlineLabel="left"/>
		<liferay-ui:panel-container id="panel-container-1" extended="true" accordion="true" >
			<liferay-ui:panel id="profile-basic" title="Basic Information" collapsible="true" extended="true" >
				<%@ include file="/html/matrimony/profile/include/basic_information.jspf" %>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-personnel" title="Personnel Information" collapsible="true" extended="false" >
				<%@ include file="/html/matrimony/profile/include/personnel_information.jspf" %>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-contact" title="Contact Information" collapsible="true" extended="false" >
				<%@ include file="/html/matrimony/profile/include/contact_information.jspf" %>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-other" title="Other Information" collapsible="true" extended="false" >
				<%@ include file="/html/matrimony/profile/include/other_information.jspf" %>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	<aui:button type="submit" value="createAccount" ></aui:button> 
	</aui:form>
</div>
<style type="text/css">
	#profilePortlet .aui-field-input, #keyValuePortlet .aui-field-labels-top .aui-field-input {
	    float: none;
	    width: 160px;
	}
	#profilePortlet .aui-field-inline .aui-field-label, #profilePortlet .aui-field-label, #profilePortlet .aui-field-label-inline-label {
	    vertical-align: top;
	    width: 120px;
	}
</style>