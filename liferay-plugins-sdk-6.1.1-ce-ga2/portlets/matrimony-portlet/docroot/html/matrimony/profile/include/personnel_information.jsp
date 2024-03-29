<%@include file="/html/matrimony/profile/init.jsp" %>

<%
	long profileId = ParamUtil.getLong(request, "profileId");
	Profile profile = new ProfileImpl();
	
	if(Validator.isNotNull(profileId)) {
		profile = ProfileLocalServiceUtil.getProfileObj(profileId);
	}

	List<Religion> religionList = ReligionLocalServiceUtil.getReligions(-1, -1);
	List<String> languageKnownList = CommonUtil.getValueList(profile.getLanguageKnown());
%>

<portlet:resourceURL var="religionChangeURL">
	<portlet:param name="action" value="populateCaste" />
</portlet:resourceURL>
<portlet:resourceURL var="casteChangeURL">
	<portlet:param name="action" value="populateSubCaste" />
</portlet:resourceURL>
<aui:model-context bean="<%= profile %>" model="<%= Profile.class %>" />
<aui:field-wrapper>
	<aui:select name="religion" label="profile-religion" inlineField="true" inputCssClass="selectBoxStyle required">
		<option value="" >Select</option>
		<%
		    for (Religion religion : religionList) {
		%>
		  <option <% if(profile.getReligion() == religion.getReligionId()) { %> selected="selected" <% } %> value="<%= religion.getReligionId() %>" >
		  	<%= religion.getName() %>
		  </option>
		<%
		  }
		%>
	</aui:select><br/>
    <div id="casteDiv">
		<aui:select name="caste" label="profile-caste" inlineField="true" inputCssClass="selectBoxStyle required">
		</aui:select><br/>
	</div>
	<div id="subCasteDiv">
		<aui:select name="subCaste" label="profile-sub-caste" inlineField="true" inputCssClass="selectBoxStyle required">
		</aui:select><br/>
	</div>
</aui:field-wrapper>
<aui:select name="rasi" label="profile-rasi" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${rasi}" var="rasiValue">
		<aui:option value="${rasiValue}" label="${rasiValue}" selected="${selectedRasiValue == rasiValue}"/>
	</c:forEach>	
</aui:select><br/>
<aui:select name="star" label="profile-star" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${star}" var="starValue">
		<aui:option value="${starValue}" label="${starValue}" selected="${selectedStarValue == starValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select name="dosam" label="profile-dosam" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${dosam}" var="dosamValue">
		<aui:option value="${dosamValue}" label="${dosamValue}" selected="${selectedDosamValue == dosamValue}"/>
	</c:forEach>	
</aui:select><br/>
<aui:select name="height" label="profile-height" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${height}" var="heightValue">
		<aui:option value="${heightValue}" label="${heightValue}" selected="${selectedHeightValue == heightValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select name="weight" label="profile-weight" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${weight}" var="weightValue">
		<aui:option value="${weightValue}" label="${weightValue}" selected="${selectedWeightValue == weightValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select name="complexion" label="profile-complexion" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${complexion}" var="complexionValue">
		<aui:option value="${complexionValue}" label="${complexionValue}" selected="${selectedComplexionValue == complexionValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select name="motherTongue" label="profile-mother-tongue" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${language}" var="motherTongueValue">
		<aui:option value="${motherTongueValue}" label="${motherTongueValue}" selected="${selectedMotherTongueValue == motherTongueValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select name="languageKnown" label="profile-language-known" inlineField="true" inputCssClass="selectBoxStyle required"  multiple="true">
	<c:forEach items="${language}" var="languageKnownValue">
		<c:set var="languageVal" scope="page" value="${languageKnownValue}"/>
		<% if(Validator.isNotNull(languageKnownList) && languageKnownList.contains(pageContext.getAttribute("languageVal"))){ %>
			<option selected="selected" value="${languageKnownValue}">
		<% } else { %>
			<option value="${languageKnownValue}">
		<% } %>
			${languageKnownValue}
		</option>
	</c:forEach>
