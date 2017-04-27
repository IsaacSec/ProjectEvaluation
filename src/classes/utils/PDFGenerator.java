package classes.utils;

import classes.config.CNodeID;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * Created by isaac on 4/27/17.
 */
public class PDFGenerator {

    public static void generatePBPReport(Scene scene){
        ImageGenerator.generatePBPChartImages(scene);
    }
}
