package com.endava.homework;

import com.endava.homework.collections.StudentTreeSet;
import com.endava.homework.model.Student;

import java.time.LocalDate;
import java.util.Iterator;

public class Application {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2017, 11, 6);
        LocalDate localDate2 = LocalDate.of(2017, 11, 6);
        LocalDate localDate3 = LocalDate.of(2017, 12, 6);
        LocalDate localDate4 = LocalDate.of(2017, 12, 6);
        LocalDate localDate5 = LocalDate.of(2017, 12, 7);
        StudentTreeSet studentTreeSet = new StudentTreeSet();

        //Add student to TreeSet
        Student student00 = new Student("Alex",localDate5, "Details" );
        Student student0 = new Student("Alex",localDate4, "Details" );
        Student student1 = new Student("Petru",today, "Details" );
        Student student2 = new Student("Petru",localDate1, "Details"  );
        Student student3 = new Student("Vasea",localDate2, "Details Details" );
        Student student4 = new Student("Vasea",localDate2, "Details Details" );
        Student student5 = new Student("Vasea",localDate3, "Details Details" );
        studentTreeSet.add(student00);
        studentTreeSet.add(student0);
        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        studentTreeSet.add(student3);
        studentTreeSet.add(student4);
        studentTreeSet.add(student5);

        //Student TreeSet Size
        System.out.println(studentTreeSet.size());


        //Iterate through Student TreeSet
        Iterator<Student> iterator = studentTreeSet.iterator();
        System.out.println("StudentTreeSet: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next() + " ");
            System.out.println();
        }

        //Remove student from Student TreeSet
        studentTreeSet.remove(student3);
        System.out.println(studentTreeSet.size());


        //Check if Student TreeSet is empty
        System.out.println(studentTreeSet.isEmpty());
        System.out.println(studentTreeSet.lower(student1));


        //Remove all
//        studentTreeSet.removeAll(studentTreeSet);
//        System.out.println(studentTreeSet.size());


        //Check if Student TreeSett contains elements from another Student TreeSet
        System.out.println(studentTreeSet.containsAll(studentTreeSet));


    }
}
