package com.shaip27.algo;

import java.util.Stack;

public class NumOfIslandsIterativeDFS {
	
	
	private int numberOfIsland(char[][] grid) {
		
		
		int row = grid.length;
		int col = grid[0].length;
		
		if(row==0) {
			return 0;
		}
		
		boolean[][] visited = new boolean[row][col];
		Stack<String> stack = new Stack<>();
		int count =0;
		for(int i=0; i< row; i++) {
			for(int j=0;j<col; j++) {
				if(!visited[i][j] && grid[i][j]=='1') {
					stack.push(i+","+j);
					exploreIsland(stack, grid,visited);
					count++;
				}
			}
			
		}
		return count;
	}

	private void exploreIsland(Stack<String> stack, char[][] grid, boolean[][] visited) {
				
		int h = grid.length;
		int l = grid[0].length;
		
		
		while(!stack.isEmpty()) {		
			
			String[] node = stack.pop().split(",");
			int row = Integer.parseInt(node[0]);
			int col = Integer.parseInt(node[1]);
			
	
			if(row < 0 || row >= h || col < 0 || col >= l || visited[row][col] || grid[row][col]!='1')
				continue;
			
			
			visited[row][col] = true;
			stack.push(row + "," + (col-1));
			stack.push(row + "," + (col+1));
			stack.push((row+1) + "," + col);
			stack.push((row-1) + "," + col);
			
		}
		
		
		
	}

	public static void main(String[] args) {
		
		char[][] grid = new char[][]{
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}			
		};
		
		
		NumOfIslandsIterativeDFS numOfIsland = new NumOfIslandsIterativeDFS();
		System.out.println("Number of Island:" + numOfIsland.numberOfIsland(grid));
		
		grid  = new char[][] {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}			
		};
		
		System.out.println("Number of Island:" + numOfIsland.numberOfIsland(grid));

	}

}
