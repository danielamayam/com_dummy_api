package com.dummy.api.utils.utilidades;

import java.util.Random;

public class GenerarId {
    private static Random random = new Random();

    public static int getRandomNumber() {
        int number = random.nextInt(24 - 1);
        return number;
    }
}
