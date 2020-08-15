package week1.w1Day1;

import java.util.Scanner;

public class ReverseOfArray {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers");
        String[] strNumbers = sc.nextLine().split("[ ]+");
        int[] numbers = new int[strNumbers.length];

        for(int i = 0; i < strNumbers.length; i++)
            numbers[i] = Integer.valueOf(strNumbers[i]);

        print(numbers);

        for(int i = 0; i < numbers.length/2; i++){
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length-(i+1)];
            numbers[numbers.length-(i+1)] = temp;
        }

        print(numbers);


    }

    static void print(int[] arr){
        System.out.print("\nArray: ");
        for(int num: arr)
            System.out.print(num + " ");
    }

}
