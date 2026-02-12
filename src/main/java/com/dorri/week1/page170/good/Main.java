package com.dorri.week1.page170.good;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Day> days = List.of(
                new Sunday(),
                new Monday(),
                new Tuseday(),
                new Wednesday(),
                new Thursday(),
                new Friday(),
                new Saturday()
        );
        days.forEach(d -> System.out.println(d.getName()));
    }
}
