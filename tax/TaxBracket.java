package tax;

/**
 * Created by John Alade.
 */
public class TaxBracket {
    private final double rate;
    private double lowerBound;
    private final double upperBound;

    public TaxBracket(int rate,double lowerBound,double upperBound){
        this.rate = (double)rate/100;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public double getTax(double income){
        double amtToTax=0;
        if(income >= lowerBound && income <= upperBound && lowerBound == 0){
          amtToTax =  income;
        }else if(income >= upperBound ){
            amtToTax =  upperBound;
        }else if(income < upperBound && income>=lowerBound){
            amtToTax =  income - --lowerBound;
        }

        double tax = amtToTax > 0 ? rate*amtToTax:0 ;
        return tax;
    }

    @Override
    public String toString(){
        return "\t\tRate: "+rate+"\tLower Bound: "+lowerBound+"\tUpper Bound: "+upperBound;
    }
}
