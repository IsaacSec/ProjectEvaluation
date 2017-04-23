package classes.control;

import classes.config.CNodeID;
import classes.config.CResource;
import classes.tablemodel.RowChecklist;
import classes.tablemodel.RowDEP;
import classes.tablemodel.RowNPV;
import classes.tablemodel.RowPBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;

public class TableAction {

    private static final int ROW_LIMIT = 100;

    public static void initTablePBP(Scene scene){

        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup((CNodeID.TABLE_PBP_CASHFLOW));
        TableColumn period = table.getColumns().get(0);
        TableColumn outflows = table.getColumns().get(1);
        TableColumn inflows = table.getColumns().get(2);
        TableColumn cumulative = table.getColumns().get(3);

        period.setCellValueFactory(new PropertyValueFactory<RowPBP, String>("period"));
        inflows.setCellValueFactory(new PropertyValueFactory<RowPBP, TextField>("inflow"));
        outflows.setCellValueFactory(new PropertyValueFactory<RowPBP, String>("outflow"));
        cumulative.setCellValueFactory(new PropertyValueFactory<RowPBP, String>("cumulativeCashFlow"));

        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        tf.addEventHandler(KeyEvent.KEY_RELEASED, event -> displayPBPRows(scene, table));
    }

    private static void displayPBPRows(Scene scene, TableView<RowPBP> table){

        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        int periods;
        ObservableList<RowPBP> data = table.getItems();

        try{
            periods = Integer.parseInt(tf.getText());
        }catch (NumberFormatException nfe){
            return;
        }

        for(int i=data.size(); i<=periods && i<= ROW_LIMIT; i++){
            data.add(new RowPBP(""+i,"","",""));
        }

        if(data.size() > periods+1){   // +1 Because it starts from 0
            data.remove(periods, data.size());
        }

        SetData.initPBPTableValues(scene);
    }

    public static void initTableNPV(Scene scene){
        TableView<RowNPV> table = (TableView<RowNPV>) scene.lookup((CNodeID.TABLE_NPV));

        TableColumn period = table.getColumns().get(0);
        TableColumn outflows = table.getColumns().get(1);
        TableColumn inflows = table.getColumns().get(2);
        TableColumn netCash = table.getColumns().get(3);
        TableColumn cumulative = table.getColumns().get(4);

        period.setCellValueFactory(new PropertyValueFactory<RowNPV, String>("period"));
        outflows.setCellValueFactory(new PropertyValueFactory<RowNPV, TextField>("outflow"));
        inflows.setCellValueFactory(new PropertyValueFactory<RowNPV, TextField>("inflow"));
        netCash.setCellValueFactory(new PropertyValueFactory<RowNPV, String>("netCashFlow"));
        cumulative.setCellValueFactory(new PropertyValueFactory<RowNPV, String>("cumulativeCashFlow"));

        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIODS);
        tf.addEventHandler(KeyEvent.KEY_RELEASED, event -> displayNPVRows(scene, table));
    }

    private static void displayNPVRows(Scene scene, TableView<RowNPV> table){
        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIODS);
        int periods;
        ObservableList<RowNPV> data = table.getItems();

        try{
            periods = Integer.parseInt(tf.getText());
        }catch (NumberFormatException nfe){
            return;
        }

        for(int i=data.size(); i<periods && i< ROW_LIMIT; i++){
            data.add(new RowNPV(""+(i+1),"","","",""));
        }

        if(data.size() > periods){
            data.remove(periods, data.size());
        }

        SetData.initNPVTableValues(scene);
    }

    public static void initTableDEP(Scene scene){
        TableView<RowDEP> table = (TableView<RowDEP>) scene.lookup((CNodeID.TABLE_DEP));

        TableColumn period = table.getColumns().get(0);
        TableColumn years = table.getColumns().get(1);
        TableColumn depRate = table.getColumns().get(2);
        TableColumn annualDep = table.getColumns().get(3);
        TableColumn accDep = table.getColumns().get(4);
        TableColumn ledgers = table.getColumns().get(5);
        TableColumn taxYear = table.getColumns().get(6);

        period.setCellValueFactory(new PropertyValueFactory<RowDEP, String>("period"));
        years.setCellValueFactory(new PropertyValueFactory<RowDEP, String>("years"));
        depRate.setCellValueFactory(new PropertyValueFactory<RowDEP, String>("depreciationRate"));
        annualDep.setCellValueFactory(new PropertyValueFactory<RowDEP, String>("annualDepreciation"));
        accDep.setCellValueFactory(new PropertyValueFactory<RowDEP, String>("accumulativeDepreciation"));
        ledgers.setCellValueFactory(new PropertyValueFactory<RowDEP, String>("valueLedgers"));
        taxYear.setCellValueFactory(new PropertyValueFactory<RowDEP, String>("taxPerYear"));

        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIODS);
        tf.addEventHandler(KeyEvent.KEY_RELEASED, event -> displayDEPRows(scene, table));
    }

    private static void displayDEPRows(Scene scene, TableView<RowDEP> table){
        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIODS);
        int periods;
        ObservableList<RowDEP> data = table.getItems();

        try{
            periods = Integer.parseInt(tf.getText());
        }catch (NumberFormatException nfe){
            return;
        }

        for(int i=data.size(); i<=periods && i<= ROW_LIMIT; i++){
            data.add(new RowDEP(""+(i+1),"","","","","",""));
        }

        if(data.size() > periods){
            data.remove(periods, data.size());
        }
    }

    public static void initTableChecklist(Scene scene){
        TableView<RowChecklist> table = (TableView<RowChecklist>) scene.lookup((CNodeID.TABLE_CHECKLIST));

        TableColumn topic = table.getColumns().get(0);
        TableColumn question = table.getColumns().get(1);
        TableColumn answer = table.getColumns().get(2);

        topic.setCellValueFactory(new PropertyValueFactory<RowChecklist, String>("topic"));
        question.setCellValueFactory(new PropertyValueFactory<RowChecklist, String>("question"));
        answer.setCellValueFactory(new PropertyValueFactory<RowChecklist, String>("answer"));

        answer.setCellFactory(TextFieldTableCell.forTableColumn());

        displayChecklistResources(scene,table);
    }

    private static void displayChecklistResources(Scene scene, TableView<RowChecklist> table){
        ObservableList<RowChecklist> data = table.getItems();
        String[][] resources = CResource.checklistResources;

        for(int i=0; i<resources.length; i++){
            String topic = resources[i][0];
            String question = resources[i][1];
            data.add(new RowChecklist(topic, question, ""));
        }
    }
}
