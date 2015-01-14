drop table instance;
drop table cloud;

create table cloud (cloudid INT NOT NULL, primary key(cloudid), name varchar(20), publicip varchar(20),privateip varchar(20), geolocation varchar(20));

insert into cloud values(1, "US-WEST","125.250.100.0" ,"55.22.10.0" ,"US-WEST");
insert into cloud values(2, "US-EAST","135.100.100.0" ,"65.22.10.0" ,"US-EAST");
insert into cloud values(3, "US-MIDWEST","145.350.100.0" ,"75.22.10.0" ,"US-MIDWEST");
insert into cloud values(4, "CHINA","200.250.100.0" ,"85.22.10.0" ,"CHINA");
insert into cloud values(5, "INDIA","300.250.100.0" ,"95.22.10.0" ,"INDIA");

select * from cloud;

create table instance (instanceid INT NOT NULL, primary key(instanceid), cloudid INT,
INDEX par_ind (cloudid),FOREIGN KEY (cloudid) REFERENCES cloud(cloudid) ON DELETE CASCADE  ,
name varchar(20), status varchar(20), type varchar(20),
 os varchar(20), cpu varchar(20), memory varchar(20),storage varchar(20), 
publicip varchar(20),privateip varchar(20), 
uptime long, userid int);

select * from instance;

insert into instance values(1, 1, "c1mi1i1", "Active", "Mobile", "iOS", "1Ghz", "512Mb", "2Gb", "125.250.100.1" ,"55.22.10.1" ,0, null);
insert into instance values(2, 2, "c2mi1i1", "Active", "Mobile", "iOS", "1Ghz", "512Mb", "2Gb", "135.100.100.1" ,"65.22.10.1" ,0, null);
insert into instance values(3, 3, "c3mi1i1", "Active", "Mobile", "iOS", "1Ghz", "512Mb", "2Gb", "145.350.100.1" ,"75.22.10.1" ,0, null);
insert into instance values(4, 4, "c4mi1i1", "Active", "Mobile", "iOS", "1Ghz", "512Mb", "2Gb", "200.250.100.1" ,"85.22.10.1" ,0, null);
insert into instance values(5, 5, "c5mi1i1", "Active", "Mobile", "iOS", "1Ghz", "512Mb", "2Gb", "300.250.100.1" ,"95.22.10.1" ,0, null);

insert into instance values(6, 1, "c1mi2a1", "Active", "Mobile", "Android", "1Ghz", "512Mb", "2Gb", "125.250.100.2" ,"55.22.10.2" ,0, null);
insert into instance values(7, 2, "c2mi2a1", "Active", "Mobile", "Android", "1Ghz", "512Mb", "2Gb", "135.100.100.2" ,"65.22.10.2" ,0, null);
insert into instance values(8, 3, "c3mi2a1", "Active", "Mobile", "Android", "1Ghz", "512Mb", "2Gb", "145.350.100.2" ,"75.22.10.2" ,0, null);
insert into instance values(9, 4, "c4mi2a1", "Active", "Mobile", "Android", "1Ghz", "512Mb", "2Gb", "200.250.100.2" ,"85.22.10.2" ,0, null);
insert into instance values(10, 5, "c5mi2a1", "Active", "Mobile", "Android", "1Ghz", "512Mb", "2Gb", "300.250.100.2" ,"95.22.10.2" ,0, null);

insert into instance values(11, 1, "c1ci1l1", "Active", "Computer", "Linux", "1Ghz", "512Mb", "2Gb", "125.250.100.3" ,"55.22.10.3" ,0, null);
insert into instance values(12, 2, "c2ci1l1", "Active", "Computer", "Linux", "1Ghz", "512Mb", "2Gb", "135.100.100.3" ,"65.22.10.3" ,0, null);
insert into instance values(13, 3, "c3ci1l1", "Active", "Computer", "Linux", "1Ghz", "512Mb", "2Gb", "145.350.100.3" ,"75.22.10.3" ,0, null);
insert into instance values(14, 4, "c4ci1l1", "Active", "Computer", "Linux", "1Ghz", "512Mb", "2Gb", "200.250.100.3" ,"85.22.10.3" ,0, null);
insert into instance values(15,5, "c5ci1l1", "Active", "Computer", "Linux", "1Ghz", "512Mb", "2Gb", "300.250.100.3" ,"95.22.10.3" ,0, null);

insert into instance values(16, 1, "c1ci2w1", "Active", "Computer", "Windows", "1Ghz", "512Mb", "2Gb", "125.250.100.4" ,"55.22.10.4" ,0, null);
insert into instance values(17, 2, "c2ci2w1", "Active", "Computer", "Windows", "1Ghz", "512Mb", "2Gb", "135.100.100.4" ,"65.22.10.4" ,0, null);
insert into instance values(18, 3, "c3ci2w1", "Active", "Computer", "Windows", "1Ghz", "512Mb", "2Gb", "145.350.100.4" ,"75.22.10.4" ,0, null);
insert into instance values(19, 4, "c4ci2w1", "Active", "Computer", "Windows", "1Ghz", "512Mb", "2Gb", "200.250.100.4" ,"85.22.10.4" ,0, null);
insert into instance values(20,5, "c5ci2w1", "Active", "Computer", "Windows", "1Ghz", "512Mb", "2Gb", "300.250.100.4" ,"95.22.10.4" ,0, null);

drop table user;

create table user (userid INT NOT NULL, primary key(userid), 
 name varchar(20), creditcard varchar(20), emailid varchar(20),
 phone varchar(20), totalbill double, paidbill double);

insert into user values(1, "Sudip" , "1234567890" , "sudip@test.com", "1234567890" , 0.0, 0.0);
insert into user values(2, "Kumar" , "9876543210" , "kumar@test.com", "9876543210" , 0.0, 0.0);

select * from user ;

drop table rate;
create table rate  (rateid INT NOT NULL, primary key(rateid), 
type varchar(20), component varchar(20), costpermin double);

insert into rate values (1, "Mobile" , "cpu" , 0.07 );
insert into rate values (2, "Mobile" , "memory" , 0.06 );
insert into rate values (3, "Mobile" , "storage" , 0.05 );
insert into rate values (4, "Computer" , "cpu" , 0.05 );
insert into rate values (5, "Computer" , "memory" , 0.04 );
insert into rate values (6, "Computer" , "storage" , 0.03 );

select * from rate ;
