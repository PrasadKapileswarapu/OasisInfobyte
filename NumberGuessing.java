import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

	public static void main(String[] args) {
	
		Random rm = new Random();
		Scanner sc = new Scanner(System.in);
		
		int guess;
		int attempts=0;
		int min=1;
		int max=10;
		int RandomNum = rm.nextInt((max - min) + 1) + min;
		
		System.out.println("Number Guessing Game!!");
		System.out.println("Guess a number between(1-10) ");
		
        do {
        	System.out.println("Enter a Guess: ");
        	guess=sc.nextInt();
        	 if (guess < min || guess > max) {
                 System.out.println("Invalid Guess! Please enter a number between (1-10).");
                 continue; 
        	}
          	attempts++;
        	if(guess<RandomNum) {
        		System.out.println("Too Low!! Try Again");
        	}
        	else if(guess>RandomNum) {
        		System.out.println("Too High!! Try Again");
        	}
        	else {
                System.out.println("CORRECT!! The number is: " + RandomNum);
                System.out.println("You Won!!");
                System.out.println("No. of Attempts: " + attempts);
        	}
        }while(guess!=RandomNum);
        
        sc.close();
	}

}
