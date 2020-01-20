import java.util.Scanner;

public class PList implements PListInterface{
  private ObjectNode head;
  private int length = 0;

  public PList(){
    head = null;
  }

  public void append(Object data){
    ObjectNode newNode = new ObjectNode(data, null);

    // If list is empty, make it the head
    if (head == null){
      this.head = newNode;
    }

    else{
      ObjectNode traversalNode = head;
      // traverse to last node
      // insert newNode there
      while (traversalNode.getNext() != null){
        traversalNode = traversalNode.getNext();
      }
      traversalNode.setNext(newNode);
    }
    this.length++;
  }

  public void add(Object item){
    ObjectNode newNode = new ObjectNode(item, null);
    // Sets head as newNode if plist is empty
    if (head == null){
      this.head = newNode;
    }
    // Current head set to next node and reassigned as newNode
    else{
      newNode.setNext(head);
      head = newNode;
    }
    this.length++;
  }

  public void print (){
    ObjectNode nodeToPrint = head;

    while (nodeToPrint != null){
      // Print at current node
      System.out.print(nodeToPrint.toString() + " ");
      // Move to next node
      nodeToPrint = nodeToPrint.getNext();
    }
    System.out.println();
  }

  public void remove(Object item){
    ObjectNode traversalNode = head;
    ObjectNode prevNode = null;

    // Removes head if it matches
    if (head.toString().equals(item.toString())){
      this.head = head.getNext();
    }
    // Otherwise traverse to last node if needed
    else{
      while (traversalNode != null){
        // Converts object to string and checks for equality
        if (item.toString().equals(traversalNode.toString())){
          prevNode.setNext(traversalNode.getNext());
          break;
        }
        prevNode = traversalNode;
        traversalNode = traversalNode.getNext();
      }
    }
  this.length--;
  }

  public void sort(){
    // If length isn't greater than one, then the list is already sorted
    if (length > 1){
      // Traverses plist like a 2D-array
      for (int i = 0; i < length; i++){
        ObjectNode traversalNode = head;
        ObjectNode nextNode = head.getNext();
        for (int j = 0; j < length - 1; j++){
          // Converting Object data to string
          String traversalNodeString = traversalNode.getData().toString();
          String nextNodeString = nextNode.getData().toString();
          // If traversalNode is larger than nextNode, then swap the data
          if (traversalNodeString.compareTo(nextNodeString) > 0){
            Object tempObject = traversalNode.getData();
            traversalNode.setData(nextNode.getData());
            nextNode.setData(tempObject);
          }
          // Update nodes (move up linked list)
          traversalNode = nextNode;
          nextNode = nextNode.getNext();
        }
      }
    }
  }

  public void concatenate(PListInterface plist){
    int index = 0;
    // Plist has no elements if head is null.
    if (plist.get(0) == null){
      return;
    }
    else{
      // Go through plist and append its items at each index to this.plist
      while (index < plist.length()){
        append(plist.get(index));
        index++;
      }
    }
  }

  public void delete(int index){
    int position = 0;
    ObjectNode traversalNode = head;
    ObjectNode prevNode = null;

    // Delete head if index is 0.
    if (index == 0){
      this.head = head.getNext();
    }
    // Otherwise find the index if it exists
    else if (index > 0 && index < length){
      // Traverse until correct position is found
      while (traversalNode != null){
        // When the chosen index is found, it is unlinked (deleted)
        if (index == position){
          prevNode.setNext(traversalNode.getNext());
          break;
        }
        // Updates nodes and position
        prevNode = traversalNode;
        traversalNode = traversalNode.getNext();
        position++;
      }
    }
    this.length--;
  }
  public void removeEvery (int n){
    ObjectNode traversalNode = head;
    ObjectNode prevNode = null;

    for (int i = 1; i <= length; i++){
      if (i % 2 == 0){
        prevNode.setNext(traversalNode.getNext());
      }
      prevNode = traversalNode;
      traversalNode = traversalNode.getNext();
    }
    this.length--;
  }

