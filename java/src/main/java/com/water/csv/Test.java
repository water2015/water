package com.water.csv;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(new File("C:\\Users\\yl70801.NAM\\git\\water\\java\\f.txt"));

		Map<String, Double> data = get("L:\\Projects\\rc_simulation\\File Compare\\November Month end run\\Java\\wsc_rc_facility_2015113007.csv");
		Map<String, Double> data2 = get("L:\\Projects\\rc_simulation\\File Compare\\November Month end run\\AbInitio\\4916642_rc_facility_2015113007.csv");

//		for (Entry<String, Double> e : data.entrySet()) {
//			System.out.println(e.getKey() + "=" + e.getValue());
//		}
//		for (Entry<String, Double> e : data2.entrySet()) {
//			System.out.println(e.getKey() + "=" + e.getValue());
//		}
		System.out.println(data.size());
		System.out.println(data2.size());
		for (Entry<String, Double> e : data.entrySet()) {
			if(!data2.containsKey(e.getKey())) {
				pw.println(e.getKey() + "==" + e.getValue());
			}
			if(data2.containsKey(e.getKey()) && data2.get(e.getKey()) - e.getValue() != 0) {
				pw.println(e.getKey() + "=" + e.getValue() + "="+data2.get(e.getKey()));
			} 
			data2.remove(e.getKey());
		}
		System.out.println(data.size());
		System.out.println(data2.size());
		for (Entry<String, Double> e : data2.entrySet()) {
			pw.println(e.getKey() + "=" + e.getValue());
		}
		pw.flush();
		pw.close();
	}
	
	private static Map<String, Double> get(String name) {
		Map<String, Double> data = new HashMap<String, Double>();
double sum = 0;
		CsvReader csvReader = null;
		try {
			csvReader = new CsvReader(name);

			String[] columnNames = null;
			while (csvReader.readRecord()) {
				if (0 == csvReader.getCurrentRecord()) {
					columnNames = csvReader.getValues();
					continue;
				}
				String[] columns = csvReader.getValues();
/**
 * String cagid = facilityData.getData().get(FacilityField.CAGID.toString());
			double creditExp = Double.parseDouble(facilityData.getData().get(FacilityField.CreditExposure.toString()));
			String expType = facilityData.getData().get(FacilityField.Exposuretype.toString());
			String flag = facilityData.getData().get(FacilityField.LocalCurrencyFlag.toString());
 */
				String a = columns[16];
				String b = columns[19];
				String c = columns[31];
				String d = columns[9];
				String e = columns[41];
				
				String key = a+"|"+b; //+"|"+b+"|"+c+"|"+d;
				double num = Double.parseDouble(StringUtils.isBlank(e) ? "0" : e);
				sum += num;
				if (data.get(key) != null) {
					num = num + data.get(key);
				}
				data.put(key, num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (csvReader != null) {
				csvReader.close();
			}
		}
		System.out.println("Sum = " + sum);
		return data;
	}
}
