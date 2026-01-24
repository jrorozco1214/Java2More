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

        //the seed
        SecureRandom rand = new SecureRandom(); //uses SHA1PRNG
        byte[] seed = rand.generateSeed(50);

        public Coords(){
            x = rand.nextDouble(min, max);
            y = rand.nextDouble(min, max);
        }

        public String toString(){
            String x = String.valueOf(this.x);
            String y = String.valueOf(this.y);
            return x + " " + y + " " + seed;
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

                if(Math.sqrt(Math.pow(xVlaue,2) + Math.pow(yValue,2)) < 1){
                    totalInside++;
                }
                //System.out.println(xVlaue + " " + yValue);
            }
            return totalInside;
        }
    }
    public static void main(String[] args) {
        int sample = 1000;
        ArrayList<Coords> n = new ArrayList<>();

        Coords c = null;

        for(int i = 0; i < sample; i++){
            n.add(c = new Coords());
        }

        for(Coords x: n){
            System.out.println(x.toString());
        }

        double totalInside = c.TotalNumberInsideCircle(n, sample);

        closeToPI(totalInside, sample);
    }

    public static void closeToPI(double totalInside, double sample){
        System.out.printf("π = %f", 4 * totalInside / sample);
    }
}
