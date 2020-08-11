package week1.w1Day3;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args){

        sort();

    }

    static void sort(){
        List<Integer> list = Arrays.asList(20,1, 2, 3, 4, 5, 1, 2, 3, 12);
        System.out.println(list.toString());
        list.sort(Integer::compareTo);
        System.out.println(list.toString());
    }



}

