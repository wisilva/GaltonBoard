import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
 
public class GaltonPanel extends JPanel {

	private JButton button, buttonFull,reset;
	private JTextField text;
	private int col=0, row=1;
	private final int LENGTH = 600,WIDTH = 400;
	private int l;
	private JPanel[] panels;
	private JLabel[] labels;
	private JLabel info;
	
	 
	
	public GaltonPanel(int l){
		text = new JTextField("1");
		text.setPreferredSize(new Dimension(50,LENGTH/(l+10)));
		this.setLayout(new GridLayout(l+1,1));
		info = new JLabel("Set the Board with \" Full \" or \" Next \".");
		
		this.l = l;
		int panLen = l+1;
		int labNum = addFac(l);
		panels = new JPanel[panLen];
		labels = new JLabel[labNum];
		button = new JButton("Next");
		buttonFull = new JButton("Full");
		reset = new JButton("Reset");
		reset.addActionListener(new ButtonListener());
		
		
		
		for(int i = 0;i <labNum; i++) {
			labels[i] = new JLabel("0");
			
		}
		int k = 0;
		
		
		for(int i = 0;i<panLen;i++) {
		
			panels[i] = new JPanel();
		 for(int j =0; j<i ; j++) {
			
			 panels[i].add(labels[k]);
			 
			//The following two lines are to make the triangle look less compact
			 //Unfortunately, it makes it look less like a triangle as well
			 
			 labels[k].setPreferredSize(new Dimension(2*WIDTH/(i*3), LENGTH/(l+1)));
			 labels[k].setHorizontalAlignment(((int) Component.CENTER_ALIGNMENT));
			 
			 
			 k++;
			
		 }	
		 add(panels[i]);
		 panels[i].setBorder(BorderFactory.createCompoundBorder());
		
		 
	 }

		
		panels[0].add(reset);
		panels[0].add(button);
		panels[0].add(buttonFull);
		panels[0].add(text);
		panels[0].add(info);
		
		labels[0].setText("1");
		
		
		button.addActionListener(new ButtonListener());
		
		buttonFull.addActionListener(new ButtonListener());
		setPreferredSize(new Dimension(WIDTH, LENGTH));
		setBackground(Color.blue);
		
		
	}
	//for use in the bar graph
	public int getTotal() {
		int res =0;
		JLabel[] last= getLast();
		for(int i =0; i<last.length;i++) {
		res += Integer.parseInt(last[i].getText());
		}
		return res;
	}
	public JLabel[] getLast() {
		JPanel last = panels[panels.length-1];
		JLabel[] res = new JLabel[l];
		for(int i = 0;i < l;i++) {
			res[i] = ((JLabel) last.getComponent(i));
		}
		return res;
	}
	private int addFac(int n) {
		
		if(n==0) return 0;
		return addFac(n-1)+n;
	}
	
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			Random rand = new Random();
			int len = l;
			
		//Bottom
			if(event.getSource() == buttonFull) {
				
				if(row == 1) {
			//This runs the full method for the number in the text box
		for(int z = 0; z<Integer.parseInt(text.getText()); z++) {			
			for(int i = 0; i<l-1;i++) {
				boolean dir= rand.nextBoolean();
						
				((JLabel) panels[row].getComponent(col)).setText(Integer.toString((Integer.parseInt(((JLabel) panels[row].getComponent(col)).getText())-1))); 	
				if(dir) {
					col++;
					row++;
				}
				else {
			
					row++;
				}
				((JLabel) panels[row].getComponent(col)).setText(Integer.toString((Integer.parseInt(((JLabel) panels[row].getComponent(col)).getText())+1)));		
			}
			row = 1;
			col = 0;
			labels[0].setText("1"); 
				}
			info.setText("Filled the board "+ text.getText() + " times.");
				}
				else info.setText("Can only use Full when row one has a 1");
					
			
		}
			//Next (Single)
			else if(event.getSource() == button) {
			boolean dir= rand.nextBoolean();
			
			((JLabel) panels[row].getComponent(col)).setText(Integer.toString((Integer.parseInt(((JLabel) panels[row].getComponent(col)).getText())-1))); 	
			if(dir) {
				col++;
				row++;
			}
				else {

					row++;
				}
			((JLabel) panels[row].getComponent(col)).setText(Integer.toString((Integer.parseInt(((JLabel) panels[row].getComponent(col)).getText())+1)));		
		
			if(row== len) {
				row = 1;
				col = 0;
				labels[0].setText("1"); 
			}
			info.setText("Set the Board with \" Full \" or \" Next \".");
			}
			else {
				JLabel[] last = getLast();
				for(int i = 0; i<last.length;i++) {
					last[i].setText("0");
				info.setText("Board Cleared");
				}
	
		}		
		}			
}
}