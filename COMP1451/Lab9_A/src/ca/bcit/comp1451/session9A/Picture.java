package ca.bcit.comp1451.session9A;

/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kšlling and David J. Barnes
 * @version 2011.07.31
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    
    public static final int NEW_WALL_XPOS = -140;
    public static final int NEW_WALL_YPOS = 20;
    public static final int NEW_WALL_SIZE = 120;
    
    public static final int NEW_WINDOW_XPOS = -120;
    public static final int NEW_WINDOW_YPOS = 40;
    public static final int NEW_WINDOW_SIZE = 40;
    
    public static final int NEW_ROOF_HEIGHT = 60;
    public static final int NEW_ROOF_WIDTH = 180;
    public static final int NEW_ROOF_XPOS = 20;
    public static final int NEW_ROOF_YPOS = -60;
    
    public static final int NEW_SUN_XPOS = 100;
    public static final int NEW_SUN_YPOS = -40;
    public static final int NEW_SUN_DIAMETER = 80;
    
    public static final String BLACK = "black";
    public static final String YELLOW = "yellow";
    public static final String RED = "red";
    public static final String GREEN = "green";
    public static final String WHITE = "white";

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        // nothing to do... instance variables are automatically set to null
    }

    public Picture(Square wall, Square window, Triangle roof, Circle sun) {
    	setWall(wall);
    	setWindow(window);
    	setRoof(roof);
    	setSun(sun);
    }
    
    /**
	 * @return the wall
	 */
	public Square getWall() {
		return wall;
	}

	/**
	 * @param wall the wall to set
	 */
	public void setWall(Square wall) {
		if(wall != null) {
			this.wall = wall;
		}
	}

	/**
	 * @return the window
	 */
	public Square getWindow() {
		return window;
	}

	/**
	 * @param window the window to set
	 */
	public void setWindow(Square window) {
		if(window != null) {
			this.window = window;
		}
	}

	/**
	 * @return the roof
	 */
	public Triangle getRoof() {
		return roof;
	}

	/**
	 * @param roof the roof to set
	 */
	public void setRoof(Triangle roof) {
		if(roof != null) {
			this.roof = roof;
		}
	}

	/**
	 * @return the sun
	 */
	public Circle getSun() {
		return sun;
	}

	/**
	 * @param sun the sun to set
	 */
	public void setSun(Circle sun) {
		if(sun != null) {
			this.sun = sun;
		}
	}

	/**
     * Draw this picture.
     */
    public void draw()
    {
    	getWall().erase();
        getWall().setxPosition(getWall().getxPosition() + NEW_WALL_XPOS);
        getWall().draw();
        
        getWall().erase();
        getWall().setyPosition(getWall().getyPosition() + NEW_WALL_YPOS);
        getWall().draw();
        
        getWall().erase();
        getWall().setSize(NEW_WALL_SIZE);
        getWall().draw();
        

        getWall().setIsVisible(true);
        getWall().draw();
        

        getWindow().setColor(BLACK);

        getWindow().erase();
        getWindow().setxPosition(getWindow().getxPosition() + NEW_WINDOW_XPOS);
        getWindow().draw();

        getWindow().erase();
        getWindow().setyPosition(getWindow().getyPosition() + NEW_WINDOW_YPOS);
        getWindow().draw();

        getWindow().erase();
        getWindow().setSize(NEW_WINDOW_SIZE);

        getWindow().setIsVisible(true);
        getWindow().draw();

        getRoof().erase();
        getRoof().setHeight(NEW_ROOF_HEIGHT);
        getRoof().setWidth(NEW_ROOF_WIDTH);

        getRoof().erase();
        getRoof().setxPosition(getRoof().getxPosition() + NEW_ROOF_XPOS);
        getRoof().draw();

        getRoof().erase();
        getRoof().setyPosition(getRoof().getyPosition() + NEW_ROOF_YPOS);
        getRoof().draw();

        getRoof().setIsVisible(true);
        getRoof().draw();       

        getSun().setColor(YELLOW);

        getSun().erase();
        getSun().setxPosition(getRoof().getxPosition() + NEW_SUN_XPOS);
        getSun().draw();

        getSun().erase();
        getSun().setyPosition(getSun().getyPosition() + NEW_SUN_YPOS);
        getSun().draw();

        getSun().erase();
        getSun().setDiameter(NEW_SUN_DIAMETER);
        getSun().draw();

        getSun().setIsVisible(true);
        getSun().draw();
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        if (wall != null)   // only if it's painted already...
        {
            wall.changeColor(BLACK);
            window.changeColor(WHITE);
            roof.changeColor(BLACK);
            sun.changeColor(BLACK);
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        if (wall != null)   // only if it's painted already...
        {
            wall.changeColor(RED);
            window.changeColor(BLACK);
            roof.changeColor(GREEN);
            sun.changeColor(YELLOW);
        }
    }
}

