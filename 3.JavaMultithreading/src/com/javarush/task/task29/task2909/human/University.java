package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {
    String name;
    int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    //из списка студентов найти студента с таким же средним балом как из переданного параметра метода getStudentWithAverageGrade.
    public Student getStudentWithAverageGrade(double averageGrade) {
        Student theSameStudent = null;
        for (Student s : getStudents()) {
            if (s.getAverageGrade() == averageGrade) {
                theSameStudent = s;
            }
        }
        return theSameStudent;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student theBestStudent = null;
        double maxGrade =  getStudents().get(0).getAverageGrade();
        for(Student s : getStudents()) {
            if (s.getAverageGrade() > maxGrade) {
                theBestStudent = s;
                maxGrade = s.getAverageGrade();
            }
        }
        return theBestStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        Student derSchwachste = null;
        double mingrade = getStudents().get(0).getAverageGrade();
        for (Student s : getStudents()) {
            if (s.getAverageGrade() < mingrade) {
                derSchwachste = s;
                mingrade = s.getAverageGrade();
            }
        }
        return derSchwachste;
    }
    public void expel(Student student){

        students.remove(student);

    }
}