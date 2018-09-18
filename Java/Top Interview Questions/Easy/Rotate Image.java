import java.util.HashMap;

class Test {
    public static void main(String[] args) {

    	int [][] matrix =   {
    						 {1 ,2 ,3 ,4 ,5 },
    					     {6 ,7 ,8 ,9 ,10},
    					     {11,12,13,14,15},
    					     {16,17,18,19,20},
    					     {21,22,23,24,25}
    					    				 };
    	/* loop i=0 j=0 (LAYER 1)
    	 * 
    	 * 1---2nd--->5--1st Step---->Temp
    	 * ^       						          |
    	 * |         					          |
    	 * 3rd						   	          |
    	 * |	     					            |
    	 * 21<--4th--25<----5th----------
    	 * 	   
    	 */
        int temp, rowLimit, columnLimit;
        int layer = (matrix[0].length)/2;
        int limit = (matrix[0].length-1);
        
        for(int i=0; i<layer; i++) {
        	
        	columnLimit = limit-i;
        	for(int j=i; j<columnLimit; j++) {
        			
        			rowLimit = limit - j;
        			
        			temp = matrix[j][columnLimit];
                    matrix[j][columnLimit] = matrix[i][j];   
                    matrix[i][j] = matrix[rowLimit][limit - columnLimit];
                    matrix[rowLimit][limit - columnLimit] = matrix[columnLimit][rowLimit];
                    matrix[columnLimit][rowLimit] = temp;
        	}

        }
        
        for(int a=0; a<matrix[0].length; a++) {
        	for(int b=0; b<matrix[0].length; b++) {
        		System.out.print(matrix[a][b]);
        		System.out.print(" ");
        	}
        System.out.println();
        }
        
    }
}

