// Chapter 6 Question 19

// Matthew Lin
/**
 * A class that creates a rainbow, with a Cyan background, an outermost Red ring, an inner Green ring, 
 * a small Magenta ring and the innermost ring that is the same color as the background.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
	private final Color skyColor = Color.CYAN;
 
  public Rainbow()
  {
    setBackground(skyColor);
  }
  
  public void drawArcCenter(Graphics g, int xCenter, int yCenter, int radius, int startAngle,int arcAngle)//draw an arc when given the coordinates of the center of the circle instead of the corners.
  {
	  g.fillArc(xCenter-radius, yCenter-radius, 2*radius, 2*radius, startAngle, arcAngle);
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();
    int xCenter = (int) (width/2.0);//set the x coordinate of the center of the arc to be 1/2 of the width
    int yCenter = (int)(height*3.0/4);//set the y coordinate of the center of the arc to be 3/4 of the height
    int startAngle=0;
    int arcAngle = 180;
    int largeRadius = (int)(width/4.0);
    int smallRadius = (int)(height/4.0);
    int mediumRadius = (smallRadius+largeRadius)/2;
    int innerRadius = (smallRadius+smallRadius/2)/2;
//    int mediumRadius = (int)Math.sqrt(largeRadius*smallRadius);
//    int innerRadius = (int)Math.sqrt(smallRadius*(smallRadius/2));

    g.setColor(Color.RED);
    this.drawArcCenter(g, xCenter, yCenter, largeRadius, startAngle, arcAngle);//draw the outer arc of the rainbow
    g.setColor(Color.GREEN);
    drawArcCenter(g, xCenter, yCenter, mediumRadius, startAngle, arcAngle);
    g.setColor(Color.MAGENTA);
    this.drawArcCenter(g, xCenter, yCenter, smallRadius, startAngle, arcAngle);
    g.setColor(skyColor);
    this.drawArcCenter(g, xCenter, yCenter, innerRadius, startAngle, arcAngle);
    
//    g.fillArc(xCenter-largeRadius, yCenter-largeRadius, 2*largeRadius, 2*largeRadius, startAngle, arcAngle);
// 
//    g.setColor(Color.GREEN);
//    g.fillArc(xCenter-mediumRadius, yCenter-mediumRadius, 2*mediumRadius, 2*mediumRadius, startAngle, arcAngle);
//  
//    g.setColor(Color.MAGENTA);
//    g.fillArc(xCenter-smallRadius, yCenter-smallRadius, 2*smallRadius, 2*smallRadius, startAngle, arcAngle);
//  
//    g.setColor(SKY_COLOR);
//    g.fillArc(xCenter-innerRadius, yCenter-innerRadius, 2*innerRadius, 2*innerRadius, startAngle, arcAngle);
//    System.out.println(largeRadius+" "+mediumRadius+" "+smallRadius+" "+innerRadius);
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
