package com.shaip27.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javafx.util.Pair;

public class NumOfDistinctIslandDFS {
	
	

	private void findDistinctIslands(int[][] grid) {
		
		int row = grid.length;
		int col = grid[0].length;
		
		if(row==0) {
			return;
		}
		
		boolean[][] visited = new boolean[row][col];
		
		
		List<ArrayList<Pair<Integer,Integer>>> allCoordinates = new ArrayList<>();
		Set<ArrayList<Pair<Integer,Integer>>> uniqueCoordinates = new HashSet<>();
		
		Stack<String> stack = new Stack<>();
		int count =0;
		for(int i=0; i< row; i++) {
			for(int j=0;j<col; j++) {
				if(!visited[i][j] && grid[i][j]==1) {
					stack.push(i+","+j);
					int x = i;
					int y = j;
					ArrayList<Pair<Integer,Integer>> coordinates = new ArrayList<>();
					exploreIsland(stack,grid,visited,x,y,coordinates);
					count++;
					uniqueCoordinates.add(coordinates);
					allCoordinates.add(coordinates);
				}
			}
			
		}
		
	
		System.out.println("All Coordinates list:" + allCoordinates);
		System.out.println("Unique Coordinates list:" + uniqueCoordinates);
		
		System.out.println("Total number of islands are: "+count);
		System.out.println("Total number of Distinct islands are: "+uniqueCoordinates.size());
		
		System.out.println("Finshed !!!");
		
		
	}

	private void exploreIsland(Stack<String> stack, int[][] grid, boolean[][] visited, int x, int y,
			ArrayList<Pair<Integer, Integer>> coordinates) {
		
		int h = grid.length;
		int l = grid[0].length;
		while(!stack.isEmpty()) {		
			
			String[] node = stack.pop().split(",");
			int row = Integer.parseInt(node[0]);
			int col = Integer.parseInt(node[1]);
			
	
			if(row < 0 || row >= h || col < 0 || col >= l || visited[row][col] || grid[row][col]==0)
				continue;
			
			
			coordinates.add(new Pair<>(row-x, col-y));
			visited[row][col] = true;
			stack.push(row + "," + (col-1));
			stack.push(row + "," + (col+1));
			stack.push((row+1) + "," + col);
			stack.push((row-1) + "," + col);
			
		}
		
	}

	public static void main(String[] args) {
		
		int[][] grid = new int[][]{
				{1, 1, 0, 1, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}};
		
		NumOfDistinctIslandDFS numOfDistinctIsland = new NumOfDistinctIslandDFS();
		numOfDistinctIsland.findDistinctIslands(grid);
		
		
		grid = new int[][] {
			{1,1,0,0,0},
			{1,1,0,1,1},
			{0,0,1,0,0},
			{0,0,0,1,1}};
			
		numOfDistinctIsland.findDistinctIslands(grid);

	}


}
