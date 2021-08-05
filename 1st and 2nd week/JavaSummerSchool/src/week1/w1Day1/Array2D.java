package week1.w1Day1;

import java.util.Scanner;

public class Array2D {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Cities: ");
        int n = sc.nextInt();
        sc.nextLine();


        String[][] cities = new String[n][];
        
        for (int i = 0; i < n; i++) {
            cities[i] = sc.nextLine().split(" ");
        }

        for(String[] counties: cities){
            System.out.println("Counties: " + String.join(" ", counties));
        }
    }



}
