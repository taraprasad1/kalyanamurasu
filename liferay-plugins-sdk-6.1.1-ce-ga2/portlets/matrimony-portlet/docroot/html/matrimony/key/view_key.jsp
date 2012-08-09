<%@include file="/html/matrimony/init.jsp" %>
<!-- Create a serveResource URL -->
<portlet:resourceURL var="addKeyURL">
	<portlet:param name="<%= KeyValueConstants.ACTION %>" value="<%= KeyValueConstants.ADD_KEY %>"/>
</portlet:resourceURL>
<portlet:resourceURL var="deleteURL">
	<portlet:param name="<%= KeyValueConstants.ACTION %>" value="<%= KeyValueConstants.DELETE_KEY %>"/>
</portlet:resourceURL>
<%
	List<Key> keyNames = KeyLocalServiceUtil.getKeies(-1,-1);
%>
<div id="keyPortlet">
	<aui:form method="post" name="keyForm">
		<aui:input type="text" name="keyName" label="key-name" inlineField="true"/> 
		<aui:button type="button" name="saveButton" 
			onClick="addkey();"
			value="add-key" /><br/><br/>
		<aui:select name="keyList" multiple="true" label="key-list" inlineField="true">
			<% for(Key keies : keyNames) {%>
				<option value="<%= keies.getKeyId() %>" ><%= keies.getName() %></option>
			<%} %>
		</aui:select>
		<aui:button type="button" value="delete-key" onclick="validateKey()"/>
	</aui:form>
</div>
<script type="text/javascript">
	function addkey(){
		var keyName = jQuery("#<portlet:namespace />keyName").val();
		if(keyName != '') {
			var url = "<%= addKeyURL %>";
			jQuery.getJSON(url + '&keyName='+keyName, function(data) {
				if(data.validKey){
					var optionValue = '<option value=\"' + data.keyId + '\">' + data.keyName + '<option/>';
					jQuery("#<portlet:namespace/>keyName").val('');
					jQuery("#<portlet:namespace/>keyList").append(optionValue);
					alert("Key Added Successfully");
				} else {
					alert("Key Already Available!!!");
				}	
			});
		} else {
			alert('Please enter the key');
		}
	}
	function validateKey(){
		var text = jQuery("#<portlet:namespace />keyList option:selected").text();
		if(text == ""){
			alert('Please select keyName to delete');
			return false;
		} else {
			var check = confirm('Are you sure you want to delete the ' + text + ' key');
			if(check){
				var keyId = jQuery("#<portlet:namespace />keyList option:selected").val();
				var url = "<%= deleteURL %>";
				jQuery.getJSON(url + '&keyId='+keyId, function(data) {
					if(data.validKey){
						jQuery("#<portlet:namespace/>keyList option:selected").remove();
						alert("key Deleted Successfully");
					} else {
						alert("Unable to Delete Key");
					}	
				});
			} else {
				return false;
			}
		}
	}
</script>
<style type="text/css">
	#keyPortlet .aui-field-input, #keyPortlet .aui-field-labels-top .aui-field-input {
	    float: none;
	    width: 150px;
	}
	#keyPortlet .aui-field-inline .aui-field-label {
	    vertical-align: top;
	    width: 68px;
	}
</style>