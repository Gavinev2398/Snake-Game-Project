//Game.java




import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.awt.Graphics;
import java.awt.Color;







public class Game extends JPanel implements Runnable {


	public static final int WIDTH = 900, HEIGHT = 650;
	private boolean running = false;
	private Thread thread;
	private SnakeBody s;
	private ArrayList<SnakeBody> snake;
	private ArrayList<Ball> balls;
	private Ball b;
	private int xCoordinate = 40, yCoordinate = 30;
	private int size = 5;
	private int amtofticks = 0;
	private Random rand;
	private boolean up = false, down = false, left = false, right = true;
	private Key key;
	private int score = 0;
	int dialogbutton = JOptionPane.YES_NO_OPTION;




	public Game() {


		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true); // needed for the JPanel to focus on the key Listener http://www.java-gaming.org/index.php/topic,25909. */
		setLayout(new GridLayout(1, 1, 0, 0));



		setBackground(Color.BLACK);


		JLabel scoreLabel = new JLabel();
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setLocation(100,100);
		scoreLabel.setText("Score" + score);

         

          

		snake = new ArrayList<SnakeBody>();
		balls = new ArrayList<Ball>();
		key = new Key();
		addKeyListener(key);


        
      
        
        
		rand = new Random();
		start();



	}

	public void tick()

	{




		if (snake.size() == 0) {
			s = new SnakeBody(xCoordinate, yCoordinate, 10);
			snake.add(s);

		}

		if (balls.size() == 0) {

			int xCoordinate = rand.nextInt(30);
			int yCoordinate = rand.nextInt(60);

			b = new Ball(xCoordinate, yCoordinate, 10);
			balls.add(b);


		}
          for(int i = 0;i < balls.size();i++) {
			  if (xCoordinate == balls.get(i).getxCoord() && yCoordinate == balls.get(i).getyCoord()) {

					  size++;

						  score++;
						  balls.remove(i);
				  i--;
			  }
		  }

          amtofticks++;

		if (amtofticks > 400000) {
			if (up) yCoordinate--;
			if (down) yCoordinate++;
			if (right) xCoordinate++;
			if (left) xCoordinate--;

			amtofticks = 0;
			s = new SnakeBody(xCoordinate, yCoordinate, 10);
			snake.add(s);


			if (snake.size() > size) {
				snake.remove(0);
			}


					if(snake.size() > 15 )
					{
						  ImageIcon icon = new ImageIcon(Frame.class.getResource("snake1.png"));  /* Adding and image to JOptionPane http://stackoverflow.com/questions/13963392/add-image-to-joptionpane */
                JOptionPane.showMessageDialog( null,"Congratulations you have caught 10 balls! ", "Congratulations", JOptionPane.INFORMATION_MESSAGE, icon);



						stop();
					}





		}

	}





	public void paint(Graphics g) {
		
    	g.clearRect(0, 0, WIDTH, HEIGHT);

      g.setColor(Color.BLACK);
      g.fillRect(0,0,WIDTH,HEIGHT);



		g.setColor(Color.RED);



	





		for (int i = 0; i < WIDTH; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
   	                                                       // Method for the 10x10 Grid    http://stackoverflow.com/questions/8288827/how-can-i-create-a-square-10x10-grid-using-nested-for-loops-in-java */
		for (int i = 0; i < HEIGHT; i++) {
			g.drawLine(0, i * 10, WIDTH, i * 10);
		}

		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}

		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).draw(g);
		}




	}





	public void start() {
		running = true;
		thread = new Thread(this, " Snake Game");
		thread.start();                                 /* Intro to threads http://www.javaworld.com/article/2077138/java-concurrency/introduction-to-java-threads.html */
	}











	public void run() {
		while (running) {
			repaint();
			tick();
		}

	}

	public void stop()
	{
		running = false;
		System.exit(0);
	}

	private class Key implements KeyListener {



		public void keyPressed(KeyEvent e)    /* key listener https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyListener.html */ {
			int key = e.getKeyCode();


			if (key == KeyEvent.VK_UP && !down) {
				up = true;
				left = false;
				right = false;

			}

			if (key == KeyEvent.VK_DOWN && !up) {
				down = true;
				left = false;
				right = false;

			}

			if (key == KeyEvent.VK_RIGHT && !left) {
				up = false;
				down = false;
				right = true;

			}

			if (key == KeyEvent.VK_LEFT && !right) {
				up = false;
				down = false;
				left = true;


			}

		}

		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {

		}

	}
	
	

}




