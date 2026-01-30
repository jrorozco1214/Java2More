package ProgrammingLanguages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Point;
import java.security.SecureRandom;

public class MonteCarlo {

    public static class Coords{
        private double x;
        private double y;

        private double min = 0.0;
        private double max = 1.0;

        //Setting the size of the array for bytes in which the controsl the size of the seed
        byte[] seed = new byte[8];

        SecureRandom rand = new SecureRandom(seed); //uses SHA1PRNG

        //SecureRandom rand = new SecureRandom();

        public Coords(){
            x = rand.nextDouble(min, max);
            y = rand.nextDouble(min, max);
        }

        public String toString(){
            String x = String.valueOf(this.x);
            String y = String.valueOf(this.y);
            return x + " " + y + " ";
        }

        public double getCoordX(){
            return x;
        }
        public double getCoordY(){
            return y;
        }

        public int TotalNumberInsideCircle(ArrayList<Coords> n, int sample){
            int totalInside = 0;

            for(int i = 0; i < sample; i++){
                double xVlaue = n.get(i).getCoordX();
                double yValue = n.get(i).getCoordY();

                if(Math.pow(xVlaue,2) + Math.pow(yValue,2) <= 1){
                    totalInside++;
                }
                //System.out.println(xVlaue + " " + yValue);
            }
            return totalInside;
        }
    }
    public static void main(String[] args) {
        int sample = 100000;
        ArrayList<Coords> n = new ArrayList<>();

        Coords c = null;

        for(int i = 0; i < sample; i++){
            n.add(c = new Coords());
        }

        // for(Coords x: n){
        //     System.out.println(x.toString());
        // }

        double totalInside = c.TotalNumberInsideCircle(n, sample);

        closeToPI(totalInside, sample);
        //c.printSeed();
    }

    public static void closeToPI(double totalInside, double sample){
        System.out.printf("π = %f \n", 4 * totalInside / sample);
    }
    //if we look at the documentations there is not getSeed() there is getSeed(int) but all this does is generates new seed bytes fo rother RNG's
    //based on these results we can determine that we are not able to get the internal seed fo teh of SecureRandom due to it's encryption
    //the smaller the sampel
}
