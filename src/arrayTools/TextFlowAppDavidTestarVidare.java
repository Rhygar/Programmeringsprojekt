package arrayTools;

import java.awt.*;

import javax.swing.*;

import project.Color;
import project.ColorDisplay;

import java.util.Timer;
import java.util.TimerTask;

public class TextFlowAppDavidTestarVidare extends JPanel {
	private static final long serialVersionUID = -2910434031371935286L; // Because of JPanel
	private final static int displaySize = 5;

	/**
	 * The main method asks for a string from the user and displays it character
	 * by character in a 7x7 grid.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Array7x7[] txtArrays;
		// An object with all possible characters
		ArrayChars chars = new ArrayChars();

		// An input window asking for a string
		String txt = JOptionPane.showInputDialog("Ange en text, bara STORA bokstäver, siffror och tecken");

		// An array of Array7x7 object to hold characters. 
		// The size of the array must be at least 5. 
		if (txt.length() < 4) {
			txtArrays = new Array7x7[5];
		} else {
			// The last position in array shall contain a space sign
			txtArrays = new Array7x7[txt.length() + 1];
		}
		
		// The display size and colors. (5*7) * 7 
		ColorDisplay d = new ColorDisplay(1, displaySize, Color.RED, Color.CYAN);

		// Inserts the graphical counterpart for each character
		// If the string is less than 4 it will be filled with space up to the fifth position.
		if (txt.length() > 4) {
			for (int i = 0; i < txt.length(); i++) {
				txtArrays[i] = chars.getChar(txt.charAt(i));
			}
			for (int j = txt.length(); j < txtArrays.length; j++) {
				txtArrays[j] = chars.getChar(' ');
			}
		} else {
			for (int i = 0; i < txt.length(); i++) {
				txtArrays[i] = chars.getChar(txt.charAt(i));
				// Last position will contain a space sign
				if(i == txtArrays.length - 2) {
					txtArrays[i+1] = chars.getChar(' ');
					i++;
				}
			}
		}
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(d);
		frame.pack();
		frame.setVisible(true);

		// New Timer object to delay each char 1 second
		Timer timer = new Timer();

		// TimerTask is an object, and requires a written class
		timer.schedule(new TimerTask() {

			Array7 arr;

			// A run() method is required
			@Override
			public void run() {

				// shifting the content to LEFT in all positions in Array7x7[].
				for (int p = 0; p < txtArrays.length; p++) {
					// each blocks last column will receive the next
					// blocks first column, unless it's the last block.
					// That one will receive the first blocks first
					// column.
					if (p == txtArrays.length - 1) {
						arr = txtArrays[0].getCol(0);
					} else {
						arr = txtArrays[p + 1].getCol(0);
					}
					txtArrays[p].shiftContent(arr, 1);
				}

				// the display is 5 blocks long. All elements containing value 1
				// will get a color different from background.
				for (int i = 0; i < displaySize; i++) {
					for (int row = 0; row < 7; row++) {
						for (int col = 0; col < 7; col++) {
							if (txtArrays[i].getElement(row, col) == 1) {
								txtArrays[i].setElement(row, col, Color.BLACK);
							}
						}
					}
					// sets up the display to show the new block.
					d.setDisplay(txtArrays[i].getArray(), 0, i);
				}
				// shows the new display
				d.updateDisplay();

			}
			// Initial delay and period in milliseconds
		}, 100, 100);
	}

}
