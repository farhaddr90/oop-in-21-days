package com.dorri.week1.page381;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements PlayerListener{
    public static Console INSTANCE = new Console();

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private Console() {
    }

    @Override
    public void handChanged(Player player) {
        printMessage(player.toString());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String readInput(String defaultInput) {
        try{
            return in.readLine();
        }catch (IOException e){
            return defaultInput;
        }
    }
}
