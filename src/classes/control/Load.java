package classes.control;

import classes.config.CNodeID;
import classes.tablemodel.RowDEP;
import classes.tablemodel.RowNPV;
import classes.tablemodel.RowPBP;
import javafx.scene.Scene;

import javax.swing.text.TableView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Erik on 24/04/2017.
 */
public class Load {

    public static void load(Scene scene){
        String projectName =  GetData.getProjectName(scene);
        try {
            javafx.scene.control.TableView<RowPBP> table = (javafx.scene.control.TableView<RowPBP>) scene.lookup((CNodeID.TABLE_PBP_CASHFLOW));
            javafx.scene.control.TableView<RowNPV> tableNpv = (javafx.scene.control.TableView<RowNPV>) scene.lookup((CNodeID.TABLE_NPV));
            javafx.scene.control.TableView<RowDEP> tableDep = (javafx.scene.control.TableView<RowDEP>) scene.lookup((CNodeID.TABLE_DEP));
            FileReader fileReader = new FileReader(projectName+".txt");
            BufferedReader bf = new BufferedReader(fileReader);
            StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine()," ");
            SetData.setProjectInfo(scene, stringTokenizer.nextToken(),stringTokenizer.nextToken());
            StringTokenizer str = new StringTokenizer(bf.readLine()," ");
            SetData.setPayBackPeriod(scene, str.nextToken(), str.nextToken(), str.nextToken());
            TableAction.displayPBPRows(scene,table);
            SetData.setPBPTableValues(scene,toArray(bf.readLine()),toArray(bf.readLine()));
            StringTokenizer str2 = new StringTokenizer(bf.readLine()," ");
            SetData.setNetPresentValue(scene, str2.nextToken(),str2.nextToken(),str2.nextToken(),str2.nextToken(),str2.nextToken(),str2.nextToken());
            TableAction.displayNPVRows(scene,tableNpv);
            SetData.setNPVTableValues(scene, toArray(bf.readLine()), toArray(bf.readLine()));
            StringTokenizer str3 = new StringTokenizer(bf.readLine()," ");
            SetData.setDepreciation(scene, str3.nextToken(),str3.nextToken(),str3.nextToken(),str3.nextToken(),str3.nextToken(),str3.nextToken()+" "+str3.nextToken(),str3.nextToken());
            TableAction.displayDEPRows(scene,tableDep);
            StringTokenizer str4 = new StringTokenizer(bf.readLine(),"*");
            SetData.setCheckList(scene,str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken(),str4.nextToken());
            ScreeningMatrixControl.setMatrixString(bf.readLine());
            bf.close();
            ButtonAction.calculateNPV(scene);
            ButtonAction.calculatePBP(scene);
            ScreeningMatrixControl matrixControl =  new ScreeningMatrixControl(scene);
            matrixControl.analyse();
            GetData.displayAlert("Load successful",null,"The project "+projectName+" was successfully loaded");

        } catch (FileNotFoundException e) {
            GetData.displayError("Error","File not found", "Please make sure the project name is correct");
           // e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> toArray(String line){
        ArrayList<String> arrayList=new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(line , " ");
        while (stringTokenizer.hasMoreTokens()){
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }
}
