DELETE u,a,ua
FROM users u 
JOIN usersaccount ua ON u.UserID=ua.UserID
JOIN accounts a ON u.UserID=a.ID
WHERE u.UserID=3;

DELETE users,accounts,usersaccount
FROM users u 
JOIN usersaccount us ON u.UserID=us.UsersID
JOIN accounts a ON a.ID=us.AccountID
WHERE a.ID=1;

DELETE FROM users WHERE UserID=6;



UPDATE users 
SET FirstName=LUX
WHERE UserID =6;
UPDATE users 
SET LastName=LOL
WHERE UserID =6;
UPDATE accounts 
SET Balance = 9999
WHERE accounts.ID=6;

UPDATE users u,accounts a,usersaccount ua
SET u.FirstName='LUX', u.LastName='LOL' , a.Balance='999999'
WHERE u.UserID=6 AND  a.ID=6;
