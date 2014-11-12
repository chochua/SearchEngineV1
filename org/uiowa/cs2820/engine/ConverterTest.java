package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ConverterTest {

	@Test
	public void test() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        Object tobyte = "what";
        // writeObject: convert object to byte
		o.writeObject(tobyte);
		ByteArrayInputStream M = new ByteArrayInputStream(b.toByteArray());
		ObjectInputStream N = new ObjectInputStream(M);
		Object tostring = null;
		// readObject: revert byte to object
		tostring = N.readObject();
        assertEquals(tostring, "what");
		
	}

}
