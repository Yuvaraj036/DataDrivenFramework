package com.hutech.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
	
	static XSSFWorkbook workbook;
	
	@Test
	public static Object[][] getDataFromExcel(String sheetName)
	{
		File file=new File("./excel/testData.xlsx");
		try {
			workbook=new XSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int rows=sheet.getPhysicalNumberOfRows();
        int column= sheet.getRow(0).getPhysicalNumberOfCells();
        
        Object[][]arr=new Object [rows-1][column];
        
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<column;j++)
            {
                arr[i-1][j]=ExcelReader.getData(sheetName,i,j);
                System.out.println(arr[i-1][j]);
            }
        }
        
        try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return arr;


		
	}
	
	
	@Test
    public static String getData(String sheetName,int row, int column)
    {
      String value = null;
      CellType type=workbook.getSheet(sheetName).getRow(row).getCell(column).getCellType();
      if(type==CellType.STRING)
      {
          value=workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
          
      }
      if(type==CellType.BOOLEAN)
      {
          boolean bvalue=workbook.getSheet(sheetName).getRow(row).getCell(column).getBooleanCellValue();
          value= String.valueOf(bvalue);
      }
      if(type==CellType.NUMERIC)
      {
         double nvalue =workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
         value= String.valueOf(nvalue);
      }
      if(type==CellType.BLANK)
      {
          
         value="";
     
      }
     return value;

	
}
}
