import java.util.Scanner;
class Main{
  public static void main(String[] args){
    Database newDatabase = new Database();
    Scanner f = new Scanner(System.in);
    System.out.println();
    System.out.print(">");

    while(f.hasNextLine()){
      System.out.println();
      System.out.print(">");
      String input = f.nextLine();

      InterpretedQuery interpretedQuery = QueryEvaluator.evaluateQuery(input);
      if (interpretedQuery.getQueryType() == QueryType.CREATE_STATEMENT){
        newDatabase.create(input);
      }
      else if(interpretedQuery.getQueryType() == QueryType.INSERT_STATEMENT){
        newDatabase.insert(input);
      }
      else if(interpretedQuery.getQueryType() == QueryType.LOAD_STATEMENT){
        newDatabase.load(input);
      }
      else if(interpretedQuery.getQueryType() == QueryType.STORE_STATEMENT){
        newDatabase.store(input);
      }
      else if(interpretedQuery.getQueryType() == QueryType.PRINT_STATEMENT){
        newDatabase.print(input);
      }
      else if(interpretedQuery.getQueryType() == QueryType.SELECT_STATEMENT){
        newDatabase.select(input);
      }
      else{
        newDatabase.exit();
      }
    }
  }
}
