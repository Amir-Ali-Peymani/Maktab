package org.example.question04;


import java.util.ArrayList;

public class MyHashMap<K, V>{

    ArrayList<K> keys = new ArrayList<>();
    ArrayList<V> values = new ArrayList<>();


    public void put(K key, V value){
        keys.add(key);
        values.add(value);
    }

    public void containsKey(K key){
        for (int i = 0; i < keys.size(); i++){
            if(keys.get(i).equals(key)){
                System.out.println("{"+keys.get(i)+"="+values.get(i)+"}");
            } else {
                System.out.println("the key is not in the map");
            }
        }
    }

    public V get(K key) {
        for(int i = 0; i < keys.size(); i++){
            if(keys.get(i).equals(key)){
                System.out.println(values.get(i));
            }
        }
        return null;
    }

    public boolean isEmpty(){
        boolean empty = false;
        if (keys.size() == 0 && values.size() == 0) {
            System.out.println("empty");
            empty = true;
        } else {
            System.out.println("not empty");
        }
        return empty;
    }

    public void remove(K key){
        if (keys.size() == 0 && values.size() == 0) {
            System.out.println("empty");
        } else {
            keys.remove(key);
            values.remove(key);
            System.out.println("it got remove!!");
        }
    }

    public void getAll(){
        System.out.print("{ ");
        for (int i = 0; i < keys.size(); i++){
            System.out.print(keys.get(i)+" = "+values.get(i));
            if (i < keys.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

    public void change(K key, V value){
        if (keys.size() == 0 && values.size() == 0) {
            System.out.println("empty");
        } else {
            for (int i = 0; i < keys.size(); i++){
                if(keys.get(i).equals(key)){
                    values.set(i, value);
                }
            }
            System.out.println("it got modify!!");
        }
    }

}
