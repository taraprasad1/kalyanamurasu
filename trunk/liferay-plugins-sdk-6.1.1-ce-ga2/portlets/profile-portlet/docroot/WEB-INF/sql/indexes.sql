create index IX_FA1EB975 on kalyan_key (name);

create index IX_EC6D60E2 on kalyan_key_value (keyId);
create index IX_C8187E7 on kalyan_key_value (name);
create index IX_22A5AA43 on kalyan_key_value (name, keyId);

create index IX_DCC54ECF on kalyan_profile (createdBy);
create index IX_C0FE1966 on kalyan_profile (status);