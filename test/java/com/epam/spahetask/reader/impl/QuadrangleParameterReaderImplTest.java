package com.epam.spahetask.reader.impl;

import com.epam.spahetask.exception.ShapeException;
import com.epam.spahetask.reader.QuadrangleParameterReader;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleParameterReaderImplTest {

    @Test
    public void testRead() throws ShapeException {
        QuadrangleParameterReader reader = new QuadrangleParameterReaderImpl();
        List<String> expected = List.of(" 1,-9   2,2    5,7  0,9", "-9 56 0 0","1,-92,2    5,7  0,9",
                                        "1 1 1 1 1 1 1 1 11", " 1,-9   2,s2    5,7  0,9", " _-_");
        List<String> actual = reader.read("src/test/resources/file/parameters_of_rectangles.txt");

        assertEquals(actual, expected);
    }
}