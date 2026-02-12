package com.dorri.week1.page132;

public class MyLogger extends BaseLog {
    @Override
    protected void log(String message, String level, String date) {
        System.out.printf("[%s] %s: %s%n", date, level, message);
    }
}
