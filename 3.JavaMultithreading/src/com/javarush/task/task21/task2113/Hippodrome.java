package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List <Horse> horses;
    static  Hippodrome game;// чтобы обращаться из других классов

    public Hippodrome(List <Horse> horses){
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for(int i = 1; i<=100; i++){
            move();
            print();
            Thread.sleep(200);
        }
//В методе move класса Hippodrome должен быть вызван метод move по одному разу для каждой лошади(каждого элемента списка horses).
    }
    public void move(){
for(int i = 0; i<horses.size(); i++){
    horses.get(i).move();
}
    }
    public void print(){
for(int i = 0; i<horses.size(); i++){
    horses.get(i).print();
}
        for(int i = 0; i<10; i++){
            System.out.println();
        }
    }
    public Horse getWinner(){//возвращать лошадь пробежавшую наибольшую дистанцию.
       Horse winner = horses.get(0);

        for(int i = 0; i<horses.size()-1;i++) {
            if (winner.getDistance() < horses.get(i + 1).distance) {//
                winner = horses.get(i+1);
                
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() +"!");
    }

    public static void main(String[] args) throws InterruptedException {

List<Horse> horses = new ArrayList<>();
    Horse horse1 = new Horse("1 лошадь", 3, 0);
        Horse horse2 = new Horse("2 лошадь", 3, 0);
        Horse horse3 = new Horse("3 лошадь", 3, 0);

        horses = new ArrayList<Horse>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);


game.run();

        game.printWinner();
    }
}
//+1. В классе Hippodrome должно быть создано поле game типа Hippodrome.
//+2. Поле game должно быть статическим.
//+3. Поле game НЕ должно быть приватным.
//+4. В методе main должно инициализироваться поле game.
//--5. В методе main в список лошадей ипподрома должны быть добавлены три лошади.
//+6. Скорости всех лошадей должны быть равны 3, а дистанции - 0.
