package Common_Api_Method;

import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common_Utility_Method {
	
	
	  public static void EvidenceFileCreator(String Filename, String requestBody,
	 String responseBody, int statusCode) throws IOException {
	 
	 File NewText = new
	 File("D:\\Software testing class\\RestAssured\\" +Filename+ ".txt");
	 System.out.println("New blank file created :" + NewText.getName());
     FileWriter Data = new FileWriter(NewText);
	 Data.write("Request Body is :" + requestBody + "\n\n");
	 Data.write("Status Code is :" + statusCode + "\n\n");
	 Data.write("Response Body is :" + responseBody);
	 Data.close();
	 System.out.println("Data Written in this file :" + NewText.getName());
	 }

	public static ArrayList<String> ReadDataExcel(String sheetname, String testCases) throws IOException {
		ArrayList<String> ArrayData = new ArrayList<String>();

		// Step 1: Create the object of file Input stream to locate the excel file

		FileInputStream Fis = new FileInputStream("D:\\RestAssured\\data.xlsx");

		// Step 2: Open the excel file XSSFWorkBook

		XSSFWorkbook workbook = new XSSFWorkbook(Fis);

		// Step 3: Open the desired Sheet
		int CountofSheet = workbook.getNumberOfSheets();

		for (int i = 0; i < CountofSheet; i++) {
			String Sheetname = workbook.getSheetName(i);

			// Step 4: Access the desired sheet
			if (Sheetname.equalsIgnoreCase(sheetname)) {
				// Step 5: use XSSFsheet to save the sheet into a variable

				XSSFSheet sheet = workbook.getSheetAt(i);

				// Create iterator through rows and find out in which column the test case names
				// are found

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();

				// Create the iterator to iterate through cells of 1st row to find out which
				// cell contain test case name
				Iterator<Cell> CellsOfFirstRow = firstRow.cellIterator();

				int j = 0;

				int tc_Column = 0;

				while (CellsOfFirstRow.hasNext()) {
					Cell cellValue = CellsOfFirstRow.next();

					if (cellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						tc_Column = j;

						// System.out.println("expected column for test case name: " + j);
						break;

					}

					j++;
				}

				// Verify the row where the desired test case is found and fetch the entire row
				while (rows.hasNext()) {
					Row DataRow = rows.next();

					String TCName = DataRow.getCell(tc_Column).getStringCellValue();

					if (TCName.equalsIgnoreCase(testCases)) {
						Iterator<Cell> cellValues = DataRow.cellIterator();

						while (cellValues.hasNext()) {
							// String Data = CellValues.next().getStringCellValue();
							// ArrayData.add(Data);

							String Data = "";
							Cell CurrentCell = cellValues.next();

							try {
								String StringData = CurrentCell.getStringCellValue();
								Data = StringData;

							} catch (IllegalStateException e) {
								double doubledata = CurrentCell.getNumericCellValue();

								Data = Double.toString(doubledata);
							}

							ArrayData.add(Data);

						}
						break;
					}
				}

			}

		}

		return ArrayData;

	}

}



