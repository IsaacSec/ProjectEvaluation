package classes.control;

import classes.config.CNodeID;
import classes.screening.*;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import static classes.control.SetData.*;
import static classes.control.GetData.*;

public class ButtonAction {

    public static void initPBPButtons(Scene scene)
    {
        Button calculate = (Button) scene.lookup(CNodeID.BUTTON_PBP_CALCULATE);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_PBP_CLEAR);

        calculate.setOnAction(e -> calculatePBP(scene));
        clear.setOnAction(e -> clearPBP(scene));
    }

    public static void calculatePBP(Scene scene)
    {
        InputPBP inputPBP = getPayBackPeriodInput(scene);
        PBPResult pbpResult = PBPEvaluation.calculatePBP(inputPBP, getPBPOutflows(scene), getPBPInflows(scene));

        if(pbpResult != null) {
            setCumulativeCashFlow(scene, pbpResult.getCumulativeCashFlow());
        }
        ChartAction.displayPBPCharts(scene);
        Save.saveAll(scene);
    }

    private static void clearPBP(Scene scene)
    {
        Load.load(scene);
        /*clearPayBackPeriod(scene);*/
    }

    public static void initNPVButtons(Scene scene)
    {
        Button calculate = (Button) scene.lookup(CNodeID.BUTTON_NPV_CALCULATE);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_NPV_CLEAR);

        calculate.setOnAction(e -> calculateNPV(scene));
        clear.setOnAction(e -> clearNPV(scene));
    }

    public static void calculateNPV(Scene scene)
    {
        InputNPV input = getNetPresentValueInput(scene);

        if(input != null) {

            NPVResult result = NPVEvaluation.calculateNPV(input, getNPVInflows(scene), getNPVOutflows(scene));

            setNPVCumulativeCashFlow(scene, result.getCumulativeCashFlowValues());
            setNPVNetCashFlow(scene, result.getNetCashFlowValues());
            setNPVNetPresentValue(scene, result.getNetPresentValue());
        }
        ChartAction.displayNPVCharts(scene);
    }

    private static void clearNPV(Scene scene)
    {
        clearNetPresentValue(scene);
    }

    public static void initDEPButtons(Scene scene)
    {
        Button straightLine = (Button) scene.lookup(CNodeID.BUTTON_DEP_STRAIGHT_LINE);
        Button macrs = (Button) scene.lookup(CNodeID.BUTTON_DEP_MACRS);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_DEP_CLEAR);

        straightLine.setOnAction(event -> calculateStraightLineDEP(scene));
        macrs.setOnAction(event -> calculateMACRS(scene));
        clear.setOnAction(event -> clearDEP(scene));
    }

    private static void calculateStraightLineDEP(Scene scene)
    {
        InputDEP input = getDepreciationInput(scene);
        if(input != null) {
            DEPResult result = DEPEvaluation.calculateStraightLine(input);

            setDepreciationResults(scene, result, input.getStartingYear());
        }
        ChartAction.displayDEPCharts(scene);
    }

    private static void calculateMACRS(Scene scene)
    {
        InputDEP input = getDepreciationInput(scene);
        if(input != null) {
            DEPResult result = DEPEvaluation.calculateMACRS(input);

            setDepreciationResults(scene, result, input.getStartingYear());
        }
        ChartAction.displayDEPCharts(scene);
    }

    private static void clearDEP(Scene scene)
    {
        clearDepreciation(scene);
    }

    public static void initMenu(Scene scene){
        MenuBar menu = (MenuBar) scene.lookup(CNodeID.MENU_BAR);
        Menu menuFile = menu.getMenus().get(0);
        MenuItem menuSave = menuFile.getItems().get(2);
        menuSave.setOnAction( e -> Save.saveAll(scene));

    }
}
