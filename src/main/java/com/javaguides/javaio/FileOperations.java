package com.javaguides.javaio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileOperations {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileOperations.class);

	public void createFile() {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
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

	public void deleteFile() {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		if (file.delete()) {
			LOGGER.info(file.getName() + "created !!");
		} else {
			LOGGER.info("Delete operation failed");
		}
	}

	// Renames the file denoted by this abstract pathname.
	public void renameFile() {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		boolean hasRename = file.renameTo(new File("C:/Project_Work/workspace/java-io-guide/sample2.txt"));
		if (hasRename) {
			LOGGER.info("File rename successful");
		} else {
			LOGGER.info("File reanme failed");
		}
	}

	public void copyFile() {
		try (InputStream inStream = new FileInputStream("sample2.txt");
				OutputStream outStream = new FileOutputStream("sample1.txt")) {
			byte[] buffer = new byte[1024];
			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
		} catch (IOException e1) {
			LOGGER.error(e1.getMessage());
		}
	}

	public void moveFile() {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		boolean hasRename = file.renameTo(new File("C:/Project_Work/workspace/java-io-guide/src/sample.txt"));
		if (hasRename) {
			LOGGER.info("File is moved successful!");
		} else {
			LOGGER.info("File is failed to move!");
		}
	}

	// Write file using BufferedWriter
	public void writeFile() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Project_Work/workspace/java-io-guide/sample.txt"))) {
			String content = "This is the content to write into file\n";
			bw.write(content);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	public void appendToExitingFile(){
		try (Writer writer = new FileWriter("C:/Project_Work/workspace/java-io-guide/sample.txt",true);
				BufferedWriter bw = new BufferedWriter(writer)) {
			String content = "append something to existing file\n";
			bw.write(content);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	public void getFileSize(){
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		if(file.exists()){
			double bytes = file.length();
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);
			double gigabytes = (megabytes / 1024);
			double terabytes = (gigabytes / 1024);
			double petabytes = (terabytes / 1024);
			double exabytes = (petabytes / 1024);
			double zettabytes = (exabytes / 1024);
			double yottabytes = (zettabytes / 1024);
			
			System.out.println("bytes : " + bytes);
			System.out.println("kilobytes : " + kilobytes);
			System.out.println("megabytes : " + megabytes);
			System.out.println("gigabytes : " + gigabytes);
			System.out.println("terabytes : " + terabytes);
			System.out.println("petabytes : " + petabytes);
			System.out.println("exabytes : " + exabytes);
			System.out.println("zettabytes : " + zettabytes);
			System.out.println("yottabytes : " + yottabytes);
		}else{
			 System.out.println("File does not exists!");
		}
	}
	
	public void getFilePath(){
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		String absolutePath = file.getAbsolutePath();
		String filePath = absolutePath.
		    substring(0,absolutePath.lastIndexOf(File.separator));
		System.out.println(filePath);
	}
	
	public static void main(String[] args) {
		FileOperations fileOperations = new FileOperations();
		fileOperations.createFile();
		fileOperations.renameFile();
		fileOperations.copyFile();
		fileOperations.moveFile();
		fileOperations.writeFile();
		fileOperations.appendToExitingFile();
		fileOperations.getFileSize();
		fileOperations.getFilePath();
	}

}
