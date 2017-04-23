package classes;

import classes.config.CNodeID;
import classes.config.CResource;
import classes.config.CWindow;
import classes.control.ButtonAction;
import classes.control.GetData;
import classes.control.SetData;
import classes.tablemodel.RowPBP;
import classes.control.TableAction;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//
import javafx.scene.control.TableView;

public class Example extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox root = FXMLLoader.load(getClass().getResource(CResource.FXML_MAIN_WINDOW));
        Scene scene = new Scene(root, CWindow.W_WIDTH, CWindow.W_HEIGHT);
        primaryStage.setTitle(CWindow.W_MAIN_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();


        SetData setData = new SetData();
        setData.setPayBackPeriod(scene,"0","0","0");
        /*
        Label l = (Label)scene.lookup(CNodeID.LABEL_SYSTEM_MESSAGE);

        l.setTooltip(
                new Tooltip("This is where the feedback will be displayed.")
        );

        TextField erik = (TextField) scene.lookup(CNodeID.TEXTFIELD_PBP_PRINCIPAL);
        erik.setText("Holas erikson");
        */

        Button b = (Button) scene.lookup(CNodeID.BUTTON_PBP_CALCULATE);
        b.setOnAction( e -> calculate(scene));

        Button b1 = (Button) scene.lookup(CNodeID.BUTTON_PBP_CLEAR);
        b1.setOnAction( e -> clear(scene));

        TableAction.initTablePBP(scene);
        TableAction.initTableNPV(scene);
        TableAction.initTableDEP(scene);
        TableAction.initTableChecklist(scene);
        ButtonAction.initPBPButtons(scene);
    }

    public static void calculate(Scene scene){
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            RowPBP row = rows.get(i);
            float inflow = Float.parseFloat(row.getInflow().getText());
            float outflow = Float.parseFloat(row.getOutflow().getText());
            row.setCumulativeCashFlow(""+(inflow-outflow));
        }

    }

    public static void clear(Scene scene){
        SetData setData = new SetData();
        TableView<RowPBP> table = (TableView<RowPBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<RowPBP> rows = table.getItems();
        rows.clear();
        setData.setPayBackPeriod(scene,"0","0","0");
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}

