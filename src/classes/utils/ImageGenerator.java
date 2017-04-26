package classes.utils;

import classes.config.CNodeID;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
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

    public static void generatePngFromLineChart(Scene scene, LineChart chart, String identifier){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        LineChart newChart = new LineChart(chart.getXAxis(), chart.getYAxis(), chart.getData());
        Scene graph = new Scene(newChart);
        String pname = projectName.getText();
        generatePng(graph, pname+"-"+identifier+".png");
    }

    public static void generatePngFromBarChart(Scene scene, BarChart chart, String identifier){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        BarChart newChart = new BarChart(chart.getXAxis(), chart.getYAxis(), chart.getData());
        Scene graph = new Scene(newChart);
        String pname = projectName.getText();
        generatePng(graph, pname+"-"+identifier+".png");
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
