package classes.control;

import javafx.scene.Scene;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Erik on 23/04/2017.
 */
public class Save {

    public static int saveAll(Scene scene){
        String projectName =  GetData.getProjectName(scene);
        if(projectName.isEmpty()){
            GetData.displayError("Error",null,"The project must have a name");
            return -1;
        }else {
            try {
                File file = new File(projectName + ".txt");
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                pw.println(projectName + " " + GetData.getProjectEvaluator(scene));
                pw.println(GetData.getPayBackPeriodInput(scene).toString());
                pw.println(arrayToString(GetData.getPBPInflows(scene)));
                pw.println(arrayToString(GetData.getPBPOutflows(scene)));
                pw.println(GetData.getNetPresentValueInput(scene).toString());
                pw.println(arrayToString(GetData.getNPVInflows(scene)));
                pw.println(arrayToString(GetData.getNPVOutflows(scene)));
                pw.println(GetData.getDepreciationInput(scene).toString());
                pw.println(GetData.getChecklist(scene).toString());
                pw.close();
                GetData.displayAlert("Save successful",null,"The project "+projectName+" was successfully saved");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
       /* SaveNpv(scene);
        SavePbp(scene);*/
            return 0;
        }
    }

    public static String arrayToString(ArrayList<Float> arrayList){
        String string= arrayList.get(0)+"";
        for(int i = 1; i < arrayList.size();i++){
            string = string+" "+arrayList.get(i);
        }
        return string;
    }
}
