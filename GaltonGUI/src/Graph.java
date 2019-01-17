import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;
public class Graph extends JPanel{
	private JLabel info;
	private GaltonPanel board;
	private JLabel[] last;
	private int WIDTH, LENGTH;
	private Timer timer;
		public Graph(int l, GaltonPanel panel) {
			info = new JLabel("");
			board = panel;
			timer = new Timer(100, new TimerListener());
			last = board.getLast();
			this.setBorder(BorderFactory.createCompoundBorder());
			add(info);
			WIDTH = 600;
			LENGTH = 700;
			timer.start();
			setBackground(Color.white);
			setPreferredSize(new Dimension(WIDTH, LENGTH));
			
		}

		public void paintComponent(Graphics page){
			int margin = 150;
			int rectWid= 10;
			int distance = 60;
			super.paintComponent(page);
		 
			for(int i = 0; i<last.length;i++) {
			page.fillRect(margin+distance*i, LENGTH-5*Integer.parseInt(last[i].getText()), rectWid, 5*Integer.parseInt(last[i].getText()));
				
			page.setColor(Color.black);
			}
			 
			
			page.drawLine(0, LENGTH, margin+rectWid/2, LENGTH-5*Integer.parseInt(last[0].getText()));	
			for(int i = 1; i<last.length;i++) {
			page.drawLine(margin+distance*(i-1)+rectWid/2, LENGTH-5*Integer.parseInt(last[i-1].getText()), margin+distance*(i)+rectWid/2, LENGTH-5*Integer.parseInt(last[i].getText()));
			}
			
			page.drawLine(margin+distance*(last.length-1)+rectWid/2, LENGTH-5*Integer.parseInt(last[last.length-1].getText()), WIDTH, LENGTH);
			
			}
		private class TimerListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				last = board.getLast();
				info.setText("Result after "+ board.getTotal()+ " runs.");
				repaint();
			}
		}
}

