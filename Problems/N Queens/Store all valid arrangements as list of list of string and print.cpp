import java.util.*;

public class Test1 {

	public static void main(String args[]) {
		
		int dimension = 4;
		
		int[][] chessboard = new int[dimension][dimension];
		
		HashSet<Integer> memoRow = new HashSet<Integer>(); 
		HashSet<Integer> memoCol = new HashSet<Integer>(); 
		HashSet<Integer> memoDiag1 = new HashSet<Integer>(); 
		HashSet<Integer> memoDiag2 = new HashSet<Integer>(); 
		int row = 0;
		
		List<List<String>> list = new ArrayList<List<String>>();
		
		queen(chessboard, dimension, memoRow, memoCol, memoDiag1, memoDiag2, row, 0, list);
		
		System.out.println(list); // Can directly println lists in java
	}
	
	public static void queen(int chessboard[][], int dimension, HashSet<Integer> memoRow, HashSet<Integer> memoCol, HashSet<Integer> memoDiag1, HashSet<Integer> memoDiag2, int row, int count, List<List<String>> list) {
		
		if(count>=dimension) {
			String rowString = "";// Store a row of present chessboard as string
			List<String> thisBoard = new ArrayList<String>(); // Store the present chessboard as string
			System.out.println("Found");
			for(int i=0; i<dimension; i++) {
				for(int j=0; j<dimension; j++) {
					if(chessboard[i][j]==0) {
						rowString+=".";
					}
					else if(chessboard[i][j]==1) {
						rowString+="Q";
					}
				}
				thisBoard.add(rowString);
				rowString = ""; // revert rowString to empty to store the next row
				//System.out.print("\n");
			}
			list.add(thisBoard);
			
			//HOW TO KEEP A COUNT OF TOTAL VALID ARRANGEMENTS?
			return;
		}
		
		for(int column=0; column<dimension; column++) {
			
			
			int row1=row,column1=column;
			
			if(!memoRow.contains(row) && !memoCol.contains(column) && !memoDiag1.contains(row-column) && !memoDiag2.contains(row+column)) {
				chessboard[row][column] = 1;
				count++;
				memoRow.add(row); 
				memoCol.add(column);
				memoDiag1.add(row-column); 
				memoDiag2.add(row+column); 
				queen(chessboard, dimension, memoRow, memoCol, memoDiag1, memoDiag2, row+1, count, list);

			}
			
			row=row1;
			column=column1;
			
			if(chessboard[row][column] == 1) {   
				chessboard[row][column] = 0;
				count--;
				memoRow.remove(row); 
				memoCol.remove(column);
				memoDiag1.remove(row-column); 
				memoDiag2.remove(row+column); 
			}
			
			if(column == (dimension-1))	return;	
		}
		return;	
		
	} 
	
}
