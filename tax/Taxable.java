import java.util.HashSet;

/**
 * Created by johnthebeloved on 3/8/14.
 */
import java.util.Set;


public class Taxable {

    //An enum Type to represent the filling Status
    private FillingStatus fillingStatus;
    //An hash map to store the various tax rates for the particular filling Status
    private Set<TaxBracket> taxRates = new HashSet<TaxBracket>();
    //The Taxable income
    private double income;
    //The calculated tax of the income
    private double tax;

    public Taxable(FillingStatus fillingStatus){
        this.fillingStatus = fillingStatus;
        setTaxRates();
    }

    public void addTaxRate(TaxBracket taxBracket){
       taxRates.add(taxBracket);
    }

    public void setIncome(double income){
        this.income = income;
    }

    public String calculateTax(){
        for(TaxBracket txB :taxRates){
            tax+= txB.getTax(income);
        }
       return fillingStatus.toString() +":- "+ tax +"\n";
    }

    private void setTaxRates(){
        TaxBracket rate1 ;
        TaxBracket rate2 ;
        TaxBracket rate3 ;
        TaxBracket rate4 ;
        TaxBracket rate5 ;
        TaxBracket rate6 ;

        switch (fillingStatus)
        {
            case SINGLE:
               rate1 = new TaxBracket(10,0,25000);
                rate2 = new TaxBracket(15,25001,135000);
                rate3 = new TaxBracket(20,135001,380000);
                rate4 = new TaxBracket(30,380001,650000);
                rate5 = new TaxBracket(34,650000,1200000);
                rate6 = new TaxBracket(38,1200001,0);

                break;
            case MARRIED_JOINT:
               rate1 = new TaxBracket(10,0,50000);
                rate2 = new TaxBracket(15,50000,265000);
                rate3 = new TaxBracket(20,265001,520000);
                rate4 = new TaxBracket(30,5200001,800000);
                rate5 = new TaxBracket(34,8000001,12000000);
                rate6 = new TaxBracket(38,12000001,0);

                break;
            case MARRIED_SEPERATE:
                rate1 = new TaxBracket(10,0,25000);
                rate2 = new TaxBracket(15,25001,135000);
                rate3 = new TaxBracket(20,135001,330000);
                rate4 = new TaxBracket(30,330001,600000);
                rate5 = new TaxBracket(34,600001,1000000);
                rate6 = new TaxBracket(38,1000001,0);

                break;
            case HEAD_OF_HOUSEHOLD:
                rate1 = new TaxBracket(10,0,35000);
                rate2 = new TaxBracket(15,35001,165000);
                rate3 = new TaxBracket(20,165001,420000);
                rate4 = new TaxBracket(30,420001,700000);
                rate5 = new TaxBracket(34,700001,1200000);
                rate6 = new TaxBracket(38,1200001,0);
                break;
            case NOT_SPECIFIED:
                rate1 = new TaxBracket(10,0,10000);
                rate2 = new TaxBracket(15,10001,20000);
                rate3 = new TaxBracket(20,20001,30000);
                rate4 = new TaxBracket(30,30001,40001);
                rate5 = new TaxBracket(34,40001,50000);
                rate6 = new TaxBracket(38,50001,60000);

                break;
            default:
                throw new IllegalArgumentException();
        }
        addTaxRate(rate1);
        addTaxRate(rate2);
        addTaxRate(rate3);
        addTaxRate(rate4);
        addTaxRate(rate5);
        addTaxRate(rate6);
    }


    public String toString(){
        String taxable = fillingStatus.toString() +" :- \n";
        for(TaxBracket taxRate: taxRates){
            taxable+=taxRate+"\n";
        }
        return taxable+"\n";
    }

}
