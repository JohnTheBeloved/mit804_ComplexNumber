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
		String complexExppressionStringEntered = inputParts[1];
		String result = "";
		if(inputParts.length == 1){
			if(arithmeticEntered == "mag"){
				result = accumulator.Magnitude();
			}else if(arithmeticEntered == "conj"){
				result = accumulator.Conjugate();
			}else{
				result = "arithmeticEntered not understood";
			}
		}else if(inputParts.length == 2){
				Complex complexExppression = new Complex(complexExppressionStringEntered);  
				if(validUserInput(userInput))
				{  
					 if(arithmeticEntered == "mag"){
						result = complexExppression.Magnitude();
					}else if(arithmeticEntered == "conj"){
						result = complexExppression.Conjugate();
					}else if(arithmeticEntered == "add" || arithmeticEntered == "+"){
						 result = accumulator.Add(complexExppression).toString();
					}else if(arithmeticEntered == "sub" || arithmeticEntered == "-"){ 
						result = accumulator.Substract(complexExppression).toString();
					}else if(arithmeticEntered == "div" || arithmeticEntered == "/"){  
						result = accumulator.Divide(complexExppression).toString();
					}else if(arithmeticEntered == "mul" || arithmeticEntered == "*"){ 
						result = accumulator.Multiply(complexExppression).toString();
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