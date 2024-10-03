package com.incubyte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
     @Test
    public void testEmptyString() {
        assertEquals(0, Calculator.addTheNumbers(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, Calculator.addTheNumbers("1"));
        
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(6, Calculator.addTheNumbers("1,5"));
    }

  
    @Test
    public void testNewLineDelimiter() {
        assertEquals(6, Calculator.addTheNumbers("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiter() {
        assertEquals(3, Calculator.addTheNumbers("//;\n1;2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumber() {
        Calculator.addTheNumbers("1,-2,3");
    }

    @Test
    public void testMultipleNegativeNumbers() {
        try {
            Calculator.addTheNumbers("1,-2,-3");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: [-2, -3]", e.getMessage());
        }
    }
}
