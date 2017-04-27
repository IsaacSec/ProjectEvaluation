package classes.control;

import classes.config.CNodeID;
import classes.config.CResource;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by isaac on 4/26/17.
 */
public class ScreeningMatrixControl {
    private static TextField weightingTotalA;
    private Label totalA;
    private Label weightedTotalA;
    private static TextField weightingTotalB;
    private Label totalB;
    private Label weightedTotalB;
    private static TextField weightingTotalC;
    private Label totalC;
    private Label weightedTotalC;

    private Label subtotalWeightingA;
    private Label subtotalWeightingB;
    private Label subtotalWeightingC;
    private Label subtotalGrandTotalWeighting;
    private Label subtotalWeightedValueA;
    private Label subtotalWeightedValueB;
    private Label subtotalWeightedValueC;
    private Label subtotalGrandTotalWeightedValue;

    private static TextField decisionNo;
    private static TextField decisionCanConsider;
    private static TextField decisionYes;

    private Label decision;
    private Button analyse;

    private static Vector<ComboBox> ratingA;
    private static Vector<ComboBox> ratingB;
    private static Vector<ComboBox> ratingC;

    private Vector<Label> weightingA;
    private Vector<Label> weightingB;
    private Vector<Label> weightingC;

    private Vector<Label> weightedValueA;
    private Vector<Label> weightedValueB;
    private Vector<Label> weightedValueC;

    public ScreeningMatrixControl(Scene scene){
        weightingTotalA = (TextField)scene.lookup(CNodeID.TEXTFIELD_WEIGHTING_A);
        weightingTotalB = (TextField)scene.lookup(CNodeID.TEXTFIELD_WEIGHTING_B);
        weightingTotalC = (TextField)scene.lookup(CNodeID.TEXTFIELD_WEIGHTING_C);

        totalA = (Label) scene.lookup(CNodeID.LABEL_TOTAL_A);
        totalB = (Label) scene.lookup(CNodeID.LABEL_TOTAL_B);
        totalC = (Label) scene.lookup(CNodeID.LABEL_TOTAL_C);
        weightedTotalA = (Label) scene.lookup(CNodeID.LABEL_WEIGHTED_TOTAL_A);
        weightedTotalB = (Label) scene.lookup(CNodeID.LABEL_WEIGHTED_TOTAL_B);
        weightedTotalC = (Label) scene.lookup(CNodeID.LABEL_WEIGHTED_TOTAL_C);

        subtotalWeightingA = (Label) scene.lookup(CNodeID.LABEL_SUBTOTAL_W_A);
        subtotalWeightingB = (Label) scene.lookup(CNodeID.LABEL_SUBTOTAL_W_B);
        subtotalWeightingC = (Label) scene.lookup(CNodeID.LABEL_SUBTOTAL_W_C);
        subtotalGrandTotalWeighting = (Label) scene.lookup(CNodeID.LABEL_SUBTOTAL_GRAND_TOTAL_W);

        subtotalWeightedValueA = (Label) scene.lookup(CNodeID.LABEL_SUBTOTAL_WV_A);
        subtotalWeightedValueB = (Label) scene.lookup(CNodeID.LABEL_SUBTOTAL_WV_B);
        subtotalWeightedValueC = (Label) scene.lookup(CNodeID.LABEL_SUBTOTAL_WV_C);
        subtotalGrandTotalWeightedValue = (Label) scene.lookup(CNodeID.LABEL_SUBTOTAL_GRAND_TOTAL_WV);

        decisionNo = (TextField) scene.lookup(CNodeID.TEXTFIELD_DECISION_NO);
        decisionCanConsider = (TextField) scene.lookup(CNodeID.TEXTFIELD_DECISION_CAN_CONSIDER);
        decisionYes = (TextField) scene.lookup(CNodeID.TEXTFIELD_DECISION_YES);
        decision = (Label) scene.lookup(CNodeID.LABEL_DECISION);

        analyse = (Button) scene.lookup(CNodeID.BUTTON_ANALYSE);

        ratingA = new Vector<>();
        weightingA = new Vector<>();
        weightedValueA = new Vector<>();

        int sizeA = CNodeID.COMBO_BOX_RATING_A.length;
        for (int i = 0; i < sizeA; i++) {
            ComboBox rating = (ComboBox) scene.lookup(CNodeID.COMBO_BOX_RATING_A[i]);
            Label weighting = (Label) scene.lookup(CNodeID.LABEL_WEIGHTING_A[i]);
            Label weighted = (Label) scene.lookup(CNodeID.LABEL_WEIGHTED_VALUE_A[i]);
            ratingA.add(rating);
            weightingA.add(weighting);
            weightedValueA.add(weighted);
        }

        ratingB = new Vector<>();
        weightingB = new Vector<>();
        weightedValueB = new Vector<>();

        int sizeB = CNodeID.COMBO_BOX_RATING_B.length;
        for (int i = 0; i < sizeB; i++) {
            ComboBox rating = (ComboBox) scene.lookup(CNodeID.COMBO_BOX_RATING_B[i]);
            Label weighting = (Label) scene.lookup(CNodeID.LABEL_WEIGHTING_B[i]);
            Label weighted = (Label) scene.lookup(CNodeID.LABEL_WEIGHTED_VALUE_B[i]);
            ratingB.add(rating);
            weightingB.add(weighting);
            weightedValueB.add(weighted);
        }

        ratingC = new Vector<>();
        weightingC = new Vector<>();
        weightedValueC = new Vector<>();

        int sizeC = CNodeID.COMBO_BOX_RATING_C.length;
        for (int i = 0; i < sizeC; i++) {
            ComboBox rating = (ComboBox) scene.lookup(CNodeID.COMBO_BOX_RATING_C[i]);
            Label weighting = (Label) scene.lookup(CNodeID.LABEL_WEIGHTING_C[i]);
            Label weighted = (Label) scene.lookup(CNodeID.LABEL_WEIGHTED_VALUE_C[i]);
            ratingC.add(rating);
            weightingC.add(weighting);
            weightedValueC.add(weighted);
        }
    }

