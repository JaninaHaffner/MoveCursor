import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Operations {

    public List<String> PerformOperation() throws IOException {

        /* Using a try catch block to catch exceptions.
         *  Using the file class with the file name
         *  Using the scanner class with a file reader to read the file
         *  Using a while loop to check if the file has a next line
         *  Using a variable to read the file line by line using the nextline function
         *  Using the split function to create an array off the information and access the operations that need
         *  to be performed on the specific line
         *  Using the split function again to get an array off the numerical values of each line
         *  Using a hash set and for each loop to get the numerical values of each line to operate on
         *  Using the parse function to put change string value into int value to operate on
         *  Using the add function to add each int value to the hash set
         *  Using a tree set to sort the numbers in ascending order. */

        Scanner scan = null;
        List<String> stringFile1 = new ArrayList<>();
        String letters = "";
        try {

           // List<String> stringFile1 = new ArrayList<>();
            scan = new Scanner(new FileReader("src/input.txt"));
            //String letters;
            while (scan.hasNext()) {
                letters = scan.next();
                stringFile1.add(letters);
            }
            String[] array1 = stringFile1.toArray(new String[0]);
            for (String eachString : array1) {
                System.out.println(eachString);
            }

        } catch (Exception a) {
            System.out.println("exception");
        } finally {
            assert scan != null;
            scan.close();
        }

        for (String let : stringFile1) {
            System.out.println(let);
        }
        return stringFile1;
    }
}

             //   String[] inputOperations = fileInfo.split(" ");
/*                String[] fileNumbers = inputOperations[1].split(",");
                Set<Integer> numberSet = new HashSet<>();

                for (String inputFileNumber : fileNumbers) {

                    int numbers = parseInt(inputFileNumber);
                    numberSet.add(numbers);
                }
                TreeSet<Integer> numberSetSorted = new TreeSet<>(numberSet);

                *//* Using a switch case to perform different calculations on each row.
                 *  Using to lowercase function to avoid program failure due to multi case wording
                 *  Using the input operation value as the switch to assess what operation needs to be performed
                 *  Using the first function on the sorted tree set to get the smallest or min value
                 *  Using the last function on the sorted tree set to get the biggest or max value
                 *  Create an object of the sorted list using the to array function
                 *  Using a for each loop and the integer parse method to add each number in the object to the
                 *  number array sum
                 *  Divide the number array sum with the length of the number array to get the average of the array of numbers
                 *  Using the file writer class with the write function to write each calculation to the new output file
                 *  Using the append method in order to avoid each line overriding the next.
                 *  using a for loop to iterate through the array to get the number of items in the collection
                 *  use the percentile formula of n = (P/100) x N - N = number of values in data set, P = percentile,
                 *  n = ordinary rank of a given value in sorted set.
                 *  use minus one as array's start at 0 not 1 to get the position and the value of the percentile
                 *  Default to close scanner
                 *  Close file writer *//*
                switch (inputOperations[0].toLowerCase()) {

                    case "min" -> {

                        String resultOne = "The Min of [" + inputOperations[1] + "] is " + numberSetSorted.first() + ".\n";
                        writeToOutputFile = new FileWriter(outputFile, true);
                        writeToOutputFile.write(resultOne);
                    }
                    case "max" -> {

                        String resultTwo = "The Max of [" + inputOperations[1] + "] is " + numberSetSorted.last() + ".\n";
                        writeToOutputFile = new FileWriter(outputFile, true);
                        writeToOutputFile.write(resultTwo);
                    }
                    case "avg" -> {

                        Object[] numberArray = numberSetSorted.toArray();
                        int numberArraySum = 0;

                        for (Object number : numberArray) {

                            int num = parseInt(number.toString());
                            numberArraySum += num;
                            String resultThree = "The Avg of [" + inputOperations[1] + "] is " +
                                    (double) numberArraySum / numberArray.length + ".\n";
                            writeToOutputFile = new FileWriter(outputFile, true);
                            writeToOutputFile.write(resultThree);
                        }
                    }
                    case "p10", "p20", "p30", "p40", "p50","p60","p70","p80","p90" -> {

                        String[] percentile = inputOperations[0].split("");

                        for (String item : percentile) {

                            if (item.equalsIgnoreCase("p")) {
                                String percentileValue = percentile[1] + percentile[2];
                                Object[] numberArrayPerc = numberSetSorted.toArray();
                                int arrayTotal = numberArrayPerc.length;
                                double valueOfPerc = Integer.parseInt(percentileValue);
                                double percValue = (valueOfPerc / 100) * arrayTotal;
                                String resultPercentile = "The " + percentileValue + "th percentile of "
                                        + Arrays.toString(numberArrayPerc) + " is " + (int) percValue + ".\n";
                                writeToOutputFile = new FileWriter(outputFile, true);
                                writeToOutputFile.write(resultPercentile);
                            }
                        }
                    }
                    case "sum" -> {

                        Object[] sumArray = numberSetSorted.toArray();
                        int sum = 0;

                        for (Object sumNum : sumArray) {

                            int sumOfNumber = parseInt(sumNum.toString());
                            sum += sumOfNumber;
                            String resultFour = "The Sum of [" + inputOperations[1] + "] is " + sum + ".\n";
                            writeToOutputFile = new FileWriter(outputFile, true);
                            writeToOutputFile.write(resultFour);
                        }
                        System.out.println("New information was successfully written to the output file.");
                    }
                    default -> {

                        System.out.println("Your information could not be processed.");
                        readFile.close();
                    }
                }
                // close file writer
                writeToOutputFile.close();
            }*/


