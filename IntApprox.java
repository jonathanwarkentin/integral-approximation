import java.math.*;
import java.util.*;

public class IntApprox {

    public static double currentFunction(String function, double x) {
        // put function as definition of result
        // example function: 1/x
        double result = 1 / x;

        result = Math.round(result * 1000000.0) / 1000000.0;
        return result;
    }

    public static double trapezoidal(String function, double a, double b, double n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            double current = currentFunction(function, a + (i * ((b - a) / n)));
            if (i != 0 && i != n)
                current *= 2;
            sum += current;
        }
        return Math.round((sum * ((b - a) / (2 * n))) * 1000000.0) / 1000000.0;
    }

    public static double midpoint(String function, double a, double b, double n) {
        double sum = 0;
        double interval = (b - a) / n;
        for (int i = 0; i < n; i++) {
            double current = currentFunction(function, a + ((i * interval) + ((i + 1) * interval)) / 2);
            sum += current;
        }
        return Math.round((sum * interval) * 1000000.0) / 1000000.0;
    }

    public static double simpsons(String function, double a, double b, double n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            double current = currentFunction(function, a + (i * ((b - a) / n)));
            if (i != 0 && i != n && (i + 1) % 2 == 0)
                current *= 4;
            else if (i != 0 && i != n && i % 2 == 0)
                current *= 2;
            sum += current;
        }
        return Math.round((sum * ((b - a) / (3 * n))) * 1000000.0) / 1000000.0;
    }

    public static void printResult(String function, double a, double b, double n) {
        System.out.println("Integral approximations:");
        System.out.println("Trapezoidal: " + trapezoidal(function, a, b, n));
        System.out.println("Midpoint: " + midpoint(function, a, b, n));
        System.out.println("Simpson's: " + simpsons(function, a, b, n));
    }

    public static void main(String[] args) {
        boolean isOn = true;
        // String helpString = "This is the help string.";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Integral Approximator.");
        System.out.println(
                "Note: currently, function input must be done in this java file, which must be re-compiled before use.");
        System.out.println("We apologize for the inconvenience");
        // System.out.println("For help, type \"help\" when prompted for input.");
        System.out.println();

        while (isOn) {
            String function = "";
            // System.out.println("Please enter the function you would like to integrate.");
            // String function = keyboard.next();
            System.out.println("Please enter the lower bound.");
            double a = keyboard.nextDouble();
            System.out.println("Please enter the upper bound.");
            double b = keyboard.nextDouble();
            System.out.println("Please enter the n value.");
            double n = keyboard.nextDouble();

            printResult(function, a, b, n);

            System.out.println("Would you like to approximate another integral? (y/n)");
            String afterInput = keyboard.next();
            /*
             * if (afterInput.toLowerCase().equals("help")) {
             * System.out.println(helpString);
             * System.out.println("Would you like to approximate another integral? (y/n)");
             * afterInput = keyboard.next(); }
             */
            if (afterInput.toLowerCase().equals("n"))
                break;
        }

        System.out.println("Thanks for using the Integral Approximator.");
    }
}
