import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpiralMatrixGeneratorTest {

  private final SpiralMatrixGenerator matrixGenerator = new SpiralMatrixGenerator();

  @Test(expected=IllegalArgumentException.class)
  public void testZeroMatrix_ZeroRows() {
    assertEquals(0, matrixGenerator.generate(0, 5).length);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testZeroMatrix_ZeroCols() {
    assertEquals(0, matrixGenerator.generate(5, 0).length);
  }

  @Test
  public void testSingleSquareMatrix() {		
    int[][] matrix = matrixGenerator.generate(1, 1);
    assertEquals(1, matrix.length);
    assertArrayEquals(new int[] {1}, matrix[0]);
  }

  @Test
  public void testEvenSquareMatrix() {		
    int[][] matrix = matrixGenerator.generate(4, 4);
    assertEquals(4, matrix.length);
    assertArrayEquals(new int[] {1,2,3,4}, matrix[0]);
    assertArrayEquals(new int[] {12,13,14,5}, matrix[1]);
    assertArrayEquals(new int[] {11,16,15,6}, matrix[2]);
    assertArrayEquals(new int[] {10,9,8,7}, matrix[3]);
  }

  @Test
  public void testOddSquareMatrix() {		
    int[][] matrix = matrixGenerator.generate(5, 5);
    assertEquals(5, matrix.length);
    assertArrayEquals(new int[] {1,2,3,4,5}, matrix[0]);
    assertArrayEquals(new int[] {16,17,18,19,6}, matrix[1]);
    assertArrayEquals(new int[] {15,24,25,20,7}, matrix[2]);
    assertArrayEquals(new int[] {14,23,22,21,8}, matrix[3]);
    assertArrayEquals(new int[] {13,12,11,10,9}, matrix[4]);
  }

  @Test
  public void testSingleRowMatrix() {
    int[][] matrix = matrixGenerator.generate(1, 5);
    assertEquals(1, matrix.length);
    assertArrayEquals(new int[] {1,2,3,4,5}, matrix[0]);
  }

  @Test
  public void testHorizontalMatrix() {
    int[][] matrix = matrixGenerator.generate(3, 5);
    assertEquals(3, matrix.length);
    assertArrayEquals(new int[] {1,2,3,4,5}, matrix[0]);
    assertArrayEquals(new int[] {12,13,14,15,6}, matrix[1]);
    assertArrayEquals(new int[] {11,10,9,8,7}, matrix[2]);
  }

  @Test
  public void testSingleColMatrix() {
    int[][] matrix = matrixGenerator.generate(5, 1);
    assertEquals(5, matrix.length);
    assertArrayEquals(new int[] {1}, matrix[0]);
    assertArrayEquals(new int[] {2}, matrix[1]);
    assertArrayEquals(new int[] {3}, matrix[2]);
    assertArrayEquals(new int[] {4}, matrix[3]);
    assertArrayEquals(new int[] {5}, matrix[4]);
  }

  @Test
  public void testVerticalMatrix() {
    int[][] matrix = matrixGenerator.generate(5, 3);
    assertEquals(5, matrix.length);
    assertArrayEquals(new int[] {1,2,3}, matrix[0]);
    assertArrayEquals(new int[] {12,13,4}, matrix[1]);
    assertArrayEquals(new int[] {11,14,5}, matrix[2]);
    assertArrayEquals(new int[] {10,15,6}, matrix[3]);
    assertArrayEquals(new int[] {9,8,7}, matrix[4]);
  }
}
