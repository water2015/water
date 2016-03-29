package com.water.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import com.monitorjbl.xlsx.StreamingReader;

public class XlsxReader {

	public static void main(String[] args) throws Exception {
		String cdrPath = "L:\\Temp\\water\\tmp\\CDR.xlsx";
//		try (InputStream is = new FileInputStream(new File(cdrPath));
//				StreamingReader reader = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).sheetIndex(2)
//						.read(is);) {
//			for (Row r : reader) {
//				for (Cell c : r) {
//					System.out.println(c.getStringCellValue());
//				}
//			}
//		}
		InputStream is = new FileInputStream(new File(cdrPath));
		StreamingReader reader = StreamingReader.builder()
		        .rowCacheSize(10)    // number of rows to keep in memory (defaults to 10)
		        .bufferSize(1024)     // buffer size to use when reading InputStream to file (defaults to 1024)
		        .sheetName("sheet1")  // name of sheet to use (overrides sheetIndex)
		        .read(is);            // InputStream or File for XLSX file (required)
		
		int i=0;
		Map<Integer, Row> sheetMap = new HashMap<Integer, Row>();
		for (Row r : reader) {
			sheetMap.put(i++, r);
//			Cell c1 = r.getCell(CellReference.convertColStringToIndex("GR"));
//			System.out.println(c1.getStringCellValue());
//			for (Cell c : r) {
//				System.out.print(c.getStringCellValue());
//				System.out.print(", ");
//			}
//			System.out.println();
//			if(i == 100) {
//				break;
//			}
		}
		reader.close();
		is.close();
		
		//--GA2:GA621,GA642:GA661,GA682:GA721,GA742:GA821
		CellReference cr1 = new CellReference("GR2");
		CellReference cr2 = new CellReference("GR621");

		CellRangeAddress cra = new CellRangeAddress(cr1.getRow(), cr2.getRow(), cr1.getCol(), cr2.getCol());

		double sum = 0.0;
		for (int ij = cra.getFirstRow(); ij <= cra.getLastRow(); ij++) {
			for (int jk = cra.getFirstColumn(); jk <= cra.getLastColumn(); jk++) {
				Row rowtest = sheetMap.get(ij);
				Cell celljk = rowtest.getCell(jk);
				sum += (celljk == null || celljk.getStringCellValue() == null || "".equals(celljk.getStringCellValue().trim()) ? 0 : Double.parseDouble(celljk.getStringCellValue()));
			}
		}
		
		System.out.println(sum);
	}
}
