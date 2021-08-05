package week1.w1Day1;

import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfGrades {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        
        int grade = takeGrade();

        while(grade != 101){

            if(grade < 0)
                System.out.println("Wrong input!");
            else
                grades.add(grade);

            grade = takeGrade();
        }

        int sumOfGrades = grades.stream().mapToInt(tempGrade -> tempGrade).sum();
        float gradesAverage = sumOfGrades/grades.size();
        
        System.out.println("Average of "+ grades.size() +" grades: " + gradesAverage);

    }
    
    public static int takeGrade(Scanner sc) {
     
        System.out.print("Grade: ");
        return sc.nextInt();
    }
}
