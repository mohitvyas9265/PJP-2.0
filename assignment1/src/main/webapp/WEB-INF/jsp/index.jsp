<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date Time Calculator</title>
</head>
<body>
	<h2> Select the function</h2>
	<h3> To Add, Subtract between two dates and express the output in days, dates, 
weeks, months:</h3>
	<br>
	<form action="/calculate1">
 		Enter  starting Date : <input type="text" name="date1"><br>
             <select name = "operation">
               <option value = "add">add</option>
               <option value = "substract">substract</option>
             </select>
          Enter  ending Date : <input type="text" name="date2"><br>   
 		<input type="submit">
 	</form>
 	<h2>${date}</h2>
 	<h3>Add, Subtract 'n' Days, Months, Weeks to the given date and derive the final 
date</h3>h3>
	<br>
	<form action="/calculate2">
		Enter Starting date: <input type="text" name="date3"><br>
		<select name = "operation1">
               <option value = "add">add</option>
               <option value = "substract">substract</option>
             </select>
          Enter  days: <input type="number" name="days"><br>  
          Enter  months: <input type="number" name="months"><br>  
          Enter  weeks: <input type="number" name="weeks"><br>   
 		<input type="submit">
	
	</form>
	<h2>${date4}</h2>
	<br>
	<h3>Determine the Day of the Week for a given date</h3>
	<form action="/calculate3">
		Enter date: <input type="text" name="date"><br>
 		<input type="submit">
	
	</form>
	<h2>${week}</h2>
	<br>
	<h3>Determine the Week number for a given a date</h3>
	<form action="/calculate4">
	 Enter date:<input type ="text" name="date"><br>
	 <input type="submit">
	</form>
	<h2>${weekNumber}</h2>
	
</body>
</html>