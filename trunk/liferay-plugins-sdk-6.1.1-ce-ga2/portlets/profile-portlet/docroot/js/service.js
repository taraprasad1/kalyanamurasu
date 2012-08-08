Liferay.Service.register("Liferay.Service.profile", "com.vijayan.profile.service", "profile-portlet");

Liferay.Service.registerClass(
	Liferay.Service.profile, "KeyValue",
	{
		valueSearch: true
	}
);