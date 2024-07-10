package org.mylist;

import java.util.Collection;

public class MyLinkedList<E> extends MyList<E> {
    private Node<E> head; // головной узел связанного списка
    private int size; // размер связанного списка

    // внутренний класс (представляет узел в связанном списке)
    private static class Node<E> {
        E data; // данные, хранящиеся в узле
        Node<E> next; // ссылка на следующий узел

        // конструктор для Node
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // инициализация пустого списока
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // конструктор инициализирующий список элементами из коллекции
    public MyLinkedList(Collection<? extends E> elements) {
        this();
        for (E element : elements) {
            add(element); // добавление каждого элемента в список
        }
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) { // если список пуст, установить новый узел как head
            head = newNode;
        } else { // в противном случае найти последний узел и добавить новый узел
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void addAll(Collection<? extends E> elements) {
        for (E element : elements) {
            add(element);
        }
    }

    @Override
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) { // пройти к узлу по данному индексу
            current = current.next;
        }
        return current.data; // вернуть данные узла
    }

    @Override
    public E set(int index, E element) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldValue = current.data; // сохранить старые данные
        current.data = element; // установить новые данные
        return oldValue; // вернуть старые данные
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) { // проверка на действительность индекса
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> removedNode;
        if (index == 0) { // если элемент для удаления находится в head
            removedNode = head;
            head = head.next; // обновить head
        } else { // в противном случае найти узел перед тем, который нужно удалить
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next; // узел для удаления
            current.next = current.next.next; // обойти удаляемый узел
        }
        size--; // уменьшить размер
        return removedNode.data; // вернуть удаленные данные
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printAll() {
        Node<E> current = head;
        while (current != null) { // пройти по списку
            System.out.print(current.data + " "); // печать каждого элемента
            current = current.next;
        }
        System.out.println();
    }
}