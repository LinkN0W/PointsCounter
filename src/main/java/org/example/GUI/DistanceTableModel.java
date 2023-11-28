package org.example.GUI;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
class DistanceTableModel extends javax.swing.table.AbstractTableModel {




    private String[] columnNames;
    private Object[][] data = {};

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }



    public DistanceTableModel(String[][] data){
        this.data = data;

    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public void setRow(List<String> rowList, int rowIndex){
        int column = 0;
        for (String row : rowList){
            data[rowIndex][column++] = row;
        }

    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        data[row][column] = value;
    }
}
