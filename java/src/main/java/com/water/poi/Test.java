package com.water.poi;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Test {

	/**
	 * 
	 colorPalette.put("24", "204,236,255"); colorPalette.put("25",
	 * "204,236,255"); colorPalette.put("29", "248,248,248");
	 * colorPalette.put("30", "234,234,234"); colorPalette.put("31",
	 * "221,221,221"); colorPalette.put("37", "192,192,192");
	 * colorPalette.put("38", "178,178,178"); colorPalette.put("45",
	 * "241,231,186");
	 * 
	 * @throws Exception
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 * 
	 */
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, Exception {
		// for (IndexedColors c : IndexedColors.values()) {
		// System.out.println("Color IDX: " + c.index + "   NAME: " + c.name());
		// }

//		Workbook wb = WorkbookFactory.create(new File("C:\\cst\\workspace\\rcast-batch-dev2\\CB_GL_PORT.xlsx"));
//		wb.cloneSheet(2);
//		wb.setSheetName(3, "Water");

		// ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// wb.write(baos);
		// Files.write(Paths.get("C:\\cst\\workspace\\rcast-batch-dev2\\water1.xlsx"),
		// baos.toByteArray());
		// baos.close();

//		FileOutputStream fileOut = new FileOutputStream("C:\\cst\\workspace\\rcast-batch-dev2\\water.xlsx");
//		wb.write(fileOut);
//		fileOut.close();

		new A().aa("Water");
		new A().aa("Amanda");
	}
}

class A {

	public synchronized void aa(String aa) {
		System.out.println("Begin : " + aa);
		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("End : " + aa);
	}
}
