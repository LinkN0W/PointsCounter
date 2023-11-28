package org.example;

import org.example.GUI.DistanceCalculatorApp;
import org.example.excel.ExcelExport;
import org.example.excel.ExcelMassive;
import org.example.logger.LoggerService;
import org.example.logger.entities.Logger;
import org.example.logger.LogAggregator;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        new DistanceCalculatorApp().setVisible(true);
    }

}




