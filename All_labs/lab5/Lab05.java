import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class Lab05{
    public static double[][] makeMatrix(int row, int column) {
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

    public static boolean writeMatrixToFile(double[][] matrix, String fileName) {
        Scanner s = null;
        try{
          s = new Scanner(new File(fileName));
        }
        catch (Exception e){
          return false;
        }

        PrintWriter p = null;
        try {
            p = new PrintWriter(new File(fileName));
            int rows = matrix.length;
            int cols = matrix[0].length;
            for (int i = 0; i < rows; i++){
              for (int j = 0; j < cols; j++){
                p.print(matrix[i][j] + " ");
              }
              p.print("\r\n");
            }

            } catch (Exception e) {
            System.out.println("Houghton, we have a really big problem");
            return false;
        }
		// NOTE: when adding a line break to a string to be printed by the PrintWriter
		// use "\r\n" not "\n"
        p.close();
        return true;
    }
    public static void main (String[] args){
      double [][] newMatrix = makeMatrix(4,3);
      writeMatrixToFile(newMatrix,"output.txt");
    }
}
