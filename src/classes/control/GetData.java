package classes.control;

import classes.config.CNodeID;
import classes.pmo.CheckListResult;
import classes.pmo.ChecklistModel;
import classes.tablemodel.RowChecklist;
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
                displayError("Error",null,"The Period, Principal and Interest rate must be numbers" );
                pbp = null;
            }
        }else{
            if(periods.getText().isEmpty()){
                displayError("Error",null,"You need to specify the time period." );
            }else if (principal.getText().isEmpty()){
                displayError("Error",null,"You need to specify the principal investment." );
            }
            pbp = null;
        }
        return pbp;
    }

    public static InputNPV getNetPresentValueInput(Scene scene){
        InputNPV npv;
        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIODS);
        TextField principal = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PRINCIPAL);
        TextField interest = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_INTEREST_RATE);
        TextField tax = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_TAX_RATE);
        TextField salvage = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_SALVAGE_VALUE);
        TextField salvagePeriod = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIOD_SV);

        try {
            int per = Integer.parseInt(periods.getText());
            float pri = Float.parseFloat(principal.getText());
            float inte = Float.parseFloat(interest.getText());
            float taxes = Float.parseFloat(tax.getText());
            float salv = Float.parseFloat(salvage.getText());
            int salvp = Integer.parseInt(salvagePeriod.getText());

            if (salvp > per){
                displayError("Error",null,"The salvage period can't be greater than the period" );
                npv = null;
            }else {
                npv = new InputNPV(per, pri, inte, taxes, salv, salvp);
            }

        }catch (NumberFormatException nfe){
            displayError("Error",null,"Period, Principal, Interest rate, Tax rate, Salvage value and Salvage period must be numbers" );
            npv= null;
        }

        return npv;
    }

    public static InputDEP getDepreciationInput(Scene scene){
        InputDEP dep;
        TextField periodsTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIODS);
        TextField principalTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PRINCIPAL);
        TextField taxTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_TAX_RATE);
        TextField salvageValueTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_SALVAGE_VALUE);
        TextField periodSVTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIOD_SV);
        ChoiceBox<String> categoryCB = (ChoiceBox<String>) scene.lookup(CNodeID.COMBOBOX_DEP_CATEGORY);
        TextField startingYearTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_STARTING_YEAR);

        try {
            int periods = Integer.parseInt(periodsTF.getText());
            float principal = Float.parseFloat(principalTF.getText());
            float tax = Float.parseFloat(taxTF.getText());
            float salvageValue = Float.parseFloat(salvageValueTF.getText());
            int periodSV = Integer.parseInt(periodSVTF.getText());
            String category = categoryCB.getValue();
            int startingYear = Integer.parseInt(startingYearTF.getText());

            if(periodSV <= periods ) {
                if(startingYear <= periods){
                    dep = new InputDEP(periods, principal, tax, salvageValue, periodSV, category, startingYear);
                }else{
                    displayError("Error", null,"The starting year can't be greater than the period");
                    dep = null;
                }
            }else {
                displayError("Error", null,"The salvage period can't be greater than the period");
                dep = null;
            }
        }catch (NumberFormatException nfe){
            displayError("Error",null,"Period, Principal, Tax rate, Salvage value, salvage period and Starting year must be numbers" );
            return null;
        }
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
            displayError("Error",null,"All Outflows in the table must be numbers" );
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
            displayError("Error",null,"All Inflows in the table must be numbers" );
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
            displayError("Error",null,"All Outflows in the table must be numbers" );
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
            displayError("Error",null,"All Inflows in the table must be numbers" );
        }
        return inflows;
    }


    public static void displayError(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();

    }public static void displayAlert(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static String getProjectName(Scene scene){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);

        return projectName.getText();

    }
    public static String getProjectEvaluator(Scene scene){
        TextField evaluatorName = (TextField) scene.lookup(CNodeID.TEXTFIELD_EVALUATOR_NAME);
        return evaluatorName.getText();

    }
    public static CheckListResult  getChecklist(Scene scene) {
        TableView<RowChecklist> table = (TableView<RowChecklist>) scene.lookup(CNodeID.TABLE_CHECKLIST);
        ObservableList<RowChecklist> rows = table.getItems();
        TextField text1 = (TextField) rows.get(0).getAnswer();
        ChoiceBox<String> choice1 = (ChoiceBox<String>) rows.get(1).getAnswer();
        ChoiceBox<String> choice2 = (ChoiceBox<String>) rows.get(2).getAnswer();
        TextField text2 = (TextField) rows.get(3).getAnswer();
        TextField text3 = (TextField) rows.get(4).getAnswer();
        TextField text4 = (TextField) rows.get(5).getAnswer();
        TextField text5 = (TextField) rows.get(6).getAnswer();
        TextField text6 = (TextField) rows.get(7).getAnswer();
        DatePicker datePicker = (DatePicker) rows.get(8).getAnswer();
        TextArea textArea = (TextArea) rows.get(9).getAnswer();
        ComboBox<String> choice3 = (ComboBox<String>) rows.get(10).getAnswer();
        ChoiceBox<String> choice4 = (ChoiceBox<String>) rows.get(11).getAnswer();
        ChoiceBox<String> choice5 = (ChoiceBox<String>) rows.get(12).getAnswer();
        ChoiceBox<String> choice6 = (ChoiceBox<String>) rows.get(13).getAnswer();
        ChoiceBox<String> choice7 = (ChoiceBox<String>) rows.get(14).getAnswer();
        ChoiceBox<String> choice8 = (ChoiceBox<String>) rows.get(15).getAnswer();
        ChoiceBox<String> choice9 = (ChoiceBox<String>) rows.get(16).getAnswer();

        CheckListResult checkListResult = new CheckListResult(text1.getText(), choice1.getValue(),choice2.getValue(),text2.getText(),text3.getText(),text4.getText(),text5.getText(),text6.getText(),datePicker.getValue().toString(),textArea.getText(),choice3.getValue(),choice4.getValue(),choice5.getValue(),choice6.getValue(),choice7.getValue(),choice8.getValue(),choice9.getValue());
        return checkListResult;
    }
}
