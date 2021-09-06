create table recorder (id bigint not null auto_increment, name varchar(255), date_of_birth date, primary key (id));

create table world_record (id bigint not null auto_increment, description varchar(255), value numeric, unit_of_measure varchar(255), date_of_record date, recorder_id bigint, primary key (id));