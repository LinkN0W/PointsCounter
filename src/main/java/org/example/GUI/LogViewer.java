package org.example.GUI;

import org.example.excel.ExcelExport;
import org.example.excel.ExcelMassiveCompiler;
import org.example.excel.LogMassiveCompiler;
import org.example.logger.LoggerFunctional;
import org.example.logger.entities.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LogViewer extends JFrame implements ActionListener {
    private JButton loadButton, exportButton, calculateButton;
    private JTable table;

    private DistanceCalculatorApp distanceCalculator;

    private DistanceTableModel tableModel;

    public LogViewer() {
        super("Log Viewer");

        loadButton = new JButton("Load Log");
        exportButton = new JButton("Export to Excel");
        calculateButton = new JButton("Back to Main");

        tableModel = new DistanceTableModel();
        tableModel.setColumnNames(new String[]{"ID", "Start Time", "End Time", "Point A", "Point B", "Distance"});
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JPanel panel = new JPanel();
        panel.add(calculateButton);
        panel.add(loadButton);
        panel.add(exportButton);


        JScrollPane scrollPane = new JScrollPane(table);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);

        loadButton.addActionListener(this);
        exportButton.addActionListener(this);
        calculateButton.addActionListener(this);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loadButton) {
            LoggerFunctional loggerFunctional = new LoggerFunctional();

            List<Logger> loggerList = (List<Logger>) loggerFunctional.getLoggerService().getAllLogger();

            tableModel.setData(new String[loggerList.size()][6]);

            int row = 0;
            for(Logger logger : loggerList){
                tableModel.setValueAt(""+(row+1), row, 0);
                tableModel.setValueAt(logger.getLaunch().getTimeOfBegin().toString(), row, 1);
                tableModel.setValueAt(logger.getLaunch().getTimeOfEnd().toString(), row, 2);
                tableModel.setValueAt(logger.getCouplePoints().getPointA().toString(), row, 3);
                tableModel.setValueAt(logger.getCouplePoints().getPointB().toString(), row, 4);
                tableModel.setValueAt(""+logger.getCalculation().getDistance(), row++, 5);
            }
            table.setModel(tableModel);
            tableModel.fireTableStructureChanged();
            table.repaint();

        }
        else if(e.getSource() == exportButton){
            ExcelExport excelExport = new ExcelExport();
            ExcelMassiveCompiler logCompile = new LogMassiveCompiler();
            LoggerFunctional loggerFunctional = new LoggerFunctional();

            excelExport.exportData(
                    logCompile.compileExcelMassive(
                            (List) loggerFunctional.getLoggerService().getAllLogger()
                    ));

        }
        else if(e.getSource() == calculateButton){
            distanceCalculator = new DistanceCalculatorApp();
            setVisible(false);
            distanceCalculator.setVisible(true);

        }

    }
}