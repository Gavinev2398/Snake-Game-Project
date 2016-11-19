//Game.java


import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;
import java.awt.Graphics;



public class Game extends JPanel implements Runnable  {



public static final int WIDTH = 750 , HEIGHT = 550;
private boolean running = false;
private Thread thread;
private SnakeBody s;
private ArrayList<SnakeBody>snake;
private int  xCoordinate = 10, yCoordinate = 10;
private int size = 10;




public Game () {
    setPreferredSize(new Dimension(WIDTH , HEIGHT));

       snake = new ArrayList<SnakeBody>();


    start();


}

       public void tick ()
   {
   	  if(snake.size() == 0)
   	  {
   	  	s = new SnakeBody(xCoordinate, yCoordinate , size);
   	  		snake.add(s);
   	  }
   }

   public void paint(Graphics g)
   {


   	g.setColor(Color.RED);


   	for(int i = 0; i < WIDTH; i++)
   	{
   		g.drawLine(i * 10,0,i*10, HEIGHT);
   	}
   	                                                       /* Method for the 10x10 Grid    http://stackoverflow.com/questions/8288827/how-can-i-create-a-square-10x10-grid-using-nested-for-loops-in-java */
   	for(int i = 0; i < HEIGHT; i++)
   	{
   		g.drawLine(0,i*10,WIDTH,i*10);
   	}

   	for(int i = 0; i < snake.size();i++)
   	{
   	     snake.get(i).draw(g);
   	}




   }




   public void start()
   {
   	running = true;
   	thread = new Thread(this," Snake Game");
   	thread.start();                                 /* Intro to threads http://www.javaworld.com/article/2077138/java-concurrency/introduction-to-java-threads.html */
   }




   public void run()
   {
   	while(running)

   		tick();

   }









}

