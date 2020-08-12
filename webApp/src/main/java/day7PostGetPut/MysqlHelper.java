package day7PostGetPut;

import java.sql.*;

public class MysqlHelper {

    private Connection con;
    private Statement stmt;

    public MysqlHelper() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JSSDB?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","Mysql-1552");
           //con.setAutoCommit(false);
            Statement stmt=con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getContactWithName(String name) throws SQLException {
        Statement stmt=con.createStatement();
        return stmt.executeQuery("SELECT * FROM contacts where name='" + name + "';");

    }

    public void addContact(Contact contact) throws SQLException {

        PreparedStatement preStmt = con.prepareStatement("INSERT INTO contacts (name,tel_num) VALUES (?,?);");
        preStmt.setString(1,contact.getName());
        preStmt.setString(2,contact.getTelNum());
        preStmt.executeUpdate();

    }

    public void updateContact(Contact contact) throws SQLException {

        PreparedStatement preStmt = con.prepareStatement("UPDATE contacts SET tel_num = ? WHERE name LIKE ?;");
        preStmt.setString(1,contact.getTelNum());
        preStmt.setString(2,contact.getName());
        preStmt.executeUpdate();
    }

    public ResultSet getContacts() throws SQLException {
        Statement stmt=con.createStatement();
        return stmt.executeQuery("select * from contacts;");
    }



}
