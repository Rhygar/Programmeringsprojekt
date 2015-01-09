package arrayTools;

import java.awt.*;

import javax.swing.*;

import project.Color;
import project.ColorDisplay;

import java.util.Timer;
import java.util.TimerTask;

public class TextFlow extends JPanel {

	private final static int displaySize = 5;
	Array7x7[] txtArray;
	ArrayChars chars = new ArrayChars();
	ColorDisplay d = new ColorDisplay(1, displaySize, Color.RED, Color.CYAN);	// The display size and colors. 35*7 blocks

	/**
	 * run the necessary methods to start program
	 */

	public void run() {
		setString();
		showDisplay();
		rollText();
	}

	/**
	 * Lets the user insert a string and creates an array holding the
	 * characters. All strings will have a space sign added as last element.
	 * Array must be at least 5 elements long. If string input is shorter rest
	 * of elements will be filled with space signs.
	 */
	public void setString() {
		// An input window asking for a string
		String txt = JOptionPane.showInputDialog("Ange en text med bokstäver, siffror och tecken");

		// An array of Array7x7 object to hold characters.
		// The size of the array must be at least 5.
		if (txt.length() < 4) {
			txtArray = new Array7x7[5];
		} else {
			// The last position in array shall contain a space sign
			txtArray = new Array7x7[txt.length() + 1];
		}

		// Inserts the graphical counterpart for each character
		// If the string is less than 4 it will be filled with space up to the
		// fifth position.
		if (txt.length() < 4) {
			for (int i = 0; i < txt.length(); i++) {
				txtArray[i] = new Array7x7(ArrayChars.getChar(txt.charAt(i)).getArray());
			}
			for (int j = txt.length(); j < txtArray.length; j++) {
				txtArray[j] = new Array7x7(ArrayChars.getChar(' ').getArray());
			}
		} else {
			for (int i = 0; i < txtArray.length; i++) {
				txtArray[i] = new Array7x7(ArrayChars.getChar(txt.charAt(i)).getArray());
				// Last position will contain a space sign
				if (i == txtArray.length - 2) {
					txtArray[i + 1] = new Array7x7(ArrayChars.getChar(' ').getArray());
					i++;
				}
			}
		}
	}

	/**
	 * Generates a JFrame to show the ColorDisplay
	 */
	public void showDisplay() {
		JFrame frame = new JFrame("Floating text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(d);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Letting the text roll through the display with a timer. 
	 */
	public void rollText() {
		// New Timer object to generate dalays
		Timer timer = new Timer();

		// TimerTask is an object, and requires a written class
		timer.schedule(new TimerTask() {

			Array7 arr;

			// A run() method is required
			public void run() {

				// shifting the content to LEFT in all positions in Array7x7[].
				for (int p = 0; p < txtArray.length; p++) {
					// Each blocks last column will receive the next
					// blocks first column, unless it's the last block.
					// That one will receive the first blocks first column.
					if (p == txtArray.length - 1) {
						arr = txtArray[0].getCol(0);
					} else {
						arr = txtArray[p + 1].getCol(0);
					}
					txtArray[p].shiftContent(arr, 1);
				}
				// the display is 5 blocks long. All elements containing value 1
				// will get a color different from background.
				for (int i = 0; i < displaySize; i++) {
					for (int row = 0; row < 7; row++) {
						for (int col = 0; col < 7; col++) {
							if (txtArray[i].getElement(row, col) == 1) {
								txtArray[i].setElement(row, col, Color.BLACK);
							}
						}
					}
					// sets up the display to show the new block.
					d.setDisplay(txtArray[i].getArray(), 0, i);
				}
				// shows the new display
				d.updateDisplay();
			}
			// Initial delay and period in milliseconds
		}, 0, 100);
	}

	public static void main(String[] args) {
		TextFlow prog = new TextFlow();
		prog.run();
	}
}
