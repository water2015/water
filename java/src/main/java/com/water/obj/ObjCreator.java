package com.water.obj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjCreator implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	public ObjCreator() {
		System.out.println("Hello! Object Creator() just got created..");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (ObjCreator) super.clone();
	}

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws Exception {

		// Create Object1
		ObjCreator object1 = new ObjCreator();

		// Create Object2
		ObjCreator object2 = (ObjCreator) Class.forName("com.water.obj.ObjCreator").newInstance();

		// Create Object3
		ObjCreator secondObject = new ObjCreator();
		ObjCreator object3 = (ObjCreator) secondObject.clone();

		// Create Object4
		Object object4 = ObjCreator.class.getClassLoader().loadClass("com.water.obj.ObjCreator").newInstance();

		// Create Object5
		// create a new file with an ObjectOutputStream
		FileOutputStream out = new FileOutputStream("obj.creator.txt");
		ObjectOutputStream oout = new ObjectOutputStream(out);

		// write something in the file
		oout.writeObject(object3);
		oout.flush();

		// create an ObjectInputStream for the file we created before
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.creator.txt"));
		ObjCreator object5 = (ObjCreator) ois.readObject();

	}
}
