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

package com.matrimony.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.matrimony.model.CasteClp;
import com.matrimony.model.CityClp;
import com.matrimony.model.InteractionClp;
import com.matrimony.model.KeyClp;
import com.matrimony.model.KeyValueClp;
import com.matrimony.model.PhotoClp;
import com.matrimony.model.ProfileClp;
import com.matrimony.model.ProfileKeyValueClp;
import com.matrimony.model.ProfileTempClp;
import com.matrimony.model.ReligionClp;
import com.matrimony.model.SubCasteClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"matrimony-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"matrimony-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "matrimony-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CasteClp.class.getName())) {
			return translateInputCaste(oldModel);
		}

		if (oldModelClassName.equals(CityClp.class.getName())) {
			return translateInputCity(oldModel);
		}

		if (oldModelClassName.equals(InteractionClp.class.getName())) {
			return translateInputInteraction(oldModel);
		}

		if (oldModelClassName.equals(KeyClp.class.getName())) {
			return translateInputKey(oldModel);
		}

		if (oldModelClassName.equals(KeyValueClp.class.getName())) {
			return translateInputKeyValue(oldModel);
		}

		if (oldModelClassName.equals(PhotoClp.class.getName())) {
			return translateInputPhoto(oldModel);
		}

		if (oldModelClassName.equals(ProfileClp.class.getName())) {
			return translateInputProfile(oldModel);
		}

		if (oldModelClassName.equals(ProfileKeyValueClp.class.getName())) {
			return translateInputProfileKeyValue(oldModel);
		}

		if (oldModelClassName.equals(ProfileTempClp.class.getName())) {
			return translateInputProfileTemp(oldModel);
		}

		if (oldModelClassName.equals(ReligionClp.class.getName())) {
			return translateInputReligion(oldModel);
		}

		if (oldModelClassName.equals(SubCasteClp.class.getName())) {
			return translateInputSubCaste(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCaste(BaseModel<?> oldModel) {
		CasteClp oldClpModel = (CasteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCasteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCity(BaseModel<?> oldModel) {
		CityClp oldClpModel = (CityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInteraction(BaseModel<?> oldModel) {
		InteractionClp oldClpModel = (InteractionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInteractionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputKey(BaseModel<?> oldModel) {
		KeyClp oldClpModel = (KeyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getKeyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputKeyValue(BaseModel<?> oldModel) {
		KeyValueClp oldClpModel = (KeyValueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getKeyValueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPhoto(BaseModel<?> oldModel) {
		PhotoClp oldClpModel = (PhotoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPhotoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProfile(BaseModel<?> oldModel) {
		ProfileClp oldClpModel = (ProfileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProfileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProfileKeyValue(BaseModel<?> oldModel) {
		ProfileKeyValueClp oldClpModel = (ProfileKeyValueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProfileKeyValueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProfileTemp(BaseModel<?> oldModel) {
		ProfileTempClp oldClpModel = (ProfileTempClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProfileTempRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputReligion(BaseModel<?> oldModel) {
		ReligionClp oldClpModel = (ReligionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getReligionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSubCaste(BaseModel<?> oldModel) {
		SubCasteClp oldClpModel = (SubCasteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSubCasteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.matrimony.model.impl.CasteImpl")) {
			return translateOutputCaste(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.CityImpl")) {
			return translateOutputCity(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.InteractionImpl")) {
			return translateOutputInteraction(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.KeyImpl")) {
			return translateOutputKey(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.KeyValueImpl")) {
			return translateOutputKeyValue(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.PhotoImpl")) {
			return translateOutputPhoto(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.ProfileImpl")) {
			return translateOutputProfile(oldModel);
		}

		if (oldModelClassName.equals(
					"com.matrimony.model.impl.ProfileKeyValueImpl")) {
			return translateOutputProfileKeyValue(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.ProfileTempImpl")) {
			return translateOutputProfileTemp(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.ReligionImpl")) {
			return translateOutputReligion(oldModel);
		}

		if (oldModelClassName.equals("com.matrimony.model.impl.SubCasteImpl")) {
			return translateOutputSubCaste(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.matrimony.ImageSizeExceedsLimitException")) {
			return new com.matrimony.ImageSizeExceedsLimitException();
		}

		if (className.equals("com.matrimony.InvalidImageException")) {
			return new com.matrimony.InvalidImageException();
		}

		if (className.equals("com.matrimony.InvalidImageTypeException")) {
			return new com.matrimony.InvalidImageTypeException();
		}

		if (className.equals("com.matrimony.NoSuchCasteException")) {
			return new com.matrimony.NoSuchCasteException();
		}

		if (className.equals("com.matrimony.NoSuchCityException")) {
			return new com.matrimony.NoSuchCityException();
		}

		if (className.equals("com.matrimony.NoSuchInteractionException")) {
			return new com.matrimony.NoSuchInteractionException();
		}

		if (className.equals("com.matrimony.NoSuchKeyException")) {
			return new com.matrimony.NoSuchKeyException();
		}

		if (className.equals("com.matrimony.NoSuchKeyValueException")) {
			return new com.matrimony.NoSuchKeyValueException();
		}

		if (className.equals("com.matrimony.NoSuchPhotoException")) {
			return new com.matrimony.NoSuchPhotoException();
		}

		if (className.equals("com.matrimony.NoSuchProfileException")) {
			return new com.matrimony.NoSuchProfileException();
		}

		if (className.equals("com.matrimony.NoSuchProfileKeyValueException")) {
			return new com.matrimony.NoSuchProfileKeyValueException();
		}

		if (className.equals("com.matrimony.NoSuchProfileTempException")) {
			return new com.matrimony.NoSuchProfileTempException();
		}

		if (className.equals("com.matrimony.NoSuchReligionException")) {
			return new com.matrimony.NoSuchReligionException();
		}

		if (className.equals("com.matrimony.NoSuchSubCasteException")) {
			return new com.matrimony.NoSuchSubCasteException();
		}

		return throwable;
	}

	public static Object translateOutputCaste(BaseModel<?> oldModel) {
		CasteClp newModel = new CasteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCasteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCity(BaseModel<?> oldModel) {
		CityClp newModel = new CityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInteraction(BaseModel<?> oldModel) {
		InteractionClp newModel = new InteractionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInteractionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputKey(BaseModel<?> oldModel) {
		KeyClp newModel = new KeyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setKeyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputKeyValue(BaseModel<?> oldModel) {
		KeyValueClp newModel = new KeyValueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setKeyValueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPhoto(BaseModel<?> oldModel) {
		PhotoClp newModel = new PhotoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPhotoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProfile(BaseModel<?> oldModel) {
		ProfileClp newModel = new ProfileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProfileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProfileKeyValue(BaseModel<?> oldModel) {
		ProfileKeyValueClp newModel = new ProfileKeyValueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProfileKeyValueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProfileTemp(BaseModel<?> oldModel) {
		ProfileTempClp newModel = new ProfileTempClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProfileTempRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputReligion(BaseModel<?> oldModel) {
		ReligionClp newModel = new ReligionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setReligionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSubCaste(BaseModel<?> oldModel) {
		SubCasteClp newModel = new SubCasteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSubCasteRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}