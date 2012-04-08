-- create table
create table person
(
  pid      number not null,
  pname    nvarchar2(20),
  age      number,
  birthday date
)

alter table person add constraint person_pk primary key (pid);
  
-- create sequence 
create sequence seq_person
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;