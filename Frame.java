//Frame.java

/* This is the JFrame for the Snake game */


import java.awt.GridLayout;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;


public class Frame extends JFrame implements ActionListener {

	JMenuBar bar;
	JMenu filenav , playernav , personnav;
	JMenuItem fopen , fsave , fexit , dadd , ddisplay , ddelete ;
	Person [] persons;
	int count;
	String name;
	public int score;









	public Frame () {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Snake Game ");
		setLocationRelativeTo(null);
	    setResizable(false);
	    
	    

            ImageIcon icon = new ImageIcon(Frame.class.getResource("snake1.png"));  /* Adding and image to JOptionPane http://stackoverflow.com/questions/13963392/add-image-to-joptionpane */
                JOptionPane.showMessageDialog( null,"Todays challenge is to collect 10 balls good luck!", "Welcome to Snake!", JOptionPane.INFORMATION_MESSAGE, icon);
		       SoundClipTest();
             
        
           
              


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

	public void  SoundClipTest() {     /* music for eating a ball https://www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html */

		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader().getResource("pacman_beginning.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
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

	public void save()
			throws IOException {
		//	public void save(){// throws IOException {
		ObjectOutputStream os;
		os = new ObjectOutputStream(new FileOutputStream("users.dat"));
		os.writeObject(persons);
		os.close();
	}

	public void open() {
		count = 0;
		try{
			ObjectInputStream is;
			is = new ObjectInputStream(new FileInputStream("users.dat"));
			persons  = (Person []) is.readObject();
			is.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"open didn't work");
			e.printStackTrace();
		}


		while (persons[count] !=null)
			count++;
	}






	public void Exit(){

		System.exit(0);
	}


	public void addPerson()
	{
		Person p1 = new Person();
		p1.setName(JOptionPane.showInputDialog("Enter you name"));
		persons[count] = p1;
		count++;
	}


	public void display()
	{
		JTextArea area = new JTextArea();
		if (count>0) {
			area.setText("High Scores\n\n");
			for (int i = 0; i<count; i++)
				area.append("Our Players " + i + " " + persons[i].toString()+ score + "\n");
			JOptionPane.showMessageDialog(null, area);
		}
		else
			JOptionPane.showMessageDialog(null ,"No Players Found ");
	}



	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Exit")) {
			Exit();
		}

	else	if (e.getActionCommand().equals("Add")) {
			addPerson();

		     

		}

		else	if (e.getActionCommand().equals("Add")) {
			open();



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

		else if(e.getActionCommand().equals("Display")) {

			display();
		}



	}



    
	
	public static void main(String args[])
	{
             new Frame();
             
             
            
             



	}
	
	
}