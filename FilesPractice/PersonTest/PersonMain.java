package FilesPractice.PersonTest;

import java.util.ArrayList;
import java.util.Collections;

public class PersonMain {
    public static void main(String[] args) {
    ArrayList<Employee> e = new ArrayList<>();
    e.add(new Employee("Jeremy", 45, 4));
    e.add(new Employee("Michelle", 45, 10));
    e.add(new Employee("Lauren", 35, 10));
    
    Collections.sort(e, new PersonCompare());

    for(Employee es: e){
        System.out.println(es.toString());
    }
    }
    
}
