class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    graphSearch(grid, i, j);
                }
            }
        }
        
        return islands;
    }
    
    private void graphSearch(char[][] grid, int row, int col) {

        if(grid[row][col] == '0') return;
        else  grid[row][col] = '0';
            
        if(row>0) graphSearch(grid, row-1, col);
        if(col<grid[0].length-1) graphSearch(grid, row, col+1);
        if(row<grid.length-1) graphSearch(grid, row+1, col);
        if(col>0) graphSearch(grid, row, col-1);

    }
}