package assignment2;

import java.util.Scanner;

class Range extends Exception {
	public Range(String n){
		super(n);
	}
}
public class ExceptionEx9 {
    static void rangeValidate (int number) throws Range {    
       if(number < 0 || number  > 100) {  
	        // throw an object of user defined exception  
	        throw new Range("Out Of Range");    
       }  
       else {   
    	   System.out.println("In Range");   
       }   
     }   

	public static void main(String[] args) {
			// TODO Auto-generated method stub
		try {  
	            // calling the method   
	            rangeValidate(11);  
		} catch (Range ex) {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	      }  
	}   

}
