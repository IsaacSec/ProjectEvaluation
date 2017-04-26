package classes.control;

import classes.config.CNodeID;
import classes.tablemodel.RowPBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;

/**
 * Created by isaac on 4/25/17.
 */
public class GraphAction {

    public static void generatePBPGraphs(Scene scene){
        BarChart<String,Number> graph = (BarChart<String,Number>) scene.lookup(CNodeID.GRAPH_PBP_NET_CASH_FLOW);
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);

        ObservableList<RowPBP> tableData = table.getItems();
        XYChart.Series series = new XYChart.Series();
        ObservableList<XYChart.Data> seriesData = series.getData();

        for (int i=0; i<tableData.size(); i++){
            RowPBP row = tableData.get(i);
            Integer period = Integer.parseInt(row.getPeriod());
            Double cumulative = Double.parseDouble(row.getCumulativeCashFlow());
            XYChart.Data d = new XYChart.Data(""+period,cumulative);
            seriesData.add(d);
        }

        graph.getData().clear();
        graph.getData().add(series);
        //graph.getData().
    }
}
