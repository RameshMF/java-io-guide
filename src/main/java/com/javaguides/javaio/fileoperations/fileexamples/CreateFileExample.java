package com.javaguides.javaio.fileoperations.fileexamples;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFileExample {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreateFileExample.class);
	
	public static void main(String[] args) {
		createFile();
	}
	
	public static void createFile() {
		File file = new File("C:/workspace/java-io-guide/sample.txt");
		try {
			if (file.createNewFile()) {
				LOGGER.info("File is created !!");
			} else {
				LOGGER.info("File is already exist");
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
}
