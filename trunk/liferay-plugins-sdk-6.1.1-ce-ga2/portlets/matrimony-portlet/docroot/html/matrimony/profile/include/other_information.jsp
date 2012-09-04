<%@include file="/html/matrimony/profile/init.jsp" %>

<%
	long profileId = ParamUtil.getLong(request, "profileId");
	Profile profile = new ProfileImpl();
	
	if(Validator.isNotNull(profileId)) {
		profile = ProfileLocalServiceUtil.getProfileObj(profileId);
	}
%>
<%
	List<String> hobbiesList = CommonUtil.getValueList(profile.getHobbies());
%>
<aui:model-context bean="<%= profile %>" model="<%= Profile.class %>" />
<aui:select  name="education" label="profile-education" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${education}" var="educationValue">
		<aui:option value="${educationValue}" label="${educationValue}" selected="${selectedEducationValue == educationValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select  name="profession" label="profile-profession" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${profession}" var="professionValue">
		<aui:option value="${professionValue}" label="${professionValue}" selected="${selectedProfessionValue == professionValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select  name="currency" label="profile-currency" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${currency}" var="currencyValue">
		<aui:option value="${currencyValue}" label="${currencyValue}" selected="${selectedCurrencyValue == currencyValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select  name="annualIncome" label="profile-annual-income" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${annualIncome}" var="annualIncomeValue">
		<aui:option value="${annualIncomeValue}" label="${annualIncomeValue}" selected="${selectedAnnualIncomeValue == annualIncomeValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select name="hobbies" label="profile-hobbies" inlineField="true" inputCssClass="selectBoxStyle required"  multiple="true">
	<c:forEach items="${hobbies}" var="hobbiesValue">
		<c:set var="hobbiesVal" scope="page" value="${hobbiesValue}"/>
		<% if(Validator.isNotNull(hobbiesList) && hobbiesList.contains(pageContext.getAttribute("hobbiesVal"))){ %>
			<option selected="selected" value="${hobbiesValue}">
		<% } else { %>
			<option value="${hobbiesValue}">
		<% } %>
			${hobbiesValue}
		</option>
	</c:forEach>
</aui:select><br/>

<aui:input name="aboutMe" type="textarea" label="profile-about-me" inlineField="true" inputCssClass="textBoxStyle required"/><br/>

<aui:select  name="familyValue" label="profile-family-value" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${familyValue}" var="familyVal">
		<aui:option value="${familyVal}" label="${familyVal}" selected="${selectedFamilyVal == familyVal}"/>
	</c:forEach>
</aui:select><br/>
<aui:select  name="familyType" label="profile-family-type" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${familyType}" var="familyTypeValue">
		<aui:option value="${familyTypeValue}" label="${familyTypeValue}" selected="${selectedFamilyTypeValue == familyTypeValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select  name="familyStatus" label="profile-family-status" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${familyStatus}" var="familyStatusValue">
		<aui:option value="${familyStatusValue}" label="${familyStatusValue}" selected="${selectedFamilyStatusValue == familyStatusValue}"/>
	</c:forEach>
</aui:select><br/>