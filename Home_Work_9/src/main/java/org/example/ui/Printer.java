package org.example.ui;

public class Printer{

    public static void printMenu(String[] items, String topic){
        System.out.println("*****************************");
        for (int i = 0; i< items.length; i++){
            System.out.println((i + 1) + "." + items[i]);
        }
        System.out.println("*****************************");
    }

    public static void printMsg(String msg, boolean nextLine){
        if (nextLine)
            System.out.println(msg);
        else
            System.out.println(msg);
    }

    public static void printWarning(String msg){
        System.out.println(">>>> "+ msg+"\n");
    }
}
