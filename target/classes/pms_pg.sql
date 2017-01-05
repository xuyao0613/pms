DROP TABLE IF EXISTS park;
CREATE TABLE Park (
	ID VARCHAR (32),
	createTime DATE,
	updateTime DATE,
	deleteTime DATE,
	delFlag INT DEFAULT 0,
	parkName VARCHAR (50)
);

DROP TABLE IF EXISTS Vehicle;
CREATE TABLE Vehicle (
	ID VARCHAR (32),
	createTime DATE,
	updateTime DATE,
	deleteTime DATE,
	delFlag INT DEFAULT 0,
	vehicleNum VARCHAR (30)
);

