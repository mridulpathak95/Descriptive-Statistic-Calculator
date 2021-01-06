package com.soen6611.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.soen6611.utilities.Logger;

public class CalculatorFunctions {

	// (1) Minimum (2) Maximum (3) Mode (4) Median
	// (5) Arithmetic Mean (6) Mean Absolute Deviation (7) Standard Deviation
	public static void getFunction(int functionNum, double[] arr) {
		switch (functionNum) {
		case 1:
			Logger.printAndLogMessage("Minimum = " + getMinimum(arr));
			break;
		case 2:
			Logger.printAndLogMessage("Maximum = " + getMaximum(arr));
			break;
		case 3:
			Logger.printAndLogMessage("Mode = " + getMode(arr));
			break;
		case 4:
			Logger.printAndLogMessage("Median = " + getMedian(arr));
			break;
		case 5:
			Logger.printAndLogMessage("Arithmetic Mean = " + getArithmeticMean(arr));
			break;
		case 6:
			Logger.printAndLogMessage("Mean Absolute Deviation = " + getMeanAbsoluteDeviation(arr));
			break;
		case 7:
			Logger.printAndLogMessage("Standard Deviation = " + getStandardDeviation(arr));
			break;
		case 8:
			Logger.printAndLogMessage("-----------------------------------------");
			Logger.printAndLogMessage("Minimum = " + getMinimum(arr));
			Logger.printAndLogMessage("Maximum = " + getMaximum(arr));
			Logger.printAndLogMessage("Mode = " + getMode(arr));
			Logger.printAndLogMessage("Median = " + getMedian(arr));
			Logger.printAndLogMessage("Arithmetic Mean = " + getArithmeticMean(arr));
			Logger.printAndLogMessage("Mean Absolute Deviation = " + getMeanAbsoluteDeviation(arr));
			Logger.printAndLogMessage("Standard Deviation = " + getStandardDeviation(arr));
			Logger.printAndLogMessage("-----------------------------------------");
			break;
		default:
			Logger.printAndLogMessage("Invalid input. ");
			break;
		}
	}

	/**
	 * Find the minimum value from an array
	 * 
	 * @param arr
	 *            list of double values
	 * @return min value
	 */
	static double getMinimum(double arr[]) {
		double ans = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (ans > arr[i]) {
				ans = arr[i];
			}
		}

