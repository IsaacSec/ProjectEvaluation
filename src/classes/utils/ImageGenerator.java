package classes.utils;

import classes.config.CNodeID;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by isaac on 4/26/17.
 */
public class ImageGenerator {

    public static void generateSceneCharts(Scene scene, String path){
        // Create directory
        File file = new File(path);
        file.mkdir();

        generatePBPChartImages(scene, path);
        generateNPVChartImages(scene, path);
        generateDEPChartImages(scene, path);
    }

    public static void generatePBPChartImages(Scene scene, String path){
        LineChart ccf = (LineChart) scene.lookup(CNodeID.CHART_PBP_CUMULATIVE_CASH_FLOW);
        BarChart ncf = (BarChart) scene.lookup(CNodeID.CHART_PBP_NET_CASH_FLOW);

        generatePngFromLineChart(scene, ccf, path, "PBP-CCF");
        generatePngFromBarChart(scene, ncf, path, "PBP-NCF");
    }

    public static void generateNPVChartImages(Scene scene, String path){
        LineChart ccf = (LineChart) scene.lookup(CNodeID.CHART_NPV_CUMULATIVE_CASH_FLOW);
        BarChart ncf = (BarChart) scene.lookup(CNodeID.CHART_NPV_NET_CASH_FLOW);

        generatePngFromLineChart(scene, ccf, path, "NPV-CCF");
        generatePngFromBarChart(scene, ncf, path, "NPV-NCF");
    }

    public static void generateDEPChartImages(Scene scene, String path){
        LineChart dr = (LineChart) scene.lookup(CNodeID.CHART_DEP_DEPRECIATION_RATE);
        LineChart ad = (LineChart) scene.lookup(CNodeID.CHART_DEP_ANNUAL_DEPRECIATION);
        LineChart acd = (LineChart) scene.lookup(CNodeID.CHART_DEP_ACCUMULATED_DEPRECIATION);
        AreaChart lv = (AreaChart) scene.lookup(CNodeID.CHART_DEP_LEDGER_VALUES);
        LineChart ty = (LineChart) scene.lookup(CNodeID.CHART_DEP_TAX_YEAR);

        generatePngFromLineChart(scene, dr, path, "DEP_DR");
        generatePngFromLineChart(scene, ad, path, "DEP_AD");
        generatePngFromLineChart(scene, acd, path, "DEP_ACD");
        generatePngFromAreaChart(scene, lv, path, "DEP_LV");
        generatePngFromLineChart(scene, ty, path, "DEP_TY");
    }

    public static void generatePngFromLineChart(Scene scene, LineChart chart, String path ,String identifier){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        LineChart newChart = new LineChart(chart.getXAxis(), chart.getYAxis(), chart.getData());
        Scene graph = new Scene(newChart);
        String pname = projectName.getText();
        generatePng(graph, path + pname+"_"+identifier+".png");
    }

    public static void generatePngFromBarChart(Scene scene, BarChart chart, String path, String identifier){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        BarChart newChart = new BarChart(chart.getXAxis(), chart.getYAxis(), chart.getData());
        Scene graph = new Scene(newChart);
        String pname = projectName.getText();
        generatePng(graph, path + pname+"_"+identifier+".png");
    }

    public static void generatePngFromAreaChart(Scene scene, AreaChart chart, String path, String identifier){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        AreaChart newChart = new AreaChart(chart.getXAxis(), chart.getYAxis(), chart.getData());
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
}
