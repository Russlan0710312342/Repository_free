package com.metanit;

import java.util.ArrayList;
import java.util.Random;

public class zadanie3 {
    public static void main(String[] args) {
        int broski = 1000;// колличество бросков

        // кости игрока 1
        ArrayList<Integer> igrock1 = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int addresult = random.nextInt(5) + 1;
            igrock1.add(addresult);
        }
        System.out.println("Комбинация игрока 1: " + igrock1);
        // кости игрока 2
        ArrayList<Integer> igrock2 = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int addresult = random.nextInt(5) + 1;
            igrock2.add(addresult);
        }
        System.out.println("Комбинация игрока 2: " + igrock2);

        // набор костей игрового поля при 100 бросках
        ArrayList<Integer> pole = new ArrayList<Integer>();
        for (int i = 0; i < 3 * broski; i++) {
            int addresult = random.nextInt(5) + 1;
            pole.add(addresult);
        }
        System.out.println("Комбинация костей игрового поля при " + broski + " бросках: " + pole);
        //считаем очки каждого
        int coin_1player = getСoin (igrock1,pole);
        System.out.println( "Игрок 1 набрал " + coin_1player + " очков");
        int coin_2player = getСoin (igrock2,pole);
        System.out.println( "Игрок 2 набрал " + coin_2player + " очков");
        // расчет вероятности = количество побед / количество бросков * 100
        double ver_win_1player = Double.parseDouble(String.valueOf(coin_1player*100)) / broski ;
        System.out.println( "Игрок 1 Процент успешности игры  "  +  ver_win_1player + " %");
        double ver_win_2player = Double.parseDouble(String.valueOf(coin_2player*100)) / broski ;
        System.out.println( "Игрок 2 Процент  успешности игры  " + ver_win_2player + " %");
        double ver_win_1 = ver_win_1player/100 - 1/36/6;//вероятность победы 1 игрока
        double ver_win_2= ver_win_2player/100 - 1/36/6;//вероятность победы 2 игрока
        double proigr1 = 1 -ver_win_1;//вероятность проигрыша 1 игрока
        double proigr2 = 1 -ver_win_2;//вероятность проигрыша 2 игрока
        double win1_louse2 = ver_win_1 * proigr2*100;
        double win2_louse1 = ver_win_2 * proigr1*100;
        double nichiya = (ver_win_1 * ver_win_2 + proigr2 * proigr1)*100;
        System.out.println( "Вероятность того что победит 1 игрок а проиграет 2 = " + win1_louse2 + " %");
        System.out.println( "Вероятность того что победит 2 игрок а проиграет 1 = " + win2_louse1 + " %");
        System.out.println( "Вероятность ничьи = " + nichiya + " %");
     
    }

    //метод подсчета очков игрока
    public static int getСoin(ArrayList<Integer> arrayIgrock, ArrayList<Integer> arrayPole) {
        int ch1 = arrayIgrock.get(0);// первое число комбинации
        int ch2 = arrayIgrock.get(1);// второе число комбинации
        int ch3 = arrayIgrock.get(2);// третье число комбинации
        int coin = 0;// колличество очков
        int combo = 0;// колличество совпадений подряд
        for (int ch : arrayPole){
            if (ch == ch1){
                combo = 1;
            }
            if (ch == ch2 && combo == 1 ){
                combo = 2;

            }
            if (ch == ch3 &&  combo == 2){
                coin += 1;
                combo = 0;

            }
        }

        return coin;

    }
}