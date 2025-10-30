//import Scanner for user input
import java.util.Scanner;

/**
* This program calculates the volume of a sphere.
*
* @author Dylan Mutabazi
* @version 1.0
* @since 2025-September-11
*/

final class Einstein {
    /**
    *@exception IllegalStateException
    *@see IllegalStateException
    */
    private Einstein() {
        throw new IllegalStateException("Utility class");
    }

    // Constant for speed of light
    public static final double SPEEDOFLIGHT = 2.998e8;
    /**
    * Entrypoint of the program.
    * @param args UNUSED.
    */
    public static void main(final String[] args) {
        // Get mass from user.
        System.out.println("Input your mass (kg): ");
        Scanner massScanner = new Scanner(System.in);
        String massString = massScanner.nextLine();

        try {
            // Converts mass into double.
            double massDouble = Double.parseDouble(massString);
            // If mass <= 0 prints error line.
            if (massDouble <= 0) {
                System.out.println("Mass cannot be <= 0");
            } else {
                // Else calculates energy in joules.
                double energy = massDouble * Math.pow(SPEEDOFLIGHT, 2);
                System.out.println("the amount of energy released = "
                + String.format("%.3e", energy) + " Joules");
            }
        } catch (Exception e) {
            // If conversion to double doesnt work prints error line.
            System.out.println("Invalid input, try again later.");
        }
    }
}
