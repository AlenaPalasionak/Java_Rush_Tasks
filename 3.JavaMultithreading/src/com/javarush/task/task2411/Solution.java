package com.javarush.task.task24.task2411;
/* 
Вспомним наследование
*/
public class Solution extends C {
    private class A {  //Приватный внутренний класс А.  ВИДЕН только в классе Solution
        protected String value = "A";//тут proteced, значит ли это, что потомки могут увидеть эту переменную?
        // или все же прайват класс не даст?

        public A() {//конструктор выводит на экран переменную value
            System.out.print(value);// теперь идем в наследник смотрим переменные потом конструктор, которого нет
        }
    }//конец приватного класса A

    private A a = new A() {// переменные класса наследника - класс идем в родителя анон класса
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
            value = "Y";//
            // получается мы задали новое значение переменной value
            if (super.getClass().getName().contains(".Solution$")) {
//Если класс родитель(A).имяКлассаРодителя.содержит ".Solution$" -  класс A внутренний у солюшена
                System.out.print(value);// печатаем
            }
        }//блок заканчивается
    };//конец анонимного класса А

    public Solution() {//конструктор Solution
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Solution();// в мэйне создаем солюшен объект, пойдем конструктор класса-родителя, т.е. С
    }
}

//CCBAYS

