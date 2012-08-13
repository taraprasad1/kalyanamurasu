<%@page import="com.matrimony.service.ProfileLocalServiceUtil"%>
<%@page import="com.matrimony.model.Profile"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/html/matrimony/profile/init.jsp" %>
<% 
	Profile profile = null;
	long profileId = ParamUtil.getLong(request, "profileId");
	String backURL = ParamUtil.getString(request, "backURL");
	if(profileId > 0l) {
		profile = ProfileLocalServiceUtil.getProfile(profileId);
	}
%>
<liferay-ui:header backLabel="&laquo; Back to List" title="Profile Details" backURL="<%= backURL %>" />
<c:if test="<%= Validator.isNotNull(profileId) %>">
	<table cellspacing="5" height="350px" width="400px" align="center">
		<tr>
			<th>Name</th>
			<td><%= profile.getName() %></td>
		</tr>
		<tr>
			<th>Gender</th>
			<td><%= profile.getGender() %></td>
		</tr>
		<tr>
			<th>Height</th>
			<td><%= profile.getHeight() %></td>
		</tr>
		<tr>
			<th>Weight</th>
			<td><%= profile.getWeight() %></td>
		</tr>
		<tr>
			<th>Email Address</th>
			<td><%= profile.getEmailAddress() %></td>
		</tr>
		<tr>
			<th>Religion</th>
			<td><%= profile.getReligion() %></td>
		</tr>
		<tr>
			<th>Caste</th>
			<td><%= profile.getCaste() %></td>
		</tr>
		<tr>
			<th>Rasi</th>
			<td><%= profile.getRasi() %></td>
		</tr>
		<tr>
			<th>Country</th>
			<td><%= profile.getCountry() %></td>
		</tr>
		<tr>
			<th>State</th>
			<td><%= profile.getState() %></td>
		</tr>
		<tr>
			<th>city</th>
			<td><%= profile.getCity() %></td>
		</tr>
		<tr>
			<th>Mother Tongue</th>
			<td><%= profile.getMotherTongue() %></td>
		</tr>
		<tr>
			<th>Dosam</th>
			<td><%= profile.getDosam() %></td>
		</tr>
	</table>
</c:if>