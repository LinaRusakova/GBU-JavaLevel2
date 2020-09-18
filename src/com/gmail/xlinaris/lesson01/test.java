package com.gmail.xlinaris.lesson01;

public class test {
    public static void main(String[] args) {
        Human human=new Human("Sapiens");
        human.info();
        human.run(200);
        human.jump(3);

        Cat cat=new Cat("Barsik");
        cat.info();
        cat.run(200);
        cat.jump(3);

        Robot robot=new Robot("SmartBot2000");
        robot.info();
        robot.run(200);
        robot.jump(3);


    }
}
