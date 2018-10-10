package SurveyTymeDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import jxl.write.Label;

public class GenericMethods {
	public static WebDriver driver;

	// Keyword to launch browser and web application
	// Made By:Name
	// Made on: date
	public static void appLaunch(String P1, String P2, String P3, String P4, String P5, String P6, String obj) {
		System.out.println("Launching Applicaiton.....");
		System.out.println(P2);
		if (P2.equals("chrome")) {
			String path1 = System.getProperty("user.dir");
			String path=path1+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",path);
			driver = new ChromeDriver();
			// driver =new ChromeDriver();
			// driver.get(P1);
			// System.setProperty("webdriver.gecko.driver",
			// "D:\\Driver\\geckodriver.exe");
			// driver=new FirefoxDriver();

		} else if (P3.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			driver = new InternetExplorerDriver();
		}
		driver.get(P1);
		driver.manage().window().maximize();
		// driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// driver.get(P1);
	}

	// Keyword to set value
	public static void setValue(String P1, String P2, String P3, String P4, String P5, String P6, String obj) {
		driver.findElement(By.xpath(obj)).sendKeys(P1);
	}

	// Keyword to click on web application on a particular element
	public static void Click(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		driver.findElement(By.xpath(obj)).click();
		Thread.sleep(1000);

	}

