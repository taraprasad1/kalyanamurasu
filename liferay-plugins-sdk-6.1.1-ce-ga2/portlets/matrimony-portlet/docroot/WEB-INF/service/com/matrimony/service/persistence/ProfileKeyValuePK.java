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

package com.matrimony.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author matrimony
 */
public class ProfileKeyValuePK implements Comparable<ProfileKeyValuePK>,
	Serializable {
	public long profileId;
	public long keyId;
	public long valueId;

	public ProfileKeyValuePK() {
	}

	public ProfileKeyValuePK(long profileId, long keyId, long valueId) {
		this.profileId = profileId;
		this.keyId = keyId;
		this.valueId = valueId;
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public long getKeyId() {
		return keyId;
	}

	public void setKeyId(long keyId) {
		this.keyId = keyId;
	}

	public long getValueId() {
		return valueId;
	}

	public void setValueId(long valueId) {
		this.valueId = valueId;
	}

	public int compareTo(ProfileKeyValuePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (profileId < pk.profileId) {
			value = -1;
		}
		else if (profileId > pk.profileId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (keyId < pk.keyId) {
			value = -1;
		}
		else if (keyId > pk.keyId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (valueId < pk.valueId) {
			value = -1;
		}
		else if (valueId > pk.valueId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProfileKeyValuePK pk = null;

		try {
			pk = (ProfileKeyValuePK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((profileId == pk.profileId) && (keyId == pk.keyId) &&
				(valueId == pk.valueId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(profileId) + String.valueOf(keyId) +
		String.valueOf(valueId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("profileId");
		sb.append(StringPool.EQUAL);
		sb.append(profileId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("keyId");
		sb.append(StringPool.EQUAL);
		sb.append(keyId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("valueId");
		sb.append(StringPool.EQUAL);
		sb.append(valueId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}