import java.util.Scanner;
public class Tester{

	Complex accumulator;
	

	
	public static void main(String [] args){

		Complex accumulator = new Complex(2,3);
		Scanner scanner;
		scanner = new Scanner(System.in);

		System.out.println("Please enter the complex expression to using format ?. add a + bi \n a = conjugate \n b = \n i = ");
		String userInput = scanner.nextLine();
		String[] inputParts = splitUserInput(userInput);
		String arithmeticEntered = inputParts[0];
		String complexExppressionEnteredEntered = inputParts[1];
		String result = "";
		if(inputParts.length == 1){
			if(arithmeticEntered == "mag"){
				result = accumulator.Magnitude();
			}else if(arithmeticEntered == "conj"){
				result = arithmeticEntered.Conjugate();
			}else{
				result = "arithmeticEntered not understood";
			}
		}else if(inputParts.length == 2){
				Complex complexExppressionEntered = new Complex(inputParts[1]);  
				if(validUserInput(userInput))
				{ 
					String complexExppressionEntered = inputParts[0];
					 if(arithmeticEntered == "mag"){
						result = complexObjectEntered.Magnitude();
					}else if(arithmeticEntered == "conj"){
						result = complexObjectEntered.Conjugate();
					}else if(arithmeticEntered == "add" || arithmeticEntered == "+"){
						String complexExppressionEntered = inputParts[1]; 
						result = accumulator.Add(complexObjectEntered);
					}else if(arithmeticEntered == "sub" || arithmeticEntered == "-"){ 
						result = accumulator.Substract(complexObjectEntered);
					}else if(arithmeticEntered == "div" || arithmeticEntered == "/"){  
						result = accumulator.divide(complexObjectEntered);
					}else if(arithmeticEntered == "mul" || arithmeticEntered == "*"){ 
						result = ""+accumulator.Multiply(complexObjectEntered);
					}else{
						result = "arithmeticEntered not understood";
					}
		
				}
		}else{
			result = "Expression entered not correct ";
		}

		 System.out.println("Your result is " + result);
		 

	}

	private static boolean validUserInput(String input){
		//Validation logic here
		return true;
	}


	public static String[] splitUserInput(String userInput){
		String inputParts[] = userInput.split(" ");
		if(inputParts.length > 1){
			return inputParts;
		}else{
			throw new RuntimeException("Please enter correct input");
		}
	}
}