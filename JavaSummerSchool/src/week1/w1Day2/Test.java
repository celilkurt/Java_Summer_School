package week1.w1Day2;

public class Test {

    public static void main(String[] args){

        Animal dog = new Dog();
        dog.makeSound();

    }


}

class Animal{
    public void makeSound(){
        System.out.println("No sound");
    }
}

class Dog extends Animal{

    public void makeSound(){
        System.out.println("Dog sound");
    }
}