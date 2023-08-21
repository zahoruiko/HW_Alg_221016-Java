import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Task #1
        System.out.println("Task #1:");
        int[] sourceArray = new int[]{25, 14, 56, 15, 47};
        System.out.println("Source array = " + Arrays.toString(sourceArray));
        System.out.println("Adding a value to an array (position of the first element = 0)");
        System.out.println("Option №1: Result (adding the number 5 to the beginning): " + Arrays.toString(insertValueInTheArray(sourceArray, 5, 0, true)));
        System.out.println("Option №2: Result (adding the number 5 to the beginning): " + Arrays.toString(insertValueInTheArrayV2(sourceArray, 5, 0, true)));
        System.out.println("Option №1: Result (adding the number 5 to position 2): " + Arrays.toString(insertValueInTheArray(sourceArray, 5, 2, true)));
        System.out.println("Option №2: Result (adding the number 5 to position 2): " + Arrays.toString(insertValueInTheArrayV2(sourceArray, 5, 2, true)));
        System.out.println("Option №1: Result (adding the number 5 to the end): " + Arrays.toString(insertValueInTheArray(sourceArray, 5, 4, true)));
        System.out.println("Option №2: Result (adding the number 5 to the end): " + Arrays.toString(insertValueInTheArrayV2(sourceArray, 5, 4, true)));
        System.out.println("");

        // Task #2
        System.out.println("Task #2:");
        sourceArray = new int[]{25, 14, 56, 15, 47};
        System.out.println("Source array = " + Arrays.toString(sourceArray));
        // Option #1
        HashMap<String, Integer> result = getMinAndMax(sourceArray);
        System.out.println("Option #1: Min = " + result.get("min") + " Max = " + result.get("max"));
        // Option #2
        result = getMinAndMaxV2(sourceArray);
        System.out.println("Option #2: Min = " + result.get("min") + " Max = " + result.get("max"));
    }



    // Task #1
    // Adding an element to an array
    public static int[] insertValueInTheArray(int[] sourceArray, int value, int position, boolean keepOriginalArraySize) {
        // Since we are adding a value to the array, and not redefining the existing one, 
        // therefore we are creating a new array that will contain all the values
        int[] resultArray;
        int arrayLengthCorrection;
        if (keepOriginalArraySize) {
            // If the resulting array should have the same length as the original one
            resultArray = new int[sourceArray.length];
            // If the resulting array is the same length as the original one, then this must be taken into account
            arrayLengthCorrection = 1;
        } else {
            // If the resulting array needs to be enlarged to save a new element
            resultArray = new int[sourceArray.length + 1];
            // If the resulting array increases, then the correction is zero
            arrayLengthCorrection = 0;
        }
        // If the value is added to the beginning of the array
        if(position == 0) {
            // Specifying the value for the element that is in the zero position
            resultArray[position] = value;
            // Starting from the next position (1) of the resulting array, we copy the values 
            // from the original array into it (taking into account the correction)
            for (int i = 0; i < sourceArray.length - arrayLengthCorrection; i++) {
                resultArray[i + 1] = sourceArray[i];
            }
        } else if (position > 0 && position < resultArray.length - 1) { // If the value is added to the middle of the array
            // Copy the values from 0 to the position where the new element should be inserted into the resulting array
            for (int i = 0; i < position; i++) {
                resultArray[i] = sourceArray[i];
            }
            // Specifying the value for the element that is in the specified position
            resultArray[position] = value;
            // We copy from the source array the elements that are located after the addition position 
            // and up to the end of the source array (taking into account the correction)
            for (int i = position; i < sourceArray.length - arrayLengthCorrection; i++) {
                resultArray[i + 1] = sourceArray[i];
            }
        } else if (position == resultArray.length - 1) { // If the value is added at the end of the array
            // We copy the elements of the mz of the original array into the resulting array (taking into account the correction)
            for (int i = 0; i < sourceArray.length - arrayLengthCorrection; i++) {
                resultArray[i] = sourceArray[i];
            }
            // Defining the value for the last element of the new array
            resultArray[position] = value;
        } else {
            System.out.println("The position of an element cannot be negative or exceed the last index of the resulting array!!");
        }
        return resultArray;
    }

    public static int[] insertValueInTheArrayV2(int[] sourceArray, int value, int position, boolean keepOriginalArraySize) {
        // Since we are adding a value to the array, and not redefining the existing one, 
        // therefore we are creating a new array that will contain all the values
        int[] resultArray;
        int arrayLengthCorrection;
        if (keepOriginalArraySize) {
            // If the resulting array should have the same length as the original one
            resultArray = new int[sourceArray.length];
            // If the resulting array is the same length as the original one, then it must be taken into account
            arrayLengthCorrection = 1;
        } else {
            // If the resulting array needs to be enlarged to save a new element
            resultArray = new int[sourceArray.length + 1];
            // If the resulting array increases, then the correction is zero
            arrayLengthCorrection = 0;
        }
        // If the value is added to the beginning of the array
        if(position == 0) {
            // Specifying the value for the element that is in the zero position
            resultArray[position] = value;
            // Starting from the next position (1) of the resulting array, we copy the values 
            // from the original array into it (taking into account the correction)
            System.arraycopy(sourceArray, 0, resultArray, 1, sourceArray.length - arrayLengthCorrection);
        } else if (position > 0 && position < resultArray.length - 1) { // If the value is added to the middle of the array
            // Copy the values from 0 to the position where the new element should be inserted into the resulting array
            System.arraycopy(sourceArray, 0, resultArray, 0, position);
            // Specifying the value for the element that is in the specified position
            resultArray[position] = value;
            // We copy from the source array the elements that are located after the addition position 
            // and up to the end of the source array (taking into account the correction)
            System.arraycopy(sourceArray, position, resultArray, position + 1, sourceArray.length - arrayLengthCorrection - position);
        } else if (position == resultArray.length - 1) { // If the value is added at the end of the array
            // Copy to the resulting array all the elements of the mz of the original array (taking into account the correction)
            System.arraycopy(sourceArray, 0, resultArray, 0, sourceArray.length - arrayLengthCorrection);
            // Defining the value for the last element of the new array
            resultArray[position] = value;
        } else {
            System.out.println("The position of an element cannot be negative or exceed the last index of the resulting array!!");
        }
        return resultArray;
    }

    // Task №2
    public static HashMap<String, Integer> getMinAndMax(int[] inputArray) {
        // Creating an associative "array" (HashMap) to return the found values
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        // We determine the minimum value and add it to the HashMap
        result.put("min", getMinValue(inputArray));
        // We determine the maximum value and add it to the HashMap
        result.put("max", getMaxValue(inputArray));
        // Returning HashMap with minimum and maximum values
        return result;
    }

    public static int getMaxValue(int[] inputArray) {
        // We determine the starting value for comparison (maximum)
        int max = inputArray[0];
        // Starting a loop to iterate through the array elements
        for (int element: inputArray) {
            // If the element being compared is greater than the wound of a certain maximum value,
            if (max < element) {
                // then we set this value as the maximum
                max = element;
            }
        }
        // Returning the result
        return max;
    }

    public static int getMinValue(int[] inputArray) {
        // We determine the starting value for comparison (minimum)
        int min = inputArray[0];
        // Starting a loop to iterate through the array elements
        for (int element: inputArray) {
            // If the element being compared is less than the previously defined minimum value,
            if (min > element) {
                // then we set this value as the minimum
                min = element;
            }
        }
        // Returning the result
        return min;
    }

    public static HashMap<String, Integer> getMinAndMaxV2(int[] inputArray) {
        // Creating an associative "array" (HashMap) to return the found values
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        // Sorting the array in ascending order
        Arrays.sort(inputArray);
        // The minimum value is now at the beginning of the sorted array
        result.put("min", inputArray[0]);
        // The maximum value is now at the end of the sorted array
        result.put("max", inputArray[inputArray.length - 1]);
        // Returning HashMap with minimum and maximum values
        return result;
    }
}
