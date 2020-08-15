package week1.w1Day3.occurrencesOfWords;


public class Word implements Comparable{

    private String word;
    private int num;

    public Word(String word, int num) {
        this.word = word;
        this.num = num;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void increaseNum(){
        num += 1;
    }

    @Override
    public int compareTo(Object o) {
        return word.toLowerCase().compareTo(((Word)o).word.toLowerCase());
    }

    public int compareToWithNumber(Object o) {

        if(num == ((Word)o).num)
            return 0;
        else if(num < ((Word)o).num)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", num=" + num +
                '}';
    }
}