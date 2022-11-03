package com.epam.learning;
import java.util.*;
import java.util.stream.Collectors;

class Test {
	
	
		public static void getName(Object name){
		 System.out.println("My name is Sumit");
		}

		public static void getName(String name){
		 System.out.println("My name is " + name );
		}
	
	public static void main(String args[]) {
		List<String> list = Arrays.asList("sumit", "SURAJ", "Kumar", "SANJAY", "sandeep");
		System.out.println(
		list.stream().filter( x-> x.toUpperCase().equals(x)).collect(Collectors.toList()));
		
		getName("obj");
		getName(new Object());
		//{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3}
		int array[] = new int[14];
		int[] tempArray = array;
		for (int i =0; i < 14;i++)
		tempArray[i] = i;
		for (int i =0; i < 14;i++)
		System.out.println("Array" + array[i]);
//		System.out.println(Test.waterArea(array));
		String s1 = null;
		String s2 = null;
		if(s1 == s2) {
			System.out.println("---q-===>");
		}
//		if(s1.equals(s2)){
//		System.out.println("---b-===>");
//	}
		String s11 = "java";
		StringBuffer s22 = new StringBuffer("java");
//		if(s11 == s22){
//			System.out.println("---c-===>");
//		}
		if(s11.equals(s22)){
			System.out.println("----d===>");
		}
		if(s11.toString().equals(s22)){
			System.out.println("---e-===>");
		}
		if(s11.equals(s22.toString())){
			System.out.println("---hghg-===>");
		}
		
	}

  public int[] nextGreaterElement(int[] array) {
    // Write your code here.
		int n = array.length;
		int output[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		int j =0;
		for(int i = n-1; i >=0; i-- ){
			while(j < i && array[j] < array[i])
				j++;
			if(array[j] <= array[i])
				output[i] = -1;
			else{
				output[i] = array[j];
				stack.push(array[j]);
			}
			stack.push(array[i]);
		}
    return output;
  }
  
  public static int waterArea(int[] heights) {
		int n = heights.length;
		if(n==0){
			return 0;
		}
		int maxHeightIndex = n-1;
		int fgr[] = new int[n];
		fgr[n-1] = -1;
		for(int i =n-2; i>=0; i--) {
			if(heights[i] < heights[maxHeightIndex])
				fgr[i] = maxHeightIndex;
			else {
				fgr[i] = -1;
				maxHeightIndex = i;
			}
		}
		maxHeightIndex = 0;
		int fgl[] = new int[n];
		fgl[0] = -1;
		for(int i = 1; i < n; i++) {
			if(heights[i] < fgl[maxHeightIndex])
				fgl[i] = maxHeightIndex;
			else {
				fgl[i] = -1;
				maxHeightIndex = i;
			}
		}
		for(int i = 0;i< n;i++)
		System.out.println(fgr[i]);
		
		for(int i = 0;i< n;i++)
		System.out.println(fgl[i]);
		
		int waterArea = 0;
		for(int i = 1; i < n-1; i++) {
			if(fgl[i] > -1 && fgr[i] > -1){
				waterArea += Math.min(heights[fgr[i]],heights[fgl[i]]) - heights[i];
			}
		}
  return waterArea;
}
}



