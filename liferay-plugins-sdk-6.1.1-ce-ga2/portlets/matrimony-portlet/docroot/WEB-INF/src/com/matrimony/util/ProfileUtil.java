package com.matrimony.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.matrimony.model.Key;
import com.matrimony.model.KeyValue;
import com.matrimony.service.KeyLocalServiceUtil;
import com.matrimony.service.KeyValueLocalServiceUtil;

public class ProfileUtil {
	public static List<KeyValue> getKeyValueList(String keyName)
	{
		List<KeyValue> keyValueList = new ArrayList<KeyValue>();
		Key  key = null;
		try {
			key = KeyLocalServiceUtil.keySearch(keyName);
			keyValueList = KeyValueLocalServiceUtil.valueSearch(key.getKeyId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return keyValueList;
	}
}
