package com.water.obj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CrunchifyObj implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	public CrunchifyObj() {
		System.out.println("Hello! CrunchifyObj() just got created..");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (CrunchifyObj) super.clone();
	}

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws Exception {

		// Create Object1
		CrunchifyObj object1 = new CrunchifyObj();

		// Create Object2
		CrunchifyObj object2 = (CrunchifyObj) Class.forName("com.water.obj.CrunchifyObj").newInstance();

		// Create Object3
		CrunchifyObj secondObject = new CrunchifyObj();
		CrunchifyObj object3 = (CrunchifyObj) secondObject.clone();

		// Create Object4
		Object object4 = CrunchifyObj.class.getClassLoader().loadClass("com.water.obj.CrunchifyObj")
				.newInstance();

		// Create Object5
		// create a new file with an ObjectOutputStream
		FileOutputStream out = new FileOutputStream("crunchify.txt");
		ObjectOutputStream oout = new ObjectOutputStream(out);

		// write something in the file
		oout.writeObject(object3);
		oout.flush();

		// create an ObjectInputStream for the file we created before
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("crunchify.txt"));
		CrunchifyObj object5 = (CrunchifyObj) ois.readObject();

	}
}
