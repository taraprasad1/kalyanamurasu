create table kalyan_key (
	keyId LONG not null primary key IDENTITY,
	name VARCHAR(75) null
);

create table kalyan_key_value (
	valueId LONG not null primary key IDENTITY,
	keyId LONG,
	name VARCHAR(75) null
);