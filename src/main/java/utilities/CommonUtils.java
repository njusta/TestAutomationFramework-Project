package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Two Ways to declare constant variables:
public class CommonUtils {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public final static String errorColorCode = "\u001B[31m";
	
	//Declare constants in class as public static so that they can be used in other methods without being instantiated:
	public static final String LocalBrowser = "Chrome";
	public static final String IEDriverPath = "D:\\Software\\Drivers\\IEDriverServer.exe";
	public static final String ChromeDriverPath = "D:\\Software\\Drivers\\chromedriver.exe";
	public static final String ApplicatonURL = "https://www.facebook.com";
	public static final int ImplicitlyWait = 10;
	static String TestDataPath = "D:\\eclipse-TestAutomationFramwork\\test-data\\Controller.xlsx";
    
	//Create a properties file and create methods to read each property:
	private Properties properties;
	private final String propertyFilePath = "D:\\eclipse-TestAutomationFramwork\\src\\main\\resources\\environment.properties";

	public void EnvFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("environment.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String path = properties.getProperty("gIEDriverPath");
		if (path != null)
			return path;
		else
			throw new RuntimeException("IEDriverPath not specified in the environment.properties file.");
	}

	public long getImplicitlyWait() {
		String gimplicitWait = properties.getProperty("gimplicitWait");
		if (gimplicitWait != null)
			return Long.parseLong(gimplicitWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the environment.properties file.");
	}

	public String getApplicationUrl() {
		String gApplicationURL = properties.getProperty("gApplicationURL");
		if (gApplicationURL != null)
			return gApplicationURL;
		else
			throw new RuntimeException("ApplicationURL not specified in the environment.properties file.");
	}

//*** Method to read test data
public static String readStringTestData(int row, int col) throws IOException {
	File src = new File(TestDataPath);
	FileInputStream fis = new FileInputStream(src);
	workbook = new XSSFWorkbook(fis);

	sheet = workbook.getSheet("Logins");
	cell = sheet.getRow(row).getCell(col);
	cell.setCellType(Cell.CELL_TYPE_STRING);
	fis.close();
	return cell.getStringCellValue();
}
}
