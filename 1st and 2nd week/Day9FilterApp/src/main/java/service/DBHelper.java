package service;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class DBHelper {

    private static DBHelper instance;
    private static final Logger logger = Logger.getLogger(DBHelper.class);

    private Connection con;

    private DBHelper(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JSSDB?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","Mysql-1552");

        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }

    }

    synchronized public static DBHelper getInstance(){
        if(instance == null)
            instance = new DBHelper();
        return instance;
    }

    public boolean isUserExist(String name, String password){

        //password = BCrypt.hashpw(password, BCrypt.gensalt());
        String query = "SELECT * FROM users WHERE name = '" + name + "';";
        Statement stmt= null;
        try {
            stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if(result.next()){
                return BCrypt.checkpw(password, result.getString(2));
            }

        }catch(SQLException e){
            logger.error(e.getMessage());
        }
        return false;
    }

    public String createUser(String name, String password){

        String message = "";
        password = BCrypt.hashpw(password, BCrypt.gensalt());
        String query = "INSERT INTO users VALUES ( '" + name + "' , '" + password + "');";
        Statement stmt = null;

        try  {
             stmt = con.createStatement();
             stmt.executeUpdate(query);
             message = "You have signed up successfully!";

        }catch (SQLException e){
            logger.error(e.getMessage());
            message = e.getMessage();
        }finally {
            return message;
        }

    }




}

