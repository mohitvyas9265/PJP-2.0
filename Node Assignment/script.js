function displayRadioValue() {
    var ele = document.getElementsByName('operator');

    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked)
            return ele[i];
    }
}
function convertDateToDays(date)
{
    var d = date.split("-");
    var dateArray = new Array();
    date.push(parseInt(d[0]));
    date.push(parseInt(d[1]));
    date.push(parseInt(d[2]));
    var monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    var numberOfDays = dateArray[2] * 365 + dateArray[0];
    for (var i = 0; i < dateArray[1] - 1; i++) {
        numberOfDays += monthDays[i];
    } 
    return numberOfDays;
}
function convertDaysToDate(days)
{
    var d = days / 365;
    days = days / 365;
    var monthDays = [31, 58, 89, 119, 150, 180, 211, 242, 272, 305, 335, 366];
    var month;
    for (var i = 0; i < monthDays - 2; i++) {
        if (days <= monthDays[i] && days < monthDays[i + 1]) {
            month = ++i;
            days = days - monthDays[i];
        }
    }
    var dateArray = new Array();
    date.push(days+"-");
    date.push(month+"-");
    date.push(year);
    
  
    return date;
}

function calculate(date1, date2, operator)
{
    var date1 = convertDateToDays(date1);
    var date2 = convertDateToDays(date2);
    if (operator == "difference")
        if (date1 > date2)
            return 0;
        else
            return convertDaysToDate(date2-date1);
    if (operator == "add")
        return convertDaysToDate(date2 + date1);
}
module.exports = {
    displayRadioValue
};

    