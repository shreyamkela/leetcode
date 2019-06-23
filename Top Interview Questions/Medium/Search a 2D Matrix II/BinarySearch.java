public class Test1 {
	
	public static boolean searchMatrix(int[][] matrix, int target)
    {
		
		boolean found = false;
        int mid, start, end;
        for(int i=0; i<matrix.length; i++)
        {
        	if(matrix[0].length==0)
        		return false;
            if(matrix[i][0]>target || matrix[i][matrix[0].length-1]<target)
                continue;
            else
            {
                //Binary Search in that row
                start = 0;
                end = matrix[0].length-1;
                mid = (start+end)/2;
                
                while(start<=end)
                {
                	//System.out.println("hey" + i + " " + start + " " + mid + " " + end);
                    if(matrix[i][mid]==target)
                    {
                        found = true;
                        break;
                    }
                    else if(matrix[i][mid]>target)
                    {
                        end = mid-1;
                    }
                    else
                    {
                        start = mid+1;
                    }
                    
                    mid = (start+end)/2;
//                    if(matrix[i][mid]==target)
//                    {
//                        found = true;
//                        break;
//                    }    
                    //System.out.println(i + " " + start + " " + mid + " " + end + " " + found);
                    
                }
                
            }
            if(found == true)
                break;
        }
      
        return found;
    }
      
	public static void main(String[] args) {	

		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
				
		
		System.out.println(searchMatrix(matrix, 5));
	}	
}