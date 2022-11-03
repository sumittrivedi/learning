package com.epam.learning;

public class StackImpl {
    //Stack Implemntation LIFO
    static int n = 10;
    static int[] data = new int[n];
    static int lastIndex = -1;

    public static void main(String args[]) throws Exception {
        StackImpl.push(8);

    }

    private static void push(int x) throws Exception{
        if (lastIndex + 1 <= n - 1) {
            data[lastIndex + 1] = x;
            lastIndex++;
        }
        else throw new RuntimeException("Array is full");
    }

    private static int pop() throws Exception {
        if (lastIndex < 0) {
            throw new RuntimeException("Array is empty");
        }
        else {
            int lastDataToPop = data[lastIndex - 1];
            data[lastIndex - 1] = 0;
            lastIndex = lastIndex - 1;
            return lastDataToPop;
        }
    }

}
