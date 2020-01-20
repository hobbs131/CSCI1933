public class Node<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private Node<K, V> left, right;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean equals(Node<K, V> other) {
        if (other == null) return false;
        boolean left, right;
        if (this.left == null) {
            left = other.left == null;
        }
        else {
            left = this.left.equals(other.left);
        }
        if (this.right == null) {
            right = other.right == null;
        }
        else {
            right = this.right.equals(other.right);
        }
        return left && right && this.key.equals(other.key) && this.value.equals(other.value);
    }

    public void add(K key, V value) {
        // key == this.key
        if (key.compareTo(this.key) == 0) {
            this.value = value;
        }
        // key < this.key
        else if (key.compareTo(this.key) < 0) {
            if (this.left == null) this.left = new Node<K, V>(key, value);
            else this.left.add(key, value);
        }
        // key > this.key
        else {
            if (this.right == null) this.right = new Node<K, V>(key, value);
            else this.right.add(key, value);
        }
    }

    public V find(K key) {
        // key == this.key
        if (this.key.equals(key)) {
            return this.value;
        }
        // key < this.key
        else if (key.compareTo(this.key) < 0) {
            return (this.left == null) ? (null) : (this.left.find(key));
        }
        // key > this.key
        else {
            return (this.right == null) ? (null) : (this.right.find(key));
        }
    }

    @SuppressWarnings("unchecked")
    private V[] concatinate(V[] arr1, V[] arr2, V[] arr3) {
        V[] ret = (V[]) new Object[arr1.length + arr2.length + arr3.length];
        int ctr = 0;
        for (V v1 : arr1) {ret[ctr++] = v1;}
        for (V v2 : arr2) {ret[ctr++] = v2;}
        for (V v3 : arr3) {ret[ctr++] = v3;}
        return ret;
    }



    private K min() {
        if (this.left == null) {
            return this.key;
        }
        else {
            return this.left.min();
        }
    }

    public void remove(K key, Node<K, V> parent) {
        // key == this.key
        if (key.equals(this.key)) {
            if (this.left != null && this.right != null) {
                K min = this.right.min();
                this.value = this.find(min);
                this.key = min;
                this.right.remove(min, this);
            }
            else if (parent.left == this) {
                parent.left = (left != null) ? left : right;
            }
            else if (parent.right == this) {
                parent.right = (left != null) ? left : right;
            }
        }
        // key < this.key
        else if (key.compareTo(this.key) < 0 && this.left != null) {
            this.left.remove(key, this);
        }
        // key > this.key
        else if (key.compareTo(this.key) > 0 && this.right != null) {
            this.right.remove(key, this);
        }
    }


    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }
    public boolean containsSub(Node node){
      if(node == null){
        return true;
      }
      return this.equals(node) || containsSub(left) || containsSub(right);
    }
}
