package classes.utils;

import classes.config.CNodeID;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * Created by isaac on 4/27/17.
 */
public class ReportGenerator {

    public static void generatePBPReport(Scene scene){
        ImageGenerator.generatePBPChartImages(scene);
    }

    public static void generateNPVReport(Scene scene){
        ImageGenerator.generateNPVChartImages(scene);
    }

    public static void generateDEPReport(Scene scene){
        ImageGenerator.generateDEPChartImages(scene);
    }
}
