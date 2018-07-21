package com.javaguides.javaio.ioexamples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
	public static void main(String[] args) {
		try (FileWriter writer = new FileWriter("D:\\sample.txt");
				BufferedWriter buffer = new BufferedWriter(writer);) {
			buffer.write("Welcome to JavaGuides.");
			System.out.println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
