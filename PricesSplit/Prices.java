package PricesSplit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prices {
    public static void main(String[] args) {
        double pTotal = 0.0;

        try{
            File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\PricesSplit\\Prices.txt");
            ArrayList<String> catsList = new ArrayList<>(); //have to create the arrayList in order to store the values from the array that you split
            ArrayList<Double> totalList = new ArrayList<>();


            Scanner sc = new Scanner(f1);
           

            while(sc.hasNext()){
                String line = sc.nextLine(); //you need to this in order to read the line!!!!!!!!!! IMPORTANT
                String []cats = line.split("[^A-Za-z]+"); //the split will make sure that it's put in the correct category
                String []total = line.split("[^0.0-9.0]+"); 


                for(String cat: cats)
                if(!cat.isEmpty()){ //will check to see whether teh string cat is not empty before adding it to the, you can sometimes end up with empty elements
                    catsList.add(cat);
                }

                for(String totals: total){
                    if(!totals.isEmpty()){
                        totalList.add(Double.parseDouble(totals));
                    }
                }
            }

            for(String p: catsList){
                System.out.println(p);
            }

            for(Double d: totalList){
                pTotal+= d;
            }

            System.out.println(pTotal);

        } catch(IOException e){
            e.getMessage();
        }
    }
}
