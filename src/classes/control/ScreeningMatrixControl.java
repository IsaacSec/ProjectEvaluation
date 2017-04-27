package classes.control;

import classes.config.CNodeID;
import com.sun.jndi.cosnaming.CNCtx;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Vector;

/**
 * Created by isaac on 4/26/17.
 */
public class ScreeningMatrixControl {
    private TextField weightingTotalA;
    private Label totalA;
    private Label weightedTotalA;
    private TextField weightingTotalB;
    private Label totalB;
    private Label weightedTotalB;
    private TextField weightingTotalC;
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

    private TextField decisionNo;
    private TextField decisionCanConsider;
    private TextField decisionYes;

    private Label decision;
    private Button analyse;

    private Vector<ComboBox> ratingA;
    private Vector<ComboBox> ratingB;
    private Vector<ComboBox> ratingC;

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
        }
        for (int i = 0; i < ratingB.size(); i++) {
            ratingB.get(i).getItems().addAll("Low","Medium","High");
        }
        for (int i = 0; i < ratingC.size(); i++) {
            ratingC.get(i).getItems().addAll("Low","Medium","High");
        }
    }

    public TextField getWeightingTotalA() {
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

    public TextField getWeightingTotalB() {
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

    public TextField getWeightingTotalC() {
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

    public TextField getDecisionNo() {
        return decisionNo;
    }

    public void setDecisionNo(TextField decisionNo) {
        this.decisionNo = decisionNo;
    }

    public TextField getDecisionCanConsider() {
        return decisionCanConsider;
    }

    public void setDecisionCanConsider(TextField decisionCanConsider) {
        this.decisionCanConsider = decisionCanConsider;
    }

    public TextField getDecisionYes() {
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

    public Vector<ComboBox> getRatingA() {
        return ratingA;
    }

    public void setRatingA(Vector<ComboBox> ratingA) {
        this.ratingA = ratingA;
    }

    public Vector<ComboBox> getRatingB() {
        return ratingB;
    }

    public void setRatingB(Vector<ComboBox> ratingB) {
        this.ratingB = ratingB;
    }

    public Vector<ComboBox> getRatingC() {
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
}
