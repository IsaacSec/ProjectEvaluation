package classes.tablemodel;

import javafx.beans.property.SimpleStringProperty;

public class RowDEP {
    private final SimpleStringProperty period;
    private final SimpleStringProperty years;
    private final SimpleStringProperty depreciationRate;
    private final SimpleStringProperty annualDepreciation;
    private final SimpleStringProperty accumulativeDepreciation;
    private final SimpleStringProperty valueLedgers;
    private final SimpleStringProperty taxPerYear;


    public RowDEP(String period,
                  String years,
                  String depRate,
                  String annualDep,
                  String accDep,
                  String ledgers,
                  String taxYear){

        this.period = new SimpleStringProperty(period);
        this.years = new SimpleStringProperty(years);
        this.depreciationRate = new SimpleStringProperty(depRate);
        this.annualDepreciation = new SimpleStringProperty(annualDep);
        this.accumulativeDepreciation = new SimpleStringProperty(accDep);
        this.valueLedgers = new SimpleStringProperty(ledgers);
        this.taxPerYear = new SimpleStringProperty(taxYear);
    }

    public String getPeriod() {
        return period.get();
    }

    public SimpleStringProperty periodProperty() {
        return period;
    }

    public void setPeriod(String period) {
        this.period.set(period);
    }

    public String getYears() {
        return years.get();
    }

    public SimpleStringProperty yearsProperty() {
        return years;
    }

    public void setYears(String years) {
        this.years.set(years);
    }

    public String getDepreciationRate() {
        return depreciationRate.get();
    }

    public SimpleStringProperty depreciationRateProperty() {
        return depreciationRate;
    }

    public void setDepreciationRate(String depreciationRate) {
        this.depreciationRate.set(depreciationRate);
    }

    public String getAnnualDepreciation() {
        return annualDepreciation.get();
    }

    public SimpleStringProperty annualDepreciationProperty() {
        return annualDepreciation;
    }

    public void setAnnualDepreciation(String annualDepreciation) {
        this.annualDepreciation.set(annualDepreciation);
    }

    public String getAccumulativeDepreciation() {
        return accumulativeDepreciation.get();
    }

    public SimpleStringProperty accumulativeDepreciationProperty() {
        return accumulativeDepreciation;
    }

    public void setAccumulativeDepreciation(String accumulativeDepreciation) {
        this.accumulativeDepreciation.set(accumulativeDepreciation);
    }

    public String getValueLedgers() {
        return valueLedgers.get();
    }

    public SimpleStringProperty valueLedgersProperty() {
        return valueLedgers;
    }

    public void setValueLedgers(String valueLedgers) {
        this.valueLedgers.set(valueLedgers);
    }

    public String getTaxPerYear() {
        return taxPerYear.get();
    }

    public SimpleStringProperty taxPerYearProperty() {
        return taxPerYear;
    }

    public void setTaxPerYear(String taxPerYear) {
        this.taxPerYear.set(taxPerYear);
    }

    public String getAllDataInRow(){
        return period.getValue()+" "+years.getValue()+" "+depreciationRate.getValue()+" "+annualDepreciation.getValue()
                +" "+accumulativeDepreciation.getValue()+" "+valueLedgers.getValue()+" "+taxPerYear.getValue();
    }
}
