// Imports.
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
* This program calculates the volume of a sphere.
*
* @author Dylan Mutabazi
* @version 1.0
* @since 2025-September-11
*/

final class ArithmeticExpressions {
    /**
    *@exception IllegalStateException
    *@see IllegalStateException
    */
    private ArithmeticExpressions() {
        throw new IllegalStateException("Utility class");
    }
    /**
    * Entrypoint of the program.
    * @param args
    */


    public static String expression(String[] arr) {
        // Tries to convert index 0 and 2 into float.
        try {
            float var1 = Float.parseFloat(arr[0]);

            try {
                float var2 = Float.parseFloat(arr[2]);
                // Holds the operator in index 1 as a string.
                String operator = arr[1];
                float result = 0;

                // Checks if operator is +, -, %, *, /, or ^.
                if (operator.equals("+")) {
                    result = var1 + var2;
                } else if (operator.equals("-")) {
                    result = var1 - var2;

                // If operator is / then checks if var_2 is 0.
                } else if (operator.equals("/")) {
                    // If so then says cant divide by 0.
                    if (var2 == 0) {
                        return "Cant divide by zero";
                    } else {
                        result = var1 / var2;
                    }
                } else if (operator.equals("*")) {
                    result = var1 * var2;
                } else if (operator.equals("^")) {
                    result = (float) Math.pow(var1, var2);
                } else if (operator.equals("%")) {
                    result = var1 % var2;
                } else {
                    /*
                     * If operator was not one of the ones listed
                     * then prints that its invalid
                     */
                    return operator + " is not a valid operator";
                }

                // Returns the result to main.
                return arr[0] + " " + operator + " " + arr[2] + " = " + result;

                // Catches any exception for var_1 and 2.
            } catch (NumberFormatException e) {
                return arr[2] + " is not a numeric number";
            }

        } catch (NumberFormatException e) {
            return arr[0] + " is not a numeric number";
        }
    }

    public static void main(final String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try {
            Scanner sc = new Scanner(inputFile);
            FileWriter out = new FileWriter(outputFile);

            // Checks if file has next line.
            while (sc.hasNextLine()) {

                // Reads next line
                String str = sc.nextLine();

                // Split each string by space.
                String[] arr = str.split(" ");

                // Calls for function expression.
                String result = expression(arr);
                out.write(result + "\n");
                System.out.println(result);
            }

            // closes the input and output files.
            sc.close();
            out.close();

            // Catches any file I/O and missing files errors.
        } catch (FileNotFoundException err) {
            System.out.println("Input file is not found");
        } catch (IOException e) {
            System.out.println("Error with writing to the output file.");
        }
    }
}