    public void initComboBoxes(){
        for (int i = 0; i < ratingA.size(); i++) {
            ratingA.get(i).getItems().addAll("Low","Medium","High");
            int index = i;
            ratingA.get(i).setOnAction(event -> displayWeightValues(index, ratingA, weightingA, weightedValueA));
        }
        for (int i = 0; i < ratingB.size(); i++) {
            ratingB.get(i).getItems().addAll("Low","Medium","High");
            int index = i;
            ratingB.get(i).setOnAction(event -> displayWeightValues(index, ratingB, weightingB, weightedValueB));
        }
        for (int i = 0; i < ratingC.size(); i++) {
            ratingC.get(i).getItems().addAll("Low","Medium","High");
            int index = i;
            ratingC.get(i).setOnAction(event -> displayWeightValues(index, ratingC, weightingC, weightedValueC));
        }
    }

    public void initWeighting(){
        for (int i = 0; i < weightingA.size(); i++) {
            weightingA.get(i).setText(""+CResource.weightingA[i]);
        }
        for (int i = 0; i < weightingB.size(); i++) {
            weightingB.get(i).setText(""+CResource.weightingB[i]);
        }
        for (int i = 0; i < weightingC.size(); i++) {
            weightingC.get(i).setText(""+CResource.weightingC[i]);
        }
    }

    private void displayWeightValues(int index, Vector<ComboBox>ratings, Vector<Label> weightings, Vector<Label> values){
        String rating = (String) ratings.get(index).getValue();
        String weighting = weightings.get(index).getText();
        float value;

        switch (rating){
            case "Low":
                value = 1;
                break;
            case "Medium":
                value = 3;
                break;
            case "High":
                value = 5;
                break;
            default:
                value = 0;
        }

        value = (value * Float.parseFloat(weighting))/5;
        values.get(index).setText(""+value);
    }

