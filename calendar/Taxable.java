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

    }

    public void addTaxRate(TaxBracket taxBracket){
       taxRates.add(taxBracket);
    }

    public void setIncome(double income){
        this.income = income;
    }

    public double calculateTax(){
        for(TaxBracket txB :taxRates){
            tax+= txB.getTax(income);
        }
       return tax;
    }



}
