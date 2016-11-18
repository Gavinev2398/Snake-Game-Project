//Picture.java


import javax.swing.JPanel;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;


public class Picture extends JPanel implements Runnable , KeyListener {



public static final int WIDTH = 750 , HEIGHT = 550;
private boolean running = false;
private Thread thread;
ArrayList<Ball>balls[];
ArrayList<Snake>snakes[];
private Snake s;
private boolean up = false  , down = false , left = false , right = true;




public Picture () {
    setPreferredSize(new Dimension(WIDTH , HEIGHT));
     
    
    
    start();

}
   
   public void paint(Graphics g)
   {
   	
   	
   	g.setColor(Color.BLACK);
   	
   	for(int i = 0; i < WIDTH; i++)
   	{
   		g.drawLine(i * 10,0,i*10, HEIGHT);
   	}
   	                                                       /* Method for the 10x10 Grid    http://stackoverflow.com/questions/8288827/how-can-i-create-a-square-10x10-grid-using-nested-for-loops-in-java */
   	for(int i = 0; i < HEIGHT; i++)
   	{
   		g.drawLine(0,i*10,WIDTH,i*10);
   	}
   	
   	
   	
    
   	
   }
   
   public void start()
   {
   	running = true;
   }
   
   public void stop()
   {
   	running = false;
   }
   
   public void run()
   {
   	while(running)
   		repaint();
   		tick();
   	
   }
   
   public void tick ()
   {
   	
   }
   
   public void  KeyPressed(KeyEvent e)
   {
   	int key = e.getKeyCode();
   
   	if(key == KeyEvent.VK_LEFT)
   		{
   		up = false;
   		down = false;
   		left = true;
   		right = false;
     	}
     	if(key == KeyEvent.VK_RIGHT)
   		{
   		up = false;
   		down = false;
   		left = false;
   		right = true;
     	}
     	
     	if(key == KeyEvent.VK_UP)
   		{
   		up = true;
   		down = false;
   		left = false;
   		right = false;
     	}
     	
     if(key == KeyEvent.VK_DOWN)
   		{
   		up = false;
   		down = true;
   		left = false;
   		right = false;
     	}
     
   }
   
   
   public static void main(String args[])
   {
   	
   }
 


}

