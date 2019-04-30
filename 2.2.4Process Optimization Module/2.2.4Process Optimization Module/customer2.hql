use finalcase;
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;
insert into table cdw_sapp_d_customer partition (cust_state)
select
	cust_ssn,
	cust_f_name,
	cust_m_name,
	cust_l_name,
	cust_cc_no,
	cust_street,
	cust_city,
	cust_country,
	cust_zip,
	cust_phone,
	cust_email,
	last_updated,
	cust_state
from customer_external;
