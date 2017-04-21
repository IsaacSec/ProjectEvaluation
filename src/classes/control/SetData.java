package classes.control;

import classes.config.CNodeID;
import classes.tablemodel.RowNPV;
import classes.tablemodel.RowPBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
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
    public void payBackPeriod(Scene scene, String period,String principal, String interest){
        TextField periods = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        TextField principalTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PRINCIPAL);
        TextField interestTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_INTEREST_RATE);
        periods.setText(period);
        principalTF.setText(principal);
        interestTF.setText(interest);
    }

    /**
     * Clear all the data in the Pay Back Period Tab
     *
     */
    public void payBackPeriodClear(Scene scene){
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
    public void setPBPTable(Scene scene){
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowPBP row = rows.get(i);
            row.setInflows("0");
            row.setOutflows("0");
        }
    }

    /**
     *  Set the cumulative cash flow in the tabla.
     * @param scene The current scene of Javafx
     * @param cashFlow Array list of Float containing the cash flows results.
     *
     */
    public void setCumulativeCashFlow(Scene scene, ArrayList<Float> cashFlow){
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowPBP row = rows.get(i);
            if(cashFlow.get(i) > 0);//TODO Add change color function
            row.setCumulativeCashFlow(""+ cashFlow.get(i));
        }
    }

    public void netPresentValueClear(Scene scene){
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
}
