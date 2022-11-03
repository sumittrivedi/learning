package com.epam.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CapriGlobal {
	
	// [7,1,5,3,6,4] -> 1,5,  3,6 => 4 + 3 = 7

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = {7,1,5,6,9,4};
		List<Integer> list = new ArrayList<>(Arrays.asList(4,2,5,3,1));
		System.out.print(CapriGlobal.getPlanetToDestroy(list));
//		System.out.println(CapriGlobal.getMaxProfit(array));

	}
	
	private static int getMaxProfit(int[] array) {
		int maxProfit = 0;
		int buyPrice = array[0];
		for (int i = 1; i < array.length; i++) {
			if ( buyPrice < array[i]) {
				maxProfit += array[i] - buyPrice;
			}
			buyPrice = array[i];
		}
		return maxProfit;
	}
	
	public static int getPlanetToDestroy(List<Integer> planets) {
	    // Write your code here
	    int oddSum = 0;
	    int evenSum = 0;
	    int result = -2;
	        for (int i =0; i< planets.size(); i++) {
	            if ( i % 2 == 0) {
	                evenSum += planets.get(i);
	            }
	            else {
	                oddSum += planets.get(i);
	            }
	        }
	    int index = evenSum > oddSum ? 0 : 1;
	    int tempSum = 0;
	    int temp2sum = 0;
	    if(index == 0) {
	        tempSum = evenSum;
	        temp2sum = oddSum;
	    }
	    else{
	        tempSum = oddSum;
	        temp2sum = evenSum;
	    }
	    System.out.println(tempSum + " " + temp2sum);
	    for (int i = index; i < planets.size(); i += 2) {
	        if((tempSum - planets.get(i)) == temp2sum) {
	            result = index;break;
	        }
	    }
	    return result + 1;
	    }


	}

