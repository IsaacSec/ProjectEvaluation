package classes.control;

/**
 * Created by erikm on 18/04/2017.
 */
public class InputPBP {
    private int periods;
    private float principal;
    private float interest;

    public InputPBP(int periods, float principal, float interest) {
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

    public String toString(){
        return this.periods+" "+this.principal+" "+this.interest;
    }
}
