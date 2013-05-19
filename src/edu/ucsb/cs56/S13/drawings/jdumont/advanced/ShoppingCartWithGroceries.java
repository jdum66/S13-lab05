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

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;
/**
   A shopping cart with Groceries
      
   @author Jake Dumont
   @version for CS56, S13, UCSB, 05/19/2013
   
*/
public class ShoppingCartWithGroceries extends ShoppingCart implements Shape
{
    /**
     * Constructor for objects of class ShoppingCartWithGroceries
     */
    public ShoppingCartWithGroceries(double x, double y, double width, double height,double radius)
    {
	// construct the basic cart shell
	super(x,y,width,height,radius);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make three bags
	//
	// The top of bag will be at y + 0.5*height and the
	// height of the bag is 0.5height;
	// The bottom of the bag will be at y+height

	double bagX = 0.10 * width;
	double bagWd = 2 * bagX;
	double bagHt =  0.5 * height;

	Rectangle2D.Double bag1 =
	    new Rectangle2D.Double(x + bagX, y + height - bagHt, bagWd, bagHt);
	Rectangle2D.Double bag2 =
	    new Rectangle2D.Double(x + 4.0*bagX, y + height - bagHt, bagWd, bagHt);
	Rectangle2D.Double bag3 =
	    new Rectangle2D.Double(x + 7.0*bagX, y + height - bagHt, bagWd, bagHt);
	
	// add the bags to the cart
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeCart = this.get();
        wholeCart.append(bag1, false);
        wholeCart.append(bag2, false);
        wholeCart.append(bag3, false); 
    }

}
