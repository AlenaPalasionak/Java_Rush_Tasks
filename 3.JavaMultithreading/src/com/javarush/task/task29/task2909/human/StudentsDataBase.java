package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);

    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }
//удалял студента из списка студентов только, если он там есть. Метод не должен кидать исключение.
    public static void removeStudent(int index)  {
        if (index >= 0 && index<students.size()){
            students.remove(index);
        }
    }
//Перепиши метод findDimaOrSasha(), сохранив логику его работы.
// В методе не должны использоваться флаги типа found, воспользуйся оператором break.
    public static void findDimaOrSasha() {
        for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getName().equals("Dima")) {
                    System.out.println("Студент Dima есть в базе.");
                    break;
                }

                if (students.get(i).getName().equals("Sasha")) {
                    System.out.println("Студент Sasha есть в базе.");
                    break;
                }
            }
        }
    }
