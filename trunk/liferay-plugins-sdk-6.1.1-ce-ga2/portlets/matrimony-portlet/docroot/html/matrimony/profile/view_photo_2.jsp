<%@include file="/html/matrimony/profile/init.jsp" %>
<% 
	Profile profile = null;
	long profileId = ParamUtil.getLong(request, "profileId");
	String backURL = ParamUtil.getString(request, "backURL");
	if(profileId > 0l) {
		profile = ProfileLocalServiceUtil.getProfileObj(profileId);
	}
	List<Photo> photoList = new ArrayList<Photo>();
	photoList = PhotoLocalServiceUtil.getPhotoList(profileId);
%>
<link href="/matrimony-portlet/css/cloud-zoom.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript" src="/matrimony-portlet/js/cloud-zoom.1.0.2.min.js"></script>
 
<% 
	int i=1;
	for(Photo photo: photoList) {
%>
	<portlet:resourceURL var="viewImageURL" >
		<portlet:param name="imageId" value='<%= photo.getPhotoId() + "" %>' />
		<portlet:param name="thumbnail" value="true" />
	</portlet:resourceURL>
	<portlet:resourceURL var="viewBigImageURL" >
		<portlet:param name="imageId" value='<%= photo.getPhotoId() + "" %>' />
		<portlet:param name="thumbnail" value="false" />
	</portlet:resourceURL>
	<% if(i==1) {%>
	  	<a href='<%= viewBigImageURL %>' class = 'cloud-zoom' id='zoom1'
	        rel="adjustX: 160, adjustY:40">
	        <img src="<%= viewImageURL %>" alt='' title="Optional title display" />
	    </a>
	<% } %>
	<a href='<%= viewBigImageURL %>' class='cloud-zoom-gallery' title='Thumbnail<%= i %>'
    	rel="useZoom: 'zoom1', smallImage: '<%= viewImageURL %>' ">
    <img src="<%= viewImageURL %>" alt = "Thumbnail<%= i %>"/></a>
   
	<% i++; %>
<% } %>