public class Stack<T extends Comparable<T>>{
  private T[] stack;
  public Stack(){
    stack = (T[]) new Comparable[5];
  }
  public Stack(int size){
    stack = (T[]) new Comparable[size];
  }
  public T pop(){
    T[] tempArray = (T[]) new Comparable[stack.length - 1];
    T objectToReturn;
    for (int i = 0; i < stack.length - 1; i++){
      tempArray[i] = stack[i];
    }
    objectToReturn = (T) stack[stack.length - 1];
    this.stack = tempArray;
    return objectToReturn;
  }
  public void push(T item)throws StackException{
    T[] tempArray = (T[]) new Comparable[stack.length + 1];
    for (int i = 0; i < stack.length; i++){
      tempArray[i] = stack[i];
    }
    tempArray[tempArray.length - 1] = item;
    this.stack = tempArray;
  }

}
