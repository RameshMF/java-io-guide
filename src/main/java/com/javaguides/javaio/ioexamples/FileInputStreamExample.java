package com.javaguides.javaio.ioexamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
	public static void main(String[] args) {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		try (FileInputStream fis = new FileInputStream(file)) {
			System.out.println("Total file size to read (in bytes) : "+ fis.available());
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
