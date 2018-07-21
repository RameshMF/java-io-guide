package com.javaguides.javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileExamples {
	// FileOutputStream is meant for writing streams of raw bytes such as image
	// data.
	// For writing streams of characters, consider using FileWriter.
	public void readFileWithFileInputStream() {
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
