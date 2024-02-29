package ex_240229;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Ex_10_Array_test5 {

	public static void main(String[] args) {
			int [] array = {1,2,3,4,5};
			System.out.println("for each 예제1");
			for(int i : array) {
				System.out.print(i +", ");
			}
			System.out.println();
			System.out.println("for each 예제2");
			String [] array2 = {"hi1","hi2","hi3","hi4"};
			for(String text : array2) {
				System.out.print(text +", ");
			}
		}
	}