package org.uiowa.cs2820.engine;

import java.io.*;

public class Checkpoint{
	/*  save(): use Field.convert to convert Java object to
	 *  byte array, write byte array to file with constant
	 *  filename
	 */
	
	public static void save(Object obj) {
		
		// change if needed
		String filepath = "checkpoint.txt";
		// file to write to
		File file = new File(filepath);
		
		try {		
			// first time, file doesn't exist
			if (file.createNewFile()) {
				System.out.println("file created");
			}
		}
		catch (Exception ex) {
			System.out.println("Error");
		}
		
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
	public static Object restore(String filepath) throws IOException{
		// file to read from
		File file = new File(filepath);
		// byte array to convert to original object
		byte[] ba = new byte[(int) file.length()];
		Object obj = new Object();

		// read from file, should throw exception if file doesn't exist
		FileInputStream fis = new FileInputStream(file);
		fis.read(ba);
	    fis.close();
		
		// convert byte array to original object with Field.revert
		obj = Converter.revert(ba); 
		return obj;
	}

}
