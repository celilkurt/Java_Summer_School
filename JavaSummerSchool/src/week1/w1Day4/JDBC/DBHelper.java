package week1.w1Day4.JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBHelper {

    private Connection con;
    private Statement stmt;

    public DBHelper(Connection con) {
        this.con = con;
        try {
            con.setAutoCommit(false);
            stmt=con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void insertTextIntoTextsTable(String text) throws SQLException{

        String INSERT_SQL="INSERT IGNORE INTO texts (text) VALUES ('"+text+"');";
        stmt.executeUpdate(INSERT_SQL);
    }

    public ResultSet getQuery(String sql){

        try {
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void insertAllWordIntoTable(HashMap<String,Integer> wordMap) throws SQLException{
        PreparedStatement preStmt = con.prepareStatement("INSERT IGNORE INTO words (word,frequence) VALUES (?,?);");

        for(Map.Entry<String,Integer> entry:wordMap.entrySet()){
            preStmt.setString(1,entry.getKey());
            preStmt.setInt(2,entry.getValue());
            preStmt.executeUpdate();

        }
    }

    public void commit(){
        try {
            con.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(){
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
