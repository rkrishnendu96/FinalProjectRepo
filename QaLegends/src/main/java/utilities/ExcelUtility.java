package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String getStringData(int a, int b, String sheet) {
		try {
			String path = Constants.HOME_DIRECTORY + Constants.TESTDATA_EXCELPATH;
			f = new FileInputStream(path);
			w = new XSSFWorkbook(f);
			s = w.getSheet(sheet);
			XSSFRow row = s.getRow(a);
			XSSFCell column = row.getCell(b);
			return column.getStringCellValue();
		} catch (Exception error) {
			throw new RuntimeException("Excel sheet not found");
		}
	}

	public static String getIntegerData(int a, int b, String sheet) {
		try {
			String path = Constants.HOME_DIRECTORY + Constants.TESTDATA_EXCELPATH;
			f = new FileInputStream(path);
			w = new XSSFWorkbook(f);
			s = w.getSheet(sheet);
			XSSFRow row = s.getRow(a);
			XSSFCell column = row.getCell(b);
			int cellValue = (int) column.getNumericCellValue();
			return String.valueOf(cellValue);

		} catch (Exception error) {
			throw new RuntimeException("Excel sheet not found");
		}
	}
}
