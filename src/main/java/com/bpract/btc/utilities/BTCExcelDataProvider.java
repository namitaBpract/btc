package com.bpract.btc.utilities;


public class BTCExcelDataProvider {
	public Object[][] testData(String excelPath, String sheetName){
		BTCExcelUtility btcexcelutility = new BTCExcelUtility(excelPath, sheetName);
		int rowCount = btcexcelutility.getRowCount();
		int colCount = btcexcelutility.getCellCount();
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = btcexcelutility.getCellDataString(i, j);
				data[i-1][j] = cellData;
			}
		}
		return data;
	}
}
