package week1.w1Day3.sort;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Student> students = Arrays.asList(new Student(1,"oli"),new Student(0,"kerim"));
        printStudents(students);
        students.sort(Student::compareTo);
        printStudents(students);

    }

    static void printStudents(List<Student> list){
        for(Student student:list)
            System.out.println(student.toString());
    }
}


class Student implements Comparable{

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(Object o){

        return this.name.compareTo(((Student)o).name);
    }
}