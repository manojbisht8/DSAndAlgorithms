package recursion;

public class TowerOfHanoi {
	
	
	public static void towerOfHanoi(int diskNum, char fromPeg, char toPeg, char usingPeg) {
		
		if(diskNum == 1) { //1 peg can be moved fromPeg to toPeg
			System.out.println("Disc 1. From: "+fromPeg+ " To: "+toPeg);
			return;
		}
		
		//move n-1 from pegA to pegC
		towerOfHanoi(diskNum-1, fromPeg, usingPeg, toPeg);
		
		System.out.println("Disc: "+diskNum +" From: "+fromPeg+ " To: "+toPeg); //print step
		
		towerOfHanoi(diskNum-1, usingPeg, toPeg, fromPeg);
		
	}

	public static void main(String[] args) {
		towerOfHanoi(3, 'A', 'B', 'C');
	}

}
