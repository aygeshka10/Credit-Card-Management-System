use finalcase;
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;
insert into table cdw_sapp_d_time partition (month)
select
	timeid,
	day,
	`quarter`,
	year,
	month
from tdtime_external;