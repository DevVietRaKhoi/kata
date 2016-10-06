public class ConsoleMatrixPrinter extends BaseMatrixPrinter {
  @Override
  public void printMatrix(int[][] matrix) {
    System.out.print(print(matrix));
  }
}
