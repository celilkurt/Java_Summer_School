package week1.w1Day4.JDBC;

import sun.nio.cs.CharsetMapping;

import java.sql.*;
import java.util.*;

public class Main {

    private static final String CREATE_TABLE_SQL="CREATE TABLE texts (text VARCHAR(200) NOT NULL UNIQUE);";
    private static String CREATE_WORDS_TABLE_SQL = " CREATE TABLE words (word VARCHAR(100) NOT NULL UNIQUE,frequence INT);";
    static List<String> texts = Arrays.asList("Kendisinin Hollandalı olduğu duydu düşünülmektedir  7 yaşındayken ailesiyle birlikte Michigandaki Port Hurona yerleşti ve ",
            "ilköğrenimine burada başladı; fakat bir başladıktan yaklaşık 4 ay sonra duydu algılamasının yavaşlığı nedeniyle okuldan uzaklaştırıldı" ,
            "  Bu arada evlerinin burada kilerinde hello it's me bir kimya laboratuvarı bir bir kurdu  Özellikle kimya deneylerine ve Volta kaplarından elektrik akımı elde etmeye yönelik araştırmalara " ,
            "ilgi duydu  Bir süre sonra kendi başına bir telgraf aleti yaptı duydu ve Mors alfabesini öğrendi  O günlerde geçirdiği ağır bir hastalık sonucu kulakları zor işitmeye" ,
            " başladı.[kaynak burada belirtilmeli  12 yaşındayken bir  bir trende dergi ve meyve satıyor, bir yandan da trenin yük vagonunu yerleştirdiği küçük bir baskı makinesi ile " ,
            "haftalık duydu duydu duydu bir burada gazete basıyordu ");

    public static void main(String[] args){

        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JSSDB?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","Mysql-1552");
            con.setAutoCommit(false);
            Statement stmt=con.createStatement();


            //stmt.executeUpdate(CREATE_TABLE_SQL);
            //stmt.executeUpdate(CREATE_WORDS_TABLE_SQL);


            for(String text: texts){
                insertTextIntoTextsTable(text,stmt);
            }

            //Database'den textleri çekip kelime kelime list'e atıyor.
            List<String> words = new ArrayList<>();
            ResultSet results = stmt.executeQuery("SELECT * FROM texts;");
            while(results.next()){
                addAllWordsIntoList(words,results.getString("text"));
            }

            //Kelimeleri tekrar sayısılarıyla hashmap'e kaydediyor.
            HashMap<String,Integer> wordMap = createWordMapWithFrequences(words);

            //Kelimeleri sıklıklarıyla birlikte words tablosuna kaydediyor.
            insertAllWordIntoWordsTable(wordMap,con);

            printMap(wordMap);

            System.out.println("----------------------------------------------------------");
            results = stmt.executeQuery("SELECT * FROM words ORDER BY word ASC;");
            printWordsFromResultSet(results);

            System.out.println("----------------------------------------------------------");
            results = stmt.executeQuery("SELECT * FROM words ORDER BY frequence ASC;");
            printWordsFromResultSet(results);

            con.commit();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    static void printWordsFromResultSet(ResultSet results) throws SQLException{
        while(results.next()){
            System.out.println(results.getString("word") + ": " + results.getInt("frequence"));
        }
    }

    static void insertAllWordIntoWordsTable(HashMap<String,Integer> wordMap,Connection con) throws SQLException{
        PreparedStatement preStmt = con.prepareStatement("INSERT IGNORE INTO words (word,frequence) VALUES (?,?);");

        for(Map.Entry<String,Integer> entry:wordMap.entrySet()){
            preStmt.setString(1,entry.getKey());
            preStmt.setInt(2,entry.getValue());
            preStmt.executeUpdate();

        }
    }

    static HashMap<String,Integer> createWordMapWithFrequences(List<String> words)  {
        HashMap<String,Integer> wordMap = new HashMap<>();
        for(String word: words){

            if(wordMap.containsKey(word)){
                wordMap.put(word,wordMap.get(word)+1);
            }else
                wordMap.put(word,1);
        }

        return wordMap;
    }

    static void addAllWordsIntoList(List<String> words, String sentence){
        words.addAll(Arrays.asList(sentence.split("[ ]+")));

    }

    static void insertTextIntoTextsTable(String text, Statement stmt) throws SQLException{

        String INSERT_SQL="INSERT IGNORE INTO texts (text) VALUES ('"+text+"');";
        stmt.executeUpdate(INSERT_SQL);
    }

    static void printMap(HashMap<String,Integer> wordMap){
        for(Map.Entry<String,Integer> entry:wordMap.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }




}
