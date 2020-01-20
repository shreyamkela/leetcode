class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        
        int[][] savedPaths = new int[n][m];
        int downPaths, rightPaths;
    
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) { 
		// Let m = 6 and n = 2 for 7*3 grid. - m is between 0 to 6 and n is between 0 to 2 
	        // Starting from (m,n), we can reach (m,n) from (m,n) by 0 paths as we are already on that cell
	        // We can reach (m,n) from (m-1,n) or (m-2,n)...(0,n) by using total 1 path
		// We can reach (m,n) from (m,n-1) or (n,n-1)...(m,0) by using total 1 path
		// We can reach (m,n) from (m-1,n-1) by using total paths of (m-1,n) + (m,n-1) = 1+1 = 2
		// Similarly we can reach (m,n) from (m-2,n-1) by using total paths of (m-1,n-1) + (m-2,n) = 2 + 1 = 3, and so on and so forth

              if(i==n-1 && j==m-1) {
                  savedPaths[i][j] = 0;
              } else if ((i==n-1 && j!=m-1) || (i!=n-1 && j==m-1)) {
                  savedPaths[i][j] = 1;
              } else {
                  savedPaths[i][j] = savedPaths[i+1][j]+savedPaths[i][j+1]; 
		  
              }
            }
        }
        
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<m; j++) { 
        //         System.out.print(" " + savedPaths[i][j]);
        //     }
        //         System.out.println();
        // }
        
        return savedPaths[0][0];
    }
    
}