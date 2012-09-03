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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.matrimony.constant.ProfileConstants;
import com.matrimony.model.Caste;
import com.matrimony.model.Profile;
import com.matrimony.model.Religion;
import com.matrimony.model.impl.ProfileImpl;
import com.matrimony.service.base.ProfileLocalServiceBaseImpl;
import com.matrimony.util.MatrimonyPropsValues;
import com.matrimony.util.ProfileIndexer;
import com.matrimony.util.ProfileUtil;

/**
 * The implementation of the profile local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.matrimony.service.ProfileLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Matrimony
 * @see com.matrimony.service.base.ProfileLocalServiceBaseImpl
 * @see com.matrimony.service.ProfileLocalServiceUtil
 */
public class ProfileLocalServiceImpl extends ProfileLocalServiceBaseImpl {

	private static final String FEMALE = "F";
	private static final String MALE = "M";
	private static final String MA = "MA";

	public Profile createProfileObj(){
		return new ProfileImpl();
	}
	
	public Profile getProfileObj(long profileId) throws PortalException, SystemException{
		Profile profile = profileLocalService.getProfile(profileId);
		profile.setHobbies(profileKeyValueLocalService.getValues(profileId, ProfileConstants.PROFILE_HOBBIES));
		profile.setLanguageKnown(profileKeyValueLocalService.getValues(profileId, ProfileConstants.PROFILE_LANGUAGE));
		return profile;
	}
	
	public Profile addProfileObj(Profile profile) throws SystemException, SearchException{
		profile.setProfileCode(createProfileCode(profile));
		profile = profileLocalService.addProfile(profile);
		ProfileIndexer profileIndexer = new ProfileIndexer();
		profileIndexer.addProfile(profile);
		Map<String, String> keyValues = ProfileUtil.getProfileKeyValues(profile);
		profileKeyValueLocalService.addValues(profile.getProfileId(), keyValues);
		return profile;
	}
	
	public Profile updateProfileObj(Profile profile) throws SystemException, SearchException{
		profileLocalService.updateProfile(profile);
		ProfileIndexer profileIndexer = new ProfileIndexer();
		profileIndexer.updateProfile(profile);
		Map<String, String> keyValues = ProfileUtil.getProfileKeyValues(profile);
		profileKeyValueLocalService.updateValues(profile.getProfileId(), keyValues);
		return profile;
	}
	
	public Boolean deleteProfileObj(Profile profile) throws SystemException, PortalException{
		profileLocalService.deleteProfile(profile.getProfileId());
		ProfileIndexer profileIndexer = new ProfileIndexer();
		profileIndexer.delete(profile);
		return true;
	}
	
	public List<Profile> getProfileListByIndexer(long companyId, long groupId){
		List<Profile> profileList = new ArrayList<Profile>();
		try {
			SearchContext searchContext = new SearchContext();
			searchContext.setCompanyId(companyId);

			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);

			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);
			contextQuery.addRequiredTerm(Field.PORTLET_ID, MatrimonyPropsValues.PROFILE_PORTLET_ID);
			
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			Sort sort = new Sort(Field.MODIFIED_DATE, true);
			searchContext.setSorts(new Sort[] { sort });
			Hits hits = SearchEngineUtil.search(searchContext, fullQuery);
			profileList = ProfileUtil.convertHitsToProfile(hits);
		} catch (SearchException e) {
			
		} catch (ParseException e) {
			
		}
		return profileList;
	}
	
	public String createProfileCode(Profile profile) {
		String idCode = MA;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		boolean male = profile.getGender();
		StringBuilder profileCode = new StringBuilder();	
		if(male){
			profileCode.append(MALE);
		} else {
			profileCode.append(FEMALE);
		}
		long autoId = 0l;
		try {
			autoId = CounterLocalServiceUtil.increment(Profile.class.getName());
		} catch (SystemException e) {
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