package com.shaip27.algo;

import java.util.LinkedList;
import java.util.Queue;

public class BFSArray2D {
	
	
	public void bfs(int[][] grid) {
		
		
		int h = grid.length;
		if(h==0) {
			System.out.println("Good Bye !!!");
			return;
		}
		int l = grid[0].length;
		
		boolean[][] visited = new boolean[h][l];
		
		Queue<String> queue = new LinkedList<>();
		
		queue.add(0+","+0);
		
		
		while(!queue.isEmpty()) {
			
			
			String[] rowCol = queue.poll().split(",");
			int row = Integer.parseInt(rowCol[0]);
			int col = Integer.parseInt(rowCol[1]);
			
			
			if(row < 0 || col < 0 || row>= h || col >= l || visited[row][col])
				continue;
			
			
			visited[row][col] = true;
			System.out.print(grid[row][col] + " ");
			queue.add(row + "," + (col+1));
			queue.add(row + "," + (col-1));
			queue.add((row+1) + "," + col);
			queue.add((row-1) + "," + col);
			
			
			
		}
		
	}

	public static void main(String[] args) {
		
		
		BFSArray2D bfsTravsal = new BFSArray2D();
		
		
		int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
                
                
        System.out.println("grid.length:" + grid.length);
        System.out.println("grid[0].length:" + grid[0].length);
                
        // 1->2 and 1->5 trasaval
        // Queue -> 1,2,5
        // remove 1 -> Queue = 2,5
        // Element 2 is connected with 1,3,6 however 1 is already visited, insert 3,6 into Queue
        // Queue 2,5,3,6
        // remove 2 -> Queue = 5,3,6
        // Element 5 is connected to 6,9 however 6 is already visited, insert 9
        // Queue 5,3,6,9
        // remove 5 -> Queue = 3,6,9
        // Element 3 is connected to 2,4,7 however 2 is already visited, insert 4,7
        // Queue 3,6,9,4,7
        // remove 3 -> Queue = 6,9,4,7        
        bfsTravsal.bfs(grid);

	}

}
