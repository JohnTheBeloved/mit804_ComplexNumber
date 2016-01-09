/*
 * File: ComplexTest.java 
 * ----------------------
 * Tests Complex.java interface.
 */


import java.util.Scanner;
import java.util.StringTokenizer;


public class ComplexTest
{

  static Complex accumulator = new Complex();
  static String opr = new String();

	public static void main(String [] args)
	{
		
		Scanner input = new Scanner(System.in);
		String line = null;
		String operator = null; 
		String lhsOperand = null; // left hand side operand.
		String rhsOperand = null; // right hand side operand.
		String expression = null;
		String cmd = null;
		int tokenLength = 0;
		String instruction = null;

		System.out.println("\n\n          Complex Number Calculator        ");
		System.out.println("============================================");

		System.out.print("Do You Want instruction(Yes or No)? ");
		instruction = input.nextLine();
		if (instruction.equalsIgnoreCase("yEs")) displayInstructions();

		while(true)
		{
			System.out.print("\n\n.? ");
			line = input.nextLine(); //read line.

			if (line.equalsIgnoreCase("end"))
			{
				System.out.println("Thanks for using Complex Number Calculator.");
				break;
			}

			String [] tokens = line.split(" ");

			tokenLength = tokens.length;

			if (tokenLength == 1 || tokenLength == 2)
			{
				if (!validCommand(tokens[0]))
				{
					System.err.printf("Unknown Command %s\n", tokens[0]);
					System.out.println("Press any Key to continue....");
					input.nextLine();
					continue;
				}


				if (tokenLength == 1)
				{
					//Only cnj and mag can work without any operand, e.g ?. mag
					if (tokens[0].equalsIgnoreCase("cnj"))
					{
						accumulator = Complex.conjugate(accumulator);
						System.out.printf("     ========>  %s\n", accumulator.toString());
					}
					else if (tokens[0].equalsIgnoreCase("mag"))
					{
						double magnitude = Complex.magnitude(accumulator);
						System.out.printf("     ========>  %.1f", magnitude);
					}
					else if(tokens[0].equalsIgnoreCase("ang"))
					{
						double angle = Complex.angle(accumulator);
						System.out.printf("     ========>  %.1f", angle);

					}
					else
					{
						System.err.printf("Command %s requires at least one argument(operand)\n", tokens[0]);
						System.out.println("Press any key to continue...");
						input.nextLine();
						continue;
					}
				}
				else
				{
					double realPart;
					double imaginaryPart;
					boolean ret;
					Complex complex = getComplexFromExpression(tokens[1], tokenLength);

					if (complex == null)
					{
						System.out.println("Press any key to continue...");
						input.nextLine();
						continue;
					}

					//System.out.println(complex.toString());


					if (tokens[0].equalsIgnoreCase("ang") || tokens[0].equalsIgnoreCase("cnj") || tokens[0].equalsIgnoreCase("mag"))
					{
						Complex tempComplex = performOperation(tokens[0], complex);
						System.out.println(tempComplex.toString());
					}
					else
					{
						accumulator = performOperation(tokens[0], complex);
						System.out.printf("     ========>  %s\n", accumulator);
					}	
				}

			} 
			else if(tokenLength == 3) 
			{
				double realPart;
				double imaginaryPart;
				String opr = null;
				Complex complex2 = null;


				if (!validCommand(tokens[1]))
				{
					System.err.printf("Unknown Command %s\n", tokens[2]);
					System.out.println("Press any Key to continue....");
					input.nextLine();
					continue;
				}

	
				Complex complex1 = getComplexFromExpression(tokens[0], tokenLength);

				if (complex1 == null)
				{
					System.out.println("Press any key to continue...");
					input.nextLine();
					continue;
				}

				complex2 = getComplexFromExpression(tokens[2], tokenLength);

				if (complex2 == null)
				{
					System.out.println("Press any key to continue...");
					input.nextLine();
					continue;
				}

				accumulator = performOperation(tokens[1], complex1, complex2);
				System.out.printf("     ========>  %s\n", accumulator);
			}
			else
			{
				    System.err.printf("Unknown Command %s\n", line);
					System.out.println("Press any Key to continue....");
					input.nextLine();
					continue;
			}

		}
	}



	/**
    * Method: performOperation
    * Usage: complex = performOperation(command, complex1);
    * -----------------------------------------------------
    * @param complex1, complex number(operand);
    * @return complex Result of performing command operation on operands accumulator(Complex) and complex
    * @Author: 
    */

