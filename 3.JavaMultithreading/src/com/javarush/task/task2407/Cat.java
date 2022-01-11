package com.javarush.task.task24.task2407;
/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i < 1, то вывести на экран, что кот спит. Пример, "Васька спит."
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     *
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {//Если локальный класс использует параметр метода,
        // то класс автоматически запоминает этот параметр
        class CatPet implements Sayable {
            @Override
            public String say() {
                if(i<1){
                    return    name + " спит.";
                }
                else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(" говорит м");
                    for(int j = 1;j <= i; j++){
                        stringBuilder.append("я");
                    }
                    stringBuilder.append("у!");
                    return   name + stringBuilder;
                }
            }
        }
    return new CatPet();// сюда мы зайдем раньше чем в создание класса CatPet
    }
}