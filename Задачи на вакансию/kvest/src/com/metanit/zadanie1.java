package com.metanit;

import java.util.*;

public class zadanie1 {
    static List even = new ArrayList<Integer>();//четные
    static List odd = new ArrayList<Integer>();//нечетные
    static List noll = new ArrayList<Integer>();//ноли

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i < 30; i++){
            int addresult = random.nextInt(10);
            integers.add(addresult);
        }


        int n = integers.size();
        getArrangedEvenOdd(integers, n);
        // сортируем по заданию
        Collections.sort(even, Collections.reverseOrder ());
        Collections.sort (odd);

        //System.out.println(odd);
        //Сборка

        for (int i = 0; i < odd.size(); i++) {
            integers.set(i, (int) odd.get(i));

        }

        for (int i = 0; i < noll.size(); i++) {
            integers.set(odd.size() + i, (int) noll.get(i));

        }
        for (int i = 0; i < even.size(); i++) {
            int t = odd.size() + noll.size();
            integers.set(t + i, (int) even.get(i));

        }

        System.out.println(integers);
    }


    //метод для разделения массива на четные на нечетные и  0
    public static void getArrangedEvenOdd(ArrayList<Integer> array, int n) {
        for (int j : array) {
            if (j == 0) {
                noll.add(j);
            } else if (j % 2 == 0) {
                even.add(j);
            } else
                odd.add(j);
        }
        //System.out.print(" even: " + even + "/n odd: " + odd );
    }


}
