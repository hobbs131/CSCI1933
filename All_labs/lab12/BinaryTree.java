import java.util.ArrayList;
public class BinaryTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node<K, V> getRoot() {
        return this.root;
    }

    public void add(K key, V value) {
        if (this.root == null) {
            this.root = new Node<K, V>(key, value);
        }
        else {
            this.root.add(key, value);
        }
    }
    public void printInOrder(Node node) {

      if (node == null){
        return;
      }
      printInorder(node.left);
      System.out.print(node.key + " ");
      prinInorder(node.right);
    }
    public void printPreOrder(Node node) {
      if (node == null){
        return;
      }
      System.out.print(node.key + " ");
      printPreorder(node.left);
      printPreorder(node.right);
    }
    public void printPostOrder(Node node) {
        if (node == null){
          return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }
    @SuppressWarnings("unchecked")
    public V[] flatten() {
      ArrayList<V> list = new ArrayList<V>();
      Node p = root;
      Helper helperFunction = new Helper();
      helperFunction.printInOrder(p,list);
      V[] flattened = new V[list.size()];
      for(int i = 0; i < list.size(); i++){
        flattened[i] = list[i];
      }
      return flattened;
    }

    public boolean containsSubtree(BinaryTree<K, V> other) {

        if(root != null && other != null){
          root.containsSub(other.getRoot());
        }
        else if(other == null){
          return true;
        }
        else if (root != null){
          return false
        }
    }

    public static void main (Strings args[]) {
            //Tree given for testing on
           BinaryTree<Integer, String> p1Tree = new BinaryTree<Integer, String>(new Node<Integer, String>(40, "forty",
            new Node<Integer, String>(20, "twenty",
                    new Node<Integer, String>(10, "ten"), new Node<Integer, String>(30, "thirty")),
            new Node<Integer, String>(60, "sixty",
                    new Node<Integer, String>(50, "fifty"), new Node<Integer, String>(70, "seventy"))));
    }
}
