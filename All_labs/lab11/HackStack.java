import java.util.Stack;

public class HackStack<T> {
  private Stack<T> newStack = new Stack<>();

  public void push(T element){
    newStack.push(element);
  }
  public T pop(){
    return newStack.pop();
  }
  public T pop(int n){
    Stack<T> tempStack = new Stack<>();
    Stack<T> tempStackTwo = new Stack<>();
    Stack<T> tempStackThree = newStack;
    int stackSize = newStack.size();

    if (n >= stackSize){
      return null;
    }

    for (int i = 0; i < stackSize; i++){
      if (i == n){
        tempStackTwo.push(tempStackThree.pop());
      }
      else{
        tempStack.push(tempStackThree.pop());
      }
    }
    this.newStack = tempStack;
    return tempStackTwo.pop();
  }
  public T peek(){
     return newStack.peek();
  }
  public static void main(String[] args){
    HackStack hackStack = new HackStack();
    hackStack.push(7);
    hackStack.push(9);
    hackStack.push(11);
    System.out.println(hackStack.pop(5));
  }
}
