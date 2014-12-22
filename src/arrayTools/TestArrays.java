package arrayTools;

import javax.swing.JFrame;

public class TestArrays {
	
	public static void main(String[] args) throws Exception {

		Array7x7 arr77 = new Array7x7();				//test constructor Array7x7
		TestEnvironment testEnv = new TestEnvironment();
		int[] arr = {1,2,3,4,5,6,7};
		Array7 arr7 = new Array7(arr);					//test constructor Array7
		testEnv.setArray7x7(arr77);
		testEnv.setVerticalArray(arr7.getArray());			//test getArray() in Array7
		testEnv.setHorizontalArray(arr7.getArray());			
		testEnv.setHorizontalArray(arr77.getCol(0).getArray()); //test getCol() in Array7x7 and getArray() in Array7
		arr77.setCol(4, arr7);
		arr77.setElement(1, 2, 3);
		testEnv.setArray7x7(arr77);
		
		
		

		
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(testEnv);
		frame.pack();
		frame.setVisible(true);
	}

}
