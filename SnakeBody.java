//SnakeBody.java

/* This class will create the snake class */


import java.awt.Graphics;
import java.awt.Color;



public class SnakeBody {
	
	private int xCoordinate , yCoordinate  , width , height;
	

	
	public SnakeBody (int xCoordinate , int yCoordinate , int size ) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.width = size;
		this.height = size;
		
	}
	
	

	
	  
		
		public void draw(Graphics g)
		{
			g.setColor(Color.BLUE);
			g.fillRect(xCoordinate  , yCoordinate  , width , height);
		
		    
		}
		
	
}




