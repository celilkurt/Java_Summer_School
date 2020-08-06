package week1.w1Day3.objectRead;

import java.io.Serializable;

public class Student implements Serializable {

    transient private int id;
    private String name;
    private String className;
    private int classGrade;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", classGrade=" + classGrade +
                '}';
    }

    public Student(int id, String name, String className, int classGrade) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.classGrade = classGrade;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(int classGrade) {
        this.classGrade = classGrade;
    }
}
