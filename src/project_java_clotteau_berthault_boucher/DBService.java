/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_java_clotteau_berthault_boucher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mclot
 */
public class DBService {

    public Connection connect() {
        String url = "jdbc:mysql://localhost:3306/bankschema";
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, "root", "1234");
        } catch (SQLException ex) {
            connection = null;
            ex.printStackTrace();
        }
        return connection;
    }

    ;
    
    int AddAccount(String firstName, String lastName, String password, Double balance) {
        int userID = -1;
        int accountID = -1;
        Connection connection = connect();
        try {
            String addUserSql = "INSERT INTO users(FirstName,LastName,Password) VALUES ('" + firstName + "','" + lastName + "','" + password + "')";
            Statement addUser = connection.createStatement();
            ResultSet addUserResults = addUser.executeQuery(addUserSql);
            if (addUserResults.next()) {
                userID = addUserResults.getInt(1);
            }
            String addAccountSql = "INSERT INTO accounts (Balance) VALUES ('" + balance + "')";
            PreparedStatement addAccount = connection.prepareStatement(addUserSql, Statement.RETURN_GENERATED_KEYS);
            ResultSet addAccountResults = addUser.getGeneratedKeys();
            if (addUserResults.next()) {
                accountID = addAccountResults.getInt(1);
            }
            if (userID > 0 && accountID > 0) {
                String linkAccountsql = "INSERT INTO usersaccount(UserID,AccountID) VALUES ('" + userID + "','" + accountID + "')";
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println("ERROR :" + ex);
        }
        return accountID;
    }

    public int AddAdminAccount(String firstName, String lastName, String password, String ssn) {
        int adminID = -1;
        Connection connection = connect();
        try {
            System.out.println("alalalalaal   " + firstName + " " + lastName + " " + password + " " + ssn);
            String addAdminSql = "INSERT INTO administrators(AdminSname,AdminLname,SSN,AdminPassword) VALUES ('" + firstName + "','" + lastName + "','" + ssn + "','" + password + "')";
            Statement addAdmin = connection.createStatement();
            addAdmin.execute(addAdminSql);
            connection.close();

        } catch (Exception ex) {
            System.err.println("ERROR :" + ex);
            ex.printStackTrace();
        }
        return adminID;
    }

    boolean findAdminRegister(String ssn) {
        Boolean check = false;
        Connection connection = connect();
        try {
            String findAdminSql = "SELECT * FROM administrators WHERE SSN='" + ssn + "'";
            Statement admin = connection.createStatement();
            ResultSet rset = admin.executeQuery(findAdminSql);
            if (rset.next()) {
                System.out.println("Admin already exist");
                check = true;
            } else if (rset.next() == false) {
                System.out.println("Admin does not exist, creating one");
                check = false;
            }
        } catch (Exception ex) {
            System.out.println("ERROR " + ex);
            ex.printStackTrace();
        }
        return check;
    }

    boolean findAdminLogin(String firstname, String lastname, String ssn, String password) {
        Boolean check = false;
        Connection connection = connect();
        try {
            JOptionPane.showMessageDialog(null, "Your info :" + firstname + " " + lastname + " " + ssn + " " + password);
            String findAdminSql = "SELECT a.AdminSname, a.AdminLname, a.SSN,a.AdminPassword FROM administrators a WHERE a.AdminSname='" + firstname + "' AND a.AdminLname='" + lastname + "' AND a.SSN='" + ssn + "' AND a.AdminPassword='" + password + "'";
            Statement admin = connection.createStatement();
            ResultSet rset = admin.executeQuery(findAdminSql);
            if (rset.next()) {
                System.out.println("WELCOME");
                check = true;
            } else if (rset.next()) {
                System.out.println("Admin does not exist");
                check = false;
            }
        } catch (Exception ex) {
            System.out.println("ERROR " + ex);
            ex.printStackTrace();
        }
        return check;
    }

    boolean findUser(String firstname, String lastname, String password) {
        Boolean check = false;
        Connection connection = connect();
        try {
            JOptionPane.showMessageDialog(null, "Your info :" + firstname + " " + lastname + " " + password);
            String findUserSql = "SELECT u.FirstName, u.LastName, u.CustomerPassword FROM users u WHERE u.FirstName='" + firstname + "' AND u.LastName='" + lastname + "' AND u.CustomerPassword='" + password + "'";
            Statement user = connection.createStatement();
            ResultSet rset = user.executeQuery(findUserSql);
            if (rset.next()) {
                System.out.println("WELCOME");
                check = true;
            } else if (rset.next()) {
                System.out.println("user does not exist");
                check = false;
            }
        } catch (Exception ex) {
            System.out.println("ERROR " + ex);
            ex.printStackTrace();
        }
        return check;
    }

    public int AddUserAccount(String firstName, String lastName, String password, int adminID) {
        int userIDGenerated = -1;
        Connection connection = connect();
        try {
            System.out.println("Adding user :   " + firstName + " " + lastName + " " + password + " " + adminID);
            String addUserSql = "INSERT INTO users(FirstName,Lastname,CustomerPassword,AdminID) VALUES ('" + firstName + "','" + lastName + "','" + password + "','" + adminID + "')";
            Statement addUser = connection.createStatement();
            addUser.execute(addUserSql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rset = addUser.getGeneratedKeys();
            if (rset.next()) {
                userIDGenerated = rset.getInt(1);
            }
            connection.close();
        } catch (Exception ex) {
            System.err.println("ERROR :" + ex);
            ex.printStackTrace();
        }
        return userIDGenerated;
    }

    public int AddBalanceUser(int idUser, double balance) {
        int idAccount = -1;
        Connection connection = connect();
        try {
            String BalanceSql = "INSERT INTO accounts(ID,Balance) VALUES ('" + idUser + "','" + balance + "')";
            Statement BalanceUser = connection.createStatement();
            BalanceUser.execute(BalanceSql);

            idAccount = idUser;
            System.out.println("This is the new id generated Acoount : " + idAccount);
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return idAccount;
    }

    public int AddInfoUser(int idUser, int idAccount, int idadmin) {
        Connection connection = connect();
        try {
            String InfoUserSql = "INSERT INTO usersaccount(UserID,AccountID,AdminID) VALUE('" + idUser + "','" + idAccount + "','" + idadmin + "')";
            Statement InfoUser = connection.createStatement();
            InfoUser.execute(InfoUserSql);
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    public boolean UpdateAdmin(int accountID, String firstname, String lastname, double balance) {
        boolean success = false;
        Connection connection = connect();
        try {
            String updateSql = "UPDATE users u,accounts a"
                    + " SET u.FirstName='" + firstname + "', u.LastName='" + lastname + "' , a.Balance='" + balance + "'"
                    + " WHERE u.UserID='" + accountID + "' AND  a.ID='" + accountID + "'";
            Statement UpdateBalance = connection.createStatement();
            UpdateBalance.execute(updateSql);
            success = true;
        } catch (SQLException ex) {
            System.err.println("ERROR : " + ex);
        }
        return success;
    }

    public boolean UpdateUsers(int accountID, double balance) {
        boolean success = false;
        Connection connection = connect();
        try {
            String updateSql = "UPDATE accounts SET Balance ='" + balance + "' WHERE ID = '" + accountID + "'";
            Statement UpdateBalance = connection.createStatement();
            UpdateBalance.execute(updateSql);
            success = true;

        } catch (SQLException ex) {
            System.err.println("ERROR : " + ex);
        }
        JOptionPane.showMessageDialog(null, "the success of tranfereing the money is : " + success);
        return success;
    }

    public boolean Delete(int accountID) {
        boolean success = false;
        Connection connection = connect();
        try {
            System.out.println("USER GOING TO BE DELETED :" + accountID);
            String deleteSql = "DELETE u,a,ua"
                    + " FROM users u"
                    + " JOIN usersaccount ua ON u.UserID=ua.UserID"
                    + " JOIN accounts a ON u.UserID=a.ID"
                    + " WHERE u.UserID='" + accountID + "'";
            Statement deleteAccount = connection.createStatement();
            deleteAccount.execute(deleteSql);
            JOptionPane.showMessageDialog(null, "User DELETED");
            success = true;
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("ERRORORO " + ex);
        }
        return success;
    }

    public int getID(String firstname, String lastname) {
        int id = -1;
        Connection connection = connect();
        String userID = "SELECT u.UserID FROM users u WHERE FirstName='" + firstname + "' AND LastName='" + lastname + "'";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rset = stmt.executeQuery(userID);
            if (rset.next()) {
                id = rset.getInt(1);
            } else {
                JOptionPane.showMessageDialog(null, "User Do not exist");
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    public double transferBalance(double amount, int ID) {
        double actualBalance = 0.0;
        Connection connection = connect();
        String getBalance = "SELECT a.Balance FROM accounts a WHERE ID='" + ID + "'";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rset = stmt.executeQuery(getBalance);
            if (rset.next()) {
                actualBalance = rset.getInt(1);
            }
            actualBalance += amount;
            if (UpdateUsers(ID, actualBalance) == false) {
                JOptionPane.showMessageDialog(null, "Money did not transfert");
                UpdateUsers(ID, actualBalance - amount);
                return -1;
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actualBalance;
    }

    public String getPassword(int id) {
        String password = "";
        String getOldPassword = "SELECT CustomerPassword FROM users WHERE UserID='" + LoginUser.idUser + "'";
        Connection connection = connect();
        Statement stmt;
        try {
            stmt = connection.createStatement();
            ResultSet rset = stmt.executeQuery(getOldPassword);
            if (rset.next()) {
                password = rset.getString(1);
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return password;
    }

    public double getBalance(int id) {
        Connection connection = connect();
        String getBalance = "SELECT Balance FROM accounts WHERE ID='" + id + "'";
        Statement stmt;
        double balance = -1;
        try {
            stmt = connection.createStatement();
            stmt.execute(getBalance);
            ResultSet rset = stmt.executeQuery(getBalance);
            if (rset.next()) {
                balance = rset.getDouble(1);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }

    public boolean checkPassword(String pass1, String pass2) {
        Character[] arr1 = new Character[pass1.length()];
        Character[] arr2 = new Character[pass1.length()];

        if (pass1.length() != pass2.length()) {
            return false;
        } else {
            for (int i = 0; i < pass1.length(); i++) {
                if (pass1.charAt(i) != pass2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public String getFirstName(int id){
        Connection connection = connect();
        String getFirstname="SELECT FirstName FROM users WHERE UserID='"+id+"'";
        try{
           String firstname="";
           Statement stmt = connection.createStatement();
           ResultSet rset = stmt.executeQuery(getFirstname);
           if(rset.next()){
               firstname=rset.getString(1);
           }
           connection.close();
           JOptionPane.showMessageDialog(null, "Firstname : "+firstname);
           return firstname;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public String getLasttName(int id){
        Connection connection = connect();
        String getFirstname="SELECT LastName FROM users WHERE UserID='"+id+"'";
        try{
           String lastname="";
           Statement stmt = connection.createStatement();
           ResultSet rset = stmt.executeQuery(getFirstname);
           if(rset.next()){
               lastname=rset.getString(1);
           }
           connection.close();
           JOptionPane.showMessageDialog(null, "Firstname : "+lastname);
           return lastname;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public int addTransfert(int id,String amount,int toID){
        int success=-1;
        Connection connection =connect();
        String insert="INSERT INTO transfers(UserID,Amount,ToUserID) VALUE ('"+id+"','"+amount+"','"+toID+"')";
        try{
            Statement stmt=connection.createStatement();
            stmt.execute(insert);
            connection.close();
            success=1;
            JOptionPane.showMessageDialog(null,"TRANSFERT ADDED");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return success;
    }
}
