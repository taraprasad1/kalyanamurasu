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

package com.matrimony.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Profile service. Represents a row in the &quot;matrimony_profile&quot; database table, with each column mapped to a property of this class.
 *
 * @author matrimony
 * @see ProfileModel
 * @see com.matrimony.model.impl.ProfileImpl
 * @see com.matrimony.model.impl.ProfileModelImpl
 * @generated
 */
public interface Profile extends ProfileModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.matrimony.model.impl.ProfileImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getHobbies();

	public void setHobbies(java.lang.String hobbies);

	public java.lang.String getLanguageKnown();

	public void setLanguageKnown(java.lang.String languageKnown);
}