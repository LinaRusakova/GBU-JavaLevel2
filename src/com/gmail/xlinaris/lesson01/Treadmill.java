package com.gmail.xlinaris.lesson01;

public class Treadmill implements Barrier {
    private static final String type = "run";
    private static final String DESCRIPTION = "\"Беговая дорожка\"";
    private static int maxLength;

    public Treadmill(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {
        //System.out.println("Тип преграды: " + type + ".");
        return "\n Тип преграды: " + DESCRIPTION + ", дистанция забега: " + maxLength + " м.\n";
    }

    @Override
    public int isOvercome() {
        return maxLength;
    }

    @Override
    public String typeMove() {
        return type;
    }
}
