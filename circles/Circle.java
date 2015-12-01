
import java.awt.Color;
import java.awt.Dimension;


/**
 *
 * @author johnthebeloved
 */
public class Circle {

    private int xCoordinate;
    private int yCoordinate;
    private int height;
    private int width;
    private int xBound;
    private int yBound;
    private int spaceTime;
    private Color color;

    private X_DIRECTION xdirection = X_DIRECTION.LEFT_RIGHT;
    private Y_DIRECTION ydirection = Y_DIRECTION.UP_DOWN;

    private Circle(int xCoordinate, int yCoordinate, int size, int xBound, int yBound) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.height = size;
        this.width = size;
        this.xBound = xBound-width;
        this.yBound = yBound-height;
        spaceTime= Utils.getRandomInt(1,10,100);
    }

    public Circle(int xBound, int yBound,int size) {

       this(Utils.getRandomInt(0, 500, 1000), Utils.getRandomInt(0, 500, 1000),size, xBound, yBound);

    }

    public void updateLocation(Dimension parentDimension) {

        
        
        this.xBound = (int)parentDimension.getWidth() -width;
        this.yBound = (int)parentDimension.getHeight() -height;
        
        
        if (xdirection == X_DIRECTION.LEFT_RIGHT && xCoordinate < xBound) {
            xCoordinate = xCoordinate + spaceTime;
        } else if (xdirection == X_DIRECTION.LEFT_RIGHT && xCoordinate >= xBound) {
            xdirection = X_DIRECTION.RIGHT_LEFT;
            spaceTime+=Utils.getRandomInt(1, 10, 10);
        } else if (xdirection == X_DIRECTION.RIGHT_LEFT&& xCoordinate > 0) {
            xCoordinate = xCoordinate - spaceTime;
        } else if (xdirection == X_DIRECTION.RIGHT_LEFT && xCoordinate <= xBound) {
            xdirection = X_DIRECTION.LEFT_RIGHT;
             spaceTime-=5;
        }

        if (ydirection == Y_DIRECTION.UP_DOWN && yCoordinate < yBound) {
            yCoordinate = yCoordinate + spaceTime;
        } else if (ydirection == Y_DIRECTION.UP_DOWN && yCoordinate >= yBound) {
            ydirection = Y_DIRECTION.DOWN_UP;
        } else if (ydirection == Y_DIRECTION.DOWN_UP&& yCoordinate > 0) {
            yCoordinate = yCoordinate - spaceTime;
       } else if (ydirection == Y_DIRECTION.DOWN_UP && yCoordinate <= yBound) {
            ydirection = Y_DIRECTION.UP_DOWN;
        }

     
    }

    @Override
    public String toString() {
        return "X=" + xCoordinate + "Y=" + yCoordinate + "H=" + height + "W=" + width;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
