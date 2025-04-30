package FinalsPractice.PersonTest;

import java.util.Comparator;

public class PersonCompare implements Comparator<Employee>{
@Override
    public int compare(Employee o1, Employee o2) {
        int result = Integer.compare(o1.getYearsW(), o2.getYearsW());

        if(result == 0){
            return Integer.compare(o1.getAge(), o2.getAge());
        }

        return result;
    }
}

    
