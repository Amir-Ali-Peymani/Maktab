package org.example.ui;

public class Printer {

    public static void printMenu(String[] items){
        System.out.println("*****************************");
        for (int i = 0; i< items.length; i++){
            System.out.println((i + 1) + "." + items[i]);
        }
        System.out.println("*****************************");
    }


}
