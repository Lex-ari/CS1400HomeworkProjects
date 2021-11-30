package Homework5.LabExerciseNov16;

public class Pet {

    private String name;
    private int age;
    private boolean isHungry;

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public boolean isHungry(){
        return isHungry;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setHungry(boolean isHungry){
        this.isHungry = isHungry;
    }

    public void feed(){
        if(isHungry){
            System.out.println(name + " is now full!");
            isHungry = false;
        } else {
            System.out.println(name + " is not hungry!");
        }
    }

    public void move(){
        System.out.println(name + " runs across the room.");
    }
}
