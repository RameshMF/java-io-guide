package com.javaguides.javaio;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteFileExamples {
	private static final Logger LOGGER = LoggerFactory.getLogger(WriteFileExamples.class);

	// FileOutputStream is meant for writing streams of raw bytes such as image
	// data.
	// For writing streams of characters, consider using FileWriter.
	public void writeFileWithFileOutputStream() {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		String content = "This is the text content";

		try (OutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			System.out.println("Done");

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	// Convenience class for writing character files
	// FileWriter is meant for writing streams of characters
	public void writeFileWithFileFileWriter() {
		File file = new File("C:/Project_Work/workspace/java-io-guide/sample.txt");
		String content = "This is the text content";

		try (FileWriter fop = new FileWriter(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			fop.write(content);

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	// data is writteb into bytes
	public void writeFileWithBufferedOutputStream() {
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
			LOGGER.error(e.getMessage());
		}
	}

	// Java ByteArrayOutputStream class is used to write common data into
	// multiple files.
	// data is written into a byte array
	public void writeFileWithByteArrayOutputStream() {
		try (OutputStream fop = new FileOutputStream("C:/Project_Work/workspace/java-io-guide/sample.txt");
				OutputStream fop1 = new FileOutputStream("C:/Project_Work/workspace/java-io-guide/sample1.txt");
				ByteArrayOutputStream bout = new ByteArrayOutputStream();) {
			bout.write(65);
			bout.writeTo(fop);
			bout.writeTo(fop1);
			bout.flush();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public void writeFileWithDataOutputStream() {

		final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
		final int[] units = { 12, 8, 13, 29, 50 };
		final String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

		try (DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("C:/Project_Work/workspace/java-io-guide/sample.txt")))) {
			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	// An ObjectOutputStream writes primitive data types and graphs of Java objects to an OutputStream
	public void writeFileWithObjectOutputStream() {

		final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
		final int[] units = { 12, 8, 13, 29, 50 };
		final String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("C:/Project_Work/workspace/java-io-guide/sample.txt")))) {
			for (int i = 0; i < prices.length; i++) {
				out.writeDouble(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(descs[i]);
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	public static void main(String[] args) {
		WriteFileExamples examples = new WriteFileExamples();
		// examples.writeFileWithFileOutputStream();
		// examples.writeFileWithFileFileWriter();
		// examples.writeFileWithDataOutputStream();
		examples.writeFileWithObjectOutputStream();
	}
}
