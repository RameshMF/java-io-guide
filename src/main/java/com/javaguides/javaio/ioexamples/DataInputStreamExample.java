package com.javaguides.javaio.ioexamples;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamExample {
	public static void main(String[] args) {
		try(InputStream input = new FileInputStream("C:/Project_Work/workspace/java-io-guide/sample.txt");  
	    DataInputStream inst = new DataInputStream(input);){  
	    int count = input.available(); 
	    
	    byte[] ary = new byte[count];  
	    inst.read(ary);  
	    for (byte bt : ary) {  
	      char k = (char) bt;  
	      System.out.print(k+"-");  
	    }  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
