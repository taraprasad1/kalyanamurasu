/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.vijayan.profile.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.vijayan.profile.service.ClpSerializer;
import com.vijayan.profile.service.KeyLocalServiceUtil;
import com.vijayan.profile.service.KeyServiceUtil;
import com.vijayan.profile.service.KeyValueLocalServiceUtil;
import com.vijayan.profile.service.KeyValueServiceUtil;
import com.vijayan.profile.service.ProfileLocalServiceUtil;
import com.vijayan.profile.service.ProfileServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			KeyLocalServiceUtil.clearService();

			KeyServiceUtil.clearService();
			KeyValueLocalServiceUtil.clearService();

			KeyValueServiceUtil.clearService();
			ProfileLocalServiceUtil.clearService();

			ProfileServiceUtil.clearService();
		}
	}
}