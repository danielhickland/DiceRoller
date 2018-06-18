package DiceRoller;

import java.util.Scanner;

public class DiceInputValidation {

	public static int Validation(Scanner sc) {
/**This will simply confirm whether or not a user inputs an int.  If true, the users input will be returned.  
		 * If not, the user will be asked to input their data again.  
		 */
		int Userint = -1;

		while (!sc.hasNextInt()) {
			System.out.println("You did not give me an int, idiot.  Try again");
			sc.nextLine();
		}

		Userint = sc.nextInt();
		return Userint;

	}
}
