package com.wxw.singlelinked;


/**
 * @Description: $
 * @Author: 魏小伟
 * @create: 2019-09-03 23:36
 * @version: 1.0
 */

public class Main {

    public static void main(String[] args) {
        SingleLinkedListDemo<Integer> linkedList = new SingleLinkedListDemo<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }
        linkedList.add(5,11111);
        System.out.println(linkedList.toString());

        linkedList.remove(5);
        System.out.println(linkedList.toString());
        linkedList.removeFirst();
        System.out.println(linkedList.toString());
        linkedList.removeLast();
        System.out.println(linkedList.toString());
        linkedList.remove(4);
        System.out.println(linkedList.toString());
        linkedList.addFirst(4);
        linkedList.addFirst(4);
        linkedList.addFirst(4);
        linkedList.removeAll(4);
        System.out.println(linkedList.toString());
    }
}