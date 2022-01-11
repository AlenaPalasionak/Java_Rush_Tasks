package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
        public boolean equals(Object o) {
            if(o == null) return  false;
            if(this == o) return  true;
            if(o.getClass() != this.getClass()) return false;
                A a = (A)o;

            return i == a.i && j == a.j;
        }
        public int hashCode() {
            int result = 17;
            result = result * 31 + (int) i;
            result = result *31 + (int) j;
        return result;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public boolean equals(Object o) {
            if (o == null || o.getClass() != this.getClass()) return false;
            if (o == this) return true;
            if (!super.equals(o)) return false;//если эти поля не совпадут, то нет смысла сравнивать дальше - объекты не равны

            B b = (B) o;

            return  name == b.name;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result*31 +(int)getI();
            result = result*31 + (int)getJ();
            result = result*31+(name == null ? 0 :name.hashCode());
            return  result;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }


        @Override
        protected C clone() throws CloneNotSupportedException {
            int i = super.getI();
            int j = super.getJ();
            String name = super.getName();
            C c = new C( i, j, name);// нужно клонировать вручную поля: i, j(из родителя A), name(из В )

            return c;
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);//
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    public static void main(String[] args) {


        }

    }

