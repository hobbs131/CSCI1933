import java.util.Stack;

public class StackedQueue<T> {
  private Stack<T> newStack = new Stack<>();

  public boolean isEmpty(){
    return newStack.empty();
  }
  public void enqueue(T element){
    newStack.push(element);
  }

  public void dequeue(){
    Stack<T> tempStack = new Stack<>();
    Stack<T> tempStackTwo = new Stack<>();
    int stackSize = newStack.size();
    if (stackSize == 0){
      System.out.println("cant remove from an empty stack");
      return;
    }
    if (stackSize == 1){
      newStack.pop();
      return;
    }
    for (int i = 0; i < stackSize - 1; i++){
      tempStack.push(newStack.pop());
    }
    while (!tempStack.empty()){
      tempStackTwo.push(tempStack.pop());
    }
    this.newStack = tempStackTwo;

  }

  public T peek(){
    Stack<T> tempStackOne = newStack;
    Stack<T> peekStack = new Stack<>();
    if (newStack.size() == 1){
      return newStack.peek();
    }
    else if (newStack.size() == 0){
      return null;
    }
    for (int i = 0; i < newStack.size() - 1; i++){
      newStack.pop();
    }
    peekStack.push(newStack.pop());
    this.newStack = tempStackOne;

    return tempStackOne.peek();
  }
  public static void main(String[] args){
    StackedQueue stackedQ = new StackedQueue();


  }

}
