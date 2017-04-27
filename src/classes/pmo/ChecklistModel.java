package classes.pmo;

import classes.config.CNodeID;
import classes.config.CResource;
import classes.tablemodel.RowChecklist;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

/**
 * Created by isaac on 4/24/17.
 */
public class ChecklistModel {

    public static void constructCheckList(Scene scene){
        TableView<RowChecklist> table = (TableView<RowChecklist>) scene.lookup(CNodeID.TABLE_CHECKLIST);
        ObservableList<RowChecklist> data = table.getItems();
        String[][] resources = CResource.checklistResources;

        // Strategy/Alignment
        RowChecklist SA1 = new RowChecklist(resources[0][0],resources[0][1], new TextField());
        data.add(SA1);
        // Driver
        ComboBox cbDR1 = new ComboBox();
        cbDR1.getItems().addAll(CResource.checkListResourcesDriver);
        cbDR1.setValue("-- Select --");
        cbDR1.setMinWidth(400);
        RowChecklist DR1 = new RowChecklist(resources[1][0],resources[1][1], cbDR1);
        data.add(DR1);
        // Success Metrics
        ComboBox cbSM1 = new ComboBox();
        cbSM1.getItems().addAll(CResource.checkListResourcesSuccessMetrics);
        cbSM1.setValue("-- Select --");
        cbSM1.setMinWidth(400);
        RowChecklist SM1 = new RowChecklist(resources[2][0],resources[2][1], cbSM1);
        data.add(SM1);
        // Sponsorship
        RowChecklist SS1 = new RowChecklist(resources[3][0],resources[3][1], new TextField());
        data.add(SS1);
        // Risk
        RowChecklist RK1 = new RowChecklist(resources[4][0],resources[4][1], new TextField());
        data.add(RK1);
        RowChecklist RK2 = new RowChecklist(resources[5][0],resources[5][1], new TextField());
        data.add(RK2);
        RowChecklist RK3 = new RowChecklist(resources[6][0],resources[6][1], new TextField());
        data.add(RK3);
        // Benefits, Value
        RowChecklist BV1 = new RowChecklist(resources[7][0],resources[7][1], new TextField());
        data.add(BV1);
        RowChecklist BV2 = new RowChecklist(resources[8][0],resources[8][1], new DatePicker());
        data.add(BV2);
        // Objectives
        RowChecklist OJ1 = new RowChecklist(resources[9][0],resources[9][1], new TextArea());
        data.add(OJ1);
        // Organization Culture
        ComboBox cbOC1 = new ComboBox();
        cbOC1.setValue("-- Select --");
        cbOC1.setMinWidth(400);
        cbOC1.getItems().addAll("Yes","No");
        RowChecklist OC1 = new RowChecklist(resources[10][0],resources[10][1], cbOC1);
        data.add(OC1);
        // Resources
        ComboBox cbRE1 = new ComboBox();
        cbRE1.setValue("-- Select --");
        cbRE1.setMinWidth(400);
        cbRE1.getItems().addAll("Yes","No");
        RowChecklist RE1 = new RowChecklist(resources[11][0],resources[11][1], cbRE1);
        data.add(RE1);
        // Approach
        ComboBox cbAP1 = new ComboBox();
        cbAP1.setValue("-- Select --");
        cbAP1.setMinWidth(400);
        cbAP1.getItems().addAll("Build","Buy");
        RowChecklist AP1 = new RowChecklist(resources[12][0],resources[12][1], cbAP1);
        data.add(AP1);
        // Schedule
        ComboBox cbSC1 = new ComboBox();
        cbSC1.setValue("-- Select --");
        cbSC1.setMinWidth(400);
        cbSC1.getItems().addAll(CResource.checkListResourcesSchedule);
        RowChecklist SC1 = new RowChecklist(resources[13][0],resources[13][1], cbSC1);
        data.add(SC1);
        ComboBox cbSC2 = new ComboBox();
        cbSC2.setValue("-- Select --");
        cbSC2.setMinWidth(400);
        cbSC2.getItems().addAll("Yes","No");
        RowChecklist SC2 = new RowChecklist(resources[14][0],resources[14][1], cbSC2);
        data.add(SC2);
        // Training/Resources
        ComboBox cbTR1 = new ComboBox();
        cbTR1.setValue("-- Select --");
        cbTR1.setMinWidth(400);
        cbTR1.getItems().addAll("Yes","No");
        RowChecklist TR1 = new RowChecklist(resources[15][0],resources[15][1], cbTR1);
        data.add(TR1);
        // Finance/Portfolio
        ComboBox cbFP1 = new ComboBox();
        cbFP1.setValue("-- Select --");
        cbFP1.setMinWidth(400);
        cbFP1.getItems().addAll("Available","New");
        RowChecklist FP1 = new RowChecklist(resources[16][0],resources[16][1], cbFP1);
        data.add(FP1);
    }

}
