create table if not exists universities(
   id              bigint auto_increment not null,
   uni_id          int not null,
   "name"          varchar not null,
   city            varchar not  null,
   foundation_year int not null
);

create table if not exists students(
   id              bigint auto_increment not null,
   student_id      int not null,
   "name"          varchar not  null,
   birth_date      varchar not  null,
   university_id   int,
   foreign key (university_id) references universities(uni_id)
);

insert into universities values (default, 90781, 'Uni at Sea', 'SeaSharp', 1990);
insert into universities values (default, 66811, 'Uni of the Mountain', 'New York', 1992);
insert into universities values (default, 44821, 'MIT', 'Canterburry', 1932);


insert into students values (default, 123, 'John Doe', '1-11-1999', null);
insert into students values (default, 345, 'Naruto Smit', '2-01-1989', null);
insert into students values (default, 567, 'Lucky Luke', '3-10-1900', null);

update students s set university_id=90781 where student_id = 123;
update students s set university_id=66811 where student_id = 345;
