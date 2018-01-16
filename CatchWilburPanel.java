// panel class
package CatchWilbur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CatchWilburPanel extends JPanel {
 private Wilbur Wilbur; // instantiates new wilbur object
 private Random gen; // instantiates a new random generator
 private Timer animate; // instantiates a new timer
 private Timer Timer; // instantiates a 2nd timer for terminating the game
 public static int seconds = 30;
 private final int X = 20, Y = 100;
 private final int MOVE_ODDS = 4; // 1 in 4 chance Wilbur will move
 private final int DELAY = 500;

 // Sets up the panel
 public CatchWilburPanel() {
  new Timer(30 * 1000, new ActionListener() { // 30 seconds until game ends
   @Override
   public void actionPerformed(ActionEvent e) {
    // Assuming wilbur is an instance of Wilbur
    System.out.println("It has been 30 seconds. Game over!");
    System.out.println("Catches: " + Wilbur.getCatchCount()); //prints catches
    System.out.println("Misses: " + Wilbur.getMissCount()); // prints misses
    System.exit(0); // terminates game
   }
  }).start();
  Wilbur = new Wilbur(X, Y);
  gen = new Random();
  addMouseListener(new Catcher());
  setBackground(Color.white);
  setPreferredSize(new Dimension(500, 500));
  animate = new Timer(DELAY, new RandomMover());
  animate.start();
 }

 // Draws wilbur and the number of catches
 public void paintComponent(Graphics page) {
  super.paintComponent(page);

  // paint wilbur here
  Wilbur.draw(this, page);

  // Update the hit counter for catches and/or misses
  String catchString = "Catches: " + Wilbur.getCatchCount();
  page.drawString(catchString, 10, 20);
  String missString = "Misses: " + Wilbur.getMissCount();
  page.drawString(missString, 10, 40);

 }

 // Inner class listens for mouse presses. If mouse is pressed inside Wilbur,
 // move Wilbur and repaint the screen.
 public class Catcher extends MouseAdapter {

  private final int X = 20, Y = 100;
  public void mouseClicked(MouseEvent event) {
   if (Wilbur.pointInMe(event.getX(), event.getY())) {
    Wilbur.move(getSize());

   }

   repaint();
  }
 }


 // Inner class listens for timer to move Wilbur & repaint screen during animation.
 // Moves Wilbur based on MOVE_ODDS (may not move every time timer fires).
 public class RandomMover implements ActionListener {
  public void actionPerformed(ActionEvent event) {

   int shouldMove = gen.nextInt(MOVE_ODDS);
   if (shouldMove == 0) {
    Wilbur.move(getSize());
    repaint();

   }
  }
 }
}
