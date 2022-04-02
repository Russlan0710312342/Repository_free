package com.metanit;

import java.util.*;

public class zadanie2 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i < 30; i++){
            int addresult = random.nextInt(5);
            integers.add(addresult);
        }
        System.out.println(integers);
        Set<Integer> unique = new HashSet<Integer>(integers);
        for(Integer x: unique){
            System.out.println("Число " + x + " встречается раз: " + Collections.frequency(integers, x));
        }

    }
}
