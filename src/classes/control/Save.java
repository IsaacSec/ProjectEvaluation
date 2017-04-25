package classes.control;

import javafx.scene.Scene;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Erik on 23/04/2017.
 */
public class Save {

    public static int saveAll(Scene scene){
        try{
            File file = new File("prueba.txt");
            file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.println(GetData.getPayBackPeriodInput(scene).toString());
            pw.println(arrayToString(GetData.getPBPInflows(scene)));
            pw.println(arrayToString(GetData.getPBPOutflows(scene)));
            pw.println(GetData.getNetPresentValueInput(scene).toString());
            pw.println(arrayToString(GetData.getNPVInflows(scene)));
            pw.println(arrayToString(GetData.getNPVOutflows(scene)));
            pw.println(GetData.getDepreciationInput(scene).toString());
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* SaveNpv(scene);
        SavePbp(scene);*/
        return 0;
    }
    //Save all the NPV values
    public static void SaveNpv(Scene scene){
        InputNPV inputNPV = GetData.getNetPresentValueInput(scene);
        System.out.println(inputNPV.toString());

    }
    //Save all the PBP values
    public static void SavePbp(Scene scene){
        InputPBP inputPBP = GetData.getPayBackPeriodInput(scene);
        System.out.println(inputPBP.toString());

    }
    public static String arrayToString(ArrayList<Float> arrayList){
        String string= arrayList.get(0)+"";
        for(int i = 1; i < arrayList.size();i++){
            string = string+" "+arrayList.get(i);
        }
        return string;
    }
}
