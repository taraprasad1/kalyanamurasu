<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

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
<%@page import="com.matrimony.util.CommonUtil"%>
<%@page import="com.matrimony.constant.ProfileConstants"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.matrimony.constant.KeyValueConstants"%>
<%@page import="com.matrimony.model.KeyValue"%>
<%@page import="com.matrimony.service.KeyLocalServiceUtil"%>
<%@page import="com.matrimony.model.Key"%>
<%@page import="com.matrimony.service.ReligionLocalServiceUtil"%>
<%@page import="com.matrimony.model.Religion"%>

<script type="text/javascript" src="/matrimony-portlet/js/jquery.min.js" ></script>

<portlet:defineObjects />
<theme:defineObjects />