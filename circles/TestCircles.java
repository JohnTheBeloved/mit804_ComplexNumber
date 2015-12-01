import javax.swing.JFrame;
import java.awt.Color;


/**
*Class implements a frame on which the Circles' panel(panel that hosts all the circles) stays
*/
public class TestCircles {
    public static void main(String[] args)
    {
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(500, 500);
        application.setLocation(500, 250);
        
        application.setForeground(Color.YELLOW);
       for(int i=0;i<20;i++){
             application.add(getNewCircle());
       }
   
        application.setVisible(true);
    }

    private static int getRandomInt(int lowerBound, int upperBound,int sigNum){
        int size=0;
        while(size <= lowerBound || size > upperBound){
        
            size = (int) (Math.random()*sigNum);
           
        }
         System.out.println("Random No==="+ size);
        return size+size+size+size+size;
        
    }

    private static Circles getNewCircle(){
        int size = getRandomInt(0,25,100);
        int loc = 1000;
        return new Circles(getRandomInt(0,500,loc), getRandomInt(0,500,loc), size, size);
    }

    }

