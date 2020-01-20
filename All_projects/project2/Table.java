class Table{
  private Row[] rows;

  public Table(){
    rows = new Row[0];
  }
  public int getRows(){
    return rows.length;
  }
  public boolean conditionalCheck(String logicalOperator, String condition, int conditionalIndex, String conditionalType, int currentRow){
    // convert rowValues to string.
    Object[] rowObjects = rows[currentRow].getRowObjects();
    String[] rowValues = new String[rowObjects.length];
    for (int i = 0; i < rowObjects.length; i++){
      rowValues[i] = String.valueOf(rowObjects[i]);
    }
    // If statements for each conditionalType
    if (conditionalType.equals("String")){
      if(logicalOperator.equals("=")){
        if (rowValues[conditionalIndex].equals(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals("!=")){
        if(!rowValues[conditionalIndex].equals(condition)){
          return true;
        }
        else{
          return false;
        }
      }
    }
    else if(conditionalType.equals("boolean")){
      if(logicalOperator.equals("=")){
        if(rowValues[conditionalIndex].equals(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals("!=")){
        if(!rowValues[conditionalIndex].equals(condition)){
          return true;
        }
        else{
          return false;
        }
      }
    }
    else if(conditionalType.equals("double")){
      if(logicalOperator.equals("<=")){
        if (Double.valueOf(rowValues[conditionalIndex]) <= Double.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals("<")){
        if (Double.valueOf(rowValues[conditionalIndex]) < Double.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if (logicalOperator.equals("=")){
        if(Double.valueOf(rowValues[conditionalIndex]) == Double.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals("!=")){
        if(Double.valueOf(rowValues[conditionalIndex]) != Double.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals(">")){
        if(Double.valueOf(rowValues[conditionalIndex]) > Double.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals(">=")){
        if(Double.valueOf(rowValues[conditionalIndex]) >= Double.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
    }
    else if(conditionalType.equals("int")){
      if(logicalOperator.equals("<=")){
        if(Integer.valueOf(rowValues[conditionalIndex]) <= Integer.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }

      }
      else if(logicalOperator.equals("<")){
        if(Integer.valueOf(rowValues[conditionalIndex]) < Integer.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals("=")){
        if(Integer.valueOf(rowValues[conditionalIndex]) == Integer.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals("!=")){
        if(Integer.valueOf(rowValues[conditionalIndex]) != Integer.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals(">")){
        if(Integer.valueOf(rowValues[conditionalIndex]) > Integer.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
      else if(logicalOperator.equals(">=")){
        if(Integer.valueOf(rowValues[conditionalIndex]) >= Integer.valueOf(condition)){
          return true;
        }
        else{
          return false;
        }
      }
    }
    return true;
  }

  public Row getCurrentRow(int rowNumber){
    return rows[rowNumber];
  }

  // adds row(resizes rows) and passes insertValues and valueTypes to addValues
  public void addRow(String[] insertValues, String[] valueTypes){
    Row[] tempRows = new Row[rows.length + 1];
    for (int i = 0; i < rows.length; i++){
      tempRows[i] = rows[i];
    }
    this.rows = tempRows;
    Row currentRow;
    rows[rows.length - 1] = new Row();
    currentRow = rows[rows.length - 1];
    currentRow.addValues(insertValues, valueTypes);
    }

  public void loadNameOrTypeRow(String[] columnNames){
    Row[] tempRows = new Row[rows.length + 1];
    for (int i = 0; i < rows.length; i++){
      tempRows[i] = rows[i];
    }
    this.rows = tempRows;
    rows[rows.length - 1] = new Row();
    rows[rows.length - 1].loadColumnNames(columnNames);
  }
}
