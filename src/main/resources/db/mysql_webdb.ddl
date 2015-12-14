drop database if exists webdb;
create database webdb;
use webdb;
drop table if exists `users`;
create table users (
  id int not null auto_increment,
  username varchar(30) not null,
  password varchar(20) not null,
  location_id int,
  primary key(`id`) using BTREE
) engine=InnoDB default CHARSET=utf8;

drop table if exists `location`;
create table location (
  id int not null auto_increment,
  latitude float not null,
  longitude float not null,
  city varchar(100),
  primary key(`id`) using BTREE
) engine=InnoDB default CHARSET=utf8;

drop table if exists `comments`;
create table comments (
  id int not null auto_increment,
  parent_id int,
  comment varchar(2000) not null,
  user_id int not null default 1,
  create_date date not null,
  create_ts timestamp not null,
  primary key(`id`) using BTREE
) engine=InnoDB default CHARSET=utf8;

alter table users add constraint ux_users_username
UNIQUE (username);

insert into users (username, password)
values ('anonymous', 'password');
