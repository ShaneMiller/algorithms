package algorithms.math;

/**
 * Chapter 31 Elementary number-theoretic notions - Introduction to Algorithms 2nd Edition.
 */
public class GreatestCommonDivisorAlgorithms {
    /**
     * Calculate the greatest common divisor of two numbers m and n iteratively using Euclid's algorithm
     * @param m non-negative number
     * @param n non-negative number
     * @return  the greatest common divisor of the two arguments
     */
    public long eculidGCDIterative(long m, long n) {
        while(n != 0) {
            long r = m % n;
            m = n;
            n = r;
        }
        return Math.abs(m);
    }

    /**
     * Calculate the greatest common divisor of two numbers m and n recursively using Euclid's algorithm
     * @param m non-negative number
     * @param n non-negative number
     * @return  the greatest common divisor of the two arguments
     */
    public long euclidGCDRecursive(long m, long n) {
        if (n == 0) {
            return Math.abs(m);
        } else {
            return euclidGCDRecursive(n, m % n);
        }
    }
}
