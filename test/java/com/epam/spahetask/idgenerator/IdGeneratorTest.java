package com.epam.spahetask.idgenerator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdGeneratorTest {

    @Test
    public void testGenerateId() {
        long[] expected = {1, 2, 3, 4};
        long[] actual = {IdGenerator.generateId(), IdGenerator.generateId(),
                         IdGenerator.generateId(), IdGenerator.generateId()};

        assertEquals(actual, expected);
    }
}