package DiceRoller;

import java.util.Scanner;
import java.util.Random;
import DiceRoller.DiceInputValidation;

public class DiceRoller {
/**This application will roll dice for a user and then calculate the number of successes. 
 * This application may also reroll certain results.
 * The User must set the number of dice thrown, and how many sides each die has.
 * The User must set what value or triggers a success.  
 * Successes will be counted as everything equal to or greater than this value
 * The user must choose whether or not they want to have results rerolled.
 * If the user chooses to have rerolls, they must choose what value will be rerolled.  This can only be an integer.
 * All integer inputs are validated in the DiceInputValidation Class
 * Yes/No Answers are validated by the YesNoValidation Class
 */
	public static void main(String[] args) {

		// variables
		try {
			int Success = 0;
			int Reroll = 0;
			int NumberOfDice;
			int DieFace;
			int SuccessTarget;
			boolean AllowReRoll = false;
			int RerollTarget = 0;
			int Critical = 0;
			int CriticalTarget;

			Scanner sc = new Scanner(System.in);
			Random roll = new Random();

			System.out.println("Please enter the number of dice you will throw.");

			NumberOfDice = DiceInputValidation.Validation(sc);

			System.out.println("How many faces do these dice have?");

			DieFace = DiceInputValidation.Validation(sc);

			System.out.println("What is the success target for this roll?");

			SuccessTarget = DiceInputValidation.Validation(sc);

			System.out.println("What roll scores a critical?");
			CriticalTarget = DiceInputValidation.Validation(sc);

			int code = -1;

			do {
				System.out.println("Are there Reroll conditions?");
				String response = sc.next();
				sc.nextLine();

				// call validation here
				code = YesNoValidation.YesOrNo(response);
				if (code == 0) {
					AllowReRoll = true;

				} else if (code == 1) {
					AllowReRoll = false;

				} else {
					System.out.println("Sorry again");
				}
			} while (code == -1);
			
			//Code is impolite

			if (AllowReRoll == true) {
				System.out.println("On what number would you like to ReRoll?");
				RerollTarget = DiceInputValidation.Validation(sc);
			}

			int results[] = new int[NumberOfDice];

			for (int i = 0; i < NumberOfDice; i++) {
				results[i] = (roll.nextInt(DieFace - 1) + 1);
			}

			for (int i = 0; i < NumberOfDice; i++) {

				if (results[i] >= SuccessTarget - 1) {
					Success++;
				}
				if (results[i] == CriticalTarget - 1) {
					Critical++;

				}
				if (AllowReRoll == true && results[i] == RerollTarget) {
					Reroll++;
				}

			}

			int RerollResults[] = new int[Reroll];
			for (int i = 0; i < Reroll; i++) {
				results[i] = (roll.nextInt(DieFace - 1) + 1);

			}
			for (int i = 0; i < Reroll; i++) {

				if (RerollResults[i] >= SuccessTarget - 1) {
					Success++;
				}
				if (RerollResults[i] == CriticalTarget - 1) {
					Critical++;
				}
			}

			System.out.println("There are " + Success + " Successes");
			System.out.println("There were " + Reroll + " Rerolls");
			System.out.println("There are " + Critical + " Critical Hits");

			sc.close();
		} catch (Exception exception) {
			System.out.println("Working As Intended");
		}
	}
}