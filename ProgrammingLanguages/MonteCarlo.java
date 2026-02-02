package ProgrammingLanguages;

import java.util.ArrayList;
import java.security.SecureRandom;

public class MonteCarlo {

    public static class Coords{
        private double x;
        private double y;

        private double min = 0.0;
        private double max = 1.0;


        public Coords(SecureRandom rand){
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
            }
            System.out.println("The total numbers inside the circle: " + totalInside);
            return totalInside;
        }
    }
    public static void main(String[] args) {
        int sample = 100;
        ArrayList<Coords> n = new ArrayList<>();

        SecureRandom rand = new SecureRandom();
        int seed = 101; //setting the seed
        rand.setSeed(seed);

        Coords c = null;

        for(int i = 0; i < sample; i++){
            n.add(c = new Coords(rand));
        }
        
        double totalInside = c.TotalNumberInsideCircle(n, sample);

        closeToPI(totalInside, sample, seed);
    }

    public static void closeToPI(double totalInside, double sample, int seed){
        System.out.printf("Language: Java PRNG Type: SecureRandom Seed: %d N: %d ", seed, (int)sample);
        System.out.printf("π = %.2f \n", (4 * totalInside) / sample);
    }
}