    public void initButton(){
        analyse.setOnAction(event -> analyse());
    }

    public void analyse(){
        calculateTotals();
        calculateSubTotals();
        takeDecision();
    }

    private void calculateTotals(){

        if(Integer.parseInt(getWeightingTotalA().getText())+Integer.parseInt(getWeightingTotalB().getText())+Integer.parseInt(getWeightingTotalC().getText())== 100) {
            calculateTotal(weightingA, weightedValueA, totalA, weightedTotalA);
            calculateTotal(weightingB, weightedValueB, totalB, weightedTotalB);
            calculateTotal(weightingC, weightedValueC, totalC, weightedTotalC);
        }else{
            GetData.displayError("Error",null,"The sum of the weights has to be 100");
        }
    }

    private void calculateTotal(Vector<Label> weightings, Vector<Label> values, Label totalW, Label totalWV){
        float totalWeightedValue = 0;
        float totalWeighting = 0;

        int size = weightings.size();
        for (int i = 0; i < size; i++) {
            float weighting = Float.parseFloat(weightings.get(i).getText());
            float value = Float.parseFloat(values.get(i).getText());
            totalWeighting += weighting;
            totalWeightedValue += value;
        }

        totalW.setText(""+totalWeighting);
        totalWV.setText(""+totalWeightedValue);
    }

    private void calculateSubTotals(){
        calculateSubTotal(weightingTotalA, totalA, weightedTotalA, subtotalWeightingA, subtotalWeightedValueA);
        calculateSubTotal(weightingTotalB, totalB, weightedTotalB, subtotalWeightingB, subtotalWeightedValueB);
        calculateSubTotal(weightingTotalC, totalC, weightedTotalC, subtotalWeightingC, subtotalWeightedValueC);

        float wA = Float.parseFloat(weightingTotalA.getText());
        float wB = Float.parseFloat(weightingTotalB.getText());
        float wC = Float.parseFloat(weightingTotalC.getText());
        float gtWeighting = wA + wB + wC;
        float wvA = Float.parseFloat(weightedTotalA.getText());
        float wvB = Float.parseFloat(weightedTotalB.getText());
        float wvC = Float.parseFloat(weightedTotalC.getText());

        float weightedA = wvA * (wA/gtWeighting);
        float weightedB = wvB * (wB/gtWeighting);
        float weightedC = wvC * (wC/gtWeighting);
        float gtWeighted = weightedA + weightedB + weightedC;

        subtotalGrandTotalWeighting.setText(""+gtWeighting);
        subtotalGrandTotalWeightedValue.setText(""+gtWeighted);
    }

    private void calculateSubTotal(TextField partialWeighting, Label partialTotal, Label weightedTotal, Label subtotalWeighting, Label subtotalWeighted){
        float proportion = Float.parseFloat(weightedTotal.getText()) / Float.parseFloat(partialTotal.getText());
        float weighting = Float.parseFloat(partialWeighting.getText());
        float weighted = proportion * weighting;
        subtotalWeighting.setText(""+weighting);
        subtotalWeighted.setText(""+weighted);
    }

    private void takeDecision(){
        float limitNo = Float.parseFloat(decisionNo.getText());
        float limitCanConsider = Float.parseFloat(decisionCanConsider.getText());
        float limitYes = Float.parseFloat(decisionYes.getText());
        float finalWeight = Float.parseFloat(subtotalGrandTotalWeightedValue.getText());
        String decisionResult;

        if (finalWeight > limitNo && finalWeight <= limitCanConsider){
            //NO
            decisionResult = "NO";
        } else if (finalWeight > limitCanConsider && finalWeight <= limitYes){
            //Can Consider
            decisionResult = "CAN CONSIDER";
        } else {
            //Yes
            decisionResult = "YES";
        }

        decision.setText(decisionResult);
    }

