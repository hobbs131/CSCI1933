import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

class Database {
  private Table[] tables;
  private InterpretedQuery[] interpretedQueries;
  private String[] tableNames;

  public Database(){
    tables = new Table[0];
    interpretedQueries = new InterpretedQuery[0];
  }
  public int getTables(){
    return tables.length;
  }

  public void create(String input){
    InterpretedQuery interpretedQuery = QueryEvaluator.evaluateQuery(input);
    InterpretedQuery[] tempQuery = new InterpretedQuery[interpretedQueries.length + 1];

    // Expands interpretedQueries to fit new query.
    for (int a = 0; a < interpretedQueries.length; a++){
      tempQuery[a] = interpretedQueries[a];
    }
    tempQuery[interpretedQueries.length] = interpretedQuery;
    this.interpretedQueries = tempQuery;

    // Checks to see if the table name already exists in database.
    for (int b = 0; b < interpretedQueries.length; b++){
      for (int c = b + 1; c < interpretedQueries.length; c++){
        if (interpretedQueries[b].getTableName().equals(interpretedQueries[c].getTableName())){
          System.out.println(interpretedQueries[b].getTableName() + " already exists");
          return;
        }
      }
    }
    // Checks to see if the query contains all unique column names.
    String[] columnNames = interpretedQuery.getColumnNames();
    for (int d = 0; d < columnNames.length; d++){
      for (int e = d + 1; e < columnNames.length; e++){
        if (columnNames[d].equals(columnNames[e])){
          System.out.println(columnNames[d] + " is not a unique column name");
          return;
        }
      }
    }
    // Checks to see if the query contains all valid types.
    String[] columnTypes = interpretedQuery.getColumnTypes();
    for (int f = 0; f < columnTypes.length; f++){
      if (!(columnTypes[f].equals("String") || columnTypes[f].equals("int") || columnTypes[f].equals("boolean") || columnTypes[f].equals("double"))){
        System.out.println(columnTypes[f] + " is not a valid type");
        return;
      }
    }
    // If all conditions are satisfied, the new table is created, first row is set to names and added to tables.
    Table[] tempTable = new Table[tables.length + 1];

    for (int i = 0; i < tables.length; i++){
      tempTable[i] = tables[i];
    }

    // When new table is created, column names/types are loaded into first/second row respectively.
    this.tables = tempTable;
    Table currentTable;
    tables[tables.length - 1] = new Table();
    currentTable = tables[tables.length - 1];
    currentTable.loadNameOrTypeRow(columnNames);
    currentTable.loadNameOrTypeRow(columnTypes);
  }

  public void insert(String input){
    InterpretedQuery interpretedQuery = QueryEvaluator.evaluateQuery(input);
    String[] insertValues = interpretedQuery.getInsertValues();

    // Finds index of table we want to insert into
    for (int i = 0; i < interpretedQueries.length; i++){
      if (interpretedQueries[i].getTableName().equals(interpretedQuery.getTableName())){
        String[] columnTypes = interpretedQueries[i].getColumnTypes();
        tables[i].addRow(insertValues,columnTypes);
        break;
      }
    }
  }
  public boolean load(String input){
    InterpretedQuery interpretedQuery = QueryEvaluator.evaluateQuery(input);
    InterpretedQuery[] tempQuery = new InterpretedQuery[interpretedQueries.length + 1];

    // Expands interpretedQueries to fit new query.
    for (int a = 0; a < interpretedQueries.length; a++){
      tempQuery[a] = interpretedQueries[a];
    }
    tempQuery[interpretedQueries.length] = interpretedQuery;
    this.interpretedQueries = tempQuery;
    String fileName = interpretedQuery.getFileName();
    Scanner s = null;
    try{
      s = new Scanner(new File(fileName));
    }
    catch (Exception e){
      return false;
    }
    // First two lines contain column names and types respectively
    String[] columnNames = s.nextLine().split(",");
    String[] columnTypes = s.nextLine().split(",");
    Table[] tempTable = new Table[tables.length + 1];

    // Resizes tables array
    for (int i = 0; i < tables.length; i++){
      tempTable[i] = tables[i];
    }
    this.tables = tempTable;

    // instantiates currentTable as last table.
    Table currentTable;
    tables[tables.length - 1] = new Table();
    currentTable = tables[tables.length - 1];

    // loads columnNames and column types to first and second row respectively
    currentTable.loadNameOrTypeRow(columnNames);
    currentTable.loadNameOrTypeRow(columnTypes);

    // Adds rest of rows and their values
    while(s.hasNextLine()){
      currentTable.addRow(s.nextLine().split(","), columnTypes);
    }
    return true;
  }

