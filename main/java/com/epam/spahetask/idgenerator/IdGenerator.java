package com.epam.spahetask.idgenerator;

public class IdGenerator {
    private static long id = 0L;

    private IdGenerator(){}

    public static long generateId() {
        return ++id;
    }
}
