package com.appium.base;

public class Main {

	
	public static void main(String[] args) {
		int i = 1;
		int j = 10;
		do {
			
			if(i++ < --j){
				System.out.print(i + " ");
				System.out.println(j);
			}
		} while (i<5);
			System.out.println(i);
			System.out.println(j);
		
	}
}
