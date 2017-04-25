package classes.control;

import javafx.scene.Scene;

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
        String line;
        try {
            FileReader fileReader = new FileReader("prueba.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            StringTokenizer str = new StringTokenizer(bf.readLine()," ");
            SetData.setPayBackPeriod(scene, str.nextToken(), str.nextToken(), str.nextToken());
            SetData.setPBPTableValues(scene,toArray(bf.readLine()),toArray(bf.readLine()));
            StringTokenizer str2 = new StringTokenizer(bf.readLine()," ");
            SetData.setNetPresentValue(scene, str2.nextToken(),str2.nextToken(),str2.nextToken(),str2.nextToken(),str2.nextToken(),str2.nextToken());
            SetData.setNPVTableValues(scene, toArray(bf.readLine()), toArray(bf.readLine()));
            StringTokenizer str3 = new StringTokenizer(bf.readLine()," ");
            SetData.setDepreciation(scene, str3.nextToken(),str3.nextToken(),str3.nextToken(),str3.nextToken(),str3.nextToken(),str3.nextToken()+" "+str3.nextToken(),str3.nextToken());
            ButtonAction.calculateNPV(scene);
            ButtonAction.calculatePBP(scene);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
