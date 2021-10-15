package com.epam.spahetask.validator.impl;

import com.epam.spahetask.validator.QuadrangleParameterValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class QuadrangleParameterValidatorImpl implements QuadrangleParameterValidator {
    final static Logger logger = LogManager.getLogger();
    private static QuadrangleParameterValidatorImpl instance = new QuadrangleParameterValidatorImpl();
    public final String PARAMETERS_REGEX = "\\s*(-?\\d{1,5},-?\\d{1,5}\\s+){3}-?\\d{1,5},-?\\d{1,5}\\s*";

    private QuadrangleParameterValidatorImpl() {
    }

    public static QuadrangleParameterValidatorImpl getInstance() {
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
