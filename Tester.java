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
		String result = "";
		if(inputParts.length == 1){
			if(arithmetic == "mag"){
				result = accumulator.getMagnitude();
			}else if(arithmetic == "conj"){
				result = arithmetic.getConjugate();
			}else{
				result = "arithmetic not understood";
			}
		}else if(inputParts.length == 2){
				String complexExppression = new Complex(inputParts[1]); 
				Complex complexObject = new Complex(complexExppression);
				if(validUserInput(userInput))
				{
					String arithmetic = inputParts[0];
					String complexExppressiom = inputParts[0];
					 if(arithmetic == "mag"){
						result = complexObjectEntered.Magnitude();
					}else if(arithmetic == "conj"){
						result = complexObjectEntered.Conjugate();
					}else if(arithmetic == "add" || arithmetic == "+"){
						String complexExppression = inputParts[1]; 
						result = accumulator.add(complexObjectEntered);
					}else if(arithmetic == "sub" || arithmetic == "-"){ 
						result = accumulator.substract(complexObjectEntered);
					}else if(arithmetic == "div" || arithmetic == "/"){  
						result = accumulator.divide(complexObjectEntered);
					}else if(arithmetic == "mul" || arithmetic == "*"){ 
						result = ""+accumulator.multiply(complexObjectEntered);
					}else{
						result = "arithmetic not understood";
					}
		
				}
		}else{
			result = "Expression entered not correct ";
		}

		 System.out.println("Your result is " + result);
		 

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