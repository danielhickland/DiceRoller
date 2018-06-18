/**
 * 
 */
package DiceRoller;



/**
 * @author User
 *
 */
public class YesNoValidation {

	/**
	 * @param H
	 * Purpose is to take a User's answer to a Yes or no question and return an int based on that answer. Default int is -1.
	 * 0 is returned for a yes
	 * 1 is returned for a no
	 * -1 is returned for any other answer
	 */
	public static int YesOrNo(String sc) {

		int userAnswer = -1;

		if (sc.equalsIgnoreCase("yes") || sc.equalsIgnoreCase("Y")) {
			userAnswer = 0;
			
		} else if (sc.equalsIgnoreCase("no") || sc.equalsIgnoreCase("n")) {
				userAnswer = 1; 
		} else {
			
			userAnswer=1;
		}

		return userAnswer;

	}

}
