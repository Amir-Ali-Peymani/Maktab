package org.example.question03;

import java.util.ArrayList;
import java.util.List;

public class Question3 {
    public static void start() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(8);
        list.add(2);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
//        list.add(10);
        getValue(list);
    }

    private static void getValue(ArrayList<Integer> list01){
        if (list01.size() == 0) {
            System.out.println(list01);
            System.out.println("empty");
            return;
        }

        if (list01.size() % 2 != 0) {
            int remove =  list01.size() - 1;
            list01.remove(remove);
        }


        for (int i = 0; i < list01.size() - 1; i+=2) {
            System.out.print("{"+list01.get(i)+", "+list01.get(i+1)+"} ,");
        }

        System.out.println();
        print(list01);
    }
    private static void print(ArrayList<Integer> list01){
        ArrayList<Integer> inAppropriate = new ArrayList<>();
        ArrayList<Integer> appropriate = new ArrayList<>();
        for (int i = 0; i < list01.size() - 1; i+=2) {
            if (list01.get(i) < list01.get(i+1)) {
                System.out.print("<no> : {"+list01.get(i)+", "+list01.get(i+1)+"}, ");
                System.out.println();
                inAppropriate.add(list01.get(i));
                inAppropriate.add(list01.get(i+1));
            }
            if (list01.get(i) >= list01.get(i+1)){
                System.out.print("<yes> : {"+list01.get(i)+", "+list01.get(i+1)+"}, ");
                System.out.println();
                appropriate.add(list01.get(i));
                appropriate.add(list01.get(i+1));
            }
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println(list01);
        list01.clear();
        list01.addAll(appropriate);
        System.out.println("after edition: "+list01);
        System.out.println("THE CANDIDATES ARE: ");
        for (int i = 0; i < list01.size() - 1; i+=2) {
            System.out.print("{"+list01.get(i)+", "+list01.get(i+1)+"} ");
        }
    }
}
