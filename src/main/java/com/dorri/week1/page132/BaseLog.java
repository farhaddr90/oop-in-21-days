package com.dorri.week1.page132;

import java.text.DateFormat;
import java.util.Date;

public abstract class BaseLog {

    private static final String DEBUG = "DEBUG";
    private static final String INFO = "INFO";
    private static final String WARNING = "WARNING";
    private static final String ERROR = "ERROR";
    private static final String FATAL = "FATAL";
    private final DateFormat df = DateFormat.getDateTimeInstance();

    protected abstract void log(String message, String level, String date);

    protected String getDate() {
        return df.format(new Date());
    }

    public void debug(String message) {
        log(message, DEBUG, getDate());
    }

    public void info(String message) {
        log(message, INFO, getDate());
    }

    public void warning(String message) {
        log(message, WARNING, getDate());
    }

    public void error(String message) {
        log(message, ERROR, getDate());
    }

    public void fatal(String message) {
        log(message, FATAL, getDate());
    }
}
