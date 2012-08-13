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

<aui:form name="fm" method="post" action="<%= updateAccountURL.toString() %>">
<div style=" height:373px; width: 1100px;">
	<aui:model-context bean="<%= profile %>" model="<%= Profile.class %>" >
	<aui:input type="hidden" name="profileId" label="name" inlineLabel="left"/>
	<div style="float: left;  height: 400px; width: 314px;" >	
		<aui:select name="createdForMy" label="created-for" inlineField="true">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("createdFor")){ %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>
		</aui:select>
		<aui:input type="text" name="name" label="name" inlineLabel="left"/>
		<aui:input type="radio" name="gender" inlineLabel="right" inlineField="true" checked="<%=true %>" label="male" value="male"/>
		<aui:input type="radio" name="gender" inlineLabel="right"  label="female" value="female"/>
		
		<aui:select name="rasi" label="rasi" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("rasi")) { %>
				<aui:option value="<%= values.getName() %>" ><%= values.getName() %></aui:option>
			<% } %>		
		</aui:select>
		<aui:select name="star" label="star" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("star")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>	
		</aui:select>
		<aui:select name="dosam" label="dosam" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("dosam")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>		
		</aui:select>
		<aui:select name="religion" label="religion" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("religion")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>		
		</aui:select>
		<aui:select name="caste" label="caste" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("caste")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>		
		</aui:select>
		<aui:select name="subCaste" label="subCaste" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("subCaste")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>	
		</aui:select>
		<aui:select name="height" label="height" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("height")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>		
		</aui:select>
		<aui:select name="weight" label="weight" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("weight")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>		
		</aui:select>
		<aui:select name="complexion" label="complexion" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("complexion")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>	
		</aui:select>
		<aui:select name="motherTongue" label="motherTongue" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("motherTongue")) { %>	
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>	
		</aui:select>
		<aui:select name="languageKnown" label="languageKnown" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("languageKnown")) { %>	
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>	
		</aui:select>
		<aui:select name="maritalStatus" label="maritalStatus" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("maritalStatus")) { %>	
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>	
		</aui:select>
		<aui:input type="text" name="children" label="children" inlineLabel="left" />
	</div>
	<div style="float: left; height: 390px; width: 385px;" >
		<aui:select name="country" label="country" inlineLabel="left">
			<% for(Country country : CountryServiceUtil.getCountries()) { %>
				<aui:option value="<%= country.getName() %>"><%= country.getName() %></aui:option>
			<% } %>
		</aui:select>
		<aui:select name="state" label="state" inlineLabel="left">
			<% for(Region region : RegionServiceUtil.getRegions()) { %>
				<aui:option value="<%= region.getName() %>"><%= region.getName() %></aui:option>
			<% } %>
		</aui:select>
		<aui:select name="city" label="city" inlineLabel="left">
			<% for(KeyValue values : ProfileUtil.getKeyValueList("city")) { %>
				<aui:option value="<%= values.getName() %>"><%= values.getName() %></aui:option>
			<% } %>
		</aui:select>
		<aui:input type="textarea" name="address" label="address" inlineLabel="left" />
		<aui:input type="text" name="pinCode" label="pinCode" inlineLabel="left" />
		<aui:input type="text" name="phone" label="phone" inlineLabel="left" />
		<aui:input name="mobile" type="text" label="mobile" inlineLabel="left" />
		<aui:input name="emailAddress" type="text" label="emailAddress" inlineLabel="left" />
		<aui:input name="education" type="text" label="education" inlineLabel="left" />
		<aui:input name="profession" type="text" label="profession" inlineLabel="left" />
		<aui:input name="currency" type="text" label="currency" inlineLabel="left" />
	</div>
	<div style="float: left; height: 380px; width: 385px;" >
		<aui:input name="annualIncome" type="text" label="annualIncome" inlineLabel="left" />
		<aui:input name="hobbies" type="text" label="hobbies" inlineLabel="left" />
		<aui:input name="aboutMe" type="text" label="aboutMe" inlineLabel="left" />
		<aui:input name="familyValue" type="text" label="familyValue" inlineLabel="left" />
		<aui:input name="familyType" type="text" label="familyType" inlineLabel="left" />
		<aui:input name="familyStatus" type="text" label="familyStatus" inlineLabel="left" />
		<aui:input name="securityCode" type="text" label="securityCode" inlineLabel="left" />
		<aui:input name="photoSecurityCode" type="text" label="photoSecurityCode" inlineLabel="left" />
		<aui:input name="status" type="text" label="status" inlineLabel="left" />
		<aui:input name="scheme" type="text" label="scheme" inlineLabel="left" />
		<aui:input name="horoscope" type="text" label="horoscope" inlineLabel="left" value="true"/>		
	</div> 
	</aui:model-context>
</div> 
<aui:button type="submit" value="createAccount" ></aui:button> 
</aui:form>