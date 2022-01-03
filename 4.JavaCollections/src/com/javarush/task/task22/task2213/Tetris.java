package com.javarush.task.task22.task2213;

public class Tetris {

    private Field field;
    private Figure figure;

    static Tetris game;

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }

    public void run(){// будет отвечать за всю игру

    }
    public void step(){//будет отвечать за один шаг в игре

    }


    public static void main(String[] args) {
        game = new Tetris();
        game.run();

    }
}