	// Keyword to Double click on web application on a particular element
	public static void DoubleClick(String P1, String P2, String P3, String P4, String P5, String P6, String obj) {
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath(obj))).build().perform();
	}

	// Keyword for Context Menu on web application on a particular element
	public static void ContextMenuC(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		WebElement elementright = driver.findElement(By.xpath(".//*[@id='grid']/div[2]/table/tbody/tr/td[2]/div"));
		Actions action = new Actions(driver).contextClick(elementright);
		action.build().perform();
		Thread.sleep(500);
		WebElement elementRowRemove = driver.findElement(By.xpath(obj));
		elementRowRemove.click();
	}

	public static void ContextMenuForRow(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		WebElement elementright = driver.findElement(By.xpath(".//*[@id='grid']/div[2]/table/tbody/tr[2]/td[2]/div"));
		Actions action = new Actions(driver).contextClick(elementright);
		action.build().perform();
		Thread.sleep(500);
		WebElement elementRowRemove = driver.findElement(By.xpath(obj));
		elementRowRemove.click();
	}

	public static void ContextMenuForRowDelSeveral(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		WebElement elementright = driver.findElement(By.xpath(".//*[@id='grid']/div[2]/table/tbody/tr[2]/td[2]/div"));
		Actions action = new Actions(driver).contextClick(elementright);
		action.build().perform();
		Thread.sleep(500);
		// String CWHandle=driver.getWindowHandle();
		// System.out.println(CWHandle);
		WebElement elementDeleteSeveral = driver.findElement(By.xpath(".//*[@id='rowHeaderMenu_new']/li[2]/span"));
		elementDeleteSeveral.click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='DeleteSeveralWindow']/table/tbody/tr[1]/td/input")).click();
		// Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='OK']")).click();

	}

	public static String Seprated_Rank_Button(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException, FileNotFoundException {
		driver.findElement(By.xpath(obj)).click();
		Thread.sleep(5000);
		String totalValue = driver.findElement(By.xpath(".//*[@id='parent_SR_ColID_0']/table/tbody/tr/td[1]")).getText()
				.toString();
		System.out.println(totalValue);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='btnExport']")).click(); //Click on Excel button
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//*[@id='btnExport']")).click(); //Click on Export button
		System.out.println("Seprated Windows");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='btnDiv']/input[2]")).click();// Click
																			// on
																			// Sort
																			// button
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='sortWindowPopUp']/div[1]/table/tr[2]/td[1]/span/span/span[2]/span"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='divDataItemsDropDown_listbox']/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='rdbAsc']")).click();
		driver.findElement(By.xpath(".//*[@id='sortWindowPopUp']/div[3]/div/button[1]")).click();
		String currentValue = driver.findElement(By.xpath(".//*[@id='parent_SR_ColID_0']/table/tbody/tr/td[1]"))
				.getText().toString();
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";

	}

	public static String Seprated_Rank_Button_Unsort(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException, FileNotFoundException {
		String totalValue = driver.findElement(By.xpath(".//*[@id='parent_SR_ColID_0']/table/tbody/tr/td[1]")).getText()
				.toString();
		System.out.println(totalValue);
		driver.findElement(By.xpath(obj)).click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath(".//*[@id='btnExport']")).click();
		// System.out.println("Seprated Windows");
		driver.findElement(By.xpath(".//*[@id='sortWindowPopUp']/div[3]/button")).click();
		String currentValue = driver.findElement(By.xpath(".//*[@id='parent_SR_ColID_0']/table/tbody/tr/td[1]"))
				.getText().toString();
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Pass");
			// System.out.println(obj);
			// return 0;
			return "pass";

		} else
			System.out.println("Fail");
		return "fail";

	}

	public static String Seprated_Rank_Highlight_HighLightRules_Custom(String P1, String P2, String P3, String P4,
			String P5, String P6, String obj) throws InterruptedException, FileNotFoundException {
		String totalValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(totalValue);
		driver.findElement(By.xpath(obj)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='highlightDropdown']/a[1]")).click();// click
																					// on
																					// Highlight
																					// Rules
		Thread.sleep(200);
		// System.out.println("Seprated Windows");
		driver.findElement(By.xpath(".//*[@id='datatype_0']")).click();
		Thread.sleep(200);
		;
		driver.findElement(By.xpath(".//*[@id='datatype_0']/option[2]")).click();
		driver.findElement(By.xpath(".//*[@id='conditional_operator_0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='conditional_operator_0']/option[3]")).click();
		driver.findElement(By.xpath(".//*[@id='number_from_000']")).sendKeys("100");
		driver.findElement(By.xpath(".//*[@id='HighlightValueAdd']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='customTab']/div/div[11]/div[2]/input")).click();
		String currentValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		Thread.sleep(200);
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";

	}

	public static String Seprated_Rank_Highlight_HighLightRules_Gradient(String P1, String P2, String P3, String P4,
			String P5, String P6, String obj) throws InterruptedException, FileNotFoundException {
		String totalValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(totalValue);
		driver.findElement(By.xpath(".//*[@id='highlightRankMode']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(obj)).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='gradientTab']/span/span[2]")).click();// Click
																						// on
																						// Gradient
																						// expand
																						// list
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='datatype_1']")).click();// click
																		// on
																		// Data
																		// Type
																		// Drop
																		// down
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='datatype_1']/option[2]")).click();
		// System.out.println("Seprated Windows");
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='gradientTab']/div/table/tr/td[2]/span/span/span[2]/span")).click();
		Thread.sleep(200);
		driver.findElement(By
				.xpath(".//*[@class='k-widget k-colorpalette k-popup k-group k-reset k-state-border-up']/table/tbody/tr[3]/td[3]"))
				.click();// select color
		driver.findElement(By.xpath(".//*[@id='HighlightValueAdd1']")).click();// click
																				// on
																				// Apply
		Thread.sleep(500);
		String currentValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";

	}

	public static String Seprated_Rank_Highlight_HighLightRules_Clears(String P1, String P2, String P3, String P4,
			String P5, String P6, String obj) throws InterruptedException, FileNotFoundException {
		String totalValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(totalValue);
		driver.findElement(By.xpath(".//*[@id='highlightRankMode']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(obj)).click();// click on Cleared Highlight
													// Rules
		Thread.sleep(500);
		String currentValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";
	}

	public static String Combined_Rank_Button(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException, FileNotFoundException {
		driver.findElement(By.xpath(".//*[@id='btnDiv']/input[6]")).click();
		driver.findElement(By.xpath(obj)).click();
		System.out.println(obj);
		String totalValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(totalValue);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='btnDiv']/input[1]")).click();
		System.out.println("Excel Button");
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='btnExport']")).click();// click
																		// on
																		// Export
																		// button
																		// for
																		// exporting
																		// file
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='btnDiv']/input[2]")).click();// Click
																			// on
																			// Sort
																			// button
																			// for
																			// sorting
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='sortWindowPopUp']/div[1]/table/tr[2]/td[1]/span/span/span[2]/span"))
				.click();// select data type
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='divDataItemsDropDown_listbox']/li[2]")).click();// select
																								// Respondent
																								// option
		driver.findElement(By.xpath(".//*[@id='rdbAsc']")).click();// select Asc
																	// order
		driver.findElement(By.xpath(".//*[@id='sortWindowPopUp']/div[3]/div/button[1]")).click();// click
																									// on
																									// Ok
																									// button
																									// for
																									// sorting
		String currentValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";

	}

	public static String Combined_Rank_Button_Unsort(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException, FileNotFoundException {
		String totalValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(totalValue);
		driver.findElement(By.xpath(obj)).click();// Click on Sort button for
													// sorting
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=' Un-Sort']")).click();// Click
																			// on
																			// unSort
																			// button
																			// for
																			// sorting
		String currentValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";

	}

	public static String Combined_Rank_Highlight_HighLightRules_Custom(String P1, String P2, String P3, String P4,
			String P5, String P6, String obj) throws InterruptedException, FileNotFoundException {
		String totalValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(totalValue);
		driver.findElement(By.xpath(obj)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='highlightDropdown']/a[1]")).click();// click
																					// on
																					// Highlight
																					// Rules
		Thread.sleep(200);
		// System.out.println("Seprated Windows");
		driver.findElement(By.xpath(".//*[@id='datatype_0']")).click();
		Thread.sleep(200);
		;
		driver.findElement(By.xpath(".//*[@id='datatype_0']/option[2]")).click();
		driver.findElement(By.xpath(".//*[@id='conditional_operator_0']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='conditional_operator_0']/option[3]")).click();
		driver.findElement(By.xpath(".//*[@id='number_from_000']")).sendKeys("100");
		driver.findElement(By.xpath(".//*[@id='HighlightValueAdd']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='customTab']/div/div[11]/div[2]/input")).click();
		String currentValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";

	}

	public static String Combined_Rank_Highlight_HighLightRules_Gradient(String P1, String P2, String P3, String P4,
			String P5, String P6, String obj) throws InterruptedException, FileNotFoundException {
		String totalValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(totalValue);
		driver.findElement(By.xpath(".//*[@id='highlightRankMode']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(obj)).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='gradientTab']/span/span[2]")).click();// Click
																						// on
																						// Gradient
																						// expand
																						// list
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='datatype_1']")).click();// click
																		// on
																		// Data
																		// Type
																		// Drop
																		// down
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='datatype_1']/option[2]")).click();
		// System.out.println("Seprated Windows");
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='gradientTab']/div/table/tr/td[2]/span/span/span[2]/span")).click();// click
																													// on
																													// Color
		Thread.sleep(200);
		driver.findElement(By
				.xpath(".//*[@class='k-widget k-colorpalette k-popup k-group k-reset k-state-border-up']/table/tbody/tr[3]/td[3]"))
				.click();// select color
		driver.findElement(By.xpath(".//*[@id='HighlightValueAdd1']")).click();// click
																				// on
																				// Apply
		Thread.sleep(500);
		String currentValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(currentValue);
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";

	}

	public static String Combined_Rank_Highlight_HighLightRules_Clears(String P1, String P2, String P3, String P4,
			String P5, String P6, String obj) throws InterruptedException, FileNotFoundException {
		String totalValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(totalValue);
		driver.findElement(By.xpath(".//*[@id='highlightRankMode']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(obj)).click();// click on Cleared Highlight
													// Rules
		Thread.sleep(1000);
		String currentValue = driver.findElement(By.xpath(".//*[@id='infoDiv']")).getText().toString();
		System.out.println(currentValue);
		driver.findElement(By.xpath(".//*[@id='btnDiv']/input[6]")).click();// Click
																			// on
																			// Close
																			// button
		if (totalValue.equals(currentValue)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";
	}

	public static String swapFunction(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		String ColOneValue = driver.findElement(By.xpath("html/body/div[2]/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/div[1]/div/div[10]/table/tbody/tr[2]/td/div/div[1]/div[1]/div[2]/table/thead/tr[2]/th[2]/div/div[2]")).getText()
				.toString();
		System.out.println(ColOneValue);
		String RowOneValue = driver
				.findElement(By.xpath("html/body/div[2]/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/div[1]/div/div[10]/table/tbody/tr[2]/td/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/div/div[2]/div")).getText()
				.toString();
		System.out.println(RowOneValue);
		// String temp=null;
		// temp=ColOneValue;
		driver.findElement(By.xpath(obj)).click();
		String AfterColOneValue = driver.findElement(By.xpath("html/body/div[2]/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table[1]/tbody/tr/td[2]/div[1]/div/div[10]/table/tbody/tr[2]/td/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/div/div[2]/div")).getText().toString();
		System.out.println(AfterColOneValue);
		String AfterRowOneValue = driver
				.findElement(By.xpath(".//*[@id='grid']/div[2]/table/tbody/tr[2]/td[2]/div/div[2]/div")).getText()
				.toString();
		System.out.println(AfterRowOneValue);
		Thread.sleep(1000);
		if (RowOneValue.equals(AfterColOneValue)) {
			System.out.println("Pass");
			// System.out.println(obj);
			// return 0;
			return "pass";

		} else
			System.out.println("Fail");
		return "fail";
	}

	public static void TitleMode(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		driver.findElement(By.xpath(obj)).click();
		driver.findElement(By.xpath(".//*[@id='xTabHomeGrp']/ul[1]/li[7]/div/a[1]")).click();
		// driver.findElement(By.xpath(".//*[@id='xTabHomeGrp']/ul[1]/li[7]/div/a[3]")).click();
		// driver.findElement(By.xpath(".//*[@id='xTabHomeGrp']/ul[1]/li[7]/div/a[2]")).click();
		Thread.sleep(500);
	}

	// Change Highlights values from home page
	public static String HighlightsValueCustomHome(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		Actions ToolTip1 = new Actions(driver);
		WebElement imageLogo = driver.findElement(By.xpath(".//*[@id='icon_higlight']"));
		Thread.sleep(200);
		ToolTip1.clickAndHold(imageLogo).perform();
		String ToolTipTxt = imageLogo.getText().toString();
		System.out.println("Tooltip value is:" + ToolTipTxt);
		driver.findElement(By.xpath(obj)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='resultFormatGrp']/li[2]/div/a[1]")).click();// click
																							// on
																							// Highlight
																							// Rules
		Thread.sleep(200);
		// System.out.println("Seprated Windows");
		driver.findElement(By.xpath(".//*[@id='datatype_0']")).click();// Click
																		// on
																		// DataType
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='datatype_0']/option[2]")).click();
		driver.findElement(By.xpath(".//*[@id='conditional_operator_0']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='conditional_operator_0']/option[3]")).click();
		driver.findElement(By.xpath(".//*[@id='number_from_000']")).sendKeys("100");
		driver.findElement(By.xpath(".//*[@id='HighlightValueAdd']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='customTab']/div/div[11]/div[2]/input")).click();
		Thread.sleep(200);
		// Actions ToolTip1 = new Actions(driver);
		WebElement imageLogo1 = driver.findElement(By.xpath(".//*[@id='icon_higlight']"));
		Thread.sleep(200);
		ToolTip1.clickAndHold(imageLogo1).build().perform();
		Thread.sleep(1000);
		WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='tooltip fade bottom in']"));
		String ToolTipTxt1 = toolTipElement.getText();
		// System.out.println("Tooltip value is:"+ ToolTipTxt1);
		System.out.println("After Tooltip value is:" + ToolTipTxt1);
		if (ToolTipTxt.equals(ToolTipTxt1)) {
			System.out.println("Fail");
			// System.out.println(obj);
			// return 0;
			return "fail";

		} else
			System.out.println("Pass");
		return "pass";

	}

	// Change Data Items values from home page
	public static String DataItemFromHome(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		try {
			String totalDataItemsValues = driver
					.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[2]/td[3]/div")).getText().toString();
			System.out.println(totalDataItemsValues);
			driver.findElement(By.xpath(obj)).click();// Click on Data Items
														// link
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='dataItemWindow']/div[1]/table/tbody/tr/td[1]/a")).click();
			Thread.sleep(2000);
			// Actions action = new Actions(driver);
			driver.findElement(By.xpath(".//*[@id='allAvailableDataItemGrid']/table/tbody/tr[6]/td")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath(".//*[@id='availableDataItemWindow']/div[4]/div/table/tbody/tr/td/input[1]"))
					.click();
			Thread.sleep(200);
			driver.findElement(By.xpath(".//*[@id='dataItemWindow']/div[3]/table/tbody/tr/td/input[1]")).click();
			Thread.sleep(200);
			String currentTotalDataItemsValues = driver
					.findElement(By.xpath("//*[@id=grid']/div[2]/table/tbody/tr[2]/td[3]/div")).getText().toString();

			System.out.println(currentTotalDataItemsValues);
			Thread.sleep(500);
			if (totalDataItemsValues.equals(currentTotalDataItemsValues)) {
				System.out.println("Fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else
				System.out.println("Pass");
			return "pass";
		} catch (Exception e) {
			System.out.println(e);
			return "Fail";
		}

	}

	// Change Data Items for Number Format values from home page
	public static String DataItemFromNumberFormatHome(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		String totalDataItemsValues = driver
				.findElement(By.xpath(".//*[@id='grid']/div[2]/table/tbody/tr[1]/td[3]/div")).getText().toString();
		System.out.println(totalDataItemsValues);
		driver.findElement(By.xpath(obj)).click();// Click on Data Items link
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='dataItemWindow']/div[1]/table/tbody/tr/td[2]/a")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(".//*[@id='ddl_102']")).click();
		driver.findElement(By.xpath(".//*[@id='ddl_102']/option[3]")).click();
		driver.findElement(By.xpath(".//*[@id='numberFormatDiv']/div[7]/div/table/tbody/tr/td/input[1]")).click();
		String currentTotalDataItemsValues = driver
				.findElement(By.xpath(".//*[@id='grid']/div[2]/table/tbody/tr[1]/td[3]/div")).getText().toString();
		System.out.println(currentTotalDataItemsValues);
		if (totalDataItemsValues.equals(currentTotalDataItemsValues)) {
			System.out.println("Pass");
			// System.out.println(obj);
			// return 0;
			return "pass";

		} else
			System.out.println("Fail");
		return "fail";
	}

	// Change Data Items for Number Format values from home page
	public static String SaveOwnCodesForHome(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			Date dt = new Date();
			System.out.println(dt);
			String dateVar = dt.toString().replace(" ", "").replace(":", "");
			dateVar = dateVar.replace(":", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath(obj)).click();// Click on Save own Codes
														// Items link
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='txtOwnCodeFileName']")).sendKeys("MRICode_" + dateVar);
			Thread.sleep(200);
			driver.findElement(By.xpath(".//*[@id='chkAllTables']")).click();
			driver.findElement(By.xpath(".//*[@id='chkAllColumns']")).click();
			driver.findElement(By.xpath(".//*[@id='chkAllRows']")).click();
			driver.findElement(By.xpath(".//*[@id='btnOK']")).click();
			String successFilesName = driver.findElement(By.xpath(".//*[@class='bootstrap-dialog-title']")).getText()
					.toString();
			System.out.println(successFilesName);
			// Thread.sleep(2000);

			if (successFilesName.equals("File Alert")) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@role='dialog']/div/div/div[3]/div/div/button[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@role='dialog']/div/div/div[3]/div/div/button[1]")).click();
				System.out.println("File save Succesfully");
				return "pass";
			} else if (successFilesName.equals("SurveyTime")) {
				Thread.sleep(500);
				driver.findElement(By.xpath("//div[@role='dialog']/div/div/div[3]/div/div/button[1]")).click();
				System.out.println("Successfully Saved");
				return "pass";
			} else
				Thread.sleep(500);
			System.out.println("Own codes failed");
			return "fail";

		} catch (Exception e) {
			System.out.println(e);
			return "Fail";
		}

	}// Undo Cross Tab from home page

	public static String UndoRedoCrossTab(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		try {
			String lastCcount = driver.findElement(By.xpath(".//*[@id='columnCountSpan']")).getText().toString();
			System.out.println(lastCcount);
			driver.findElement(By.xpath(obj)).click();
			Thread.sleep(5000);
			String corrrentCcount = driver.findElement(By.xpath(".//*[@id='columnCountSpan']")).getText().toString();
			System.out.println(corrrentCcount);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='navbar']/div[3]/ul/li[8]/span")).click();
			String redoColCount = driver.findElement(By.xpath(".//*[@id='columnCountSpan']")).getText().toString();
			System.out.println(redoColCount);
			if (lastCcount.equals(redoColCount)) {
				System.out.println("Pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("Fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "Fail";

		}

	}

	// Keyword DragAndDrop to Row.
	// any node from code book
	public static String dragAndDropAddRow(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		try {
			String lastRcount = driver.findElement(By.xpath(".//*[@id='rowCountSpan']")).getText().toString();
			System.out.println(lastRcount);
			WebElement drag = driver.findElement(By.xpath(obj));
			drag.click();
			System.out.println(drag);
			WebElement drop1 = driver.findElement(By.xpath("//*[@id='btnAddNewRow']"));
			WebElement drop2 = driver.findElement(By.xpath(".//*[@id='div_row_separate']"));
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.clickAndHold(drag);
			Thread.sleep(1000);
			// act.dragAndDrop(ele1, ele2).build().perform();
			action.moveToElement(drop1).build().perform();
			Thread.sleep(1000);
			action.dragAndDrop(drag, drop2).build().perform();
			Thread.sleep(1000);
			String corrrentRcount = driver.findElement(By.xpath(".//*[@id='rowCountSpan']")).getText().toString();
			System.out.println(corrrentRcount);
			if (lastRcount.equals(corrrentRcount)) {
				System.out.println("Fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("Pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "Fail";

		}

	}

	// Keyword DragAndDrop to Col.
	// any node from code book
	public static String dragAndDropAddCol(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws InterruptedException {
		try {
			String lastColcount = driver.findElement(By.xpath(".//*[@id='columnCountSpan']")).getText().toString();
			System.out.println(lastColcount);
			WebElement drag = driver.findElement(By.xpath(obj));
			drag.click();
			System.out.println(drag);
			WebElement drop1 = driver.findElement(By.xpath(".//*[@id='btnAddNewColumn']"));
			WebElement drop2 = driver.findElement(By.xpath(".//*[@id='div_column_separate']"));
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.clickAndHold(drag);
			Thread.sleep(1000);
			// act.dragAndDrop(ele1, ele2).build().perform();
			action.moveToElement(drop1).build().perform();
			Thread.sleep(1000);
			action.dragAndDrop(drag, drop2).build().perform();
			Thread.sleep(1000);
			String corrrentCcount = driver.findElement(By.xpath(".//*[@id='columnCountSpan']")).getText().toString();
			System.out.println(corrrentCcount);
			if (lastColcount.equals(corrrentCcount)) {
				System.out.println("Fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("Pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "Fail";

		}

	}

	// Keyword DragAndDrop to Table.
	public static String dragAndDropAddTable(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			String lastRcount = driver
					.findElement(By
							.xpath(".//*[@id='div_cross_tab_grid']/div/div[10]/table/tbody/tr[1]/td/table/tbody/tr/td[4]/div/div/table/tbody/tr[2]/td[2]/span/span/span[1]"))
					.getText().toString();
			System.out.println(lastRcount);
			WebElement drag = driver.findElement(By.xpath(obj));
			drag.click();
			System.out.println(drag);
			WebElement drop1 = driver.findElement(By.xpath(".//*[@id='btnAddNewTable']"));
			WebElement drop2 = driver.findElement(By.xpath(".//*[@id='div_table_separate']"));
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.clickAndHold(drag);
			Thread.sleep(1000);
			// act.dragAndDrop(ele1, ele2).build().perform();
			action.moveToElement(drop1).build().perform();
			Thread.sleep(1000);
			action.dragAndDrop(drag, drop2).build().perform();
			Thread.sleep(1000);
			String corrrentRcount = driver.findElement(By.xpath(".//*[@id='txtBoxTable-list']")).getText().toString();
			if (lastRcount.equals(corrrentRcount)) {
				System.out.println("Fail");
				// System.out.println(obj);
				// return 0;
				return "Fail";

			} else
				System.out.println("Pass");
			return "Pass";
		} catch (Exception e) {
			System.out.println(e);
			return "Fail";

		}

	}

	// Keyword for wait for page load
	public static void WaitForPageLoad(String P1, String P2, String P3, String P4, String P5, String P6, String obj) {
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
	}

	// Put waitdriver
	public static void Wait(String P1, String P2, String P3, String P4, String P5, String P6, String obj)
			throws NumberFormatException, InterruptedException {
		Thread.sleep(Integer.parseInt(P1) * 1500);
	}
	// public static void select_new_survey() {
	// driver.findElement(By.id("//input[@id='rdbNewSurvey']")).click();
	// driver.findElement(By.xpath("//input[@type='button']")).click();
	// }

}
