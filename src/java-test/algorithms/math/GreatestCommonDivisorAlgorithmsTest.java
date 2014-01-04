package algorithms.math;

import junit.framework.Assert;
import org.junit.Test;

public class GreatestCommonDivisorAlgorithmsTest {

    private GreatestCommonDivisorAlgorithms gcdAlgorithms = new GreatestCommonDivisorAlgorithms();

    /*Test iterative Euclid GCD method*/
    @Test
    public void euclidGCDIterative_validNumbers_isSuccessful() throws Exception {
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(8, 12) == 4);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(60, 24) == 12);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(48, 2880) == 48);
    }

    @Test
    public void euclidGCDIterative_primeNumbers_isSuccessful() {
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(3, 19) == 1);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(37, 2) == 1);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(3, 1171) == 1);
    }

    @Test
    public void euclidGCDIterative_negativeNumbers_isSuccessful() {
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(-8, 12) == 4);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(60, -24) == 12);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(-48, -2880) == 48);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(-48, 0) == 48);
    }

    @Test
    public void euclidGCDIterative_usingZero_isSuccessful() {
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(0, 0) == 0);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(0, 12) == 12);
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(0, 2880) == 2880);
    }

    @Test
    public void euclidGCDIterative_communicativeProperty_isSuccessful() {
        /*The GCF is a commutative function: GCF(a, b) = GCF(b, a)*/
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(48, 2880) == gcdAlgorithms.eculidGCDIterative(2880, 48));
    }

    @Test
    public void euclidGCDIterative_associativeProperty_isSuccessful() {
        /*The GCF is an associative function: GCF(a, GCF(b, c)) = GCF(GCF(a, b), c)*/
        Assert.assertTrue(gcdAlgorithms.eculidGCDIterative(8, gcdAlgorithms.eculidGCDIterative(60, 24)) == gcdAlgorithms.eculidGCDIterative(gcdAlgorithms.eculidGCDIterative(8, 60), 24));
    }

    /*Test recursive Euclid GCD method*/
    @Test
    public void euclidGCDRecursive_validNumbers_isSuccessful() throws Exception {
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(8, 12) == 4);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(60, 24) == 12);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(48, 2880) == 48);
    }

    @Test
    public void euclidGCDRecursive_primeNumbers_isSuccessful() {
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(3, 19) == 1);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(37, 2) == 1);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(3, 1171) == 1);
    }

    @Test
    public void euclidGCDRecursive_negativeNumbers_isSuccessful() {
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(-8, 12) == 4);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(60, -24) == 12);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(-48, -2880) == 48);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(-48, 0) == 48);
    }

    @Test
    public void euclidGCDRecursive_usingZero_isSuccessful() {
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(0, 0) == 0);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(0, 12) == 12);
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(0, 2880) == 2880);
    }

    @Test
    public void euclidGCDRecursive_communicativeProperty_isSuccessful() {
        /*The GCF is a commutative function: GCF(a, b) = GCF(b, a)*/
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(48, 2880) == gcdAlgorithms.euclidGCDRecursive(2880, 48));
    }

    @Test
    public void euclidGCDRecursive_associativeProperty_isSuccessful() {
        /*The GCF is an associative function: GCF(a, GCF(b, c)) = GCF(GCF(a, b), c)*/
        Assert.assertTrue(gcdAlgorithms.euclidGCDRecursive(8, gcdAlgorithms.euclidGCDRecursive(60, 24)) == gcdAlgorithms.euclidGCDRecursive(gcdAlgorithms.euclidGCDRecursive(8, 60), 24));
    }

}
