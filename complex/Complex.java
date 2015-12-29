/**
 * File: Complex.java
 * -------------------
 * Implements a new abstraction for manipulating complex numbers.
 */


public class Complex 
{
	private double realPart;
	private double imaginaryPart;

    /**
     * Constructor: Complex
     * Usage: Complex complex = new Complex();
     * --------------------------------------
     * Initializes a new empty Complex object.
     * @Author: 
     */


    public Complex()
	{
		this.realPart = 0;
		this.imaginaryPart = 0;
	}


    /**
     * Constructor: Complex
     * Usage: Complex complex = new Complex(realPart, imaginaryPart);
     * --------------------------------------------------------------
     * Initializes a new empty Complex object.
     * @Author: 
     */


	public Complex(double realPart, double imaginaryPart)
	{
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

  
    /**
     * Method: add
     * Usage: Complex complex = complex1.add(complex2);
     * ------------------------------------------------
     * @return complex The result of adding operand complex1 and operand complex2.
     * @Author:
     */

	public Complex add(Complex complex)
	{
		return new Complex(complex.realPart + this.realPart, complex.imaginaryPart + this.imaginaryPart);
	}


	/**
     * Method: sub
     * Usage: Complex complex = complex1.sub(complex2);
     * ------------------------------------------------
     * @return complex The result of subtracting operand complex2 from operand complex2.
     * @Author:
     */

	public Complex sub(Complex complex)
	{
		return new Complex(complex.realPart - this.realPart, complex.imaginaryPart - this.imaginaryPart);
	}

    
    /**
     *  Method: multiply
     *  Usage: Complex complex = complex1.multiply(complex2);
     * -------------------------------------------------------
     * @param complex The product of complex1 and complex2.
     */

	public Complex multiply(Complex complex)
	{
		double operand1, operand2, operand3, operand4;


		operand1 = complex.realPart * this.realPart;
		operand2 = complex.realPart * this.imaginaryPart;

		operand3 = complex.imaginaryPart * this.realPart;
		operand4 = complex.imaginaryPart * this.imaginaryPart;


		//Simplify and group the four operands into 3, 1.e operand1, operand2, operand3
		//Operand1 retains its state.

	    operand2 = operand2 + operand3;
	    operand3 = operand4 * -1;

	    this.realPart = operand1 + operand3;
	    this.imaginaryPart = operand2;

	    return this;
	}


	/**
     *  Method: divide
     *  Usage: Complex complex = complex1.divide(complex2);
     * -------------------------------------------------------
     * @param complex The result of dividing operand complex1 by operand complex2.
     * @Author:
     */

    public Complex divide(Complex complex)
    {
    	Complex conjugateComplex = conjugate(complex); //Conjugate of numerator
    	Complex numerator = this.multiply(conjugateComplex);
    	Complex denomenator = complex.multiply(conjugateComplex);
    	return new Complex(numerator.realPart / denomenator.realPart, numerator.imaginaryPart / denomenator.realPart);
    }


    /**
     * Class Method: conjugate
     * Usage: Complex complex = Complex.conjugate(complex);
     * ----------------------------------------------------
     * @Return complex The conjugate complex of complex
     * @Author: 
     */

	public static Complex conjugate(Complex complex)
	{
		return new Complex(complex.realPart, (complex.imaginaryPart) * -1);
	}



    /**
     * Class Method: angle
     * Usage: double angle = angle(complex);
     * -------------------------------------
     * @return angle The angle of complex
     * @author: 
     */

	public static double angle(Complex complex)
	{
		return Math.atan2(complex.imaginaryPart, complex.realPart);
	}

	/**
     * Class Method: magnitude
     * Usage: double magnitude = magnitude(complex);
     * --------------------------------------------
     * @return magnitude The magnitude of complex
     * @author: 
     */

	public static double magnitude(Complex complex)
	{
		return Math.abs(Math.sqrt((Math.pow(complex.realPart, 2)) + (Math.pow(complex.imaginaryPart, 2))));
	}


	/**
	 * Method: toString
	 * Usage: String complexStr = complex.toString();
	 * -----------------------------------------------
	 * @param complexStr The string equivalent of object complex.
	 */

	public String toString()
	{	
		//When a complex number is multiplied by its conjugate, the result is always a positive, real number:
		
		if (this.imaginaryPart == 0)
		{
			return String.format("%.1f", this.realPart);
		}
		// Pure imaginary number
		else if (this.realPart == 0)
		{
			if (this.imaginaryPart < 0)
			{
			 	return String.format("- j%.1f", (this.imaginaryPart) * -1);
			}
			else
			{
				return String.format("j%.1f", this.imaginaryPart);
			}
		}
		else if (this.imaginaryPart < 0)
		{
		 	return String.format("(%.1f - j%.1f)", this.realPart, (this.imaginaryPart) * -1);
		}
		else
		{
			return String.format("(%.1f + j%.1f)", this.realPart, this.imaginaryPart);
		}

	}
}