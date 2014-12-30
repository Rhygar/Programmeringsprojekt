package arrayTools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestEnvironment2 extends JPanel {
	
	private Array7x7 array77;
	
	private JLabel[][] labels = new JLabel[7][7];
	private JLabel[] labelsW = new JLabel[7];	
	private JLabel[] labelsE = new JLabel[7];	
	
	private JButton btnLeft = new JButton("Left");
	private JButton btnRight = new JButton("Right");


	private Dimension block = new Dimension(40,40);		//size for all the JLabel components
	private Font font = new Font( "SansSerif", Font.BOLD, 30 );
	
	
	public TestEnvironment2(Array7x7 array) {
	
		this.array77 = array;
		//main test window size
		setPreferredSize(new Dimension(500,400));
		//choosing borderlayout to have one in west, south, east and center
		setLayout(new BorderLayout());
		
		//panel west, where the Left vertical Arrray7 is
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(80, 400));
		west.setLayout(new GridLayout(7,1, 5, 5));
		west.setBorder(BorderFactory.createEmptyBorder(2,20,20,20));
		for (int i = 0; i < labelsW.length; i++) {
			labelsW[i] = new JLabel("");
			labelsW[i].setBackground(Color.RED);
			labelsW[i].setOpaque(true);
			labelsW[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelsW[i].setFont(font);			
			west.add(labelsW[i]);
		}
		
		//panel center, where the 7x7 array is
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(7,7, 5, 5));
		center.setBorder(BorderFactory.createEmptyBorder(2,20,20,20));
			for (int row = 0; row < labels.length; row++) {
				for (int col = 0; col < labels[row].length; col++) {
					labels[row][col] = new JLabel("");
					labels[row][col].setPreferredSize(block);
					labels[row][col].setBackground(Color.GRAY);
					labels[row][col].setOpaque(true);
					labels[row][col].setHorizontalAlignment(SwingConstants.CENTER);
					labels[row][col].setFont(font);
					center.add(labels[row][col]);
				}
			}
		
			
		//panel east, where the Right vertical Arrray7 is
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(80, 400));
		east.setLayout(new GridLayout(7,1, 5, 5));
		east.setBorder(BorderFactory.createEmptyBorder(2,20,20,20));
		for (int i = 0; i < labelsE.length; i++) {
			labelsE[i] = new JLabel("");
			labelsE[i].setBackground(Color.RED);
			labelsE[i].setOpaque(true);
			labelsE[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelsE[i].setFont(font);			
			east.add(labelsE[i]);
		}
		
		//panel south, where the Left and Right buttons are
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(500, 65));
		south.setLayout(new GridLayout(1,2, 5, 5));
		south.setBorder(BorderFactory.createEmptyBorder(20,100,5,92));
		south.add(btnLeft);
		south.add(btnRight);
		
			
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
	
		btnLeft.addActionListener(new AL());
		btnRight.addActionListener(new AL());
	}
		
	/**
	 * Sets values in a 7x7 JLabel
	 * @param array 7x7 int[][] with values
	 */
	public void update() {
		for(int i = 0; i < labels.length; i++) {
			for(int j = 0; j < labels[i].length; j++) {
				String value = this.array77.getElement(i, j) + "";
				labels[i][j].setText(value);
				if (value.equals("1")) {
					labels[i][j].setBackground(Color.BLACK);
					labels[i][j].setForeground(Color.BLACK);
				} else if (value.equals("0")) {
					labels[i][j].setBackground(Color.RED);
					labels[i][j].setForeground(Color.RED);
				}
			}
		}
	}	
		
		
	
	
	private class AL implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (btnLeft == e.getSource()) {
				try {
					array77.shiftContent(new Array7(), 1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				update();
//				JOptionPane.showMessageDialog(null, "You clicked on Left button!");
			} else if(btnRight == e.getSource()) {
				try {
					array77.shiftContent(new Array7(), 2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				update();
				//				JOptionPane.showMessageDialog(null, "You clicked on Right button");
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		ArrayChars chars = new ArrayChars();
		int[] arr = {1,1,1,1,1,1,1};
		Array7 arr7 = new Array7(arr);
		Array7x7 arr77 = chars.getChar('A');
		TestEnvironment2 test = new TestEnvironment2(arr77);
//		arr77.shiftContent(arr7, 1);
		test.update();
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(test);
		frame.pack();
		frame.setVisible(true);
		
	}
}