    public static TextField getWeightingTotalA() {
        return weightingTotalA;
    }

    public void setWeightingTotalA(TextField weightingTotalA) {
        this.weightingTotalA = weightingTotalA;
    }

    public Label getTotalA() {
        return totalA;
    }

    public void setTotalA(Label totalA) {
        this.totalA = totalA;
    }

    public Label getWeightedTotalA() {
        return weightedTotalA;
    }

    public void setWeightedTotalA(Label weightedTotalA) {
        this.weightedTotalA = weightedTotalA;
    }

    public static TextField getWeightingTotalB() {
        return weightingTotalB;
    }

    public void setWeightingTotalB(TextField weightingTotalB) {
        this.weightingTotalB = weightingTotalB;
    }

    public Label getTotalB() {
        return totalB;
    }

    public void setTotalB(Label totalB) {
        this.totalB = totalB;
    }

    public Label getWeightedTotalB() {
        return weightedTotalB;
    }

    public void setWeightedTotalB(Label weightedTotalB) {
        this.weightedTotalB = weightedTotalB;
    }

    public static TextField getWeightingTotalC() {
        return weightingTotalC;
    }

    public void setWeightingTotalC(TextField weightingTotalC) {
        this.weightingTotalC = weightingTotalC;
    }

    public Label getTotalC() {
        return totalC;
    }

    public void setTotalC(Label totalC) {
        this.totalC = totalC;
    }

    public Label getWeightedTotalC() {
        return weightedTotalC;
    }

    public void setWeightedTotalC(Label weightedTotalC) {
        this.weightedTotalC = weightedTotalC;
    }

    public Label getSubtotalWeightingA() {
        return subtotalWeightingA;
    }

    public void setSubtotalWeightingA(Label subtotalWeightingA) {
        this.subtotalWeightingA = subtotalWeightingA;
    }

    public Label getSubtotalWeightingB() {
        return subtotalWeightingB;
    }

    public void setSubtotalWeightingB(Label subtotalWeightingB) {
        this.subtotalWeightingB = subtotalWeightingB;
    }

    public Label getSubtotalWeightingC() {
        return subtotalWeightingC;
    }

    public void setSubtotalWeightingC(Label subtotalWeightingC) {
        this.subtotalWeightingC = subtotalWeightingC;
    }

    public Label getSubtotalGrandTotalWeighting() {
        return subtotalGrandTotalWeighting;
    }

    public void setSubtotalGrandTotalWeighting(Label subtotalGrandTotalWeighting) {
        this.subtotalGrandTotalWeighting = subtotalGrandTotalWeighting;
    }

    public Label getSubtotalWeightedValueA() {
        return subtotalWeightedValueA;
    }

    public void setSubtotalWeightedValueA(Label subtotalWeightedValueA) {
        this.subtotalWeightedValueA = subtotalWeightedValueA;
    }

    public Label getSubtotalWeightedValueB() {
        return subtotalWeightedValueB;
    }

    public void setSubtotalWeightedValueB(Label subtotalWeightedValueB) {
        this.subtotalWeightedValueB = subtotalWeightedValueB;
    }

    public Label getSubtotalWeightedValueC() {
        return subtotalWeightedValueC;
    }

    public void setSubtotalWeightedValueC(Label subtotalWeightedValueC) {
        this.subtotalWeightedValueC = subtotalWeightedValueC;
    }

    public Label getSubtotalGrandTotalWeightedValue() {
        return subtotalGrandTotalWeightedValue;
    }

    public void setSubtotalGrandTotalWeightedValue(Label subtotalGrandTotalWeightedValue) {
        this.subtotalGrandTotalWeightedValue = subtotalGrandTotalWeightedValue;
    }

    public static TextField getDecisionNo() {
        return decisionNo;
    }

    public void setDecisionNo(TextField decisionNo) {
        this.decisionNo = decisionNo;
    }

