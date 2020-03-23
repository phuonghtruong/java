package ca.bcit.comp1451.session9A;

import java.awt.Polygon;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kšlling and David J. Barnes
 * @version 2011.07.31
 */

public class Triangle extends MyShape
{
    private int height;
    private int width;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(int xPosition, int yPosition, String color,
    		boolean isVisible, int height, int width)
    {
    	super(xPosition, yPosition, color, isVisible);
    	setHeight(height);
    	setWidth(width);
    }

    /**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newHeight, int newWidth)
    {
        erase();
        setHeight(newHeight);
        setWidth(newWidth);
        draw();
    }


    /**
     * Draw the triangle with current specifications on screen.
     */
    @Override
    public void draw()
    {
        if(getIsVisible()) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { getxPosition(), getxPosition() + (getWidth()/2), getxPosition() - (getWidth()/2) };
            int[] ypoints = { getyPosition(), getyPosition() + getHeight(), getyPosition() + getHeight() };
            canvas.draw(this, getColor(), new Polygon(xpoints, ypoints, 3));
            canvas.wait(this.TIMEOUT);
        }
    }

}

