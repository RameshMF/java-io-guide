package com.javaguides.javaio.zipexamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This Java program demonstartes that how to decompress files from zip.
 * @author javaguides.net
 *
 */
public class DecompressZipExample {
	List<String> fileList;
	private static final String INPUT_ZIP_FILE = "C:\\Project_Work\\samples\\dest_sample.zip";
	private static final String OUTPUT_FOLDER = "C:\\Project_Work\\samples\\outputzip";

	public static void main(String[] args) {
		DecompressZipExample unZip = new DecompressZipExample();
		unZip.unZipIt(INPUT_ZIP_FILE, OUTPUT_FOLDER);
	}

	/**
	 * Unzip it
	 * 
	 * @param zipFile
	 *            input zip file
	 * @param output
	 *            zip file output folder
	 */
	public void unZipIt(String zipFile, String outputFolder) {

		byte[] buffer = new byte[1024];

		File folder = new File(OUTPUT_FOLDER);
		if (!folder.exists()) {
			folder.mkdir();
		}

		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
			// get the zipped file list entry
			ZipEntry ze = zis.getNextEntry();

			while (ze != null) {

				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);

				System.out.println("file unzip : " + newFile.getAbsoluteFile());

				// create all non exists folders
				// else you will hit FileNotFoundException for compressed folder
				new File(newFile.getParent()).mkdirs();

				try (FileOutputStream fos = new FileOutputStream(newFile)) {
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
				}
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

			System.out.println("Done");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
