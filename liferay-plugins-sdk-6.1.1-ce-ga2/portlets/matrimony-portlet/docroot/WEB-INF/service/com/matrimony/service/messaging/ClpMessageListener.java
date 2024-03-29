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

package com.matrimony.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.matrimony.service.CasteLocalServiceUtil;
import com.matrimony.service.CityLocalServiceUtil;
import com.matrimony.service.ClpSerializer;
import com.matrimony.service.InteractionLocalServiceUtil;
import com.matrimony.service.InteractionServiceUtil;
import com.matrimony.service.KeyLocalServiceUtil;
import com.matrimony.service.KeyServiceUtil;
import com.matrimony.service.KeyValueLocalServiceUtil;
import com.matrimony.service.KeyValueServiceUtil;
import com.matrimony.service.PhotoLocalServiceUtil;
import com.matrimony.service.PhotoServiceUtil;
import com.matrimony.service.ProfileKeyValueLocalServiceUtil;
import com.matrimony.service.ProfileLocalServiceUtil;
import com.matrimony.service.ProfileServiceUtil;
import com.matrimony.service.ProfileTempLocalServiceUtil;
import com.matrimony.service.ProfileTempServiceUtil;
import com.matrimony.service.ReligionLocalServiceUtil;
import com.matrimony.service.SubCasteLocalServiceUtil;

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
			CasteLocalServiceUtil.clearService();

			CityLocalServiceUtil.clearService();

			InteractionLocalServiceUtil.clearService();

			InteractionServiceUtil.clearService();
			KeyLocalServiceUtil.clearService();

			KeyServiceUtil.clearService();
			KeyValueLocalServiceUtil.clearService();

			KeyValueServiceUtil.clearService();
			PhotoLocalServiceUtil.clearService();

			PhotoServiceUtil.clearService();
			ProfileLocalServiceUtil.clearService();

			ProfileServiceUtil.clearService();
			ProfileKeyValueLocalServiceUtil.clearService();

			ProfileTempLocalServiceUtil.clearService();

			ProfileTempServiceUtil.clearService();
			ReligionLocalServiceUtil.clearService();

			SubCasteLocalServiceUtil.clearService();
		}
	}
}