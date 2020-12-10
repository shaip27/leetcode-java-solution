package com.shaip27.algo;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslandsIterativeBFS {
	

	private int numberOfIsland(char[][] grid) {
		
		int row = grid.length;
		if(row==0){
			return 0;
		}
		
		int col = grid[0].length;
		
		boolean[][] visited = new boolean[row][col];
		
		Queue<String> queue = new LinkedList<>();
		 
		int islandCount = 0; 
		
		for(int i=0 ;i < row; i ++) {
			
			for(int j=0;j<col;j++) {
				
				if(!visited[i][j] && grid[i][j]=='1') {
					queue.add(i + "," + j);
					exploreIslandBFS(queue, grid, visited);
					islandCount++;
				}
				
			}
		}
		
		return islandCount;
	}


	private void exploreIslandBFS(Queue<String> queue, char[][] grid, boolean[][] visited) {
		
		int height = grid.length;
		int length = grid[0].length;
		
		while(!queue.isEmpty()) {
			
			String[] node = queue.poll().split(",");
			int row = Integer.parseInt(node[0]);
			int col = Integer.parseInt(node[1]);
			
			
			if(row<0 || row >= height || col<0 || col >= length || visited[row][col] || grid[row][col]!='1')
				continue;
			
			visited[row][col]= true;
			
			queue.add(row + "," + (col+1));
			queue.add(row + "," + (col-1));
			queue.add((row+1) + "," + col);
			queue.add((row-1) + "," + col);
			
		}
		
		
		
		
	}


	public static void main(String[] args) {
		
		char[][] grid = new char[][]{
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}			
	};
	
	
	NumOfIslandsIterativeBFS numOfIsland = new NumOfIslandsIterativeBFS();
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
