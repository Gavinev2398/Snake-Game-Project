//Frame.java

/* This is the JFrame for the Snake game */


import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class Frame extends JFrame implements ActionListener {

	JMenuBar bar;
	JMenu filenav , playernav , personnav;
	JMenuItem fopen , fsave , fexit , dadd , ddisplay , ddelete ;
	Person [] persons;
	int count = 0;
	String name;







	public Frame () {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Snake Game ");
		setLocationRelativeTo(null);
	    setResizable(false);

            ImageIcon icon = new ImageIcon(Frame.class.getResource("snake1.png"));  /* Adding and image to JOptionPane http://stackoverflow.com/questions/13963392/add-image-to-joptionpane */
                JOptionPane.showMessageDialog( null,"Todays challenge is to collect 10 balls good luck!", "Welcome to Snake!", JOptionPane.INFORMATION_MESSAGE, icon);
             
        

              


		filenav();
		playernav();



		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(filenav);
		bar.add(playernav);


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



	public void playernav () {

		playernav = new JMenu("Player");

		dadd = new JMenuItem("Add");
		dadd.addActionListener(this);
		playernav.add(dadd);



		ddisplay = new JMenuItem("Display");
		ddisplay.addActionListener(this);
		playernav.add(ddisplay);


		ddelete = new JMenuItem("Delete");
		ddelete.addActionListener(this);
		playernav.add(ddelete);


	}

	public void save() throws IOException {
		//	public void save(){// throws IOException {
		ObjectOutputStream os;
		os = new ObjectOutputStream(new FileOutputStream("users.dat"));
		os.writeObject(persons);
		os.close();
	}
	
	
	


	public void Exit(){
	  System.exit(0);
	}


	
	



	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Exit")) {
			Exit();
		}

	else	if (e.getActionCommand().equals("Add")) {
		     

		}
		
		else	if (e.getActionCommand().equals("Save")) {
			try{
				save();
				JOptionPane.showMessageDialog(null,"Your game scores have been sucessfully saved");
			} // try
			catch (IOException f){
				JOptionPane.showMessageDialog(null, "Not able to save the file:\n"+
						"Check the console printout for clues to why ");
				f.printStackTrace();
			}// catch



		}



	}

    
	
	public static void main(String args[])
	{
             new Frame();
             
             
            
             



	}
	
	
}