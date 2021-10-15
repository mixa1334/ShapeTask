package com.epam.spahetask.validator.impl;

import com.epam.spahetask.validator.PolygonParameterValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class QuadrangleParameterValidator implements PolygonParameterValidator {
    final static Logger logger = LogManager.getLogger();
    private static QuadrangleParameterValidator instance = new QuadrangleParameterValidator();
    public final String PARAMETERS_REGEX = "\\s*(-?\\d{1,5},-?\\d{1,5}\\s+){3}-?\\d{1,5},-?\\d{1,5}\\s*";

    private QuadrangleParameterValidator() {
    }

    public static QuadrangleParameterValidator getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(String parameters) {
        if (parameters == null) {
            logger.log(Level.DEBUG, "parameter is null");
            return false;
        }
        boolean result = parameters.matches(PARAMETERS_REGEX);
        logger.log(Level.DEBUG, "Parameters - \"" + parameters + "\" isValid - " + result);
        return result;
    }
}
