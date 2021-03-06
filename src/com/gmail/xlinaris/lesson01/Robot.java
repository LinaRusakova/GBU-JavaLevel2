package com.gmail.xlinaris.lesson01;

public class Robot implements Competitor {
    private static final String type = "Robot";
    private String name;
    private static int maxRun;// = 1000;
    private static int maxJump;// = 1;
    private static boolean next=true;

    public boolean isNext() {
        return this.next;
    }

    public void setNext(boolean next) {
        Robot.next = next;
    }


    public Robot(String modelName) {
        this.name = modelName;
    }

    public Robot(String modelName, int maxRun, int maxJump) {
        this.name = modelName;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
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
