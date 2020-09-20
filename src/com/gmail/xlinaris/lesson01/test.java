package com.gmail.xlinaris.lesson01;

import java.io.OptionalDataException;
import java.util.Random;

public class test {

    public static void main(String[] args) {
        // создаем и иницализируем переменную массива участников соревнований
        Competitor[] competitors = creatingCompetitors();
        // создаем и иницализируем переменную массива преград на соревнованиях
        Barrier[] barriers = creatingBarriers();
        // запускаем соревнования
        playCompetition(competitors, barriers);

    }

    private static void playCompetition(Competitor[] competitors, Barrier[] barriers) {

        for (Barrier barrier : barriers) {
            System.out.println(barrier); //выводим тип преграды
            for (Competitor competitor : competitors) {
                if (competitor.isNext()) {
                    System.out.println(competitor); //выводим данные по каждому из участников
                    competitor.isOvercome(barrier.isOvercome(), barrier.typeMove());
                    System.out.println("------------------");
                }
            }
        }
    }

    private static Barrier[] creatingBarriers() {
        Random randomRun = new Random();
        Random randomJump = new Random();
        Barrier[] barriers = new Barrier[2];
        barriers[0] = new Wall(randomJump.nextInt(120));
        barriers[1] = new Treadmill(randomRun.nextInt(500));
        return barriers;
    }

    private static Competitor[] creatingCompetitors() {
        Random randomRun = new Random();
        Random randomJump = new Random();
//        Human[] humans = new Human[testNumber];
//        Cat[] cats = new Cat[testNumber];
//        Robot[] robots = new Robot[testNumber];
        Competitor[] competitors = new Competitor[3];
        competitors[0] = new Human("Sapiens", randomRun.nextInt(500), randomJump.nextInt(200));
        competitors[1] = new Cat("Feya", randomRun.nextInt(500), randomJump.nextInt(200));
        competitors[2] = new Robot("Smartbot", randomRun.nextInt(500), randomJump.nextInt(50));
        return competitors;

    }
}
