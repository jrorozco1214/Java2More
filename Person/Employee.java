package Person;

import java.util.ArrayList;

public class Employee extends Person{
    private String occupation;

    public Employee(String name, int age, String occupation){
        super(name, age);
        this.occupation = occupation;
    }


    public String toString(){
        return super.toString() + this.occupation;
    }

    public ArrayList<Employee> changeAge(ArrayList<Employee> eList){
        ArrayList<Employee> copy = new ArrayList<>();


        for(int i = 0; i < eList.size(); i++){
            copy.add("fd");
        }
        return copy;
    }

}
