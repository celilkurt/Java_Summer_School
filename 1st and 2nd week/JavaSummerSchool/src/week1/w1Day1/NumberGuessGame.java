package week1.w1Day1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args){

        Random random = new Random();
        int number = random.nextInt(100);
        Scanner sc = new Scanner(System.in);
        int guess;
        boolean key = false;

        System.out.println("//Number: " + number);


        int meter = 0;
        while(meter++ < 5){

            System.out.print(meter + ". guess: ");
            guess = sc.nextInt();

            if(guess == number){
                key = true;
                System.out.println("You win.");
                break;
            }else if( guess < number){
                System.out.println("Try bigger");
            }else if( guess > number){
                System.out.println("Try smaller");
            }
        }

        if(!key)
            System.out.println("You lose. Number is " + number);


    }


}
