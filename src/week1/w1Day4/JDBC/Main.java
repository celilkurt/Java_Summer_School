package week1.w1Day4.JDBC;

import sun.nio.cs.CharsetMapping;

import java.sql.*;
import java.util.*;

public class Main {

    private static final String CREATE_TABLE_SQL="CREATE TABLE texts (text VARCHAR(200) NOT NULL UNIQUE);";

    static List<String> texts = Arrays.asList("Kendisinin Hollandalı olduğu duydu düşünülmektedir  7 yaşındayken ailesiyle birlikte Michigandaki Port Hurona yerleşti ve ",
            "ilköğrenimine burada başladı; fakat bir başladıktan yaklaşık 4 ay sonra duydu algılamasının yavaşlığı nedeniyle okuldan uzaklaştırıldı" ,
            "  Bu arada evlerinin burada kilerinde bir kimya laboratuvarı bir bir kurdu  Özellikle kimya deneylerine ve Volta kaplarından elektrik akımı elde etmeye yönelik araştırmalara " ,
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
            for(String text: texts){
                String INSERT_SQL="INSERT IGNORE INTO texts (text) VALUES ('"+text+"');";
                stmt.executeUpdate(INSERT_SQL);
            }

            //Database'den textleri çekip kelime kelime list'e atıyor.
            List<String> words = new ArrayList<>();
            ResultSet results = stmt.executeQuery("SELECT * FROM texts;");
            while(results.next()){
                words.addAll(Arrays.asList(results.getString("text").split("[ ]+")));
            }

            //Kelimeleri tekrar sayısılarıyla hashmap'e kaydediyor.
            HashMap<String,Integer> wordMap = new HashMap<>();
            for(String word: words){

                if(wordMap.containsKey(word)){
                    wordMap.put(word,wordMap.get(word)+1);
                }else
                    wordMap.put(word,1);
            }



            String CREATE_WORDS_TABLE_SQL = " CREATE TABLE words (word VARCHAR(100) NOT NULL UNIQUE,frequence INT);";
            //stmt.executeUpdate(CREATE_WORDS_TABLE_SQL);

            //Kelimeleri sıklıklarıyla birlikte words tablosuna kaydediyor.
            for(Map.Entry<String,Integer> entry:wordMap.entrySet()){
                String INSERT_SQL="INSERT IGNORE INTO words (word,frequence) VALUES ('"+entry.getKey()+"', "+entry.getValue()+" );";
                stmt.executeUpdate(INSERT_SQL);
            }

            printMap(wordMap);
            System.out.println("----------------------------------------------------------");
             results = stmt.executeQuery("SELECT * FROM words ORDER BY word ASC;");
            while(results.next()){
                System.out.println(results.getString("word") + ": " + results.getInt("frequence"));
            }


            System.out.println("----------------------------------------------------------");
            results = stmt.executeQuery("SELECT * FROM words ORDER BY frequence ASC;");
            while(results.next()){
                System.out.println(results.getString("word") + ": " + results.getInt("frequence"));
            }

            con.commit();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    static void printMap(HashMap<String,Integer> wordMap){
        for(Map.Entry<String,Integer> entry:wordMap.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }




}
