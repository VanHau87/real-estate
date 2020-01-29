CREATE TABLE role (
	roleid smallint unsigned auto_increment primary key,
	code varchar(20) not null,
	name varchar(255) not null,
	createddate timestamp,
	createdby varchar(255),
	modifieddate timestamp,
	modifiedby varchar(255)
);
CREATE TABLE users (
	userid int unsigned auto_increment primary key,
	username varchar(100) not null,
	fullname varchar(255),
	password varchar(100),
	createddate timestamp,
	createdby varchar(255),
	modifieddate timestamp,
	modifiedby varchar(255)
);

CREATE TABLE user_role (
	id mediumint unsigned auto_increment primary key,
	roleid smallint unsigned not null,
	userid int unsigned not null
);

ALTER TABLE user_role ADD FOREIGN KEY (roleid) REFERENCES role(roleid);
ALTER TABLE user_role ADD FOREIGN KEY (userid) REFERENCES users(userid);

CREATE TABLE building (
	buildingid smallint unsigned not null primary key,
	name varchar(255) not null,
	ward varchar(255),
	street varchar(255),
	structure varchar(100),
	num_of_basement int,
	floor_area int,
	direction varchar(255),
	rank varchar(255),
	area_description text,
	rental int,
	rental_description text,
	service_charge varchar(255),
	car_cost varchar(255),
	moto_cost varchar(255),
	ot_cost varchar(255),
	electric_bill varchar(255),
	deposit varchar(255),
	payment varchar(255),
	time_rent varchar(255),
	time_decoration varchar(255),
	management varchar(255),
	management_phone varchar(255),
	distric varchar(255),
	types text,
	createddate timestamp,
	createdby varchar(255),
	modifieddate timestamp,
	modifiedby varchar(255)
);
CREATE TABLE rentarea (
	id int unsigned auto_increment primary key,
	value int not null,
	buildingid smallint unsigned not null,
	createddate timestamp,
	createdby varchar(255),
	modifieddate timestamp,
	modifiedby varchar(255)
);

ALTER TABLE rentarea ADD FOREIGN KEY (buildingid) REFERENCES building(buildingid);

CREATE TABLE assignedbuilding (
	id mediumint unsigned auto_increment primary key,
	staffid mediumint unsigned not null,
	buildingid smallint unsigned not null
);
ALTER TABLE assignedbuilding ADD FOREIGN KEY (buildingid) REFERENCES building(buildingid);
ALTER TABLE assignedbuilding ADD FOREIGN KEY (staffid) REFERENCES users(userid);


CREATE TABLE usertracking (
	userid int unsigned auto_increment primary key,
	username varchar(100) not null,
	fullname varchar(255),
	actions varchar(255) not null,
	createddate timestamp
);

CREATE TABLE buildingtracking (
	buildingid smallint unsigned not null primary key,
	name varchar(255) not null,
	ward varchar(255),
	street varchar(255),
	structure varchar(100),
	num_of_basement int,
	floor_area int,
	direction varchar(255),
	rank varchar(255),
	area_description text,
	rental int,
	rental_description text,
	service_charge varchar(255),
	car_cost varchar(255),
	moto_cost varchar(255),
	ot_cost varchar(255),
	electric_bill varchar(255),
	deposit varchar(255),
	payment varchar(255),
	time_rent varchar(255),
	time_decoration varchar(255),
	management varchar(255),
	management_phone varchar(255),
	distric varchar(255),
	types text,
	actions varchar(255),
	createddate timestamp
);

CREATE TABLE rentareatracking (
	id int unsigned auto_increment primary key,
	value int not null,
	buildingid smallint unsigned not null,
	actions varchar(255),
	createddate timestamp
);
CREATE TABLE assignedbuildingtracking (
	id mediumint unsigned auto_increment primary key,
	staffid mediumint unsigned not null,
	buildingid smallint unsigned not null,
	actions varchar(255),
	createddate timestamp
);






