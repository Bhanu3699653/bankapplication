use bankapplication;
show tables;
drop table transactiondata;
create table transactiondata(acno int, dateoftx varchar(20), credit int, withdrawl int);
insert into transactiondata values(1235,"29/7/2020",500,0);
select * from transactiondata;
select acno, sum(credit)-sum(withdrawl) as balance from transactiondata group by acno ;
insert into transactiondata values(1234,"31/7/2020",5000,1000);
