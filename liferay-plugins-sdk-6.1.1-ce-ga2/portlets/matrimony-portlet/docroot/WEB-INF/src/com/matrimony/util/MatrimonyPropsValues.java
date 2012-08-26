package com.matrimony.util;

import com.liferay.util.portlet.PortletProps;
import com.matrimony.constant.MatrimonyPropsKeys;

public class MatrimonyPropsValues {
	public static String IMAGE_TYPES = PortletProps.get(MatrimonyPropsKeys.IMAGE_TYPES);
	public static int IMAGE_SIZE = Integer.parseInt(PortletProps.get(MatrimonyPropsKeys.IMAGE_SIZE));
	public static int IMAGE_HEIGHT = Integer.parseInt(PortletProps.get(MatrimonyPropsKeys.IMAGE_HEIGHT));
	public static int IMAGE_WIDTH = Integer.parseInt(PortletProps.get(MatrimonyPropsKeys.IMAGE_WIDTH));
	public static String PROFILE_PORTLET_ID = PortletProps.get(MatrimonyPropsKeys.PROFILE_PORTLET_ID);
}
