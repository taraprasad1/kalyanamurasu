package com.matrimony.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.Validator;
import com.matrimony.constant.ProfileConstants;
import com.matrimony.model.Profile;
import com.matrimony.model.impl.ProfileImpl;

public class ProfileUtil {

	private static final Log LOGGER = LogFactoryUtil.getLog(ProfileUtil.class);

	public static List<Profile> convertHitsToProfile(Hits hits) {
		List<Profile> profileList = new ArrayList<Profile>();
		if (hits != null && hits.getLength() > 0) {
			for (Document document : hits.getDocs()) {
				Profile profile = new ProfileImpl();
				if (Validator.isNotNull(document.get(Field.COMPANY_ID))) {
					profile.setCompanyId(Long.parseLong(document
							.get(Field.COMPANY_ID)));
				}
				if (Validator.isNotNull(document.get(Field.GROUP_ID))) {
					profile.setGroupId(Long.parseLong(document
							.get(Field.GROUP_ID)));
				}
				if (Validator.isNotNull(document.get(Field.TITLE))) {
					profile.setProfileCode(document.get(Field.TITLE));
				}
				if (Validator.isNotNull(document.get(Field.ENTRY_CLASS_PK))) {
					profile.setProfileId(Long.parseLong(document
							.get(Field.ENTRY_CLASS_PK)));
				}
				profile.setCountry(document
						.get(ProfileConstants.PROFILE_COUNTRY));
				profile.setState(document
						.get(ProfileConstants.PROFILE_STATE));
				profile.setCity(document
						.get(ProfileConstants.PROFILE_CITY));
				profile.setReligion(document
						.get(ProfileConstants.PROFILE_RELIGION));
				profile.setName(document
						.get(ProfileConstants.PROFILE_NAME));
				profile.setEmailAddress(document
						.get(ProfileConstants.PROFILE_EMAIL_ADDRESS));
				profileList.add(profile);
			}
		}
		return profileList;
	}
	
	public static Map<String, String> getProfileKeyValues(Profile profile){
		Map<String, String> keyValues = new HashMap<String, String>();
		keyValues.put(ProfileConstants.PROFILE_HOBBIES, profile.getHobbies());
		keyValues.put(ProfileConstants.PROFILE_LANGUAGE, profile.getLanguageKnown());
		return keyValues;
	}
}