package com.epam.spahetask.util.idgenerator;

public class IdGenerator {
    private static long id = 0L;

    private IdGenerator(){}

    public static long generateId() {
        return ++id;
    }
}
