package SurveyTymeDemo;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericCharts {
	public static String ChartsPreferences_ChartsGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			String currentVisualcode = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='VCBMainContiner']/div[1]/table/tbody/tr/td[1]")).getText()
					.toString();
			System.out.println(currentVisualcode);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='chartLeftMenu']/div")).click();// Select
																									// Charts
																									// tab

			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='ResHeight']/ul/li[4]")).click();
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[2]/tr/td[2]/select"))
					.click(); // select chart theme
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[2]/tr/td[2]/select/option[3]"))
					.click(); // select default option
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[2]/tr/td[5]/input"))
					.sendKeys("6");// insert default rows
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[3]/tr/td[2]/select"))
					.click();// Select Trend chart
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[3]/tr/td[2]/select/option[2]"))
					.click();
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[3]/tr/td[5]/input"))
					.click();
			Thread.sleep(200);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions']/span/input[1]")).click();// Click
																													// on
																													// Apply
																													// button
			Thread.sleep(2000);
			String successFilesName = GenericMethods.driver
					.findElement(By.xpath(".//*[@class='bootstrap-dialog-title']")).getText().toString();
			System.out.println(successFilesName);
			if (successFilesName.equals("Success")) {
				Thread.sleep(5000);
				GenericMethods.driver
						.findElement(By
								.xpath(".//div[@class='modal bootstrap-dialog messageBoxContent type-info fade size-small in']/div/div/div[3]/div/div/button"))
						.click();
				Thread.sleep(500);
				System.out.println("Chart save Succesfully");
				return "pass";
			} else
				Thread.sleep(500);
			System.out.println("Save Runfailed");
			return "fail";

		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String TitleMode_ChartGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath("//*[@id='homeTab']")).click();
			Thread.sleep(200);
			GenericMethods.driver.findElement(By.xpath(obj)).click();

			GenericMethods.driver.findElement(By.xpath(".//*[@id='chartHomeGrp']/ul[3]/li[2]/div/a[2]")).click();
			Thread.sleep(500);
			String titleMode = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='chartHomeGrp']/ul[3]/li[2]/div/a[2]")).getText().toString();
			System.out.println(titleMode);
			if (titleMode.equals("Long Title")) {
				Thread.sleep(5000);
				return "pass";
			} else
				Thread.sleep(500);
			System.out.println("Title failed");
			return "fail";

		} catch (Exception e) {
			System.out.println(e);
			return "fail";
		}
	}

	public static String DataItem_ChartGrids(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			String totalDataItemsValues = GenericMethods.driver.findElement(By.xpath(".//*[@id='dataItems']")).getText()
					.toString();
			System.out.println(totalDataItemsValues);
			GenericMethods.driver.findElement(By.xpath(obj)).click();// Click on
			// Data
		    // Items
			// link
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath("//span[text()='%Row']")).click();// select
																							// Chart
																							// DataItems
																							// %Row
			Thread.sleep(500);
			String currentTotalDataItemsValues = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='dataItems']/option[4]")).getText().toString();
			System.out.println(currentTotalDataItemsValues);
			Thread.sleep(500);
			if (currentTotalDataItemsValues.equals("%Row")) {
				System.out.println("Pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else
				System.out.println("Fail");
			return "fail";
		} catch (Exception e) {
			System.out.println(e);
			return "Fail";
		}

	}

	public static String ExportExcel_ChartGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnExport']")).click();
			Thread.sleep(1000);
			return "pass";
		} catch (Exception e) {
			System.out.println(e);
			return "fail";
		}
	}

	public static String ExportImage_ChartGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(1000);
			return "pass";
		} catch (Exception e) {
			System.out.println(e);
			return "fail";
		}
	}

	public static String ExportChart_ChartGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(1000);
			return "pass";
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String PowerPoint_ChartGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(1000);
			return "pass";
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}
}
