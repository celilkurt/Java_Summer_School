package week1.w1Day1;

import java.util.Scanner;

public class Array2D {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Cities: ");
        int n = sc.nextInt();
        sc.nextLine();


        String[][] cities = new String[n][];
        int meter = 0;

        while(meter < n){
            cities[meter++] = sc.nextLine().split(" ");
        }

        for(String[] arr: cities){
            System.out.print("Counties: ");
            for(String city: arr)
                System.out.print(city + " ");

            System.out.println();
        }
    }



}
