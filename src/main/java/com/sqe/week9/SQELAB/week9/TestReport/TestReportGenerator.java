package com.sqe.week9.SQELAB.week9.TestReport;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestReportGenerator {

    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test Report");

        // Header Row
        Row headerRow = sheet.createRow(0);
        String[] columns = {"Test Case ID", "Description", "Input", "Expected", "Actual", "Status", "Remarks"};
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Test Case Data
        Object[][] testData = {
                {"TC001", "Verify login feature", "valid user", "Login successful", "Login successful", "Pass", "-"},
                {"TC002", "Verify invalid login", "wrong user", "Error message displayed", "Error message displayed", "Pass", "-"},
                {"TC003", "Verify search feature", "test query", "Relevant results shown", "Timeout error occurred", "Fail", "Defect #101"}
        };

        int rowNum = 1;
        for (Object[] testCase : testData) {
            Row row = sheet.createRow(rowNum++);
            for (int colNum = 0; colNum < testCase.length; colNum++) {
                row.createCell(colNum).setCellValue(testCase[colNum].toString());
            }
        }

        // Resize columns
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write to file
        try (FileOutputStream fileOut = new FileOutputStream("TestReport.xlsx")) {
            workbook.write(fileOut);
        }

        workbook.close();
        System.out.println("Test report generated: TestReport.xlsx");
    }
}

