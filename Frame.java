//Frame.java

/* This is the JFrame for the Snake game */


import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;




public class Frame extends JFrame implements ActionListener {

	JMenuBar bar;
	JMenu filenav , DVDnav , personnav;
	JMenuItem fopen , fsave , fexit , dadd , ddisplay , ddelete ;




	public Frame () {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Snake Game ");
		setLocationRelativeTo(null);
	    setResizable(false);



		filenav();
		DVDnav();



		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(filenav);
		bar.add(DVDnav);


		init();
	}
	
	public void init() {
		setLayout(new GridLayout(1, 1, 0, 0));


		


		Game g = new Game();
		add(g);


	   pack();   /* Found this method so that the JFrame would go to the setPreffered Size  http://stackoverflow.com/questions/11939028/setpreferredsize-does-not-work */
	
	
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}


	public void filenav()
	{
		filenav = new JMenu("File");

		fopen = new JMenuItem("Open");
		fopen.addActionListener(this);
		filenav.add(fopen);



		fsave = new JMenuItem("Save");
		fsave.addActionListener(this);
		filenav.add(fsave);


		fexit = new JMenuItem("Exit");
		fexit.addActionListener(this);
		filenav.add(fexit);






	}

	public void DVDnav () {

		DVDnav = new JMenu("DVD");

		dadd = new JMenuItem("Add");
		dadd.addActionListener(this);
		DVDnav.add(dadd);



		ddisplay = new JMenuItem("Display");
		ddisplay.addActionListener(this);
		DVDnav.add(ddisplay);


		ddelete = new JMenuItem("Delete");
		ddelete.addActionListener(this);
		DVDnav.add(ddelete);


	}

	public void actionPerformed(ActionEvent e)
	{

	}

	
	public static void main(String args[])
	{
             new Frame();
             
             
             
             



	}
	
	
}