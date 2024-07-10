package org.mylist;

import java.util.ArrayList;
import java.util.List;

public class TestMyList {
    public static void main(String[] args) {
        // тестирование ArrayList
        {
            System.out.println("Array List");
            MyList<Integer> myArrayList = new MyArrayList<>();

            // метод add
            myArrayList.add(4);
            myArrayList.add(3);
            myArrayList.add(1);
            myArrayList.add(2);
            myArrayList.add(5);
            myArrayList.printAll(); // ожидаем вывод: 4 3 1 2 5

            // метод addAll
            List<Integer> additionalElements = new ArrayList<>();
            additionalElements.add(6);
            additionalElements.add(7);
            myArrayList.addAll(additionalElements);
            myArrayList.printAll(); // ожидаем вывод: 4 3 1 2 5 6 7

            // метод get
            System.out.println(myArrayList.get(2)); // Вывод: 1

            // метод set
            myArrayList.set(1, 15);
            myArrayList.printAll(); // ожидаем вывод: 4 15 1 2 5 6 7

            // метод remove
            myArrayList.remove(1);
            myArrayList.printAll(); // ожидаем вывод: 4 1 2 5 6 7

            // метод bubbleSort
            MyList.bubbleSort(myArrayList);
            myArrayList.printAll(); // ожидаем вывод: 1 2 4 5 6 7
        }
        // тестируем LinkedList
        {
            System.out.println("Linked List");
            MyList<Integer> myLinkedList = new MyLinkedList<>();

            // метод add
            myLinkedList.add(5);
            myLinkedList.add(4);
            myLinkedList.add(3);
            myLinkedList.add(2);
            myLinkedList.add(7);
            myLinkedList.printAll(); // ожидаем вывод: 5 4 3 2 7

            // метод addAll
            List<Integer> additionalElements = new ArrayList<>();
            additionalElements.add(8);
            additionalElements.add(9);
            myLinkedList.addAll(additionalElements);
            myLinkedList.printAll(); // ожидаем вывод: 5 4 3 2 7 8 9

            // метод get
            System.out.println(myLinkedList.get(2)); // ожидаем вывод: 3

            // метод set
            myLinkedList.set(2, 8);
            myLinkedList.printAll(); // ожидаем вывод: 5 4 8 2 7 8 9

            // метод remove
            myLinkedList.remove(2);
            myLinkedList.printAll(); // ожидаем вывод: 5 4 2 7 8 9

            // метод bubbleSort
            MyList.bubbleSort(myLinkedList);
            myLinkedList.printAll(); // ожидаем вывод: 2 4 5 7 8 9
        }
    }
}
