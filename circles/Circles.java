import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;


/**
 *
 * @author johnthebeloved
 *
 *Panel hosts all the circles
 */
public class Circles extends JPanel{
 
    //Array of circles to store the number of Circles generated
    Circle [] circles ;
    //Array of colors to use for drawing the circles
    Color[] colors = {Color.BLUE,Color.CYAN,Color.GREEN,Color.PINK,Color.RED,Color.ORANGE,Color.MAGENTA,Color.YELLOW,Color.DARK_GRAY,Color.LIGHT_GRAY};
    
    /**
    *noOfCircles - The number of circles to draw
    *lowerRange - The lower range of size
    *higherRange - The higher range of size
    */
    public Circles(int noOfCircles,int lowerRange,int higherRange){
        //the backgrod color of the  frame
        setBackground(Color.WHITE);
        //initialize the circles array
        circles = new Circle[noOfCircles];
        //loop through to create a new circle into eanch array and also set the color
        for(int i=0;i<circles.length;i++){
            circles[i] = new Circle(getWidth(),getHeight(),Utils.getRandomInt(lowerRange, higherRange, 100));
            circles[i].setColor(colors[Utils.getRandomInt(1, 10, 10)]);
        }
    }
    
    /**
    *Paint the frame with the circles
    */
    @Override
   public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
       
       for(Circle circle:circles){
            g.setColor(circle.getColor());
           g.fillOval(circle.getxCoordinate(),circle.getyCoordinate(),circle.getWidth(),circle.getHeight());
        }
     
    }
   
   public void updateCirclesLocation(){
       for(Circle circle:circles){
             circle.updateLocation(getSize());
       }
   }

    @Override
    public String toString(){
        String circlesString = "";
          int count=0;
        for(Circle circle:circles){
            circlesString += "Circle:"+ count++ + circle.toString() +"\n";
        }
        return circlesString+"X="+getX()+"Y="+getY()+"H="+getHeight()+"W="+getHeight();
        
    }
   
    
}
