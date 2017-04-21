package classes.control;

import classes.GetData;
import classes.SetData;
import classes.config.CNodeID;
import classes.screening.*;
import classes.tablemodel.TableNPV;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ButtonSupport {
    public static void initPBPButtons(Scene scene){
        Button calculate = (Button) scene.lookup(CNodeID.BUTTON_PBP_CALCULATE);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_PBP_CLEAR);

        calculate.setOnAction(e -> calculatePBP(scene));
        clear.setOnAction(e -> clearPBP(scene));
    }

    private static void calculatePBP(Scene scene){
        GetData getData = new GetData();
        SetData setData = new SetData();
        EvaluationMethods eval = new EvaluationMethods();

        PayBackPeriod pbp = getData.payBackPeriod(scene);
        ArrayList<Float> cumulative = eval.calculatePBP(pbp,getData.getOutflows(scene),getData.getInflows(scene));
        setData.setCumulativeCashFlow(scene,cumulative);
    }

    private  static void clearPBP(Scene scene){
        SetData setData = new SetData();
        setData.payBackPeriodClear(scene);
    }

    public static void initNPVButtons(Scene scene){
        Button calculate = (Button) scene.lookup(CNodeID.BUTTON_NPV_CALCULATE);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_NPV_CLEAR);

        calculate.setOnAction(e -> calculateNPV(scene));
        clear.setOnAction(e -> clearNPV(scene));
    }

    private static void calculateNPV(Scene scene){
        GetData getData = new GetData();
        SetData setData = new SetData();
        NPVEvaluation npvEval = new NPVEvaluation();
        NetPresentValue npv = getData.netPresentValue(scene);
        NPVResult result = npvEval.calculateNPV(npv.getPeriods(), npv.getPrincipal(), npv.getInterest(), npv.getTax(),npv.getSalvage(),npv.getSalvagePeriod(),
                                                getData.getNPVInflows(scene),getData.getNPVOutflows(scene));
        //This will be move to SetData class
        TextField tfNPV = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_RESULT);
        tfNPV.setText(""+result.getNetPresentValue());

        TableView<TableNPV> table = (TableView<TableNPV>) scene.lookup(CNodeID.TABLE_NPV);
        ObservableList<TableNPV> rows = table.getItems();
        ArrayList<Float> cumulative = result.getCumulativeCashFlowValues();
        ArrayList<Float> netcash = result.getNetCashFlowValues();

        for (int i=0; i<rows.size(); i++){
            TableNPV row = rows.get(i);
            row.setCumulativeCashFlow(""+cumulative.get(i));
            row.setNetCashFlow(""+netcash.get(i));
        }
    }

    private static void clearNPV(Scene scene){
        SetData setData = new SetData();
        setData.netPresentValueClear(scene);
    }
}
