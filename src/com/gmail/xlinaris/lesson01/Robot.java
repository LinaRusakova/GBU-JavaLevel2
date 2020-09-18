package com.gmail.xlinaris.lesson01;

public class Robot {
    public static final String type="robot";
    private String name;
    private static final int maxRun=1000;
    private static final int maxJump=0;

    public Robot(String modelName) {
        this.name = modelName;
    }

    public static String getType() {
        return type;
    }

    public String getModelName() {
        return name;
    }

    public void setModelName(String modelName) {
        this.name = modelName;
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
