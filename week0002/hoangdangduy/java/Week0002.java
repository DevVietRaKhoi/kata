package week0002;

public class Week0002 {
	public void Spiral(int M, int N){

		int[][] arr = new int[M][N];

		int upperLeftConrner = 0;
		int bottomLeftCorner = 0;
		int upperRightConrner = N - 1;
		int bottomRightCorner = M - 1;

		int numRun = 1;
		int i = 0, j = 0;

		if (M == 1) {
			for (int k = 1; k <= N; k++) {
				System.out.print(k + " ");
			}
			return;
		}

		if (N == 1) {
			for (int k = 1; k <= M; k++) {
				System.out.println(k);
			}
			return;
		}

		while (numRun <= (M * N)) {
			/*
			 * run from left to right
			 */
			while (j <= upperRightConrner && numRun <= (M * N)) {
				arr[i][j] = numRun++;
				// System.out.println(i + " - " + j + " - " + arr[i][j]);
				j++;
			}
			upperRightConrner--;
			j--;
			i++;

			/*
			 * run from above to below
			 */
			while (i <= bottomRightCorner && numRun <= (M * N)) {
				arr[i][j] = numRun++;
				// System.out.println(i + " - " + j + " - " + arr[i][j]);
				i++;
			}
			bottomRightCorner--;
			i--;
			j--;

			/*
			 * run from right to left
			 */
			while (j >= bottomLeftCorner && numRun <= (M * N)) {
				arr[i][j] = numRun++;
				// System.out.println(i + " - " + j + " - " + arr[i][j]);
				j--;
			}
			bottomLeftCorner++;
			i--;
			j++;

			/*
			 * run from below to above
			 */
			while (i > upperLeftConrner && numRun <= (M * N)) {
				arr[i][j] = numRun++;
				// System.out.println(i + " - " + j + " - " + arr[i][j]);
				i--;
			}
			i++;
			upperLeftConrner++;
			j++;
		}

		for (int temp1 = 0; temp1 < M; temp1++) {
			for (int temp2 = 0; temp2 < N; temp2++) {
				System.out.print(arr[temp1][temp2] + "   ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Week0002 week0002 = new Week0002();
		week0002.Spiral(1, 2);
	}
}