  public void removeDuplicates(){
    ObjectNode innerTraversalNode = head.getNext();
    ObjectNode outerTraversalNode = head;
    ObjectNode prevNode = head;
    ObjectNode prevNodeTracker = head;

    // two while loop structure acts as 2D-Array
    while (outerTraversalNode.getNext() != null){
      // update prevNode to be one position before innerTraversalNode
      prevNode = prevNodeTracker;
      // iterate through linked-list
      while (innerTraversalNode != null){
        if (outerTraversalNode.toString().equals(innerTraversalNode.toString())){
          System.out.println("Removed: " + prevNode.getData() + " " + innerTraversalNode.getData() + " " + innerTraversalNode.getNext());
          prevNode.setNext(innerTraversalNode.getNext());
          innerTraversalNode = prevNode.getNext();
        }
        else {
          prevNode = innerTraversalNode;
          innerTraversalNode = innerTraversalNode.getNext();
        }
      }
      // shift forward one position in list by moving outer,inner,and prevNodeTracker
      if (outerTraversalNode.getNext() != null){
        outerTraversalNode = outerTraversalNode.getNext();
        innerTraversalNode = outerTraversalNode.getNext();
        prevNodeTracker = prevNodeTracker.getNext();
      }
    }
  }

  public Object get(int index){
    int position = 0;
    ObjectNode traversalNode = head;

    // Return head if index is zero
    if (index == 0){
      return head;
    }

    // Otherwise traverse until correct position is found
    while (traversalNode != null){
      // Exit loop and return desired Object
      if (index == position){
        break;
      }
      traversalNode = traversalNode.getNext();
      position++;
    }
    return traversalNode.getData();
  }

  public int length(){
    // global variable length is updated
    // with each insertion/deletion operation
    return length;
  }

  public void insert(Object item, int index){
    int position = 0;
    // Creation of node containing item
    ObjectNode newNode = new ObjectNode(item, null);
    newNode.setData(item);
    newNode.setNext(null);

    // Sets head to newNode if the list is empty
    if (head == null){
      this.head = newNode;
    }
    // Appends to list if index doesn't exist
    else if (index > length){
      ObjectNode traversalNode = head;
      // traverse to last node
      // insert newNode there
      while (traversalNode.getNext() != null){
        traversalNode = traversalNode.getNext();
      }
      traversalNode.setNext(newNode);
    }
    // If index is zero, treat like an add operation
    else if (index == 0){
      newNode.setNext(head);
      head = newNode;
    }
    // Traverses through list, finds correct position
    // Then sets link of newNode to the previous node and next node
    else{
      ObjectNode prevNode = null;
      ObjectNode traversalNode = head;
      // Finding correct position
      while(traversalNode != null && position < index){
        prevNode = traversalNode;
        traversalNode = traversalNode.getNext();
        position++;
      }
      // Setting links
      newNode.setNext(prevNode.getNext());
      prevNode.setNext(newNode);
    }
    this.length++;
  }

