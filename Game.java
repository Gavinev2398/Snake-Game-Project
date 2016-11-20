//Game.java


import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.Graphics;






public class Game extends JPanel implements Runnable ,  EventListener {


	public static final int WIDTH = 750, HEIGHT = 550;
	private boolean running = false;
	private Thread thread;
	private SnakeBody s;
	private ArrayList<SnakeBody> snake;
	private int xCoordinate = 30, yCoordinate = 30;
	private int size = 10;
	private int ticks = 0;
	private boolean up = false, down = false, left = false, right = true;


	public Game() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		snake = new ArrayList<SnakeBody>();


		start();


	}

	public void tick()

	{
		if (snake.size() == 0) {
			s = new SnakeBody(xCoordinate, yCoordinate,10);
			snake.add(s);

		}
		ticks++;

		if (ticks > 10000) {
			if (up) yCoordinate--;
			if (down) yCoordinate++;
			if (right) xCoordinate++;
			if (left) xCoordinate--;

           ticks=0;
			s = new SnakeBody(xCoordinate, yCoordinate, 10);
			snake.add(s);

		}

		if (snake.size() > size) {
			snake.remove(0);
		}


	}

	public void paint(Graphics g) {

		g.clearRect(0,0,WIDTH,HEIGHT);   /* Snake was filling up boxes as it was moving so I used the clear Rectangle method https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html */
		g.setColor(Color.RED);


		for (int i = 0; i < WIDTH; i++) {
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
   	                                                       /* Method for the 10x10 Grid    http://stackoverflow.com/questions/8288827/how-can-i-create-a-square-10x10-grid-using-nested-for-loops-in-java */
		for (int i = 0; i < HEIGHT; i++) {
			g.drawLine(0, i * 10, WIDTH, i * 10);
		}

		for (int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
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

	public void keyPressed(KeyEvent e)    /* key listener https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyListener.html */ {
		if (e.getKeyCode() == KeyEvent.VK_UP && !down) {
			up = true;
			down = false;
			left = false;
			right = false;

		}


	}

}

