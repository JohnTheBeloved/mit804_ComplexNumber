package tax;

import java.util.HashSet;

/**
 * Created by John Alade.
 */
import java.util.Set;


public class Taxable {

    //An enum Type to represent the filling Status
    private final FillingStatus fillingStatus;
    private final Set<TaxBracket> taxBrackets;
    //The Taxable income
    private double income;
    //The calculated tax of the income
    private double tax;
    
    public Taxable(FillingStatus fillingStatus){
        this.taxBrackets = new HashSet<>();
        this.fillingStatus = fillingStatus;
        setTaxBrackets();
    }
    
    private void addTaxBracket(TaxBracket taxBracket){
       taxBrackets.add(taxBracket);
    }

    public void setIncome(double income){
        this.income = income;
    }

    public String calculateTax(){
        for(TaxBracket txB :taxBrackets){
            tax+= txB.getTax(income);
        }
       return fillingStatus.toString() +":- "+ tax +"\n";
    }

    private void setTaxBrackets(){
        TaxBracket bracket1 ,  bracket2 ,  bracket3 ,bracket4 , bracket5 ,bracket6 ;

        switch (fillingStatus)
        {
            case SINGLE:
               bracket1 = new TaxBracket(10,0,25000);
                bracket2 = new TaxBracket(15,25001,135000);
                bracket3 = new TaxBracket(20,135001,380000);
                bracket4 = new TaxBracket(30,380001,650000);
                bracket5 = new TaxBracket(34,650000,1200000);
                bracket6 = new TaxBracket(38,1200001,0);

                break;
            case MARRIED_JOINT:
               bracket1 = new TaxBracket(10,0,50000);
                bracket2 = new TaxBracket(15,50000,265000);
                bracket3 = new TaxBracket(20,265001,520000);
                bracket4 = new TaxBracket(30,5200001,800000);
                bracket5 = new TaxBracket(34,8000001,12000000);
                bracket6 = new TaxBracket(38,12000001,0);

                break;
            case MARRIED_SEPERATE:
                bracket1 = new TaxBracket(10,0,25000);
                bracket2 = new TaxBracket(15,25001,135000);
                bracket3 = new TaxBracket(20,135001,330000);
                bracket4 = new TaxBracket(30,330001,600000);
                bracket5 = new TaxBracket(34,600001,1000000);
                bracket6 = new TaxBracket(38,1000001,0);

                break;
            case HEAD_OF_HOUSEHOLD:
                bracket1 = new TaxBracket(10,0,35000);
                bracket2 = new TaxBracket(15,35001,165000);
                bracket3 = new TaxBracket(20,165001,420000);
                bracket4 = new TaxBracket(30,420001,700000);
                bracket5 = new TaxBracket(34,700001,1200000);
                bracket6 = new TaxBracket(38,1200001,0);
                break;
            case NOT_SPECIFIED:
                bracket1 = new TaxBracket(10,0,10000);
                bracket2 = new TaxBracket(15,10001,20000);
                bracket3 = new TaxBracket(20,20001,30000);
                bracket4 = new TaxBracket(30,30001,40001);
                bracket5 = new TaxBracket(34,40001,50000);
                bracket6 = new TaxBracket(38,50001,60000);

                break;
            default:
                throw new IllegalArgumentException();
        }
        addTaxBracket(bracket1);
        addTaxBracket(bracket2);
        addTaxBracket(bracket3);
        addTaxBracket(bracket4);
        addTaxBracket(bracket5);
        addTaxBracket(bracket6);
    }


    @Override
    public String toString(){
        String taxable = fillingStatus.toString() +" :- \n";
        for(TaxBracket taxRate: taxBrackets){
            taxable+=taxRate+"\n";
        }
        return taxable+"\n";
    }

}
