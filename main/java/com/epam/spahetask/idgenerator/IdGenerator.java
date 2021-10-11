package com.epam.spahetask.idgenerator;

public class IdGenerator {
    private static long id = 0L;

    public static long generateId() {
        return ++id;
    }
}
