package ua.com.alevel.db;

import java.util.Iterator;


public interface Array<T> extends Iterable<T>{

    void add(T element);

    void set(int index, T element);

    T get(int index);

    //int indexOf(T element);

    void remove(int index);

    void clear();

    int size();

    String toString();

    Iterator<T> iterator();
}
