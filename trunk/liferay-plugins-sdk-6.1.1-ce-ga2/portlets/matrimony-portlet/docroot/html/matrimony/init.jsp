<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects />
<theme:defineObjects />

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@page import="com.matrimony.constant.KeyValueConstants"%>
<%@page import="com.matrimony.model.KeyValue"%>
<%@page import="com.matrimony.service.KeyLocalServiceUtil"%>
<%@page import="com.matrimony.model.Key"%>

