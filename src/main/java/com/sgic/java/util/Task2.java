package com.sgic.java.util;
import ch.qos.logback.core.pattern.parser.Parser;
import com.sun.jdi.LongValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.String;
import java.util.Scanner;
import java.util.Date;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Email");
        String email = in.nextLine();
        System.out.println("Enter the test String");
        String testString = in.nextLine();
        System.out.println("Enter the Date");
        String dateString = in.nextLine();


        String result1 = ValidateEmail(email);
        String result2 = changeNullToString(testString);
        Date result3 = ConvertStringToDate(dateString);
        int result4=add(5,9);
        double result5=add(4.89,7.98);
        float result6=add(3.8f,2.8f);


        System.out.println(result1);
        System.out.println("After Change NullToString: " + result2);
        if (result3 != null)
        {
            System.out.println("Converted Date: " + result3);
        }
        else
        {
            System.out.println("Failed to convert date.");
        }
        System.out.println("Add Two Integer Numbers "+result4);
        System.out.println("Add Two Double Numbers "+result5);
        System.out.println("Add Two Float Numbers "+result6);
    }


    public static String ValidateEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return "Email is Invalid";
        } else {
            return "Email is Valid";
        }
    }

    public static String changeNullToString(String input)
    {
        if (input == null)
        {
            return "";
        }
        else
        {
            return input;
        }
    }

    public static Date ConvertStringToDate(String dateString)
    {
        DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateformat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T extends Number> T add(T no1, T no2)
    {
        if (no1 instanceof Double || no2 instanceof Double)
        {
            return (T) Double.valueOf(no1.doubleValue() + no2.doubleValue());
        }
        else if (no1 instanceof Float || no2 instanceof Float)
        {
            return (T) Float.valueOf(no1.floatValue() + no2.longValue());
        }
        else if (no1 instanceof Long || no2 instanceof Long)
        {
            return (T) Long.valueOf(no1.longValue() + no2.longValue());
        }
        else
            {
                return (T) Integer.valueOf(no1.intValue()+no2.intValue());
            }
        }
    }

