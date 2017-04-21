package classes;

import classes.config.CNodeID;
import classes.config.CResource;
import classes.config.CWindow;
import classes.control.ButtonSupport;
import classes.tablemodel.TablePBP;
import classes.control.TableSupport;
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

        TableSupport.initTablePBP(scene);
        TableSupport.initTableNPV(scene);
        TableSupport.initTableDEP(scene);
        TableSupport.initTableChecklist(scene);
        ButtonSupport.initPBPButtons(scene);
    }

    public static void calculate(Scene scene){
        TableView<TablePBP> table = (TableView<TablePBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<TablePBP> rows = table.getItems();
        int size = rows.size();

        for (int i=0; i<size; i++){
            TablePBP row = rows.get(i);
            float inflow = Float.parseFloat(row.getInflows().getText());
            float outflow = Float.parseFloat(row.getOutflows().getText());
            row.setCumulativeCashFlow(""+(inflow-outflow));
        }

    }

    public static void clear(Scene scene){
        TableView<TablePBP> table = (TableView<TablePBP>) scene.lookup(CNodeID.TABLE_PBP_CASHFLOW);
        ObservableList<TablePBP> rows = table.getItems();
        rows.clear();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}

