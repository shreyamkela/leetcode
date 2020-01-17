class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0, tempArea = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    tempArea = graphSearch(grid, i, j, tempArea);
                    if(tempArea > area) area = tempArea;
                    tempArea = 0;
                }
            }
        }
        
        return area;
    }
    
    private int graphSearch(int[][] grid, int row, int col, int tempArea) {

        if(grid[row][col] == 0) return tempArea;
        else  {
            grid[row][col] = 0;
            tempArea++;
        }
            
        if(row>0) tempArea = graphSearch(grid, row-1, col, tempArea);
        if(col<grid[0].length-1) tempArea = graphSearch(grid, row, col+1, tempArea);
        if(row<grid.length-1) tempArea = graphSearch(grid, row+1, col, tempArea);
        if(col>0) tempArea = graphSearch(grid, row, col-1, tempArea);
        
        return tempArea;

    }
}