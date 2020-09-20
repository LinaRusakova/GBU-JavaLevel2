package com.gmail.xlinaris.lesson01;

public class Cat implements Competitor {
    private static final String type="Cat";
    private String name;
    private static int maxRun;//=500;
    private static int maxJump;//=2;
    private static boolean next=true;

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        Cat.next = next;
    }



    public Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun=maxRun;
        this.maxJump=maxJump;
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


    //Метод преодоления препятствий
    String yesOrNot = "";
    private int maxLimit;

    @Override
    public void isOvercome(int length, String type) {
        switch (type) {
            case ("run"):
                run(length);
                maxLimit = maxRun;
                break;
            case ("jump"):
                jump(length);
                maxLimit = maxJump;
                break;
        }
        System.out.println(this.type + ((length <= maxLimit) ? " преодолел преграду и может продолжать соревнование." : " не смог преодолеть эту преграду и выбывает из соревнования."));
        if (length > maxLimit) this.setNext(false); //если не преодолел препятстсвие, то выбыл!
    }

    //метод умения бегать
    public void run(int length) {
        System.out.println(type + " умеет бегать на дистанции до " + maxRun + " м.");
    }

    //метод умения прыгать
    public void jump(int length) {
        System.out.println(type + " умеет прыгать в высоту до " + maxJump + " cм.");
    }

    //вывод иноформации об участнике
    @Override
    public String toString() {
        return "Участник соревнования: " + type + " по имени " + name + ".";
    }
}
