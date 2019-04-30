use finalcase;
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;

insert into table cdw_sapp_d_branch partition (branch_state)
select 
	branch_code,
	branch_name,
	branch_street,
	branch_city,
	branch_zip,
	branch_phone,
	last_updated,
	branch_state
from branch_external;