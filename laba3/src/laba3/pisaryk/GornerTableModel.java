package laba3.pisaryk;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel{

    private Double from, to, step, parameter;

    public GornerTableModel(Double from, Double to, Double step, Double parameter) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.parameter = parameter;
    }

    public Double getParameter() { return parameter; }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }
    @Override
    public int getRowCount() {
        return (int)(Math.ceil((to-from)/step))+1;
    }
    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { // метод Горнера
        Double x = from + step*rowIndex;
        Double y = x+parameter+x*(-parameter*0.2)+Math.pow(x,2)*(-parameter);
        int temp;
        Boolean z = false;// логика 3 столба
        if((0.1>Math.abs(y-y.intValue())) || (Math.abs(y-y.intValue())>0.9))
        {
            z = true;
        }

        switch (columnIndex){
            case 0: return x;
            case 1: return y;
            case 2: return z;
        }
        return null;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 2) return Boolean.class;
        return Double.class;
    }
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Значение Х";
            case 1: return "Значение многочлена";
            case 2: return "Близко к целому?";
        }
        return "";
    }
}