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

public class GenericCodingGrid {
	// public static WebDriver driver;
	public static String dragAndDropCodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {
			Thread.sleep(2000);
			String currentColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCol']")).getText()
					.toString();
			System.out.println(currentColCount);
			WebElement drag = GenericMethods.driver.findElement(By.xpath(obj));
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCol']")).click();
			drag.click();
			System.out.println(drag);
			Thread.sleep(200);
			WebElement mainGrid = GenericMethods.driver.findElement(By.id("grid1"));
			WebElement drop = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='tblCrtNewRow']/table/tbody/tr[1]/td"));
			Thread.sleep(5000);
			Actions action = new Actions(GenericMethods.driver);
			action.clickAndHold(drag);
			Thread.sleep(1000);
			action.moveToElement(mainGrid).build().perform();
			// Thread.sleep(1000);
			action.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(2000);
			String lastColCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCol']")).getText()
					.toString();
			System.out.println(lastColCcount);
			if (currentColCount.equals(lastColCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String dragAndDrop_Row_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5,
			String P6, String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {
			Thread.sleep(2000);
			String currentColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentColCount);
			WebElement drag = GenericMethods.driver.findElement(By.xpath(obj));
			drag.click();
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).click();
			WebElement mainGrid = GenericMethods.driver.findElement(By.id("grid1"));
			WebElement drop = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='tblCrtNewRow']/table/tbody/tr[1]/td"));
			// System.out.println(drag);
			Thread.sleep(5000);
			Actions action = new Actions(GenericMethods.driver);
			action.clickAndHold(drag);
			action.moveToElement(mainGrid).build().perform();
			Thread.sleep(1000);
			action.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(1000);
			String lastColCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastColCcount);
			if (currentColCount.equals(lastColCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String dragAndDrop_Table_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5,
			String P6, String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {
			Thread.sleep(2000);
			String currentColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnTable']")).getText()
					.toString();
			System.out.println(currentColCount);
			WebElement drag = GenericMethods.driver.findElement(By.xpath(obj));
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnTable']")).click();
			drag.click();
			System.out.println(drag);
			Thread.sleep(200);
			WebElement mainGrid = GenericMethods.driver.findElement(By.id("grid1"));
			Actions action = new Actions(GenericMethods.driver);
			Thread.sleep(3000);
			action.clickAndHold(drag);
			Thread.sleep(2000);
			action.moveToElement(mainGrid).build().perform();
			Thread.sleep(2000);
			WebElement drop = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='tblCrtNewRow']/table/tbody/tr[1]/td"));
			Thread.sleep(2000);
			action.dragAndDrop(drag, drop).build().perform();
			Thread.sleep(2000);
			String lastColCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnTable']")).getText()
					.toString();
			System.out.println(lastColCcount);
			if (currentColCount.equals(lastColCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Table_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnTable']")).getText()
					.toString();
			System.out.println(currentColCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Children Under 18']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			;
			Thread.sleep(2000);
			String lastColCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnTable']")).getText()
					.toString();
			System.out.println(lastColCcount);
			if (currentColCount.equals(lastColCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Columns_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5,
			String P6, String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {
			Thread.sleep(3000);
			String currentColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCol']")).getText()
					.toString();
			System.out.println(currentColCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Census Region']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			;
			Thread.sleep(2000);
			String lastColCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCol']")).getText()
					.toString();
			System.out.println(lastColCcount);
			if (currentColCount.equals(lastColCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Rows_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {
			Thread.sleep(3000);
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			GenericMethods.driver.findElement(By.xpath("//span[text()='CBSA']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			;
			Thread.sleep(2000);
			String lastRowscount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowscount);
			if (currentRowsCount.equals(lastRowscount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Auto_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsColCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Wage Earner Status']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			;
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsColCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Button_Add_Selected_CodingGridAddCol(String P1, String P2, String P3, String P4,
			String P5, String P6, String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Life Cycle: Respondent 18-34']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			;
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Any_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Life Cycle: Respondent 18-34']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			;
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_All_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Life Cycle: Respondent 35-49']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			;
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Count_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='treeview_tv_active']/div/span[1]")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='treeview_tv_active']/ul/li[1]/div/span")).click();
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='countPopUp']/div/table/tbody/tr[1]/td[1]/span/span/span[1]"))
					.click();
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='ddlCount_listbox']/li[2]")).click();
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='dvTxtCountValue']//span//span//input[2]"))
					.sendKeys(P1);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCountPopOK']")).click();
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_OR_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Actions action = new Actions(GenericMethods.driver);
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[2]/div/span"))).build()
					.perform();
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAddSelectedCode']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[3]/div/span"))).build()
					.perform();
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_AND_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Actions action = new Actions(GenericMethods.driver);
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[4]/div/span"))).build()
					.perform();
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAddSelectedCode']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[5]/div/span"))).build()
					.perform();
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_NOT_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Actions action = new Actions(GenericMethods.driver);
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='treeview']/ul/li[7]/ul/li[1]/ul/li[11]/div/span[1]")).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[4]/div/span"))).build()
					.perform();
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAddSelectedCode']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAnd']")).click();
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[6]/div/span"))).build()
					.perform();
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_VAUD_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {
			WebElement element = GenericMethods.driver.findElement(By.xpath(".//*[@id='ascrail2001']/div"));
			((JavascriptExecutor) GenericMethods.driver).executeScript("arguments[0].scrollIntoView();", element);
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Actions action = new Actions(GenericMethods.driver);
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='treeview']/ul/li[7]/ul/li[1]/ul/li[11]/div/span[1]")).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[3]/div/span"))).build()
					.perform();
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAddSelectedCode']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[5]/div/span"))).build()
					.perform();
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_VIND_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {
			// WebElement element =
			// GenericMethods.driver.findElement(By.xpath("//*[@id='btnVind']"));
			// ((JavascriptExecutor)
			// GenericMethods.driver).executeScript("arguments[0].scrollIntoView();",
			// element);
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Actions action = new Actions(GenericMethods.driver);
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='treeview']/ul/li[7]/ul/li[1]/ul/li[11]/div/span[1]")).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[2]/div/span"))).build()
					.perform();
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAddSelectedCode']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[3]/div/span"))).build()
					.perform();
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_VMUL_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			WebElement element = GenericMethods.driver.findElement(By.xpath("//*[@id='btnVaud']"));
			((JavascriptExecutor) GenericMethods.driver).executeScript("arguments[0].scrollIntoView();", element);
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Actions action = new Actions(GenericMethods.driver);
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[1]/div/span"))).build()
					.perform();
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAddSelectedCode']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[4]/div/span"))).build()
					.perform();
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);

			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_SUM_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Presence of Children by Age']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Multiply_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5,
			String P6, String obj) throws InterruptedException {
		try {
			// String currentColCount =
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[6]/td[5]")).getText().toString();
			// System.out.println(currentColCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Presence of Children by Age']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(500);
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='inputPopUp']/div/table/tbody/tr[1]/td[2]/span/span/input[2]"))
					.sendKeys(P1);
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnEntNumPopOK']")).click();
			String lastRowsCcount = GenericMethods.driver
					.findElement(By.xpath("//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[2]/td[5]/div")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(lastRowsCcount);
			if (lastRowsCcount.indexOf("*") != -1) {
				System.out.println("pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_MMEANZ_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			WebElement element = GenericMethods.driver.findElement(By.xpath(".//*[@id='ascrail2001']/div"));
			((JavascriptExecutor) GenericMethods.driver).executeScript("arguments[0].scrollIntoView();", element);
			// String currentColCount =
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[6]/td[5]")).getText().toString();
			// System.out.println(currentColCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()=' Married, youngest 12-17']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver
					.findElement(By.xpath("//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[2]/td[5]/div")).getText()
					.toString();
			Thread.sleep(1000);
			// *[@id="grid1"]/div[2]/div[1]/table/tbody/tr[1]/td[5]/div
			// *[@id="grid1"]/div[2]/div[1]/table/tbody/tr[1]/td[5]/div
			// *[@id="grid1"]/div[2]/div[1]/table/tbody/tr[2]/td[5]/div
			System.out.println(lastRowsCcount);
			if (lastRowsCcount.indexOf("MEANZ") != -1) {
				System.out.println("pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_MEAN_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			// String currentColCount =
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[6]/td[5]")).getText().toString();
			// System.out.println(currentColCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()=' Married, youngest 12-17']")).click();
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[2]/td[5]")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(lastRowsCcount);
			Thread.sleep(1000);
			if (lastRowsCcount.indexOf("MEAN") != -1) {
				System.out.println("pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_MEDIAN_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			// String currentColCount =
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[6]/td[5]")).getText().toString();
			// System.out.println(currentColCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Length of Residence at Present Address']"))
					.click();
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(1000);
			String lastRowsCcount = GenericMethods.driver
					.findElement(By.xpath("//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[2]/td[5]/div")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(lastRowsCcount);
			if (lastRowsCcount.indexOf("MEDIAN") != -1) {
				System.out.println("pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Solus_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			// String currentColCount =
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[6]/td[5]")).getText().toString();
			// System.out.println(currentColCount);
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath("//span[text()='Length of Residence at Present Address']"))
					.click();
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(1000);
			String lastRowsCcount = GenericMethods.driver
					.findElement(By.xpath("//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[2]/td[5]/div")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(lastRowsCcount);
			if (lastRowsCcount.indexOf("SOLUS") != -1) {
				System.out.println("pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String Click_Vdiv_CodingGridAddCol(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		// GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
		try {

			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			Actions action = new Actions(GenericMethods.driver);
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[1]/div/span"))).build()
					.perform();
			// GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAddSelectedCode']")).click();
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(2000);
			action.doubleClick(GenericMethods.driver
					.findElement(By.xpath("//*[@id='treeview']/ul/li[1]/ul/li[1]/ul/li[17]/ul/li[4]/div/span"))).build()
					.perform();
			String lastRowsCcount = GenericMethods.driver
					.findElement(By.xpath("//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[2]/td[5]/div")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(lastRowsCcount);
			if (lastRowsCcount.indexOf("VDIV") != -1) {
				System.out.println("pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}
	}

	public static String ContextMenuForInserBlankRowCodingGrid(String P1, String P2, String P3, String P4, String P5,
			String P6, String obj) throws InterruptedException {
		try {
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);

			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));
			insertBlankRow.click();
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String MultipleInsertBlankRow_CodingGrid(String P1, String P2, String P3, String P4, String P5,
			String P6, String obj) throws InterruptedException {
		try {
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);

			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));
			insertBlankRow.click();
			Thread.sleep(1000);
			GenericMethods.driver
					.findElement(
							By.xpath(".//*[@id='insertBlankRowPopUp']/div/table/tbody/tr[1]/td[2]/span/span/input[2]"))
					.sendKeys("2");
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRowCountOK']")).click();
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(lastRowsCcount);
			if (currentRowsCount.equals(lastRowsCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String InsertSepratorBlankRow_CodingGrid(String P1, String P2, String P3, String P4, String P5,
			String P6, String obj) throws InterruptedException {
		try {
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);

			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));
			insertBlankRow.click();
			String lastColCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(lastColCcount);
			if (currentRowsCount.equals(lastColCcount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String SwapRowsAndColumns_CodingGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='spnRowCount']/text()"))
					.getText().toString();
			System.out.println(currentRowsCount);
			String currentColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='spnColCount']/text()"))
					.getText().toString();
			System.out.println(currentColCount);
			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));
			insertBlankRow.click();
			Thread.sleep(2000);
			String lastRowsCcount = GenericMethods.driver.findElement(By.xpath(".//*[@id='spnRowCount']/text()"))
					.getText().toString();
			Thread.sleep(1000);
			System.out.println(lastRowsCcount);
			String lastColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='spnColCount']/text()"))
					.getText().toString();
			if (currentRowsCount.equals(lastColCount)) {
				System.out.println("pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String SeparateCount_CodingGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));
			insertBlankRow.click();
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='sepCount']/span")).click();
			Thread.sleep(1000);
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='countPopUp']/div/table/tbody/tr[1]/td[1]/span/span/span[2]/span"))
					.click();
			GenericMethods.driver.findElement(By.xpath(".//*[@id='ddlCount_listbox']/li[2]")).click();
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='dvTxtCountValue']//span//span//input[2]"))
					.sendKeys(P1);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCountPopOK']")).click();
			Thread.sleep(2000);
			String countValue = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(countValue);
			if (countValue.indexOf(">") != -1) {
				System.out.println("pass");
				// System.out.println(obj);
				// return 0;
				return "pass";

			} else {
				System.out.println("fail");
				return "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String Combine_CodingGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));
			insertBlankRow.click();
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='combineAny']/span")).click();
			String lastRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(lastRowsCount);
			if (currentRowsCount.equals(lastRowsCount)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String SaveOwnCodes_CodingGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			Date dt = new Date();
			System.out.println(dt);
			String dateVar = dt.toString().replace(" ", "").replace(":", "");
			dateVar = dateVar.replace(":", "");
			Thread.sleep(2000);
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));// Click
																							// on
																							// Save
																							// own
																							// Codes
																							// Items
																							// link
			insertBlankRow.click();
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='txtOwnCodeFileName']"))
					.sendKeys("MRICode_CodingGrid" + dateVar);
			Thread.sleep(200);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='chkAllTables']")).click();
			GenericMethods.driver.findElement(By.xpath(".//*[@id='chkAllColumns']")).click();
			GenericMethods.driver.findElement(By.xpath(".//*[@id='chkAllRows']")).click();
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnOK']")).click();
			String successFilesName = GenericMethods.driver
					.findElement(By.xpath(".//*[@class='bootstrap-dialog-title']")).getText().toString();
			Thread.sleep(1000);
			System.out.println(successFilesName);
			// Thread.sleep(2000);

			if (successFilesName.equals("File Alert")) {
				Thread.sleep(5000);
				GenericMethods.driver.findElement(By.xpath("//div[@role='dialog']/div/div/div[3]/div/div/button[1]"))
						.click();
				Thread.sleep(2000);
				GenericMethods.driver.findElement(By.xpath("//div[@role='dialog']/div/div/div[3]/div/div/button[1]"))
						.click();
				System.out.println("File save Succesfully");
				return "pass";
			} else if (successFilesName.equals("SurveyTime")) {
				Thread.sleep(500);
				GenericMethods.driver.findElement(By.xpath("//div[@role='dialog']/div/div/div[3]/div/div/button[1]"))
						.click();
				System.out.println("Successfully Saved");
				return "pass";
			} else
				Thread.sleep(500);
			System.out.println("Own codes failed");
			return "fail";

		} catch (Exception e) {
			System.out.println(e);
			return "fail";
		}

	}

	public static String CopyAndPasteRowsAndColumns_CodingGrid(String P1, String P2, String P3, String P4, String P5,
			String P6, String obj) throws InterruptedException {
		try {
			String currentRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			System.out.println(currentRowsCount);
			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			System.out.println(elementright);
			Thread.sleep(500);
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));
			insertBlankRow.click();
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCol']")).click();
			Thread.sleep(1000);
			String CurrentColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCol']")).getText()
					.toString();
			WebElement elementright1 = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			System.out.println(elementright1);
			Actions action1 = new Actions(GenericMethods.driver).contextClick(elementright1);
			action1.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow1 = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='pasteSelectedRow']/span"));
			insertBlankRow1.click();
			Thread.sleep(2000);
			String lastColCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnCol']")).getText()
					.toString();
			Thread.sleep(1000);
			System.out.println(lastColCount);
			if (CurrentColCount.equals(lastColCount)) {
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
			return "fail";

		}

	}

	public static String ShowGroupName_CodingGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			Thread.sleep(1000);
			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[2]/div[1]/table/tbody/tr[1]/td[5]/div"));
			System.out.println(elementright);
			Thread.sleep(500);
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver.findElement(By.xpath(obj));
			insertBlankRow.click();
			String groupName = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='grid1']/div[1]/div/table/thead/tr/th[9]")).getText().toString();
			Thread.sleep(1000);
			if (groupName.equals("GroupName")) {
				System.out.println("Hello GroupName " + groupName);
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("Fail");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String UserPreferences_CodingGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			String currentVisualcode = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='VCBMainContiner']/div[1]/table/tbody/tr/td[1]")).getText()
					.toString();
			System.out.println(currentVisualcode);
			GenericMethods.driver.findElement(By.xpath(obj)).click();// Select
																		// User
																		// Preferences
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='userPreferencesOptions-1']/table[1]/tr[7]/td[2]/input")).click();// Select
																														// Show
																														// %
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='userPreferencesOptions-1']/table[1]/tr[11]/td[2]/select")).click();// Select
																														// Short
																														// title
			GenericMethods.driver
					.findElement(
							By.xpath(".//*[@id='userPreferencesOptions-1']/table[1]/tr[11]/td[2]/select/option[2]"))
					.click();
			Thread.sleep(200);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions']/ul/li[2]/span[2]")).click();// Select
																														// Chart
																														// menu
			Thread.sleep(200);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[3]/tr/td[2]/select"))
					.click();// Select trend chart
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[3]/tr/td[2]/select/option[2]"))
					.click();
			Thread.sleep(200);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions-2']/table[3]/tr/td[5]/input"))
					.click();// Select Show chart data label
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions']/ul/li[3]/span[2]")).click();// Select
																														// ClassicalCode
																														// menu
			Thread.sleep(500);
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='userPreferencesOptions-3']/table[1]/tr[3]/td[2]/input")).click();// Select
																														// Visual
																														// code
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions']/ul/li[4]/span[2]")).click();// Select
																														// AutoGraphics
																														// Menu
			Thread.sleep(1000);
			WebElement elementright = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='autoGrafixPanelGrid']/div[2]/table/tbody/tr[4]/td[1]"));
			System.out.println(elementright);
			Thread.sleep(500);
			Actions action = new Actions(GenericMethods.driver).contextClick(elementright);
			action.build().perform();
			Thread.sleep(500);
			WebElement insertBlankRow = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='panelGridContextMenu']/li/span"));
			insertBlankRow.click();
			String lastRowsCount = GenericMethods.driver.findElement(By.xpath(".//*[@id='btnRow']")).getText()
					.toString();
			Thread.sleep(1000);
			Date dt = new Date();
			String dateVar = dt.toString().replace(" ", "").replace(":", "");
			dateVar = dateVar.replace(":", "");
			GenericMethods.driver.findElement(By.xpath(".//*[@id='txtPanelName']")).sendKeys("Ritesh_Panal_" + dateVar);
			GenericMethods.driver
					.findElement(By.xpath(".//*[@id='allGroupsCharts']/div/div/div/table/tbody/tr[5]/td/div/button[1]"))
					.click();
			Thread.sleep(2000);
			// WebDriverWait wait = new WebDriverWait(GenericMethods.driver,
			// 100);
			// WebElement element=
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='modal
			// bootstrap-dialog messageBoxContent type-info fade size-small
			// in']/div/div/div[3]/div/div/button")));
			// element.click();
			GenericMethods.driver
					.findElement(By
							.xpath(".//div[@class='modal bootstrap-dialog messageBoxContent type-info fade size-small in']/div/div/div[3]/div/div/button"))
					.click();// click on save successfully popup
			Thread.sleep(2000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='userPreferencesOptions']/span/input[1]")).click();// Click
																													// on
																													// Apply
																													// button
			Thread.sleep(2000);
			GenericMethods.driver
					.findElement(By
							.xpath(".//div[@class='modal bootstrap-dialog messageBoxContent type-info fade size-small in']/div/div/div[3]/div/div/button"))
					.click();
			System.out.println(lastRowsCount);
			String lastVisualcode = GenericMethods.driver
					.findElement(By.xpath(".//*[@id='VCBMainContiner']/div[1]/table/tbody/tr/td[1]")).getText()
					.toString();
			System.out.println(lastVisualcode);
			if (currentVisualcode.equals(lastVisualcode)) {
				System.out.println("fail");
				// System.out.println(obj);
				// return 0;
				return "fail";

			} else {
				System.out.println("pass");
				return "pass";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "fail";

		}

	}

	public static String SaveRun_CodingGrid(String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws InterruptedException {
		try {
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='fileMenuTab']")).click();
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath(obj)).click();
			Thread.sleep(500);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='fileMenu']/li/ul[1]/li[3]/div/a[2]")).click();
			Thread.sleep(500);
			Date dt = new Date();
			String dateVar = dt.toString().replace(" ", "").replace(":", "");
			dateVar = dateVar.replace(":", "");
			GenericMethods.driver.findElement(By.xpath(".//*[@id='txtFileName']")).sendKeys("Ritesh_Panal_" + dateVar);
			GenericMethods.driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
			Thread.sleep(500);
			String successFilesName = GenericMethods.driver
					.findElement(By.xpath(".//*[@class='bootstrap-dialog-title']")).getText().toString();
			System.out.println(successFilesName);
			if (successFilesName.equals("SurveyTime")) {
				Thread.sleep(5000);
				GenericMethods.driver
						.findElement(By
								.xpath(".//div[@class='modal bootstrap-dialog messageBoxContent type-info fade size-small in']/div/div/div[3]/div/div/button"))
						.click();
				Thread.sleep(500);
				System.out.println("File save Succesfully");
				return "pass";
			} else
				Thread.sleep(500);
			System.out.println("Save Runfailed");
			return "fail";

		} catch (Exception e) {
			System.out.println(e);
			return "Fail";
		}

	}
}
