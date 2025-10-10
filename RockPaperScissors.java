import java.util.Scanner;
import java.util.Random;

//Jeremy Orozco
//Assignment 1

public class RockPaperScissors {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        System.out.println("Welcome to Rock Paper Scissors");
        System.out.println("Please enter in 0 = Rock 1 = Paper or 2 = Scissors, you will play 5 rounds");
        System.out.println("If you would like to exit at anytime type 'exit' or 'quit' ");

        int tracker = 0;

        int rock = 0;
        int paper = 1;
        int scissors = 2;

        int wins = 0;
        int losses = 0;
        int ties = 0;

        while(tracker < 5){
            int randomInt = rn.nextInt(0,3);
            String input = sc.next();

            if(input.equals("exit") || input.equals("quit")){
                break;
            }

            int changed_to_integer = Integer.parseInt(input);

            if(changed_to_integer < 0 || changed_to_integer > 2){
                System.out.println("Please enter in 0, 1, or 2");
                continue;
            } else {
                 if(changed_to_integer == rock && randomInt == rock || changed_to_integer == paper && randomInt == paper || changed_to_integer == scissors && randomInt == scissors){
                    System.out.println("You have tied this round");
                    ties++;
                } else if(changed_to_integer == rock && randomInt == scissors || changed_to_integer == paper && randomInt == rock || changed_to_integer == scissors && randomInt == paper){
                    System.out.println("You have won this round");
                    wins++;
                } else if(randomInt == rock && changed_to_integer == scissors || randomInt == paper && changed_to_integer == rock || randomInt == scissors && changed_to_integer == paper){
                    System.out.println("You have lost this round");
                    losses++;
                }
                    System.out.printf("Wins: " + wins + "\n" + "Lost: " + losses + "\n" + "Ties: " + ties  + "\n");
                    tracker++;
                }
            }
            sc.close();
        }
    }
