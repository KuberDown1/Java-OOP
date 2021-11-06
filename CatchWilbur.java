//--------------------------------------------------------------------------
// Design and implement an application that plays a game called catch Wilbur
// By Tulsi Kuber
//--------------------------------------------------------------------------

// driver class
package CatchWilbur;

import javax.swing.JFrame;
public class CatchWilbur {
 // Displays the main frame of the program.
 public static void main(String[] args) {

  JFrame frame = new JFrame("Catch Wilbur");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().add(new CatchWilburPanel());
  frame.pack();
  frame.setVisible(true);
 }
}
