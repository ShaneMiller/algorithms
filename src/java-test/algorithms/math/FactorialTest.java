package algorithms.math;

import junit.framework.Assert;
import org.junit.Test;

public class FactorialTest {
    /*Test recursive factorial method*/
    @Test
    public void factorialRecursive_validNumbers_isSuccessful() throws Exception {
        Assert.assertEquals(Factorial.factorialRecurisve(0), 1);
        Assert.assertEquals(Factorial.factorialRecurisve(5), 120);
        Assert.assertEquals(Factorial.factorialRecurisve(6), 720);
        Assert.assertEquals(Factorial.factorialRecurisve(7), 5040);
    }

    @Test(expected = ArithmeticException.class)
    public void factorialRecursive_negativeNumbers_isFailure() throws Exception {
        Factorial.factorialRecurisve(-4);
    }

    /*Test iterative factorial method*/
    @Test
    public void factorialIterative_validNumbers_isSuccessful() throws Exception {
        Assert.assertEquals(Factorial.factorialRecurisve(0), 1);
        Assert.assertEquals(Factorial.factorialIterative(5), 120);
        Assert.assertEquals(Factorial.factorialIterative(6), 720);
        Assert.assertEquals(Factorial.factorialIterative(7), 5040);
    }

    @Test(expected = ArithmeticException.class)
    public void factorialIterative_negativeNumbers_isFailure() throws Exception {
        Factorial.factorialIterative(-4);
    }
}
