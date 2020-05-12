package com.endava.homework.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;
    private LocalDate dateOfBirth;
    private String details;

    public Student(String name, LocalDate dateOfBirth, String details) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Student() {
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        Student student = (Student) obj;
        return name.equals(student.name) && details.equals(student.details) && dateOfBirth.equals(student.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, details);
    }

    @Override
    public String toString(){
        return String.format(name + " " + " " + dateOfBirth + " " + " " + details);
    }

    @Override
    public int compareTo(Student o){
        return Comparator.comparing(Student::getName)
                .thenComparing(Student::getDateOfBirth)
                .compare(this, o);
    }

}
