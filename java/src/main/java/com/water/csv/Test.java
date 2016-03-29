package com.water.csv;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Map<String, String[]> data = get(args[0]);
		Map<String, String[]> data2 = get2(args[1]);
		CsvWriter pw = new CsvWriter(args[2]);
		pw.writeRecord("GSST_Source,Period,Data_Source,AsOfDate,Name,GFCID,CAGID,GFRN,Sequence,isCRC,isStressTest,isIVAST,isCVA,isSCAP,isICAAP,isCOC,isRFA,isHoldings,isPerforming,isLLR,isLLR10yrs,isMarkdown,BusinessCode,CRCCode,GSSTCode,BusinessHierarchy,CRCHierarchy,GSSTHierarchy,ObligorCountry,ObligorRegion,FacilityCountry,FacilityRegion,Sector,IndustryCode,IndustryName,FacilityAssetType,FacilityBusiness,FacilityProduct,FacilityTreatment,LegalVehicle,FacilityType,FDLType,LCYflag,FacilityCurrency,ORR,FRR,RemainingTenor,Exposure,MarketValue,FairValue,NormalCRC,SurchargeCRC,ExpectedLoss,LifetimeLoss,LLR,GSST_PriceShock_DM_IRLevelUp150,GSST_PriceShock_DM_IRLevelDown150,GSST_PriceShock_EM_IRLevelUp300,GSST_PriceShock_EM_IRLevelDown300,GSST_PriceShock_DM_SlopeLevelUp200,GSST_PriceShock_DM_SlopeLevelDown125,GSST_PriceShock_EM_SlopeLevelUp200,GSST_PriceShock_EM_SlopeLevelDown125,GSST_PriceShock_DM_SpreadUp80,GSST_PriceShock_DM_SpreadDown35,GSST_PriceShock_EM_SpreadUp100,GSST_PriceShock_EM_SpreadDown45,GSST_PriceShock_DM_GDPUp410,GSST_PriceShock_EM_GDPUp410,GSST_PriceShock_DM_GDPDown272,GSST_PriceShock_EM_GDPDown272,GSST_PriceShock_DM_1974_FY,GSST_PriceShock_EM_1974_FY,GSST_PriceShock_DM_2008_FY,GSST_PriceShock_EM_2008_FY,GSST_PriceShock_DM_1974CapitalBaseline_FullReval,GSST_PriceShock_EM_1974CapitalBaseline_FullReval,GSST_PriceShock_DM_2008CapitalBaseline_FullReval,GSST_PriceShock_EM_2008CapitalBaseline_FullReval,GSST_PriceShock_DM_Deep_Downturn,GSST_PriceShock_EM_Deep_Downturn,GSST_PriceShock_DM_Dollar_Collapse,GSST_PriceShock_EM_Dollar_Collapse,GSST_PriceShock_DM_Dollar_Decline,GSST_PriceShock_EM_Dollar_Decline,GSST_PriceShock_DM_Double_Dip,GSST_PriceShock_EM_Double_Dip,GSST_PriceShock_DM_Delayed_Recovery,GSST_PriceShock_EM_Delayed_Recovery,GSST_PriceShock_DM_Lost_Decade,GSST_PriceShock_EM_Lost_Decade,GSST_PriceShock_DM_ThroughTheCycle,GSST_PriceShock_EM_ThroughTheCycle,GSST_PriceShock_DM_BaseCase,GSST_PriceShock_EM_BaseCase,GSST_PriceShock_DM_Interest_Rate_Shock,GSST_PriceShock_EM_Interest_Rate_Shock,GSST_DefaultLoss_DM_IRLevelUp150,GSST_DefaultLoss_DM_IRLevelDown150,GSST_DefaultLoss_EM_IRLevelUp300,GSST_DefaultLoss_EM_IRLevelDown300,GSST_DefaultLoss_DM_SlopeLevelUp200,GSST_DefaultLoss_DM_SlopeLevelDown125,GSST_DefaultLoss_EM_SlopeLevelUp200,GSST_DefaultLoss_EM_SlopeLevelDown125,GSST_DefaultLoss_DM_SpreadUp80,GSST_DefaultLoss_DM_SpreadDown35,GSST_DefaultLoss_EM_SpreadUp100,GSST_DefaultLoss_EM_SpreadDown45,GSST_DefaultLoss_DM_GDPUp410,GSST_DefaultLoss_EM_GDPUp410,GSST_DefaultLoss_DM_GDPDown272,GSST_DefaultLoss_EM_GDPDown272,GSST_DefaultLoss_DM_1974_FY,GSST_DefaultLoss_EM_1974_FY,GSST_DefaultLoss_DM_2008_FY,GSST_DefaultLoss_EM_2008_FY,GSST_DefaultLoss_DM_1974CapitalBaseline_FullReval,GSST_DefaultLoss_EM_1974CapitalBaseline_FullReval,GSST_DefaultLoss_DM_2008CapitalBaseline_FullReval,GSST_DefaultLoss_EM_2008CapitalBaseline_FullReval,GSST_DefaultLoss_DM_Deep_Downturn,GSST_DefaultLoss_EM_Deep_Downturn,GSST_DefaultLoss_DM_Dollar_Collapse,GSST_DefaultLoss_EM_Dollar_Collapse,GSST_DefaultLoss_DM_Dollar_Decline,GSST_DefaultLoss_EM_Dollar_Decline,GSST_DefaultLoss_DM_Double_Dip,GSST_DefaultLoss_EM_Double_Dip,GSST_DefaultLoss_DM_Delayed_Recovery,GSST_DefaultLoss_EM_Delayed_Recovery,GSST_DefaultLoss_DM_Lost_Decade,GSST_DefaultLoss_EM_Lost_Decade,GSST_DefaultLoss_DM_ThroughTheCycle,GSST_DefaultLoss_EM_ThroughTheCycle,GSST_DefaultLoss_DM_BaseCase,GSST_DefaultLoss_EM_BaseCase,GSST_DefaultLoss_DM_Interest_Rate_Shock,GSST_DefaultLoss_EM_Interest_Rate_Shock,GSST_LLRChg_DM_IRLevelUp150,GSST_LLRChg_DM_IRLevelDown150,GSST_LLRChg_EM_IRLevelUp300,GSST_LLRChg_EM_IRLevelDown300,GSST_LLRChg_DM_SlopeLevelUp200,GSST_LLRChg_DM_SlopeLevelDown125,GSST_LLRChg_EM_SlopeLevelUp200,GSST_LLRChg_EM_SlopeLevelDown125,GSST_LLRChg_DM_SpreadUp80,GSST_LLRChg_DM_SpreadDown35,GSST_LLRChg_EM_SpreadUp100,GSST_LLRChg_EM_SpreadDown45,GSST_LLRChg_DM_GDPUp410,GSST_LLRChg_EM_GDPUp410,GSST_LLRChg_DM_GDPDown272,GSST_LLRChg_EM_GDPDown272,GSST_LLRChg_DM_1974_FY,GSST_LLRChg_EM_1974_FY,GSST_LLRChg_DM_2008_FY,GSST_LLRChg_EM_2008_FY,GSST_LLRChg_DM_1974CapitalBaseline_FullReval,GSST_LLRChg_EM_1974CapitalBaseline_FullReval,GSST_LLRChg_DM_2008CapitalBaseline_FullReval,GSST_LLRChg_EM_2008CapitalBaseline_FullReval,GSST_LLRChg_DM_Deep_Downturn,GSST_LLRChg_EM_Deep_Downturn,GSST_LLRChg_DM_Dollar_Collapse,GSST_LLRChg_EM_Dollar_Collapse,GSST_LLRChg_DM_Dollar_Decline,GSST_LLRChg_EM_Dollar_Decline,GSST_LLRChg_DM_Double_Dip,GSST_LLRChg_EM_Double_Dip,GSST_LLRChg_DM_Delayed_Recovery,GSST_LLRChg_EM_Delayed_Recovery,GSST_LLRChg_DM_Lost_Decade,GSST_LLRChg_EM_Lost_Decade,GSST_LLRChg_DM_ThroughTheCycle,GSST_LLRChg_EM_ThroughTheCycle,GSST_LLRChg_DM_BaseCase,GSST_LLRChg_EM_BaseCase,GSST_LLRChg_DM_Interest_Rate_Shock,GSST_LLRChg_EM_Interest_Rate_Shock,LevelCode_1,LevelCode_2,LevelCode_3,LevelCode_4,LevelCode_5,LevelName_1,LevelName_2,LevelName_3,LevelName_4,LevelName_5,GOC,GocMngdSegCd,PORT_ID,CUSIP,CR_Org,Industry1".split(","));

		for (Entry<String, String[]> e : data.entrySet()) {
			if(data2.containsKey(e.getKey())) {
				String[] a = e.getValue();
				for(int i=0;i<a.length-2;i++) {
					pw.write(a[i]);
				}
				pw.write(data2.get(e.getKey())[1]);
				pw.write(data2.get(e.getKey())[2]);
				pw.endRecord();
			} else {
				System.out.println("F Seq :" + e.getKey() + " cannot find.");
			}
			data2.remove(e.getKey());
		}
		System.out.println("Java : "+data.size());
		System.out.println("AB : "+data2.size());
		pw.close();
	}

	private static Map<String, String[]> get(String name) {
		System.out.println("Filename : "+name);
		Map<String, String[]> data = new HashMap<String, String[]>(954974);
		CsvReader csvReader = null;
		try {
			csvReader = new CsvReader(name);

			while (csvReader.readRecord()) {
				if (0 == csvReader.getCurrentRecord()) {
					continue;
				}
				String[] columns = csvReader.getValues();
				String seq = columns[8];

				data.put(seq, columns);
				if(csvReader.getCurrentRecord() % 50000 == 0) {
					System.out.println("Filename : "+csvReader.getCurrentRecord());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (csvReader != null) {
				csvReader.close();
			}
		}
		System.out.println("Map size : "+data.keySet().size());
		return data;
	}
	
	private static Map<String, String[]> get2(String name) {
		System.out.println("Filename : "+name);
		Map<String, String[]> data = new HashMap<String, String[]>(1794349);
		CsvReader csvReader = null;
		try {
			csvReader = new CsvReader(name);

			while (csvReader.readRecord()) {
				if (0 == csvReader.getCurrentRecord()) {
					continue;
				}
				String[] columns = csvReader.getValues();
				String seq = columns[0];

				data.put(seq, columns);
				if(csvReader.getCurrentRecord() % 50000 == 0) {
					System.out.println("Filename : "+csvReader.getCurrentRecord());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (csvReader != null) {
				csvReader.close();
			}
		}
		System.out.println("Map size : "+data.keySet().size());
		return data;
	}
}
