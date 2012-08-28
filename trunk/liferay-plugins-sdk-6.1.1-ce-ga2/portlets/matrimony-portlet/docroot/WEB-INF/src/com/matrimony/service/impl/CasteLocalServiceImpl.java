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

import com.liferay.portal.kernel.exception.SystemException;
import com.matrimony.NoSuchCasteException;
import com.matrimony.model.Caste;
import com.matrimony.model.CasteSoap;
import com.matrimony.service.base.CasteLocalServiceBaseImpl;

/**
 * The implementation of the caste local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.matrimony.service.CasteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matrimony
 * @see com.matrimony.service.base.CasteLocalServiceBaseImpl
 * @see com.matrimony.service.CasteLocalServiceUtil
 */
public class CasteLocalServiceImpl extends CasteLocalServiceBaseImpl{
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.matrimony.service.CasteLocalServiceUtil} to access the caste local service.
	 */
	public List<Caste> getCasteListByReligionId(long religionId) throws SystemException{
		return castePersistence.findByReligionId(religionId);
	}
	
	public Caste getCasteByReligionIdAndName(long religionId, String name) throws SystemException, NoSuchCasteException{
		return castePersistence.findByReligionIdAndName(religionId, name);
	}
}