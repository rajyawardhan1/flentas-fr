package com.flentas.fr;

import java.util.Scanner;

public class TempleRun {
    public static void main(String[] args) {

        /* START: Reading input */
        Scanner sc = new Scanner(System.in);

        int totalTestCases = sc.nextInt();
        int[] numberOfPeople = new int[totalTestCases];
        int[][] costOfCrossing = new int[totalTestCases][];
        int[] totalCosts = new int[totalTestCases];

        int currentNumberOfPeople, currentCrossingValue;
        int[] currentCrossingCostValues;

        for (int i = 0; i < totalTestCases; i++) {

            currentNumberOfPeople = sc.nextInt();
            numberOfPeople[i] = currentNumberOfPeople;
            currentCrossingCostValues = new int[currentNumberOfPeople];

            for (int j = 0; j < currentNumberOfPeople; j++) {
                currentCrossingValue = sc.nextInt();
                currentCrossingCostValues[j] = currentCrossingValue;
            }
            costOfCrossing[i] = TempleUtil.sortCrossingValues(currentCrossingCostValues, 0, currentNumberOfPeople - 1);
        }
        /* END: Reading input */

        /* START: Processing and printing output */
        for (int i = 0; i < totalTestCases; i++) {
            totalCosts[i] = startFerryOperation(costOfCrossing[i]);
            System.out.println(totalCosts[i]);
        }
        /* END: Processing and printing output */
    }

    public static int startFerryOperation(int[] currentCrossingCostValues) {
        int totalCost = 0;

        if (currentCrossingCostValues.length == 1) {
            totalCost += currentCrossingCostValues[0];
        } else if (currentCrossingCostValues.length == 2) {
            totalCost += currentCrossingCostValues[1];
        } else {
            int[] villageSideOfRiver = currentCrossingCostValues;
            int[] templeSideOfRiver = {};

            totalCost = villageSideOfRiver[0] + villageSideOfRiver[1];
            templeSideOfRiver = TempleUtil.addElementToArray(templeSideOfRiver, villageSideOfRiver[1]);
            villageSideOfRiver = TempleUtil.removeElementByIndex(villageSideOfRiver, 1);

            int totalCostMin = getTotalCostMinApproach(villageSideOfRiver, templeSideOfRiver, totalCost);
            int totalCostMax = getTotalCostMaxApproach(villageSideOfRiver, templeSideOfRiver, totalCost);

            totalCost = Math.min(totalCostMin, totalCostMax);

        }

        return totalCost;
    }

    public static int getTotalCostMaxApproach(int[] village, int[] temple, int cost) {
        int[] villageSideOfRiver = village;
        int[] templeSideOfRiver = temple;
        int totalCost = cost;

        while (villageSideOfRiver.length >= 2) {

            templeSideOfRiver = TempleUtil.addTwoElementsToArray(templeSideOfRiver, villageSideOfRiver[villageSideOfRiver.length - 1], villageSideOfRiver[villageSideOfRiver.length - 2]);
            totalCost += villageSideOfRiver[villageSideOfRiver.length - 1];
            villageSideOfRiver = TempleUtil.removeMaximumTwoElement(villageSideOfRiver);

            if (villageSideOfRiver.length > 0) {
                TempleUtil.sortCrossingValues(templeSideOfRiver, 0, templeSideOfRiver.length - 1);

                villageSideOfRiver = TempleUtil.addElementToArray(villageSideOfRiver, templeSideOfRiver[0]);
                totalCost += templeSideOfRiver[0];
                templeSideOfRiver = TempleUtil.removeElementByIndex(templeSideOfRiver, 0);
            }

            TempleUtil.sortCrossingValues(villageSideOfRiver, 0, villageSideOfRiver.length - 1);
            TempleUtil.sortCrossingValues(templeSideOfRiver, 0, templeSideOfRiver.length - 1);
        }
        return totalCost;
    }

    public static int getTotalCostMinApproach(int[] village, int[] temple, int cost) {
        int[] villageSideOfRiver = village;
        int[] templeSideOfRiver = temple;
        int totalCost = cost;

        while (villageSideOfRiver.length >= 2) {

            templeSideOfRiver = TempleUtil.addTwoElementsToArray(templeSideOfRiver, villageSideOfRiver[0], villageSideOfRiver[1]);
            totalCost += villageSideOfRiver[1];
            villageSideOfRiver = TempleUtil.removeMinimumTwoElement(villageSideOfRiver);

            if (villageSideOfRiver.length > 0) {
                TempleUtil.sortCrossingValues(templeSideOfRiver, 0, templeSideOfRiver.length - 1);

                villageSideOfRiver = TempleUtil.addElementToArray(villageSideOfRiver, templeSideOfRiver[0]);
                totalCost += templeSideOfRiver[0];
                templeSideOfRiver = TempleUtil.removeElementByIndex(templeSideOfRiver, 0);
            }

            TempleUtil.sortCrossingValues(villageSideOfRiver, 0, villageSideOfRiver.length - 1);
            TempleUtil.sortCrossingValues(templeSideOfRiver, 0, templeSideOfRiver.length - 1);
        }
        return totalCost;
    }
}
