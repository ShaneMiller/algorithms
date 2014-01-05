package algorithms.math;

/**
 * Chapter 3 Growth of Functions - Introduction to Algorithms 2nd Edition.
 */
public class Factorial {

    /**
     * Calculate the factorial of a number recursively
     * @param n non-negative number
     * @return  n!
     */
    public static long factorialRecurisve(long n) {
        if(n < 0) {
            throw new ArithmeticException("unable to calculate factorial of negative numbers");
        } else {
            return n <= 1 ? 1 : n * factorialRecurisve(n - 1);
        }
    }

    /**
     * Calculate the factorial of a number iteratively
     * @param n non-negative number
     * @return  n!
     */
    public static long factorialIterative(long n) {
        if(n < 0) {
            throw new ArithmeticException("unable to calculate factorial of negative numbers");
        }

        long factorial = 1;
        for(long i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
