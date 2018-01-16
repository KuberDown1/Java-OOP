package CatchWilbur;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Wilbur {

 private int X, Y, clickCount, catchCount;
 private ImageIcon wilbur; // instantiasted a new ImageIcon
 private Random gen;


 // Creates Wilbur.
 public Wilbur(int initialX, int initialY) {
  wilbur = new ImageIcon("C:\\Users\\kubert\\Documents\\NetBeansProjects\\CatchtheCreature\\src\\CatchWilbur\\Wilbur.png");
  X = X;
  Y = Y;
  clickCount = catchCount = 0;
  gen = new Random();

 }

 // Moves wilbur to a random location within the play area.
 public void move(Dimension area) {
   X = gen.nextInt(area.width - wilbur.getIconWidth());
   Y = gen.nextInt(area.height - wilbur.getIconHeight());
  }
  // Returns true if point (x,y) is in wilbur and increments catch count, else
  // returns false.

 public boolean pointInMe(int x, int y) // check whether mouse click catches Wilbur
  {
   clickCount++;
   if (x >= X && x <= X + wilbur.getIconWidth()) {
    if (y >= Y && y <= Y + wilbur.getIconHeight()) // point is in boudns of Wilbur
    {
     catchCount++;
     return true;
    } else {
     return false;
    }
   } else {
    return false;
   }
  }

 public int getCatchCount() // return number of times Wilbur was "caught"
  {
   return catchCount;
  }

 public int getMissCount() // return the number of times Wilbur waas "missed"
  {
   return clickCount - catchCount;
  }

 public void draw(Component panel, Graphics page) // has Wilbur repaint itself
  {
   wilbur.paintIcon(panel, page, X, Y);

  }

}
