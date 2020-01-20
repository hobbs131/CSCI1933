class Row{
  private Object[] objects;

  public Row(){
    objects = new Object[0];
  }
  public Object[] getRowObjects(){
    return objects;
  }
  // Adds converted values to objects which acts as row values.
  public void addValues(String[] insertValues, String[] valueTypes){
    int rowLength = insertValues.length;
    this.objects = new Object[rowLength];

    // Converts insertValues to respective valueType, adds to objects.
    for (int j = 0; j < rowLength; j++){
      if (valueTypes[j].equals("int")){
        int convertedInt = Integer.valueOf(insertValues[j]);
        objects[j] = convertedInt;
      }
      else if (valueTypes[j].equals("double")){
        double convertedDouble = Double.valueOf(insertValues[j]);
        objects[j] = convertedDouble;
      }
      else if (valueTypes[j].equals("boolean")){
        boolean convertedBoolean = Boolean.valueOf(insertValues[j]);
        objects[j] = convertedBoolean;
      }
      else {
        String stringToInsert = insertValues[j];
        objects[j] = stringToInsert;
      }
    }
  }

  public void loadColumnNames(String[] columnNames){
    int rowLength = columnNames.length;
    this.objects = new Object[rowLength];

    for (int i = 0; i < rowLength; i++){
      objects[i] = columnNames[i];
    }
  }
}
