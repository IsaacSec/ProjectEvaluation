package classes.control;

public class InputDEP {
    private int periods;
    private float principal;
    private float tax;
    private float salvage;
    private int periodSalvage;
    private String category;
    private int startingYear;

    public InputDEP(int periods, float principal, float tax, float salvage, int periodSalvage, String category, int startingYear) {
        this.periods = periods;
        this.principal = principal;
        this.tax = tax;
        this.salvage = salvage;
        this.periodSalvage = periodSalvage;
        this.category = category;
        this.startingYear = startingYear;
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

    public int getPeriodSalvage() {
        return periodSalvage;
    }

    public void setPeriodSalvage(int periodSalvage) {
        this.periodSalvage = periodSalvage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(int startingYear) {
        this.startingYear = startingYear;
    }

    public String toString(){
        return this.getPeriods()+" "+this.getPrincipal()+ " "+ this.getTax() + " "+ this.getSalvage() +" " + this.getPeriodSalvage()+" "+this.getCategory()+" "+this.getStartingYear();
    }
}
