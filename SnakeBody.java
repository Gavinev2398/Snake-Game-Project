  //SnakeBody.java

/* This class will create the snake class */


import java.awt.Graphics;
import java.awt.Color;



public class SnakeBody {
	
	private int xCoordinate , yCoordinate  , width , height;
	

	
	public SnakeBody (int xCoordinate , int yCoordinate , int blocksize ) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.width = blocksize;
		this.height = blocksize;
		
	}
	








	
	  
		
		public void draw(Graphics g)
		{
			g.setColor(Color.ORANGE);
			g.fillRect(xCoordinate * width , yCoordinate * height  , width , height);

		
		    
		}
		
	
}




