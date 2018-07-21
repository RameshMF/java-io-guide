package com.javaguides.javaio.ioexamples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("C:/workspace/java-io-guide/sample.txt");
				BufferedReader br = new BufferedReader(fr);) {
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