  public static void main (String[] args){
    PListInterface pList = new PList();

    Scanner f = new Scanner(System.in);
    System.out.println();
    System.out.println("Commands for plist:");
    System.out.println();
    System.out.println("Add (item) - adds the String item to the start of the PList");
    System.out.println("Append (item)- places the String item at the end of the PList");
    System.out.println("Concatenate - joins two plists together (prints hard-coded tests)");
    System.out.println("Create - creates a new empty PList");
    System.out.println("Delete (index) - removes the item at index from the PList");
    System.out.println("Get (index) - returns the data item at index");
    System.out.println("Insert (item, index) - places the String item at the specified index");
    System.out.println("Length - returns the length of the PList");
    System.out.println("Print - displays to the screen the items in PList from beginning to to end");
    System.out.println("Remove (item) - removes the data entry that matches item from the PList");
    System.out.println("Sort - sorts all items in ascending order by comparing toString() values");
    System.out.println("Exit - terminates the program");
    System.out.println("Mixed - concatenates current list with list of mixed types");
    System.out.println();
    System.out.println("Sample commands syntax:");
    System.out.println();
    System.out.println("Append 7");
    System.out.println("Delete 0");
    System.out.println("Insert hello,0");
    System.out.println("Print");
    System.out.println("Output: hello");
    System.out.println();
    System.out.print("Enter Command: ");

    while(f.hasNextLine()){
      System.out.println();
      System.out.print("> ");
      String[] input = f.nextLine().split(" ");
      if (input[0].equals("Add") || input[0].equals("add")){
        pList.add(input[1]);
        System.out.println(input[1] + " was added to the list");
        System.out.println();
      }
      else if(input[0].equals("Get") || input[0].equals("get")){
        System.out.println("The item at the given index is: " + String.valueOf(pList.get(Integer.valueOf(input[1]))));
      }
      else if(input[0].equals("Append") || input[0].equals("append")){
        pList.append(input[1]);
        System.out.println(input[1] + " was appended to the list");
        System.out.println();
      }
      else if(input[0].equals("Length") || input[0].equals("length")){
        System.out.println("The length of the list is: " + pList.length());
      }
      else if(input[0].equals("Remove") || input[0].equals("remove")){
        pList.remove(input[1]);
        System.out.println(input[1] + " was removed from the list");
        System.out.println();
      }
      else if(input[0].equals("Delete") || input[0].equals("delete")){
        pList.delete(Integer.valueOf(input[1]));
        System.out.println("The item at index " + input[1] + " (if the index exists) was deleted from the list");
        System.out.println();
      }
      else if(input[0].equals("Print") || input[0].equals("print")){
        pList.print();
      }
      else if(input[0].equals("Mixed") || input[0].equals("mixed")){
        PList plist1 = new PList();
        plist1.append(7.0);
        plist1.append(5);
        plist1.append("hello");
        pList.concatenate(plist1);
        pList.sort();
        System.out.println("Mixed list is: {7.0, 5, hello} (double, int, string)");
        System.out.println("Concatenated and sorted list is: ");
        pList.print();
      }
      else if(input[0].equals("Insert") || input[0].equals("insert")){
        // Because it's split at "," the following tempString will be of format
        // {item,index}
        String[] tempString = input[1].split(",");

        pList.insert(tempString[0], Integer.valueOf(tempString[1]));
        if (Integer.valueOf(tempString[1]) > pList.length()){
          System.out.println("Index is out of range. " + tempString[0] + " was added to the end of the list");
        }
        else{
          System.out.println(tempString[0] + " was inserted into the list at index " + tempString[1]);
          System.out.println();
        }
      }
      else if(input[0].equals("Sort") || input[0].equals("sort")){
        pList.sort();
        System.out.println("The list is now sorted");
        System.out.println();
      }
      else if(input[0].equals("Create") || input[0].equals("create")){
        pList = new PList();
        System.out.println();
      }
      else if(input[0].equals("Exit") || input[0].equals("exit")){
        System.out.println("Program successfully terminated");
        System.exit(0);
      }

      else if(input[0].equals("removeEvery") || input[0].equals("removeevery")){
        pList.removeEvery(Integer.valueOf(input[1]));
        System.out.println("removeEvery operation has been performed");
      }

      else if(input[0].equals("removeDuplicates") || input[0].equals("removeduplicates")){
        pList.removeDuplicates();
        System.out.println("removeDuplicates operation has been performed");
      }

      else if(input[0].equals("Concatenate") || input[0].equals("concatenate")){
        PList pList1 = new PList();
        pList1.append("7");
        pList1.append("hello");
        pList1.append("10");
        System.out.println("Hard-coded concatenate test with plist containing {7,hello,10}");
        pList.concatenate(pList1);
        System.out.print("Concatenated list: ");
        pList.print();
        System.out.println();
      }
    }
    */
  }
}
