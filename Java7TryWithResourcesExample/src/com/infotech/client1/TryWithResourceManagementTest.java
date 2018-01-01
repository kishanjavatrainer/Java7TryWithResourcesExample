package com.infotech.client1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourceManagementTest {

	public static void main(String[] args) {

		//tryWithCatchResourceManagement();
		tryWithResourcesResourceManagement();
	}
	
	//before JDK 7
	private static void tryWithCatchResourceManagement() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			String line ;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br !=null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	//JDK 7 onwards..
	private static void tryWithResourcesResourceManagement() {
		try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
			String line ;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
