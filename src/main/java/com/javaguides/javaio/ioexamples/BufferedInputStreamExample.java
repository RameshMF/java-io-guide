package com.javaguides.javaio.ioexamples;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamExample {
	public static void main(String[] args) {
		try( FileInputStream fin=new FileInputStream("D:\\testout.txt");    
			    BufferedInputStream bin=new BufferedInputStream(fin); ){
			int i;    
		    while((i=bin.read())!=-1){    
		     System.out.print((char)i);    
		    }    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
