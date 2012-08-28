create index IX_EE1BA394 on city (regionId);
create index IX_434FE29E on city (regionId, cityName);
create index IX_B932C57 on city (status);

create index IX_BEE0B131 on matrimony_caste (religionId);
create index IX_CA839830 on matrimony_caste (religionId, name);

create index IX_48F621A9 on matrimony_key (name);

create index IX_21AE162E on matrimony_key_value (keyId);
create index IX_E424368F on matrimony_key_value (name, keyId);

create index IX_BC430FF7 on matrimony_photo (profileId);

create index IX_C4ADE11B on matrimony_profile (createdBy);
create index IX_996B8A9A on matrimony_profile (status);

create index IX_96544E5E on matrimony_profile_key (keyId, profileId);
create index IX_AD30F426 on matrimony_profile_key (keyId, valueId);

create index IX_1BB2CB11 on matrimony_religion (name);

create index IX_850126A on matrimony_subcaste (casteId);
create index IX_8696AA9 on matrimony_subcaste (casteId, name);