package com.matrimony.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.matrimony.model.Key;
import com.matrimony.model.KeyValue;
import com.matrimony.model.Profile;
import com.matrimony.service.KeyLocalServiceUtil;
import com.matrimony.service.KeyValueLocalServiceUtil;

public class ProfileUtil {
	public static List<String> getKeyValueList(String keyName)
	{
		List<String> valueList = new ArrayList<String>();
		if(Validator.isNotNull(keyName)) {
			Key key = null;
			try {
				if (Validator.isNotNull(KeyLocalServiceUtil.keySearch(keyName))) {
					key = KeyLocalServiceUtil.keySearch(keyName);
					List<KeyValue> keyValueList = new ArrayList<KeyValue>();
					if (Validator.isNotNull(key)){
						keyValueList = KeyValueLocalServiceUtil.valueSearch(key.getKeyId());
					}
					for (KeyValue value: keyValueList) {
						if(Validator.isNotNull(value.getName())) {
							valueList.add(value.getName());
						}
					}
				}
			} catch (SystemException e) {
				System.out.println("Key Not Found====>>" + keyName);
			}
		}
		return valueList;
	}
	
	public static String getProfileCode(Profile profile) {
		String idCode = "MA";
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		boolean male = profile.getGender();
		StringBuilder profileCode = new StringBuilder();	
		if(male){
			profileCode.append("M");
		} else {
			profileCode.append("F");
		}
		long autoId = 0l;
		try {
			autoId = CounterLocalServiceUtil.increment(Profile.class.getName());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		profileCode.append(autoId);
		profileCode.append(idCode);
		String profileName = profile.getName();
		if (Validator.isNotNull(profileName) && profileName.length() >= 2) {
			profileName = profileName.substring(0, 2).toUpperCase();
		}
		profileCode.append(year);
		profileCode.append(month);
		profileCode.append(date);
		profileCode.append(profileName);
		return profileCode.toString();
	}
}
