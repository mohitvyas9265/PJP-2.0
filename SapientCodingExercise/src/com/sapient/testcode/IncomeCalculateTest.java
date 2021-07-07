package com.sapient.testcode;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.sapient.code.IncomeCalculate;

class IncomeCalculateTest {

	@Test
	void test1() throws IOException 
	{
		IncomeCalculate ob = new IncomeCalculate();
	ob.loadConvert("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\SapientCodingExercise\\SampleInput.csv");
	assertEquals(true,ob.print("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\SapientCodingExercise\\SampleOutput.csv"));                                                                                                        
		
	}
	@Test
	void test() throws IOException 
	{
		IncomeCalculate ob = new IncomeCalculate();
	ob.loadConvert("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\SapientCodingExercise\\SampleInput.csv");
	assertEquals(false,ob.print("C:\\Users\\Mohit\\projects\\PJP-2.0\\PJP-2.0\\SapientCodingExercise"));                                                                                                        
		
	}

}
