// ArrayList.java
// CSCI 1933 Lab 11 - Midterm 2 Review
// ArrayList implements PListInterface using an array

public class ArrayList implements PListInterface {

    // member variables

    private static final int DEFAULT_LENGTH = 5;
    private Object[] arr;
    private int size;

    // constructors

    public ArrayList() {
        arr = new Object[DEFAULT_LENGTH];
        size = 0;
    }

    public ArrayList(int length) {
        if (length < 0) {
            length = DEFAULT_LENGTH;
        }
        arr = new Object[length];
        size = 0;
    }

    // methods

    // TODO: Implement this
    public void add(Object item) {
      Object[] tempArr = new Object[arr.length + 1];
      for (int i = 0; i < arr.length; i++){
        tempArr[i] = arr[i];
      }
      tempArr[tempArr.length - 1] = item;
      this.arr = tempArr;
    }

    public void append(Object item) {
        if (size >= arr.length) {
            growArray();
        }
        arr[size++] = item;
    }

    // TODO: Implement this
    public void concatenate(PListInterface plist) {

    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // TODO: Implement this
    public Object get(int index) {
        return null;
    }

    public void insert(Object item, int index) {

    }

    public int length() {
        return size;
    }

    public void print() {
        System.out.println(this);  // calls the toString
    }

    public void remove(Object item) {

    }

    public void sort() {

    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < size - 1; i++) {
            str += arr[i] + ", ";
        }
        if (size > 0) {
            str += arr[size - 1];
        }
        str += "]";
        return str;
    }

    public boolean equals(ArrayList other) {
        return false;
    }

    // re-sizes the array to (approximately) double its size
    // notice how this method is private
    private void growArray() {
        int oldSize = arr.length;
        Object[] newArr = new Object[2 * oldSize + 1];
        for (int i = 0; i < oldSize; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public static void main(String[] args) {
        PListInterface myList = new ArrayList(2);
        myList.add(42);
        myList.print();
        myList.add(0);
        myList.print();
    }
} // ArrayList
