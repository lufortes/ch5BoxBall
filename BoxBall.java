import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

/**
 * A class that draws a rectangle with balls bouncing off its walls. 
 *
 * @author  Lucita Fortes
 * @version 2017.10.23
 */
public class BoxBall
{
    private int numberOfBalls;
    private int xLeft;
    private int xRight;
    private int yTop;
    private int yBottom;
    private Canvas canvas;
    private int d;
    private ArrayList<Ball> balls;
    private Random randomGenerator;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param numberOfBalls the number of balls in the box
     * @param drawingCanvas  the canvas to draw this ball on
     * @param x-coordinate of left wall that ball cannot go beyond
     * @param x-coordinate of right wall that ball cannot go beyond 
     * @param y-coordinate of top wall that ball cannot go beyond
     * @param y-coordinate of bottom wall that ball cannot go beyond
     * @param diameter of the ball
     */
    public BoxBall(int nBalls, Canvas drawingCanvas, int x1, int x2, int y1, int y2, int diam)
    {
        numberOfBalls = nBalls;
        canvas = drawingCanvas;
        xLeft = x1;
        xRight = x2;
        yTop = y1;
        yBottom = y2;
        d = diam;
        randomGenerator = new Random();
        checkNoOfBalls(numberOfBalls);
        fillArrayList();
        bounceBall();
    }

    /**
     * Checks the number of balls to be displayed. If number is 
     * not between 5 and 30, use default value of 5
     */
    private void checkNoOfBalls(int n)
    {
        if ((n < 5) || (n > 30))
        {
            numberOfBalls = 5;
        }
    }
    
    /**
     * Fills array with Ball objects 
     */
    private void fillArrayList()
    {
        balls = new ArrayList<>();
        int index = 0;
        int x, y, r, g, b;
        boolean isWhite = true;
        r = 255;
        g = 255;
        b = 255;
        
        while (index < numberOfBalls)
        {
            x = randomGenerator.nextInt(xRight);
            y = randomGenerator.nextInt(yBottom);
            
            while (isWhite)
            {
                r = randomGenerator.nextInt(255);
                g = randomGenerator.nextInt(255);
                b = randomGenerator.nextInt(255);
            
                if (r != 255 || g!= 255 || b != 255)
                {
                    isWhite = false;
                }
            }
            
            balls.add(new Ball(x, y, d, new Color(r,g,b), canvas));
            isWhite = true;
            index++;
        }   
    }
    
    /**
     * Bounces balls in the array list
     */
    private void bounceBall()
    {
        for (Ball b: balls)
        {
            b.draw();
        }
        boolean finished =  false;
        while(!finished) {
            canvas.wait(50);           // small delay
            for (Ball b: balls)
            {
                b.move();
            }
        }
    }
    
    
}
