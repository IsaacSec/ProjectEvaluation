package classes;

import classes.config.CNodeID;
import classes.config.CResource;
import classes.config.CWindow;
import classes.control.ButtonSupport;
import classes.control.TableSupport;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

        TableSupport.initTablePBP(scene);
        TableSupport.initTableNPV(scene);
        TableSupport.initTableDEP(scene);
        TableSupport.initTableChecklist(scene);

        ButtonSupport.initPBPButtons(scene);
        ButtonSupport.initNPVButtons(scene);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
