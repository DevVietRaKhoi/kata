public class SpiralMatrixGenerator {
  public int[][] generate(int rows, int cols) {
    if (rows <= 0 || cols <= 0)
      throw new IllegalArgumentException("Matrix rols/cols must be positive");

    int[][] matrix = new int[rows][cols];

    int layer = 0;
    int startElement = 1;
    while (layer <= rows/2 && layer <= cols/2)
      startElement = fillLayer(matrix, layer++, startElement);

    return matrix;
  }

  private int fillLayer(int[][] matrix, int layer, int startElement) {
    assert matrix.length > 0;
    assert matrix[0].length > 0;

    int rows = matrix.length;
    int cols = matrix[0].length;

    for (int i = layer; i <= cols-1-layer; i++)
      matrix[layer][i] = startElement++;

    for (int i = layer+1; i <= rows-1-layer; i++)
      matrix[i][cols-1-layer] = startElement++;

    if (layer < rows/2)
      for (int i = cols-layer-2; i >= layer; i--)
        matrix[rows-layer-1][i] = startElement++;

    if (layer < cols/2)
      for (int i = rows-layer-2; i > layer; i--)
        matrix[i][layer] = startElement++;

    return startElement;
  }
}
