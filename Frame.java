//Frame.java

/* This is the JFrame for the Snake game */


import java.awt.GridLayout;
import javax.swing.JFrame;


public class Frame extends JFrame {
	
	public Frame () {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Snake Game ");
		setLocationRelativeTo(null);


		init();
	}
	
	public void init() {
		setLayout(new GridLayout (1,0,1,0));

		Picture p1 = new Picture();
		add(p1);

		pack();   /* Found this method so that the JFrame would go to the setPreffered Size  http://stackoverflow.com/questions/11939028/setpreferredsize-does-not-work */
	
	
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String args[])
	{
             new Frame();
	}
	
	
}