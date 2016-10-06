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

	protected final String print(int[][] matrix) {
		StringJoiner lineJoiner = new StringJoiner(lineSeparator);
		Arrays.stream(matrix).forEach(row -> lineJoiner.add(printRow(row)));
		return lineJoiner.toString();
	}
	
	private String printRow(int[] row) {
		StringJoiner elementJoiner = new StringJoiner(delimiter);
		Arrays.stream(row).forEach(element -> elementJoiner.add(String.valueOf(element)));
		return elementJoiner.toString();
	}
}
