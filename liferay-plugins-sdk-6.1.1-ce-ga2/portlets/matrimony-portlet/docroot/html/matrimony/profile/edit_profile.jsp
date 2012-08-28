<%@include file="/html/matrimony/profile/init.jsp" %>
<script type="text/javascript" src="/matrimony-portlet/js/jquery.min.js"></script>
<%
	long profileId = ParamUtil.getLong(request, "profileId");
	Profile profile = new ProfileImpl();
	
	if(Validator.isNotNull(profileId)) {
		profile = ProfileLocalServiceUtil.getProfileObj(profileId);
	}
%>
<portlet:actionURL var="updateAccountURL" >
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="updateAccount" />
</portlet:actionURL>
<portlet:renderURL var="cancelURL"/>
<div id="profilePortlet">
	<aui:form name="fm" method="post" action="<%= updateAccountURL %>">
		<aui:model-context bean="<%= profile %>" model="<%= Profile.class %>" />
		<aui:input type="hidden" name="profileId" label="name"/>
		<liferay-ui:panel-container id="panel-container-1" extended="true" accordion="true" >
			<liferay-ui:panel id="profile-basic" title="Basic Information" collapsible="false" extended="true" >
				<%@ include file="/html/matrimony/profile/include/basic_information.jspf" %>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-personnel" title="Personnel Information" collapsible="false" extended="false" >
				<%@ include file="/html/matrimony/profile/include/personnel_information.jspf" %>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-contact" title="Contact Information" collapsible="false" extended="false" >
				<%@ include file="/html/matrimony/profile/include/contact_information.jspf" %>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-other" title="Other Information" collapsible="false" extended="false" >
				<%@ include file="/html/matrimony/profile/include/other_information.jspf" %>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		<aui:button-row>
			<aui:button type="submit" value="createAccount" />
			<input type="button" value="Cancel" onClick="location.href='<%= cancelURL %>'"/>
		</aui:button-row>
	</aui:form>
</div>
<style type="text/css">
	#profilePortlet .textBoxStyle {
	    float: none;
	    width: 160px;
	}
	
	#profilePortlet .selectBoxStyle {
	    float: none;
	    width: 164px;
	    height: auto;
	}
	
	#profilePortlet .radioButtonStyle {
	    float: none;
	    width: 13px;
	}
	#profilePortlet .aui-field-inline .aui-field-label, #profilePortlet .aui-field-label, #profilePortlet .aui-field-label-inline-label {
	    vertical-align: top;
	    width: 120px;
	}
	#profilePortlet .aui-choice-label {
	    font-weight: normal;
	    vertical-align: middle;
	}
</style>