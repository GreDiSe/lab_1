package com.company;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private String studentStatus = "Бюджет";
    private Float averageValue;
    private ArrayList inputArray;

    private ArrayList<Integer> marks = new ArrayList<>();

    Student(String name, String surname, ArrayList inputArray){
        this.name = name;
        this.surname = surname;
        this.inputArray = inputArray;
    }

    private void calculateMarksArray(){
        for(Object numMark : this.inputArray){
            if(numMark instanceof Integer){
                int currentValue = (int)numMark;

                if(currentValue >= 90) marks.add(5);
                else if(currentValue >= 75) marks.add(4);
                else if(currentValue >= 60) {
                    this.studentStatus = "Контракт";
                    marks.add(3);
                }
                else {
                    this.studentStatus = "Контракт";
                    marks.add(2);
                }

            } else if(numMark instanceof String) {
                String currentValue = (String) numMark;

                if(currentValue.equalsIgnoreCase("a")) marks.add(5);
                else if(currentValue.equalsIgnoreCase("b") || currentValue.equalsIgnoreCase("c")) marks.add(4);
                else if(currentValue.equalsIgnoreCase("d") || currentValue.equalsIgnoreCase("e")) {
                    this.studentStatus = "Контракт";
                    marks.add(3);
                }
                else {
                    this.studentStatus = "Контракт";
                    marks.add(2);
                }

            }
        }
    }

    private Float getAverageValue(){
        Float sum = 0f, kol = 0f;
        for(Object numMark:this.marks){
            sum += (int)numMark;
            kol++;
        }
        this.averageValue = sum / kol * 10;
        this.averageValue = (float) Math.round(this.averageValue);
        this.averageValue /= 10;

        return this.averageValue;
    }

    public String getStudentName(){
        return this.name;
    }

    public String getStudentSurname(){
        return this.surname;
    }

    public ArrayList<Integer> getStudentMarks(){
        return this.marks;
    }

    public String getUserStatus(){
        return this.studentStatus;
    }

    public ArrayList getInputArray(){
        return this.inputArray;
    }

    public void showStudentInfo(){
        if(this.averageValue == null)
            calculateMarksArray();

        System.out.println("Имя: " + this.name);
        System.out.println("Фамилия: " + this.surname);
        System.out.println("Оценки: " + this.marks.toString());
        System.out.println("Введенные оценки: " + this.inputArray.toString());
        System.out.println("Средний балл: " + this.getAverageValue());
        System.out.println("Статус: " + this.studentStatus + "\n");
    }
}
