package com.matrimony.util;

import java.util.ArrayList;
import java.util.List;

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
				if (Validator.isNotNull(document.get(Field.CLASS_PK))) {
					profile.setProfileId(Long.parseLong(document
							.get(Field.CLASS_PK)));
				}
				profile.setCountry(document
						.get(ProfileConstants.PROFILE_COUNTRY));
				profile.setState(ProfileConstants.PROFILE_STATE);
				profile.setCity(ProfileConstants.PROFILE_CITY);
				profile.setReligion(ProfileConstants.PROFILE_RELIGION);
				profileList.add(profile);
			}
		}
		return profileList;
	}
}