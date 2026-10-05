import java.util.Scanner;


/**
 * Program Description
 * 1) Fill in steps
 * 
 * @author Name, optional email
 * @version v1.0
 * @since date
 */

public class FallingDistance{
    public static final double ACCELERATION = 9.8;  
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double distance;
        int numOfSecs;
        
        System.out.print("Please enter how many seconds to compute: ");
        numOfSecs = keyboard.nextInt();
        System.out.println("Time(secs) Distance(m)");
        System.out.println("========== ===========");
        for(int i = 1; i<=numOfSecs; ++i) {
            distance = getDistance(i);
            System.out.printf("%d\t\t%.1f%n", i, distance);
        }

    } 
    /**
     * This will calculate the distance per second.
     * @param numOfSecs the number of seconds to be used in calculating distance
     * @return The result in meters of multiplying the number of seconds by itself times acceleration times one half
     */
    public static double getDistance(int numOfSecs) {
        double distance;
        distance = 0.5* ACCELERATION * (numOfSecs * numOfSecs);
        return distance;
    }

}