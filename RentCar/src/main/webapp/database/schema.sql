CREATE TABLE users(
usersNum int,
usersName varchar(20),
phone varchar(20),
clientID varchar(20),
password varchar(20),
age char(3),
PRIMARY KEY (usersNum, clientID)
registDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE car(
carNum int PRIMARY KEY,
carName varchar(20),
hourPrice varchar(20),
year char(4),
seater char(2),
possibleAge char(3),
registDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE booking(
carNum int ,
carName varchar(20),
borrowDate varchar(20),
totalPayment varchar(20),
clientNum int,
returnDate varchar(20),
registDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (carNum, clientNum), 
FOREIGN KEY (carNum) REFERENCES car (carNum),
FOREIGN KEY (clientNum) REFERENCES users (usersNum)
);

CREATE TABLE review(
reviewNum int,
tittle varchar(20),
contents varchar(100),
writerID varchar(20),
writeDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
carNum int,
PRIMARY KEY (reviewNum, carNum),
FOREIGN KEY (carNum) REFERENCES car (carNum)
);




CREATE TABLE announcement (
number int,
tittle varchar(20),
contents varchar(100),
writerID varchar(20),
writeDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);
