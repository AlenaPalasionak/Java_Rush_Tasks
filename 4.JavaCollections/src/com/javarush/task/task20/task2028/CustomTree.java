package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
//
//1) переопределить метод add(String s) - добавляет элементы дерева,
// в качестве параметра принимает имя элемента (elementName), искать место для вставки начинаем слева направо.
import java.io.Serializable;
import java.util.*;
//
//1) переопределить метод add(String s) - добавляет элементы дерева,
// в качестве параметра принимает имя элемента (elementName), искать место для вставки начинаем слева направо.
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    List<Entry<String>> list = new LinkedList<>();
    int listSize = 0;
    Entry<String> root;

    public CustomTree() {
        root = new Entry<>("0");
        root.parent = root;
        this.list.add(root);
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }

        @Override
        public String toString() {
            return "" + elementName;
        }
    }
    //хороший алгоритм. Можно в дебаггер -понятно
    public boolean add(String s) {
        Entry<String> entry = new Entry<>(s);// объект с именем s для создания узла

        for (int i = 0; i < list.size(); i++) {
            Entry<String> currentEntry = list.get(i);// корень в переменную cureEntry

            if (currentEntry.isAvailableToAddChildren()) {// если корень способен иметь детей, пока дети левый правый не заполнились
                if (currentEntry.availableToAddLeftChildren) {//ЛЕВОГО?
                    currentEntry.leftChild = entry;//присваиваем ребенка
                    currentEntry.availableToAddLeftChildren = false;// false не даст добавить то, что уже есть
                    entry.parent = currentEntry;//родителем этого узла будет cureEntry
                    list.add(entry);//добавляем в список левого ребенка
                    listSize++;
                    return true;// получается обнуляем результат, что бы можно было создавать детей для другого следующего родителя

                } else if (currentEntry.availableToAddRightChildren) {
                    currentEntry.rightChild = entry;
                    currentEntry.availableToAddRightChildren = false;
                    entry.parent = currentEntry;
                    list.add(entry);
                    listSize++;
                    return true;
                }
            }
        }
        return false;//
    }

    public int size() {
        return list.size() - 1; //
    }

    public String getParent(String s) {
        int parentName = (Integer.parseInt(s) - 1) / 2;
        return String.valueOf(parentName);
    }

    @Override
    public boolean remove(Object o) {

        if(!(o instanceof String)){
            throw new UnsupportedOperationException();
        }
        String elementName = "";
        o = (String) elementName;




        return super.remove(o);
    }

    // =======================================================

    public String get(int index) {
        return list.get(index).toString();
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}
