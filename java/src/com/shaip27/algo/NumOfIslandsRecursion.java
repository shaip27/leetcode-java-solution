package com.shaip27.algo;

public class NumOfIslandsRecursion {
	
    public int findNumOfIslands(char[][] grid) {
    	
    	if(grid==null || grid.length==0 || grid[0].length==0)
    		return 0;
    	
    	int count=0;
    	
    	int h = grid.length;
    	int l = grid[0].length;
    	
    
    	
    	for(int i=0; i < h ; i ++) {
    		for(int j=0; j<l ; j++) {
    			if(grid[i][j]=='1') {
    				exploreIsland(grid, i ,j);
    				count++;
    			}
    			
    		}
    	}
    	

    	return count;
        
    }

	private void exploreIsland(char[][] grid, int row, int col) {
		
		int h = grid.length;
    	int l = grid[0].length;
    	
    	if(row <0 || col<0 || row >= h || col >= l  || grid[row][col]!='1') {
    		return;
    	}
    	
    	grid[row][col]='0'; //Marking visited
    	exploreIsland(grid, row+1,col);
    	exploreIsland(grid, row-1,col);
    	exploreIsland(grid, row,col+1);
    	exploreIsland(grid, row,col-1);
   
		
	}

	public static void main(String[] args) {
		
		
		
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}			
		};
		
		
		NumOfIslandsRecursion numOfIsland = new NumOfIslandsRecursion();
		System.out.println("Number of Island:" + numOfIsland.findNumOfIslands(grid));
		
		
		char[][] grid1 = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}			
		};
		System.out.println("Number of Island:" + numOfIsland.findNumOfIslands(grid1));

	}

}
