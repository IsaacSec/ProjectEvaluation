package classes.utils;

import classes.config.CNodeID;
import classes.control.GetData;
import classes.control.InputDEP;
import classes.control.InputNPV;
import classes.control.InputPBP;
import classes.pmo.CheckListResult;
import classes.tablemodel.RowDEP;
import classes.tablemodel.RowNPV;
import classes.tablemodel.RowPBP;
import com.itextpdf.text.DocumentException;
import com.sun.jndi.cosnaming.CNCtx;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
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
        String data = input.getPeriods()+"_"+input.getPrincipal()+"_"+input.getInterest()+"_";

        String output = "";
        ObservableList<RowPBP> rows = ((TableView<RowPBP>)scene.lookup(CNodeID.TABLE_PBP_CASHFLOW)).getItems();

        for (int i=0; i<rows.size(); i++){
            output += rows.get(i).getAllDataInRow()+"\n";
        }

        data += output;

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
                +"_"+input.getSalvagePeriod()+"_";

        String output = "";
        ObservableList<RowNPV> rows = ((TableView<RowNPV>)scene.lookup(CNodeID.TABLE_NPV)).getItems();

        for (int i=0; i<rows.size(); i++){
            output += rows.get(i).getAllDataInRow()+"\n";
        }

        data += output;

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
        data += "_";

        String output = "";
        ObservableList<RowDEP> rows = ((TableView<RowDEP>)scene.lookup(CNodeID.TABLE_DEP)).getItems();

        for (int i=0; i<rows.size(); i++){
            output += rows.get(i).getAllDataInRow()+"\n";
        }

        data += output;

        try {
            dep.writePDF(data,scene);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateChecklistReport(Scene scene){
        createPDF_checkList check = new createPDF_checkList();
        CheckListResult output = GetData.getChecklist(scene);
        String data = output.toString();

        try {
            check.writePDF(scene, data);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
