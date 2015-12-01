import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class RunCircles  extends JFrame{
  
         Circles circles;
     
       public RunCircles()
    {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocation(500, 250);
        setTitle("Circles Animation");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       getContentPane().setBackground(Color.WHITE);
     
    }
       
       public void startShowing(int noOfCircles,int lowerRange,int higherRange){
        circles = new Circles(noOfCircles, lowerRange, higherRange);
     
             add(circles);
       
        
        setVisible(true);
        
        while(true){
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(RunCircles.class.getName()).log(Level.SEVERE, null, ex);
                 }
            remove(circles);
            circles.updateCirclesLocation();
            add(circles);
          
           repaint();

        }
       }
       
       public static void main(String[] args) throws InterruptedException {
              RunCircles runCircle = new RunCircles();
  
           Panel optionsPanel = new Panel(runCircle,true);
           
           runCircle.startShowing(optionsPanel.getNoOfCircles(), optionsPanel.getLowerRange(), optionsPanel.getHigherRange());
          
       }

    }

