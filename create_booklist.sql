drop table booklist;
create table booklist (
       id int unsigned auto_increment primary key not null,
       author varchar(256),
       title varchar(512),
       publisher varchar(256),
       price int, ISBN char(10)
);

load data infile '/Users/fkd/co/webexperiment/BookList.csv' into table booklist fields terminated by ',' enclosed by '"';
