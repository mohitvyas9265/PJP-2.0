package com.sapient.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		IncomeCalculate ob =new IncomeCalculate();
		ob.abc();
		ob.loadConvert("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\SapientCodingExercise\\SampleInput.csv");
		ob.print("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\SapientCodingExercise\\SampleOutput.csv");
		BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\SapientCodingExercise\\SampleOutput.csv"));
		while(csvReader.readLine()!=null)
		{
			String data=csvReader.readLine();
			System.out.println(data);
		}
		
	}

}
