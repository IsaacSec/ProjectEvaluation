package classes.utils;

import classes.config.CNodeID;
import classes.control.GetData;
import classes.control.InputDEP;
import classes.control.InputNPV;
import classes.control.InputPBP;
import com.itextpdf.text.DocumentException;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by isaac on 4/27/17.
 */
public class ReportGenerator {

    public static void generatePBPReport(Scene scene){
        ImageGenerator.generatePBPChartImages(scene);
        createPDF_PayBack pbp = new createPDF_PayBack();
        InputPBP input = GetData.getPayBackPeriodInput(scene);
        String data = input.getPeriods()+"_"+input.getPrincipal()+"_"+input.getInterest()+"_[DATA HERE]";

        try {
            pbp.writePDF(scene,data);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateNPVReport(Scene scene){
        ImageGenerator.generateNPVChartImages(scene);
        createPDF_NetPresent npv = new createPDF_NetPresent();
        InputNPV input = GetData.getNetPresentValueInput(scene);
        String data = input.getPeriods()+"_"+input.getPrincipal()+"_"+input.getInterest()+"_"+input.getTax()+"_"+input.getSalvagePeriod()
                +"_"+input.getSalvagePeriod()+"_[DATA_HERE]";

        try {
            npv.writePDF(scene, data);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateDEPReport(Scene scene){
        ImageGenerator.generateDEPChartImages(scene);
        crearPDF_Depreciacion dep = new crearPDF_Depreciacion();
        InputDEP input = GetData.getDepreciationInput(scene);
        String data = input.getPrincipal()+"_"+input.getSalvage()+"_"+input.getPeriods()+"_"+input.getTax()+"_"+input.getPeriodSalvage()+"_"+input.getCategory();
        data += "_[DATA HERE]";

        try {
            dep.writePDF(data,scene);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
