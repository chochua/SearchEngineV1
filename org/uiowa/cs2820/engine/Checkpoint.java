package org.uiowa.cs2820.engine;

import java.io.*;

public class Checkpoint {
	/*  save(): use Field.convert to convert Java object to
	 *  byte array, write byte array to file with constant
	 *  filename
	 */
	
	public static void save(Object obj) {
		// change if needed
		String filepath = "checkpoint.txt";
		// file to write to
		File file = new File(filepath);
		// byte array to write to file
		byte[] ba = new byte[(int) file.length()];
		// convert object to byte array using Field.convert
		ba = Converter.convert(obj);  
		
		try {
			// write to file
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(ba);
			fos.close();
		}
		catch (Exception ex) {
			System.out.println("Error");
		}
	}
	
	/* restore(): 
	 * read file with constant filename holding byte array,
	 * uses Field.revert to convert byte array back to
	 * original Java object
	 */
	public static void restore(String filepath) {
		// file to read from
		File file = new File(filepath);
		// byte array to convert to original object
		byte[] ba = new byte[(int) file.length()];
		Object obj = new Object();
		
		try {
			// read from file
			FileInputStream fis = new FileInputStream(file);
			fis.read(ba);
		    fis.close();
		}
		catch (Exception ex) {
			System.out.println("Error");
		}
		
		// convert byte array to original object with Field.revert
		obj = Converter.revert(ba); 
	}

}
