insert into lector(id, first_name, second_name, salary, degree) values (1, "Nick" , "Scout", 9999, "PROFESSOR");
insert into lector(id, first_name, second_name, salary, degree) values (2, "Ilya" , "Xumuk", 8888, "PROFESSOR");
insert into lector(id, first_name, second_name, salary, degree) values (3, "Ivan" , "Ivanov", 715, "ASSOCIATE_PROFESSOR");
insert into lector(id, first_name, second_name, salary, degree) values (4, "Petr" , "Petrov", 1776, "ASSOCIATE_PROFESSOR");
insert into lector(id, first_name, second_name, salary, degree) values (5, "Pavel" , "Morozov", 1337, "ASSOCIATE_PROFESSOR");
insert into lector(id, first_name, second_name, salary, degree) values (6,"Red" , "Head", 420 , "ASSISTANT");

insert into department (id, name, head_id) values (1, "ami" , 1);
insert into department (id, name, head_id) values (2, "chemistry" , 2);
insert into department (id, name, head_id) values (3, "his" , 3);

insert into departments_lectors (lector_id, department_id)
values (1, 1);
insert into departments_lectors (lector_id, department_id)
values (1, 2);
insert into departments_lectors (lector_id, department_id)
values (1, 4);

insert into departments_lectors (lector_id, department_id)
values (2, 2);
insert into departments_lectors (lector_id, department_id)
values (2, 4);
insert into departments_lectors (lector_id, department_id)
values (2, 6);


insert into departments_lectors (lector_id, department_id)
values (3, 3);
insert into departments_lectors (lector_id, department_id)
values (3, 5);
insert into departments_lectors (lector_id, department_id)
values (3, 6);



