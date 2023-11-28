package org.example.excel;

import org.example.logger.entities.Logger;

import java.util.ArrayList;
import java.util.List;

public class LogMassiveCompiler implements ExcelMassiveCompiler{
    @Override
    public List<ExcelMassive> compileExcelMassive(List list) {
        Integer index = 0;
        List<ExcelMassive> excelMassiveData = new ArrayList<>();

        ExcelMassive titleExcelMassive = new ExcelMassive();
        titleExcelMassive.setRowsCells(
                new ArrayList<>(List.of(new String[]{"ID", "Start Time", "End Time", "Point A", "Point B", "Calculate Method" ,"Distance"})));

        excelMassiveData.add(titleExcelMassive);
        for (Logger log : (List<Logger>) list) {
            ExcelMassive excelMassive = new ExcelMassive();
            List<String> rowsCells = new ArrayList<>();
            rowsCells.add(index.toString());
            rowsCells.add(log.getLaunch().getTimeOfBegin().toString());
            rowsCells.add(log.getLaunch().getTimeOfEnd().toString());
            rowsCells.add(log.getCouplePoints().getPointA().toString());
            rowsCells.add(log.getCouplePoints().getPointB().toString());
            rowsCells.add(log.getCalculation().getMethodCalculation().toString());
            rowsCells.add("" + log.getCalculation().getDistance());
            excelMassive.setRowsCells(rowsCells);
            System.out.println(rowsCells);
            excelMassiveData.add(excelMassive);
            index++;
        }
        return excelMassiveData;
    }
}
