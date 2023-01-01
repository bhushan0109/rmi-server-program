package com.test;

import java.util.Scanner;

import com.service.TestImplement;
import com.service.TestInterface;

public class App {
	int a = 30;
	int b = 40;

	// Parameterized constructor
//    App(int a, int b)
//    {
//        this.a = a;
//        this.b = b;
//    }
// 
	void display()

	{
		// Displaying value of variables a and b
		System.out.println("a = " + a + "  b = " + b);
	}

	void display1()

	{
		int a = 10;
		int b = 20;
		// Displaying value of variables a and b
		System.out.println("a = " + this.a + "  b = " + this.b);
		// System.out.println("a = " +a + " b = " + b);
	}

	public static void main(String[] args) {
		// App object = new App(40, 50);
//        App object = new App();
//      //  object.display();
//        object.display1();
//        
//        Scanner sc = new Scanner(System.in);
//        System.out.println(" please inter the array");

		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements you want to store: ");
		// int[] a = new int[] { 20, 30, 50, 4, 71, 100};
		int size = sc.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements of the array: ");
		for (int i = 0; i < size; i++) {
			// reading array elements from the user
			array[i] = sc.nextInt();
		}
		System.out.println("Array elements are: ");
		// accessing array elements using the for loop
		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}

		int max = array[0];
		System.out.println(array.length);

		System.out.println(array.length - 1);
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		System.out.println("The Given Array Element is:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		System.out.println("From The Array Element Largest Number is:" + max);
	}
	
	 public static void reverse(int[] array)
	    {
	 
	        // Length of the array
	        int n = array.length;

			// Swapping the first half elements with last half
	        // elements
	        for (int i = 0; i < n / 2; i++) {
	 
	            // Storing the first half elements temporarily
	            int temp = array[i];
	 
	            // Assigning the first half to the last half
	            array[i] = array[n - i - 1];
	 
	            // Assigning the last half to the first half
	            array[n - i - 1] = temp;
	        }
	    }
	
	
	
}