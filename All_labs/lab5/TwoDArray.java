class TwoDArray{

  public static double [][] make2DArray (int row, int column){
    double[][] twoDArray = new double[row][column];
    int rowCount = 0;

    for(int i = 0; i < row; i++){
      for (int j = 0; j < column; j++){
        twoDArray[i][j] = rowCount + j;
      }
      rowCount++;
    }
    return twoDArray;
  }
  public static void main(String[] args){

    System.out.println(make2DArray(4,3));
  }
}
