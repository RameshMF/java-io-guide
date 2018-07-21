package com.javaguides.javaio.fileoperations.fileexamples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteFileExample {
	private static final Logger LOGGER = LoggerFactory.getLogger(WriteFileExample.class);

	public static void main(String[] args) {
		writeFile();
	}

	// Write file using BufferedWriter
	public static void writeFile() {
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("C:/workspace/java-io-guide/sample.txt"))) {
			String content = "This is the content to write into file\n";
			bw.write(content);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
}
