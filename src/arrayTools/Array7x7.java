package arrayTools;

/**
 * Class which stores and manipulates a 
 * 2-D integer array that is 7 by 7
 *
 */
public class Array7x7 {
	private int[][] array;
	
	/**
	 * Creates an object with an empty array
	 */
	public Array7x7(){
		array = new int[7][7];
	}
	
	/**
	 * Creates an object with provided array
	 * 
	 * @param array Array to be used. Has to be 7*7.
	 * @throws Exception If array is wrong size.
	 */
	public Array7x7(int[][] array) throws Exception{
		if(array.length==7 && array[0].length==7){
			this.array = array;
		}else{
			throw new Exception("Incorrect array size");
		}
	}
	
	/**
	 * Sets a value in specified row and column
	 * 
	 * @param row Which row the element is  
	 * @param col Which column the element is
	 * @param value The value to be inserted
	 */
	public void setElement(int row, int col, int value){
		array[row][col] = value;
	}
	
	/**
	 * Returns the value in specified element
	 * 
	 * @param row Row where element exists
	 * @param col Column where element exists
	 * @return The value in specified element
	 */
	public int getElement(int row, int col){
		return array[row][col];
	}
}
