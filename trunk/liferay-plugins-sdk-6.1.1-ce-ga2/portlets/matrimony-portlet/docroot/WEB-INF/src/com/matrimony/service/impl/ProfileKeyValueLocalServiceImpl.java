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

package com.matrimony.service.impl;

import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.matrimony.model.Key;
import com.matrimony.model.KeyValue;
import com.matrimony.model.ProfileKeyValue;
import com.matrimony.model.impl.ProfileKeyValueImpl;
import com.matrimony.service.KeyValueLocalServiceUtil;
import com.matrimony.service.base.ProfileKeyValueLocalServiceBaseImpl;

/**
 * The implementation of the profile key value local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.matrimony.service.ProfileKeyValueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matrimony
 * @see com.matrimony.service.base.ProfileKeyValueLocalServiceBaseImpl
 * @see com.matrimony.service.ProfileKeyValueLocalServiceUtil
 */
public class ProfileKeyValueLocalServiceImpl
	extends ProfileKeyValueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.matrimony.service.ProfileKeyValueLocalServiceUtil} to access the profile key value local service.
	 */
	public void addValues(long profileId, Map<String, String> keyValues) throws SystemException {
		if(Validator.isNotNull(profileId) && Validator.isNotNull(keyValues)){
			for (Map.Entry<String, String> entry : keyValues.entrySet()) {
				System.out.println("Name:" + entry.getKey() + "Values: " + entry.getValue());
				if(Validator.isNotNull(keyLocalService.keySearch(entry.getKey()))) {
					Key key = keyLocalService.keySearch(entry.getKey());
					long keyId = key.getKeyId();
					String[] values = entry.getValue().split(StringPool.COMMA_AND_SPACE);
					for(String value: values) {
						if(Validator.isNotNull(keyValueLocalService.valueNameSearch(value, keyId))) {
							KeyValue keyValue = keyValueLocalService.valueNameSearch(value, keyId);
							ProfileKeyValue profileKeyValue = new ProfileKeyValueImpl();
							profileKeyValue.setProfileId(profileId);
							profileKeyValue.setKeyId(keyId);
							profileKeyValue.setValueId(keyValue.getValueId());
							profileKeyValueLocalService.addProfileKeyValue(profileKeyValue);
						}
					}
				}
			}
		}
	}
	public void updateValues(long profileId, Map<String, String> keyValues) throws SystemException {
		if(Validator.isNotNull(profileId) && Validator.isNotNull(keyValues)){
			for (Map.Entry<String, String> entry : keyValues.entrySet()) {
				if(Validator.isNotNull(keyLocalService.keySearch(entry.getKey()))) {
					Key key = keyLocalService.keySearch(entry.getKey());
					long keyId = key.getKeyId();
					if(Validator.isNotNull(profileKeyValuePersistence.findByProfileAndKeyId(keyId, profileId))){
						List<ProfileKeyValue> profileKeyValList = profileKeyValuePersistence.findByProfileAndKeyId(keyId, profileId);
						for(ProfileKeyValue keyValue: profileKeyValList){
							profileKeyValueLocalService.deleteProfileKeyValue(keyValue);
						}
					}
				}
			}
			addValues(profileId, keyValues);
		}
	}
	
	public String getValues(long profileId, String keyName) throws SystemException, PortalException{
		StringBuilder values = new StringBuilder();
		if(Validator.isNotNull(profileId) && Validator.isNotNull(keyName)){
			if(Validator.isNotNull(keyLocalService.keySearch(keyName))) {
				Key key = keyLocalService.keySearch(keyName);
				long keyId = key.getKeyId();
				if(Validator.isNotNull(profileKeyValuePersistence.findByProfileAndKeyId(keyId, profileId))){
					List<ProfileKeyValue> profileKeyValList = profileKeyValuePersistence.findByProfileAndKeyId(keyId, profileId);
					for(ProfileKeyValue profileKeyValue: profileKeyValList){
						KeyValue keyValue = KeyValueLocalServiceUtil.getKeyValue(profileKeyValue.getValueId());
						if(Validator.isNotNull(values)) {
							values.append(StringPool.COMMA_AND_SPACE);
							values.append(keyValue.getName());
						} else {
							values.append(keyValue.getName());
						}
					}
				}
			}
		}
		return values.toString();
	}
}