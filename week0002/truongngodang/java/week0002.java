/**
 * Created by truon on 03/10/2016.
 */

public class week0002 {

    public static void main(String[] args) {
        int[][] array = new int[4][4];
//        createSpiralSquare(array);
        createSprialRectangle(array, 1);// 1: start form 1;
        displayArrayToConsole(array);
    }

    private static void createSpiralSquare(int[][] array) {
        int row = array.length - 1;
        int col = array.length - 1;
        int value = 1;
        int flag = 0;

        while (flag <= array.length / 2) {
            // Draw top row
            for (int colTop = flag; colTop <= col; colTop++) {
                array[flag][colTop] = value;
                value++;
            }
            // Draw right col
            for (int rowRight = flag + 1; rowRight <= row; rowRight++) {
                array[rowRight][col] = value;
                value++;
            }
            // Draw bottom row
            for (int colBottom = col - 1; colBottom >= flag; colBottom--) {
                array[row][colBottom] = value;
                value++;
            }
            // Draw left col
            for (int rowLeft = row - 1; rowLeft >= flag + 1; rowLeft--) {
                array[rowLeft][flag] = value;
                value++;
            }
            flag++;
            row--;
            col--;
        }
    }

    private static void createSprialRectangle(int[][] array, int numStart) {
        drawTopRight(array, numStart, 0, array[0].length - 1, 0, array.length - 1);
    }

    private static void drawTopRight(int[][] matrix, int numStart, int x1, int x2, int y1, int y2) {
        for (int col = x1; col <= x2; col++) {
            matrix[y1][col] = numStart++;
        }
        for (int row = y1 + 1; row <= y2; row++) {
            matrix[row][x2] = numStart++;
        }
        if (x2 - x1 > 0 && y2 - y1 > 0) {
            y1++;
            x2--;
            drawBottomLeft(matrix, numStart, x1, x2, y1, y2);
        }
    }

    private static void drawBottomLeft(int[][] matrix, int numStart, int x1, int x2, int y1, int y2) {
        for (int col = x2; col >= x1 ; col--) {
            matrix[y2][col] = numStart++;
        }
        for (int row = y2 - 1; row >= y1 ; row--) {
            matrix[row][x1] = numStart++;
        }
        if (x2 - x1 > 0 && y2 - y1 > 0) {
            x1++;
            y2--;
            drawTopRight(matrix, numStart,x1, x2, y1, y2);
        }
    }

    private static void displayArrayToConsole(int[][] array) {
        int numberLength = String.valueOf(array.length * array[0].length).length();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0)
                    System.out.print(" ");
                String s = String.valueOf(row[i]);
                for (int j = 0; j < numberLength - s.length(); j++) { // replace null == space, one char has three slot.
                    System.out.print(" ");
                }
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }
}
