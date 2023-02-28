package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    public static List<Object[]> getAllData(String filePath, String sheetName) throws IOException {
        List<Object[]> data = new ArrayList<>();
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();
        int rowCount = sheet.getLastRowNum();
        
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            int colCount = row.getLastCellNum();
            Object[] rowData = new Object[colCount];
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                String value = formatter.formatCellValue(cell);
                rowData[j] = value;
            }
            data.add(rowData);
        }
        workbook.close();
        inputStream.close();
        return data;
    }
    
    public List<String> getColumnData(String filePath, String sheetName, String columnName) throws IOException {
        List<String> columnData = new ArrayList<>();
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.iterator();
        int columnIndex = -1;
        
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (columnIndex == -1) {
                // Find the column index of the specified column name
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getStringCellValue().equals(columnName)) {
                        columnIndex = cell.getColumnIndex();
                        break;
                    }
                }
            } else {
                // Get the value of the cell in the specified column
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    switch (cell.getCellType()) {
                    case STRING:
                        columnData.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        columnData.add(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case BOOLEAN:
                        columnData.add(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    default:
                        columnData.add("");
                        break;
                    }
                } else {
                    columnData.add("");
                }
            }
        }
        workbook.close();
        inputStream.close();
        return columnData;
    }
}