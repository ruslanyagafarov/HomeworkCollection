package org.mylist;

import java.util.Collection;

public class MyArrayList<E extends Comparable<E>> extends MyList<E> {
    private int size = 0; // размер списка
    private int capacity = 10; // начальная емкость массива
    private final double CAPACITY_RATIO = 1.5; // коэффициент увеличения емкости
    private int CUT_RATIO = 4; // коэффициент для уменьшения емкости
    private E[] array; // массив для хранения элементов

    // конструктор для инициализации массива начальной емкости
    public MyArrayList() {
        array = (E[]) new Comparable[capacity];
    }

    // конструктор для инициализации списка элементами из коллекции
    public MyArrayList(Collection<? extends E> elements) {
        this();
        for (E element : elements) {
            add(element); // добавление каждого элемента в список
        }
    }

    // метод увеличивающий емкость массива
    private void increase(int addCapacity) {
        int newSize = (int) (array.length * CAPACITY_RATIO) + addCapacity;
        E[] tempArray = (E[]) new Comparable[newSize];
        System.arraycopy(array, 0, tempArray, 0, size); // копирование старого массива в новый
        array = tempArray;
        capacity = newSize; // обновление емкости
    }

    @Override
    public void add(E element) {
        if (size == capacity) { // Если массив заполнен, увеличить емкость
            increase(1);
        }
        array[size] = element;
        size++;
    }

    @Override
    public void addAll(Collection<? extends E> elements) {
        for (E element : elements) {
            add(element); // Добавление каждого элемента в список
        }
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldElement = array[index]; // сохранение старого элемента
        array[index] = element; // установка нового элемента
        return oldElement; // возврат старого элемента
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = array[index]; // сохранение удаляемого элемента
        for (int i = index; i < size - 1; i++) { // сдвиг элементов
            array[i] = array[i + 1];
        }
        array[size - 1] = null; // очистка последнего элемента
        size--; // уменьшение размера списка

        if (capacity > size && size < capacity / CUT_RATIO) { // проверка необходимости уменьшения емкости
            int newLength = Math.max(capacity / CUT_RATIO, 10);
            E[] tempArray = (E[]) new Comparable[newLength];
            System.arraycopy(array, 0, tempArray, 0, size); // копирование в новый массив
            array = tempArray;
            capacity = newLength; // обновление емкости
        }
        return removedElement; // возврат удаленного элемента
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}