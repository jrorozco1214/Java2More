package FinalsPractice.PersonTest;

import java.util.Comparator;

public class Employee extends Person implements Comparable<Employee>{

    private int yearsW;

    public Employee(String name, int age, int yearsW){
        super(name, age);
        this.yearsW = yearsW;
    }

    public int getYearsW() {
        return yearsW;
    }

    public void setYearsW(int yearsW) {
        this.yearsW = yearsW;
    }

    @Override
    public int compareTo(Employee o) {
        int result = Integer.compare(this.yearsW, o.yearsW);

        if(result == 0){
            return Integer.compare(super.getAge(), o.getAge());
        }

        return result;
    }

    public String toString(){
        return super.toString() + yearsW;
    }   
    
}

interface Flyable {
    void fly();
}

class Vehicle {
    public void start() {
        System.out.println("Vehicle starts");
    }
}

class Airplane extends Vehicle implements Flyable {
    public void takeOff() {
        System.out.println("Airplane takes off");
    }

    public void fly() {
        System.out.println("Airplane flies");
    }
}

class Jet extends Airplane {
    public void boost() {
        System.out.println("Jet boosts speed");
    }
}