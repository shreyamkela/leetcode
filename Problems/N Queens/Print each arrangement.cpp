import java.util.*;

public class Test1 {

	public static void main(String args[]) {
		
		int dimension = 8;
		
		int[][] chessboard = new int[dimension][dimension]; // No need to initialize with 0. In java lists are already initialized with 0
		
		// Here we move on each square on the chessboard, starting form row 0 and column 0. We check the current square if its index is present in any of the 4 Sets we have defined below.
		// If not present in all then only we make that square as 1 and then update all the 4 sets so that no square colliding with this square can be called valid
		// We move to each column in the current row then when all 8 places have been visited then we move to the next row
		// The basic algo used is recursion. We set the first square as 1 and then scan the whole chessboard for 8 valid queen placements
		// If the whole chessboard is scanned and 8 queens cannot be place then backtrack to the last queen placed and place it on the next square
		
		HashSet<Integer> memoRow = new HashSet<Integer>(); //When the square is made 1, update row set so that no other square in the same row is made 1
		HashSet<Integer> memoCol = new HashSet<Integer>(); //Update column set so that no other square in the same column is made 1
		HashSet<Integer> memoDiag1 = new HashSet<Integer>(); //Update diag1 set so that no other square in the same diag1 is made 1
		HashSet<Integer> memoDiag2 = new HashSet<Integer>(); //Update diag2 set so that no other square in the same diag2 is made 1
		//We need 4 sets, so that when we backtrack and remove stuff from our the sets, no removal in 1 set affects the other set
		//If same set is used to store row column diag1 and diag2 positions then when we remove 1 entry from set on backtracking, it could be possible that the entry being removed was made by some other queen
		//To avoid this kind of confusion, we isolate the 4 kinds of set
		
		int row = 0;
		//we use a for loop to traverse each column in the current row. Therefore no need to pass column as parameter. 
		//we only keep track of the rows
		queen(chessboard, dimension, memoRow, memoCol, memoDiag1, memoDiag2, row, 0);
		

	
		
	}
	
	public static void queen(int chessboard[][], int dimension, HashSet<Integer> memoRow, HashSet<Integer> memoCol, HashSet<Integer> memoDiag1, HashSet<Integer> memoDiag2, int row, int count) {
		
		if(count>=dimension) { // if all queens placed
			
			System.out.println("Found");
			for(int i=0; i<dimension; i++) {
				for(int j=0; j<dimension; j++) {
					System.out.print(chessboard[i][j] + " ");
				}
				System.out.print("\n");
			}
			
			//HOW TO KEEP A COUNT OF TOTAL VALID ARRANGEMENTS in java?
			return;
		}
		
		for(int column=0; column<dimension; column++) { // scan all columns of the current row
			
			
			int row1=row,column1=column; // temp variables to store current row and column
			// Used in backtracking, so when the recursion returns, the state can be reverted back to current state.
			// In java we need these temp variables as the row is being passed as parameter so its object is getting updated on each recursion and so it does not get reverted back to current state when recursion call returns
			// Therefore, we have to explicitly revert the state of row
			// There is probably no need for column temp as column is not being passed as parameter and the its state remains same when the recursion call returns as the column has been defined INSIDE the queen function
			// So each recursive queen has its own column variable
			// But Column temp variable is still used just to be safe
			
			if(!memoRow.contains(row) && !memoCol.contains(column) && !memoDiag1.contains(row-column) && !memoDiag2.contains(row+column)) { //if current square is not present in row set, column set, diag1 set and diag2 set then it is valid and can be made 1
				chessboard[row][column] = 1;
				count++;
				memoRow.add(row); 
				memoCol.add(column);
				memoDiag1.add(row-column); //adding this single entry makes all the square in this diagonal as invalid
				memoDiag2.add(row+column); //adding this single entry makes all the square in this diagonal as invalid
				queen(chessboard, dimension, memoRow, memoCol, memoDiag1, memoDiag2, row+1, count); // if queen placed in the current row, move to the next row

			}
			
			row=row1; // reverting back the state after recursive call returns
			column=column1; // reverting back the state after recursive call returns
			
			//Backtrack
			if(chessboard[row][column] == 1) {   //If the current square was made 1 then make it back to 0 and revert all the changes in state
				chessboard[row][column] = 0;
				count--;
				memoRow.remove(row); 
				memoCol.remove(column);
				memoDiag1.remove(row-column); 
				memoDiag2.remove(row+column); 
			}
			
			//if(column == (dimension-1))	return;	
		}
		return;	 // If we have traversed the last column in the current row, then return 
		
	} 
	
}
