public class BiasedQueue{
  private String[] line;
  public BiasedQueue(){
    this.line = new String[0];
  }

  public void print(){
    if (line.length == 0){
      System.out.println("Queue is empty");
      return;
    }
    for(int i = 0; i < line.length; i++){
      System.out.println(line[i]);
    }
  }
  public void enqueue(String person){
    String[] tempString = new String[line.length + 1];

    if(person.equals("Budger")){
      for (int a = 0; a < line.length; a++){
        if (a == line.length - 1){
          tempString[a] = person;
          tempString[a + 1] = line[a];
          this.line = tempString;
          return;
        }
        tempString[a] = line[a];
      }
    }
    for (int i = 0; i < line.length; i++){
      tempString[i] = line[i];
    }
    tempString[tempString.length - 1] = person;
    this.line = tempString;
  }
  public void dequeue(){
    String[] tempString = new String[line.length - 1];



    if (line[0].equals("Budger")){
      for (int a = 1; a < line.length; a++){
        if (!line[a].equals("Budger")){
          for (int b = 0; b < line.length; b++){
            if (b == a){
              tempString[b] = line[b + 1];
              b++;
              while(b < tempString.length){
                tempString[b] = line[b + 1];
                b++;
              }
              break;
            }
            else{
              tempString[b] = line[b];
            }
          }
          break;
        }
        else {
          for (int c = 1; c < line.length; c++){
            tempString[c - 1] = line[c];
          }
        }
      }
    }
    else{
      for (int i = 1; i < line.length; i++){
        tempString[i - 1] = line[i];
      }
    }
    this.line = tempString;
  }

  public String peek(){
    return line[0];
  }

  public boolean isEmpty(){
    if (line.length == 0){
      return true;
    }
    return false;
  }
  public static void main(String[] args){
    BiasedQueue biasedQueue = new BiasedQueue();
    biasedQueue.enqueue("Budger");
    biasedQueue.enqueue("Budger");
    biasedQueue.dequeue();
    biasedQueue.dequeue();
    biasedQueue.print();

  }
}
