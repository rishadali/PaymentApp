
create sequence hibernate_sequence start with 1 increment by 1;
create table account (name varchar(255) not null, balance double not null, email varchar(255), primary key (name));
create table transaction (id integer not null, amount double not null, datetime timestamp, payfrom varchar(255), payto varchar(255), primary key (id));
INSERT INTO account VALUES 
('muhammad',200,'mrishadali@gmail.com'),
('rishad',200,'mrishadali@gmail.com'),
('ali',200,'mrishadali@hotmail.com'),
('test1',200,'mrishadali@gmail.com'), 
('test2',200,'mrishadali@gmail.com'),
('test3',200,'mrishadali@gmail.com');
