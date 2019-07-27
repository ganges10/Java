/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateapplication;

/**
 *
 * @author ganga
 */
public class Date implements Comparable{
    
    int day,month,year;
    
    
    public Date(int dd,int mm,int yy){
        
        //validation and throwing appropriate exception message that occured.Write declaration of object in try block
        if(mm > 12 || mm <= 0){
            throw new RuntimeException("Month must be specified within 1 and 12");
        }
        else if( dd <= 0){
            throw new RuntimeException("Day must be a postive number");
        }
        else if((mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) && dd > 31){
            throw new RuntimeException("Day must be between 1 and 31");
        }
        else if((mm == 4 || mm == 6 || mm == 9 || mm == 11) && dd > 30){
            throw new RuntimeException("Day must be between 1 and 30");
        }
        else if(mm == 2 && (yy % 4 == 0) && dd > 29){
            throw new RuntimeException("Day must be between 1 and 29");
        }
        else if(mm == 2 && (yy % 4 != 0) && dd > 28){
            throw new RuntimeException("Day must be between 1 and 28");
        }
        
        //valid day , month and year assigned to the member function
        this.day=dd;
        this.month=mm;
        this.year=yy;
        
    }
    
    
    public int getDay(){
        
        //return the day of the object
        return this.day;
    }
    
    
    public int getMonth(){
        
        //returns the month of the object
        return this.month;
    }
    
    
    public int getYear(){
        
        //returns the year of the object
        return this.year;
    }
    
    
    public Date addDays(int daystoadd){
        
        //if negative number specified will automatically call the subtractDays function
        if(daystoadd < 0)
            return subtractDays(Math.abs(daystoadd));
        
        int resultday=day,resultmonth=month,resultyear=year;
        
        //calculate the number of years present within the daystoadd
        while(daystoadd >= 365){
            
            if(resultyear % 4 == 0){
                daystoadd -= 366;
            }
            else{
                daystoadd -= 365;
            }
            resultyear += 1;
            
        }
        
        //calculate the months that could be taken out of the days to add
        while(daystoadd >= 28){
            
            if((resultmonth == 1 || resultmonth == 3 || resultmonth == 5 || resultmonth == 7 || resultmonth == 8 || resultmonth == 10) && (daystoadd >= 31)){
                resultmonth += 1;
                daystoadd -= 31;
            }
            else if((resultmonth == 12) && (daystoadd >= 31)){
                daystoadd -= 31;
                resultmonth = 1;
                resultyear += 1;
            }
            else if((resultmonth == 4 || resultmonth == 6 || resultmonth == 9 || resultmonth == 11 ) && (daystoadd >= 30)){
                daystoadd -= 30;
                resultmonth += 1;
            }
            else if(resultmonth == 2 && resultyear % 4 == 0 && daystoadd >= 29){
                daystoadd -= 29;
                resultmonth += 1;
            }
            else{
                daystoadd -= 28;
                resultmonth += 1;
            }
            
        }
        
        //adding the remaining daystoadd to the resultday
        resultday+=daystoadd;
        
        //if the resultday is greater than the desired valid date the  day,month and year are correspondingly altered
        if(resultday > 31 && (resultmonth == 1 || resultmonth == 3 || resultmonth == 5 || resultmonth == 7 || resultmonth == 8 || resultmonth == 10)){
            resultday -= 31;
            resultmonth += 1;
        }
        else if(resultday > 31 && resultmonth == 12){
            resultday -= 31;
            resultmonth = 1;
            resultyear += 1;
        }
        else if(resultday > 30 && (resultmonth == 4 || resultmonth == 6 || resultmonth == 9 || resultmonth == 11 )){
            resultday -= 30;
            resultmonth += 1;
        }
        else if(resultday > 29 && resultmonth == 2 && resultyear % 4 == 0){
            resultday -= 29;
            resultmonth += 1;
        }
        else if(resultday >28 && resultmonth == 2 && resultyear % 4 != 0){
            resultday -= 28;
            resultmonth += 1;
        }
        
        Date result=new Date(resultday,resultmonth,resultyear);
        return result;
        
    }
    
    
    public Date subtractDays(int daystosubtract){
        
        //if negative number is specified, automatically calling addDays function
        if(daystosubtract < 0)
            return addDays(Math.abs(daystosubtract));
        
        int dd = this.day , mm = this.month , yy = this.year;
        
        //subtracting the yearspossiblr from the date
        while(daystosubtract >=365){
            
            if((yy - 1) % 4 == 0){
                daystosubtract -= 366;
            }
            else{
                daystosubtract -= 365;
            }
            yy -= 1;
            
        }
        
        //subtracting the possible months from the date
        while(daystosubtract >= 28){
            
            if(((mm - 1) == 1 ||(mm - 1) == 3 || (mm - 1) == 5 || (mm - 1) == 7 || (mm - 1) == 8 || (mm - 1) == 10) && (daystosubtract >= 31)){
                daystosubtract -= 31;
                mm -= 1;
            }
            else if((mm == 1) && (daystosubtract >= 31)){
                daystosubtract -= 31;
                mm = 12;
                yy -= 1;
            }
            else if(((mm - 1) == 4 || (mm - 1) == 6 || (mm - 1) == 9 || (mm - 1) == 11) && (daystosubtract >= 30)){
                daystosubtract -= 30;
                mm -= 1;
            }
            else if(((mm - 1) == 2 && yy % 4 == 0) && (daystosubtract >= 29))
            {
                daystosubtract -= 29;
                mm -= 1;
            }
            else if(((mm - 1) == 2 && yy % 4 != 0) && (daystosubtract >= 28)){
                daystosubtract -= 28;
                mm -=1;
            }
                
        }
        //if the days to subtract is less than the obect day then directly subtracted else day,month and year latered correspondingly
        if(daystosubtract < dd){
            dd -= daystosubtract;
        }
        else
        {
            daystosubtract -= dd;
            if(mm == 1){
                dd = 31 - daystosubtract;
                mm = 12;
                yy -= 1;
            }
            else if((mm - 1) == 1 ||(mm - 1) == 3 || (mm - 1) == 5 || (mm - 1) == 7 || (mm - 1) == 8 || (mm - 1) == 10){
                dd = 31 - daystosubtract;
                mm -= 1;
            }
            else if((mm - 1) == 4 || (mm - 1) == 6 || (mm - 1) == 9 || (mm - 1) == 11){
                dd = 30 - daystosubtract;
                mm -= 1;
            }
            else if((mm - 1) == 2 && yy % 4 == 0){
                dd = 29 - daystosubtract;
                mm -= 1;
            }
            else if((mm - 1) == 2 && yy % 4 != 0){
               dd = 28 - daystosubtract;
               mm -= 1; 
            }
        }

        Date result =new Date(dd , mm , yy);
        return result;
        
    } 
    
    
    public int dateDifference(Date date2){
        
        //ensuring if the date2 provided is less than the object date.Ro be put in the try block
        if(date2.year > this.year){
            throw new RuntimeException("Year specified in the date provided is greater");
        }
        else if(date2.year == this.year){
            if(date2.month > this.month){
                throw new RuntimeException("Month specified in the date provided is greater");
            }
            else if(date2.month == this.month){
                throw new RuntimeException("Day specified in the date provided is greater");
            }
        
        }
        
        int difference = 0;
        
        //adding the years in between the two dates
        for(int yearsbtw = date2.year + 1 ; yearsbtw < this.year ; yearsbtw++){
            
            if(yearsbtw % 4 == 0)
                difference += 366;
            else
                difference += 365;
        
        }
        
        // adding the months after the date2.month in the date2.year 
        for(int monthsafter = date2.month + 1 ; monthsafter <= 12 ; monthsafter++){
           
            if(monthsafter == 1 || monthsafter == 3 || monthsafter == 5 || monthsafter == 7 || monthsafter == 8 || monthsafter == 10 || monthsafter == 12)
                difference += 31;
            else if(monthsafter == 4 || monthsafter == 6 || monthsafter == 9 || monthsafter == 11)
                difference += 30;
            else if(monthsafter == 2 && date2.year%4==0)
                difference+=29;
            else
                difference+=28;                     
        
        }
        
        //adding the months before the month of the year as specified in the object
        for(int monthsbefore = 1 ; monthsbefore < this.month ; monthsbefore++){
            if(monthsbefore== 1 || monthsbefore == 3 || monthsbefore == 5 || monthsbefore == 7 || monthsbefore == 8 || monthsbefore == 10 || monthsbefore == 12)
                difference += 31;
            else if(monthsbefore == 4 || monthsbefore == 6 || monthsbefore == 9 || monthsbefore == 11)
                difference += 30;
            else if(monthsbefore == 2 && date2.year%4==0)
                difference+=29;
            else
                difference+=28;  
        }
        
        //adding the pending days of date2.month
        if(date2.month == 1 || date2.month == 3 || date2.month == 5 || date2.month == 7 || date2.month == 8 || date2.month == 10 ||date2.month == 12)
            difference+=(31 - date2.day);
        else if(date2.month == 4 || date2.month == 6 || date2.month == 9 || date2.month == 11 )
            difference+=(30 - date2.day);
        else if(date2.month == 2 && date2.year % 4 == 0)
            difference+=(29 - date2.day);
        else
            difference+=(28 - date2.day);
        
        //adding the days passed in this.month
        difference += this.day;
        
        return difference;
    }

    
    @Override
    public int compareTo(Object t) {
        Date d = (Date)t;
        if(this.year > d.year)
            return 1;
        else if(this.year == d.year){
            if(this.month > d.month)
                return 1;
            else if(this.month == d.month){
                if(this.day > d.day)
                    return 1;
                else if(this.day < d.day)
                        return -1;
                else
                    return 0;
            }
            else
                return -1;
        }
        return -1;
    }
    
    
    @Override
    public boolean equals(Object o){
        
        if(o instanceof Date){
            Date d=(Date)o;
            return ((this.day == d.day) && (this.month == d.month) && (this.year == d.year));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.day;
        hash = 47 * hash + this.month;
        hash = 47 * hash + this.year;
        return hash;
    }
    
    @Override
    public String toString(){
        return (String.valueOf(this.day) +" - " + String.valueOf(this.month) + " - " +String.valueOf(this.year));
    }
}
