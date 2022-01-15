package com.company.exam.q4;

public class AClass {
    private String name;
    public AClass(String name) { this.name = name; };
    public String toString() { return name; }
    public static void main(String[] args) {
        MyClass<Integer> intObj = new MyClass<>();
        intObj.add(1);
        intObj.add(2);
        intObj.add(3);
        System.out.println(intObj.get());
        System.out.println(intObj.get());
        System.out.println(intObj.get());
        System.out.println(); // New line
        MyClass<Double> dblObj = new MyClass<>();
        dblObj.add(3.3);
        dblObj.add(1.1);
        System.out.println(dblObj.get());
        dblObj.add(2.2);
        System.out.println(dblObj.get());
        System.out.println(dblObj.get());
        System.out.println(); // New line
        MyClass<AClass> aClassObj = new MyClass<>();
        aClassObj.add(new AClass("oop"));
        aClassObj.add(new AClass("sql"));
        System.out.println(aClassObj.get());
        System.out.println(aClassObj.get());
        aClassObj.add(new AClass("asp.net"));
        System.out.println(aClassObj.get());
    }
}
