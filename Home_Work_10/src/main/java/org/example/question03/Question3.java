package org.example.question03;

import java.util.ArrayList;

public class Question3 {
    public static void start() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(8);
        list.add(8);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(10);
        getChecking(list);
    }

    private static void printList(ArrayList<Integer> list) {
        System.out.print("{ ");
        for (int i = 0; i < list.size() - 1; i+=2) {
            System.out.print(list.get(i)+", "+list.get(i+1));
            if (i + 2 < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

    private static void getChecking(ArrayList<Integer> list01){
        if (list01.size() == 0) {
            System.out.println(list01);
            System.out.println("empty");
            return;
        }
        if (list01.size() % 2 != 0) {
            int remove =  list01.size() - 1;
            list01.remove(remove);
        }
        printList(list01);
        System.out.println();
        conclusion(list01);
    }

    private static void conclusion(ArrayList<Integer> list01){
        ArrayList<Integer> appropriate = new ArrayList<>();
        for (int i = 0; i < list01.size() - 1; i+=2) {
            if (list01.get(i) < list01.get(i+1)) {
                System.out.print("<no> : {"+list01.get(i)+", "+list01.get(i+1)+"}, ");
                System.out.println();
            }
            if (list01.get(i) >= list01.get(i+1)){
                System.out.print("<yes> : {"+list01.get(i)+", "+list01.get(i+1)+"}, ");
                System.out.println();
                appropriate.add(list01.get(i));
                appropriate.add(list01.get(i+1));
            }
        }
        printConclusion(list01, appropriate);
    }

    private static void printConclusion(ArrayList<Integer> list01, ArrayList<Integer> appropriate){
        System.out.println("-----------------------------------------------------------------");
        printList(list01);
        list01.clear();
        list01.addAll(appropriate);
        System.out.print("The appropriate: ");
        printList(list01);
        System.out.println("THE CANDIDATES ARE: ");
        for (int i = 0; i < list01.size() - 1; i+=2) {
            System.out.print("{"+list01.get(i)+", "+list01.get(i+1)+"} ");
        }
    }
}
