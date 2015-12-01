import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author johnthebeloved on 3/10/14.
 */
public class Board  extends JPanel{

    private List<Cell> cells;

    private MyCalendar referenceCalendar;
    public Board(MyCalendar myCalendar){
        referenceCalendar = myCalendar;
        setSize(300, 200);
        setLayout(new GridLayout(7,7));
        setWeekNames();
        cells = new ArrayList<Cell>();
        int day=0;
        for(int i=0;i<42;i++){
            if(day>=31)day=0;
            Cell cell= new Cell(0, 0);//myCalendar.getFirstWeekDayOfMonth() >= day?  new Cell(0, myCalendar.getDayOfMonth()): new Cell(++day, myCalendar.getDayOfMonth());
            cells.add(cell);
             add(cell);
        }
        refreshCells();
    }

    public MyCalendar getReferenceCalendar() {
        return referenceCalendar;
    }

    public void setReferenceCalendar(MyCalendar referenceCalendar) {
        this.referenceCalendar = referenceCalendar;
    }

    public void refreshCells(){
        int celldate=0;
        int referenceDate = referenceCalendar.getDayOfMonth();

        for(int i=1;i<cells.size();i++){
            Cell currentCell = cells.get(i);
             if(i>= referenceCalendar.getFirstWeekDayOfMonth()-1)currentCell.refreshCell(++celldate,referenceDate);
             else currentCell.refreshCell(0, referenceDate);
            if(celldate>= referenceCalendar.getNoOfDaysInMonth())celldate=0;
        }
    }

    private void setWeekNames(){

        add(new JLabel("Sun"));
        add(new JLabel("Mon"));
        add(new JLabel("Tue"));
        add(new JLabel("Wed"));
        add(new JLabel("Thu"));
        add(new JLabel("Fri"));
        add(new JLabel("Sat"));
    }
}
