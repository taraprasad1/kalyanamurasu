package com.matrimony.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.matrimony.ImageSizeExceedsLimitException;
import com.matrimony.InvalidImageException;
import com.matrimony.InvalidImageTypeException;
import com.matrimony.constant.ProfileConstants;

public class CommonUtil {
	public static boolean inAcceptedImageTypes(String type) {
		String imageTypeString = MatrimonyPropsValues.IMAGE_TYPES;
		String[] imageType = imageTypeString.split(StringPool.COMMA);
		for (int i = 0; i < imageType.length; i++) {
			if (type.equalsIgnoreCase(imageType[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean validatePhoto(UploadPortletRequest uploadRequest)
			throws SystemException, PortalException {
		int size = 0;
		String type = StringPool.BLANK;

		if (uploadRequest.getFileName(ProfileConstants.IMAGE_PROFILE_PHOTO) == StringPool.BLANK) {
			throw new InvalidImageException();
		}

		try {
			File file = uploadRequest
					.getFile(ProfileConstants.IMAGE_PROFILE_PHOTO);
			byte[] bytes = FileUtil.getBytes(file);
			ImageBag imageBag = ImageToolUtil.read(bytes);
			type = imageBag.getType();
			size = bytes.length;
		} catch (IOException e) {
		}
		if (!CommonUtil.inAcceptedImageTypes(type)) {
			throw new InvalidImageTypeException();
		}
		if (size > MatrimonyPropsValues.IMAGE_SIZE) {
			throw new ImageSizeExceedsLimitException();
		}
		return true;
	}
	
	public static List<String> getValueList(String value) {
		List<String> valueList = new ArrayList<String>();
		if(Validator.isNotNull(value)) {
			String[] values = value.split(StringPool.COMMA_AND_SPACE);
			for(String data: values) {
				valueList.add(data);
			}
		}
		return valueList;
	}
}