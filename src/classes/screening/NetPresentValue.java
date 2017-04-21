package classes.screening;

/**
 * Created by erikm on 18/04/2017.
 */
public class NetPresentValue {
    private int periods;
    private float principal;
    private float interest;
    private float tax;
    private float salvage;
    private int salvagePeriod;

    public NetPresentValue(int periods, float principal, float interest, float tax, float salvage, int salvagePeriod) {
        this.periods = periods;
        this.principal = principal;
        this.interest = interest;
        this.tax = tax;
        this.salvage = salvage;
        this.salvagePeriod = salvagePeriod;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public float getPrincipal() {
        return principal;
    }

    public void setPrincipal(float principal) {
        this.principal = principal;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getSalvage() {
        return salvage;
    }

    public void setSalvage(float salvage) {
        this.salvage = salvage;
    }

    public int getSalvagePeriod() {
        return salvagePeriod;
    }

    public void setSalvagePeriod(int salvagePeriod) {
        this.salvagePeriod = salvagePeriod;
    }

    public String toString (){
        return this.principal+" "+this.getPeriods()+" "+this.interest+" "+this.tax+" "+this.salvage+" "+this.salvagePeriod;
    }
}