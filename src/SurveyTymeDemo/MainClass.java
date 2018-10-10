package SurveyTymeDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class MainClass {
	public static String kw = "", P1 = "", P2 = "", P3 = "", P4 = "", P5 = "", P6 = "", obj = "", TCResult = "Pass";
	public static String result = "";
	public static String colresult = "";
	public static String Tableresult = "";
	public static String totalFilter = "";
	public static String unSort = "";
	public static String highLight = "";
	public static String cleared = "";
	public static String highlightClour = "";
	public static String combinedSorting = "";
	public static String combinedunSort = "";
	public static String combinedHighlightRulesForCustom = "", combinedHighlightRulesForGradient = "",
			CountAutoUnderCodingGrid = "", clickVAUDUnderCodingGrid = "", clickVMULUnderCodingGrid = "",
			clickMEANZUnderCodingGrid = "", clickMEANUnderCodingGrid = "", clickMEDIANUnderCodingGrid = "",
			combinedHighlightRulesForClearGradient = "", SwapVapue = "", HighLightsCustomHome = "", toTalDataItems = "",
			clickVINDUnderCodingGrid = "", clickSUMUnderCodingGrid = "", clickMultyplyUnderCodingGrid = "",
			clickSolusUnderCodingGrid = "", clickVDivUnderCodingGrid = "", clickSwapRowsAndColCodingGrid = "",
			toTalDataItemsNumber = "", saveOwnCodes = "", UndoRedoTotalColumnCount = "",
			dragAndDropColUnderCodingGrid = "", dragAndDropRowlUnderCodingGrid = "",
			dragAndDropTablelUnderCodingGrid = "", CountTableUnderCodingGrid = "", CountColumnsUnderCodingGrid = "",
			CountRowsUnderCodingGrid = "", clickAddSelectedCodeUnderCodingGrid = "", clickCopyAndPasteCodingGrid = "",
			clickExportExcelChartsGrid = "", clickDataItemsChartsGrid = "", clickPowerPointChartChartsGrid = "",
			clickExportChartChartsGrid = "", clickExportImageChartsGrid = "", clickSeprateCountCodingGrid = "",
			clickTitleModeChartsGrid = "", clickChartsPreferencesChartsGrid = "", clickSaveRunCodingGrid = "",
			clickUserPreferencesCodingGrid = "", clickCombineCountCodingGrid = "", clickShowGroupNameCodingGrid = "",
			clickSaveOwnCodesCountCodingGrid = "", clickAnyUnderCodingGrid = "", clickAllUnderCodingGrid = "",
			clickCountUnderCodingGrid = "", clickOrUnderCodingGrid = "", clickNOTUnderCodingGrid = "",
			clickAndUnderCodingGrid = "", clickInserBlankRowUnderCodingGrid = "",
			clickMultipleInserBlankRowCodingGrid = "", clickInsertSepratorRowCodingGrid = "";
	public static int etVar = 1;
	
/*	public static void main(String atr[]){
		String path1 = System.getProperty("user.dir");
		String path=path1+"\\DriverFile.xls";
		String path2=path1+"\\results";
		String path3=path1+"\\chromedriver.exe";
		System.out.println(path+"\n"+path2+"\n"+path3);
	}
*/
	public static void main(String[] args) throws BiffException, IOException, WriteException {
		// TODO Auto-generated method stub

		Date dt = new Date();
		System.out.println(dt);
		String dateVar = dt.toString().replace(" ", "").replace(":", "");
		dateVar = dateVar.replace(":", "");
		System.out.println(dateVar);
		String path1 = System.getProperty("user.dir");
		String path=path1+"\\DriverFile.xls";
		FileInputStream fs = new FileInputStream(path);
		Workbook wb = Workbook.getWorkbook(fs);
		WritableWorkbook wwb = Workbook
				.createWorkbook(new File(path1+"\\results"+"\\" + dateVar + ".xls"), wb);
		System.out.println(wwb);
		WritableSheet wws = wwb.getSheet("DriverSheet");
		int r = wws.getRows();
		System.out.println(r);
		for (int i = 1; i < r; i++) {
			String flagValue = wws.getCell(0, i).getContents();
			System.out.println(flagValue);
			if (flagValue.equals("Y")) {
				String shtName = wws.getCell(1, i).getContents();
				System.out.println(shtName);
				WritableSheet mnSht = wwb.getSheet(shtName);
				for (int ms = 1; ms < mnSht.getRows(); ms++) {
					try {
						kw = mnSht.getCell(0, ms).getContents();
						P1 = mnSht.getCell(1, ms).getContents();
						System.out.println(P1);
						P2 = mnSht.getCell(2, ms).getContents();
						P3 = mnSht.getCell(3, ms).getContents();
						P4 = mnSht.getCell(4, ms).getContents();
						P5 = mnSht.getCell(5, ms).getContents();
						P6 = mnSht.getCell(6, ms).getContents();
						obj = mnSht.getCell(7, ms).getContents();
						System.out.println("Row" + result);
						System.out.println("Col" + colresult);
						if (kw.equals("EndTestCase")) {
							if (TCResult.equals("Fail")) {
								Label lb1 = new Label(8, ms, "Fail");
								mnSht.addCell(lb1);

							}
							TCResult = "Pass";
						} 
						else if (result.equals("Fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, result + ":" + "Rows are not added successfully");
							mnSht.addCell(lb1);
							result = "";
						} else if (result.equals("Pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, result + ":" + "Rows are added successfully");
							mnSht.addCell(lb1);
							result = "";
						} else if (colresult.equals("Fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, colresult + ":" + "Cols are not added successfully");
							mnSht.addCell(lb1);
							colresult = "";
						} else if (colresult.equals("Pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, colresult + ":" + "Cols are added successfully");
							mnSht.addCell(lb1);
							colresult = "";
						} else if (Tableresult.equals("Fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, Tableresult + ":" + "Tables are not added successfully");
							mnSht.addCell(lb1);
							Tableresult = "";
						} else if (Tableresult.equals("Pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, Tableresult + ":" + "Tables are added successfully");
							mnSht.addCell(lb1);
							Tableresult = "";
						} else if (totalFilter.equals("Pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, totalFilter + ":" + "Sorting successfully");
							mnSht.addCell(lb1);
							totalFilter = "";
						} else if (totalFilter.equals("Fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, totalFilter + ":" + "Sorting not successfully");
							mnSht.addCell(lb1);
							totalFilter = "";
						} else if (unSort.equals("Pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, totalFilter + ":" + "Unsort successfully");
							mnSht.addCell(lb1);
							unSort = "";
						} else if (unSort.equals("Fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, totalFilter + ":" + "Unsort failed");
							mnSht.addCell(lb1);
							unSort = "";
						} else if (highLight.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, highLight + ":" + "HighLights Filter Pass");
							mnSht.addCell(lb1);
							highLight = "";
						} else if (highLight.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, highLight + ":" + "HighLights Filter Fail");
							mnSht.addCell(lb1);
							highLight = "";
						} else if (highlightClour.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, highlightClour + ":" + "HighLights Color Filter Pass");
							mnSht.addCell(lb1);
							highlightClour = "";
						} else if (highlightClour.equalsIgnoreCase("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, highlightClour + ":" + "HighLights Color Filter Fail");
							mnSht.addCell(lb1);
							highlightClour = "";
						} else if (cleared.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, cleared + ":" + "Cleared Highlits Filter Pass");
							mnSht.addCell(lb1);
							cleared = "";
						} else if (cleared.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, cleared + ":" + "Cleared Highlits Filter Fail");
							mnSht.addCell(lb1);
							cleared = "";
						} else if (combinedSorting.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, combinedSorting + ":" + "Pass sorting under Combined button");
							mnSht.addCell(lb1);
							combinedSorting = "";
						} else if (combinedSorting.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									combinedSorting + ":" + "Failed Sorting under Combined button Fail");
							mnSht.addCell(lb1);
							combinedSorting = "";
						} else if (combinedunSort.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, combinedunSort + ":" + "Pass Unsort under Combined button");
							mnSht.addCell(lb1);
							combinedunSort = "";
						} else if (combinedunSort.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									combinedunSort + ":" + "Faile UnSort under Combined button Fail");
							mnSht.addCell(lb1);
							combinedunSort = "";
						} else if (combinedHighlightRulesForCustom.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, combinedHighlightRulesForCustom + ":"
									+ "Pass HighLightRules under Combined button");
							mnSht.addCell(lb1);
							combinedHighlightRulesForCustom = "";
						} else if (combinedHighlightRulesForCustom.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, combinedHighlightRulesForCustom + ":"
									+ "Fail HighlightRules under Combined button Fail");
							mnSht.addCell(lb1);
							combinedHighlightRulesForCustom = "";
						} else if (combinedHighlightRulesForGradient.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, combinedHighlightRulesForGradient + ":"
									+ "Pass HighLightRules for Gradient under Combined button");
							mnSht.addCell(lb1);
							combinedHighlightRulesForGradient = "";
						} else if (combinedHighlightRulesForGradient.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, combinedHighlightRulesForGradient + ":"
									+ "Fail HighLightRules for Gradient under Combined button Fail");
							mnSht.addCell(lb1);
							combinedHighlightRulesForGradient = "";
						} else if (combinedHighlightRulesForClearGradient.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, combinedHighlightRulesForClearGradient + ":"
									+ "Pass HighLightRules cleared for Gradient under Combined button");
							mnSht.addCell(lb1);
							combinedHighlightRulesForClearGradient = "";
						} else if (combinedHighlightRulesForClearGradient.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, combinedHighlightRulesForClearGradient + ":"
									+ "Fail HighLightRules cleared for Gradient under Combined button Fail");
							mnSht.addCell(lb1);
							combinedHighlightRulesForClearGradient = "";
						} else if (SwapVapue.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, SwapVapue + ":" + "Pass Swap Value");
							mnSht.addCell(lb1);
							SwapVapue = "";
						} else if (SwapVapue.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, SwapVapue + ":" + "Fail Swap Value");
							mnSht.addCell(lb1);
							SwapVapue = "";
						} else if (HighLightsCustomHome.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									HighLightsCustomHome + ":" + "Pass HighLights Custom Home Value");
							mnSht.addCell(lb1);
							HighLightsCustomHome = "";
						} else if (HighLightsCustomHome.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									HighLightsCustomHome + ":" + "Fail HighLights Custom Home Value");
							mnSht.addCell(lb1);
							HighLightsCustomHome = "";
						} else if (toTalDataItems.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, toTalDataItems + ":" + "Pass Data ItemsHome Value");
							mnSht.addCell(lb1);
							toTalDataItems = "";
						} else if (toTalDataItems.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, toTalDataItems + ":" + "Fail Data Items Home Value");
							mnSht.addCell(lb1);
							toTalDataItems = "";
						} else if (toTalDataItemsNumber.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									toTalDataItemsNumber + ":" + "Pass Data Items NumberHome Value");
							mnSht.addCell(lb1);
							toTalDataItemsNumber = "";
						} else if (toTalDataItems.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									toTalDataItemsNumber + ":" + "Fail Data Items NumberHome Value");
							mnSht.addCell(lb1);
							toTalDataItemsNumber = "";
						} else if (saveOwnCodes.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									saveOwnCodes + ":" + "Pass Save Own Codes values under Home Page");
							mnSht.addCell(lb1);
							saveOwnCodes = "";
						} else if (saveOwnCodes.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									saveOwnCodes + ":" + "Fail Save Own Codes values under Home Page");
							mnSht.addCell(lb1);
							saveOwnCodes = "";
						} else if (UndoRedoTotalColumnCount.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, UndoRedoTotalColumnCount + ":" + "Pass Undo Column");
							mnSht.addCell(lb1);
							UndoRedoTotalColumnCount = "";
						} else if (UndoRedoTotalColumnCount.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, UndoRedoTotalColumnCount + ":" + "Fail Undo Column");
							mnSht.addCell(lb1);
							UndoRedoTotalColumnCount = "";
						} else if (dragAndDropColUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									dragAndDropColUnderCodingGrid + ":" + "Pass dragAndDropColUnderCodingGrid");
							mnSht.addCell(lb1);
							dragAndDropColUnderCodingGrid = "";
						} else if (dragAndDropColUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									dragAndDropColUnderCodingGrid + ":" + "Fail dragAndDropColUnderCodingGrid");
							mnSht.addCell(lb1);
							dragAndDropColUnderCodingGrid = "";
						} else if (dragAndDropRowlUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									dragAndDropRowlUnderCodingGrid + ":" + "Pass dragAndDropRowlUnderCodingGrid");
							mnSht.addCell(lb1);
							dragAndDropRowlUnderCodingGrid = "";
						} else if (dragAndDropRowlUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									dragAndDropRowlUnderCodingGrid + ":" + "Fail dragAndDropRowlUnderCodingGrid");
							mnSht.addCell(lb1);
							dragAndDropRowlUnderCodingGrid = "";
						} else if (dragAndDropTablelUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									dragAndDropTablelUnderCodingGrid + ":" + "Pass dragAndDropTablelUnderCodingGrid");
							mnSht.addCell(lb1);
							dragAndDropTablelUnderCodingGrid = "";
						} else if (dragAndDropTablelUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									dragAndDropTablelUnderCodingGrid + ":" + "Fail dragAndDropTablelUnderCodingGrid");
							mnSht.addCell(lb1);
							dragAndDropTablelUnderCodingGrid = "";
						} else if (CountTableUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									CountTableUnderCodingGrid + ":" + "Pass CountTableUnderCodingGrid");
							mnSht.addCell(lb1);
							CountTableUnderCodingGrid = "";
						} else if (CountTableUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									CountTableUnderCodingGrid + ":" + "Fail CountTableUnderCodingGrid");
							mnSht.addCell(lb1);
							CountTableUnderCodingGrid = "";
						} else if (CountColumnsUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									CountColumnsUnderCodingGrid + ":" + "Pass CountColumnsUnderCodingGrid");
							mnSht.addCell(lb1);
							CountColumnsUnderCodingGrid = "";
						} else if (CountColumnsUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									CountColumnsUnderCodingGrid + ":" + "Fail CountColumnsUnderCodingGrid");
							mnSht.addCell(lb1);
							CountColumnsUnderCodingGrid = "";
						} else if (CountRowsUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									CountRowsUnderCodingGrid + ":" + "Pass CountRowsUnderCodingGrid");
							mnSht.addCell(lb1);
							CountRowsUnderCodingGrid = "";
						} else if (CountRowsUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									CountRowsUnderCodingGrid + ":" + "Fail CountRowsUnderCodingGrid");
							mnSht.addCell(lb1);
							CountRowsUnderCodingGrid = "";
						} else if (CountAutoUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									CountAutoUnderCodingGrid + ":" + "Pass CountAutoUnderCodingGrid");
							mnSht.addCell(lb1);
							CountAutoUnderCodingGrid = "";
						} else if (CountAutoUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									CountAutoUnderCodingGrid + ":" + "Fail CountAutoUnderCodingGrid");
							mnSht.addCell(lb1);
							CountAutoUnderCodingGrid = "";
						} else if (clickAddSelectedCodeUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, clickAddSelectedCodeUnderCodingGrid + ":"
									+ "Pass clickAddSelectedCodeUnderCodingGrid");
							mnSht.addCell(lb1);
							clickAddSelectedCodeUnderCodingGrid = "";
						} else if (clickAddSelectedCodeUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, clickAddSelectedCodeUnderCodingGrid + ":"
									+ "Fail clickAddSelectedCodeUnderCodingGrid");
							mnSht.addCell(lb1);
							clickAddSelectedCodeUnderCodingGrid = "";
						} else if (clickAnyUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickAnyUnderCodingGrid + ":" + "Pass clickAnyUnderCodingGrid");
							mnSht.addCell(lb1);
							clickAnyUnderCodingGrid = "";
						} else if (clickAnyUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickAnyUnderCodingGrid + ":" + "Fail clickAnyUnderCodingGrid");
							mnSht.addCell(lb1);
							clickAnyUnderCodingGrid = "";
						} else if (clickAllUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickAllUnderCodingGrid + ":" + "Pass clickAllUnderCodingGrid");
							mnSht.addCell(lb1);
							clickAllUnderCodingGrid = "";
						} else if (clickAllUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickAllUnderCodingGrid + ":" + "Fail clickAllUnderCodingGrid");
							mnSht.addCell(lb1);
							clickAllUnderCodingGrid = "";
						} else if (clickCountUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickCountUnderCodingGrid + ":" + "Pass clickCountUnderCodingGrid");
							mnSht.addCell(lb1);
							clickCountUnderCodingGrid = "";
						} else if (clickCountUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickCountUnderCodingGrid + ":" + "Fail clickCountUnderCodingGrid");
							mnSht.addCell(lb1);
							clickCountUnderCodingGrid = "";
						} else if (clickOrUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, clickOrUnderCodingGrid + ":" + "Pass clickOrUnderCodingGrid");
							mnSht.addCell(lb1);
							clickOrUnderCodingGrid = "";
						} else if (clickOrUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, clickOrUnderCodingGrid + ":" + "Fail clickOrUnderCodingGrid");
							mnSht.addCell(lb1);
							clickOrUnderCodingGrid = "";
						} else if (clickAndUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickAndUnderCodingGrid + ":" + "Pass clickAndUnderCodingGrid");
							mnSht.addCell(lb1);
							clickAndUnderCodingGrid = "";
						} else if (clickAndUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickAndUnderCodingGrid + ":" + "Fail clickAndUnderCodingGrid");
							mnSht.addCell(lb1);
							clickAndUnderCodingGrid = "";
						} else if (clickNOTUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickNOTUnderCodingGrid + ":" + "Pass clickNOTUnderCodingGrid");
							mnSht.addCell(lb1);
							clickNOTUnderCodingGrid = "";
						} else if (clickAndUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickNOTUnderCodingGrid + ":" + "Fail clickNOTUnderCodingGrid");
							mnSht.addCell(lb1);
							clickNOTUnderCodingGrid = "";
						} else if (clickVINDUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickVINDUnderCodingGrid + ":" + "Pass clickVINDUnderCodingGrid");
							mnSht.addCell(lb1);
							clickVINDUnderCodingGrid = "";
						} else if (clickVINDUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickVINDUnderCodingGrid + ":" + "Fail clickVINDUnderCodingGrid");
							mnSht.addCell(lb1);
							clickVINDUnderCodingGrid = "";
						} else if (clickVAUDUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickVAUDUnderCodingGrid + ":" + "Pass clickVAUDUnderCodingGrid");
							mnSht.addCell(lb1);
							clickVAUDUnderCodingGrid = "";
						} else if (clickVINDUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickVAUDUnderCodingGrid + ":" + "Fail clickVAUDUnderCodingGrid");
							mnSht.addCell(lb1);
							clickVAUDUnderCodingGrid = "";
						} else if (clickVMULUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickVMULUnderCodingGrid + ":" + "Pass clickVMULUnderCodingGrid");
							mnSht.addCell(lb1);
							clickVMULUnderCodingGrid = "";
						} else if (clickVMULUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickVMULUnderCodingGrid + ":" + "Fail clickVMULUnderCodingGrid");
							mnSht.addCell(lb1);
							clickVMULUnderCodingGrid = "";
						} else if (clickSUMUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSUMUnderCodingGrid + ":" + "Pass clickSUMUnderCodingGrid");
							mnSht.addCell(lb1);
							clickSUMUnderCodingGrid = "";
						} else if (clickSUMUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSUMUnderCodingGrid + ":" + "Fail clickSUMUnderCodingGrid");
							mnSht.addCell(lb1);
							clickSUMUnderCodingGrid = "";
						} else if (clickMultyplyUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickMultyplyUnderCodingGrid + ":" + "Pass clickMultyplyUnderCodingGrid");
							mnSht.addCell(lb1);
							clickMultyplyUnderCodingGrid = "";
						} else if (clickMultyplyUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickMultyplyUnderCodingGrid + ":" + "Fail clickMultyplyUnderCodingGrid");
							mnSht.addCell(lb1);
							clickMultyplyUnderCodingGrid = "";
						} else if (clickMEANZUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickMEANZUnderCodingGrid + ":" + "Pass clickMEANZUnderCodingGrid");
							mnSht.addCell(lb1);
							clickMEANZUnderCodingGrid = "";
						} else if (clickMEANZUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickMEANZUnderCodingGrid + ":" + "Fail clickMEANZUnderCodingGrid");
							mnSht.addCell(lb1);
							clickMEANZUnderCodingGrid = "";
						} else if (clickMEANUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickMEANUnderCodingGrid + ":" + "Pass clickMEANUnderCodingGrid");
							mnSht.addCell(lb1);
							clickMEANUnderCodingGrid = "";
						} else if (clickMEANUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickMEANUnderCodingGrid + ":" + "Fail clickMEANUnderCodingGrid");
							mnSht.addCell(lb1);
							clickMEANUnderCodingGrid = "";
						} else if (clickMEDIANUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickMEDIANUnderCodingGrid + ":" + "Pass clickMEDIANUnderCodingGrid");
							mnSht.addCell(lb1);
							clickMEDIANUnderCodingGrid = "";
						} else if (clickMEDIANUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickMEDIANUnderCodingGrid + ":" + "Fail clickMEDIANUnderCodingGrid");
							mnSht.addCell(lb1);
							clickMEDIANUnderCodingGrid = "";
						} else if (clickSolusUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSolusUnderCodingGrid + ":" + "Pass clickSolusUnderCodingGrid");
							mnSht.addCell(lb1);
							clickSolusUnderCodingGrid = "";
						} else if (clickSolusUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSolusUnderCodingGrid + ":" + "Fail clickSolusUnderCodingGrid");
							mnSht.addCell(lb1);
							clickSolusUnderCodingGrid = "";
						} else if (clickVDivUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickVDivUnderCodingGrid + ":" + "Pass clickVDivUnderCodingGrid");
							mnSht.addCell(lb1);
							clickVDivUnderCodingGrid = "";
						} else if (clickVDivUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickVDivUnderCodingGrid + ":" + "Fail clickVDivUnderCodingGrid");
							mnSht.addCell(lb1);
							clickVDivUnderCodingGrid = "";
						} else if (clickInserBlankRowUnderCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickInserBlankRowUnderCodingGrid + ":" + "Pass clickInserBlankRowUnderCodingGrid");
							mnSht.addCell(lb1);
							clickInserBlankRowUnderCodingGrid = "";
						} else if (clickInserBlankRowUnderCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickInserBlankRowUnderCodingGrid + ":" + "Fail clickInserBlankRowUnderCodingGrid");
							mnSht.addCell(lb1);
							clickInserBlankRowUnderCodingGrid = "";
						} else if (clickMultipleInserBlankRowCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, clickMultipleInserBlankRowCodingGrid + ":"
									+ "Pass clickMultipleInserBlankRowCodingGrid");
							mnSht.addCell(lb1);
							clickMultipleInserBlankRowCodingGrid = "";
						} else if (clickMultipleInserBlankRowCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, clickMultipleInserBlankRowCodingGrid + ":"
									+ "Fail clickMultipleInserBlankRowCodingGrid");
							mnSht.addCell(lb1);
							clickMultipleInserBlankRowCodingGrid = "";
						} else if (clickInsertSepratorRowCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickInsertSepratorRowCodingGrid + ":" + "Pass clickInsertSepratorRowCodingGrid");
							mnSht.addCell(lb1);
							clickInsertSepratorRowCodingGrid = "";
						} else if (clickInsertSepratorRowCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickInsertSepratorRowCodingGrid + ":" + "Fail clickInsertSepratorRowCodingGrid");
							mnSht.addCell(lb1);
							clickInsertSepratorRowCodingGrid = "";
						} else if (clickSwapRowsAndColCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSwapRowsAndColCodingGrid + ":" + "Pass clickSwapRowsAndColCodingGrid");
							mnSht.addCell(lb1);
							clickSwapRowsAndColCodingGrid = "";
						} else if (clickSwapRowsAndColCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSwapRowsAndColCodingGrid + ":" + "Fail clickSwapRowsAndColCodingGrid");
							mnSht.addCell(lb1);
							clickSwapRowsAndColCodingGrid = "";
						} else if (clickSeprateCountCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSeprateCountCodingGrid + ":" + "Pass clickSeprateCountCodingGrid");
							mnSht.addCell(lb1);
							clickSeprateCountCodingGrid = "";
						} else if (clickSeprateCountCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSeprateCountCodingGrid + ":" + "Fail clickSeprateCountCodingGrid");
							mnSht.addCell(lb1);
							clickSeprateCountCodingGrid = "";
						} else if (clickCombineCountCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickCombineCountCodingGrid + ":" + "Pass clickCombineCountCodingGrid");
							mnSht.addCell(lb1);
							clickCombineCountCodingGrid = "";
						} else if (clickCombineCountCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickCombineCountCodingGrid + ":" + "Fail clickCombineCountCodingGrid");
							mnSht.addCell(lb1);
							clickCombineCountCodingGrid = "";
						} else if (clickSaveOwnCodesCountCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSaveOwnCodesCountCodingGrid + ":" + "Pass clickSaveOwnCodesCountCodingGrid");
							mnSht.addCell(lb1);
							clickSaveOwnCodesCountCodingGrid = "";
						} else if (clickSaveOwnCodesCountCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickSaveOwnCodesCountCodingGrid + ":" + "Fail clickSaveOwnCodesCountCodingGrid");
							mnSht.addCell(lb1);
							clickSaveOwnCodesCountCodingGrid = "";
						} else if (clickCopyAndPasteCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickCopyAndPasteCodingGrid + ":" + "Pass clickCopyAndPasteCodingGrid");
							mnSht.addCell(lb1);
							clickCopyAndPasteCodingGrid = "";
						} else if (clickCopyAndPasteCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickCopyAndPasteCodingGrid + ":" + "Fail clickCopyAndPasteCodingGrid");
							mnSht.addCell(lb1);
							clickCopyAndPasteCodingGrid = "";
						} else if (clickShowGroupNameCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickShowGroupNameCodingGrid + ":" + "Pass clickShowGroupNameCodingGrid");
							mnSht.addCell(lb1);
							clickShowGroupNameCodingGrid = "";
						} else if (clickShowGroupNameCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickShowGroupNameCodingGrid + ":" + "Fail clickShowGroupNameCodingGrid");
							mnSht.addCell(lb1);
							clickShowGroupNameCodingGrid = "";
						} else if (clickUserPreferencesCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickUserPreferencesCodingGrid + ":" + "Pass clickUserPreferencesCodingGrid");
							mnSht.addCell(lb1);
							clickUserPreferencesCodingGrid = "";
						} else if (clickUserPreferencesCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickUserPreferencesCodingGrid + ":" + "Fail clickUserPreferencesCodingGrid");
							mnSht.addCell(lb1);
							clickUserPreferencesCodingGrid = "";
						} else if (clickSaveRunCodingGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, clickSaveRunCodingGrid + ":" + "Pass clickSaveRunCodingGrid");
							mnSht.addCell(lb1);
							clickSaveRunCodingGrid = "";
						} else if (clickSaveRunCodingGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms, clickSaveRunCodingGrid + ":" + "Fail clickSaveRunCodingGrid");
							mnSht.addCell(lb1);
							clickSaveRunCodingGrid = "";
						} else if (clickChartsPreferencesChartsGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickChartsPreferencesChartsGrid + ":" + "Pass clickChartsPreferencesChartsGrid");
							mnSht.addCell(lb1);
							clickChartsPreferencesChartsGrid = "";
						} else if (clickChartsPreferencesChartsGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickChartsPreferencesChartsGrid + ":" + "Fail clickChartsPreferencesChartsGrid");
							mnSht.addCell(lb1);
							clickChartsPreferencesChartsGrid = "";
						} else if (clickTitleModeChartsGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickTitleModeChartsGrid + ":" + "Pass clickTitleModeChartsGrid");
							mnSht.addCell(lb1);
							clickTitleModeChartsGrid = "";
						} else if (clickTitleModeChartsGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickTitleModeChartsGrid + ":" + "Fail clickTitleModeChartsGrid");
							mnSht.addCell(lb1);
							clickTitleModeChartsGrid = "";

						} else if (clickDataItemsChartsGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickDataItemsChartsGrid + ":" + "Pass clickDataItemsChartsGrid");
							mnSht.addCell(lb1);
							clickDataItemsChartsGrid = "";
						} else if (clickDataItemsChartsGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickDataItemsChartsGrid + ":" + "Fail clickDataItemsChartsGrid");
							mnSht.addCell(lb1);
							clickDataItemsChartsGrid = "";
						} else if (clickExportExcelChartsGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickExportExcelChartsGrid + ":" + "Pass clickExportExcelChartsGrid");
							mnSht.addCell(lb1);
							clickExportExcelChartsGrid = "";
						} else if (clickExportExcelChartsGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickExportExcelChartsGrid + ":" + "Fail clickExportExcelChartsGrid");
							mnSht.addCell(lb1);
							clickExportExcelChartsGrid = "";
						} else if (clickExportImageChartsGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickExportImageChartsGrid + ":" + "Pass clickExportImageChartsGrid");
							mnSht.addCell(lb1);
							clickExportImageChartsGrid = "";
						} else if (clickExportImageChartsGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickExportImageChartsGrid + ":" + "Fail clickExportImageChartsGrid");
							mnSht.addCell(lb1);
							clickExportImageChartsGrid = "";
						} else if (clickExportChartChartsGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickExportChartChartsGrid + ":" + "Pass clickExportChartChartsGrid");
							mnSht.addCell(lb1);
							clickExportChartChartsGrid = "";
						} else if (clickExportChartChartsGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickExportChartChartsGrid + ":" + "Fail clickExportChartChartsGrid");
							mnSht.addCell(lb1);
							clickExportChartChartsGrid = "";
						} else if (clickPowerPointChartChartsGrid.equals("pass")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickPowerPointChartChartsGrid + ":" + "Pass clickPowerPointChartChartsGrid");
							mnSht.addCell(lb1);
							clickPowerPointChartChartsGrid = "";
						} else if (clickPowerPointChartChartsGrid.equals("fail")) {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb1 = new Label(9, ms,
									clickPowerPointChartChartsGrid + ":" + "Fail clickPowerPointChartChartsGrid");
							mnSht.addCell(lb1);
							clickPowerPointChartChartsGrid = "";
						} else {
							keyMethod(kw, P1, P2, P3, P4, P5, P6, obj);
							Label lb = new Label(8, ms, "Pass");
							mnSht.addCell(lb);
						}

					} catch (Exception e) {
						Label lb = new Label(8, ms, "Fail" + e.getMessage());
						TCResult = "Fail";
						mnSht.addCell(lb);
						System.out.println(e);
					}
				}
			}
		}

		wb.close();
		wwb.write();
		wwb.close();

	}

	public static void keyMethod(String kw, String P1, String P2, String P3, String P4, String P5, String P6,
			String obj) throws NumberFormatException, InterruptedException, FileNotFoundException {
		if (kw.equals("Launch")) {
			GenericMethods.appLaunch(P1, P2, P3, P4, P5, P6, obj);
			System.out.println(P1);

		} else if (kw.equals("setValue")) {
			GenericMethods.setValue(P1, P2, P3, P4, P5, P6, obj);
		} else if (kw.equals("Click")) {
			GenericMethods.Click(P1, P2, P3, P4, P5, P6, obj);
			System.out.println(obj);
			Thread.sleep(1000);
		} else if (kw.equals("DoubleClick")) {
			GenericMethods.DoubleClick(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("Double Click");
			Thread.sleep(1000);
		} /*else if (kw.equals("ClearAllColumns")) {
			GenericMethods.ContextMenuC(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("ContextMenuForClearColumns");
			Thread.sleep(1000);
		} else if (kw.equals("ContextMenuForRow")) {
			GenericMethods.ContextMenuForRow(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("ContextMenuForClearRows");
			Thread.sleep(1000);
		} else if (kw.equals("DeleteAllSeveralRows")) {
			GenericMethods.ContextMenuForRowDelSeveral(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("ContextMenuForDeleteAllRows");
			Thread.sleep(1000);
		}*/

		else if (kw.equals("dragAndDropRow")) {
			result = GenericMethods.dragAndDropAddRow(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(1000);
		} else if (kw.equals("dragAndDropCol")) {
			colresult = GenericMethods.dragAndDropAddCol(P1, P2, P3, P4, P5, P6, obj);
			System.out.print(colresult);
			Thread.sleep(5000);
		} else if (kw.equals("dragAndDropTable")) {
			Tableresult = GenericMethods.dragAndDropAddTable(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(5000);
		} else if (kw.equals("SepratedRank")) {
			totalFilter = GenericMethods.Seprated_Rank_Button(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("Seprated_Rank_Button");
			Thread.sleep(1000);
		} else if (kw.equals("SepratedRankSortUnsort")) {
			unSort = GenericMethods.Seprated_Rank_Button_Unsort(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("Seprated_Rank_Button");
			Thread.sleep(1000);
		} else if (kw.equals("HighlightRulesCustom")) {
			highLight = GenericMethods.Seprated_Rank_Highlight_HighLightRules_Custom(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("Highlight_HighLightRules");
			Thread.sleep(1000);
		} else if (kw.equals("HighLightRulesGradient")) {
			highlightClour = GenericMethods.Seprated_Rank_Highlight_HighLightRules_Gradient(P1, P2, P3, P4, P5, P6,
					obj);
			System.out.println("highlightClour");
			Thread.sleep(1000);
		} else if (kw.equals("HighLightRulesClears")) {
			cleared = GenericMethods.Seprated_Rank_Highlight_HighLightRules_Clears(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("HighLightRulesClears");
			Thread.sleep(1000);
		} else if (kw.equals("CombinedRank")) {
			combinedSorting = GenericMethods.Combined_Rank_Button(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("Combined Rank");
			Thread.sleep(1000);
		} else if (kw.equals("CombinedRankUnsort")) {
			combinedunSort = GenericMethods.Combined_Rank_Button_Unsort(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("UnSort Combined Rank");
			Thread.sleep(1000);
		} else if (kw.equals("HighLightButton")) {
			combinedHighlightRulesForCustom = GenericMethods.Combined_Rank_Highlight_HighLightRules_Custom(P1, P2, P3,
					P4, P5, P6, obj);
			System.out.println("Combined Rank - HighLights Rules");
			Thread.sleep(1000);
		} else if (kw.equals("HightlightRulesGradient")) {
			combinedHighlightRulesForGradient = GenericMethods.Combined_Rank_Highlight_HighLightRules_Gradient(P1, P2,
					P3, P4, P5, P6, obj);
			System.out.println("Combined Rank - HighLights Rules");
			Thread.sleep(1000);
		} else if (kw.equals("CombinedHightHighLightRulesClears")) {
			combinedHighlightRulesForClearGradient = GenericMethods.Combined_Rank_Highlight_HighLightRules_Clears(P1,
					P2, P3, P4, P5, P6, obj);
			System.out.println("Combined Rank - HighLights Rules");
			Thread.sleep(1000);
		} else if (kw.equals("SwapValue")) {
			SwapVapue = GenericMethods.swapFunction(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("Swap Value");
			Thread.sleep(1000);
		} else if (kw.equals("TitleMode")) {
			GenericMethods.TitleMode(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("Change Title Mode");
			Thread.sleep(1000);
		} else if (kw.equals("HightlightRulesCustomHome")) {
			HighLightsCustomHome = GenericMethods.HighlightsValueCustomHome(P1, P2, P3, P4, P5, P6, obj);
			System.out.println("Hightlight Rules Custom For Home");
			Thread.sleep(1000);
		} else if (kw.equals("DataItemsHome")) {
			toTalDataItems = GenericMethods.DataItemFromHome(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Data items For Home");
			Thread.sleep(1000);
		} else if (kw.equals("DataItemNumberFormatHome")) {
			toTalDataItemsNumber = GenericMethods.DataItemFromNumberFormatHome(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Data items Number For Home");
			Thread.sleep(1000);
		} else if (kw.equals("SaveOwnCodes")) {
			saveOwnCodes = GenericMethods.SaveOwnCodesForHome(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Save own Codes for home");
			Thread.sleep(1000);
		} else if (kw.equals("UndoRedoCrossTab")) {
			UndoRedoTotalColumnCount = GenericMethods.UndoRedoCrossTab(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Undo/Redo Column");
			Thread.sleep(1000);
		} else if (kw.equals("dragAndDropColUnderCodingGrid")) {
			dragAndDropColUnderCodingGrid = GenericCodingGrid.dragAndDropCodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(dragAndDropColUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("dragAndDropRowUnderCodingGrid")) {
			dragAndDropRowlUnderCodingGrid = GenericCodingGrid.dragAndDrop_Row_CodingGridAddCol(P1, P2, P3, P4, P5, P6,
					obj);
			Thread.sleep(200);
			System.out.println(dragAndDropColUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("dragAndDropTableUnderCodingGrid")) {
			dragAndDropTablelUnderCodingGrid = GenericCodingGrid.dragAndDrop_Table_CodingGridAddCol(P1, P2, P3, P4, P5,
					P6, obj);
			Thread.sleep(200);
			System.out.println(dragAndDropColUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickTableUnderCodingGrid")) {
			CountTableUnderCodingGrid = GenericCodingGrid.Click_Table_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(CountTableUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickColumnUnderCodingGrid")) {
			CountColumnsUnderCodingGrid = GenericCodingGrid.Click_Columns_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(CountColumnsUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickRowsUnderCodingGrid")) {
			CountRowsUnderCodingGrid = GenericCodingGrid.Click_Rows_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(CountRowsUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickAutoUnderCodingGrid")) {
			CountAutoUnderCodingGrid = GenericCodingGrid.Click_Auto_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(CountRowsUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickAddSelectedCodeUnderCodingGrid")) {
			clickAddSelectedCodeUnderCodingGrid = GenericCodingGrid.Click_Button_Add_Selected_CodingGridAddCol(P1, P2,
					P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(CountRowsUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickAnyUnderCodingGrid")) {
			clickAnyUnderCodingGrid = GenericCodingGrid.Click_Any_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickAnyUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickAllUnderCodingGrid")) {
			clickAllUnderCodingGrid = GenericCodingGrid.Click_All_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickAllUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickCountUnderCodingGrid")) {
			clickCountUnderCodingGrid = GenericCodingGrid.Click_Count_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickCountUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickOrUnderCodingGrid")) {
			clickOrUnderCodingGrid = GenericCodingGrid.Click_OR_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickOrUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickAndUnderCodingGrid")) {
			clickAndUnderCodingGrid = GenericCodingGrid.Click_AND_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickAndUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickNOTUnderCodingGrid")) {
			clickNOTUnderCodingGrid = GenericCodingGrid.Click_NOT_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickNOTUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickVINDUnderCodingGrid")) {
			clickVINDUnderCodingGrid = GenericCodingGrid.Click_VIND_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickVINDUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickVAUDUnderCodingGrid")) {
			clickVAUDUnderCodingGrid = GenericCodingGrid.Click_VAUD_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickVAUDUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickVMULUnderCodingGrid")) {
			clickVMULUnderCodingGrid = GenericCodingGrid.Click_VMUL_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickVMULUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickSUMUnderCodingGrid")) {
			clickSUMUnderCodingGrid = GenericCodingGrid.Click_SUM_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickSUMUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickMultyplyUnderCodingGrid")) {
			clickMultyplyUnderCodingGrid = GenericCodingGrid.Click_Multiply_CodingGridAddCol(P1, P2, P3, P4, P5, P6,
					obj);
			Thread.sleep(200);
			System.out.println(clickMultyplyUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickMEANZUnderCodingGrid")) {
			clickMEANZUnderCodingGrid = GenericCodingGrid.Click_MMEANZ_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickMEANZUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickMEANUnderCodingGrid")) {
			clickMEANUnderCodingGrid = GenericCodingGrid.Click_MEAN_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickMEANUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickMEDIANUnderCodingGrid")) {
			clickMEDIANUnderCodingGrid = GenericCodingGrid.Click_MEDIAN_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickMEDIANUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickSolusUnderCodingGrid")) {
			clickSolusUnderCodingGrid = GenericCodingGrid.Click_Solus_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickSolusUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickVDivUnderCodingGrid")) {
			clickVDivUnderCodingGrid = GenericCodingGrid.Click_Vdiv_CodingGridAddCol(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickVDivUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickInserBlankRowUnderCodingGrid")) {
			clickInserBlankRowUnderCodingGrid = GenericCodingGrid.ContextMenuForInserBlankRowCodingGrid(P1, P2, P3, P4,
					P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickInserBlankRowUnderCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickMultipleInserBlankRowCodingGrid")) {
			clickMultipleInserBlankRowCodingGrid = GenericCodingGrid.MultipleInsertBlankRow_CodingGrid(P1, P2, P3, P4,
					P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickMultipleInserBlankRowCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickInsertSepratorRowCodingGrid")) {
			clickInsertSepratorRowCodingGrid = GenericCodingGrid.InsertSepratorBlankRow_CodingGrid(P1, P2, P3, P4, P5,
					P6, obj);
			Thread.sleep(200);
			System.out.println(clickInsertSepratorRowCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickSwapRowsAndColCodingGrid")) {
			clickSwapRowsAndColCodingGrid = GenericCodingGrid.SwapRowsAndColumns_CodingGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickSwapRowsAndColCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickSeprateCountCodingGrid")) {
			clickSeprateCountCodingGrid = GenericCodingGrid.SeparateCount_CodingGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickSeprateCountCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickCombineCountCodingGrid")) {
			clickCombineCountCodingGrid = GenericCodingGrid.Combine_CodingGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickCombineCountCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickSaveOwnCodesCountCodingGrid")) {
			clickSaveOwnCodesCountCodingGrid = GenericCodingGrid.SaveOwnCodes_CodingGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickSaveOwnCodesCountCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickCopyAndPasteCodingGrid")) {
			clickCopyAndPasteCodingGrid = GenericCodingGrid.CopyAndPasteRowsAndColumns_CodingGrid(P1, P2, P3, P4, P5,
					P6, obj);
			Thread.sleep(200);
			System.out.println(clickCopyAndPasteCodingGrid);
			Thread.sleep(1000);
		}

		else if (kw.equals("clickShowGroupNameCodingGrid")) {
			clickShowGroupNameCodingGrid = GenericCodingGrid.ShowGroupName_CodingGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println(clickCombineCountCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickUserPreferencesCodingGrid")) {
			clickUserPreferencesCodingGrid = GenericCodingGrid.UserPreferences_CodingGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("clickUserPreferencesCodingGrid" + clickUserPreferencesCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickSaveRunCodingGrid")) {
			clickSaveRunCodingGrid = GenericCodingGrid.SaveRun_CodingGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Save Run" + clickSaveRunCodingGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickChartsPreferencesChartsGrid")) {
			clickChartsPreferencesChartsGrid = GenericCharts.ChartsPreferences_ChartsGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Chart Preferences" + clickChartsPreferencesChartsGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickTitleModeChartsGrid")) {
			clickTitleModeChartsGrid = GenericCharts.TitleMode_ChartGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Title Mode" + clickTitleModeChartsGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickTitleModeChartsGrid")) {
			clickTitleModeChartsGrid = GenericCharts.TitleMode_ChartGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Title Mode" + clickTitleModeChartsGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickDataItemsChartsGrid")) {
			clickDataItemsChartsGrid = GenericCharts.DataItem_ChartGrids(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Selevt Data Items from chart grid" + clickDataItemsChartsGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickExportImageChartsGrid")) {
			clickExportImageChartsGrid = GenericCharts.ExportImage_ChartGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Export Excel Import under Charts Grid" + clickExportImageChartsGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickExportChartChartsGrid")) {
			clickExportChartChartsGrid = GenericCharts.ExportChart_ChartGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Export Chart under Chart Grid" + clickExportChartChartsGrid);
			Thread.sleep(1000);
		} else if (kw.equals("clickPowerPointChartChartsGrid")) {
			clickPowerPointChartChartsGrid = GenericCharts.PowerPoint_ChartGrid(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(200);
			System.out.println("Export Power Point under Chart Grid" + clickPowerPointChartChartsGrid);
			Thread.sleep(1000);
		} else if (kw.equals("WaitForPageLoad")) {
			GenericMethods.WaitForPageLoad(P1, P2, P3, P4, P5, P6, obj);
			Thread.sleep(5000);
		} else if (kw.equals("Wait")) {
			GenericMethods.Wait(P1, P2, P3, P4, P5, P6, obj);

		} 

	}

}
