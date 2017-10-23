import java.awt.*;
/**
 * Class Ball - a graphical ball has the ability to move within the box. 
 * It bounces off walls.
 * This movement can be initiated by repeated calls to the "move" method.
 * @author  Lucita Fortes
 * @version 10.23.2017
 */
public class Ball
{
    // instance variables 
   
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private int ySpeed = 7;
    private int xSpeed = 7;
    private Dimension dim;
    private double dHeight;
    private double dWidth;
    
    /**
     * Constructor for objects of class Ball
     * @param x-coordinate of Ball
     * @param y-coordinate of Ball
     * @param diameter of Ball
     * @param color of Ball
     * @param Canvas object to draw the ball
     */
    public Ball(int xPos, int yPos, int ballDiameter, Color ballColor, Canvas pCanvas)
    {
        // initialise instance variables
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = pCanvas;
        dim = canvas.getSize();
        dHeight = dim.getHeight();
        dWidth = dim.getWidth();
    }

    /**
     * Get x position of the ball
     */
    public int getXPos()
    {
        // put your code here
        return xPosition;
    }
    
    /**
     * Get y position of the ball
     */
    public int getYPos()
    {
        // put your code here
        return yPosition;
    }
    
    /**
     * Get diameter of the ball
     */
    public int getDiameter()
    {
        return diameter;
    }
    
    /**
     * Get color of the ball
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    
    
    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the walls
        if(yPosition >= ((int)dHeight - diameter)) {
            yPosition = (int)(dHeight) - diameter;
            ySpeed = -7; 
        }
        
        if (yPosition <= 0) {
            yPosition = (int)(0);
            ySpeed = 7;
        }
        
        if (xPosition >= ((int)dWidth - diameter)) {
            xPosition = (int)(dHeight) - diameter;
            xSpeed = -7;
        }

        if (xPosition <= 0) {
            xPosition = (int)(0);
            xSpeed = 7;
        }
        // draw again at new position
        draw();
    }    
}