	static Complex performOperation(String command, Complex complex)
	{
		if (command.equalsIgnoreCase("mag"))
		{
			return new Complex(Complex.magnitude(complex), 0.0);
		}
		else if (command.equalsIgnoreCase("cnj"))
		{
			return Complex.conjugate(complex);
		}
		else if (command.equalsIgnoreCase("ang"))
		{
			return new Complex(Complex.angle(complex), 0.0);
		}
		else
		{
			switch(command)
			{

				case "add": case "+": return accumulator.add(complex);
				case "sub": case "-": return accumulator.sub(complex);
				case "mul": case "*": return accumulator.multiply(complex);
				case "div": case "/": return accumulator.divide(complex);
				default: return accumulator;
			}
		}
	}

   /**
    * Method: performOperation
    * Usage: complex = performOperation(command, complex1, complex2);
    * ---------------------------------------------------------------
    * @param complex1, First complex number(operand 1);
    * @param complex2, Second complex number(operand 2);
    * @return complex Result of performing command operation on operands complex1 and complex2
    * @Note: This is an overloaded method of the first performOperation.
    * @Author: 
    */

	static Complex performOperation(String command, Complex complex1, Complex complex2)
	{
		accumulator = new Complex();

		switch(command)
		{
			case "add": case "+": return complex1.add(complex2);
			case "sub": case "-": return complex1.sub(complex2);
			case "mul": case "*": return complex1.multiply(complex2);
			case "div": case "/": return complex1.divide(complex2);
			default: return accumulator;
		}
	}

	/**
	 * Predicate Function: validCommand
	 * Usage: if (validCommand(command)) ...
	 * -------------------------------------
	 * @param command Command to check
	 * @return Returns true if command is a valid command, otherwise it returns false.
	 * @Author: 
	 */
	static boolean validCommand(String command)
	{
		switch(command)
		{
			case "add": case "+":
			case "sub": case "-":
			case "mul": case "*":
			case "div": case "/":
			case "mag": case "cnj":
			case "ang": return true;
			default: return false;
		}
	}


	
	/**
	 * Procedure: displayInstructions
	 * Usage: displayInstructions();
	 * -----------------------------
	 * Displays instructions on the console.
	 */

	static void displayInstructions()
	{
		System.out.println("To quit the program enter the word end");
	}

	
	/**
	 * Method: getComplexFromExpression
	 * Usage: Complex complex = getComplexFromExpression(expression, args);
	 * --------------------------------------------------------------------
	 * @param expression The rhs or lhs expression entered by the client.
	 * @param args The number of tokens in user input.
	 * @return complex Null if the user input is invalid, otherwise it returns a complex number.
	 */

	static Complex getComplexFromExpression(String expression, int args)
	{
		int len = 0;
		char ch;
		String [] tokens;
		String lhs = null;
		String rhs = null;
		int i;
		int imaginaryIndex;
		String imaginaryPart;
		String realPart;
		double rPart, iPart;

		len = expression.length();

		for (i = 0; i < len; i++)
		{
			ch = expression.charAt(i);

			if (ch == '-' || ch == '+' || ch == '/' || ch == '*') {
				opr = new String(String.format("%c", ch));
				lhs = expression.substring(i + 1);
				rhs = expression.substring(0, i);
				break;
			}
			
		}

		if (i == len)
		{
			//e.g j0.2 + 2.0+j3.0 
			if (args == 3)
			{
				imaginaryIndex = expression.indexOf('j');
				
				rPart = iPart = 0;

				if (imaginaryIndex == -1) //set realPart
				{
					// Only real part is available.
					rPart = Double.parseDouble(expression); 
				}
				//set imaginary part
				else
				{
					iPart = Double.parseDouble(expression.substring(imaginaryIndex + 1));
				}

				return new Complex(rPart, iPart);
			}
			else
			{
				System.err.printf("Expression %s does not have operator\n", expression);
			    return null;
			}
			
		}

		if ((lhs.indexOf('j') == -1) && (rhs.indexOf('j') == -1))
		{
			System.err.printf("Imaginary part is not specified in command %s\n", expression);
			return null;
		}


		imaginaryIndex = lhs.indexOf('j');

		if (imaginaryIndex != -1)
		{
			imaginaryPart = String.format("%s%s", opr, lhs.substring(imaginaryIndex + 1));
			realPart = String.format("%s", rhs);
		}
		else 
		{
			realPart = String.format("%s%s", opr, lhs);
		    imaginaryPart =  rhs.substring(imaginaryIndex + 1);
		}

		rPart = Double.parseDouble(realPart);
		iPart = Double.parseDouble(imaginaryPart);

		return new Complex(rPart, iPart);

	}
}