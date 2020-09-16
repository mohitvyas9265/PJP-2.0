function convertDate(d)
{
	var d1 = d.split("/");
    var date = new Array();
    date.push(parseInt(d1[0]));
    date.push(parseInt(d1[1]));
    date.push(parseInt(d1[2]));
    return date;
}
function dateCalc()
{
	var d2 = document.getElementById("date");
	var f2 = document.getElementById("func"); 
	var d = d2.value;
	var f = f2.value;
    document.getElementById("out").textContent = d + "  " + f;

    processDate(d,f);
}

function processDate(d,f)
{
	var date = convertDate(d);
	//console.log(date);
	var f1 = f.split(" ");
	if(f1.length == 2)
	{
		if(f1[0] == "difference")
			return date_diff(date,convertDate(f1[1]));
		if(f1[0] == "add")
			return date_add(date,parseInt(f1[1]));
	}
	if(f1.length == 1)
	{
		if(f1[0] == "nextday")
			return date_add(date,1);
		else if(f1[0] == "tommorow")
			return date_add(date,1);
		else if(f1[0] == "yesterday")
			return date_add(date,-1);
		else if(f1[0] == "nextweek")
			return date_add(date,7);
		else if(f1[0] == "lastweek")
			return date_add(date,-7);
		else if(f1[0] == "nextyear")
			return date_add(date,365);
		else if(f1[0] == "lastyear")
			return date_add(date,-365);
		else if(f1[0] == "nextmonth")
			return date_add(date,30);
		else if(f1[0] == "lastmonth")
			return date_add(date,-30);
		else
			return "";
	}
	if(f1.length == 3)
	{
		if(f1[0] == "after")
		{
			if(f1[2] == "days") return date_add(d, parseInt(f1[1]));
			else if(f1[2] == "months") return date_add(date, 30*parseInt(f1[1]));
			else if(f1[2] == "weeks") return date_add(date, 7*parseInt(f1[1]));
			else if(f1[2] == "years") return date_add(date, 365*parseInt(f1[1]));
			else return "";
		}
		if(f1[0] == "before")
		{
			if(f1[2] == "days") return date_add(d, -1*parseInt(f1[1]));
			else if(f1[2] == "months") return date_add(date, -30*parseInt(f1[1]));
			else if(f1[2] == "weeks") return date_add(date, -7*parseInt(f1[1]));
			else if(f1[2] == "years") return date_add(date, -365*parseInt(f1[1]));
			else return "";
		}
	}
}

function countLeapYears(d)  
	{ 
	var years = d[2]; 
	if (d[1] <= 2)  
	{ 
	years--; 
	} 
	return Math.floor(years / 4) - Math.floor(years / 100) + Math.floor(years / 400); 
	} 
function date_diff(dt1,dt2)
{
		console.log(dt1);
		console.log(dt2);
		var monthDays  = [31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31];
	    var n1 = dt1[2] * 365 + dt1[0]; 
        for (var i = 0; i < dt1[1] - 1; i++)  
        { 
            n1 += monthDays[i]; 
        }
        n1 += countLeapYears(dt1); 
        var n2 = dt2[2] * 365 + dt2[0]; 
        for (var i = 0; i < dt2[1] - 1; i++) 
        { 
            n2 += monthDays[i]; 
        } 
        n2 += countLeapYears(dt2); 
       // document.getElementById("out").textContent = n2-n1;
       return (n2-n1) + "";
}

function date_add(d,n)
{
	var date = new Date(d[2],d[1],d[0]);
	console.log(d + " " + n);
    date.setDate((date.getDate() + n)%30);
    console.log(date);
    console.log(date.getDay());
    var x = Math.floor((date.getDate()+n)/30);
    return date.getDate() + "/" + (date.getMonth() + x) + "/" + date.getFullYear();
     //document.getElementById("date").textContent = (date.getMonth()+1) + "/" + date.getDate() + "/" + date.getFullYear();
}

module.exports = {
  processDate
};