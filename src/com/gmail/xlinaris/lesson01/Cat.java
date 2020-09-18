package com.gmail.xlinaris.lesson01;

public class Cat {
    public static final String type="cat";
    private String name;
    private static final int maxRun=500;
    private static final int maxJump=3;

    public Cat(String name) {
        this.name = name;
    }

    public static String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getMaxRun() {
        return maxRun;
    }

    public static int getMaxJump() {
        return maxJump;
    }

    void info() {
        System.out.println("-----------------");
        System.out.printf("Участник соревнования: %s. Имя: %s.%n", type, name);
    }
    void run(int lengthRun) {
        if (lengthRun<=maxRun) {
            System.out.printf("%s может пробежать дистанцию: %d. Предельная дистанция для %s - %d.%n", type, lengthRun, type, maxRun);
        }
    }
    void jump(int lengthJump) {
        if (lengthJump<=maxJump) {
            System.out.printf("%s может прыгнуть на высоту %d. Предельная высота для %s %d%n", type, lengthJump,type, maxJump);
        }
    }
}
