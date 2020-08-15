package week1.w1Day1;

import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfGrades {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        int grade = 0;

        while(true){
            System.out.print("Grade: ");
            grade = sc.nextInt();

            if(grade == 101)
                break;
            else if(grade < 0)
                System.out.println("Wrong input!");
            else
                grades.add(grade);

        }

        int total = grades.stream().mapToInt(tempGrade -> tempGrade).sum();
        System.out.println("Average of "+ grades.size() +" grades: " + total/grades.size());

    }
}
