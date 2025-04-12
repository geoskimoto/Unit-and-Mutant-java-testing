package org.example;

public class Calculator {

	 public double sum(double [] arr){
	        //Creation of Array
	    	
	        double sum_ = 0;
	        for(int i =0; i < arr.length; i++){
	        	

	            sum_ += arr[i];
	        }
	        //adding all elements in an array
	        System.out.println("Addition: "+sum_);
	        return sum_;
	    }

	 public double subtract(double[] arr) {
		 
		 	//Creation of Array
		    double diff_ = arr[0];
		    for (int i = 1; i < arr.length; i++) {
		        diff_ -= arr[i];
		    }
	        //Subtracting all elements in an array

		    System.out.println("Subtraction: " + diff_);
		    return diff_;
		}
	   

	    public  double Multiplication(double [] arr){
	        //Creation of Array
	        double pro_ = 1;
	        for(int i = 0; i < arr.length; i++){
	            pro_ = pro_ * arr[i];
	        }
	        //Multiplying all elements in an array
	        System.out.println("product: " +pro_);
	        return pro_;
	    }

	    public double divide(double a, double b){
	    	if (b == 0) {
	            // if denominator is zero return some minimum value

	            System.out.println("Cannot divide by zero");
	            return Double.MIN_VALUE; 
	        }
	        double div_=a/b;
	        System.out.println("division of Given Two Numbers is: "+div_);
	        return  div_;
	    }

	    public double squareRoot(double radical){
	        if(radical < 0){
	        	
	            System.out.println("Square root of negative number cannot be real number");

	        	return Double.MIN_VALUE; 
	        }
	        double res = Math.sqrt(radical);
	        System.out.println("Square root: " + res);
	        return res;
	        
	    }
	    
	    public double moduloOfTwoNum(double a, double b) {
	        /*the modulo operation returns the remainder or signed remainder of a division,
	        after one number is divided by another (called the modulus of the operation).*/

	        // Handling negative values
	        if (a < 0) {
	            a = -a;
	        }
	        if (b < 0) {
	            b = -b;
	        }
	        if(b == 0){
	            System.out.println("mod 0 is undefined ");
	            return Double.MIN_VALUE;
	        }

	        // Finding mod by repeated subtraction
	        double mod = a;
	        while (mod >= b) {
	            mod = mod - b;
	        }

	        // Sign of result typically depends
	        // on sign of a
	        if (a < 0) {
	            return -mod;
	        }

	        System.out.println("Modulo of 2 numbers: " + mod);

	        return mod;
	    }

	   
	    public double Average(double [] arr){
	    	
	    	if (arr.length == 0) {
	            throw new IllegalArgumentException("Input array cannot be empty");
	        }
	    	
	        double sum_ = 0;
	        
	        for(int i =0; i < arr.length; i++){
	            sum_ += arr[i];
	        }
	        //calculating Average of all elements in an array
	        double average = sum_ / (arr.length);
	        System.out.println("Average of numbers: " +average);
	        return average;
	    }
	   
	    public int factorial(int n) {
	        if (n < 0) {
	            System.out.println("If the given integer is negative,n! is not defined\n");
	            return 0;
	        } else if (n == 0 || n == 1) {
	            return 1;
	        } else {
	            return n * factorial(n - 1);
	        }
	    }



}


