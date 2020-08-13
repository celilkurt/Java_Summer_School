package day7CRUDApp.dao;

import day7CRUDApp.entity.Contact;
import day7CRUDApp.entity.DBResult;
import day7CRUDApp.exception.RecordsNotFoundException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlHelper {

    private static MysqlHelper instance;
    private static final Logger logger = Logger.getLogger(MysqlHelper.class);

    private MysqlHelper(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JSSDB?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","Mysql-1552");

        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

    synchronized public static MysqlHelper getInstance(){
        if(instance == null){
            instance = new MysqlHelper();
        }
        return instance;
    }

    private Connection con;
    private Statement stmt;



    public DBResult getContactWithName(String name) {
        Statement stmt= null;
        Contact contact = null;
        DBResult dbResult = new DBResult();
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM contacts where name='" + name + "';");
            if(results.next())
                contact = new Contact(results.getString(1),results.getString(2));
            dbResult.setResult(contact);
            dbResult.setSuccessful(true);
            stmt.close();
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            dbResult.setMessage(throwables.getMessage());
            dbResult.setSuccessful(false);
        }finally{
            dbResult.setResult(contact);
            return dbResult;
        }

    }

    public DBResult addContact(Contact contact){

        PreparedStatement preStmt = null;
        String message = "";
        DBResult dbResult = new DBResult();
        try {
            preStmt = con.prepareStatement("INSERT INTO contacts (name,tel_num) VALUES (?,?);");
            preStmt.setString(1,contact.getName());
            preStmt.setString(2,contact.getTelNum());
            preStmt.executeUpdate();
            dbResult.setMessage(contact.getName() +"'s contact has been created!");
            dbResult.setSuccessful(true);
            preStmt.close();

        } catch (SQLException throwables) {

            dbResult.setMessage(throwables.getMessage());
            dbResult.setSuccessful(false);

        }finally {
            logger.error(dbResult.getMessage());
            return dbResult;
        }

    }

    public DBResult updateContact(Contact contact){
        String message = "";
        PreparedStatement preStmt = null;
        DBResult dbResult = new DBResult();
        try {
            preStmt = con.prepareStatement("UPDATE contacts SET tel_num = ? WHERE name LIKE ?;");
            preStmt.setString(1,contact.getTelNum());
            preStmt.setString(2,contact.getName());
            preStmt.executeUpdate();
            dbResult.setMessage(contact.getName() + "'s contact has been updated!");
            dbResult.setSuccessful(true);
            preStmt.close();
        } catch (SQLException throwables) {
            dbResult.setMessage(throwables.getMessage());
            dbResult.setSuccessful(false);

        }finally {
            logger.error(dbResult.getMessage());
            return dbResult;
        }

    }

    public DBResult getContacts(){

        Statement stmt= null;
        List<Contact> contacts = new ArrayList<>();
        DBResult dbResult = new DBResult();
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("select * from contacts;");
            while(results.next())
                contacts.add(new Contact(results.getString(1),results.getString(2)));

            dbResult.setSuccessful(true);
            stmt.close();
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
            //throwables.printStackTrace();
            dbResult.setSuccessful(false);
            dbResult.setMessage(throwables.getMessage());
        }finally {
            dbResult.setResult(contacts);
            return dbResult;
        }

    }

    public String deleteContact(String name){

        Statement stmt = null;
        String message = "";
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("delete from contacts where name = '"+name+"';");
            message = "Contact deleted from table!";
        }catch(SQLException e){
            message = e.getMessage();
        }finally {
            return message;
        }
    }



}
