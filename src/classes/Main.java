package classes;

import classes.config.CNodeID;
import classes.config.CResource;
import classes.config.CWindow;
import classes.control.ButtonAction;
import classes.control.SetData;
import classes.control.TableAction;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox root = FXMLLoader.load(getClass().getResource(CResource.FXML_MAIN_WINDOW));
        Scene scene = new Scene(root, CWindow.W_WIDTH, CWindow.W_HEIGHT);
        primaryStage.setTitle(CWindow.W_MAIN_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();

        ChoiceBox<String> category = (ChoiceBox<String>) scene.lookup(CNodeID.COMBOBOX_DEP_CATEGORY);
        category.getItems().addAll("3 Years","5 Years","7 Years","10 Years","15 Years","20 Years");
        category.setValue("3 Years");


        TableAction.initTablePBP(scene);
        TableAction.initTableNPV(scene);
        TableAction.initTableDEP(scene);
        TableAction.initTableChecklist(scene);

        ButtonAction.initPBPButtons(scene);
        ButtonAction.initNPVButtons(scene);
        ButtonAction.initDEPButtons(scene);
        ButtonAction.initMenu(scene);

        SetData.clearDepreciation(scene);
        SetData.clearNetPresentValue(scene);
        SetData.clearPayBackPeriod(scene);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
