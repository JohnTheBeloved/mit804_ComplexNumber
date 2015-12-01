import sun.awt.VerticalBagLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
/**
 * Created by johnthebeloved on 3/10/14.
 */
public class CalendarFrame extends JFrame {
    //initialise a new Customised Calender and set time to now
    //This represents the calender board that displays the days (<1=31>)
    Board calenderBoard = new Board(new MyCalendar(new Date(System.currentTimeMillis())));
    //This is the Panel that contains the textboxes where the reference dates are shown or entered
    ReferencePanel referencePanel = new ReferencePanel(calenderBoard);

    public  CalendarFrame(){
        //Dimension of the Calendar Frame
        Dimension frameDimension = new Dimension(300,350);
        //Set the Layout to be Vertical
        setLayout(new VerticalBagLayout());
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //set the size of the Calendar Frame
        setSize(frameDimension);
        //Constraint the minimum size
        setMinimumSize(frameDimension);
        //Constraint the maximum size
        setMaximumSize(frameDimension);
        //add to the com.calendar frame-- the Reference panel(which) contains the textboxes and buttons
        add(referencePanel);
        //Add to the com.calendar frame -- the com.calendar panel which displays the days
        add(calenderBoard);
        //Set the Screen location of the Calendar frame
        setLocation(250,250);
        //Show the com.calendar frame
        setVisible(true);
   }



}
