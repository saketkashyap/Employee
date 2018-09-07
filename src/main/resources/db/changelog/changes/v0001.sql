create table "employee" (
  id SERIAL,
  firstname varchar(100) not null,
  lastname varchar(100) not null,
  emailid varchar(100) not null,
  companycode Integer not NULL,
  primary key (id)
);