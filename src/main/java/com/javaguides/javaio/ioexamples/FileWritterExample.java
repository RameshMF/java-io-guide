package com.javaguides.javaio.ioexamples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritterExample {
	public static void main(String[] args) {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		String content = "This is the text content";

		try (FileWriter fop = new FileWriter(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			fop.write(content);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
