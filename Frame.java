//Frame.java

/* This is the JFrame for the Snake game */


import java.awt.GridLayout;
import javax.swing.JFrame;


public class Frame extends JFrame {
	
	public Frame () {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Snake Game ");
		
		init();
	}
	
	public void init() {
		setLayout(new GridLayout (1,0,1,0));
		
		Picture p = new Picture();
		add(p);
		
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String args[])
	{
		new Frame();
	}
	
	
}