import javax.swing.*;
import java.awt.*;

/**
 * Created by johnthebeloved on 3/10/14.
 */
public class Cell extends JPanel {
    JLabel label = new JLabel();
    Dimension dimension = new Dimension(25,25);
    public Cell(int dayToSet,int realDay){
        setSize(dimension);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        add(label);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
       refreshCell(dayToSet,realDay);
    }

    public void refreshCell(int cellDate,int calendarDate){
        if(cellDate==0)label.setText("");
        else label.setText("" + cellDate);
        if(calendarDate==cellDate)label.setForeground(Color.GREEN);
        else label.setForeground(Color.BLACK);
    }
}
