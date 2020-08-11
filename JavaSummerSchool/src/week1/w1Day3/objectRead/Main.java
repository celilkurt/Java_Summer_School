package week1.w1Day3.objectRead;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        Student s1 = new Student(1,"ali","h",4);
        Student s2 = new Student(2,"ayşe","c",2);
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        try {
            FileOutputStream fos = new FileOutputStream("students.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(students);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("students.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            students = null;
            students = (ArrayList<Student>)ois.readObject();
            //System.out.println(ois.readObject().getClass());
            //students.add((Student)ois.readObject());
            //students.add((Student)ois.readObject());

            ois.close();
            fis.close();

            for(Student s: students)
                System.out.println(s.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
