package com.sapient.assignment2code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Transaction 
{
	Map<String,String> mp= new HashMap<String, String>();
	Map<String,Integer> tr= new HashMap<String, Integer>();
	
	public void load(String str) throws IOException
	{
		BufferedReader csvReader = new BufferedReader(new FileReader(str));
		String row;
		while((row=csvReader.readLine())!=null)
		{
			String[] data=row.split(",");
			process(data);
		}
	}
	public void process(String[] data)
	{
		String name=data[0];
		int processingId=Integer.parseInt(data[1]);
		int clientId=Integer.parseInt(data[2]);
		int securityId=Integer.parseInt(data[3]);
		String transactionType=data[4];
		String date=data[5];
		//SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
		//Date date = DateFor.parse(data[4]);
		int marketValue=Integer.parseInt(data[6]);
		String priority = data[7];
		String str="";
		if(mp.containsKey(clientId+","+securityId+","+date))
		{
			if(transactionType.equals("Buy")&&mp.get(clientId+","+securityId+","+date).equals("Sell"))
			{				
				mp.put(clientId+","+securityId+","+date,transactionType);
					System.out.println("Hi");
					tr.put(clientId+","+"Buy"+","+date+","+priority,10);
					String priorityTemp=getValue(transactionType,clientId,date);
					if(priorityTemp.equals("Y")||priorityTemp.equals("N"))
						tr.put(clientId+","+"Sell"+","+date+","+priorityTemp,10);
					
					
	
				
			}
			else if(transactionType.equals("Sell")&&mp.get(clientId+","+securityId+","+date).equals("Buy"))
			{
				mp.put(clientId+","+securityId+","+date,transactionType);
					System.out.println("Hi");
					tr.put(clientId+","+"Sell"+","+date+","+priority,10);
					String priorityTemp=getValue(transactionType,clientId,date);
					if(priorityTemp.equals("Y")||priorityTemp.equals("N"))
						tr.put(clientId+","+"Buy"+","+date+","+priorityTemp,10);
					
			}
			
		}
		else
		{
			mp.put(clientId+","+securityId+","+date,transactionType);
			if(priority.equals("Y"))
			{
				tr.put(clientId+","+transactionType+","+date+","+priority,500);
			}
			else if(priority.equals("N")&&(transactionType.equals("Sell")||transactionType.equals("Withdraw")))
			{
				tr.put(clientId+","+transactionType+","+date+","+priority,100);
			}
			else if(priority.equals("N")&&(transactionType.equals("Buy")||transactionType.equals("Deposit")))
			{
				tr.put(clientId+","+transactionType+","+date+","+priority,50);
			}
			else
				System.out.println("Invalid details for processing id"+processingId);
			
		}
		
	}
	public String getValue(String transactionType,int clientId,String date)
	{
		
		for(Map.Entry<String,Integer> it : tr.entrySet())
	      {
			if(it.getKey()== clientId+","+transactionType+","+date+","+"Y")
			{
				return "Y";
				
				
			}
			else if(it.getKey()== clientId+","+transactionType+","+date+","+"N")
			{
				return "N";
				
				
			}
			
	      }
		return "";
	}
	public boolean print(String str)
	{
		
		try (PrintWriter writer = new PrintWriter(new File(str))) 
		{
			writer.print("");

		      StringBuilder sb = new StringBuilder();
		      for(Map.Entry<String,Integer> it : tr.entrySet())
		      {
		    	  System.out.println(it.getKey()+it.getValue());
		    	  
		    	  String key=it.getKey();
		    	  int amount =it.getValue();
		    	  sb.append(key);
		    	  sb.append(",");
		    	  sb.append(amount);
		    	  sb.append('\n');
		    	  
		    	  
		    	  
		    	  
		      } 
		     // System.out.println(sb.toString());
		      writer.write(sb.toString());
		      return true;
		      
		      

		 } 
		catch (FileNotFoundException e) 
		{
			
		      System.out.println(e.getMessage());
		      return false;
		}
	}
}
