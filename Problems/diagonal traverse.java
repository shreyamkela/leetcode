class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int i=0, j=0;
        int r = matrix.length;
        int c = matrix[0].length;
        boolean up = true;
        int count = 0;
        
        int[] res = new int[r*c];
        
        while(i!=r && j!=c) {
            res[count++] = matrix[i][j];
            
            if(up) {
                if(i-1>=0 && j+1<c) {
                    i--;
                    j++;
                } else {
                    up = !up;
                    if(j+1<c) j++;
                    else i++;
                }
            } else {
                if(i+1<r && j-1>=0) {
                    i++;
                    j--;
                } else {
                    up = !up;
                    if(i+1<r) i++;
                    else j++;
                }
            }
            
            // System.out.println(res);
        }

     return res;   
    }
}