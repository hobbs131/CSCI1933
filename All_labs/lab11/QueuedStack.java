import java.util.PriorityQueue;

public class QueuedStack {
  private PriorityQueue queuedStack = new PriorityQueue();

  public void push(int element){
  queuedStack.add(element);
  }
  public boolean isEmpty(){
    if (queuedStack.size() == 0){
      return true;
    }
    return false;
  }
  public int pop(){
    PriorityQueue tempQueue = new PriorityQueue();
    PriorityQueue tempQueueTwo = new PriorityQueue();

    for (int i = 0; i < queuedStack.size() - 1; i++){
      tempQueue.add(queuedStack.poll());
    }
    tempQueueTwo.add(queuedStack.poll());
    this.queuedStack = tempQueue;
    return (int) tempQueueTwo.poll();
  }
  public int top(){
    PriorityQueue tempQueue = new PriorityQueue();
    PriorityQueue tempQueueTwo = queuedStack;
    for (int i = 0; i < tempQueueTwo.size() - 1; i++){
      tempQueue.add(tempQueueTwo.poll());
    }
    return (int) tempQueueTwo.poll();
  }
  public static void main(String[] args){
    QueuedStack newQueue = new QueuedStack();

  }
}
