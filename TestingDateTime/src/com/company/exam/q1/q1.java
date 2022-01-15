package com.company.exam.q1;

import java.util.HashMap;

public class q1 {
    public static void main(String [] args){
        String s = "0,1,1,1,0,0,1,1,0,1";
        String[] numbers = s.split(",");
        HashMap<String,Integer> helper = new HashMap<String, Integer>();
        for(String number : numbers){
            if(helper.containsKey(number)){
                Integer i = helper.get(number);
                i++;
                helper.put(number,i);
            }
            else{
                helper.put(number,1);
            }
        }

        for(String key : helper.keySet()){
            System.out.println("Number of "+ key +":" + helper.get(key).toString());
        }


    }
}
