// PListInterface.java
// Interface for Project 3

public interface PListInterface {

    public void add(Object item);
        // adds item to the start of the PList.

    public void append(Object item);
       // places item at the end of the PList.

    public void concatenate(PListInterface plist);
      // joins plist to this PList to create a longer list.

    public void delete(int index);
      // removes the item at index from the Plist.
      // if the index does not exist, nothing happens.

    public Object get(int index);
      // returns the data item at index.

    public void insert(Object item, int index);
      // places item at the specified index.
      // if the index is past the end of the list,
      // item is added at the end of the PList.

    public int length();
      // returns the length of the PList.

    public void print();
      // displays to the screen the items in PList from beginning to end.
      // this is an option used for testing and verification.

    public void remove(Object item);
      // removes the data entry that matches item from the PList.

    public void sort();
      // sorts all items in PList by comparing the toString() values
      // of each data item.
    public void removeEvery(int n);

    public void removeDuplicates();
}  // PListInterface
