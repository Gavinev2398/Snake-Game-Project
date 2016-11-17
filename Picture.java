//Picture.java


import javax.swing.JPanel;
import java.awt.*;


public class Picture extends JPanel implements Runnable {



public static final int WIDTH = 750 , HEIGHT = 550;
private boolean running = false;
private Thread thread;

private Snake s;



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
   	
   }
   
   public void run()
   {
   	while(running)
   		repaint();
   		tick();
   	
   }
   
   public void tick ()
   {
   	System.out.println("hi");
   }
   
   public static void main(String args[])
   {
   	
   }
 


}