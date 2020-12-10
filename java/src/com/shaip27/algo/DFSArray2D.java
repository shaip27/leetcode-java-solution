package com.shaip27.algo;

import java.util.Stack;

public class DFSArray2D {

	public void dfs(int[][] grid) {

		int h = grid.length;
		if (h == 0) {
			System.out.println("Good Bye !!!");
			return;
		}
		int l = grid[0].length;

		boolean[][] visited = new boolean[h][l];

		Stack<String> stack = new Stack<>();

		stack.push(0 + "," + 0);

		while (!stack.isEmpty()) {

			String[] rowCol = stack.pop().split(",");
			int row = Integer.parseInt(rowCol[0]);
			int col = Integer.parseInt(rowCol[1]);
			

			if (row < 0 || col < 0 || row >= h || col >= l || visited[row][col])
				continue;

			visited[row][col] = true;
			System.out.print(grid[row][col] + " ");
			stack.push(row + "," + (col + 1));
			stack.push(row + "," + (col - 1));
			stack.push((row + 1) + "," + col);
			stack.push((row - 1) + "," + col);
			
		}
	}

	public static void main(String[] args) {

		DFSArray2D dfsTravsal = new DFSArray2D();

		int[][] grid = new int[][] { 
			{ 1, 2, 3, 4 }, 
			{ 5, 6, 7, 8 }, 
			{ 9, 10, 11, 12 }, 
			{ 13, 14, 15, 16 }
		};

		System.out.println("grid.length:" + grid.length);
		System.out.println("grid[0].length:" + grid[0].length);

		// Stack -> 1
		// pop 1 and push adjacent (2,5) - push 2, push 5
	
		// Stack -> 2,5
		// pop 5 -> push adjacent (6,9) - push 6, push 9 
	
		// Stack -> 2,6,9
		// pop 9 and push adjacent (10,13) - push 10, push 13
		
		// Stack -> 2,6,10,13
		// pop 13 and push adjacent (14) - push 14
		
		// Stack -> 2,6,10,14
		// pop 14 and push adjacent (10,15) push 15 push 10
		
		// Stack -> 2,6,15,10
		
		
		dfsTravsal.dfs(grid);

	}

}
