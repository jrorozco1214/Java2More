package PetPractice;

import java.util.ArrayList;

public class PetMain {
    public static void main(String[] args) {
        ArrayList <Dog> dList = new ArrayList<>();

        dList.add(new Dog("Teddy", 9, 25));

        dList.get(0).ageChange(20);

        Food d2 = new Dog("Chanel", 5, 30);

        ((Dog)d2).feedMe();
        
        System.out.println(dList.get(0).toString());

        for(Dog d: dList){
            if(d instanceof Food){
                System.out.println(d);
            }
        }
    }
    
}
