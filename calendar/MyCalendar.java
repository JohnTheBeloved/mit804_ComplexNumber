import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by johnthebeloved on 3/11/14.
 */
public class MyCalendar {

        Calendar referenceCalendar = Calendar.getInstance();
        Calendar todayCalender = Calendar.getInstance();

        public MyCalendar(Date referenceDate){
            referenceCalendar.setTime(referenceDate);
            todayCalender.setTime(new Date(System.currentTimeMillis()));

        }

    public   String getTimeString(){
        String dateString= referenceCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH) + " ";
        dateString+=referenceCalendar.get(Calendar.DAY_OF_MONTH) + ", ";
        dateString+=referenceCalendar.get(Calendar.YEAR) + ", ";
        dateString+= "("+referenceCalendar.get(Calendar.HOUR_OF_DAY)+ ".";
        dateString+=referenceCalendar.get(Calendar.MINUTE) + ".";
        dateString+=referenceCalendar.get(Calendar.SECOND) + ")";
        return dateString;
    }

    public  int getDayOfMonth(){
        return referenceCalendar.get(Calendar.DAY_OF_MONTH);
    }

    public  String getMonthDayString(){
        String dateString= referenceCalendar.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.ENGLISH) + ", ";
        dateString+=referenceCalendar.get(Calendar.YEAR) ;
        return  dateString;

    }

    public    String getDurationFromNowString(){

        long millInSecond = 1000;
        long millInMinute = millInSecond*60;
        long millInHour = millInMinute*60;

        long millInDay = millInHour*24;

        long daysInMonth =referenceCalendar.getMaximum(Calendar.DAY_OF_MONTH);

        long millInMonth =  millInDay* daysInMonth;

        long daysThatMakeThisYear = (((GregorianCalendar) referenceCalendar).isLeapYear(referenceCalendar.get(Calendar.YEAR))?366:365);
        long millInYear = millInMonth*daysThatMakeThisYear;

        Calendar todayDateCalender = Calendar.getInstance();
        todayDateCalender.setTime(new Date(System.currentTimeMillis()));
        long differenceInTime =todayDateCalender.getTimeInMillis()> referenceCalendar.getTimeInMillis()? todayDateCalender.getTimeInMillis()-referenceCalendar.getTimeInMillis():referenceCalendar.getTimeInMillis()-todayDateCalender.getTimeInMillis();

        System.out.println("Year=="+millInYear);

        System.out.println("Today=="+todayDateCalender.getTimeInMillis()+"Reference=="+ referenceCalendar.getTimeInMillis());


        System.out.println("Difference in time === "+differenceInTime +
        "Mill in Year"+ millInYear);

        String dateString= (differenceInTime/millInYear) + " ";
        differenceInTime%=millInYear;
        dateString+= differenceInTime/millInMonth + ",";
        differenceInTime%=millInMonth;
        dateString+=differenceInTime/millInDay + ", ";
        differenceInTime%=millInDay;
        dateString+= "("+differenceInTime/millInHour+ ".";
        differenceInTime%=millInHour;
        dateString+=differenceInTime/millInMinute + ".";
        differenceInTime%=millInMinute;
        dateString+=differenceInTime/millInSecond + " )";
        return dateString;
    }

    public  int getFirstWeekDayOfMonth(){
       Calendar firstDayOfMonth = Calendar.getInstance();
        firstDayOfMonth.setTime(referenceCalendar.getTime());
        firstDayOfMonth.set(Calendar.DAY_OF_MONTH,1);
        return firstDayOfMonth.get(Calendar.DAY_OF_WEEK);
    }

    public int getNoOfDaysInMonth(){
        return referenceCalendar.getMaximum(Calendar.DAY_OF_MONTH);
    }
}
