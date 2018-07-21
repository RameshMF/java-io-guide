package com.javaguides.javaio.ioexamples;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStreamExample {
	public static void main(String[] args) {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		String content = "This is the text content";

		try (OutputStream out = new FileOutputStream(file);
				BufferedOutputStream bout = new BufferedOutputStream(out);) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			bout.write(content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
