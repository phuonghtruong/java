package ca.bcit.comp1451.session9A;

import java.awt.Rectangle;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kšlling and David J. Barnes
 * @version 2011.07.31
 */

public class Square extends MyShape
{
    private int size;

    /**
     * Create a new square at default position with default color.
     */
    public Square(int xPosition, int yPosition, String color,
    		boolean isVisible, int size)
    {
    	super(xPosition, yPosition, color, isVisible);
    	setSize(size);
    }

    /**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newSize)
    {
        erase();
        setSize(newSize);
        draw();
    }

    /**
     * Draw the square with current specifications on screen.
     */
    @Override
    public void draw()
    {
        if(getIsVisible()) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, getColor(),
                        new Rectangle(getxPosition(), getyPosition(), getSize(), getSize()));
            canvas.wait(this.TIMEOUT);
        }
    }

}

