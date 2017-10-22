
/**
 * Program: Guessing Game File: GuessingGame.java Summary: Generates random
 * number between 1 and 10000, and provides interactive guessing to narrow down
 * the correct number. Author: Evan W Wilson Date: October 18, 2017
 *
 */
import java.util.Scanner;
//import scanner class from java.util package

public class GuessingGame {
    //being public class

    public static void main(String[] args) {
        // begin main method
        Scanner sc = new Scanner(System.in);

        int number = (int) (Math.random() * 10001);
        //declares int number and generates a random number between 1 and
        //10000, inclusive
        int numberOfTries = 0;
        //declare numberOfTries variable
        System.out.println("This is a guessing game, try to guess the correct "
                + "number in the least amount of tries.");
        System.out.println("Type 0 at any time to give up and reveal the number.");
        int guess = 0; //declare int variable
        int min = 1; //declare min variable
        int max = 10000; //declare max variable
        while (number != guess) { //creates loop until correct number is guessed
            System.out.print("Please guess a number between " + min + " and "
                    + max + ":  ");
            guess = sc.nextInt(); //prompts user for input of guess
            if (guess == 0) { //quits the program if user enters 0
                System.out.println("The correct number was " + number + ".");
                return;
            }
            while (guess < min || guess > max) {
                //prompts for new number if input is outside of range
                System.out.println("Number must be between " + min + " and "
                        + max + ":  ");
                System.out.print("Please guess a number between " + min + " and "
                        + max + ":  ");
                guess = sc.nextInt();
                if (guess == 0) { //quits the program if user enters 0 within loop
                    System.out.println("The correct number was " + number + ".");
                    return;
                }

                if (number == guess) { //if number was correct
                    numberOfTries++;
                    System.out.println("Congratulations, you guessed correctly "
                            + "after " + numberOfTries + " tries!");
                } else { //if number was incorrect
                    numberOfTries++;
                    if (guess < number) {
                        System.out.println("HIGHER!");
                        min = guess + 1;
                    } else {
                        System.out.println("LOWER!");
                        max = guess - 1;
                    }
                    System.out.println("Guess again. Number of tries:  "
                            + numberOfTries);
                }
            }
        }
    }
}
