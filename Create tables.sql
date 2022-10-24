CREATE TABLE IF NOT EXISTS Administrators(
AdminID int primary key auto_increment,
AdminSname varchar(50),
AdminLname varchar(50),
SSN varchar(50),
AdminPassword varchar(50)
);

CREATE TABLE IF NOT EXISTS Users(
UserID int primary key auto_increment,
FirstName varchar(50),
LastName varchar(50),
CustomerPassword varchar(10) NOT NULL,
AdminID int,
foreign key (AdminID) references administrators(AdminID) on delete cascade
);

CREATE TABLE IF NOT EXISTS Accounts(
ID int primary key auto_increment,
Balance double
);
CREATE TABLE IF NOT EXISTS Transfers(
TransfertID int primary key auto_increment,
UserID int,
Amount varchar(50),
ToUserID int,
foreign key (UserID) references users(UserID),
foreign key (ToUserID) references users(UserID)
);

CREATE TABLE IF NOT EXISTS UsersAccount(
ID int primary key auto_increment,
UserID int,
AccountID int,
AdminID int,
foreign key (UserID) references Users(UserID) on delete cascade,
foreign key (AccountID) references Accounts(ID) on delete cascade,
foreign key (AdminID) references administrators(AdminID) on delete cascade
);