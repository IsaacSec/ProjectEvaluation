package classes.screening;

/**
 * Created by erikm on 18/04/2017.
 */
public class PayBackPeriod {
    private int periods;
    private int principal;
    private int interest;

    public PayBackPeriod(int periods, int principal, int interest) {
        this.periods = periods;
        this.principal = principal;
        this.interest = interest;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public String toString(){
        return this.periods+" "+this.principal+" "+this.interest;
    }
}
