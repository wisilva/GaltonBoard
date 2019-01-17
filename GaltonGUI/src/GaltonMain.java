
	import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class GaltonMain {
		public static void main(String [] args) {
			int length = 6;
		JFrame frame = new JFrame("Galton");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane pane = new JTabbedPane();
		GaltonPanel panel = new GaltonPanel(length);
		pane.add("Board",panel);
		pane.add("Bar Graph", new Graph(length, panel));
		
		frame.getContentPane().add(pane);

		
		frame.pack();
		frame.setVisible(true);
		

		}
	}
/*This project was made in two parts: one GUI and one that displays method results in the Console.

Running the GUI Client class will display a tabbed JFrame with two panels, one that shows a triangle (not really that triangular). Using the next button will move the 1 at the top to one of the two 0s beneath it. Each sequential "next" will do the same, only to the two 0s beneath the 1. Using the "Full" method will run through the whole board the number of times specified in the text box. Clicking the "Graph" tab will show you a bar graph of the numbers, displaying a normal-like distribution of the galton board.*/