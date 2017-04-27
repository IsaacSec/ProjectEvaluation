package classes.utils;

import classes.config.CNodeID;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import java.io.File;
import java.io.IOException;

/**
 * Created by isaac on 4/26/17.
 */
public class ImageGenerator {

    public static void generateSceneCharts(Scene scene){
        // Create directory
        generatePBPChartImages(scene);
        generateNPVChartImages(scene);
        generateDEPChartImages(scene);
    }

    public static void generatePBPChartImages(Scene scene){
        LineChart<String,Number> ccf = (LineChart<String,Number>) scene.lookup(CNodeID.CHART_PBP_CUMULATIVE_CASH_FLOW);
        BarChart ncf = (BarChart) scene.lookup(CNodeID.CHART_PBP_NET_CASH_FLOW);
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        String path = projectName.getText()+"/";

        File file = new File(path);
        file.mkdir();

        System.out.println("Size "+ccf.getData().get(0).getData().size());

        generatePngFromLineChart(scene, ccf, path, "PBP_CCF");
        generatePngFromBarChart(scene, ncf, path, "PBP_NCF");

    }

    public static void generateNPVChartImages(Scene scene){
        LineChart ccf = (LineChart) scene.lookup(CNodeID.CHART_NPV_CUMULATIVE_CASH_FLOW);
        BarChart ncf = (BarChart) scene.lookup(CNodeID.CHART_NPV_NET_CASH_FLOW);
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        String path = projectName.getText()+"/";

        File file = new File(path);
        file.mkdir();

        generatePngFromLineChart(scene, ccf, path, "NPV_CCF");
        generatePngFromBarChart(scene, ncf, path, "NPV_NCF");
    }

    public static void generateDEPChartImages(Scene scene){
        LineChart dr = (LineChart) scene.lookup(CNodeID.CHART_DEP_DEPRECIATION_RATE);
        LineChart ad = (LineChart) scene.lookup(CNodeID.CHART_DEP_ANNUAL_DEPRECIATION);
        LineChart acd = (LineChart) scene.lookup(CNodeID.CHART_DEP_ACCUMULATED_DEPRECIATION);
        AreaChart lv = (AreaChart) scene.lookup(CNodeID.CHART_DEP_LEDGER_VALUES);
        LineChart ty = (LineChart) scene.lookup(CNodeID.CHART_DEP_TAX_YEAR);

        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        String path = projectName.getText()+"/";

        File file = new File(path);
        file.mkdir();

        generatePngFromLineChart(scene, dr, path, "DEP_DR");
        generatePngFromLineChart(scene, ad, path, "DEP_AD");
        generatePngFromLineChart(scene, acd, path, "DEP_ACD");
        generatePngFromAreaChart(scene, lv, path, "DEP_LV");
        generatePngFromLineChart(scene, ty, path, "DEP_TY");
    }

    public static void generatePngFromLineChart(Scene scene, LineChart chart, String path ,String identifier){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        LineChart newChart = cloneLineChart(chart);
        Scene graph = new Scene(newChart);
        String pname = projectName.getText();
        //System.out.println(path);
        generatePng(graph, path + pname+"_"+identifier+".png");
    }

    public static void generatePngFromBarChart(Scene scene, BarChart chart, String path, String identifier){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        BarChart newChart = cloneBarChart(chart);
        Scene graph = new Scene(newChart);
        String pname = projectName.getText();
        //System.out.println(path + pname+"_"+identifier+".png");
        generatePng(graph, path + pname+"_"+identifier+".png");
    }

    public static void generatePngFromAreaChart(Scene scene, AreaChart chart, String path, String identifier){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        AreaChart newChart = cloneAreaChart(chart);
        Scene graph = new Scene(newChart);
        String pname = projectName.getText();
        generatePng(graph, path + pname+"_"+identifier+".png");
    }

    public static void generatePng(Scene scene, String path) {
        WritableImage image = scene.snapshot(null);
        File file = new File(path);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (image.getProgress() != 1){
            System.out.println(image.getProgress());
        }
    }

    private static LineChart cloneLineChart(LineChart<String,Number> src){

        XYChart.Series<Number,Number> newSeries = new XYChart.Series<Number,Number>();
        int size = src.getData().get(0).getData().size();
        XYChart.Series<String,Number> srcSeries = src.getData().get(0);

        for (int i = 0; i < size; i++) {
            Number x = Double.parseDouble( srcSeries.getData().get(i).getXValue());
            Number y = srcSeries.getData().get(i).getYValue();
            newSeries.getData().add(new XYChart.Data(x,y));
        }

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel(src.getXAxis().getLabel());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(src.getYAxis().getLabel());

        LineChart cpy = new LineChart(xAxis,yAxis);
        cpy.getData().add(newSeries);
        return cpy;
    }

    private static BarChart cloneBarChart(BarChart<String,Number> src){

        XYChart.Series<String,Number> newSeries = new XYChart.Series<String,Number>();
        int size = src.getData().get(0).getData().size();
        XYChart.Series<String,Number> srcSeries = src.getData().get(0);

        for (int i = 0; i < size; i++) {
            String x = srcSeries.getData().get(i).getXValue();
            Number y = srcSeries.getData().get(i).getYValue();
            newSeries.getData().add(new XYChart.Data(x,y));
        }

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(src.getXAxis().getLabel());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(src.getYAxis().getLabel());

        BarChart cpy = new BarChart(xAxis,yAxis);
        cpy.getData().add(newSeries);
        return cpy;
    }

    private static AreaChart cloneAreaChart(AreaChart<String,Number> src){

        XYChart.Series<Number,Number> newSeries = new XYChart.Series<Number,Number>();
        int size = src.getData().get(0).getData().size();
        XYChart.Series<String,Number> srcSeries = src.getData().get(0);

        for (int i = 0; i < size; i++) {
            Number x = Double.parseDouble( srcSeries.getData().get(i).getXValue());
            Number y = srcSeries.getData().get(i).getYValue();
            newSeries.getData().add(new XYChart.Data(x,y));
        }

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel(src.getXAxis().getLabel());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(src.getYAxis().getLabel());

        AreaChart cpy = new AreaChart(xAxis,yAxis);
        cpy.getData().add(newSeries);
        return cpy;
    }
}
