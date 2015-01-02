package project;

import javax.swing.JOptionPane;

import arrayTools.Array7;
import arrayTools.Array7x7;
import arrayTools.ArrayChars;

/**
 * @author Andreas & Pontus
 * Class TestColor creates a character 
 * Shifts it from center to right and then back to center
 */

public class TestColors extends Array7x7{
	private static Array7x7 arr77;
	private static Array7 arr7 = new Array7();

	int arrColor7x7 = Color.argb(1, 25, 70, 186);
	ColorDisplay d = new ColorDisplay(Color.BLACK, Color.CYAN);

	/**
	 * Reads all the elements and controls that if "1" occurs in an element
	 * the color of the element will be set to Black.
	 * We store the selected character, in this case "B", in an array.
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		ArrayChars chars = new ArrayChars();
		arr77 = chars.getChar('B');
		int a = Color.BLUE;
		for(int row = 0; row < 7; row++) {
			for(int col = 0; col < 7; col++) {
				if(arr77.getElement(row, col)==1){
					arr77.setElement(row, col, a);
				}
			}
		}
		/**
		 * Sets the background color to red and the borderline color to cyan.
		 * The character shifts first from center to left and then right.
		 */
		
		ColorDisplay d = new ColorDisplay(Color.RED, Color.CYAN);
		d.setDisplay(arr77.getArray());
		d.updateDisplay();
		JOptionPane.showMessageDialog(null,d);
	
		arr77.shiftContent(arr7, 1);		
		d.setDisplay(arr77.getArray());
		d.updateDisplay();
		JOptionPane.showMessageDialog(null,d);
		
		arr77.shiftContent(arr7, 2);		
		d.setDisplay(arr77.getArray());
		d.updateDisplay();
		JOptionPane.showMessageDialog(null,d);
	}
}
		
		
