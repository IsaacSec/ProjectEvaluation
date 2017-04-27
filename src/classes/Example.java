package classes;

import classes.config.CNodeID;
import classes.config.CResource;
import classes.config.CWindow;
import classes.control.ButtonAction;
import classes.control.GetData;
import classes.control.SetData;
import classes.tablemodel.RowPBP;
import classes.control.TableAction;
import classes.utils.ImageGenerator;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//
import javafx.scene.control.TableView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Example extends Application{

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

        ImageGenerator.generateSceneCharts(scene);
    }

    public void saveAsPng(Scene scene, String path) {
        System.out.println("Trying to snapshot");
        WritableImage image = scene.snapshot(null);
        File file = new File(path);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (image.getProgress() != 1){
            System.out.println(image.getProgress());
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}

