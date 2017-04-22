package classes;

import classes.config.CResource;
import classes.config.CWindow;
import classes.control.ButtonAction;
import classes.control.TableAction;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

        TableAction.initTablePBP(scene);
        TableAction.initTableNPV(scene);
        TableAction.initTableDEP(scene);
        TableAction.initTableChecklist(scene);

        ButtonAction.initPBPButtons(scene);
        ButtonAction.initNPVButtons(scene);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
