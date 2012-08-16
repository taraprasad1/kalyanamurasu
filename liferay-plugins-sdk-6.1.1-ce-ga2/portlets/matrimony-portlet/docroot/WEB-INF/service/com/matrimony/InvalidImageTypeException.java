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

package com.matrimony;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author matrimony
 */
public class InvalidImageTypeException extends PortalException {

	public InvalidImageTypeException() {
		super();
	}

	public InvalidImageTypeException(String msg) {
		super(msg);
	}

	public InvalidImageTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidImageTypeException(Throwable cause) {
		super(cause);
	}

}