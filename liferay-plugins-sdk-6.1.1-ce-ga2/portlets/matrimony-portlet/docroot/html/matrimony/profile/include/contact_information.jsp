<%@include file="/html/matrimony/profile/init.jsp" %>

<%
	long profileId = ParamUtil.getLong(request, "profileId");
	Profile profile = new ProfileImpl();
	
	if(Validator.isNotNull(profileId)) {
		profile = ProfileLocalServiceUtil.getProfileObj(profileId);
	}
%>
<% List<Country> countries = CountryServiceUtil.getCountries(); %>
<portlet:resourceURL var="countryChangeURL">
	<portlet:param name="action" value="populateState" />
</portlet:resourceURL>
<portlet:resourceURL var="stateChangeURL">
	<portlet:param name="action" value="populateCity" />
</portlet:resourceURL>
<aui:model-context bean="<%= profile %>" model="<%= Profile.class %>" />
<aui:field-wrapper>
	<aui:select name="country" label="profile-country" inlineField="true" inputCssClass="selectBoxStyle required">
		<option value="" >Select</option>
		<%
		    for (Country country : countries) {
		    	if(profile.getCountry() > 0l) {
		%>
				  <option <% if(profile.getCountry() == country.getCountryId()) { %> selected="selected" <% } %> value="<%= country.getCountryId() %>" >
				  	<%= country.getName() %>
				  </option>
		<%
		  		} else {
		%>
					<option selected="selected" value="<%= country.getCountryId() %>" >
					  	<%= country.getName() %>
					</option>
		<%
		  		} 
		    }
		%>
	</aui:select><br/>
	<aui:select name="state" label="profile-state" inlineField="true" inputCssClass="selectBoxStyle required">
	</aui:select><br/>
	<aui:select name="city" label="profile-city" inlineField="true" inputCssClass="selectBoxStyle required">
	</aui:select><br/>
</aui:field-wrapper>
<aui:input type="textarea" name="address" label="profile-address" inlineField="true" inputCssClass="textBoxStyle required"/><br/>
<aui:input type="text" name="pinCode" label="profile-pin-code" inlineField="true" inputCssClass="textBoxStyle required"/><br/>
<aui:input type="text" name="phone" label="profile-phone" inlineField="true" inputCssClass="textBoxStyle required"/><br/>
<aui:input name="mobile" type="text" label="profile-mobile" inlineField="true" inputCssClass="textBoxStyle required"/><br/>
<aui:input name="emailAddress" type="text" label="profile-email-address" inlineField="true" inputCssClass="textBoxStyle required"/><br/>

<script type="text/javascript">
	jQuery(document).ready(function(){
		var prfoileCountryId = "<%= profile.getCountry() %>";
		var profileRegionId = "<%= profile.getState() %>";
		var profileCityId = "<%= profile.getCity() %>";
		
		if(prfoileCountryId > 0) {
			loadRegions(prfoileCountryId, profileRegionId);
			if(profileRegionId > 0) {
				loadCity(profileRegionId, profileCityId);
			}
		}
		 
		jQuery("#<portlet:namespace />country").change(function(){
			var countryId = jQuery("#<portlet:namespace />country option:selected").val();
			if(countryId != '') {
				loadRegions(countryId, 0);
			} else {
				jQuery("#<portlet:namespace />state option").remove();
				jQuery("#<portlet:namespace />city option").remove();
			}
		});
		jQuery("#<portlet:namespace />state").change(function(){
			var regionId = jQuery("#<portlet:namespace />state option:selected").val();
			if(regionId != '') {
				loadCity(regionId, 0);
			} else {
				jQuery("#<portlet:namespace />city option").remove();
			}
		});
	});
	
	function loadRegions(countryId, profileRegionId) {
		var url = "<%= countryChangeURL %>";
		jQuery("#<portlet:namespace />state option").remove();
		jQuery("#<portlet:namespace />city option").remove();
		jQuery.getJSON(url + '&countryId='+countryId, function(data) {
			if(data.isValid) {
				var states = data.arrayList;
				for(var i=0; i<states.length; i++){
					var stateValue = states[i].split(":");
					if(profileRegionId > 0 && profileRegionId == stateValue[0]) {
						jQuery("#<portlet:namespace />state").append("<option value="+ stateValue[0] +" selected='selected'>" + stateValue[1] + "</option>");
					} else {
						jQuery("#<portlet:namespace />state").append("<option value="+ stateValue[0] +">" + stateValue[1] + "</option>");
					}
				}
			}
		});
	}
	
	function loadCity(regionId, profileCityId) {
		var url = "<%= stateChangeURL %>";
		jQuery("#<portlet:namespace />city option").remove();
		jQuery.getJSON(url + '&regionId='+regionId, function(data) {
			jQuery("#<portlet:namespace />city").append("<option value='other'>Other</option>");
			if (data.isValid) {
				var cities = data.arrayList;
				for (var i=0; i<cities.length; i++) {
					var cityValue = cities[i].split(":");
					if (profileCityId > 0 && profileCityId == cityValue[0]) {
						jQuery("#<portlet:namespace />city").append("<option value="+ cityValue[0] +" selected='selected'>" + cityValue[1] + "</option>");
					} else {
						jQuery("#<portlet:namespace />city").append("<option value="+ cityValue[0] +">" + cityValue[1] + "</option>");
					}
				}
			}
		});
	}
</script>