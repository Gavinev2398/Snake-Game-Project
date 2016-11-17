//Snake.java

/* This class will create the snake class */

import java.awt.*;
import javax.swing.*;


public class Snake {
	
	private int xCoordinate , yCoordinate , size , width , height;
	
	
	public Snake (int xCoordinate , int yCoordinate , int size ) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.size = size;
		this.width = size;
		this.height = size;
		
	}
		
		public void draw(Graphics g)
		{
			g.fillRect(xCoordinate * width , yCoordinate * height , width , height);
			g.setColor(Color.GREEN);
		}
		
	
}




