import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.Calendar;

/**
 * Created by johnthebeloved on 3/11/14.
 */
public class ReferencePanel extends JPanel {

    Board calendarBoard;

    JTextField dateTextField = new JTextField(20);
    JLabel dateLabel = new JLabel("Date");
    JButton refButton = new JButton("Set as Ref");

    JLabel timeFromRefDateLabel = new JLabel("Time From Reference Date");
    JTextField timeFromRefDateTextField = new JTextField(15);

    JLabel dateStringLabel = new JLabel();

    GridBagLayout gridBaglayout;
    GridBagConstraints layoutConstraints;

    public ReferencePanel(Board board){
        setSize(250, 50);
        calendarBoard = board;
        gridBaglayout = new GridBagLayout();
        layoutConstraints= new GridBagConstraints();
       layoutConstraints.insets = new Insets(2,2,2,2);
        setLayout(gridBaglayout);
        setRow1();
        setRow2();
        setRow3();
        setDate();
    }



    private void setDate(){
        dateTextField.setText(calendarBoard.getReferenceCalendar().getTimeString());
        dateStringLabel.setText(calendarBoard.getReferenceCalendar().getMonthDayString());
        timeFromRefDateTextField.setText(calendarBoard.getReferenceCalendar().getDurationFromNowString());
        calendarBoard.refreshCells();
    }

    private void setRow1(){
        layoutConstraints.fill = GridBagConstraints.BOTH;
        gridBaglayout.setConstraints(dateLabel, layoutConstraints);
        gridBaglayout.setConstraints(dateTextField, layoutConstraints);
        layoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBaglayout.setConstraints(refButton, layoutConstraints);
        add(dateLabel);
        add(dateTextField);
        add(refButton);

        refButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                MyCalendar newReferenceCalendar =    getReferenceDate(dateTextField.getText());
                calendarBoard.setReferenceCalendar(newReferenceCalendar);
              setDate();
               }catch (Exception ex){
                   JOptionPane.showMessageDialog(new JFrame(),ex.getMessage());
               }
            }
        });
        }

    private MyCalendar getReferenceDate(String dateEntered) throws Exception {

        StringTokenizer tokeniser = new StringTokenizer(dateEntered);
        String monthString = tokeniser.nextToken(" ").replace(",","").trim();
        String dateString = tokeniser.nextToken(",").replace(",","").trim();
        String yearString = tokeniser.nextToken("(").replace(",","").trim();
        String hourString = tokeniser.nextToken(".").replace("(","").trim();
        String minuteString = tokeniser.nextToken(".").replace(",","").trim();
        String secondString = tokeniser.nextToken(")").replace(".","").trim();
//System.out.println(monthString+dateString+yearString+hourString+minuteString+secondString);
        int year,month,date,hour,minute,second;

        year = Integer.valueOf(yearString);

        monthString = monthString.toUpperCase();
        if(monthString.equals("JANUARY"))month=0;
        else if(monthString.equals("FEBRUARY"))month=1;
        else if(monthString.equals("MARCH"))month=2;
        else if(monthString.equals("APRIL"))month=3;
        else if(monthString.equals("MAY"))month=4;
        else if(monthString.equals("JUNE"))month=5;
        else if(monthString.equals("JULY"))month=6;
        else if(monthString.equals("AUGUST"))month=7;
        else if(monthString.equals("SEPTEMBER"))month=8;
        else if(monthString.equals("OCTOBER"))month=9;
        else if(monthString.equals("NOVEMBER"))month=10;
        else if(monthString.equals("DECEMBER"))month=11;
        else throw new Exception("Month String Format "+monthString +" is not Correct...");

        date = Integer.valueOf(dateString);
        hour = Integer.valueOf(hourString);
        minute = Integer.valueOf(minuteString);
        second= Integer.valueOf(secondString);

        Calendar referenceCalender = Calendar.getInstance();
        referenceCalender.set(year,month,date,hour,minute,second);
       return new MyCalendar(referenceCalender.getTime());
    }

    private void setRow2(){
        layoutConstraints.gridwidth = GridBagConstraints.RELATIVE;
        gridBaglayout.setConstraints(timeFromRefDateLabel, layoutConstraints);
        layoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBaglayout.setConstraints(timeFromRefDateTextField, layoutConstraints);
        add(timeFromRefDateLabel);
        add(timeFromRefDateTextField);
        layoutConstraints.weightx = 0.0;
    }

    private void setRow3(){
        dateStringLabel.setText(calendarBoard.getReferenceCalendar().getTimeString());
        gridBaglayout.setConstraints(dateStringLabel, layoutConstraints);
        dateStringLabel.setHorizontalAlignment(JLabel.CENTER);
        add(dateStringLabel);
    }


}
