package org.example.GUI;

import org.example.inputXML.XMLReader;
import org.example.logger.LogAggregator;
import org.example.logger.LoggerFunctional;
import org.example.logger.entities.Logger;
import org.example.points.entities.CouplePoints;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DistanceCalculatorApp extends JFrame implements ActionListener{

    private JButton uploadButton, logButton, calculateButton;
    private JTable resultTable;
    private DistanceTableModel tableModel;

    JTextField pathField;
    JScrollPane scrollPane;

    private LogViewer logViewer;

    private List<CouplePoints> couplePointsList;

    public DistanceCalculatorApp() {
        setTitle("Distance Calculator App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 320);
        setLocationRelativeTo(null);
        setResizable(false);

        pathField = new JTextField(20);

        pathField.setEditable(false);
        pathField.setFocusable(false);



        uploadButton = new JButton("Load a file");
        uploadButton.addActionListener(this);


        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        logButton = new JButton("Log");
        logButton.addActionListener(this);


        tableModel = new DistanceTableModel();
        tableModel.setColumnNames(new String[]{"Point A", "Point B", "Distance"});



        resultTable = new JTable(tableModel);
        scrollPane = new JScrollPane(resultTable);
        scrollPane.setPreferredSize(new Dimension(350, 200));

        getContentPane().add(pathField);

        getContentPane().add(uploadButton);
        getContentPane().add(calculateButton);
        getContentPane().add(logButton);
        getContentPane().add(scrollPane);


        setLayout(new java.awt.FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logButton) {
            logViewer = new LogViewer();
            setVisible(false);
            logViewer.setLocationRelativeTo(null);
            logViewer.setVisible(true);
        } else if (e.getSource() == uploadButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose a file");
            fileChooser.setCurrentDirectory(new java.io.File("."));
            fileChooser.setFileFilter(new FileNameExtensionFilter("Xml file (*.xml)", "xml"));
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {

                pathField.setText("" + fileChooser.getSelectedFile().getPath());
                System.out.println("Selected file: " + fileChooser.getSelectedFile().getPath());

                XMLReader xmlReader = new XMLReader.Builder(pathField.getText())
                        .setElement("CouplePoints")
                        .build();
                couplePointsList = ((List<CouplePoints>) xmlReader.getElements());

                tableModel.setData(new String[couplePointsList.size()][3]);

               int row = 0;
                for (CouplePoints couplePoint: couplePointsList) {
                    tableModel.setValueAt(couplePoint.getPointA().toString(),row,0);
                    tableModel.setValueAt(couplePoint.getPointB().toString(),row,1);
                    tableModel.setValueAt(" ",row++,2);
                }
                resultTable.setModel(tableModel);
                tableModel.fireTableStructureChanged();
                resultTable.repaint();


            }
        } else if (e.getSource() == calculateButton && pathField.getText() != "") {
            LogAggregator logAggregator = new LogAggregator();
            LoggerFunctional loggerFunctional = new LoggerFunctional();

            int row = 0;
            for (CouplePoints couplePoints : couplePointsList){
                Logger logger = logAggregator.aggregateLog(couplePoints);
                loggerFunctional.addLogToTable(logger);
                tableModel.setValueAt(""+logger.getCalculation().getDistance(),row++,2);
            }
            resultTable.setModel(tableModel);
            tableModel.fireTableStructureChanged();
            resultTable.repaint();

        }
    }
}