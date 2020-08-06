package week1.w1Day3.occurrencesOfWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static String text = "Kendisinin Hollandalı olduğu düşünülmektedir  7 yaşındayken ailesiyle birlikte Michigan'daki Port Huron'a yerleşti ve ilköğrenimine burada başladı; fakat başladıktan yaklaşık 4 ay sonra algılamasının yavaşlığı nedeniyle okuldan uzaklaştırıldı  Bu arada evlerinin kilerinde bir kimya laboratuvarı kurdu  Özellikle kimya deneylerine ve Volta kaplarından elektrik akımı elde etmeye yönelik araştırmalara ilgi duydu  Bir süre sonra kendi başına bir telgraf aleti yaptı ve Mors alfabesini öğrendi  O günlerde geçirdiği ağır bir hastalık sonucu kulakları zor işitmeye başladı.[kaynak belirtilmeli  12 yaşındayken bir trende dergi ve meyve satıyor, bir yandan da trenin yük vagonunu yerleştirdiği küçük bir baskı makinesi ile haftalık bir gazete basıyordu ";


    public static void main(String[] args){

        String words[] = text.split("[ ]+");



        List<Word> list = createListWithFrequency(words);
        printList(list);
        System.out.println("-------------------------------");
        list.sort(Word::compareTo);
        printList(list);
        System.out.println("-------------------------------");
        list.sort(Word::compareToWithNumber);
        printList(list);


    }

    static void printList(List<Word> list){

        for(Word word: list)
            System.out.println(word.toString());
    }

    static List<Word> createListWithFrequency(String[] words){

        List<Word> list = new ArrayList<>();

        for(String word: words){
            int index = findWord(list,word);
            if(index != -1)
                list.get(index).increaseNum();
            else
                list.add(new Word(word,1));

        }
        return list;
    }

    static int findWord(List<Word> words, String str){

        for(int i = 0; i < words.size(); i++)
            if(words.get(i).getWord().equals(str))
                return i;

        return -1;

    }


    static void printWords(String... words){

        for(String word: words)
            System.out.println(word);

    }



}

