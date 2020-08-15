package week1.w1Day1;

import java.util.Scanner;

public class YoungOrOld {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();


        if(age < 0){
            System.out.println("Wrong input.");
        }else if(age  <= 30){
            System.out.println("You're young");
        }else if(age > 30){
            System.out.println("You're old.");
        }
    }
}
