import java.lang.*;
import java.io.*;
import java.util.*;

public class week0002 {
    public static void main(String[] args) {
	int M = Integer.parseInt(args[0]);
	int N = Integer.parseInt(args[1]);
	// DIRECTIONS:  RIGHT   DOWN    LEFT     UP
	int[][] DIR = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

	// r: current row; c: current col; d: current direction
	int r = 0, c = 0, d = 0;
	// output matrix
	int[][] res = new int[M][N];
	// last number filled in
	int curr = 0;
	while(curr < M*N) {
	    ++curr;
	    res[r][c] = curr;
	    int newR = r + DIR[d][0];
	    int newC = c + DIR[d][1];
	    if(newR < 0 || newC < 0 || newR >= M || newC >= N || res[newR][newC] > 0)
	    {
		// change direction: out of bounds or hit outer "layer"
		d = (d+1) % DIR.length;
	    }
	    r = r + DIR[d][0];
	    c = c + DIR[d][1];
	}

	// pretty print
	int numLen = String.valueOf(M*N).length();
	for(int[] row : res) {
	    for(int i = 0; i < row.length; i++) {
		if(i > 0) System.out.print(" ");
		String s = String.valueOf(row[i]);
		for(int j = 0; j < numLen - s.length(); j++) {
		    System.out.print(" ");
		}
		System.out.print(row[i]);
	    }
	    System.out.println();
	}
    }
}
