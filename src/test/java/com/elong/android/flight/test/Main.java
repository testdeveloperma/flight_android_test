package com.elong.android.flight.test;

import java.net.URL;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		 URL classUrl =
				 Thread.currentThread().getContextClassLoader().getResource("");
				 String agentPath = classUrl.getPath();
				 String[] split = agentPath.split("target");
				 for (String string : split) {
					System.out.println(string);
				}
				 System.out.println(agentPath);
	}
}
