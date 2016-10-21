public class week0002 {
	public static void main(String[] args) {
		printSpiralRectangle(7, 8);
	}

	public static void printSpiralRectangle (int m, int n){
		int[][] direction = new int[][] {{0, 1},{1, 0},{0, -1},{-1, 0}};
		int i = 0, j = 0, k = 0, l = 0;
		int[][] spiralArray = new int[m][n];

		for (int x = 1; x <= m*n; x++){
			spiralArray[i][j] = x;
			
			if(direction[k][0] == 0){
				if ((direction[k][1] == 1 && j == n - 1 - l) || (direction[k][1] == -1 && j == l)){
					k = (k + 1) % 4;
				}
			} else {
				if ((direction[k][0] == 1 && i == m - 1 - l) || (direction[k][0] == -1 && i == l + 1)) {
					if (k == 3) l++;
					k = (k + 1) % 4;
				}
			}

			i = i + direction[k][0];
			j = j + direction[k][1];
		}

		int numberLength = String.valueOf(m*n).length();

		for(int[] row : spiralArray) {
			for (int a = 0; a < row.length; a++) {
				if (a > 0)
					System.out.print(" ");
				String c = String.valueOf(row[a]);
				for (int b = 0; b < numberLength - c.length(); b++) {
					System.out.print(" ");
				}
				System.out.print(row[a]);
			}

			System.out.println();
		}
	}
}

