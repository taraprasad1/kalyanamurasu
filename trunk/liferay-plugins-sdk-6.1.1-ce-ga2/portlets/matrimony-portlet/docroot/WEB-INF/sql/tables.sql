create table matrimony_key (
	keyId LONG not null primary key IDENTITY,
	name VARCHAR(75) null
);

create table matrimony_key_value (
	valueId LONG not null primary key IDENTITY,
	keyId LONG,
	name VARCHAR(75) null
);

create table matrimony_photo (
	photoId LONG not null primary key IDENTITY,
	profileId LONG,
	content VARCHAR(75) null,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null,
	thumbnail BOOLEAN
);

create table matrimony_profile (
	profileId LONG not null primary key IDENTITY,
	profileCode VARCHAR(75) null,
	createdForMy VARCHAR(75) null,
	name VARCHAR(75) null,
	gender BOOLEAN,
	birthDateWithTime DATE null,
	rasi VARCHAR(75) null,
	star VARCHAR(75) null,
	dosam VARCHAR(75) null,
	religion VARCHAR(75) null,
	caste VARCHAR(75) null,
	subCaste VARCHAR(75) null,
	height VARCHAR(75) null,
	weight VARCHAR(75) null,
	complexion VARCHAR(75) null,
	motherTongue VARCHAR(75) null,
	languageKnown VARCHAR(75) null,
	maritalStatus VARCHAR(75) null,
	children INTEGER,
	country VARCHAR(75) null,
	state_ VARCHAR(75) null,
	city VARCHAR(75) null,
	address VARCHAR(75) null,
	pinCode VARCHAR(75) null,
	phone VARCHAR(75) null,
	mobile VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	education VARCHAR(75) null,
	profession VARCHAR(75) null,
	currency_ VARCHAR(75) null,
	annualIncome VARCHAR(75) null,
	hobbies VARCHAR(75) null,
	aboutMe VARCHAR(75) null,
	familyValue VARCHAR(75) null,
	familyType VARCHAR(75) null,
	familyStatus VARCHAR(75) null,
	securityCode VARCHAR(75) null,
	photoSecurityCode VARCHAR(75) null,
	lastLoggedIn DATE null,
	status INTEGER,
	scheme INTEGER,
	horoscope BOOLEAN,
	createdBy LONG,
	modifiedBy LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	companyId LONG,
	groupId LONG
);

create table matrimony_profile_interaction (
	interactionId LONG not null primary key IDENTITY,
	maleId LONG,
	femaleId LONG,
	maleLastViewedFemale DATE null,
	maleViewedCount INTEGER,
	femaleLastViewedMale DATE null,
	femaleViewedCount INTEGER,
	canViewMalePhoto BOOLEAN,
	canViewFemalePhoto BOOLEAN,
	canViewMaleContact BOOLEAN,
	canViewFemaleContact BOOLEAN,
	proposedOn DATE null,
	proposedByMale BOOLEAN,
	proposalNotSeen BOOLEAN,
	respondedOn DATE null,
	responseType INTEGER,
	responseNotSeen BOOLEAN,
	shortlistedByMale DATE null,
	shortlistedByFemale DATE null,
	blockedByMale DATE null,
	blockedByFemale DATE null,
	capturedInMaleReport INTEGER,
	capturedInFemaleReport INTEGER
);

create table matrimony_profile_temp (
	profileTempId LONG not null primary key IDENTITY,
	profileId LONG,
	name LONG,
	address VARCHAR(75) null,
	pinCode VARCHAR(75) null,
	phone VARCHAR(75) null,
	mobile VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	aboutMe VARCHAR(75) null,
	scheme INTEGER
);