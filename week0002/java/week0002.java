/**
 * Created by truon on 03/10/2016.
 */

public class week0002 {

    public static void main(String[] args) {

        int[][] array = new int[4][4];
        createSpiralRectangle(array);
        displayArray(array);

    }

    private static void createSpiralRectangle(int[][] array) {

        int row = array.length - 1;
        int col = array.length - 1;
        int value = 1;
        int flag = 0;   //flags to mark spirals

        while (flag <= array.length / 2) { //leg-(length/2) loops, pear-(int)(length/2 + 1) loops
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

    private static void displayArray(int[][] array) {

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array.length; col++) {
                System.out.print(array[row][col] + "\t");
            }
            if (row != array.length - 1) {
                System.out.print("\n \n");
            }
        }

    }

}
