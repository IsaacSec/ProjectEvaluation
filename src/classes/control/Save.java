package classes.control;

import javafx.scene.Scene;

import java.io.BufferedWriter;

/**
 * Created by Erik on 23/04/2017.
 */
public class Save {

    public static int saveAll(Scene scene){
        SaveNpv(scene);
        SavePbp(scene);
        return 0;
    }
    //Save all the NPV values
    public static void SaveNpv(Scene scene){
        InputNPV inputNPV = GetData.getNetPresentValueInput(scene);
        System.out.println(inputNPV.toString());
        //BufferedWriter bufferedWriter = new BufferedWriter();
    }
    //Save all the PBP values
    public static void SavePbp(Scene scene){
        InputPBP inputPBP = GetData.getPayBackPeriodInput(scene);
        System.out.println(inputPBP.toString());
        //BufferedWriter bufferedWriter = new BufferedWriter();
    }
    //Save all the depreciation values
    //Save all the matrix values

}
