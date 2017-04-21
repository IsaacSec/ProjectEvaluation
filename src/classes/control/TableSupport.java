package classes.control;

import classes.config.CNodeID;
import classes.config.CResource;
import classes.tablemodel.TableChecklist;
import classes.tablemodel.TableDEP;
import classes.tablemodel.TableNPV;
import classes.tablemodel.TablePBP;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TableSupport {

    public static void initTablePBP(Scene scene){

        TableView<TablePBP> table = (TableView<TablePBP>) scene.lookup((CNodeID.TABLE_PBP_CASHFLOW));
        TableColumn period = table.getColumns().get(0);
        TableColumn outflows = table.getColumns().get(1);
        TableColumn inflows = table.getColumns().get(2);
        TableColumn cumulative = table.getColumns().get(3);

        period.setCellValueFactory(new PropertyValueFactory<TablePBP, String>("period"));
        inflows.setCellValueFactory(new PropertyValueFactory<TablePBP, TextField>("inflows"));
        outflows.setCellValueFactory(new PropertyValueFactory<TablePBP, String>("outflows"));
        cumulative.setCellValueFactory(new PropertyValueFactory<TablePBP, String>("cumulativeCashFlow"));


        //inflows.setCellFactory(TextFieldTableCell.forTableColumn());
        //outflows.setCellFactory(TextFieldTableCell.forTableColumn());

        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        tf.setOnAction(e -> displayPBPRows(scene, table));
    }

    private static void displayPBPRows(Scene scene, TableView<TablePBP> table){
        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PERIODS);
        int periods;
        ObservableList<TablePBP> data = table.getItems();

        try{
            periods = Integer.parseInt(tf.getText());
        }catch (NumberFormatException nfe){
            return;
        }

        for(int i=data.size(); i<=periods; i++){
            data.add(new TablePBP(""+i,"","",""));
        }
    }

    public static void initTableNPV(Scene scene){
        TableView<TableNPV> table = (TableView<TableNPV>) scene.lookup((CNodeID.TABLE_NPV));

        TableColumn period = table.getColumns().get(0);
        TableColumn outflows = table.getColumns().get(1);
        TableColumn inflows = table.getColumns().get(2);
        TableColumn netCash = table.getColumns().get(3);
        TableColumn cumulative = table.getColumns().get(4);

        period.setCellValueFactory(new PropertyValueFactory<TableNPV, String>("period"));
        outflows.setCellValueFactory(new PropertyValueFactory<TableNPV, TextField>("outflows"));
        inflows.setCellValueFactory(new PropertyValueFactory<TableNPV, TextField>("inflows"));
        netCash.setCellValueFactory(new PropertyValueFactory<TableNPV, String>("netCashFlow"));
        cumulative.setCellValueFactory(new PropertyValueFactory<TableNPV, String>("cumulativeCashFlow"));

        //outflows.setCellFactory(TextFieldTableCell.forTableColumn());
        //inflows.setCellFactory(TextFieldTableCell.forTableColumn());

        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIODS);
        tf.setOnAction(e -> displayNPVRows(scene, table));
    }

    private static void displayNPVRows(Scene scene, TableView<TableNPV> table){
        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_NPV_PERIODS);
        int periods;
        ObservableList<TableNPV> data = table.getItems();

        try{
            periods = Integer.parseInt(tf.getText());
        }catch (NumberFormatException nfe){
            return;
        }

        for(int i=data.size(); i<periods; i++){
            data.add(new TableNPV(""+(i+1),"","","",""));
        }
    }

    public static void initTableDEP(Scene scene){
        TableView<TableDEP> table = (TableView<TableDEP>) scene.lookup((CNodeID.TABLE_DEP));

        TableColumn period = table.getColumns().get(0);
        TableColumn years = table.getColumns().get(1);
        TableColumn depRate = table.getColumns().get(2);
        TableColumn annualDep = table.getColumns().get(3);
        TableColumn accDep = table.getColumns().get(4);
        TableColumn ledgers = table.getColumns().get(5);
        TableColumn taxYear = table.getColumns().get(6);

        period.setCellValueFactory(new PropertyValueFactory<TableDEP, String>("period"));
        years.setCellValueFactory(new PropertyValueFactory<TableDEP, String>("years"));
        depRate.setCellValueFactory(new PropertyValueFactory<TableDEP, String>("depreciationRate"));
        annualDep.setCellValueFactory(new PropertyValueFactory<TableDEP, String>("annualDepreciation"));
        accDep.setCellValueFactory(new PropertyValueFactory<TableDEP, String>("accumulativeDepreciation"));
        ledgers.setCellValueFactory(new PropertyValueFactory<TableDEP, String>("valueLedgers"));
        taxYear.setCellValueFactory(new PropertyValueFactory<TableDEP, String>("taxPerYear"));

        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIODS);
        tf.setOnAction(e -> displayDEPRows(scene, table));
    }

    private static void displayDEPRows(Scene scene, TableView<TableDEP> table){
        TextField tf = (TextField) scene.lookup(CNodeID.TEXTFIELD_DEP_PERIODS);
        int periods;
        ObservableList<TableDEP> data = table.getItems();

        try{
            periods = Integer.parseInt(tf.getText());
        }catch (NumberFormatException nfe){
            return;
        }

        for(int i=data.size(); i<=periods; i++){
            data.add(new TableDEP(""+(i+1),"","","","","",""));
        }
    }

    public static void initTableChecklist(Scene scene){
        TableView<TableChecklist> table = (TableView<TableChecklist>) scene.lookup((CNodeID.TABLE_CHECKLIST));

        TableColumn topic = table.getColumns().get(0);
        TableColumn question = table.getColumns().get(1);
        TableColumn answer = table.getColumns().get(2);

        topic.setCellValueFactory(new PropertyValueFactory<TableChecklist, String>("topic"));
        question.setCellValueFactory(new PropertyValueFactory<TableChecklist, String>("question"));
        answer.setCellValueFactory(new PropertyValueFactory<TableChecklist, String>("answer"));

        answer.setCellFactory(TextFieldTableCell.forTableColumn());

        displayChecklistResources(scene,table);
    }

    private static void displayChecklistResources(Scene scene, TableView<TableChecklist> table){
        ObservableList<TableChecklist> data = table.getItems();
        String[][] resources = CResource.checklistResources;

        for(int i=0; i<resources.length; i++){
            String topic = resources[i][0];
            String question = resources[i][1];
            data.add(new TableChecklist(topic, question, ""));
        }
    }
}
