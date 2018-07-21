package com.javaguides.javaio.fileoperations.fileexamples;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenameFileExample {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteFileExample.class);

	public static void main(String[] args) {
		renameFile();
	}

	// Renames the file denoted by this abstract pathname.
	public static void renameFile() {
		File file = new File("C:/workspace/java-io-guide/sample.txt");
		boolean hasRename = file.renameTo(new File("C:/workspace/java-io-guide/sample2.txt"));
		if (hasRename) {
			LOGGER.info("File rename successful");
		} else {
			LOGGER.info("File reanme failed");
		}
	}
}
