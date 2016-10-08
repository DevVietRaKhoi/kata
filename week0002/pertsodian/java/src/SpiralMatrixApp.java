public class SpiralMatrixApp {

  private final SpiralMatrixGenerator matrixGenerator;
  private final BaseMatrixPrinter matrixPrinter;

  public SpiralMatrixApp(SpiralMatrixGenerator matrixGenerator, BaseMatrixPrinter matrixPrinter) {
    this.matrixGenerator = matrixGenerator;
    this.matrixPrinter = matrixPrinter;
  }

  public void printSquareSpiralMatrixOfSize(int size) {
    matrixPrinter.printMatrix(matrixGenerator.generate(size, size));
  }

  public void printSpiralMatrixOfSize(int rows, int cols) {
    matrixPrinter.printMatrix(matrixGenerator.generate(rows, cols));
  }

  public void printUsage() {
    System.out.println("****************************");
    System.out.println("Usage: size/rows/cols >= 1");
    System.out.println("SpiralMatrixApp size");
    System.out.println("or");
    System.out.println("SpiralMatrixApp rows cols");
    System.out.println("****************************");
  }

  public static void main(String arg[]) {
    // TODO: add Options to configure element/line separator and OutPrinter

    SpiralMatrixGenerator matrixGenerator = new SpiralMatrixGenerator();
    BaseMatrixPrinter matrixPrinter = new ConsoleMatrixPrinter();		
    SpiralMatrixApp spiralMatrixApp = new SpiralMatrixApp(matrixGenerator, matrixPrinter);

    if (arg.length == 1) {
      try {
        int size = Integer.parseInt(arg[0]);
        if (size < 1)
          spiralMatrixApp.printUsage();
        else
          spiralMatrixApp.printSquareSpiralMatrixOfSize(size);
      }
      catch (NumberFormatException e) {
        spiralMatrixApp.printUsage();
      }
    }
    else if (arg.length == 2) {
      try {
        int rows = Integer.parseInt(arg[0]);
        int cols = Integer.parseInt(arg[1]);
        if (rows < 1 || cols < 1)
          spiralMatrixApp.printUsage();
        else
          spiralMatrixApp.printSpiralMatrixOfSize(rows, cols);
      }
      catch (NumberFormatException e) {
        spiralMatrixApp.printUsage();
      }
    }
    else
      spiralMatrixApp.printUsage();
  }
}
