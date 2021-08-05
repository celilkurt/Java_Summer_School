package week1.w1Day1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args){

        Random random = new Random();
        int number = random.nextInt(100);
        Scanner sc = new Scanner(System.in);
        int guess;

        System.out.println("//Number: " + number);


        for (int i = 0; i < 5; i++){

            System.out.print((i+1) + ". guess: ");
            guess = sc.nextInt();

            if(guess == number){
                System.out.println("You win.");
                return;
            }else if( guess < number){
                System.out.println("Try bigger");
            }else if( guess > number){
                System.out.println("Try smaller");
            }
        }

        System.out.println("You lose. Number is " + number);


    }


}
