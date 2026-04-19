package com.dorri;

public class Console implements PlayerListener{

    public static final Console INSTANCE = new Console();

    @Override
    public void handChanged(Player player) {
        System.out.println(player);
    }
}
