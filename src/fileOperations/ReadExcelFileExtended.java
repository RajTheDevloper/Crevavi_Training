/**
 * The ReadExcelFile class demonstrates how to read data from an Excel file
 * using Apache POI in Java. It detects the type of each cell (string, numeric,
 * boolean, date, or formula) and prints the value accordingly.
 */
package fileOperations;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileExtended {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\git\\Crevavi_Training\\files\\SampleData.xlsx");
             Workbook wb = new XSSFWorkbook(fis)) {

            // Get the third sheet (index 2)
            Sheet sheet = wb.getSheetAt(1);

            // Loop through each row
            for (Row row : sheet) {
                // Loop through each cell in the row
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                // Format date values
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                System.out.print(sdf.format(cell.getDateCellValue()) + "\t");
                            } else {
                                // Print numeric values
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case FORMULA:
                            // Evaluate formula result
                            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                            CellValue cellValue = evaluator.evaluate(cell);
                            System.out.print(cellValue.formatAsString() + "\t");
                            break;
                        case BLANK:
                            System.out.print("[BLANK]\t");
                            break;
                        default:
                            System.out.print("[UNKNOWN TYPE]\t");
                    }
                }
                System.out.println(); // Move to next line after each row
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
