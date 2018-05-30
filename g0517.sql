
drop database if exists `g0517`;
create database `g0517`;
use `g0517`;

drop table if exists `user`;
create table `user`(
	id int primary key auto_increment,
	uno varchar(20)  not null,
	account varchar(50) not null,
	password varchar(50) not null,
    email varchar(50) not null,
	gender int not null,
	role int default 0 not null,
	unique(uno),
	updtime timestamp default current_timestamp on update current_timestamp
);
insert into user values(null,'00000000000','admin','000000','admin@gmail.com',0,0,null);

insert into user values(null,'20185100518','Oliver','123456','2336@gmail.com',1,2,null);
insert into user values(null,'20185100519','Timi','456mmm','2335@gmail.com',1,2,null);
insert into user values(null,'20185100520','Jane','456123','2333@gmail.com',1,2,null);
insert into user values(null,'20185100521','Tommy','456678','2333@gmail.com',1,2,null);
insert into user values(null,'20185100522','Donnie','456445','2333@gmail.com',1,2,null);
insert into user values(null,'20185100523','Ada','4th78k','2333@gmail.com',1,2,null);
insert into user values(null,'20185100524','Alva','4efgh5','2333@gmail.com',0,2,null);
insert into user values(null,'20185100525','Brant','45ed45','2333@gmail.com',0,2,null);
insert into user values(null,'20185100526','Caspar','456aaa','2333@gmail.com',0,2,null);
insert into user values(null,'20185100527','Danrtsey','4bdc45','2333@gmail.com',0,2,null);

insert into user values(null,'00000000001','Tisa','654321','2334@gmail.com',1,1,null);
insert into user values(null,'00000000002','Lili','652143','2335@gmail.com',1,1,null);
insert into user values(null,'00000000003','Baot','111111','23345@gmail.com',0,1,null);
insert into user values(null,'00000000004','Ben','898989','1192297505@qq.com',0,1,null);
insert into user values(null,'00000000005','Presley','8frdds','1192297505@qq.com',0,1,null);
insert into user values(null,'00000000006','Elvis ','fd989','1192297505@qq.com',0,1,null);
insert into user values(null,'00000000007','Elliott','gfg989','1192297505@qq.com',0,1,null);
insert into user values(null,'00000000008','Eadgar','812349','1192297505@qq.com',0,1,null);
insert into user values(null,'00000000009','Dats','8hjkkl','1192297505@qq.com',0,1,null);
insert into user values(null,'000000000010','Douglas','8kl929','1192297505@qq.com',0,1,null);

drop table if exists `student`;
create table `student`(
	id int primary key auto_increment,
	sno varchar(20) not null,
	sname varchar(50) not null,
	dept varchar(50) not null,
	sc varchar(50) not null,
	grade varchar(50) not null,
	unique(sno),
	updtime timestamp default current_timestamp on update current_timestamp
);
insert into student values(null,'20185100518','Oliver','计算机与信息技术学院','计算机科学与技术','2018',null);
insert into student values(null,'20185100519','Timi','计算机与信息技术学院','计算机科学与技术','2018',null);
insert into student values(null,'20185100520','Jane','计算机与信息技术学院','计算机科学与技术','2018',null);
insert into student values(null,'20185100521','Tommy','生命科学学院','生物科学','2018',null);
insert into student values(null,'20185100522','Donnie','生命科学学院','生物科学','2019',null);
insert into student values(null,'20185100523','Ada','马克思主义学院','思想政治教育','2018',null);
insert into student values(null,'20185100524','Alva','马克思主义学院','思想政治教育','2019',null);
insert into student values(null,'20185100525','Brant','马克思主义学院','思想政治教育','2019',null);
insert into student values(null,'20185100526','Caspar','马克思主义学院','思想政治教育','2019',null);
insert into student values(null,'20185100527','Danrtsey','马克思主义学院','思想政治教育','2019',null);
drop table if exists `score`;
create table `score`(
	id int primary key auto_increment,
	sno_id int,
	tno_id int,
	mark double(4,2),
	pass int,
	role int not null,
	updtime timestamp default current_timestamp on update current_timestamp
);

drop table if exists `course`;
create table `course`(
	id int primary key auto_increment,
	tno varchar(20)  not null,
	tname varchar(50) not null,
	cname varchar(50) not null,
	dept varchar(50) not null,
	sc varchar(50) not null,
	grade varchar(50) not null,
	semester int default 0,
	updtime timestamp default current_timestamp on update current_timestamp
);
insert into course values(null,'00000000001','Tisa','Java','计算机与信息技术学院','计算机科学与技术','2018',0,null);
insert into course values(null,'00000000001','Tisa','Java','计算机与信息技术学院','计算机科学与技术','2019',0,null);
insert into course values(null,'00000000002','Lili','PHP','计算机与信息技术学院','物联网工程','2018',0,null);
insert into course values(null,'00000000002','Lili','PHP','计算机与信息技术学院','物联网工程','2019',0,null);
insert into course values(null,'00000000003','Baot','动物学','生命科学学院','生物科学','2018',1,null);
insert into course values(null,'00000000003','Baot','动物学','生命科学学院','生物科学','2019',1,null);
insert into course values(null,'00000000004','Ben','政治学','马克思主义学院','思想政治教育','2018',1,null);
insert into course values(null,'00000000004','Ben','政治学','马克思主义学院','思想政治教育','2019',1,null);
insert into course values(null,'00000000005','Presley','中国哲学史','马克思主义学院','思想政治教育','2018',0,null);
insert into course values(null,'00000000005','Presley','中国哲学史','马克思主义学院','思想政治教育','2019',1,null);
insert into course values(null,'00000000006','Elvis','西方哲学史','马克思主义学院','思想政治教育','2018',1,null);

drop table if exists `notice`;
create table `notice`(
	id int primary key auto_increment,
	title varchar(50) not null,
	content varchar(300),
	role int,
	unique (title),
	updtime timestamp default current_timestamp on update current_timestamp
);
insert into `notice` values(null,'通知1','学生内容',2,null);
insert into `notice` values(null,'通知2','请完成第二章第四节内容',2,null);
insert into `notice` values(null,'通知3','请完成第三章第八节内容',2,null);
insert into `notice` values(null,'通知4','教师内容',1,null);
insert into `notice` values(null,'通知5','假期结束，通知学生上课',1,null);
insert into `notice` values(null,'通知6','学生教师',0,null);

