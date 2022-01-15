package com.company;

import java.io.FileReader;
import java.util.Random;

public class exceptionTest {
    public static void  main(String[] args){
        //FileReader fileReader = new FileReader("someplace.txt");
        Random r = new Random();
        int t = r.nextInt(10);
        System.out.println(t);
    }
}
