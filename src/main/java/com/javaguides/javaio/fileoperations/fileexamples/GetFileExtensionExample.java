package com.javaguides.javaio.fileoperations.fileexamples;

import java.io.File;

public class GetFileExtensionExample {
	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf('.') != -1 && fileName.lastIndexOf('.') != 0) {
			return fileName.substring(fileName.lastIndexOf('.') + 1);
		} else {
			return "File don't have extension";
		}
	}

	public static void main(String[] args) {
		File file = new File("sample.txt");
		System.out.println(getFileExtension(file));
		
		File file1 = new File("sample");
		System.out.println(getFileExtension(file1));
		
		File file2 = new File("sample.docx");
		System.out.println(getFileExtension(file2));
		
	}

}
