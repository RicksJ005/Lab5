import java.util.Scanner;

/**
 * Program Description
 * 1) Fill in steps
 * 
 * @author Name, optional email
 * @version v1.0
 * @since date
 */
public class Prime {
    public static void main(String[] args) {
        boolean isPrime;
        int number;
        String playAgain = "";

        do {
            System.out.print("Enter a whole number >2 (ie 19) to test if prime: ");
            Scanner keyboard = new Scanner(System.in);
            number = keyboard.nextInt();
            isPrime = testForPrime(number);

            if (isPrime == true) {
                System.out.println(number + " is prime");
            } else {
                System.out.println(number + " is not prime");
            }

            System.out.print("Enter yes to test another number, no to quit ");
            playAgain = keyboard.next();
        } while (playAgain.equalsIgnoreCase("yes"));


    }

    /** 
     * This will take an integer and test whether its prime using a for loop, and will output a boolean value
     * @param number the number to be tested if it is prime or not
     * @return the result of whether it is prime (true) or not (false)
     */
    public static boolean testForPrime(int number) {

        int inNumberSqRt = (int) Math.sqrt(number);
        boolean isPrimeMeth = true;


        for (int i = 2; isPrimeMeth && i <= inNumberSqRt; i++) {  //declare and set int var to 2  //Can start here vs 1 for one less run
            if ((number % i) == 0) {
                isPrimeMeth = false;
      
            }

        }
        return isPrimeMeth;//end testForPrime
    }

//end Prime
}