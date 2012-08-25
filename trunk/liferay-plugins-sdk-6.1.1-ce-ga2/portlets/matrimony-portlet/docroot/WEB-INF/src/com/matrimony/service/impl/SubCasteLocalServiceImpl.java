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

import com.liferay.portal.kernel.exception.SystemException;
import com.matrimony.model.SubCaste;
import com.matrimony.service.base.SubCasteLocalServiceBaseImpl;

/**
 * The implementation of the sub caste local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.matrimony.service.SubCasteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author matrimony
 * @see com.matrimony.service.base.SubCasteLocalServiceBaseImpl
 * @see com.matrimony.service.SubCasteLocalServiceUtil
 */
public class SubCasteLocalServiceImpl extends SubCasteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.matrimony.service.SubCasteLocalServiceUtil} to access the sub caste local service.
	 */
	
	public List<SubCaste> getSubCasteListByCasteId(long casteId) throws SystemException{
		return subCastePersistence.findByCasteId(casteId);
	}
}