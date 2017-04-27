package classes.control;

import classes.config.CNodeID;
import classes.screening.*;
import javafx.scene.Scene;
import javafx.scene.control.*;

import static classes.control.SetData.*;
import static classes.control.GetData.*;
import static classes.utils.ReportGenerator.*;

public class ButtonAction {

    public static void initPBPButtons(Scene scene)
    {
        Button calculate = (Button) scene.lookup(CNodeID.BUTTON_PBP_CALCULATE);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_PBP_CLEAR);
        Button report = (Button) scene.lookup(CNodeID.BUTTON_PBP_GENERATE_REPORT);

        calculate.setOnAction(e -> calculatePBP(scene));
        clear.setOnAction(e -> clearPBP(scene));
        report.setOnAction(e -> generatePBPReport(scene));
    }

    public static void calculatePBP(Scene scene)
    {
        InputPBP inputPBP = getPayBackPeriodInput(scene);
        PBPResult pbpResult = PBPEvaluation.calculatePBP(inputPBP, getPBPOutflows(scene), getPBPInflows(scene));

        if(pbpResult != null) {
            setCumulativeCashFlow(scene, pbpResult.getCumulativeCashFlow());
        }
        ChartAction.displayPBPCharts(scene);
    }

    private static void clearPBP(Scene scene)
    {
        clearPayBackPeriod(scene);
    }

    public static void initNPVButtons(Scene scene)
    {
        Button calculate = (Button) scene.lookup(CNodeID.BUTTON_NPV_CALCULATE);
        Button clear = (Button) scene.lookup(CNodeID.BUTTON_NPV_CLEAR);
        Button report = (Button) scene.lookup(CNodeID.BUTTON_NPV_GENERATE_REPORT);

        calculate.setOnAction(e -> calculateNPV(scene));
        clear.setOnAction(e -> clearNPV(scene));
        report.setOnAction(e -> generateNPVReport(scene));
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
        Button report = (Button) scene.lookup(CNodeID.BUTTON_DEP_GENERATE_REPORT);

        straightLine.setOnAction(event -> calculateStraightLineDEP(scene));
        macrs.setOnAction(event -> calculateMACRS(scene));
        clear.setOnAction(event -> clearDEP(scene));
        report.setOnAction(e -> generateDEPReport(scene));
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
        MenuItem menuNew = menuFile.getItems().get(0);
        MenuItem menuOpen = menuFile.getItems().get(1);
        MenuItem menuSave = menuFile.getItems().get(2);
        MenuItem menuClose = menuFile.getItems().get(3);

        menuNew.setOnAction( e ->clearAll(scene) );
        menuOpen.setOnAction(e -> Load.load(scene));
        menuSave.setOnAction( e -> Save.saveAll(scene));
        menuClose.setOnAction( e -> clearAll(scene));

    }
    public static void clearAll(Scene scene){
        clearDEP(scene);
        clearNPV(scene);
        clearPBP(scene);
        SetData.setProjectInfo(scene,"","");

    }
}
