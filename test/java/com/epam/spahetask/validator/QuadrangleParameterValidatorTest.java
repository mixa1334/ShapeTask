package com.epam.spahetask.validator;

import com.epam.spahetask.validator.impl.QuadrangleParameterValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleParameterValidatorTest {
    QuadrangleParameterValidator validator;

    @BeforeClass
    public void setUp() {
        validator = QuadrangleParameterValidator.getInstance();
    }

    @Test
    public void testIsValidPositiveOutcome() {
        String input = "2,5 -5,3 6,5 -7,3";
        boolean actual = validator.isValid(input);

        assertTrue(actual);
    }

    @Test
    public void testIsValidPositiveOutcomeMoreSpaces() {
        String input = "  2,5  599,3   6,5       7,3 ";
        boolean actual = validator.isValid(input);

        assertTrue(actual);
    }

    @Test
    public void testIsValidNegativeOutcomeInvalidData() {
        String input = "2,--5 5,3 6,5 7,3";
        boolean actual = validator.isValid(input);

        assertFalse(actual);
    }

    @Test
    public void testIsValidNegativeOutcomeNotAllData() {
        String input = "0, 0 111 f";
        boolean actual = validator.isValid(input);

        assertFalse(actual);
    }
}