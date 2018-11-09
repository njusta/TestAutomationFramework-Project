package com.facebook;
import java.io.IOException;
import org.testng.annotations.Test;
import utilities.BaseClass;
import utilities.CommonUtils;

public class LoginTests extends BaseClass {

	@Test
	public void enterLoginDetails_Invalid() throws IOException {
		LoginPage objPage = new LoginPage(driver);
		
		objPage.enterUsername(CommonUtils.readStringTestData(1, 0));
		objPage.enterPassword(CommonUtils.readStringTestData(1, 1));
		objPage.clickLogin();
		
		objPage = null;
		
	}
	@Test
	public void enterLoginDetails_Valid() throws IOException {
		LoginPage objPage = new LoginPage(driver);
		
		objPage.enterUsername(CommonUtils.readStringTestData(2, 0));
		objPage.enterPassword(CommonUtils.readStringTestData(2, 1));
		objPage.clickLogin();
		
		objPage = null;
		
	}

//	@Test
//	public void enterLoginDetails_Valid() throws IOException, Exception {
//		LoginPage objPage = new LoginPage(driver);
//		File src = new File("D:\\eclipse-TestAutomationFramwork\\test-data\\Controller.xlsx");
//		FileInputStream fis = new FileInputStream(src);
//		workbook = new XSSFWorkbook(fis);
//
//		sheet = workbook.getSheet("Logins");
//		cell = sheet.getRow(2).getCell(0);
//		cell.setCellType(Cell.CELL_TYPE_STRING);
//		Reporter.log("=== Enter username ===");
//		Reporter.log(cell.getStringCellValue());
//		objPage.enterUsername(cell.getStringCellValue());
//
//		cell = sheet.getRow(2).getCell(1);
//		cell.setCellType(Cell.CELL_TYPE_STRING);
//		Reporter.log("=== Enter Password ===");
//		Reporter.log(cell.getStringCellValue());
//		objPage.enterPassword(cell.getStringCellValue());
//		objPage.clickLogin();
//		fis.close();
//		
//	}

}
