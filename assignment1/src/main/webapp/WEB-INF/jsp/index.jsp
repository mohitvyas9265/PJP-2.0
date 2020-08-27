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
 	<h2>Date ${date}!</h2>
</body>
</html>