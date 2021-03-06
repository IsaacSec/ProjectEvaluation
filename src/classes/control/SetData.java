package classes.control;

import classes.config.CNodeID;
import classes.screening.DEPResult;
import classes.tablemodel.RowChecklist;
import classes.tablemodel.RowDEP;
import classes.tablemodel.RowNPV;
import classes.tablemodel.RowPBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

        periods.setText("0");
        principalTF.setText("0");
        interestTF.setText("0");
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

    public static void setNPVNetPresentValue(Scene scene, float result){
        TextField tfResult = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_RESULT);
        tfResult.setText(""+result);
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

        periods.setText("0");
        principalTF.setText("0");
        interestTF.setText("0");
        taxTF.setText("0");
        salvageTF.setText("0");
        periodSVTF.setText("0");
        npvresultTF.setText("0");
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

        periods.setText("0");
        principal.setText("0");
        tax.setText("0");
        salvageValue.setText("0");
        periodSV.setText("0");
        category.setValue("3 Years");
        startingYear.setText("0");

    }


    public static void setPBPTableValues(Scene scene, ArrayList<String> inflows, ArrayList<String> outflows){
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowPBP row = rows.get(i);
            row.setInflow(inflows.get(i));
            row.setOutflow(outflows.get(i));
        }
    }

    public static void setNPVTableValues(Scene scene,  ArrayList<String> inflows, ArrayList<String> outflows){
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<RowNPV> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowNPV row = rows.get(i);
            row.setInflow(inflows.get(i));
            row.setOutflow(outflows.get(i));
        }
    }

    public static void setDepreciation(Scene scene, String period, String principal, String tax , String salvage, String salvagePeriod, String category, String year){
        TextField periodsTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIODS);
        TextField principalTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PRINCIPAL);
        TextField taxTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_TAX_RATE);
        TextField salvageValueTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_SALVAGE_VALUE);
        TextField periodSVTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIOD_SV);
        ChoiceBox<String> categoryCB = (ChoiceBox<String>) scene.lookup(CNodeID.COMBOBOX_DEP_CATEGORY);
        TextField startingYearTF = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_STARTING_YEAR);

        periodsTF.setText(period);
        principalTF.setText(principal);
        taxTF.setText(tax);
        salvageValueTF.setText(salvage);
        periodSVTF.setText(salvagePeriod);
        categoryCB.setValue(category);
        startingYearTF.setText(year);

    }

    public static void setProjectInfo(Scene scene, String nameString, String evaluationString){
        TextField projectName = (TextField) scene.lookup(CNodeID.TEXTFIELD_PROJECT_NAME);
        TextField evaluatorName = (TextField) scene.lookup(CNodeID.TEXTFIELD_EVALUATOR_NAME);

        projectName.setText(nameString);
        evaluatorName.setText(evaluationString);
    }

    public static void setCheckList(Scene scene, String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9,String str10, String str11,String str12,String str13,String str14,String str15,String str16, String str17) {
        TableView<RowChecklist> table = (TableView<RowChecklist>) scene.lookup(CNodeID.TABLE_CHECKLIST);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(str9, formatter);
        ObservableList<RowChecklist> rows = table.getItems();
        TextField text1 = (TextField) rows.get(0).getAnswer();
        ComboBox<String> choice1 = (ComboBox<String>) rows.get(1).getAnswer();
        ComboBox<String> choice2 = (ComboBox<String>) rows.get(2).getAnswer();
        TextField text2 = (TextField) rows.get(3).getAnswer();
        TextField text3 = (TextField) rows.get(4).getAnswer();
        TextField text4 = (TextField) rows.get(5).getAnswer();
        TextField text5 = (TextField) rows.get(6).getAnswer();
        TextField text6 = (TextField) rows.get(7).getAnswer();
        DatePicker datePicker = (DatePicker) rows.get(8).getAnswer();
        TextArea textArea = (TextArea) rows.get(9).getAnswer();
        ComboBox<String> choice3 = (ComboBox<String>) rows.get(10).getAnswer();
        ComboBox<String> choice4 = (ComboBox<String>) rows.get(11).getAnswer();
        ComboBox<String> choice5 = (ComboBox<String>) rows.get(12).getAnswer();
        ComboBox<String> choice6 = (ComboBox<String>) rows.get(13).getAnswer();
        ComboBox<String> choice7 = (ComboBox<String>) rows.get(14).getAnswer();
        ComboBox<String> choice8 = (ComboBox<String>) rows.get(15).getAnswer();
        ComboBox<String> choice9 = (ComboBox<String>) rows.get(16).getAnswer();

        text1.setText(str1);
        choice1.setValue(str2);
        choice2.setValue(str3);
        text2.setText(str4);
        text3.setText(str5);
        text4.setText(str6);
        text5.setText(str7);
        text6.setText(str8);
        datePicker.setValue(localDate);
        textArea.setText(str10);
        choice3.setValue(str11);
        choice4.setValue(str12);
        choice5.setValue(str13);
        choice6.setValue(str14);
        choice7.setValue(str15);
        choice8.setValue(str16);
        choice9.setValue(str17);
    }
}
