//Frame.java

/* This is the JFrame for the Snake game */


import java.awt.GridLayout;
import javax.swing.JFrame;
import java.awt.Component;




public class Frame extends JFrame {
	
	public Frame () {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Snake Game ");
		setLocationRelativeTo(null);
	    setResizable(false);


		init();
	}
	
	public void init() {
		setLayout(new GridLayout (1,1,0,0));
	
		


		Game g = new Game();
		add(g);



	   pack();   /* Found this method so that the JFrame would go to the setPreffered Size  http://stackoverflow.com/questions/11939028/setpreferredsize-does-not-work */
	
	
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String args[])
	{
             new Frame();
	}
	
	
}