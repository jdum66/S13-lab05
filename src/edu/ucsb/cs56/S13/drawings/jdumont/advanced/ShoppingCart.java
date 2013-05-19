package edu.ucsb.cs56.S13.drawings.jdumont.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a shopping cart that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jake Dumont
   @version for CS56, Spring 13, UCSB
   
*/
public class ShoppingCart extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of cart
       @param y y coord of lower left corner of cart
       @param width width of the cart
       @param height of cart
       @param wheelRadius radius of the wheels
     */
    public ShoppingCart(double x, double y, double width, double height, double wheelRadius)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	double handleXLength = .25 * width;
	double handleYLength = .25 * height;

       	//make main rectangle of cart
	
	Rectangle2D.Double cartBody = new Rectangle2D.Double(x, y, width, height);
	
	//make the handle

	Line2D.Double cartHandle = new Line2D.Double(x, y, x - handleXLength, y - handleYLength); 

	//make the wheels

	Ellipse2D.Double cartWheel1 = new Ellipse2D.Double(x - wheelRadius, y + height, wheelRadius*2, wheelRadius*2);

	Ellipse2D.Double cartWheel2 = new Ellipse2D.Double(x + width - wheelRadius, y + height, wheelRadius*2, wheelRadius*2);


	GeneralPath wholeCart = this.get();
        wholeCart.append(cartBody, false);
        wholeCart.append(cartHandle, false);
        wholeCart.append(cartWheel1, false); 
	wholeCart.append(cartWheel2, false);
	
        
    }

}
