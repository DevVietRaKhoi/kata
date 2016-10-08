import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BaseMatrixPrinterTest {

  private final BaseMatrixPrinter matrixPrinter = new ConsoleMatrixPrinter();
  
  @Rule
  public final ExpectedException expectedException = ExpectedException.none();
  
  @Test
  public void testInvalidMatrix_ZeroRows() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Input matrix must be non-empty");
    matrixPrinter.print(new int[0][5]);
  }
  
  @Test
  public void testInvalidMatrix_ZeroCols() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Input matrix must be non-empty");
    matrixPrinter.print(new int[5][0]);
  }
  
  @Test
  public void testInvalidMatrix_Negative() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Input matrix must be non-negative");
    
    int[][] matrix = new int[2][];
    matrix[0] = new int[] {1};
    matrix[1] = new int[] {-1};
    matrixPrinter.print(matrix);
  }
  
  @Test
  public void testSingleDigit() {
    String expected = "1 2 3\n8 9 4\n7 6 5";
    int[][] matrix = new int[3][];
    matrix[0] = new int[] {1,2,3};
    matrix[1] = new int[] {8,9,4};
    matrix[2] = new int[] {7,6,5};
    assertEquals(expected, matrixPrinter.print(matrix));
  }
  
  @Test
  public void testDoubleDigit() {
    String expected = " 1  2  3  4\n12 13 14  5\n11 16 15  6\n10  9  8  7";
    int[][] matrix = new int[4][];
    matrix[0] = new int[] {1,2,3,4};
    matrix[1] = new int[] {12,13,14,5};
    matrix[2] = new int[] {11,16,15,6};
    matrix[3] = new int[] {10,9,8,7};
    assertEquals(expected, matrixPrinter.print(matrix));
  }
  
  @Test
  public void testMixDigit() {
    String expected = "  11    2  333    0\n1234   13  145    5";
    int[][] matrix = new int[2][];
    matrix[0] = new int[] {11,2,333,0};
    matrix[1] = new int[] {1234,13,145,5};
    assertEquals(expected, matrixPrinter.print(matrix));
  }
}
