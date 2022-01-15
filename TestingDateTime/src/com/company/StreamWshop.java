package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWshop {
    public static void main(String[] args) {
        List<Staff> staffList = new ArrayList<>();
        staffList.add(new Staff("6c0231c1", "John", 5, 4293));
        staffList.add(new Staff("270d0145", "Mike", 6, 6530));
        staffList.add(new Staff("e75a1d7e", "Jean", 3, 2220));
        staffList.add(new Staff("c1c0a83a", "Kim", 4, 3390));

        // Exercise 1: Using streams' forEach(),
        // print the name of every staff
        System.out.println("[Exercise 1: ForEach]");
        staffList.stream().forEach(s->System.out.println(s.getName()));

        // Exercise 2: Using streams, compute
        // the total salary of all staff
        System.out.println("\n[Exercise 2: Sum]");
        float total = staffList.stream().map(s->s.getSalary()).reduce((n1,n2)->n1+n2).get();
        System.out.println(total);

        // Exercise 3: Using streams' filter(),
        // retrieve all salary that are more than
        // 3500 into a List, then print each of the
        // object within the List
        System.out.println("\n[Exercise 3: Filter]");
        staffList.stream().filter(s->s.getSalary()>3500).forEach(System.out::println);

        // Exercise 4: Using streams' map(), print
        // the list of increments that are less
        // than 200; given a staff's increment is
        // such that a grade of 5 and above
        // will yield a 8% increment (off of the staff's
        // current salary), while any other grades
        // will only yield a 4% increment.
        System.out.println("\n[Exercise 4: Map]");
        staffList.stream().map(s->{if(s.getGrade()>5) return 0.08*s.getSalary(); else return 0.04* s.getSalary();})
                .filter(n->n>200).forEach(System.out::println);

        // Exercise 5: Using streams' sort(), sort
        // the staff by salary in ascending
        // order (least salary first) and print out
        // each staff object
        // You may need to add necessary methods
        // to Staff class
        System.out.println("\n[Exercise 5: Sort]");
        staffList.stream().sorted((s1,s2)->{if(s1.getSalary() >s2.getSalary()) return 1;else return -1;}).forEach(System.out::println);

        // Exercise 6: Using streams' max(), display
        // the highest salary among the staff
        System.out.println("\n[Exercise 6: Max]");
        float maxSalary = staffList.stream().map(s1->s1.getSalary()).max((n1,n2)->{if(n1>n2) return 1;else if(n1<n2) return -1; else return 0;}).get();
        System.out.println(maxSalary);

        // Exercise 7: Using streams' reduce(),
        // implement your own "max" function
        // to display the highest salary among the staff
        System.out.println("\n[Exercise 7: Reduce");
        float maxSalary2 = staffList.stream().map(s1->s1.getSalary()).reduce((n1,n2)->{if(n1>n2) return n1;else return n2;}).get();
        System.out.println(maxSalary2);
    }
}

