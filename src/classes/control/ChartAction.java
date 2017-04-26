package classes.control;

import classes.config.CNodeID;
import classes.tablemodel.RowDEP;
import classes.tablemodel.RowNPV;
import classes.tablemodel.RowPBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Created by isaac on 4/25/17.
 */
public class ChartAction {

    public static void displayPBPCharts(Scene scene){
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> tableData = table.getItems();

        displayPBPChartNetCashFlow(scene, tableData);
        displayPBPChartCumulativeCashFlow(scene, tableData);
    }

    private static void displayPBPChartNetCashFlow(Scene scene, ObservableList<RowPBP> tableData){
        BarChart<String,Number> chart = (BarChart<String,Number>) scene.lookup(CNodeID.CHART_PBP_NET_CASH_FLOW);
        TextField principal = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PRINCIPAL);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowPBP row = tableData.get(i);
            x.add(row.getPeriod());
            if (i==0){
                y.add(Double.parseDouble(row.getInflow().getText()) - Double.parseDouble(row.getOutflow().getText()) - Double.parseDouble(principal.getText()));
            }else {
                y.add(Double.parseDouble(row.getInflow().getText()) - Double.parseDouble(row.getOutflow().getText()));
            }
        }

        displayChart(chart,x,y);
    }

    private static void displayPBPChartCumulativeCashFlow(Scene scene, ObservableList<RowPBP> tableData){
        LineChart<String,Number> chart = (LineChart<String,Number>) scene.lookup(CNodeID.CHART_PBP_CUMULATIVE_CASH_FLOW);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowPBP row = tableData.get(i);
            x.add(row.getPeriod());
            y.add(Double.parseDouble(row.getCumulativeCashFlow()));
        }

        displayChart(chart,x,y);
    }

    public static void displayNPVCharts(Scene scene){
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<RowNPV> tableData = table.getItems();

        displayNPVChartNetCashFlow(scene, tableData);
        displayNPVChartCumulativeCashFlow(scene, tableData);
    }

    private static void displayNPVChartNetCashFlow(Scene scene, ObservableList<RowNPV> tableData){
        BarChart<String,Number> chart = (BarChart<String,Number>) scene.lookup(CNodeID.CHART_NPV_NET_CASH_FLOW);
        TextField principal = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PRINCIPAL);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowNPV row = tableData.get(i);
            x.add(row.getPeriod());
            if (i==0){
                y.add(Double.parseDouble(row.getInflow().getText()) - Double.parseDouble(row.getOutflow().getText()) - Double.parseDouble(principal.getText()));
            }else {
                y.add(Double.parseDouble(row.getInflow().getText()) - Double.parseDouble(row.getOutflow().getText()));
            }
        }

        displayChart(chart,x,y);
    }

    private static void displayNPVChartCumulativeCashFlow(Scene scene, ObservableList<RowNPV> tableData){
        LineChart<String,Number> chart = (LineChart<String,Number>) scene.lookup(CNodeID.CHART_NPV_CUMULATIVE_CASH_FLOW);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowNPV row = tableData.get(i);
            x.add(row.getPeriod());
            y.add(Double.parseDouble(row.getCumulativeCashFlow()));
        }

        displayChart(chart,x,y);
    }

    public static void displayDEPCharts(Scene scene){
        TableView<RowDEP> table = (TableView<RowDEP>) scene.lookup(CNodeID.TABLE_DEP);
        ObservableList<RowDEP> tableData = table.getItems();

        displayDEPChartDepreciationRate(scene, tableData);
        displayDEPChartAnnualDepreciation(scene, tableData);
        displayDEPChartAccumulatedDepreciation(scene, tableData);
        displayDEPChartLedgerValues(scene, tableData);
        displayDEPChartTaxYear(scene, tableData);
    }

    private static void displayDEPChartDepreciationRate(Scene scene, ObservableList<RowDEP> tableData){
        LineChart<String,Number> chart = (LineChart<String,Number>) scene.lookup(CNodeID.CHART_DEP_DEPRECIATION_RATE);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowDEP row = tableData.get(i);
            x.add(row.getYears());
            y.add(Double.parseDouble(row.getDepreciationRate()));
        }

        displayChart(chart,x,y);
    }

    private static void displayDEPChartAnnualDepreciation(Scene scene, ObservableList<RowDEP> tableData){
        LineChart<String,Number> chart = (LineChart<String,Number>) scene.lookup(CNodeID.CHART_DEP_ANNUAL_DEPRECIATION);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowDEP row = tableData.get(i);
            x.add(row.getYears());
            y.add(Double.parseDouble(row.getAnnualDepreciation()));
        }

        displayChart(chart,x,y);
    }

    private static void displayDEPChartAccumulatedDepreciation(Scene scene, ObservableList<RowDEP> tableData){
        LineChart<String,Number> chart = (LineChart<String,Number>) scene.lookup(CNodeID.CHART_DEP_ACCUMULATED_DEPRECIATION);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowDEP row = tableData.get(i);
            x.add(row.getYears());
            y.add(Double.parseDouble(row.getAccumulativeDepreciation()));
        }

        displayChart(chart,x,y);
    }

    private static void displayDEPChartLedgerValues(Scene scene, ObservableList<RowDEP> tableData){
        AreaChart<String,Number> chart = (AreaChart<String,Number>) scene.lookup(CNodeID.CHART_DEP_LEDGER_VALUES);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowDEP row = tableData.get(i);
            x.add(row.getYears());
            y.add(Double.parseDouble(row.getValueLedgers()));
        }

        displayChart(chart,x,y);
    }

    private static void displayDEPChartTaxYear(Scene scene, ObservableList<RowDEP> tableData){
        LineChart<String,Number> chart = (LineChart<String,Number>) scene.lookup(CNodeID.CHART_DEP_TAX_YEAR);
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();

        for (int i=0; i<tableData.size(); i++){
            RowDEP row = tableData.get(i);
            x.add(row.getYears());
            y.add(Double.parseDouble(row.getTaxPerYear()));
        }

        displayChart(chart,x,y);
    }

    // General Method

    private static void displayChart(XYChart chart, ArrayList<String> x, ArrayList<Double> y){
        XYChart.Series series = new XYChart.Series();
        ObservableList<XYChart.Data> seriesData = series.getData();

        for (int i=0; i<x.size(); i++){
            String xValue = x.get(i);
            Double yValue = y.get(i);
            XYChart.Data data = new XYChart.Data(xValue, yValue);
            seriesData.add(data);
        }

        chart.getData().clear();
        chart.getData().add(series);
    }

}
