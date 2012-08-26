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
import java.util.List;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.matrimony.constant.ProfileConstants;
import com.matrimony.model.Profile;
import com.matrimony.model.impl.ProfileImpl;
import com.matrimony.service.base.ProfileLocalServiceBaseImpl;
import com.matrimony.util.MatrimonyPropsValues;
import com.matrimony.util.ProfileIndexer;

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

	public Profile createProfileObj(){
		return new ProfileImpl();
	}
	
	public Profile addProfileObj(Profile profile) throws SystemException, SearchException{
		profile = profileLocalService.addProfile(profile);
		ProfileIndexer profileIndexer = new ProfileIndexer();
		profileIndexer.addProfile(profile);
		return profile;
	}
	
	public Profile updateProfileObj(Profile profile) throws SystemException, SearchException{
		profileLocalService.updateProfile(profile);
		ProfileIndexer profileIndexer = new ProfileIndexer();
		profileIndexer.updateProfile(profile);
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
			profileList = convertHitsToProfile(hits);
		} catch (SearchException e) {
			
		} catch (ParseException e) {
			
		}
		return profileList;
	}
	
	public List<Profile> convertHitsToProfile(Hits hits) {
		List<Profile> profileList = new ArrayList<Profile>();
		if (hits != null && hits.getLength() > 0) {
			for (Document document : hits.getDocs()) {
				Profile profile = new ProfileImpl();
				if(Validator.isNotNull(document.get(Field.COMPANY_ID))) {
					profile.setCompanyId(Long.parseLong(document.get(Field.COMPANY_ID)));
				}
				if(Validator.isNotNull(document.get(Field.GROUP_ID))) {
					profile.setGroupId(Long.parseLong(document.get(Field.GROUP_ID)));
				}
				if(Validator.isNotNull(document.get(Field.TITLE))) {
					profile.setProfileCode(document.get(Field.TITLE));
				}
				if(Validator.isNotNull(document.get(Field.CLASS_PK))) {
					profile.setProfileId(Long.parseLong(document.get(Field.CLASS_PK)));
				}
				profile.setCountry(document.get(ProfileConstants.PROFILE_COUNTRY));
				profile.setState(ProfileConstants.PROFILE_STATE);
				profile.setCity(ProfileConstants.PROFILE_CITY);
				profile.setReligion(ProfileConstants.PROFILE_RELIGION);
				profileList.add(profile);
			}
		}
		return profileList;
	}
}