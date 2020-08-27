package com.sapient.assignment1;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;

public class Date1 
{
	DateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
	final int[] daysOfMonth={ 0, 31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31 };  
	final String[] daysOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	public String addDate(String startDate,String endDate) throws ParseException
	{
		Date d1;
		d1= sdf.parse(startDate);
		System.out.println(d1.getTime());
		Date d2;
		d2= sdf.parse(endDate);
		long sum=d1.getTime()+d2.getTime();
		return(convert(sum));

	}
	public String substractDate(String startDate,String endDate) throws ParseException
	{
		Date d1;
		d1= sdf.parse(startDate);
		System.out.println(d1.getTime());
		Date d2;
		d2= sdf.parse(endDate);
		long diff=d1.getTime()-d2.getTime();
		return(convert(diff));
		
	}
	public String addDays(String startDate,int days,int weeks,int months) throws ParseException
	{
		System.out.println("Hey" +startDate);
		Date d1=sdf.parse(startDate);
		long ms=d1.getTime();
		System.out.println(ms);
		long cnt=0;
		if(days>0)
			cnt+=(long)(days*24*60*60*1000);
		if(weeks>0)
			cnt+=(long)(weeks*7*24*60*60*1000);
		if(months>0)
			cnt+=(long)(months*30*24*60*60*1000);
		ms+=cnt;
		System.out.println(ms);
		Date d2=new Date(ms);
		String date=sdf.format(d2);
		return date;
		
		
	}
	public String substractDays(String startDate,int days,int weeks,int months) throws ParseException
	{
		Date d1=sdf.parse(startDate);
		long ms=d1.getTime();
		long cnt=0;
		cnt+=(long)(days*24*60*60*1000);
		cnt+=(long)(weeks*7*24*60*60*1000);
		cnt+=(long)(months*30*24*60*60*1000);
		ms-=cnt;
		Date d2=new Date(ms);
		String date=sdf.format(d2);
		return date;
		
		
	}
	public String convert(long sum)
	{
		long days=sum/(1000l*60*60*24);
		long years = sum/(1000l * 60 * 60 * 24 * 365);
		Date newDate= new Date(sum);
		String date=sdf.format(newDate);
		long week=sum/(1000l*60*60*24*52);
		long months=sum/(1000l*60*60*24*12);
		return(days+ " days "+years+" years "+date+" date "+week+" week "+months+" months");
	}
	public String dayOfWeek(String str) throws ParseException
	{
		String[] date= str.split("-");
		int d=Integer.parseInt(date[0]);
		int m=Integer.parseInt(date[1]);
		int y=Integer.parseInt(date[2]);
		int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 }; 
		y -= (m < 3) ? 1 : 0; 
		int index=( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7; 
		return daysOfWeek[index];		
	}
	public int weekNumber(String str)
	{
		String[] date= str.split("-");
		int d=Integer.parseInt(date[0]);
		int m=Integer.parseInt(date[1]);
		int y=Integer.parseInt(date[2]);
		int days=0;
		if(y%4==0&&m>2)
			days++;
		for(int i=1;i<m;i++)
		{
			days+=daysOfMonth[i];
		}
		days+=d;
		return((days/7)+1);
		
	}
	
	public static void main(String[] args) throws ParseException 
	{
		Date1 ob = new Date1();
		//ob.addDate("01-02-0001", "12-01-0001");
		//ob.substractDate("01-02-0001", "31-01-0001");
		ob.addDays("16-10-1998", 0, 0, 1);
		System.out.println(ob.dayOfWeek("28-08-2020"));
		System.out.println(ob.weekNumber("28-01-2020"));
		
	}

}
