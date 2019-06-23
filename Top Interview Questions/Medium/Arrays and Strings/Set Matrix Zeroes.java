class Solution {
/*
Following the solution by user mzchen:
Refer - https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/discuss/26014/Any-shorter-O(1)-space-solution

Store states of each row in the first of that row, and store states of each column in the first of that column. Because the state of row0 and the state of column0 would occupy the same cell, I let it be the state of column0 and use another variable firstRow for row0. In the first phase, use matrix elements to set states in a top-down way. In the second phase, use states to set matrix elements in a bottom-up way.

*/
	    public static void setZeroes(int[][] matrix) {
	        if(matrix.length < 1) {
	            return;
	        }
            
            Boolean firstRow = true;

	        for(int i=0; i<matrix.length; i++) {
	            for(int j=0; j<matrix[0].length; j++) {
	                if(matrix[i][j] == 0) {
                        if(i == 0) {
                            firstRow = false;
                        } else {
                           matrix[i][0] = 0;
	                       matrix[0][j] = 0; 
                        }
	                }
	            }
	        }
	        
	        for(int k=matrix.length-1; k>=0; k--) {
	            for(int l=matrix[0].length-1; l>=0; l--) {
                    System.out.println(matrix[k][l] + " " + matrix[k][0] +  matrix[0][l]);
	                if((matrix[k][0] == 0 || matrix[0][l] == 0) && k!=0) {
	                    matrix[k][l] = 0;
	                }
                    if(k == 0 && firstRow == false) {
                        matrix[k][l] = 0;
                    }
	            }
	        }
	        return;
	    }
}