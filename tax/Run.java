import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.StringTokenizer;

/**
 * Created by johnthebeloved on 3/9/14.
 */
public class Run {

    public static void main(String [] args){
       Run taxcalculator = new Run();
       boolean restart = taxcalculator.restartReponse(taxcalculator.startApp());
       while(restart){
        restart= taxcalculator.restartReponse(taxcalculator.startApp());
       }
       System.exit(1);
       


    }

    JFrame parentFrame = new JFrame();
    private  String startApp(){
        String result="";
       String enteredOption ;


        double income = 0;
         
       
       int options[] = getEnteredOption();
       
       if(options.length == 0)
       {
        return "Invalid Options Entered";
        }
       else if(options.length == 1)
        {
            if(options[0] == 5){
               return new Taxable(getFillingStatus(1)).toString() + new Taxable(getFillingStatus(2)).toString()
                + new Taxable(getFillingStatus(3)).toString() + new Taxable(getFillingStatus(4)).toString() ;
            }
            if(options[0] == 0)
            {
                Taxable taxable = new Taxable(getFillingStatus(0));
                taxable.setIncome(getEnteredIncome());
                return "Tax : " + taxable.calculateTax();
        
             }
        }
       


         income = getEnteredIncome();
        for(int i = 0; i< options.length;i++){
        Taxable taxable =null;
    
        taxable = new Taxable(getFillingStatus(options[i]));

        taxable.setIncome(income);
       
          try{
       result+= "\n"+taxable.calculateTax();
             }catch (NumberFormatException ex){
            return ex.getMessage();
        
 }

}
        return "Tax : " +result;
        
    }

    private FillingStatus getFillingStatus(int numberRepresentation){
        switch(numberRepresentation){

            case 1:
                return FillingStatus.SINGLE;
            case 2:
                return FillingStatus.MARRIED_JOINT;
            case 3:
                return FillingStatus.MARRIED_SEPERATE;
            case 4:
                return FillingStatus.HEAD_OF_HOUSEHOLD;
            case 0:
                 return FillingStatus.NOT_SPECIFIED;
            default:
                 throw new IllegalArgumentException();
        }
    }

    private double getEnteredIncome(){
        double income=0;
        String response="";
        do{
        String enteredIncome = response+"\n" + JOptionPane.showInputDialog("Please enter income Amount...");
        try{
            income= Double.parseDouble(enteredIncome);
        }catch (NumberFormatException ex){
            response = "The Entered Income amount is not Valid";

        }
    }while(income<1);
    return income;
    }

    private int[] getEnteredOption() {
     int[] options;
     boolean optionsOK=false;
     String response="";
     Object[] inputOptions = { "OK" };
     do{
          
     //Get the Input from the User,(sepereated by Commas for more than one)
    String enteredOption  = JOptionPane.showInputDialog(response+"!\nPlease Enter the Filling Status \n\n" +
                "(0): Query \n" +
                "(1): Single \n" +
                "(2): Married(Joint)\n" +
                "(3): Married(Singly)\n"+
                "(4): Head of Household \n" +
                "(5): Listing\n");
    if(enteredOption==null)System.exit(1);
     if(enteredOption.contains("0") && enteredOption.contains(",")){
        response="Invalid Options Entered";
        optionsOK = false;
        options = new int[0];
        continue;
    }else if(enteredOption.contains("5") && enteredOption.contains(","))
     {
        response="Invalid Options Entered";
        optionsOK = false;
        options = new int[0];
        continue;
     }else if(enteredOption.equals("")){
       if(JOptionPane.showConfirmDialog(null,"Nothing was entered, Re-enter?", "Invalid", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        response="Nothing was Entered";
        optionsOK = false;
        options = new int[0];
       }else{
        System.exit(1);
       }
     }
        //Append the last comma in other to use String tokeniser to get last token
        enteredOption=enteredOption+",";
        //Innitialize a new String tokenizer using comma as delimeter
        StringTokenizer stringTokeniser = new StringTokenizer(enteredOption,",");
        //If it contains , and 0 OR , and 5 throw Exception of Invalid Argument
        
        //Count number of tokens based on Comma delimeter
        int noOfOptions=stringTokeniser.countTokens();
        //Initialize a new array of noOfOptions
         options = new int[noOfOptions];
        //Loop through to parse
         for(int i = 0; i< noOfOptions;i++){
          
          try{
         options[i]=Integer.parseInt(stringTokeniser.nextToken());
          
        //Check if number is 0
        if(options[i]==0)
        {
         options = new int[1];
         options[i] = 0;
        optionsOK = true;
        //Check if number is between 0 and 5
        }else if(options[i] > 0 && options[i] < 5){
            options[i] = options[i];
        //Check if number is 5
        }else if(options[i]==5)
        {
         options = new int[1];
         options[i] = 5;
       optionsOK = true;
        }

           }catch (NumberFormatException ex){
           response = "Invalid Number Format: "+ ex.getMessage();
           optionsOK = false;
        }

    }
    if(options.length > 0)optionsOK = true;

}while(options.length < 0 || !optionsOK);

    return options;
}

    private boolean restartReponse(String message){
 return JOptionPane.showConfirmDialog(parentFrame,message +"\n Restart The Application?","Restart",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION;
    }


}
