drop table if exists items;
create table items (id bigint not null auto_increment, name varchar(50) not null unique, description varchar(150), primary key (id)) type=InnoDB;
