package com.matrimony.util;

import java.io.File;
import java.io.IOException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.matrimony.ImageSizeExceedsLimitException;
import com.matrimony.InvalidImageException;
import com.matrimony.InvalidImageTypeException;


public class CommonUtil {
	public static boolean inAcceptedImageTypes(String type) {
		 String imageTypeString = MatrimonyPropsValues.IMAGE_TYPES;
		 String[] imageType = imageTypeString.split(StringPool.COMMA);
		 for (int i=0; i<imageType.length; i++) {
			 if (type.equalsIgnoreCase(imageType[i])) {
				return true;
			 }
		 }
		 return false;
	 }
	public static boolean validatePhoto(UploadPortletRequest uploadRequest) throws SystemException, PortalException {
		int size = 0;
		String type = StringPool.BLANK;
		
		if (uploadRequest.getFileName("profilePhoto") == StringPool.BLANK){
			throw new InvalidImageException();
		}
		
		try {
			File file = uploadRequest.getFile("profilePhoto");
			byte[] bytes = FileUtil.getBytes(file);
			ImageBag imageBag = ImageToolUtil.read(bytes);
			type = imageBag.getType();
			size = bytes.length;
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		if (!CommonUtil.inAcceptedImageTypes(type)) {
			throw new InvalidImageTypeException();
		}
		if (size > MatrimonyPropsValues.IMAGE_SIZE) {
			throw new ImageSizeExceedsLimitException();
		}
		return true;
	}
}
