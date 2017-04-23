package classes.control;

import classes.config.CNodeID;
import classes.tablemodel.RowNPV;
import classes.tablemodel.RowPBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.util.ArrayList;

/**
 * Created by erikm on 18/04/2017.
 */
public class GetData {

    /**
     * Get the values of the period, principal and interest
     * @param scene The current scene of Javafx
     * @return
     * Return a InputPBP containing the data of the text fields
     */
    public static InputPBP getPayBackPeriodInput(Scene scene){
        InputPBP pbp;
        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        TextField principal = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PRINCIPAL);
        TextField interest = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_INTEREST_RATE);

        if(!periods.getText().isEmpty()&& !principal.getText().isEmpty()) {
            if(interest.getText().isEmpty())interest.setText("0");
            try {
                pbp = new InputPBP(Integer.parseInt(periods.getText()), Float.parseFloat(principal.getText()), Float.parseFloat(interest.getText()));
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

    public static InputNPV getNetPresentValueInput(Scene scene){
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


        InputNPV npv = new InputNPV(per,pri,inte,taxes,salv,salvp);


        return npv;
    }

    public static InputDEP getDepreciationInput(Scene scene){
        TextField periodsTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIODS);
        TextField principalTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PRINCIPAL);
        TextField taxTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_TAX_RATE);
        TextField salvageValueTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_SALVAGE_VALUE);
        TextField periodSVTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIOD_SV);
        ChoiceBox<String> categoryCB = (ChoiceBox<String>) scene.lookup(CNodeID.COMBOBOX_DEP_CATEGORY);
        TextField startingYearTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_STARTING_YEAR);

        int periods = Integer.parseInt(periodsTF.getText());
        float principal = Float.parseFloat(principalTF.getText());
        float tax = Float.parseFloat(taxTF.getText());
        float salvageValue = Float.parseFloat(salvageValueTF.getText());
        int periodSV = Integer.parseInt(periodSVTF.getText());
        String category = categoryCB.getValue();
        int startingYear = Integer.parseInt(startingYearTF.getText());

        InputDEP dep = new InputDEP(periods,principal,tax,salvageValue,periodSV,category,startingYear);
        return dep;
    }

    /**
     * Get the outflows of the table
     * @param scene The current scene of Javafx
     * @return
     * Array list with all the outflows
     */

    public static ArrayList<Float> getPBPOutflows(Scene scene){
        ArrayList<Float> outflows = new ArrayList<>();
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();                           //Get all the items in the table.
        int size = rows.size();
        try {                                                                       //Validate that all outflows are integers.
            for (int i = 0; i < size ; i++) {
                RowPBP row = rows.get(i);
                float outflow = Math.abs(Float.parseFloat(row.getOutflow().getText()));      //Make all outflows positives
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
    public static ArrayList<Float> getPBPInflows(Scene scene){
        ArrayList<Float> inflows = new ArrayList<>();
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();                       //Get all the items in the table.
        int size = rows.size();
        try {                                                                   //Validate that all inflows are integers.
            for (int i = 0; i < size; i++) {
                RowPBP row = rows.get(i);
                float inflow = Math.abs(Float.parseFloat(row.getInflow().getText()));    //Make all inflows positives
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

    public static ArrayList<Float> getNPVOutflows(Scene scene){
        ArrayList<Float> outflows = new ArrayList<>();
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<RowNPV> rows = table.getItems();                           //Get all the items in the table.
        int size = rows.size();
        try {                                                                       //Validate that all outflows are integers.
            for (int i = 0; i < size ; i++) {
                RowNPV row = rows.get(i);
                float outflow = Math.abs(Float.parseFloat(row.getOutflow().getText()));      //Make all outflows positives
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
    public static ArrayList<Float> getNPVInflows(Scene scene){
        ArrayList<Float> inflows = new ArrayList<>();
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<RowNPV> rows = table.getItems();                       //Get all the items in the table.
        int size = rows.size();
        try {                                                                   //Validate that all inflows are integers.
            for (int i = 0; i < size; i++) {
                RowNPV row = rows.get(i);
                float inflow = Math.abs(Float.parseFloat(row.getInflow().getText()));    //Make all inflows positives
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
