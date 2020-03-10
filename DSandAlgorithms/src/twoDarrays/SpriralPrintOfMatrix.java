package twoDarrays;

import java.util.ArrayList;
import java.util.List;

public class SpriralPrintOfMatrix {
	
  public static List<Integer> spiralOrder(int[][] matrix) {
	  
	  List<Integer> result = new ArrayList<>();
	  
	  int rowStart = 0;
	  int rowEnd = matrix.length;
	  if(rowEnd == 0) {
		  return result; //empty matrix
	  }
	  int colStart =0;
	  int colEnd = matrix[0].length;
	  //consider boundaries (rowStart, colStart) TOP-LEFT to (rowEnd, colEnd) BOTTOM-RIGHT
	  
	  while(rowStart <= rowEnd && colStart <= colEnd) {
		  //print TOP-ROW
		  for(int i=colStart; i < colEnd; i++) {
			  result.add(matrix[rowStart][i]);
		  }
		  //print RIGHT-MOST-COL
		  for(int i=rowStart+1; i < rowEnd; i++) {
			  result.add(matrix[i][colEnd-1]);
		  }
		  
		  //check if bottom and left side is possible
		  if(rowStart < rowEnd && colStart < colEnd) {
			  //print BOTTOM-ROW
			  for(int i=colEnd-2; i > colStart; i--) {
				  result.add(matrix[rowEnd-1][i]);
			  }
			  //print LEFT-MOST-COL
			  for(int i=rowEnd-1; i > rowStart; i--) {
				  result.add(matrix[i][colStart]);
			  }
		  }
		  //adjust rows/cols
		  colStart++;
		  colEnd--;
		  rowStart++;
		  rowEnd--;
	  }
	  
	  return result;
	}

	public static void main(String[] args) {
		int[][] input = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
				};
		
		List<Integer> result = spiralOrder(input);
		
		result.forEach(System.out::println);

	}

}
