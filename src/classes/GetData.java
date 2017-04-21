package classes;

import classes.config.CNodeID;
import classes.screening.NetPresentValue;
import classes.screening.PayBackPeriod;
import classes.tablemodel.TableNPV;
import classes.tablemodel.TablePBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by erikm on 18/04/2017.
 */
public class GetData {

    /**
     * Get the values of the period, principal and interest
     * @param scene The current scene of Javafx
     * @return
     * Return a PayBackPeriod contaeining the data of the text fields
     */
    public PayBackPeriod payBackPeriod(Scene scene){
        PayBackPeriod pbp;
        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        TextField principal = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PRINCIPAL);
        TextField interest = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_INTEREST_RATE);
        if(!periods.getText().isEmpty()&& !principal.getText().isEmpty()) {
            if(interest.getText().isEmpty())interest.setText("0");
            try {
                pbp = new PayBackPeriod(Integer.parseInt(periods.getText()), Integer.parseInt(principal.getText()), Integer.parseInt(interest.getText()));
            }catch (NumberFormatException nfe){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("The Period and Principal need to be numbers");
                alert.showAndWait();
                pbp = null;
            }
        }else{
            if(periods.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Missing information");
                alert.setContentText("You need to specify the time period.");
                alert.showAndWait();
            }else if (principal.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Missing information");
                alert.setContentText("You need to specify the principal investment.");
                alert.showAndWait();
            }
            pbp = null;
        }
        return pbp;
    }

    public NetPresentValue netPresentValue(Scene scene){
        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIODS);
        TextField principal = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PRINCIPAL);
        TextField interest = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_INTEREST_RATE);
        TextField tax = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_TAX_RATE);
        TextField salvage = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_SALVAGE_VALUE);
        TextField salvagePeriod = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIOD_SV);

        int per = Integer.parseInt(periods.getText());
        float pri = Float.parseFloat(principal.getText());
        float inte = Float.parseFloat(interest.getText());
        float taxes = Float.parseFloat(tax.getText());
        float salv = Float.parseFloat(salvage.getText());
        int salvp = Integer.parseInt(salvagePeriod.getText());


        NetPresentValue npv = new NetPresentValue(per,pri,inte,taxes,salv,salvp);


        return npv;
    }

    /**
     * Get the outflows of the table
     * @param scene The current scene of Javafx
     * @return
     * Array list with all the outflows
     */

    public ArrayList<Float>getOutflows(Scene scene){
        ArrayList<Float> outflows = new ArrayList<>();
        TableView<TablePBP> table = (TableView<TablePBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<TablePBP> rows = table.getItems();                           //Get all the items in the table.
        int size = rows.size();
        try {                                                                       //Validate that all outflows are integers.
            for (int i = 0; i < size ; i++) {
                TablePBP row = rows.get(i);
                float outflow = Math.abs(Float.parseFloat(row.getOutflows().getText()));      //Make all outflows positives
                outflows.add(outflow);                                              //Add the outflow to the inflow array list
            }
        }catch (NumberFormatException nfe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("All Outflows in the table must be numbers");
            alert.showAndWait();
        }

        return outflows;
    }

    /**
     * Get the inflows of the table
     * @param scene The current scene of Javafx
     * @return
     * Array list with all the inflows
     */
    public ArrayList<Float>getInflows(Scene scene){
        ArrayList<Float> inflows = new ArrayList<>();
        TableView<TablePBP> table = (TableView<TablePBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<TablePBP> rows = table.getItems();                       //Get all the items in the table.
        int size = rows.size();
        try {                                                                   //Validate that all inflows are integers.
            for (int i = 0; i < size; i++) {
                TablePBP row = rows.get(i);
                float inflow = Math.abs(Float.parseFloat(row.getInflows().getText()));    //Make all inflows positives
                inflows.add(inflow);                                            //Add the inflow to the inflow array list
            }
        }catch (NumberFormatException nfe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("All Inflows in the table must be numbers");
            alert.showAndWait();
        }
        return inflows;
    }

    /**
     * Get the outflows of the table
     * @param scene The current scene of Javafx
     * @return
     * Array list with all the outflows
     */

    public ArrayList<Float>getNPVOutflows(Scene scene){
        ArrayList<Float> outflows = new ArrayList<>();
        TableView<TableNPV> table = (TableView<TableNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<TableNPV> rows = table.getItems();                           //Get all the items in the table.
        int size = rows.size();
        try {                                                                       //Validate that all outflows are integers.
            for (int i = 0; i < size ; i++) {
                TableNPV row = rows.get(i);
                float outflow = Math.abs(Float.parseFloat(row.getOutflows().getText()));      //Make all outflows positives
                outflows.add(outflow);                                              //Add the outflow to the inflow array list
            }
        }catch (NumberFormatException nfe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("All Outflows in the table must be numbers");
            alert.showAndWait();
        }

        return outflows;
    }

    /**
     * Get the inflows of the table
     * @param scene The current scene of Javafx
     * @return
     * Array list with all the inflows
     */
    public ArrayList<Float>getNPVInflows(Scene scene){
        ArrayList<Float> inflows = new ArrayList<>();
        TableView<TableNPV> table = (TableView<TableNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<TableNPV> rows = table.getItems();                       //Get all the items in the table.
        int size = rows.size();
        try {                                                                   //Validate that all inflows are integers.
            for (int i = 0; i < size; i++) {
                TableNPV row = rows.get(i);
                float inflow = Math.abs(Float.parseFloat(row.getInflows().getText()));    //Make all inflows positives
                inflows.add(inflow);                                            //Add the inflow to the inflow array list
            }
        }catch (NumberFormatException nfe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("All Inflows in the table must be numbers");
            alert.showAndWait();
        }
        return inflows;
    }
}
