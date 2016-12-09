
create database mts;

drop table mts.ACCOUNTS;
create table mts.ACCOUNTS(num int primary key,name varchar(50),balance double);


insert into mts.ACCOUNTS values("1","Nag",1000);
insert into mts.ACCOUNTS values("2","Ria",1000);