package com.company.exam.q4;

import java.util.ArrayList;
import java.util.List;

public class MyClass<T> {
    private static Integer pos = 0;
    private List<T> mylist= new ArrayList<T>();

    public void add(T obj){
        mylist.add(obj);
    }

    public T get(){
        return mylist.get((pos++)%mylist.size());
    }
}
