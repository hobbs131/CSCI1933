public class RemoveDuplicates{
  public static void removeDuplicates(IntNode list){
    IntNode ptr = list;
    while (ptr != null){
      IntNode tempNode = ptr.getNext();
      while(tempNode.getData() == ptr.getData()){
        tempNode = tempNode.getNext();
      }
      list.setNext(tempNode);
      ptr = ptr.getNext();
    }
  }
}
