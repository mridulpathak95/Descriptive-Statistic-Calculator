package com.soen6611.calculator;

import java.util.*;

import com.soen6611.utilities.Logger;

public class Calculator {

	public static void performStatistics(Scanner scan, double[] arr) {

		int functionNum = 1;

		while (true) {

			Logger.printAndLogMessage("Input array: " + Arrays.toString(arr));
			Logger.printAndLogMessage("Select one operation from below,");
			Logger.printAndLogMessage("(1) Minimum");
			Logger.printAndLogMessage("(2) Maximum");
			Logger.printAndLogMessage("(3) Mode");
			Logger.printAndLogMessage("(4) Median");
			Logger.printAndLogMessage("(5) Arithmetic Mean");
			Logger.printAndLogMessage("(6) Mean Absolute Deviation");
			Logger.printAndLogMessage("(7) Standard Deviation");
			Logger.printAndLogMessage("(8) All");
			Logger.printAndLogMessage("(9) To Exit");

			try {
				functionNum = Integer.parseInt(scan.nextLine());

				if (functionNum == 9) {
					Logger.printAndLogMessage("*** End of Session ***");
					break;
				}
				CalculatorFunctions.getFunction(functionNum, arr);

			} catch (Exception e) {
				Logger.printAndLogMessage("Exception: Invalid input");
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		int userChoice = 1;

		while (userChoice != 3) {

			double[] arr = null;

			Logger.printAndLogMessage("***** DESCRIPTIVE-STATISTICS CALCULATOR *****");

			Logger.printAndLogMessage("(1) To Enter values Manually");
			Logger.printAndLogMessage("(2) To Select values Randomly");
			Logger.printAndLogMessage("(3) To Terminate Calculator");

			try {
				userChoice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				Logger.printAndLogMessage("Exception: " + e.toString());
				continue;
			}

			switch (userChoice) {

			case 1:
				Logger.printAndLogMessage("Enter values seperated by space [Ex: 14 64 11 1 0 1]");

				String[] strArr = scan.nextLine().split(" ");
				arr = new double[strArr.length];

				for (int i = 0; i < strArr.length; i++) {
					arr[i] = Double.valueOf(strArr[i]);
				}
				performStatistics(scan, arr);
				break;

			case 2:
				Logger.printAndLogMessage("How many numbers?");
				int numOfValues = Integer.parseInt(scan.nextLine());

				arr = new double[numOfValues];

				for (int i = 0; i < numOfValues; i++) {
					double randVal = rand.nextInt(1000);
					arr[i] = randVal;
				}
				performStatistics(scan, arr);
				break;

			case 3:
				Logger.printAndLogMessage("*** End of Calculator ***");
				System.exit(0);
				break;

			default:
				Logger.printAndLogMessage("Invalid input. ");
				break;
			}
		}

		scan.close();
	}
}
