package classes.screening;

import java.util.ArrayList;

/**
 * Created by isaac on 4/22/17.
 */
public class DEPResult {
    private ArrayList<Float> depreciationRate;
    private ArrayList<Float> annualDepreciation;
    private ArrayList<Float> accumulatedDepreciation;
    private ArrayList<Float> ledgerValues;
    private ArrayList<Float> taxPerYear;

    public DEPResult(ArrayList<Float> depreciationRate, ArrayList<Float> annualDepreciation, ArrayList<Float> accumulatedDepreciation,
                     ArrayList<Float> ledgerValues, ArrayList<Float> taxPerYear) {
        this.depreciationRate = depreciationRate;
        this.annualDepreciation = annualDepreciation;
        this.accumulatedDepreciation = accumulatedDepreciation;
        this.ledgerValues = ledgerValues;
        this.taxPerYear = taxPerYear;
    }

    public ArrayList<Float> getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(ArrayList<Float> depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public ArrayList<Float> getAnnualDepreciation() {
        return annualDepreciation;
    }

    public void setAnnualDepreciation(ArrayList<Float> annualDepreciation) {
        this.annualDepreciation = annualDepreciation;
    }

    public ArrayList<Float> getAccumulatedDepreciation() {
        return accumulatedDepreciation;
    }

    public void setAccumulatedDepreciation(ArrayList<Float> accumulatedDepreciation) {
        this.accumulatedDepreciation = accumulatedDepreciation;
    }

    public ArrayList<Float> getLedgerValues() {
        return ledgerValues;
    }

    public void setLedgerValues(ArrayList<Float> ledgerValues) {
        this.ledgerValues = ledgerValues;
    }

    public ArrayList<Float> getTaxPerYear() {
        return taxPerYear;
    }

    public void setTaxPerYear(ArrayList<Float> taxPerYear) {
        this.taxPerYear = taxPerYear;
    }
}
