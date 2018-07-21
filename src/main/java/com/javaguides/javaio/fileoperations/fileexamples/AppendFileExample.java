package com.javaguides.javaio.fileoperations.fileexamples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppendFileExample {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AppendFileExample.class);
	
	public static void main(String[] args) {
		appendToExitingFile();
	}
	
	public static void appendToExitingFile(){
		try (Writer writer = new FileWriter("sample.txt",true);
				BufferedWriter bw = new BufferedWriter(writer)) {
			String content = "append something to existing file\n";
			bw.write(content);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
}
