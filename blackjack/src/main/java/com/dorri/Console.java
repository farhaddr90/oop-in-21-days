package com.dorri;

import java.util.Scanner;

public class Console implements PlayerListener {

    public static final Console INSTANCE = new Console();
    private final Scanner scanner;

    private Console() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void handChanged(Player player) {
        System.out.println(player);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void close() {
        this.scanner.close();
    }
}