		return ans;
	}

	/**
	 * Find the maximum value from an array
	 * 
	 * @param arr
	 *            list of double values
	 * @return max value
	 */
	static double getMaximum(double arr[]) {
		double ans = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (ans < arr[i]) {
				ans = arr[i];
			}
		}

		return ans;
	}

	/**
	 * Find the median value from an array
	 * 
	 * @param arr
	 *            list of double values
	 * @return median value
	 */
	static double getMedian(double arr[]) {

		double median = 0;
		double[] cloneArr = new double[arr.length];

		for (int idx = 0; idx < arr.length; idx++)
			cloneArr[idx] = arr[idx];

		merge_sort(cloneArr, 0, cloneArr.length - 1);

		if (arr.length % 2 == 0) {
			median = (cloneArr[cloneArr.length / 2] + cloneArr[cloneArr.length / 2 - 1]) / 2;
		}
		// The median is the middle number if n is odd
		else {
			median = cloneArr[cloneArr.length / 2];
		}

		return median;
	}

	/**
	 * Find the arithmetic mean value from an array
	 * 
	 * @param arr
	 *            list of double values
	 * @return arithmetic mean value
	 */
	static double getArithmeticMean(double arr[]) {
		double mean = 0, sum = 0;
		int arrLen = arr.length;

		for (int idx = 0; idx < arrLen; idx++) {
			sum += arr[idx];
		}

		mean = sum / arrLen;

		return mean;
	}

	/**
	 * Find the mean absolute deviation of an array
	 * 
	 * @param arr
	 *            list of double values
	 * @return mean absolute deviation value
	 */
	static double getMeanAbsoluteDeviation(double arr[]) {

		// Get the mean
		double mean = getArithmeticMean(arr);
		double[] distArr = new double[arr.length];
		double sumAbsDist = 0;

		// compute the absolute difference between each data value and the mean
		for (int idx = 0; idx < distArr.length; idx++) {
			distArr[idx] = getAbsValue(arr[idx] - mean);
		}

		// add distances
		for (int idx = 0; idx < distArr.length; idx++) {
			sumAbsDist += distArr[idx];
		}

		// divide sum by total points
		return sumAbsDist / distArr.length;
	}

	/**
	 * Find the standard deviation of an array
	 * 
	 * @param arr
	 *            list of double values
	 * @return standard deviation value
	 */
	static double getStandardDeviation(double arr[]) {

		// Get the mean
		double mean = getArithmeticMean(arr);
		double std = 0;

		// compute the square difference between each data value and the mean
		for (int idx = 0; idx < arr.length; idx++) {
			std += squareInputNumber(arr[idx] - mean);
		}

		// divide sum by total points and then square root the result value
		return Math.sqrt(std / arr.length);
	}

	/**
	 * Find the square of given number
	 * 
	 * @param x
	 *            input double values
	 * @return square value
	 */
	static double squareInputNumber(double x) {
		return x * x;
	}

	/**
	 * Find the absolute of given number
	 * 
	 * @param x
	 *            input double values
	 * @return Absolute value
	 */
	static double getAbsValue(double x) {

		if (x < 0) {
			return x * (-1);
		} else {
			return x;
		}
	}

	/**
	 * Merge left half and right half of an array
	 * 
	 * @param arr
	 *            array of double values
	 * @param left_idx
	 *            index of left half
	 * @param mid_idx
	 *            index of middle value
	 * @param right_idx
	 *            index of right half
	 * 
	 * @return merged array
	 */
	static void merge_arrays(double arr[], int left_idx, int mid_idx, int right_idx) {
		// Find sizes of two sub-arrays to be merged
		int left_half_size = mid_idx - left_idx + 1;
		int right_half_size = right_idx - mid_idx;
		double L[] = new double[left_half_size];
		double R[] = new double[right_half_size];

		// Copy data
		for (int i = 0; i < left_half_size; ++i)
			L[i] = arr[left_idx + i];

		for (int j = 0; j < right_half_size; ++j)
			R[j] = arr[mid_idx + 1 + j];

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array
		int k = left_idx;
		while (i < left_half_size && j < right_half_size) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < left_half_size) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < right_half_size) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	/**
	 * Sort given array using merge sort algorithm
	 * 
	 * @param arr
	 *            array of double values
	 * @param left_idx
	 *            index of left half
	 * @param right_idx
	 *            index of right half
	 * 
	 * @return sorted array
	 */
	static void merge_sort(double arr[], int left_idx, int right_idx) {
		if (left_idx < right_idx) {

			// Get the middle point
			int mid_idx = (left_idx + right_idx) / 2;

			// Sort first and second halves
			merge_sort(arr, left_idx, mid_idx);
			merge_sort(arr, mid_idx + 1, right_idx);

			// Merge the sorted halves
			merge_arrays(arr, left_idx, mid_idx, right_idx);
		}
	}

	/**
	 * Find the mode value from an array 1. Calculate the frequeny of all numbers in
	 * hashmap 2. Create a list and sort it 3. Check the count ( If the count is
	 * same or not, if so then no mode) ->There is possibility that there can be
	 * more than one mode, if highest number of frequency is same for multiple
	 * numbers
	 *
	 * @param arr
	 *            list of double values
	 * @return String of all the numbers which represent mode value
	 */
	static String getMode(double arr[]) {

		HashMap<Double, Integer> inputCountHashMap = new HashMap<Double, Integer>();
		for (Double val : arr) {
			if (inputCountHashMap.containsKey(val)) {
				inputCountHashMap.put(val, inputCountHashMap.get(val) + 1);
			} else
				inputCountHashMap.put(val, 1);
		}

		Comparator<Map.Entry<Double, Integer>> customComparator = new Comparator<Map.Entry<Double, Integer>>() {
			@Override
			public int compare(Map.Entry<Double, Integer> e1, Map.Entry<Double, Integer> e2) {
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue();
				return v2.compareTo(v1);
			}
		};

		List<Map.Entry<Double, Integer>> inputCountNumberList = new ArrayList<Map.Entry<Double, Integer>>(
				inputCountHashMap.entrySet());
		Collections.sort(inputCountNumberList, customComparator);
		LinkedHashMap<Double, Integer> sortedByCount = new LinkedHashMap<Double, Integer>(inputCountNumberList.size());
		for (Map.Entry<Double, Integer> entry : inputCountNumberList) {
			sortedByCount.put(entry.getKey(), entry.getValue());
		}
		int highestFrequency = sortedByCount.get(inputCountNumberList.get(0).getKey());
		int lowestFrequency = sortedByCount.get(inputCountNumberList.get(inputCountNumberList.size() - 1).getKey());
		String output = "";
		if (highestFrequency == lowestFrequency) {
			output = "All numbers have same frequency ";
			return output;
		} else {
			Set<Map.Entry<Double, Integer>> INPUTSetSortedByValue = sortedByCount.entrySet();
			for (Map.Entry<Double, Integer> mapping : INPUTSetSortedByValue) {
				if (mapping.getValue() == highestFrequency)
					output = output.concat(mapping.getKey() + ",");
			}
			System.out.println("Mode Value: has frequency of " + highestFrequency + " and the numbers are "
					+ output.substring(0, output.length() - 1));
			return output.substring(0, output.length() - 1);
		}
	}
}
