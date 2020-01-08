package com.example.helloworld;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class Task_1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int[] numbers = {1, 5, 10, 24, 55, -20};
        String[] textArray = {"hello", "my", "name", "is", "Orest", "hello"};

        getMinMaxValue(numbers);
        reverseArray(numbers);
        getDuplicateValuesInArray(textArray);
        removeDuplicateValuesFromArray(textArray);
        getNameOfWeekDay();
        getNumberOfDaysInMonth();
    }

    // 1. Write a Java program to find the maximum and minimum value of an array
    public static void getMinMaxValue(int[] numbers) {

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
                if( (textArray[i].equals(textArray[j])) && (i != j) ) {
                    System.out.println("Duplicate Element is : "+ textArray[j]);
                }
            }
        }
    }

    // 4. Write a Java program to remove duplicate elements from an array
    public static String[] removeDuplicateValuesFromArray(String[] textArray) {

        for (int i = 0; i < textArray.length-1; i++) {
            for (int j = i + 1; j < textArray.length; j++) {
                if( (textArray[i].equals(textArray[j])) && (i != j) ) {
                    System.out.println("Removing duplicate element - " + textArray[j]);
                    textArray = ArrayUtils.remove(textArray, j);
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
        int dayNumber = in.nextInt();

        String dayName = "";
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
        String MonthName = "Unknown";

        System.out.print("Input a month number: ");
        int month = input.nextInt();

        System.out.print("Input a year: ");
        int year = input.nextInt();

        switch (month) {
            case 1:
                MonthName = "January";
                numberDays = 31;
                break;
            case 2:
                MonthName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    numberDays = 29;
                } else {
                    numberDays = 28;
                }
                break;
            case 3:
                MonthName = "March";
                numberDays = 31;
                break;
            case 4:
                MonthName = "April";
                numberDays = 30;
                break;
            case 5:
                MonthName = "May";
                numberDays = 31;
                break;
            case 6:
                MonthName = "June";
                numberDays = 30;
                break;
            case 7:
                MonthName = "July";
                numberDays = 31;
                break;
            case 8:
                MonthName = "August";
                numberDays = 31;
                break;
            case 9:
                MonthName = "September";
                numberDays = 30;
                break;
            case 10:
                MonthName = "October";
                numberDays = 31;
                break;
            case 11:
                MonthName = "November";
                numberDays = 30;
                break;
            case 12:
                MonthName = "December";
                numberDays = 31;
        }
        System.out.print(MonthName + " " + year + " has " + numberDays + " days\n");
        return numberDays;
    }
}
