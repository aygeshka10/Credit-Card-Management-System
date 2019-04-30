use finalcase;
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;
insert into table cdw_sapp_f_credit_card partition (branch_code)
select
	cust_cc_no,
	timeid,
	cust_ssn,
	transaction_type,
	transaction_value,
	transaction_id,
	branch_code
from creditcard_external;