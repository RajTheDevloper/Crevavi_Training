/**
 * The ReadExcelFile class demonstrates how to read data from an Excel file
 * using Apache POI in Java. It opens a workbook, selects a sheet, and iterates
 * through rows and cells to print their contents.
 *
 * This example illustrates basic Excel file reading operations and exception handling.
 */
package fileOperations;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A simple program to read text from "SampleData.xlsx" using Apache POI.
 */
public class ReadExcelFile {

    /**
     * The main method is the entry point of the program.
     * It reads the third sheet (index 2) of "SampleData.xlsx"
     * and prints each cell value to the console.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Use try-with-resources to ensure FileInputStream and Workbook are closed automatically
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\git\\Crevavi_Training\\files\\SampleData.xlsx");
        //for xlsx(2007+) file will use XSSFWorkbook and for xls(-2003) file will use HSSFWorkbook
             Workbook wb = new XSSFWorkbook(fis)) {

            // Get the third sheet (index starts at 0, so 2 = third sheet)
            Sheet sheet = wb.getSheetAt(0);

            // Loop through each row in the sheet
            for (Row row : sheet) {
                // Loop through each cell in the current row
                for (Cell cell : row) {
                    // Print the cell value as a string, followed by a tab
                    System.out.print(cell.toString() + "\t");
                }
                // Move to the next line after finishing a row
                System.out.println();
            }

        } catch (Exception e) {
            // Handle any exceptions (e.g., file not found, IO errors, invalid sheet index)
            System.out.println(e.getMessage());
            e.printStackTrace(); // Print detailed error information
        }
    }
}
