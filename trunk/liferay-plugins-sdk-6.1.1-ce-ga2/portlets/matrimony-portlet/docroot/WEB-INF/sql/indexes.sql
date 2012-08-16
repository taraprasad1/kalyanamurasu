create index IX_48F621A9 on matrimony_key (name);

create index IX_21AE162E on matrimony_key_value (keyId);
create index IX_E424368F on matrimony_key_value (name, keyId);

create index IX_BC430FF7 on matrimony_photo (profileId);

create index IX_C4ADE11B on matrimony_profile (createdBy);
create index IX_996B8A9A on matrimony_profile (status);