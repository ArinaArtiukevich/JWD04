package com.calculator;

import com.calculator.exception.CalculatorException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.calculator.Calculator.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Test
    public void testValidateInput() throws CalculatorException {
        Assert.assertTrue(validateOperation("+"));
        Assert.assertEquals(16, Calculator.countResult(4,2,"^"),0);
        Assert.assertEquals(0.0625, Calculator.countResult(-4,-2,"^"),0);

    }

    @Test(expected = CalculatorException.class)
    public void testValidateInputException() throws CalculatorException {
        validateOperation("exception");
        Assert.assertEquals(1, Calculator.countResult(1,1,"l"), 0);
        Assert.assertEquals(0, Calculator.countResult(1,0,"/"), 0);
    }
}
