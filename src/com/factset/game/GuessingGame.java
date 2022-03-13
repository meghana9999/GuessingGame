package com.factset.game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int originalNum = 0, guessedNum = 0;
		int noOfTries = 1;
		// int invalidCount = 0;
		String msg = "";
		originalNum = random.nextInt(10);
		if (originalNum == 0)
			originalNum++;
		// System.out.println("original value = " + originalNum);

		do {
			System.out.println("I am thinking a number from 1 to 10");
			System.out.println("You must guess what it is in three tries");
			System.out.print("Enter a guess : ");
			try {
				guessedNum = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Your input is invalid");
				break;
			}
			// displaying error message if user guessed number is in range or not
			if (guessedNum < 1 || guessedNum > 10) {
				System.err.println("You entered an invalid number.");
				break;
				// invalidCount++;
				// if (invalidCount == 3)
				// System.out.println("Sorry! You lost the game.");
			} else {
				msg = (originalNum - guessedNum >= 3) || (guessedNum - originalNum >= 3) ? "(cold)"
						: (originalNum - guessedNum == 2) || (guessedNum - originalNum == 2) ? "(warm)"
								: (originalNum - guessedNum == 1) || (guessedNum - originalNum == 1) ? "(hot)" : "";

				switch (noOfTries) {
				case 1:
					System.out.println("Your first guess is: " + guessedNum + msg);
					break;
				case 2:
					System.out.println("Your second guess is: " + guessedNum + msg);
					break;
				case 3:
					System.out.println("Your last guess is: " + guessedNum + msg);
					break;
				}

				if (guessedNum == originalNum) {
					System.out.println("Right! You have won the game.");
					break;
				}
				if (noOfTries == 3) {
					System.out.println("Sorry! You lost the game.");
					break;
				}
			}
			noOfTries++;
		} while (noOfTries < 4);

		scanner.close();
	}

}
