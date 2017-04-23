package classes.control;

import classes.config.CNodeID;
import classes.screening.DEPResult;
import classes.tablemodel.RowDEP;
import classes.tablemodel.RowNPV;
import classes.tablemodel.RowPBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Created by erikm on 18/04/2017.
 */
public class SetData {

    /**
     * Set the initial values of Pay Back Period text fields
     * @param scene The current scene of Javafx
     * @param period The period of the Pay Back Period
     * @param principal The principal of the Pay Back Period
     * @param interest The interest of the Pay Back Period
     */
    public static void setPayBackPeriod(Scene scene, String period,String principal, String interest){
        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        TextField principalTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PRINCIPAL);
        TextField interestTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_INTEREST_RATE);

        periods.setText(period);
        principalTF.setText(principal);
        interestTF.setText(interest);
    }

    public static void setNetPresentValue(Scene scene, String periods, String principal, String interest,
                                          String tax, String salvage, String salvagePeriod){
        TextField periodsTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIODS);
        TextField principalTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PRINCIPAL);
        TextField interestTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_INTEREST_RATE);
        TextField taxTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_TAX_RATE);
        TextField salvageTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_SALVAGE_VALUE);
        TextField periodSVTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIOD_SV);

        periodsTF.setText(periods);
        principalTF.setText(principal);
        interestTF.setText(interest);
        taxTF.setText(tax);
        salvageTF.setText(salvage);
        periodSVTF.setText(salvagePeriod);
    }

    public static void setCalculatedNetPresentValue(Scene scene, float calculatedNPV){
        //This will be move to SetData class
        TextField tfNPV = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_RESULT);
        tfNPV.setText(""+calculatedNPV);
    }

    /**
     * Clear all the data in the Pay Back Period Tab
     *
     */
    public static void clearPayBackPeriod(Scene scene){
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        table.getItems().clear();

        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        TextField principalTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PRINCIPAL);
        TextField interestTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_INTEREST_RATE);

        periods.setText("");
        principalTF.setText("");
        interestTF.setText("");
    }

    /**
     * @param scene The current scene of Javafx
     * Initialize the Pay Back Period Inflows and Outflows with 0.
     */
    public static void initPBPTableValues(Scene scene){
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowPBP row = rows.get(i);
            row.setInflow("0");
            row.setOutflow("0");
        }
    }

    public static void initNPVTableValues(Scene scene){
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<RowNPV> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowNPV row = rows.get(i);
            row.setInflow("0");
            row.setOutflow("0");
        }
    }

    /**
     *  Set the cumulative cash flow in the tabla.
     * @param scene The current scene of Javafx
     * @param cashFlow Array list of Float containing the cash flows results.
     *
     */
    public static void setCumulativeCashFlow(Scene scene, ArrayList<Float> cashFlow){
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowPBP row = rows.get(i);
            if(cashFlow.get(i) > 0);//TODO Add change color function
            row.setCumulativeCashFlow(""+ cashFlow.get(i));
        }
    }

    public static void setNPVCumulativeCashFlow(Scene scene, ArrayList<Float> cumulativeCash){
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<RowNPV> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowNPV row = rows.get(i);
            row.setCumulativeCashFlow(""+ cumulativeCash.get(i));
        }
    }

    public static void setNPVNetCashFlow(Scene scene, ArrayList<Float> netCash){
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<RowNPV> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowNPV row = rows.get(i);
            row.setNetCashFlow(""+ netCash.get(i));
        }
    }

    public static void setDepreciationResults(Scene scene, DEPResult result, int startingYear){
        TableView<RowDEP> table = (TableView<RowDEP>) scene.lookup(CNodeID.TABLE_DEP);
        ObservableList<RowDEP> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowDEP row = rows.get(i);
            row.setYears(""+(startingYear+i));
            row.setDepreciationRate(""+result.getDepreciationRate().get(i));
            row.setAnnualDepreciation(""+result.getAnnualDepreciation().get(i));
            row.setAccumulativeDepreciation(""+result.getAccumulatedDepreciation().get(i));
            row.setValueLedgers(""+result.getLedgerValues().get(i));
            row.setTaxPerYear(""+result.getTaxPerYear().get(i));
        }
    }

    public static void clearNetPresentValue(Scene scene){
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup(CNodeID.TABLE_NPV);
        table.getItems().clear();

        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIODS);
        TextField principalTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PRINCIPAL);
        TextField interestTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_INTEREST_RATE);
        TextField taxTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_TAX_RATE);
        TextField salvageTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_SALVAGE_VALUE);
        TextField periodSVTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIOD_SV);
        TextField npvresultTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_RESULT);

        periods.setText("");
        principalTF.setText("");
        interestTF.setText("");
        taxTF.setText("");
        salvageTF.setText("");
        periodSVTF.setText("");
        npvresultTF.setText("");
    }

    public static void clearDepreciation(Scene scene){
        TableView<RowDEP> table = (TableView<RowDEP>) scene.lookup(CNodeID.TABLE_DEP);
        table.getItems().clear();

        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIODS);
        TextField principal = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PRINCIPAL);
        TextField tax = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_TAX_RATE);
        TextField salvageValue = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_SALVAGE_VALUE);
        TextField periodSV = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIOD_SV);
        ChoiceBox<String> category = (ChoiceBox<String>) scene.lookup(CNodeID.COMBOBOX_DEP_CATEGORY);
        TextField startingYear = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_STARTING_YEAR);

        periods.setText("");
        principal.setText("");
        tax.setText("");
        salvageValue.setText("");
        periodSV.setText("");
        category.setValue("3 Years");
        startingYear.setText("");
    }

    // TODO: method setEmptyPBPTableValues() that fills empty cells (PBP) with 0
    // TODO: method setEmptyNPVTableValues() that fills empty cells (NPV) with 0
}
