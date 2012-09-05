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
<style type="text/css">

.magnifyarea{
	box-shadow: 5px 5px 7px #818181;
	-webkit-box-shadow: 5px 5px 7px #818181;
	-moz-box-shadow: 5px 5px 7px #818181;
	filter: progid:DXImageTransform.Microsoft.dropShadow(color=#818181, offX=5, offY=5, positive=true);
	background: white;
}

</style>

<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script> -->

<script type="text/javascript" src="/matrimony-portlet/js/featuredimagezoomer.js"></script>
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
	<img id="image<%= i %>" src="<%= viewImageURL %>" />&nbsp;&nbsp;&nbsp;
	<script type="text/javascript">
		jQuery(document).ready(function($){
			var imageId = "#image" + "<%= i %>";
			var imageURL = "<%= viewBigImageURL %>";
			$(imageId).addimagezoom({
				zoomrange: [3, 10],
				magnifiersize: [300,300],
				magnifierpos: 'right',
				cursorshade: true,
				largeimage: imageURL
			});
		});
	</script>
	<% i++; %>
<% } %>