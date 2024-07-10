package org.mylist;

import java.util.Collection;

public abstract class MyList<E> {

    public abstract void add(E element);

    public abstract void addAll(Collection<? extends E> elements);

    public abstract E get(int index);

    public abstract E set(int index, E element);

    public abstract E remove(int index);

    public static <E extends Comparable<E>> void bubbleSort(MyList<E> mylist) {
        boolean flag;
        for (int i = 0; i < mylist.size() - 1; i++) {
            flag = false;
            for (int j = 0; j < mylist.size() - 1 - i; j++) {
                if (mylist.get(j).compareTo(mylist.get(j + 1)) > 0) {
                    E temp = mylist.get(j);
                    mylist.set(j, mylist.get(j + 1));
                    mylist.set(j + 1, temp);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public abstract int size();

    public abstract void printAll();
}
