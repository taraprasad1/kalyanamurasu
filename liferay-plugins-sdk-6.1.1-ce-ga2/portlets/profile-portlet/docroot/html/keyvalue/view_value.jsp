<%@include file="/html/profile/init.jsp" %>

<portlet:renderURL var="valueListURL" />
<portlet:resourceURL var="addKeyValueURL">
	<portlet:param name="<%= KeyValueConstants.ACTION %>" value="<%= KeyValueConstants.ADD_KEY_VALUE %>"/>
</portlet:resourceURL>
<portlet:resourceURL var="deleteKeyValueURL">
	<portlet:param name="<%= KeyValueConstants.ACTION %>" value="<%= KeyValueConstants.DELETE_KEY_VALUE %>"/>
</portlet:resourceURL>
<% 
	List<Key> keyNames = KeyLocalServiceUtil.getKeies(-1, -1);
	long keyId = 0l;
	List<KeyValue> keyValueList = new ArrayList<KeyValue>();
	if(Validator.isNotNull(renderRequest.getAttribute(KeyValueConstants.KEY_ID))){
		keyId = (Long)renderRequest.getAttribute(KeyValueConstants.KEY_ID);
		if(Validator.isNotNull(renderRequest.getAttribute(KeyValueConstants.KEY_VALUE_LIST))){
			keyValueList = (List<KeyValue>)renderRequest.getAttribute(KeyValueConstants.KEY_VALUE_LIST);
		}
	}
%>
<div id="keyValuePortlet">
	<aui:form name="keyForm" action="<%= valueListURL %>" method="post">
		<span style="font-weight:bold;padding-right:33px;"><liferay-ui:message key="select-key-name" /></span>
		<select name="keyId" id="keyId" onChange="valueList();" style="width:153px;">
			<% for(Key keies : keyNames) { %>
				<option value="<%= keies.getKeyId() %>" <%if(keyId == keies.getKeyId()) {%>selected="selected"<% } %>>
					<%=keies.getName() %>
				</option>
			<% } %>
		</select>
	</aui:form><br/><br/>
	<% if(keyId > 0l) {%>
		<aui:form method="post" name="keyValueForm">
			<aui:input type="text" name="keyValueName" label="key-value-name" inlineField="true"/> 
			<aui:button type="button" name="saveButton" 
				onClick="addKeyValue();"
				value="add-key-value" /><br/><br/>
			<aui:select name="keyValueList" multiple="true" label="key-value-list" inlineField="true">
				<% for(KeyValue value : keyValueList) { %>
					<option value="<%= value.getValueId() %>" ><%= value.getName() %></option>
				<%} %>
			</aui:select>
			<aui:button type="button" value="delete-key-value" onclick="deleteKeyValue();"/>
		</aui:form>
	<% } %>
</div>
<script type="text/javascript">
	function valueList() {
		jQuery("#<portlet:namespace />keyForm").submit();
	}
	function addKeyValue(){
		var keyValueName = jQuery("#<portlet:namespace />keyValueName").val();
		var keyId = jQuery("#keyId").val();
		if(keyValueName != '' && keyId != '') {
			var url = "<%= addKeyValueURL %>" + "&keyId=" + keyId + "&keyValueName=" + keyValueName;
			jQuery.getJSON(url, function(data) {
				if(data.validKeyValue){
					var optionValue = '<option value=\"' + data.keyValueId + '\">' + data.keyValueName + '<option/>';
					jQuery("#<portlet:namespace/>keyValueName").val('');
					jQuery("#<portlet:namespace/>keyValueList").append(optionValue);
					alert("KeyValue Added Successfully");
				} else {
					alert("KeyValue Already Available!!!");
				}	
			});
		} else {
			alert('Please enter the keyValue');
		}
	}
	function deleteKeyValue(){
		var text = jQuery("#<portlet:namespace />keyValueList option:selected").text();
		if(text == ""){
			alert('Please select keyValue to delete');
			return false;
		} else {
			var check = confirm('Are you sure you want to delete the ' + text + ' key');
			if(check){
				var keyValueId =jQuery("#<portlet:namespace />keyValueList option:selected").val();
				var url = "<%= deleteKeyValueURL %>";
				jQuery.getJSON(url + '&keyValueId='+keyValueId, function(data) {
					if(data.validKeyValue){
						jQuery("#<portlet:namespace/>keyValueList option:selected").remove();
						alert("key Deleted Successfully");
					} else {
						alert("Unable to Delete keyValue");
					}	
				});
			} else {
				return false;
			}
		}
	}
</script>
<style type="text/css">
	#keyValuePortlet .aui-field-input, #keyValuePortlet .aui-field-labels-top .aui-field-input {
	    float: none;
	    width: 150px;
	}
	#keyValuePortlet .aui-field-inline .aui-field-label {
	    vertical-align: top;
	    width: 90px;
	}
</style>