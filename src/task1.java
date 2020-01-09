package com.example.helloworld;
import java.util.*;

import com.sun.deploy.security.SelectableSecurityManager;
import org.apache.commons.lang3.ArrayUtils;

public class Task_1 {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int[] numbers = {1, 5, 10, 24, 55, -20};
        String[] textArray = {null, "hello", "my", null, "name", "is", "Orest", "hello"};

        getMinMaxValue(numbers);
        reverseArray(numbers);
        getDuplicateValuesInArray(textArray);
        removeDuplicateValuesFromArray(textArray);
        getNameOfWeekDay();
        getNumberOfDaysInMonth();
    }

    // 1. Write a Java program to find the maximum and minimum value of an array
    public static void getMinMaxValue(int[] numbers) {

        if (numbers == null || numbers.length < 1) {
            System.out.println("method getMinMaxValue parameter 'numbers' is: null or 0 length");
            return;
        }

        int maxValue = numbers[0], minValue = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        System.out.println("Minimum value is : " + minValue + " and Maximum value is : " + maxValue);
    }

    // 2. Write a Java program to reverse an array of integer values
    public static void reverseArray(int[] numbers) {

              // first wanted like this but then found that there is such Apache Commons Lang
              //  int[] b = new int[numbers.length];
              //  int j = numbers.length;
              //  for (int i = 0; i < numbers.length; i++) {
              //      b[j - 1] = numbers[i];
              //      j = j - 1;
              //  }

              //  System.out.println("Reversed array - " + Arrays.toString(b));

        ArrayUtils.reverse(numbers);
        System.out.println("Reversed array - " + Arrays.toString(numbers));
    }

    // 3. Write a Java program to find the duplicate values of an array of string values
    public static void getDuplicateValuesInArray(String[] textArray) {

        for (int i = 0; i < textArray.length-1; i++) {
            for (int j = i + 1; j < textArray.length; j++) {
                try {
                    if( (textArray[i].equals(textArray[j])) && (i != j) ) {
                        System.out.println("Duplicate Element is : " + textArray[j]);
                    }
                } catch (Exception e) {
                    // there can be some log or something else like for ex. removing all null objects
                    // added nothing because it's doesn't matter for me if one of the elements is null
                }
            }
        }
    }

    // 4. Write a Java program to remove duplicate elements from an array
    public static String[] removeDuplicateValuesFromArray(String[] textArray) {

        for (int i = 0; i < textArray.length-1; i++) {
            for (int j = i + 1; j < textArray.length; j++) {
                try {
                    if( (textArray[i].equals(textArray[j])) && (i != j) ) {
                        System.out.println("Removing duplicate element - " + textArray[j]);
                        textArray = ArrayUtils.remove(textArray, j);
                    }
                } catch (Exception e) {
                    // there can be some log or something else like for ex. removing all null objects
                    // added nothing because it's doesn't matter for me if one of the elements is null
                }
            }
        }
        return textArray;
    }

    //  5. Write a Java program that keeps a number from the user and generates an integer between 1 and 7
    //  and displays the name of the weekday
    public static String getNameOfWeekDay() {

        Scanner in = new Scanner(System.in);
        System.out.print("Input number of a Day: ");
        if (!in.hasNextInt()) {
            System.out.println("Please enter a number, you entered - '" + in.next() + "'");
            return "Invalid day range, please insert day between 1 and 7";
        }
        int dayNumber = in.nextInt();

        String dayName;
        switch (dayNumber) {
            case 1: dayName = "Monday"; break;
            case 2: dayName = "Tuesday"; break;
            case 3: dayName = "Wednesday"; break;
            case 4: dayName = "Thursday"; break;
            case 5: dayName = "Friday"; break;
            case 6: dayName = "Saturday"; break;
            case 7: dayName = "Sunday"; break;
            default: dayName = "Invalid day range, please insert day between 1 and 7";
        }
        System.out.println("Name of the weekday is: " + dayName);
        return dayName;
    }

    // 6. Write a Java program to find the number of days in a month
    public static int getNumberOfDaysInMonth() {

        Scanner input = new Scanner(System.in);

        int numberDays = 0;
        String monthName;

        System.out.println("Input a month number: ");
        if (!input.hasNextInt()) {
            System.out.println("Please enter a number, you entered - '" + input.next() + "'");
            return numberDays;
        }
        int month = input.nextInt();

        System.out.println("Input a year: ");
        if (!input.hasNextInt()) {
            System.out.println("Please enter a number, you entered - '" + input.next() + "'");
            return numberDays;
        }
        int year = input.nextInt();

        switch (month) {
            case 1:
                monthName = "January";
                numberDays = 31;
                break;
            case 2:
                monthName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    numberDays = 29;
                } else {
                    numberDays = 28;
                }
                break;
            case 3:
                monthName = "March";
                numberDays = 31;
                break;
            case 4:
                monthName = "April";
                numberDays = 30;
                break;
            case 5:
                monthName = "May";
                numberDays = 31;
                break;
            case 6:
                monthName = "June";
                numberDays = 30;
                break;
            case 7:
                monthName = "July";
                numberDays = 31;
                break;
            case 8:
                monthName = "August";
                numberDays = 31;
                break;
            case 9:
                monthName = "September";
                numberDays = 30;
                break;
            case 10:
                monthName = "October";
                numberDays = 31;
                break;
            case 11:
                monthName = "November";
                numberDays = 30;
                break;
            case 12:
                monthName = "December";
                numberDays = 31;
                break;
            default: monthName = "Unknown";

        }
        if (monthName != "Unknown") {
            System.out.print(monthName + " " + year + " has " + numberDays + " days\n");
        } else {
            System.out.print("You entered wrong month number - " + month);
        }
        return numberDays;
    }
}
