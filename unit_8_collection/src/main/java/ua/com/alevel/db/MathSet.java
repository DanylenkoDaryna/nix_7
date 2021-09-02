package ua.com.alevel.db;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MathSet<T extends Number> implements Iterable{
    private T[] set;
    private static final int INITIAL_CAPACITY = 10;
    private int size;
    private static final int EXTRA_ITEM = 1;

    Comparator<Number> mathSetComparatop = (o1, o2) -> {
        if(o1 == o2 || o1.longValue() == o2.longValue() || o1.equals(o2) || o1.hashCode() == o2.hashCode()){
            return 0;
        }else if(o1.longValue() > o2.longValue()){
            return 1;
        }else
            return -1;
    };
    Comparator<Number> mathSetComparator = Comparator.comparingLong(Number::longValue);

    public MathSet(){
        set = (T[]) new Number[INITIAL_CAPACITY];
    }

    public MathSet(int initialCapacity){
        set = (T[]) new Number[initialCapacity];
    }

    public MathSet(T[] numbers){
        set = numbers;
        size = numbers.length;
    }

    @SafeVarargs
    public MathSet(T[]... numbers){
        int sizeCounter = 0;
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers[i].length; j++){
                sizeCounter++;
            }
        }
        setSize(sizeCounter);
        int counter = 0;
        set = (T[]) new Number[sizeCounter + INITIAL_CAPACITY];
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers[i].length; j++){
                set[counter] = numbers[i][j];
                counter++;
            }
        }
    }

    public MathSet(MathSet<T> mathSet){
        this();
        for(Object element : mathSet){
            add((T) element);
        }
    }

    @SafeVarargs
    public MathSet(MathSet<T>... mathSets){
        this();
        for(MathSet<T> set : mathSets){
            for(Object element : set){
                add((T) element);
            }
        }
    }

    public int size(){
        return getSize();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(T arg){
        if(checkNotRepeatable(arg)){
            if(size == set.length){
                grow(size);
                set[size] = arg;
                size = size + 1;
            }else{
                set[size] = arg;
                size = size + 1;
            }
        }
    }

    private boolean checkNotRepeatable(T arg){
        for(int i = 0; i < size; i++){
            if(mathSetComparatop.compare(set[i], arg) == 0){
                return false;
            }
        }
        return true;
    }

    public void add(T... args){
        for(int i = 0; i < args.length; i++){
            add(args[i]);
        }
    }

    private void grow(int oldCapacity){
        int newCapacity = oldCapacity + INITIAL_CAPACITY;
        T[] tempSet = (T[]) new Number[newCapacity];
        System.arraycopy(set, 0, tempSet, 0, size);
        set = tempSet;
    }

    private void remove(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException("You can not remove here! Out of MathSet bounds!");
        }else{
            int elementsToMove = size - index - EXTRA_ITEM;
            if(elementsToMove > 0){
                Object[] tempSet1 = set;
                Object[] tempSet2 = set;
                System.arraycopy(tempSet1, index + EXTRA_ITEM,
                        tempSet2, index,
                        elementsToMove);
            }
            int lastIndexToDelete = size - EXTRA_ITEM;
            set[lastIndexToDelete] = null;
            size = size - 1;
        }
    }

    public void set(int index, T element){
        if(index >= size){
            throw new IndexOutOfBoundsException("Out of MathSet bounds!");
        }else{
            set[index] = element;
        }
    }

    public Number get(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException("Out of MathSet bounds!");
        }else{
            return set[index];
        }
    }

    public void join(MathSet<T> mathSet){
        for(int i = 0; i < mathSet.size(); i++){
            add(mathSet.set[i]);
        }
    }

    public void join(MathSet<T>... mathSets){
        for(int i = 0; i < mathSets.length; i++){
            join(mathSets[i]);
        }
    }

    public void intersection(MathSet<T> mathSet){
        MathSet<T> tempSet = new MathSet(this.size() + mathSet.size());
        for(int i = 0; i < mathSet.size(); i++){
            if(!checkNotRepeatable(mathSet.getSet()[i])){
                tempSet.add(mathSet.getSet()[i]);
            }
        }
        set = tempSet.getSet();
        size = tempSet.size();
    }

    public void intersection(MathSet<T>... mathSets){
        for(int i = 0; i < mathSets.length; i++){
            intersection(mathSets[i]);
        }
    }

    public void clear(){
        for(int i = 0; i < size; i++){
            set[i] = null;
        }
        size = 0;
    }

    public void sortAsc(){
        for(int i = 0; i < size() - 1; i++){
            for(int j = 0; j < size() - 1; j++){
                T currVal = set[j];
                T nextVal = set[j + 1];
                if(currVal.longValue() > nextVal.longValue()){
                    set[j] = nextVal;
                    set[j + 1] = currVal;
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex){
        MathSet<T> tempSet = new MathSet(this.size());
        MathSet<T> setToSort = new MathSet(this.size());
        for(int i = 0; i < size(); i++){
            if(i == firstIndex){
                while(i != lastIndex){
                    setToSort.add(set[i]);
                    i++;
                }
                tempSet.add(set[i]);
                setToSort.sortAsc();
                tempSet.join(setToSort);
            }else{
                tempSet.add(set[i]);
            }
        }
        set = tempSet.getSet();
    }

    public void sortAsc(T value){
        MathSet<T> tempSet = new MathSet(this.size());
        MathSet<T> setToSort = new MathSet(this.size());
        for(int i = 0; i < size(); i++){
            if(mathSetComparator.compare(value, set[i]) == 0){
                while(i < size()){
                    setToSort.add(set[i]);
                    i++;
                }
                setToSort.sortAsc();
                tempSet.join(setToSort);
            }else{
                tempSet.add(set[i]);
            }
        }
        set = tempSet.getSet();
    }

    public void sortDesc(){
        for(int i = 0; i < size() - 1; i++){
            for(int j = 0; j < size() - 1; j++){
                T currVal = set[j];
                T nextVal = set[j + 1];
                if(currVal.longValue() < nextVal.longValue()){
                    set[j] = nextVal;
                    set[j + 1] = currVal;
                }
            }
        }
    }

    public void sortDesc(int firstIndex, int lastIndex){
        MathSet<T> tempSet = new MathSet(this.size());
        MathSet<T> setToSort = new MathSet(this.size());
        for(int i = 0; i < size(); i++){
            if(i == firstIndex){
                while(i != lastIndex){
                    setToSort.add(set[i]);
                    i++;
                }
                tempSet.add(set[i]);
                setToSort.sortDesc();
                tempSet.join(setToSort);
            }else{
                tempSet.add(set[i]);
            }
        }
        set = tempSet.getSet();
    }

    public void sortDesc(T value){
        MathSet<T> tempSet = new MathSet(this.size());
        MathSet<T> setToSort = new MathSet(this.size());
        for(int i = 0; i < size(); i++){
            if(mathSetComparator.compare(value, set[i]) == 0){
                while(i < size()){
                    setToSort.add(set[i]);
                    i++;
                }
                setToSort.sortDesc();
                tempSet.join(setToSort);
            }else{
                tempSet.add(set[i]);
            }
        }
        set = tempSet.getSet();
    }

    @Override
    public Iterator iterator(){
        return new MathSetIterator();
    }

    public Number getMax(){
        Number max = 0;
        for(int i = 0; i < size(); i++){
            Number currVal = set[i];
            if(currVal.longValue() > max.longValue()){
                max = set[i];
            }
        }
        return max;
    }

    public Number getMin(){
        Number min = set[0];
        for(int i = 0; i < size(); i++){
            Number currVal = set[i];
            if(currVal.longValue() < min.longValue()){
                min = set[i];
            }
        }
        return min;
    }

    public Number getAverage(){
        Integer average = new Integer(0);
        for(int i = 0; i < size(); i++){
            average += (Integer) set[i];
        }
        return average / 2;
    }

    public Number getMedian(){
        if(size % 2 != 0){
            return set[size() / 2];
        }else{
            Number leftCentralElement = set[(size() / 2) - 1];
            Number rightCentralElement = set[(size() / 2) + 1];
            Number average = (leftCentralElement.doubleValue() + rightCentralElement.doubleValue()) / 2;
            return average;
        }
    }

    public Number[] toArray(){
        return set;
    }

    public Number[] toArray(int firstIndex, int lastIndex){
        Number[] array = new Number[lastIndex - firstIndex + 1];
        for(int i = 0; i < size(); i++){
            if(i == firstIndex){
                int count = 0;
                while(i != lastIndex + 1){
                    array[count] = set[i];
                    i++;
                    count++;
                }
            }
        }
        return array;
    }

    public MathSet<T> cut(int firstIndex, int lastIndex){
        MathSet<T> tempSet = new MathSet(lastIndex - firstIndex + 1);
        for(int i = 0; i < size(); i++){
            if(i == firstIndex){
                while(i != lastIndex + 1){
                    tempSet.add(set[i]);
                    i++;
                }
            }
        }
        return tempSet;
    }

    public void clear(Number[] numbers){
        MathSet<T> tempSet = new MathSet(size() - numbers.length);
        for(int i = 0; i < size(); i++){
            if(set[i] == numbers[0]){
                while(set[i] != numbers[numbers.length - 1]){
                    i++;
                }
            }else{
                tempSet.add(set[i]);
            }
        }
        set = tempSet.getSet();
        size = tempSet.size();
    }


    class MathSetIterator implements Iterator{

        private static final short NO_SUCH_INDEX = -1;
        private static final short INCREMENT = 1;
        // index of next element to return
        private int nextIndex = 0;
        // index of last element returned; -1 if no such
        private int lastReturnIndex = NO_SUCH_INDEX;

        MathSetIterator(){
        }

        @Override
        public boolean hasNext(){
            return nextIndex < size;
        }

        @Override
        public T next(){
            int nextToReturnIndex = nextIndex;
            if(nextToReturnIndex >= getSize()){
                throw new NoSuchElementException();
            }
            lastReturnIndex = nextToReturnIndex;
            nextIndex = nextToReturnIndex + INCREMENT;
            return getSet()[lastReturnIndex];

        }

        @Override
        public void remove(){
            if(lastReturnIndex < 0){
                throw new IllegalStateException();
            }
            try{
                MathSet.this.remove(lastReturnIndex);
                nextIndex = lastReturnIndex;
                lastReturnIndex = NO_SUCH_INDEX;
            }catch(IndexOutOfBoundsException ex){
                throw new IndexOutOfBoundsException("Problem in method remove() in iterator!");
            }
        }
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i <= size - 1; i++){
            if(i != size - 1){
                sb.append(set[i]).append(", ");
            }else{
                sb.append(set[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }


    private int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public T[] getSet(){
        return set;
    }

    public void setSet(T[] set){
        this.set = set;
    }
}
