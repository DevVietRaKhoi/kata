import java.util.Arrays;
import java.util.StringJoiner;

public abstract class BaseMatrixPrinter {

  private String delimiter = " ";
  private String lineSeparator = "\n";

  public abstract void printMatrix(int[][] matrix);

  protected final void setDelimiter(String delimiter) {
    this.delimiter = delimiter;
  }

  protected final void setLineSeparator(String lineSeparator) {
    this.lineSeparator = lineSeparator;
  }

  /**
   * 
   * @param non-empty matrix of non-negative numbers
   * @return formatted String representation of input matrix
   */
  protected final String print(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      throw new IllegalArgumentException("Input matrix must be non-empty");
    
    if (Arrays.stream(matrix).mapToInt(row -> Arrays.stream(row).min().getAsInt()).min().getAsInt() < 0)
      throw new IllegalArgumentException("Input matrix must be non-negative");
    
    int spacePerElement = (int) Math.log10(Arrays.stream(matrix).mapToInt(row -> Arrays.stream(row).max().getAsInt()).max().getAsInt()) + 1;
    String format = "%" + spacePerElement + "d";
    StringJoiner lineJoiner = new StringJoiner(lineSeparator);
    Arrays.stream(matrix).forEach(row -> lineJoiner.add(printRow(row, format)));
    return lineJoiner.toString();
  }

  private String printRow(int[] row, String format) {
    StringJoiner elementJoiner = new StringJoiner(delimiter);
    Arrays.stream(row).forEach(element -> elementJoiner.add(String.format(format, element)));
    return elementJoiner.toString();
  }
}
