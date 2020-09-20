package com.gmail.xlinaris.lesson01;

public interface Competitor {
    void isOvercome(int length, String type);

    void run(int lengthRun);

    void jump(int lengthJump);

    boolean isNext();

//    void setNext(boolean next);
}
