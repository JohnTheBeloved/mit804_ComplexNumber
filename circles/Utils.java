/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johnthebeloved
 */
public class Utils {
 
    
    public static int getRandomInt(int lowerBound, int upperBound,int sigNum){
        int size=0;
        while(size <= lowerBound || size > upperBound){
        
            size = (int) (Math.random()*sigNum);
           
        }
        return size;
        
    }
}
