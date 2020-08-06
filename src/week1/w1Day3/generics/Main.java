package week1.w1Day3.generics;

public class Main {

    static String text = "Kendisinin Hollandalı olduğu düşünülmektedir  7 yaşındayken ailesiyle birlikte Michigan'daki Port Huron'a yerleşti ve ilköğrenimine burada başladı; fakat başladıktan yaklaşık 4 ay sonra algılamasının yavaşlığı nedeniyle okuldan uzaklaştırıldı  Bu arada evlerinin kilerinde bir kimya laboratuvarı kurdu  Özellikle kimya deneylerine ve Volta kaplarından elektrik akımı elde etmeye yönelik araştırmalara ilgi duydu  Bir süre sonra kendi başına bir telgraf aleti yaptı ve Mors alfabesini öğrendi  O günlerde geçirdiği ağır bir hastalık sonucu kulakları zor işitmeye başladı.[kaynak belirtilmeli  12 yaşındayken bir trende dergi ve meyve satıyor, bir yandan da trenin yük vagonunu yerleştirdiği küçük bir baskı makinesi ile haftalık bir gazete basıyordu ";

    public static void main(String[] args){

        MyMap<String,Integer> frequencies = new MyMap<>();

        String[] words = text.split("[ ]+");

        for(String word: words){

            if(frequencies.hasKey(word))
                frequencies.add(word,frequencies.get(word)+1);
            else
                frequencies.add(word,1);

        }

        for(String key: frequencies.keySet())
            System.out.println("Frequency of " + key + ": " + frequencies.get(key));

    }
}
