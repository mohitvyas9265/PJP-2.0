package com.sapient.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IncomeCalculate 
{
	
	//load
	//convert into usd
	//group by country/gender
	//country A/Male/per capita
	//country A/Female/per capita
	//write into file
	Map<String,Float> mp = new HashMap<>();
	Map<String,Integer> count = new HashMap<>();
	String str;
	public void loadConvert(String str) throws IOException
	{
		BufferedReader csvReader = new BufferedReader(new FileReader(str));
		String row;
		while((row=csvReader.readLine())!=null)
		{
			String[] data=row.split(",");
			String city=data[0];
			String country=data[1];
			String gender=data[2];
			String currency=data[3];
			float amount=Float.parseFloat(data[4]);
			try
			{
			if(currency.equals("INR"))
			{
				amount =amount/66;
			}
			else if(currency.equals("GBP"))
			{
				amount=amount/(float)0.67;
			}
			else if(currency.equals("HKD"))
			{
				amount=amount/8;
			}
			else if(currency.equals("SGD"))
			{
				amount=amount/(float)1.5;
			}
			else
				throw new Exception("Invalid currency");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(country.equals(""))
			{
				if(mp.containsKey(city+","+gender))
				{
					System.out.println("1");
					float capita=mp.get(city+","+gender);
					int countMap =count.get(city+","+gender);
					amount=((capita*countMap)+amount)/(countMap+1);
					mp.	put(city+","+gender,amount);
					count.put(city+","+gender, countMap+1);					
				}
				else
				{
					System.out.println("2");
					mp.	put(city+","+gender,amount);
					count.put(city+","+gender,1);	
				}
			}
			else
			{
				if(mp.containsKey(country+","+gender))
				{
					System.out.println("3");
					float capita=mp.get(country+","+gender);
					int countMap =count.get(country+","+gender);
					amount=((capita*countMap)+amount)/(countMap+1);
					mp.	put(country+","+gender,amount);
					count.put(country+","+gender, countMap+1);					
				}
				else
				{
					System.out.println("4");
					mp.	put(country+","+gender,amount);
					count.put(country+","+gender,1);	
				}
				
			}			
		}
		csvReader.close();
	}
	public boolean print(String str)
	{
		
		try (PrintWriter writer = new PrintWriter(new File(str))) 
		{
			writer.print("");

		      StringBuilder sb = new StringBuilder();
		      for(Map.Entry<String,Float> it : mp.entrySet())
		      {
		    	  String key=it.getKey();
		    	  Float amount =it.getValue();
		    	  sb.append(key);
		    	  sb.append(",");
		    	  sb.append(amount);
		    	  sb.append('\n');
		    	  writer.write(sb.toString());
		    	  
		    	  
		      }    
		      return true;
		      
		      

		 } 
		catch (FileNotFoundException e) 
		{
			
		      System.out.println(e.getMessage());
		      return false;
		}
	}
	

}
