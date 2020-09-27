package com.gmail.xlinaris.lesson01;

public class Wall implements Barrier{
    private static final String type="jump";
    private static final String DESCRIPTION="\"Cтена\"";
    public int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override
    public String toString() {
        //System.out.println("Тип преграды: " + type + ".");
        return "\n Тип преграды: " + DESCRIPTION + ", высота стены: "+wallHeight + " cм.\n";
    }
    @Override
    public int isOvercome() {
        return wallHeight;
    }

    @Override
    public String typeMove() {
        return type;
    }
}