    public static TextField getDecisionCanConsider() {
        return decisionCanConsider;
    }

    public void setDecisionCanConsider(TextField decisionCanConsider) {
        this.decisionCanConsider = decisionCanConsider;
    }

    public static TextField getDecisionYes() {
        return decisionYes;
    }

    public void setDecisionYes(TextField decisionYes) {
        this.decisionYes = decisionYes;
    }

    public Label getDecision() {
        return decision;
    }

    public void setDecision(Label decision) {
        this.decision = decision;
    }

    public Button getAnalyse() {
        return analyse;
    }

    public void setAnalyse(Button analyse) {
        this.analyse = analyse;
    }

    public static Vector<ComboBox> getRatingA() {
        return ratingA;
    }

    public void setRatingA(Vector<ComboBox> ratingA) {
        this.ratingA = ratingA;
    }

    public static Vector<ComboBox> getRatingB() {
        return ratingB;
    }

    public void setRatingB(Vector<ComboBox> ratingB) {
        this.ratingB = ratingB;
    }

    public static Vector<ComboBox> getRatingC() {
        return ratingC;
    }

    public void setRatingC(Vector<ComboBox> ratingC) {
        this.ratingC = ratingC;
    }

    public Vector<Label> getWeightingA() {
        return weightingA;
    }

    public void setWeightingA(Vector<Label> weightingA) {
        this.weightingA = weightingA;
    }

    public Vector<Label> getWeightingB() {
        return weightingB;
    }

    public void setWeightingB(Vector<Label> weightingB) {
        this.weightingB = weightingB;
    }

    public Vector<Label> getWeightingC() {
        return weightingC;
    }

    public void setWeightingC(Vector<Label> weightingC) {
        this.weightingC = weightingC;
    }

    public Vector<Label> getWeightedValueA() {
        return weightedValueA;
    }

    public void setWeightedValueA(Vector<Label> weightedValueA) {
        this.weightedValueA = weightedValueA;
    }

    public Vector<Label> getWeightedValueB() {
        return weightedValueB;
    }

    public void setWeightedValueB(Vector<Label> weightedValueB) {
        this.weightedValueB = weightedValueB;
    }

    public Vector<Label> getWeightedValueC() {
        return weightedValueC;
    }

    public void setWeightedValueC(Vector<Label> weightedValueC) {
        this.weightedValueC = weightedValueC;
    }

    public static String matrixString(){
        String value="";
        for(int i = 0; i < getRatingA().size();i++){
            value += getRatingA().get(i).getValue()+" ";
        }
        for(int i = 0; i < getRatingB().size();i++){
            value += getRatingB().get(i).getValue()+" ";
        }for(int i = 0; i < getRatingC().size();i++){
            value += getRatingC().get(i).getValue()+" ";
        }
        value += getWeightingTotalA().getText()+" "+getWeightingTotalB().getText()+" "+ getWeightingTotalC().getText();
        value += " "+getDecisionNo().getText()+" "+getDecisionCanConsider().getText()+" "+getDecisionYes().getText();
        return value;
    }
    public static void setMatrixString(String str){
        StringTokenizer strTok = new StringTokenizer(str," ");
        for(int i = 0; i < getRatingA().size();i++){
            getRatingA().get(i).setValue(strTok.nextToken());
        }
        for(int i = 0; i < getRatingB().size();i++){
            getRatingB().get(i).setValue(strTok.nextToken());
        }for(int i = 0; i < getRatingC().size();i++){
            getRatingC().get(i).setValue(strTok.nextToken());
        }
        getWeightingTotalA().setText(strTok.nextToken());
        getWeightingTotalB().setText(strTok.nextToken());
        getWeightingTotalC().setText(strTok.nextToken());
        getDecisionNo().setText(strTok.nextToken());
        getDecisionCanConsider().setText(strTok.nextToken());
        getDecisionYes().setText(strTok.nextToken());


    }
}
