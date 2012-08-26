<%@page import="com.matrimony.constant.ProfileConstants"%>
<%@include file="/html/matrimony/init.jsp" %>

<%@page import="javax.portlet.PortletPreferences"%>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="com.matrimony.service.ProfileLocalServiceUtil" %>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
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
<%@page import="com.matrimony.InvalidImageException"%>
<%@page import="com.matrimony.ImageSizeExceedsLimitException"%>
<%@page import="com.matrimony.InvalidImageTypeException"%>
<%@page import="com.matrimony.service.PhotoLocalServiceUtil"%>
<%@page import="com.matrimony.model.Photo"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%
	List<Profile> profileList = ProfileLocalServiceUtil.getProfileListByIndexer(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
%>