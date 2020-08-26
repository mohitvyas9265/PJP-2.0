package com.sapient.assignment2code;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		Transaction tc = new Transaction();
		tc.load("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\Assignment 2 Java\\Input.csv");
		tc.print("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\Assignment 2 Java\\Output.csv");
		
	}

}
