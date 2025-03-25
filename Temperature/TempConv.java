package Temperature;
import java.util.Scanner;


public class TempConv {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.println("Enter in the first temperature: ");
int fNum1 = sc.nextInt();

System.out.println("Label using a number for the type of temperature Celsius, Fahrenheit, Kelvin:" );
String tempCon1 = sc.next().toUpperCase();
Temperatures.Temps fEnum1 = Temperatures.Temps.valueOf(tempCon1);


System.out.println("Enter in what you want to convert to using a number as above: ");
String tempCon2 = sc.next().toUpperCase();
Temperatures.Temps fEnum2 = Temperatures.Temps.valueOf(tempCon2);

Conversion(fNum1, fEnum1, fEnum2);


sc.close();

}
    public static void Conversion(int temps, Temperatures.Temps t1, Temperatures.Temps t2){

        if(t1 == Temperatures.Temps.CELSIUS && t2 == Temperatures.Temps.CELSIUS || t1 == Temperatures.Temps.FAHRENHEIT && t2 == Temperatures.Temps.FAHRENHEIT || t1 == Temperatures.Temps.KELVIN && t2 == Temperatures.Temps.KELVIN){
            System.out.println("You are doing the same conversion");
        }
        else if (t1 == Temperatures.Temps.CELSIUS && t2 == Temperatures.Temps.FAHRENHEIT){
            temps = (int) (temps * (1.8) + 32);   
            System.out.println("Conversion from Celsius to Fahrenheit is: " + temps);
        } else if(t1 == Temperatures.Temps.CELSIUS && t2 == Temperatures.Temps.KELVIN){
            temps = (int) (temps + 273.15);
            System.out.println("Conversion from Celsius to Kelvin: " + temps);
        } else if(t1 == Temperatures.Temps.FAHRENHEIT && t2 == Temperatures.Temps.CELSIUS){
            temps = (int) ((temps - 32) * 0.55);
            System.out.println("Conversion from Fahrenheit to Celsius: " + temps);
        } else if(t1 == Temperatures.Temps.FAHRENHEIT && t2 == Temperatures.Temps.KELVIN){
            temps = (int) ((temps - 32) * (0.55) + 273.15);
            System.out.println("Conversion from Fahrenheit to Kelvin: " + temps);
        } else if(t1 == Temperatures.Temps.KELVIN && t2 == Temperatures.Temps.CELSIUS) {
            temps = (int) (temps - 273.15);
            System.out.println("Conversion from Kelvin to Celsius: " + temps);
        } else if(t1 == Temperatures.Temps.KELVIN && t2 == Temperatures.Temps.FAHRENHEIT){
            temps = (int) ((temps - 273.15) * 1.8 + 32);
            System.out.println("Conversion from Kelvin to Fahrenheit: " + temps);
        } else {
            System.out.println("An error has occurred");
        }
    }
}
