/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateapplication;
import static java.lang.System.exit;
import java.util.*;
/**
 *
 * @author ganga
 */
public class DateApplication {

    public static void main(String[] args) {
        Date[] d = new Date[7];
        try{
            d[0] = new Date(10,2,2009);
            d[1] = new Date(11,3,2018);
            d[2] = new Date(12,3,2018);
            d[3] = new Date(12,12,2012);
            d[4] = new Date(2,2,2018);
            d[5] = new Date(10,10,2000);
            d[6] = new Date(2,2,2018);
        }
        catch(RuntimeException e){
            System.out.println("Exception found :"+e);
            exit(0);
        }
        List<Date> listofdates = new ArrayList<Date>();
        for(int i = 0 ; i < 6 ; i++){
            listofdates.add(d[i]);
        }
//        System.out.println(listofdates);
        
        if(listofdates.contains(d[6]))
            System.out.println("It is present in the list");
        else
            System.out.println("It is not present in the list");
        
        Collections.sort(listofdates);
        System.out.println(listofdates);
        
        int difference = 0;
        try{
            difference = d[0].dateDifference(d[5]);
        }
        catch(RuntimeException e){
            System.out.println("Exception occured:"+e);
            exit(0);
        }
        finally{
            System.out.println("Date Difference is "+String.valueOf(difference) + " days");
        }
        
        System.out.println("After adding 365 days:" + d[0].addDays(365));
        
        System.out.println("After subtracting 366 days: "+ d[3].subtractDays(365));
    }
    
}