</aui:select><br/>
<aui:select name="maritalStatus" label="profile-marital-status" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${maritalStatus}" var="maritalStatusValue">
		<aui:option value="${maritalStatusValue}" label="${maritalStatusValue}" selected="${selectedMaritalStatusValue == maritalStatusValue}"/>
	</c:forEach>
</aui:select><br/>
<aui:select name="children" label="profile-children" inlineField="true" inputCssClass="selectBoxStyle required">
	<aui:option value="" label="select" />
	<c:forEach items="${children}" var="childrenValue">
		<aui:option value="${childrenValue}" label="${childrenValue}" selected="${selectedChildrenValue == childrenValue}"/>
	</c:forEach>
</aui:select><br/>


<script type="text/javascript">
	jQuery(document).ready(function(){
		var profileReligionId = "<%= profile.getReligion() %>";
		var profileCasteId = "<%= profile.getCaste() %>";
		var profileSubCasteId = "<%= profile.getSubCaste() %>";
		
		if(profileReligionId > 0) {
			loadCatse(profileReligionId, profileCasteId);
			if(profileCasteId > 0) {
				loadSubCaste(profileCasteId, profileSubCasteId);
			}
		}
		
		jQuery("#<portlet:namespace />religion").change(function(){
			var religionId = jQuery("#<portlet:namespace />religion option:selected").val();
			if(religionId != '') {
				loadCatse(religionId, 0);
			} else {
				jQuery("#<portlet:namespace />caste option").remove();
				jQuery("#<portlet:namespace />subCaste option").remove();
			}
		});
		jQuery("#<portlet:namespace />caste").change(function(){
			var casteId = jQuery("#<portlet:namespace />caste option:selected").val();
			if(casteId != '') {
				loadSubCaste(casteId, 0);
			} else {
				jQuery("#<portlet:namespace />subCaste option").remove();
			}
		});
	});
	
	function loadCatse(religionId, profileCasteId) {
		var url = "<%= religionChangeURL %>";
		jQuery("#<portlet:namespace />caste option").remove();
		jQuery("#<portlet:namespace />subCaste option").remove();
		jQuery.getJSON(url + '&religionId='+religionId, function(data) {
			if(data.isValid) {
				var castes = data.arrayList;
				for(var i=0; i<castes.length; i++){
					var casteValue = castes[i].split(":");
					if(profileCasteId > 0 && profileCasteId == casteValue[0]) {
						jQuery("#<portlet:namespace />caste").append("<option value="+ casteValue[0] +" selected='selected'>" + casteValue[1] + "</option>");
					} else {
						jQuery("#<portlet:namespace />caste").append("<option value="+ casteValue[0] +">" + casteValue[1] + "</option>");
					}
				}
			}
		});
	}
	
	function loadSubCaste(casteId, profileSubCasteId) {
		var url = "<%= casteChangeURL %>";
		jQuery("#<portlet:namespace />subCaste option").remove();
		jQuery.getJSON(url + '&casteId='+casteId, function(data) {
			jQuery("#<portlet:namespace />subCaste").append("<option value='other'>Other</option>");
			if(data.isValid) {
				var subCastes = data.arrayList;
				for(var i=0; i<subCastes.length; i++){
					var subCasteValue = subCastes[i].split(":");
					if(profileSubCasteId > 0 && profileSubCasteId == subCasteValue[0]) {
						jQuery("#<portlet:namespace />subCaste").append("<option value="+ subCasteValue[0] +" selected='selected'>" + subCasteValue[1] + "</option>");
					} else {
						jQuery("#<portlet:namespace />subCaste").append("<option value="+ subCasteValue[0] +">" + subCasteValue[1] + "</option>");
					}
				}
			}
		});
	}
</script>