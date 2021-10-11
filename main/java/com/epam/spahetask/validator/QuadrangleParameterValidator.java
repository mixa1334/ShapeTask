package com.epam.spahetask.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class QuadrangleParameterValidator {
    final static Logger logger = LogManager.getLogger();
    public final static String PARAMETERS_REGEX = "\\s*(-?\\d{1,5},-?\\d{1,5}\\s+){3}-?\\d{1,5},-?\\d{1,5}\\s*";

    public static boolean isValid(String parameters) {
        if (parameters == null) {
            logger.log(Level.DEBUG, "parameter is null");
            return false;
        }
        boolean result = parameters.matches(PARAMETERS_REGEX);
        logger.log(Level.DEBUG, "Parameters - \"" + parameters + "\" isValid - " + result);
        return result;
    }
}
