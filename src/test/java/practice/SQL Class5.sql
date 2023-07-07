use orangehrm2022;

CREATE TABLE `employee` (
  `empId` varchar(20) NOT NULL,
  `salary` int(11) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `department` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ;
# DDl data definition language
create table product(
pid varchar(20) not null,
pname varchar(100) not null,
pprice float(20),
primary key (pid)
);

select * from product;
describe product;

insert into product (pid,pname,pprice) values ('1','Apple',1000);

insert into product values ('3','Banana',30);

select * from ohrm_language;

insert into ohrm_language values (4,"English");
insert into ohrm_language values (5,"Italian");
insert into ohrm_language values (6,"French");


describe ohrm_language;

update ohrm_language set name='Arabic';

# security flag to disable bulk update when it is set to 0 it is disbaled
SET SQL_SAFE_UPDATES = 1;


select * from ohrm_language;
# is used to delete rows one by one based on a condition.
delete from ohrm_language where id=6;
#delete the entire data from a table but table itself is retained.
truncate table product;
select * from product;
# delete the table plus the data
drop table product;

alter table product add review varchar(100);
alter table product drop column review;

select * from employee;
