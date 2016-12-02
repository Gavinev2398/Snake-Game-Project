//Ball.java

/* This wil be the ball that the snake will eat and will move to a random co-ordinate once eaten */


import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.Graphics;


public class Ball  {
	
	
	private int xCoordinate , yCoordinate , width , height ;


	public Ball(int xCoordinate , int yCoordinate , int ballsize)
	{
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.width = ballsize;
		this.height = ballsize;
	}
	
	public void draw(Graphics g)  /* https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html */
	{
		g.setColor(Color.GREEN);
		g.fillRect( xCoordinate * width , yCoordinate * height , width ,  height);

	}

	public int getxCoord()
	{

		return xCoordinate;
	}

	public void setxCoord(int xCoord)

	{
		this.xCoordinate = xCoord;
	}

	public int getyCoord()

	{
		return yCoordinate;
	}

	public void setyCoord(int yCoord)
	{

		this.yCoordinate = yCoord;
	}



}