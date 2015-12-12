drop database if exists webdb;
create database webdb;
\connect webdb;
create schema webdb;

drop sequence if exists webdb.users_id_seq;
create sequence webdb.users_id_seq start with 1 increment by 1 ;
drop sequence if exists webdb.comments_id_seq;
create sequence webdb.comments_id_seq start with 1 increment by 1 ;

drop table if exists webdb.users;
create table webdb.users (
  id integer not null default nextval('users_id_seq'),
  username varchar(30) not null,
  password varchar(20) not null,
  primary key (id)
) ;

drop table if exists webdb.comments;
create table webdb.comments (
  id integer not null default nextval('comments_id_seq'),
  parent_id int,
  comment varchar(2000) not null,
  user_id int references users(id) not null,
  create_date date not null,
  create_ts timestamp not null,
  primary key (id)
) ;

insert into webdb.users (username, password)
values ('anonymous', 'password');
