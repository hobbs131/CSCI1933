public class Helper{
  public void printInOrder(Node node, ArrayList<V> list) {
    if (node == null){
      return false;
    }
    printInorder(node.left);
    list.add(node.getValue());
    prinInorder(node.right);
  }
  public boolean containsSub(Node node){
    if(node == null){
      return true;
    }
    containsSub(node.left);
    containsSub(node.right);
  }
}
