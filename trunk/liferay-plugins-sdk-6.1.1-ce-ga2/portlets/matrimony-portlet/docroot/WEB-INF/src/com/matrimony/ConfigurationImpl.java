package com.matrimony;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationImpl extends DefaultConfigurationAction {
	
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String listView = ParamUtil.getString(actionRequest, "listView");
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		if(Validator.isNotNull(preferences)) {
			preferences.setValue("listView",listView);
			preferences.store();
		}
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

}
