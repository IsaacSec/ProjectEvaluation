package classes.control;

import classes.config.CNodeID;
import classes.screening.*;
import classes.tablemodel.RowNPV;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static classes.control.SetData.*;
import static classes.control.GetData.*;

public class ButtonAction {
    public static void initPBPButtons(Scene scene){
        Button calculate = (Button) scene.lookup(CNodeID.BUTTON_PBP_CALCULATE);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_PBP_CLEAR);

        calculate.setOnAction(e -> calculatePBP(scene));
        clear.setOnAction(e -> clearPBP(scene));
    }

    private static void calculatePBP(Scene scene){
        InputPBP inputPBP = getPayBackPeriodInput(scene);
        PBPResult pbpResult = PBPEvaluation.calculatePBP(inputPBP, getPBPOutflows(scene), getPBPInflows(scene));

        setCumulativeCashFlow(scene, pbpResult.getCumulativeCashFlow());
    }

    private  static void clearPBP(Scene scene){
        clearPayBackPeriod(scene);
    }

    public static void initNPVButtons(Scene scene){
        Button calculate = (Button) scene.lookup(CNodeID.BUTTON_NPV_CALCULATE);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_NPV_CLEAR);

        calculate.setOnAction(e -> calculateNPV(scene));
        clear.setOnAction(e -> clearNPV(scene));
    }

    private static void calculateNPV(Scene scene){
        InputNPV input = getNetPresentValueInput(scene);

        // TODO: Validate that the periodSalvage does not surpass the highest period

        NPVResult result = NPVEvaluation.calculateNPV(input, getNPVInflows(scene),getNPVOutflows(scene));

        setNPVCumulativeCashFlow(scene, result.getCumulativeCashFlowValues());
        setNPVNetCashFlow(scene, result.getNetCashFlowValues());
    }

    private static void clearNPV(Scene scene){
        clearNetPresentValue(scene);
    }
}
