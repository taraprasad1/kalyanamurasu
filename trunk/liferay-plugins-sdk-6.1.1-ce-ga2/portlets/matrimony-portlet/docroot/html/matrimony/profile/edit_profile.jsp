<%@include file="/html/matrimony/profile/init.jsp" %>

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
		<liferay-ui:panel-container id="profile-pannel" cssClass="profilecontainer" extended="true">
			<liferay-ui:panel id="profile-basic" cssClass="profilepannel" title="Basic Information">
				<jsp:include page="/html/matrimony/profile/include/basic_information.jsp"></jsp:include>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-personnel" cssClass="profilepannel" title="Personnel Information">
				<jsp:include page="/html/matrimony/profile/include/personnel_information.jsp"></jsp:include>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-contact" cssClass="profilepannel" title="Contact Information">
				<jsp:include page="/html/matrimony/profile/include/contact_information.jsp"></jsp:include>
			</liferay-ui:panel>
			<liferay-ui:panel id="profile-other" cssClass="profilepannel" title="Other Information">
				<jsp:include page="/html/matrimony/profile/include/other_information.jsp"></jsp:include>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		<aui:button-row>
			<aui:button type="button" value="Create Account" onClick="validateAndSubmitForm()" />
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
	#profilePortlet .profilepannel {
	    padding: 4px;
	}
	#profilePortlet .profilecontainer {
	   
	}
	
	#profilePortlet .lfr-panel-container {
	    background-color: transparent;
	    border: medium none;
	}

	#profilePortlet .lfr-panel-container .lfr-panel {
	    margin-bottom: 7px;
	    margin-top: 7px;
	}
	
	#profilePortlet .lfr-panel-container .lfr-extended.lfr-collapsible .lfr-panel-titlebar {
	    border: 1px solid #CECECE;
	}
	
	#profilePortlet .lfr-panel.lfr-extended .lfr-panel-titlebar {
	    background: none repeat scroll 0 0 #CCFFFF;
	    line-height: 1.6;
	    padding: 2px;
	}
	
	#profilePortlet {
	    background: none repeat scroll 0 0 #FFFFFF;
	    border: 1px solid #CCCCCC;
	    line-height: 22px;
	    padding: 4px;
	}
	
	#profilePortlet select {
	    padding: 2px;
	}
	
	#profilePortlet .aui-datepicker-button-wrapper {
	    margin: -2px 5px 0 4px;
	}
	
	.invalidfield{
		font-weight:bold;
		color:red;
	}
</style>

<script type="text/javascript">
	jQuery(document).ready(function(){
		
	});
	
	function validateAndSubmitForm() {
		var validForm = true;
		jQuery(".invalidfield").remove();
		var portletNameSpace = "<portlet:namespace />";
		jQuery(".required").each(function(){
			var value = this.value;
			var name = this.name;
			if (this.type == 'radio') {
				var radioVal = jQuery("input:radio[name='"+this.name+"']").is(":checked");
	        	if (!radioVal) {
	        		var fieldName = jQuery(this).parent().parent().parent().parent().find("label[for='" + name + "']").text();
	        		jQuery(this).parent().parent().parent().parent().append("<span class='invalidfield'>"+ fieldName +" is Mandatory</span>");
	        		validForm = false;
	        	}
			} else {
				var fieldName = jQuery(this).parent().parent().find("label[for='" + name + "']").text();
				if(isEmpty(fieldName)){
					name = name.replace(portletNameSpace,"");
					fieldName = jQuery(this).parent().parent().find("label[for='" + name + "']").text();
				}
				if(isEmpty(value) && !isEmpty(fieldName)){
					jQuery(this).parent().parent().append("<span class='invalidfield'>"+ fieldName +" is Mandatory</span>");
					validForm = false;
				} else if(isEmpty(value)) {
					jQuery(this).parent().parent().append("<span class='invalidfield'>Field is Mandatory</span>");
					validForm = false;
				}
			}
		});
		if(validForm) {
			jQuery("#<portlet:namespace />fm").submit();
		} else {
			alert("Please Fill The Mandaory Fields And Submit");
		}
	}
	
	function trim(s) {		
		s = s.replace(/(^\s*)|(\s*$)/gi,"");		
		s = s.replace(/\n /,"\n");		
		return s;
	}
	
	function isEmpty(value)
	{
		value = trim(value);
	    return value == '';
	}
</script>