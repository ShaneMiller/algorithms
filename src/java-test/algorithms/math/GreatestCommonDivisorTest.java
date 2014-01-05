package algorithms.math;

import junit.framework.Assert;
import org.junit.Test;

public class GreatestCommonDivisorTest {

    /*Test iterative Euclid GCD method*/
    @Test
    public void euclidGCDIterative_validNumbers_isSuccessful() throws Exception {
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(8, 12) == 4);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(60, 24) == 12);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(48, 2880) == 48);
    }

    @Test
    public void euclidGCDIterative_primeNumbers_isSuccessful() {
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(3, 19) == 1);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(37, 2) == 1);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(3, 1171) == 1);
    }

    @Test
    public void euclidGCDIterative_negativeNumbers_isSuccessful() {
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(-8, 12) == 4);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(60, -24) == 12);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(-48, -2880) == 48);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(-48, 0) == 48);
    }

    @Test
    public void euclidGCDIterative_usingZero_isSuccessful() {
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(0, 0) == 0);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(0, 12) == 12);
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(0, 2880) == 2880);
    }

    @Test
    public void euclidGCDIterative_communicativeProperty_isSuccessful() {
        /*The GCF is a commutative function: GCF(a, b) = GCF(b, a)*/
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(48, 2880) == GreatestCommonDivisor.eculidGCDIterative(2880, 48));
    }

    @Test
    public void euclidGCDIterative_associativeProperty_isSuccessful() {
        /*The GCF is an associative function: GCF(a, GCF(b, c)) = GCF(GCF(a, b), c)*/
        Assert.assertTrue(GreatestCommonDivisor.eculidGCDIterative(8, GreatestCommonDivisor.eculidGCDIterative(60, 24)) == GreatestCommonDivisor.eculidGCDIterative(GreatestCommonDivisor.eculidGCDIterative(8, 60), 24));
    }

    /*Test recursive Euclid GCD method*/
    @Test
    public void euclidGCDRecursive_validNumbers_isSuccessful() throws Exception {
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(8, 12) == 4);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(60, 24) == 12);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(48, 2880) == 48);
    }

    @Test
    public void euclidGCDRecursive_primeNumbers_isSuccessful() {
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(3, 19) == 1);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(37, 2) == 1);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(3, 1171) == 1);
    }

    @Test
    public void euclidGCDRecursive_negativeNumbers_isSuccessful() {
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(-8, 12) == 4);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(60, -24) == 12);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(-48, -2880) == 48);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(-48, 0) == 48);
    }

    @Test
    public void euclidGCDRecursive_usingZero_isSuccessful() {
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(0, 0) == 0);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(0, 12) == 12);
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(0, 2880) == 2880);
    }

    @Test
    public void euclidGCDRecursive_communicativeProperty_isSuccessful() {
        /*The GCF is a commutative function: GCF(a, b) = GCF(b, a)*/
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(48, 2880) == GreatestCommonDivisor.euclidGCDRecursive(2880, 48));
    }

    @Test
    public void euclidGCDRecursive_associativeProperty_isSuccessful() {
        /*The GCF is an associative function: GCF(a, GCF(b, c)) = GCF(GCF(a, b), c)*/
        Assert.assertTrue(GreatestCommonDivisor.euclidGCDRecursive(8, GreatestCommonDivisor.euclidGCDRecursive(60, 24)) == GreatestCommonDivisor.euclidGCDRecursive(GreatestCommonDivisor.euclidGCDRecursive(8, 60), 24));
    }

}