    public boolean store(String input){
      InterpretedQuery interpretedQuery = QueryEvaluator.evaluateQuery(input);
      String fileName = interpretedQuery.getTableName() + ".db";
      int tableIndex = 0;
      Scanner s = null;
      Object[] rowValues;

      try{
        s = new Scanner(new File(fileName));
      }
      catch (Exception e){
        return false;
      }

      PrintWriter p = null;
      try {
          p = new PrintWriter(new File(fileName));

          // Finds index of table to be stored
          for (int i = 0; i < interpretedQueries.length; i++){
            if (interpretedQueries[i].equals(interpretedQuery.getTableName())){
              tableIndex = i;
            }
          }
            // Prints the row values into csv file.
            for(int j = 0; j < tables[tableIndex].getRows(); j++){
              rowValues = tables[tableIndex].getCurrentRow(j).getRowObjects();
              for (int k = 0; k < rowValues.length; k++){
                p.print(rowValues[k] + ", ");
              }
              p.print("\r\n");
            }
          } catch (Exception e) {
          System.out.println("Error encountered while storing file " + fileName);
          return false;
    }
    p.close();
    return true;
  }

  public void print(String input){
    InterpretedQuery interpretedQuery = QueryEvaluator.evaluateQuery(input);
    String tableName = interpretedQuery.getTableName();
    Object[] rowValues;
    int tableIndex = 0;
    String table = "";

    // Finds index of table to print
    for (int i = 0; i < interpretedQueries.length; i++){
      if (interpretedQueries[i].getTableName().equals(tableName)){
        tableIndex = i;
      }
    }
    // Converts object values to string and concatenates to table string
    for(int j = 0; j < tables[tableIndex].getRows(); j++){
      rowValues = tables[tableIndex].getCurrentRow(j).getRowObjects();
      for (int k = 0; k < rowValues.length; k++){
        String stringRowValues = String.valueOf(rowValues[k]);
        table += stringRowValues + ", ";
      }
      table+= "\n";
    }
  System.out.println();
  System.out.println(table);
  }

  public void select(String input){
    InterpretedQuery interpretedQuery = QueryEvaluator.evaluateQuery(input);
    String tableName = interpretedQuery.getTableName();
    String[] selectColumnNames = interpretedQuery.getColumnNames();
    int tableIndex = 0;
    String[] columnNameAndConditional = interpretedQuery.getConditional().split(" ");
    String valuesToPrint = "";
    int conditionalIndex = 0;
    int[] selectedIndices = new int[selectColumnNames.length];
    int addedIndicesCount = 0;
    String logicalOperator = columnNameAndConditional[1];
    String condition = columnNameAndConditional[2];
    String[] columnTypes;
    Object[] rowValues;

    for(int i = 0; i < interpretedQueries.length; i++){
      if (interpretedQueries[i].getQueryType() == QueryType.LOAD_STATEMENT){
          if (interpretedQueries[i].getFileName().equals(tableName)){
            tableIndex = i;
            break;
          }
      }
      else{
        if(interpretedQueries[i].getTableName().equals(tableName)){
          tableIndex = i;
          break;
        }
      }
    }
    // Finds row index of conditional statement
    String[] columnNames = interpretedQueries[tableIndex].getColumnNames();
    for (int i = 0; i < columnNames.length; i++){
      if (columnNames[i].equals(columnNameAndConditional[0])){
        conditionalIndex = i;
      }
    }
    // Keeps track of the values of indices that should be printed.
    for (int j = 0; j < selectColumnNames.length; j++){
      for (int k = 0; k < columnNames.length; k++){
        if (selectColumnNames[j].equals(columnNames[k])){
          selectedIndices[addedIndicesCount] = k;
          addedIndicesCount++;
        }
      }
    }
    // Adds first two rows (names and types) to valuesToPrint
    for (int a = 0; a < 2; a++){
      rowValues = tables[tableIndex].getCurrentRow(a).getRowObjects();
      for(int b = 0; b < rowValues.length; b++){
        String firstOrSecondRowValues = String.valueOf(rowValues[b]);
        valuesToPrint += firstOrSecondRowValues + ", ";
      }
      valuesToPrint += "\n";
    }

    int rowCount = 2;
    columnTypes = interpretedQueries[tableIndex].getColumnTypes();
    String conditionalType = columnTypes[conditionalIndex];
    // Converts and concatenates row values to valuesToPrint
    // If the given indice of the row is a selectedIndice and conditional is met
    while (rowCount < tables[tableIndex].getRows()){
      if(tables[tableIndex].conditionalCheck(logicalOperator,condition, conditionalIndex, conditionalType, rowCount)){
        rowValues = tables[tableIndex].getCurrentRow(rowCount).getRowObjects();
        for (int l = 0; l < rowValues.length; l++){
          String stringRowValues = String.valueOf(rowValues[l]);
          for(int m = 0; m < addedIndicesCount; m++){
            if (selectedIndices[m] == l){
              valuesToPrint += stringRowValues + ", ";
            }
          }
        }
        valuesToPrint += "\n";
      }
      rowCount++;
    }
    System.out.println(valuesToPrint);
  }

  public void exit(){
    System.exit(0);
  }
}
