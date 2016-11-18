//Ball.java

/* This wil be the ball that the snake will eat and will move to a random co-ordinate once eaten */


import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.Graphics;


public class Ball  {
	
	
	private int xCoor , yCoor , width , height;
	
	
	public Ball(int xCoor , int yCoor , int width , int height)
	{
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g)
	{
		g.fillRect( xCoor , yCoor , width ,  height);
		g.setColor(Color.GREEN);
	}
}