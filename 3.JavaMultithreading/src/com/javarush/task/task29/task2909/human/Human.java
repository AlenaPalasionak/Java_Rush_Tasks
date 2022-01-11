package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private List<Human> children = new ArrayList<>();

    public Size getSize() {
        return size;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    private int id;
    protected int age;
    protected String name;

    private Size size;

    private BloodGroup bloodGroup;


        public class Size {
            public int height;
           public int weight;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Human> getChildren() {
            return Collections.unmodifiableList(children);
        }

        @Override
        public void live() {
        }

        public int getId() {
            return id;
        }

        public void printSize() {
            System.out.println("Рост: " + size.height + " Вес: " + size.weight);
        }

        public void addChild(Human child) {
            children.add(child);
        }

        public void removeChild(Human child) {
            children.remove(child);
        }

        public void printData() {
            System.out.println(getPosition() + ": " + name);
        }

        public String getPosition() {
            return "Человек";
        }

}