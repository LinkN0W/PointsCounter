package org.example.excel;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ExcelExport {


    private final XSSFWorkbook wb;
    private final XSSFSheet sheet;


    public ExcelExport() {
        this.wb = new XSSFWorkbook();
        this.sheet = wb.createSheet();

    }


    public String exportData(List<ExcelMassive> rows){

        int rowNum = 0;
        String excelPath = null;
        for(ExcelMassive row : rows) createRow(rowNum++, row);
        try {
            excelPath = writeWorkbook();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return excelPath;
    }



    private void createRow(int index, ExcelMassive rowMassive) {
        XSSFRow row = sheet.createRow(index);
        int i = 0;

        for(String element : rowMassive.getRowsCells())
            setCellValue(row.createCell(i++), element);

    }

    private void setCellValue(XSSFCell cell, String value) {
        cell.setCellValue(value);
    }

    private String writeWorkbook() throws IOException {
        String file = Instant.now().getEpochSecond() + ".xlsx";
        FileOutputStream fileOut = new FileOutputStream(file);
        wb.write(fileOut);
        fileOut.close();
        return file;
    }


}
