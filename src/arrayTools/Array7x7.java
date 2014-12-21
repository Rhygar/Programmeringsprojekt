package arrayTools;

import com.sun.javafx.collections.SetAdapterChange;

/**
 * Class which stores and manipulates a 2-D integer array that is 7 by 7
 */
public class Array7x7 {
	private static final int LEFT = 1;
	private static final int RIGHT = 2;
	private int[][] array;

	/**
	 * Creates an object with an empty array
	 */
	public Array7x7() {
		array = new int[7][7];
	}

	/**
	 * Creates an object with provided array
	 * 
	 * @param array
	 *            Array to be used. Has to be 7*7.
	 * @throws Exception
	 *             If array is wrong size.
	 */
	public Array7x7(int[][] array) throws Exception {
		if (array.length == 7 && array[0].length == 7) {
			for(int i = 0; i < array.length; i++){
				this.array[i] = array[i].clone();
			}
		} else {
			throw new Exception("Incorrect array size");
		}
	}

	/**
	 * Sets a value in specified row and column
	 * 
	 * @param row
	 *            Which row the element is
	 * @param col
	 *            Which column the element is
	 * @param value
	 *            The value to be inserted
	 */
	public void setElement(int row, int col, int value) {
		array[row][col] = value;
	}

	/**
	 * Returns the value in specified element
	 * 
	 * @param row
	 *            Row where element exists
	 * @param col
	 *            Column where element exists
	 * @return The value in specified element
	 */
	public int getElement(int row, int col) {
		return array[row][col];
	}

	/**
	 * Sets specified row with values given in the passed Array7 object
	 * 
	 * @param row
	 *            Which row to manipulate
	 * @param theRow
	 *            An Array7 object with the values
	 */
	public void setRow(int row, Array7 theRow) {
		array[row] = theRow.getArray();
	}

	/**
	 * Returns a specified row of values in an Array7 object
	 * 
	 * @param row
	 *            Which row to return
	 * @return An Array7 object with the values
	 * @throws Exception
	 *             ???
	 */
	public Array7 getRow(int row) throws Exception {
		return new Array7(array[row]);
	}

	/**
	 * Sets specified column with values given in the passed Array7 object
	 * 
	 * @param col
	 *            Which column to manipulate
	 * @param theCol
	 *            An Array7 object with the values
	 */
	public void setCol(int col, Array7 theCol) {
		int[] array = theCol.getArray();

		for (int i = 0; i < 7; i++) {
			this.array[i][col] = array[i];
		}
	}

	/**
	 * Returns a specified column of values in an Array7 object
	 * 
	 * @param col
	 *            Which column to return
	 * @return An Array7 object with the values
	 * @throws Exception
	 *             ???
	 */
	public Array7 getCol(int col) throws Exception {
		int[] array = new int[7];

		for (int i = 0; i < 7; i++) {
			array[i] = this.array[i][col];
		}

		return new Array7(array);
	}
	
	/**
	 * Gets the whole 2d array
	 * 
	 * @return The whole 2d array
	 */
	public int[][] getArray(){
		return array;
	}

	/**
	 * Shifts the array one column in chosen direction and inserts provided
	 * Array7 in "empty" column. Returns the column that is "pushed" out.
	 * 
	 * @param colReplace
	 *            The column that should be injected from the right
	 * @param direction
	 *            Constant from the class, either RIGHT, or LEFT
	 * @return The "lost" column as an Array7 object
	 * @throws Exception
	 *             ???
	 */
	public Array7 shiftContent(Array7 colReplace, int direction)
			throws Exception {
		Array7 array = null;

		if (direction == LEFT) {
			// Stores the leftmost column in an Array7
			array = getCol(0);			

			// Shifts the content to the left
			for(int col = 0; col < 6; col++){
				setCol(col, getCol(col+1));
			}
			
			// Inserts provided column to the far right
			setCol(6, colReplace);
		} else if (direction == RIGHT) {
			
			// Stores the rightmost column in an Array7
			array = getCol(6);

			// Shifts the content to the right
			for(int col = 6; col > 0; col--){
				setCol(col, getCol(col-1));
			}
			// Inserts provided column to the far left
			setCol(0, colReplace);
		}

		return array;
	}	
}
